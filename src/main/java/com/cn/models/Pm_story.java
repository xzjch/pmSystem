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
public class Pm_story {
	
	 @PrivateKey
	 @AutoIncrement
	 
	 @FieldDescriber("用户故事ID")
	  private int story_id;
	 
	 @NotNull
	 @Size(max = 500, message = "{pm_story.story_con.length.illegal}")
	 
	 @FieldDescriber("用户故事内容")
	 @Required(true)
	 private String story_con;
	 
	 
	 @Size(max = 200)	 
	 @FieldDescriber("细节注释")
	  private String story_not;
	 
	 @Size(max = 200)	 
	 @FieldDescriber("验收标准")
	  private String story_stan;
	 
	 @Size(max = 200)	 
	 @FieldDescriber("故事点")
	  private String story_number;
	 
	 @Size(max = 200)
	 @DefaultValue("普通")	 
	 @FieldDescriber("优先级")
	  private String story_pri;
	 
	 @Size(max = 200)
	 @DefaultValue("0")	 //未完成
	 @FieldDescriber("状态")
	  private String story_state;
	 
	 //卢将int型改为String型
	 @DefaultValue("0")
	 @NotNull
	 @FieldDescriber("泳道ID")
	  private String lane_id;
	 
	 @NotNull
	 @FieldDescriber("项目ID")
	  private int project_id;
	 
	 @FieldDescriber("迭代ID")
	  private int iteration_id;
	 
	 @FieldDescriber("发布计划ID")
	  private int version_id;
	 
	 @Size(max = 200)
	 @FieldDescriber("用户名")
	 private String user_name;
	 
	  public String getUser_name() { 
		  return user_name;
	  } 
	  public void setUser_name(String user_name) {
		  this.user_name = user_name; 
	  }
	 

	
	
	public int getStory_id() {
		return story_id;
	}

	public void setStory_id(int story_id) {
		this.story_id = story_id;
	}

	public String getStory_con() {
		return story_con;
	}

	public void setStory_con(String story_con) {
		this.story_con = story_con;
	}

	public String getStory_not() {
		return story_not;
	}

	public void setStory_not(String story_not) {
		this.story_not = story_not;
	}

	public String getStory_stan() {
		return story_stan;
	}

	public void setStory_stan(String story_stan) {
		this.story_stan = story_stan;
	}	

	public String getStory_pri() {
		return story_pri;
	}

	public void setStory_pri(String story_pri) {
		this.story_pri = story_pri;
	}

	public String getStory_state() {
		return story_state;
	}

	public void setStory_state(String story_state) {
		this.story_state = story_state;
	}

	public String getLane_id() {
		return lane_id;
	}

	public void setLane_id(String lane_id) {
		this.lane_id = lane_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getStory_number() {
		return story_number;
	}
	public void setStory_number(String story_number) {
		this.story_number = story_number;
	}
	
	public int getIteration_id() {
		return iteration_id;
	}
	public void setIteration_id(int iteration_id) {
		this.iteration_id = iteration_id;
	}
	public int getVersion_id() {
		return version_id;
	}
	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}

	
	 
}
