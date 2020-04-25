package com.cn.models;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.PrivateKey;

import javax.validation.constraints.Size;

public class Pm_iteration {
    @PrivateKey//私钥？
    @AutoIncrement//数据库id自增长？

    @FieldDescriber("迭代ID")
    private int iteration_id;


    @Required(false)
    @Size(max = 10)
    @FieldDescriber("迭代名称")
    private String iteration_name;
    
    @Size(max = 30)
	  @Required(false)
	  @FieldDescriber("开始时间")
	  private String iteration_stime;
	  
	  @Size(max = 30)
	  @Required(false)
	  @FieldDescriber("结束时间")
	  private String iteration_otime;
	  
	  @Size(max = 500)
	  @Required(false)
	  @FieldDescriber("迭代备注")
	  private String iteration_desc;

    @FieldDescriber("项目ID")
    private int project_id;
    
    @FieldDescriber("用户故事ID")
	  private int story_id;
    

    public int getIteration_id() {
        return iteration_id;
    }

    public void setIteration_id(int iteration_id) {
        this.iteration_id = iteration_id;
    }

    public String getIteration_name() {
        return iteration_name;
    }

    public void setIteration_name(String iteration_name) {
        this.iteration_name = iteration_name;
    }
    
    

    public String getIteration_stime() {
		return iteration_stime;
	}

	public void setIteration_stime(String iteration_stime) {
		this.iteration_stime = iteration_stime;
	}

	public String getIteration_otime() {
		return iteration_otime;
	}

	public void setIteration_otime(String iteration_otime) {
		this.iteration_otime = iteration_otime;
	}

	public String getIteration_desc() {
		return iteration_desc;
	}

	public void setIteration_desc(String iteration_desc) {
		this.iteration_desc = iteration_desc;
	}

	public int getStory_id() {
		return story_id;
	}

	public void setStory_id(int story_id) {
		this.story_id = story_id;
	}

	public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }
    
}
