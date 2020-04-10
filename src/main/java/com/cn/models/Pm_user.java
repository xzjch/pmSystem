package com.cn.models;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
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
	
	@FieldDescriber("关联的角色ID")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
	@Required(false)
	private int role_id;
	
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

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
