package com.cn.models;
/**

 * @author GMZ

 * @since 2020.4.8

 */

import javax.validation.constraints.Size;

import com.github.tools.annotations.api.FieldDescriber;
import com.github.tools.annotations.api.Required;
import com.github.tools.annotations.mysql.AutoIncrement;
import com.github.tools.annotations.mysql.JavaBean;
import com.github.tools.annotations.mysql.PrivateKey;

@JavaBean
public class Pm_project {
	//实体类必须要有JavaBean注解
		@PrivateKey//私钥？
		@AutoIncrement//数据库id自增长？
		
		@FieldDescriber("项目ID")
//		每一个成员变量应该有一个Reqired变量（没有默认表示该参数是前端请求的必填项）
		private int project_id;
		

		@Required(false)
		@Size(max = 10)
		@FieldDescriber("项目名称")
		private String project_name;
		
		@FieldDescriber("项目简介")
		@Required(false)
		private String project_des;
		
		@FieldDescriber("项目创建人")
		@Required(false)
		private String project_men;

		@FieldDescriber("项目迭代周期")
		@Required(false)
		private String project_spr;
		
		@Required(false)
		@FieldDescriber("项目名状态")
		private int project_state;

	//	@Required(false)
		@FieldDescriber("项目类型")
		private int project_type;
		
		@FieldDescriber("项目创建时间")
		@Required(false)
		private String project_time;

		public int getProject_id() {
			return project_id;
		}

		public void setProject_id(int project_id) {
			this.project_id = project_id;
		}

		public String getProject_name() {
			return project_name;
		}

		public void setProject_name(String project_name) {
			this.project_name = project_name;
		}

		public String getProject_des() {
			return project_des;
		}

		public void setProject_des(String project_des) {
			this.project_des = project_des;
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

		public int getProject_state() {
			return project_state;
		}

		public void setProject_state(int project_state) {
			this.project_state = project_state;
		}

		public int getProject_type() {
			return project_type;
		}

		public void setProject_type(int project_type) {
			this.project_type = project_type;
		}

		public String getProject_time() {
			return project_time;
		}

		public void setProject_time(String project_time) {
			this.project_time = project_time;
		}
		
		
		
}

