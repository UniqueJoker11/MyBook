package colin.profile.opensource.system.core.pojo;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;

@Table(name = "bk_user")
public class BkUserEntity {

	/**
	 * 用户id
	 */

	private String userId;

	/**
	 * 用户名
	 */

	private String userName;

	/**
	 * 用户头像
	 */

	private String userHead;

	/**
	 * 用户密码
	 */

	private String userPassword;

	/**
	 * 用户加密盐
	 */

	private String userPwSalt;

	/**
	 * 用户别称
	 */

	private String userCallname;

	/**
	 * 用户email
	 */

	private String userEmail;

	/**
	 * 用户手机
	 */

	private String userPhone;

	/**
	 * 用户创建时间
	 */

	private String userCreatetime;

	/**
	 * 用户登录时间
	 */

	private String userLogintime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPwSalt() {
        return userPwSalt;
    }

    public void setUserPwSalt(String userPwSalt) {
        this.userPwSalt = userPwSalt;
    }

    public String getUserCallname() {
        return userCallname;
    }

    public void setUserCallname(String userCallname) {
        this.userCallname = userCallname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(String userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public String getUserLogintime() {
        return userLogintime;
    }

    public void setUserLogintime(String userLogintime) {
        this.userLogintime = userLogintime;
    }
}