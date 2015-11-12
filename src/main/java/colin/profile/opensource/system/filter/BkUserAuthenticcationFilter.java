package colin.profile.opensource.system.filter;

import colin.profile.opensource.system.core.pojo.BkUserEntity;
import colin.profile.opensource.system.service.BkUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BkUserAuthenticcationFilter extends FormAuthenticationFilter {

    @Autowired
    private BkUserService bkUserService;

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        AuthenticationToken token = this.createToken(request, response);
        if (token == null) {
            String e1 = "获取不到用户名和密码信息";
            throw new IllegalStateException(e1);
        } else {
            try {
                BkUserEntity userEntity = bkUserService.queryUserInfoByUserName(this.getUsernameParam());
                if (userEntity == null) {
                    return this.onLoginFailure(token, new UnknownAccountException("用户名不存在"), request, response);
                } else if (!userEntity.getUserPassword().equals(this.getPasswordParam())) {
                    return this.onLoginFailure(token, new IncorrectCredentialsException("用户名密码错误"), request, response);
                } else {
                    Subject e = this.getSubject(request, response);
                    e.login(token);
                    return this.onLoginSuccess(token, e, request, response);
                }
            } catch (AuthenticationException var5) {
                return this.onLoginFailure(token, var5, request, response);
            }
        }
    }
}
