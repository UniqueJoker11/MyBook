package colin.profile.opensource.system.realm;

import colin.profile.opensource.system.core.pojo.BkUserEntity;
import colin.profile.opensource.system.service.BkUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthenticatingRealm {

@Autowired
private BkUserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       String username=authenticationToken.getPrincipal().toString();//用户名
        String password=authenticationToken.getCredentials().toString();//密码
        BkUserEntity bkUserEntity=userService.queryUserInfoByUserName(username);

        if (bkUserEntity==null){
            throw new UnknownAccountException("用户不存在！");
        }else{
            String pw_salt=bkUserEntity.getUser_pw_salt();
            if(bkUserEntity.getUser_password().equals(password)){
                return new SimpleAuthenticationInfo(username,password,this.getName());
            }else{
                throw new IncorrectCredentialsException("用户名或密码错误！");
            }
        }
    }
}
