package com.cn.pmSystem;

import com.cn.mappers.Pm_storyMapper;
import com.cn.models.Pm_bug;
import com.cn.models.Pm_department;
import com.cn.models.Pm_flow;
import com.cn.models.Pm_iteration;
import com.cn.models.Pm_lane;
import com.cn.models.Pm_member;
import com.cn.models.Pm_project;
import com.cn.models.Pm_project_bind;
import com.cn.models.Pm_role;
import com.cn.models.Pm_story;
import com.cn.models.Pm_user;
import com.cn.models.Pm_version;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.sqls.MyqlTableGenerator;

public class Mapper {
	
	public static void main( String[] args ) throws Exception {
		myqlTableGenerator();
		//serviceGenerator();
	}
	
	public static void myqlTableGenerator() throws Exception {
		MyqlTableGenerator sql = new MyqlTableGenerator(
	            "jdbc:mysql://127.0.0.1:3306/pmSystem",
	            "com.mysql.cj.jdbc.Driver",
	            "root", "123456");
	      //sql.setDbName("pmSystem");
	      //sql.createDatabase();
	      //sql.createTable(Pm_story.class);
		sql.createTable(Pm_bug.class);
		sql.createTable(Pm_department.class);
		sql.createTable(Pm_flow.class);
		sql.createTable(Pm_iteration.class);
		sql.createTable(Pm_lane.class);
		//sql.createTable(Pm_member.class);
		sql.createTable(Pm_project_bind.class);
		//sql.createTable(Pm_project.class);
		sql.createTable(Pm_role.class);
		//sql.createTable(Pm_user.class);
		sql.createTable(Pm_version.class);
	}
	
	public static void serviceGenerator() throws Exception {
		ServiceGenerator sg = new ServiceGenerator();
		sg.createServiceFromMapper(Pm_storyMapper.class);
		sg.write();
	}
}
