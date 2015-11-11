package colin.profile.opensource.system.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class UserBean {
	@NotEmpty(message = "手机号不能为空！")
	@Pattern(regexp = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$", message = "手机格式不正确")
	private String username;
	@NotEmpty(message = "密码不能为空！")
	@Size(max = 15, min = 6, message = "密码长度在6~10位之间")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
