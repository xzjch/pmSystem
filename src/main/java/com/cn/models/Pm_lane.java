/*卢湛兴*/

package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.NotNull;
import com.github.tools.annotations.mysql.PrivateKey;

public class Pm_lane {
	@PrivateKey
	@FieldDescriber("泳道ID")
	private int lane_id;
	
	@NotNull
	@Size(min = 2, max = 20, message = "泳道列表名称在2-20个字符之间") 
	@FieldDescriber("泳道列表流转规则名称")
	@Required(false)
	private String lane_name;

	public int getLane_id() {
		return lane_id;
	}

	public void setLane_id(int lane_id) {
		this.lane_id = lane_id;
	}

	public String getLane_name() {
		return lane_name;
	}

	public void setLane_name(String lane_name) {
		this.lane_name = lane_name;
	}
	
}
