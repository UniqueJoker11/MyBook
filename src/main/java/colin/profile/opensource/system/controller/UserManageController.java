package colin.profile.opensource.system.controller;

import colin.profile.opensource.system.bean.ResultCommonBean;
import colin.profile.opensource.system.bean.UserBean;
import colin.profile.opensource.system.core.pojo.BkUserEntity;
import colin.profile.opensource.system.service.BkUserService;
import colin.profile.opensource.system.tools.extend.UserPasswordTools;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by DELL on 2015/11/12.
 */
@Controller
public class UserManageController {
    private final Logger logger = Logger.getLogger(UserManageController.class.getName());
    @Autowired
    private BkUserService bkUserService;

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
                e.printStackTrace();
                return "login";
            }
            return "index";
        }
    }

    /**
     * 注册用户信息
     *
     * @param userBean
     * @param bindingResult
     * @return
     */
    public Object registerUserInfo(@Valid UserBean userBean, BindingResult bindingResult) {
        ResultCommonBean commonBean = new ResultCommonBean();
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMsg.append(fieldError.getDefaultMessage()).append(",");
            }
            commonBean.setInfoMsg(errorMsg.substring(0, errorMsg.lastIndexOf(",")));
            commonBean.setSuccess(false);
        } else {
            BkUserEntity bkUserEntity = new BkUserEntity();
            bkUserEntity.setUserName(userBean.getUsername());
            bkUserEntity.setUserPassword(userBean.getPassword());
            this.bkUserService.insertUserInfo(UserPasswordTools.encryptUserEntity(bkUserEntity));
            commonBean.setSuccess(true);
        }
        return commonBean;
    }
}
