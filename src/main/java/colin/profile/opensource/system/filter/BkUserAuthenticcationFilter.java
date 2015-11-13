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
            BkUserEntity userEntity = bkUserService.queryUserInfoByUserName(token.getPrincipal().toString());
            if (userEntity == null) {
                return this.onLoginFailure(token, new UnknownAccountException("用户名不存在"), request, response);
            } else if (!userEntity.getUserPassword().equals(String.valueOf((char[]) token.getCredentials()))) {
                return this.onLoginFailure(token, new IncorrectCredentialsException("用户名密码错误"), request, response);
            } else {
                Subject e = this.getSubject(request, response);
                try {
                    e.login(token);
                    return this.onLoginSuccess(token, e, request, response);
                } catch (UnknownAccountException e1) {
                    //账户不存在
                    return this.onLoginFailure(token, e1, request, response);
                } catch (IncorrectCredentialsException e2) {
                    //密码错误
                    return this.onLoginFailure(token, e2, request, response);
                } catch (AuthenticationException e3) {
                    //用户验证错误
                    return this.onLoginFailure(token, e3, request, response);
                }
            }
        }
    }
}
