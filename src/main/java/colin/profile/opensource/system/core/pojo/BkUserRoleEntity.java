package colin.profile.opensource.system.core.pojo;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;


@Table(name="bk_user_role")
public class BkUserRoleEntity{

/**
* 用户角色id
*/

private String user_role_id;

/**
* 角色id
*/

private String role_id;

/**
* 用户id
*/

private String user_id;
public void setUser_role_id(String user_role_id){
this.user_role_id=user_role_id;
}
@AssignID
public String getUser_role_id(){
return this.user_role_id;
}
public void setRole_id(String role_id){
this.role_id=role_id;
}
public String getRole_id(){
return this.role_id;
}
public void setUser_id(String user_id){
this.user_id=user_id;
}
public String getUser_id(){
return this.user_id;
}
}