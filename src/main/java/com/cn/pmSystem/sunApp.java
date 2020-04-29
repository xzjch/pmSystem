package com.cn.pmSystem;


import com.cn.mappers.Pm_costMapper;
import com.cn.mappers.Pm_iterationMapper;
import com.cn.mappers.Pm_projectMapper;
import com.cn.mappers.Pm_taskMapper;
import com.cn.mappers.Pm_versionMapper;
import com.cn.models.Pm_iteration;
import com.cn.models.Pm_task;
import com.cn.models.Pm_version;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.codes.WebfrkGenerator;
import com.github.tools.generators.docs.APIDocGenerator;
import com.github.tools.generators.docs.SqlDocGenerator;
import com.github.tools.generators.sqls.MyqlTableGenerator;

/**
 * Hello world!
 *
 */
public class sunApp {
	/*
	 * public static void main( String[] args ) {
	 * 
	 * WebfrkGenerator generator = new WebfrkGenerator(); generator.generate();
	 * 
	 * 
	 * }
	 */
	public static void main(String[] args) throws Exception {
		
		//generateDatabase();
		generateServices();
		//generateApiDoc();
		//generateSqlDoc(); 
	}
	//自动生成Services
	public static void generateServices() throws Exception {
		ServiceGenerator sg = new ServiceGenerator();
		//sg.createServiceFromMapper(Pm_versionMapper.class);
		//sg.createServiceFromMapper(Pm_iterationMapper.class);
		//sg.createServiceFromMapper(Pm_taskMapper.class);
		sg.createServiceFromMapper(Pm_projectMapper.class);
		sg.write();
	}
	//自动生成数据库和数据库表
	public static void generateDatabase() throws Exception {
		MyqlTableGenerator sql = new MyqlTableGenerator(
	            "jdbc:mysql://127.0.0.1:3306/pmSystem",
	            "com.mysql.cj.jdbc.Driver",
	            "root", "980216");
	      //sql.setDbName("pmsystem");
	      //sql.createDatabase();
	      sql.createTable(Pm_version.class);
	      //sql.createTable(Pm_iteration.class);
	      //sql.createTable(Pm_task.class);
	}
	//API文档生成,空指针异常的话要把getter setter方法删掉
	public static void generateApiDoc() throws Exception {
		APIDocGenerator apig = new APIDocGenerator();
		 //对应application.yml
		//apig.createAPIDoc("http://127.0.0.1:8081", Pm_version.class);
		//apig.createAPIDoc("http://127.0.0.1:8081", Pm_iteration.class);
		apig.createAPIDoc("http://127.0.0.1:8081", Pm_task.class);

		apig.write();
	}
	//Mysql文档生成
	public static void generateSqlDoc() throws Exception {
		SqlDocGenerator wg = new SqlDocGenerator();
		//wg.createSqlDoc("com.cn.models.Pm_version");
		//wg.createSqlDoc("com.cn.models.Pm_iteration");
		wg.createSqlDoc("com.cn.models.Pm_task");

		wg.print();
		wg.write();
	}
	
	
}
