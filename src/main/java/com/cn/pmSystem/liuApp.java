package com.cn.pmSystem;

import com.cn.mappers.Pm_projectMapper;
import com.cn.mappers.Pm_project_bindMapper;
import com.cn.models.Pm_member;
import com.cn.models.Pm_project;
import com.cn.models.Pm_project_bind;
import com.cn.models.Pm_role;
import com.cn.models.Pm_user;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.sqls.MyqlTableGenerator;

public class liuApp {
	public static void main( String[] args ) throws Exception {
		//myqlTableGenerator();
		serviceGenerator();
	}
	
	public static void myqlTableGenerator() throws Exception {
		MyqlTableGenerator sql = new MyqlTableGenerator(
	            "jdbc:mysql://127.0.0.1:3306/pmSystem",
	            "com.mysql.cj.jdbc.Driver",
	            "root", "root");
	   //   sql.setDbName("pmSystem");
	   //   sql.createDatabase();
	   //   sql.createTable(Pm_project_bind.class);
	      sql.createTable(Pm_member.class);
	      sql.createTable(Pm_project.class);
	      sql.createTable(Pm_role.class);
	      sql.createTable(Pm_user.class);
	}
	
	public static void serviceGenerator()  {
		ServiceGenerator sg = new ServiceGenerator();
		try {
			sg.createServiceFromMapper(Pm_projectMapper.class);
			sg.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	}
}
