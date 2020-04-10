/*卢湛兴*/

package com.cn.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.models.Pm_flow;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_flowMapper{
	//创建流转规则名称
	@Insert("INSERT INTO pm_flow(flow_rule,project_id) VALUES(#{flow_rule},#{project_id})")
	@FunctionDescriber(shortName = "创建流转规则")
	public void addPm_flow(String flow_rule,Integer project_id);
	
	//获取项目id并插入流转中--------这里需要之后完善
//	@Insert("INSERT INTO pm_flow(project_id) VALUES(#{project_id})")
//	@FunctionDescriber(shortName = "项目id")
//	public void addProject_id(Pm_flow project_id);
	
	//查询所有的流转规则名称
	@Select("select flow_rule from pm_flow")
	@FunctionDescriber(shortName = "查询所有流转规则名称")
	public List<String> queryFlow_rule();
	
	//删除流转规则
	@Delete("delete from pm_flow where flow_id=#{flow_id}")
	@FunctionDescriber(shortName = "根据flow_id删除流转规则")
	public void deletePm_flow(int flow_id);
	
	//根据流转id查询流转内的所有字段
	@Select("select * from pm_flow where flow_id=#{flow_id}")
	@FunctionDescriber(shortName = "查询流转内的所有字段")
	public List<Pm_flow> queryPm_flow(Integer flow_id);
	
	//编辑更新流转规则
	@Update("update pm_flow set flow_rule=#{flow_rule},lane_name1=#{lane_name1},flow_condition=#{flow_condition},lane_name2=#{lane_name2},lane_state=#{lane_state} where flow_id=#{flow_id}")
	@FunctionDescriber(shortName = "编辑流转规则")
	public void updateFlow_rule(String flow_rule,Integer lane_name1,Integer flow_condition,Integer lane_name2,Integer lane_state,Integer flow_id);	

}
