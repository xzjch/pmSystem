package com.cn.pmSystem;


import com.cn.mappers.Pm_versionMapper;
import com.cn.models.Pm_version;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.codes.WebfrkGenerator;
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
	}
	public static void generateServices() throws Exception {
		ServiceGenerator sg = new ServiceGenerator();
		sg.createServiceFromMapper(Pm_versionMapper.class);
		sg.write();
	}
	
	public static void generateDatabase() throws Exception {
		MyqlTableGenerator sql = new MyqlTableGenerator(
	            "jdbc:mysql://127.0.0.1:3306/pmsystem",
	            "com.mysql.cj.jdbc.Driver",
	            "root", "980216");
	      sql.setDbName("pmsystem");
	      sql.createDatabase();
	      sql.createTable(Pm_version.class);
	}
}
