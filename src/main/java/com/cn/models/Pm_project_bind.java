package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.PrivateKey;

public class Pm_project_bind {
	
	@PrivateKey
	@AutoIncrement
	  
	@FieldDescriber("项目约束和假设的ID")
	private int project_bind_id;
	
	  
	@FieldDescriber("关联项目的ID")
	private int project_id;
	
	@Size(max = 200)  
	@FieldDescriber("项目约束")
	@Required(true)
	private String project_bd;
	
	@Size(max = 200) 
	@FieldDescriber("项目假设")
	@Required(true)
	private String project_sup;

	public int getProject_bind_id() {
		return project_bind_id;
	}

	public void setProject_bind_id(int project_bind_id) {
		this.project_bind_id = project_bind_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_bd() {
		return project_bd;
	}

	public void setProject_bd(String project_bd) {
		this.project_bd = project_bd;
	}

	public String getProject_sup() {
		return project_sup;
	}

	public void setProject_sup(String project_sup) {
		this.project_sup = project_sup;
	}
	
	

}
