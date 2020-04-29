package com.cn.models;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.NotNull;
import com.github.tools.annotations.mysql.PrivateKey;

/*必须有JavaBean的注解
 * 每一个成员变量都必须有FieldDescriber注解，用于生成文档
 * 每一个成员变量至少有一个注解（com.github.tools.annotations.mysql目录下），用于生成SQL中的元素
 * 每一个成员变量可以有长度约束，当前仅仅支持整型和字符串类型（javax.validation.constraints目录下），用于生成SQL语句中的长度约束
 * 每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
 * */

//实体类必须要有JavaBean注解
@JavaBean
public class Pm_user {

	@PrivateKey//私钥？
	@AutoIncrement//数据库id自增长？
	
	@FieldDescriber("用户的ID")
	private int user_id;
	
	@NotNull
	@Size(max = 10, message = "{Pm_user.user_name.length.illegal}") 
	@FieldDescriber("用户名")
	private String user_name;
	
	@NotNull
	@Size(max = 10, message = "{Pm_user.user_realname.length.illegal}") 
	@FieldDescriber("用户真实姓名")
	private String user_realname;
	
	@NotNull
	@Size(min=8,max =16 , message = "{Pm_user.user_password.length.illegal}") 
	@FieldDescriber("用户密码")
	private String user_password;
	
	@NotNull
	@Size(max = 11, message = "{Pm_user.user_phone.length.illegal}") 
	@FieldDescriber("用户手机号")
	private String user_phone;
	
	@NotNull
	@Size(max = 100, message = "{Pm_user.user_email.length.illegal}") 
	@FieldDescriber("用户邮箱")
	private String user_email;
	
	@Size(max = 10) 
	@DefaultValue("0")
	@FieldDescriber("用户状态")
	private String user_state;
	
	@FieldDescriber("部门ID")
	private int department_id;
	
	@FieldDescriber("部门下员工的职位")
	@Size(max = 10)
	private String department_user_role;//（0是无部门人员,1是部门主管,2是部门成员）
	
	@FieldDescriber("关联的角色ID")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
	@Required(false)
	private int role_id;
	
	@NotNull
	@Size(max = 100, message = "{Pm_user.role_name.length.illegal}") 
	@FieldDescriber("角色名称")
	private String role_name;
	
	@NotNull
	@Size(max = 100, message = "{Pm_user.department_name.length.illegal}") 
	@FieldDescriber("部门名称")
	private String department_name;
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	public String getUser_state() {
		return user_state;
	}

	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_user_role() {
		return department_user_role;
	}

	public void setDepartment_user_role(String department_user_role) {
		this.department_user_role = department_user_role;
	}
	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	
}
