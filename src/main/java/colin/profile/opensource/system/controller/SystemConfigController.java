package colin.profile.opensource.system.controller;

import colin.profile.opensource.system.common.CommonConstants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("request")
@RequestMapping(CommonConstants.REQUEST_MANAGER_PREFIEX)
public class SystemConfigController {

	@RequestMapping(value="/unauthorize.html",method=RequestMethod.GET)
	public String showUnAuthorizeHtml(){
		return "/manage/errorunauthorize";
	}
}
