package colin.profile.opensource.system.controller;

import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import colin.profile.opensource.system.bean.UserBean;

import java.util.logging.Logger;

@Controller
@Scope("request")
@RequestMapping("/pay")
public class TemplateManageController {

    private final Logger logger = Logger.getLogger(TemplateManageController.class.getName());

    /**
     * 方法描述：显示登陆页面 注意事项：
     *
     * @return
     * @Exception 异常对象
     */
    @RequestMapping(value = "login.html", method = RequestMethod.GET)
    public String showLoginHtml() {
        return "login";
    }

    /**
     * 方法描述：验证用户登录 注意事项：
     *
     * @return
     * @Exception 异常对象
     */
    @RequestMapping(value = "user_login.action", method = RequestMethod.POST)
    public String validateUserLogin(HttpServletRequest request,
                                    @Valid UserBean userBean, BindingResult errorResult) {
        if (errorResult.hasErrors()) {
            request.setAttribute("hasError", true);
            return "login";
        } else {
            //验证用户是否在数据库中存在
            org.apache.shiro.subject.Subject userSubject = SecurityUtils.getSubject();
            try {
                userSubject.login(new UsernamePasswordToken(userBean.getUsername(), userBean.getPassword(), true));
            } catch (UnknownAccountException e) {
                logger.info("不存在的用户");
                return "login";
            } catch (IncorrectCredentialsException e) {
                logger.info("用户名或密码错误");
                return "login";
            } catch (AuthenticationException e) {
                logger.info("用户身份信息不正确");
                return "login";
            }
            return "index";
        }
    }

    @RequestMapping(value = "index.html", method = RequestMethod.GET)
    public String showIndexPage() {
        //TODO 需要添加用户是否登录的校验
        return "index";
    }
}
