package colin.profile.opensource.system.core.pojo;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;


@Table(name="bk_role")
public class BkRoleEntity{

/**
* 角色id
*/

private String role_id;

/**
* 角色父级id
*/

private String parent_role_id;

/**
* 创建日期
*/

private String createdate;

/**
* 角色描述
*/

private String role_description;

/**
* 角色名称
*/

private String role_name;
public void setRole_id(String role_id){
this.role_id=role_id;
}
@AssignID
public String getRole_id(){
return this.role_id;
}
public void setParent_role_id(String parent_role_id){
this.parent_role_id=parent_role_id;
}
public String getParent_role_id(){
return this.parent_role_id;
}
public void setCreatedate(String createdate){
this.createdate=createdate;
}
public String getCreatedate(){
return this.createdate;
}
public void setRole_description(String role_description){
this.role_description=role_description;
}
public String getRole_description(){
return this.role_description;
}
public void setRole_name(String role_name){
this.role_name=role_name;
}
public String getRole_name(){
return this.role_name;
}
}