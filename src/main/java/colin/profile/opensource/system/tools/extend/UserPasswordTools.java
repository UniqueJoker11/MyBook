package colin.profile.opensource.system.tools.extend;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;

import colin.profile.opensource.system.core.pojo.BkUserEntity;

@Component
public class UserPasswordTools {

	private String algorithmName = "md5";// 加密方式
	private final int hashIterations = 2;// 加密迭代次数

	/**
	 * 
	 * 方法描述：对新注册的用户密码加密处理   
	 * 注意事项：    
	 * @param userEntity
	 * @return 
	 * @Exception 异常对象
	 */
	public BkUserEntity encryptUserEntity(BkUserEntity userEntity) {
		RandomNumberGenerator numberGenerator = new SecureRandomNumberGenerator();
		String key_salt = numberGenerator.nextBytes().toHex();
		userEntity.setUser_pw_salt(key_salt);
		// 设定新密码
		userEntity.setUser_password(new SimpleHash(algorithmName, userEntity
				.getUser_password(), ByteSource.Util.bytes(userEntity
				.getUser_pw_salt()), hashIterations).toHex());
		return userEntity;
	}
}
