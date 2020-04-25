package com.cn.models;

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.DefaultValue;
import com.github.tools.annotations.mysql.PrivateKey;

/*必须有JavaBean的注解
 * 每一个成员变量都必须有FieldDescriber注解，用于生成文档
 * 每一个成员变量至少有一个注解（com.github.tools.annotations.mysql目录下），用于生成SQL中的元素
 * 每一个成员变量可以有长度约束，当前仅仅支持整型和字符串类型（javax.validation.constraints目录下），用于生成SQL语句中的长度约束
 * 每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
 * */
//实体类必须要有JavaBean注解
public class Pm_version {
	  @PrivateKey//主键
	  @AutoIncrement//自增
	  
	  @FieldDescriber("发布计划ID")
	  private int version_id;

	  @Size(max = 255)
	  @FieldDescriber("发布名称")
	  private String version_name;

	  @Size(max = 500)
	  @Required(false)
	  @FieldDescriber("发布备注")
	  private String version_desc;
	  
	  @Size(max = 30)
	  @Required(false)
	  @FieldDescriber("发布的开始时间")
	  private String version_stime;
	  
	  @Size(max = 30)
	  @Required(false)
	  @FieldDescriber("发布的截至时间")
	  private String version_ptime;
	  
	  @Size(max = 30)
	  @DefaultValue("未开始")
	  @Required(false)
	  @FieldDescriber("发布状态（状态。0：未开始，1：进行中，2：延期发布，3：已发布）")
	  private String version_state;

	  @FieldDescriber("项目ID")
	  private int project_id;
	  
	  @FieldDescriber("用户故事ID")
	  private int story_id;
	  
	  @Size(max = 500)
	  @FieldDescriber("用户故事内容")
	  private String story_con;
	  
	public int getVersion_id() {
		return version_id;
	}

	public void setVersion_id(int version_id) {
		this.version_id = version_id;
	}

	public String getVersion_name() {
		return version_name;
	}

	public void setVersion_name(String version_name) {
		this.version_name = version_name;
	}

	public String getVersion_desc() {
		return version_desc;
	}

	public void setVersion_desc(String version_desc) {
		this.version_desc = version_desc;
	}

	public String getVersion_stime() {
		return version_stime;
	}

	public void setVersion_stime(String version_stime) {
		this.version_stime = version_stime;
	}

	public String getVersion_ptime() {
		return version_ptime;
	}

	public void setVersion_ptime(String version_ptime) {
		this.version_ptime = version_ptime;
	}



	public String getVersion_state() {
		return version_state;
	}

	public void setVersion_state(String version_state) {
		this.version_state = version_state;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
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

}
