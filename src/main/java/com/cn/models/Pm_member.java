package com.cn.models;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.PrivateKey;
//实体类必须要有JavaBean注解
@JavaBean
public class Pm_member {
	//实体类必须要有JavaBean注解
	@PrivateKey//私钥？
	@AutoIncrement//数据库id自增长？
	
	@FieldDescriber("成员ID")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
	private int member_id;
	
	@FieldDescriber("关联的项目ID")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
//	@Required(false)
	private int project_id;
	
//	@Required(false)
	@FieldDescriber("关联角色名id")
	private int role_id;
	
//	@FieldDescriber("角色名")
//	private String role_name;
	
	@FieldDescriber("关联的用户ID")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
//	@Required(false)
	private int user_id;
	
//	@FieldDescriber("用户名")
//	private String user_name;
	

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	/* 新添加的字段 */
//	public String getRole_name() {
//		return role_name;
//	}
//
//	public void setRole_name(String role_name) {
//		this.role_name = role_name;
//	}
//
//	public String getUser_name() {
//		return user_name;
//	}
//
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
	
}

