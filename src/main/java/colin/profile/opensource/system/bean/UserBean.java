package colin.profile.opensource.system.bean;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class UserBean {
	@NotEmpty(message = "用户名不能为空！")
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
