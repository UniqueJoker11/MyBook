package colin.profile.opensource.system.controller;

import colin.profile.opensource.system.common.CommonConstants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@Scope("request")
@RequestMapping(CommonConstants.REQUEST_MANAGER_PREFIEX)
public class PageManageController {

    private final Logger logger = Logger.getLogger(PageManageController.class.getName());

    /**
     * 方法描述：显示登陆页面 注意事项：
     *
     * @return
     * @Exception 异常对象
     */
    @RequestMapping(value = "signin.html", method = RequestMethod.GET)
    public String showLoginHtml() {
        return "/manage/signin";
    }



    @RequestMapping(value = "manage.html", method = RequestMethod.GET)
    public String showIndexPage() {
        //TODO 需要添加用户是否登录的校验
        return "/manage/manage";
    }
}
