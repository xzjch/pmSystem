package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.PrivateKey;

public class Pm_project {
	@PrivateKey
	@AutoIncrement

	@FieldDescriber("项目ID")
	private int project_id;

	@DefaultValue("baseball")
	@Size(max = 200)

	@FieldDescriber("项目简介")
	@Required(true)
	private String project_des;

	@DefaultValue("baseball")
	@Size(max = 200)

	@FieldDescriber("项目名称")
	@Required(true)
	private String project_name;

	@DefaultValue("baseball")
	@Size(max = 200)

	@FieldDescriber("项目类型")
	@Required(true)
	private String project_type;

	@DefaultValue("baseball")
	@Size(max = 200)

	@FieldDescriber("项目创建人")
	@Required(true)
	private String project_men;

	@DefaultValue("baseball")
	@Size(max = 200)

	@FieldDescriber("项目迭代周期")
	@Required(true)
	private String project_spr;

	@DefaultValue("baseball")
	@Size(max = 200)

	@FieldDescriber("项目创建时间")
	@Required(true)
	private String project_time;

	@DefaultValue("0")
	@Size(max = 200)

	@FieldDescriber("项目状态")
	@Required(true)
	private String project_state;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProject_des() {
		return project_des;
	}

	public void setProject_des(String project_des) {
		this.project_des = project_des;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getProject_type() {
		return project_type;
	}

	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}

	public String getProject_men() {
		return project_men;
	}

	public void setProject_men(String project_men) {
		this.project_men = project_men;
	}

	public String getProject_spr() {
		return project_spr;
	}

	public void setProject_spr(String project_spr) {
		this.project_spr = project_spr;
	}

	public String getProject_time() {
		return project_time;
	}

	public void setProject_time(String project_time) {
		this.project_time = project_time;
	}

	public String getProject_state() {
		return project_state;
	}

	public void setProject_state(String project_state) {
		this.project_state = project_state;
	}




}
