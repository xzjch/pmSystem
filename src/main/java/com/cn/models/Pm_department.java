/**

 * @author GMZ

 * @since 2020.4.8

 */
package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.NotNull;
import com.github.tools.annotations.mysql.PrivateKey;

@JavaBean
public class Pm_department {
	@PrivateKey
	@AutoIncrement
	@FieldDescriber("部门ID")
	private int department_id;
	
	@NotNull
	@Size(max = 10, message = "部门名称输入长度大小不超过10") 
	@FieldDescriber("部门名称")
	private String department_name;
	

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

}
