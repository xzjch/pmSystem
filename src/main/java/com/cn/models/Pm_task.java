package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.PrivateKey;

public class Pm_task {
	 @PrivateKey//主键
	  @AutoIncrement//自增
	  
	  @FieldDescriber("任务ID")
	  private int task_id;

	  @Size(max = 500)
	  @FieldDescriber("任务内容")
	  private String task_con;

	  @Size(max = 500)
	  @Required(false)
	  @FieldDescriber("任务备注")
	  private String task_desc;
	  
	  @Size(max = 30)
	  @Required(false)
	  @FieldDescriber("估算值")
	  private String task_esti;
	  
	  @Size(max = 30)
	  @Required(false)
	  @FieldDescriber("优先级")
	  private String task_pri;
	  
	  @Size(max = 30)
	  @DefaultValue("未完成")
	  @Required(false)
	  @FieldDescriber("任务状态（已完成，未完成）")
	  private String task_state;
	  
	  @FieldDescriber("用户故事ID")
	  private int story_id;
	  
	  @FieldDescriber("泳道ID")
	  private String lane_id;
	  
	  @FieldDescriber("迭代ID")
	  private int iteration_id;

	public int getTask_id() {
		return task_id;
	}

	public void setTask_id(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_con() {
		return task_con;
	}

	public void setTask_con(String task_con) {
		this.task_con = task_con;
	}

	public String getTask_desc() {
		return task_desc;
	}

	public void setTask_desc(String task_desc) {
		this.task_desc = task_desc;
	}

	public String getTask_esti() {
		return task_esti;
	}

	public void setTask_esti(String task_esti) {
		this.task_esti = task_esti;
	}

	public String getTask_pri() {
		return task_pri;
	}

	public void setTask_pri(String task_pri) {
		this.task_pri = task_pri;
	}

	public String getTask_state() {
		return task_state;
	}

	public void setTask_state(String task_state) {
		this.task_state = task_state;
	}

	public int getStory_id() {
		return story_id;
	}

	public void setStory_id(int story_id) {
		this.story_id = story_id;
	}

	public String getLane_id() {
		return lane_id;
	}

	public void setLane_id(String lane_id) {
		this.lane_id = lane_id;
	}

	public int getIteration_id() {
		return iteration_id;
	}

	public void setIteration_id(int iteration_id) {
		this.iteration_id = iteration_id;
	}
	
}
