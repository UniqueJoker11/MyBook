package colin.profile.opensource.system.core.pojo;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

@Table(name = "bk_user")
public class BkUserEntity {

	/**
	 * 用户id
	 */

	private String user_id;

	/**
	 * 用户名
	 */

	private String user_name;

	/**
	 * 用户头像
	 */

	private String user_head;

	/**
	 * 用户密码
	 */

	private String user_password;

	/**
	 * 用户加密盐
	 */

	private String user_pw_salt;

	/**
	 * 用户别称
	 */

	private String user_callname;

	/**
	 * 用户email
	 */

	private String user_email;

	/**
	 * 用户手机
	 */

	private String user_phone;

	/**
	 * 用户创建时间
	 */

	private String user_createtime;

	/**
	 * 用户登录时间
	 */

	private String user_logintime;

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@AssignID
	public String getUser_id() {
		return this.user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name() {
		return this.user_name;
	}

	public void setUser_head(String user_head) {
		this.user_head = user_head;
	}

	public String getUser_head() {
		return this.user_head;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_password() {
		return this.user_password;
	}

	public void setUser_pw_salt(String user_pw_salt) {
		this.user_pw_salt = user_pw_salt;
	}

	public String getUser_pw_salt() {
		return this.user_pw_salt;
	}

	public void setUser_callname(String user_callname) {
		this.user_callname = user_callname;
	}

	public String getUser_callname() {
		return this.user_callname;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_email() {
		return this.user_email;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_phone() {
		return this.user_phone;
	}

	public void setUser_createtime(String user_createtime) {
		this.user_createtime = user_createtime;
	}

	public String getUser_createtime() {
		return this.user_createtime;
	}

	public void setUser_logintime(String user_logintime) {
		this.user_logintime = user_logintime;
	}

	public String getUser_logintime() {
		return this.user_logintime;
	}
}