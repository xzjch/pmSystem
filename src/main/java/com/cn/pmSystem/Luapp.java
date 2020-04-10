/*卢湛兴*/

package com.cn.pmSystem;

import com.cn.mappers.Pm_flowMapper;
import com.cn.mappers.Pm_memberMapper;
import com.cn.models.Pm_member;
import com.github.tools.generators.codes.ServiceGenerator;
import com.github.tools.generators.sqls.MyqlTableGenerator;

public class Luapp {
	public static void main( String[] args ) throws Exception{
        //数据库表
//      generateDatabase();
      
       //service
     generateServices();
	}
	//自动生成流转数据库和数据库表（Pm_flow、Pm_lane）
    public static void generateDatabase() throws Exception {
	    MyqlTableGenerator sql = null;
		
		sql = new MyqlTableGenerator(
			"jdbc:mysql://127.0.0.1:3306/pmSystem",
			"com.mysql.cj.jdbc.Driver",
			"root", "root");
		
//	    sql.setDbName("pmSystem");
//		sql.DropDatabase();
//		sql.createDatabase();
//		sql.createTable(Pm_flow.class);
//		sql.createTable(Pm_lane.class);
		sql.createTable(Pm_member.class);
    }
	
    //自动生成Service
    public static void generateServices() throws Exception {
	    ServiceGenerator sg = new ServiceGenerator();
//		sg.createServiceFromMapper(Pm_flowMapper.class);
//		sg.createServiceFromMapper(Pm_laneMapper.class);
		sg.createServiceFromMapper(Pm_memberMapper.class);
		sg.write();
    }
}
