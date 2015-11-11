package colin.profile.opensource.system.core.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import colin.profile.opensource.system.core.pojo.BkUserEntity;

@Repository
public class BkUserDao extends BkBaseDao {

    private static final String SQLFILE="bkuser";
	/**
	 * 
	 * 方法描述：保存用户对象 注意事项：
	 * 
	 * @param userEntity
	 * @Exception 异常对象
	 */
	public void saveBkUserInfo(BkUserEntity userEntity) {
		super.initSqlManager().insert(BkUserEntity.class, userEntity);
	}

	/**
	 * 
	 * 方法描述：获取所有的用户信息   
	 * 注意事项：    
	 * @return 
	 * @Exception 异常对象
	 */
	public List<BkUserEntity> fetchAllBkUserInfo() {
		return super.initSqlManager().all(BkUserEntity.class);
	}
	/**
	 * 
	 * 方法描述：根据userId更新信息   
	 * 注意事项：    
	 * @param userEntity 
	 * @Exception 异常对象
	 */
	public void updateUserInfo(BkUserEntity userEntity){
		super.initSqlManager().updateById(userEntity);
	}

    /**
     * 根据用户名来查询用户对象
     * @param params
     * @return
     */
    public BkUserEntity fetchBkUserInfoByUsername(Map<String,Object> params){
        return super.initSqlManager().selectSingle(SQLFILE+"selectByUsername",params,BkUserEntity.class);
    }
}
