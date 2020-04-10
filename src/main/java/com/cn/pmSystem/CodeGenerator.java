package com.cn.pmSystem;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import com.cn.mappers.Pm_memberMapper;
import com.cn.mappers.Pm_projectMapper;
import com.cn.models.Pm_member;
import com.cn.models.Pm_project;
import com.cn.models.Pm_role;
import com.cn.models.Pm_user;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.codes.WebfrkGenerator;
import com.github.tools.generators.sqls.MyqlTableGenerator;

public class CodeGenerator {
	public static void main(String[] args) {
//		webfrkGenerator();
//		myqlTableGenerator();
		serviceGenerator();
	}

	/*
	 * 第一步 初始化整个项目。自动生成resources包、ApplicationServer.java
	 */
	public static void webfrkGenerator() {
		WebfrkGenerator generator = new WebfrkGenerator();
		generator.generate();
	}

	/*
	 * 第二步 初始化数据库以及创建数据库表
	 */
	public static void myqlTableGenerator() {
		MyqlTableGenerator sql;
		try {
			sql = new MyqlTableGenerator(

					"jdbc:mysql://127.0.0.1:3306/pmSystem", "com.mysql.cj.jdbc.Driver", "root", "root");
			sql.setDbName("pmSystem");

			sql.createDatabase();

			sql.createTable(Pm_role.class);
			sql.createTable(Pm_user.class);
			sql.createTable(Pm_member.class);
			sql.createTable(Pm_project.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}

	}
	
	/*
	 * 第三步 自动生成service包、service文件
	 */
	public static void serviceGenerator() {

		ServiceGenerator sg = new ServiceGenerator();
		try {
			sg.createServiceFromMapper(Pm_memberMapper.class);
			sg.createServiceFromMapper(Pm_projectMapper.class);
			sg.write();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		

	}
	
}
