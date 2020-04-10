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
import com.github.tools.annotations.mysql.PrivateKey;
//实体类必须要有JavaBean注解
@JavaBean
public class Pm_role {
	//实体类必须要有JavaBean注解
	@PrivateKey//私钥？
	@AutoIncrement//数据库id自增长？
	
	@FieldDescriber("角色ID")
//	每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
	private int role_id;
	

	@Required(false)
	@Size(max = 10)
	@FieldDescriber("角色名称")
	private String role_name;

	public int getRole_id() {
		return role_id;
	}


	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
}

