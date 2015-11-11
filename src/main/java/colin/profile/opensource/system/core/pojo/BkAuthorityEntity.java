package colin.profile.opensource.system.core.pojo;

import org.beetl.sql.core.annotatoin.AssignID;
import org.beetl.sql.core.annotatoin.Table;


@Table(name="bk_authority")
public class BkAuthorityEntity{

/**
* 权限id
*/

private String authority_id;

/**
* 权限父级id
*/

private String parent_authority_id;

/**
* 创建日期
*/

private String createdate;

/**
* 权限描述
*/

private String authority_description;

/**
* 权限名称
*/

private String authority_name;
public void setAuthority_id(String authority_id){
this.authority_id=authority_id;
}
@AssignID
public String getAuthority_id(){
return this.authority_id;
}
public void setParent_authority_id(String parent_authority_id){
this.parent_authority_id=parent_authority_id;
}
public String getParent_authority_id(){
return this.parent_authority_id;
}
public void setCreatedate(String createdate){
this.createdate=createdate;
}
public String getCreatedate(){
return this.createdate;
}
public void setAuthority_description(String authority_description){
this.authority_description=authority_description;
}
public String getAuthority_description(){
return this.authority_description;
}
public void setAuthority_name(String authority_name){
this.authority_name=authority_name;
}
public String getAuthority_name(){
return this.authority_name;
}
}