package com.cn.pmSystem;

import com.cn.mappers.Pm_storyMapper;
import com.cn.models.Pm_story;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.sqls.MyqlTableGenerator;

public class Mapper {
	
	public static void main( String[] args ) throws Exception {
		//myqlTableGenerator();
		serviceGenerator();
	}
	
	public static void myqlTableGenerator() throws Exception {
		MyqlTableGenerator sql = new MyqlTableGenerator(
	            "jdbc:mysql://127.0.0.1:3306/pmSystem",
	            "com.mysql.cj.jdbc.Driver",
	            "root", "123456");
	      sql.setDbName("pmSystem");
	      sql.createDatabase();
	      sql.createTable(Pm_story.class);
	}
	
	public static void serviceGenerator() throws Exception {
		ServiceGenerator sg = new ServiceGenerator();
		sg.createServiceFromMapper(Pm_storyMapper.class);
		sg.write();
	}
}
