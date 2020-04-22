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
	@Size(min = 1, max = 10, message = "流转规则名称在1-10个字符之间") 
	@FieldDescriber("流转规则名称")
	@Required(false)
	private String flow_rule;
	
	
	@Size(max = 20)
	@FieldDescriber("泳道列表")
	private String lane_name1;
	
	
	@Size(max = 20)
	@FieldDescriber("流转条件")
	private String flow_condition;
	

	@Size(max = 20)
	@FieldDescriber("流转到的泳道列表")
	private String lane_name2;
	
	@Size(max = 20)
	@FieldDescriber("流转后的状态")
	private String lane_state;
	
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

	public String getLane_name1() {
		return lane_name1;
	}

	public void setLane_name1(String lane_name1) {
		this.lane_name1 = lane_name1;
	}

	public String getFlow_condition() {
		return flow_condition;
	}

	public void setFlow_condition(String lflow_condition) {
		this.flow_condition = lflow_condition;
	}

	public String getLane_name2() {
		return lane_name2;
	}

	public void setLane_name2(String lane_name2) {
		this.lane_name2 = lane_name2;
	}

	public String getLane_state() {
		return lane_state;
	}

	public void setLane_state(String lane_state) {
		this.lane_state = lane_state;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
}
