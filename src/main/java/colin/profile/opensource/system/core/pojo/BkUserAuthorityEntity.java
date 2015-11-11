package colin.profile.opensource.system.core.pojo;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;


@Table(name="bk_user_authority")
public class BkUserAuthorityEntity{

/**
* 用户权限id
*/

private String role_authority_id;

/**
* 角色id
*/

private String role_id;

/**
* 权限id
*/

private String authority_id;

/**
* 权限类型
*/

private String authority_type;

/**
* 允许访问
*/

private int is_access;

/**
* 是否授权
*/

private int is_authorization;
public void setRole_authority_id(String role_authority_id){
this.role_authority_id=role_authority_id;
}
@AssignID
public String getRole_authority_id(){
return this.role_authority_id;
}
public void setRole_id(String role_id){
this.role_id=role_id;
}
public String getRole_id(){
return this.role_id;
}
public void setAuthority_id(String authority_id){
this.authority_id=authority_id;
}
public String getAuthority_id(){
return this.authority_id;
}
public void setAuthority_type(String authority_type){
this.authority_type=authority_type;
}
public String getAuthority_type(){
return this.authority_type;
}
public void setIs_access(int is_access){
this.is_access=is_access;
}
public int getIs_access(){
return this.is_access;
}
public void setIs_authorization(int is_authorization){
this.is_authorization=is_authorization;
}
public int getIs_authorization(){
return this.is_authorization;
}
}