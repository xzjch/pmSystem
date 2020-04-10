/*卢湛兴*/

package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.NotNull;
import com.github.tools.annotations.mysql.PrivateKey;

@JavaBean
public class Pm_flow {
	@PrivateKey
	@AutoIncrement
	@FieldDescriber("流转ID")
	private int flow_id;
	
	@NotNull
	@Size(min = 6, max = 20, message = "流转规则名称在6-20个字符之间") 
	@FieldDescriber("流转规则名称")
	@Required(false)
	private String flow_rule;
	
	@NotNull
	@FieldDescriber("泳道列表")
	@DefaultValue("0")
	private int lane_name1;
	
	@NotNull
	@FieldDescriber("流转条件")
	@DefaultValue("0")
	private int flow_condition;
	
	@NotNull
	@FieldDescriber("流转到的泳道列表")
	@DefaultValue("0")
	private int lane_name2;
	
	@NotNull
	@FieldDescriber("流转后的状态")
	@DefaultValue("0")
	private int lane_state;
	
	@NotNull
	@FieldDescriber("所属项目ID")
	private int project_id;

	public int getFlow_id() {
		return flow_id;
	}

	public void setFlow_id(int flow_id) {
		this.flow_id = flow_id;
	}

	public String getFlow_rule() {
		return flow_rule;
	}

	public void setFlow_rule(String flow_rule) {
		this.flow_rule = flow_rule;
	}

	public int getLane_name1() {
		return lane_name1;
	}

	public void setLane_name1(int lane_name1) {
		this.lane_name1 = lane_name1;
	}

	public int getFlow_condition() {
		return flow_condition;
	}

	public void setFlow_condition(int lflow_condition) {
		this.flow_condition = lflow_condition;
	}

	public int getLane_name2() {
		return lane_name2;
	}

	public void setLane_name2(int lane_name2) {
		this.lane_name2 = lane_name2;
	}

	public int getLane_state() {
		return lane_state;
	}

	public void setLane_state(int lane_state) {
		this.lane_state = lane_state;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
}
