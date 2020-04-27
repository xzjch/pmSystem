package com.cn.mappers;

import com.cn.models.Pm_iteration;
import com.cn.models.Pm_user;
import com.github.tools.annotations.api.FunctionDescriber;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

public interface Pm_iterationMapper {

	@Select("select iteration_name from pm_iteration where  project_id=#{project_id}")
	@FunctionDescriber(shortName = "根据项目id展示该项目的所有迭代")
	public List<Pm_iteration> getPm_iteration(@Param("project_id") BigInteger project_id);

	@Select("select iteration_name from pm_iteration iteration,pm_bug bug " +
			"where iteration.project_id=bug.project_id and bug.bug_id=#{bug_id}")
	@FunctionDescriber(shortName = "根据缺陷id展示该项目的所有迭代")
	public List<Pm_iteration> getPm_itBybug(@Param("bug_id") BigInteger bug_id);

	@Select("select user_name from pm_user user,pm_member member,pm_bug bug " +
			"where user.user_id = member.user_id and member.project_id=bug.project_id and bug.bug_id=#{bug_id}")
	@FunctionDescriber(shortName = "根据缺陷id展示该项目的所有成员")
	public List<Pm_user> getUserBybug_id(@Param("bug_id") BigInteger bug_id);

	@Select("select user_name from pm_user user,pm_member member " +
			"where user.user_id = member.user_id and member.project_id=#{project_id}")
	@FunctionDescriber(shortName = "根据项目id展示该项目的所有成员")
	public List<Pm_user> getUserByp_id(@Param("project_id") BigInteger project_id);
	
	/*//展示（本项目）迭代信息,还需要获取本项目的id
	@Select("select * from pm_iteration")
	@FunctionDescriber(shortName = "展示（本项目）迭代信息")
	public List<Pm_iteration> getPm_iteration();*/
			
	//根据迭代ID展示该迭代的用户故事
	@Select("select * from pm_iteration iteration,pm_story story "
			+ "where story.iteration_id = iteration.iteration_id and "
			+ "iteration.iteration_id=#{iteration_id}")
			
	@FunctionDescriber(shortName = "根据迭代id展示该迭代的用户故事")
	public List<Pm_iteration> listPm_iteration(BigInteger iteration_id);
	
	//根据项目id展示该项目的迭代
	@Select("select iteration_id, iteration_name,iteration_stime,iteration_otime,iteration_desc from pm_iteration where project_id=#{project_id}")
	@ResultType(Pm_iteration.class)
	@FunctionDescriber(shortName = "根据项目id展示该项目的迭代")
	public List<Pm_iteration> listPm_iteration1(BigInteger project_id);
	
	//卢湛兴（开始）----------------------------------------------------------------------
	//添加迭代计划
		@Insert("INSERT INTO pm_iteration(iteration_name,iteration_stime,iteration_otime,iteration_desc,project_id) VALUES(#{iteration_name},#{iteration_stime},#{iteration_otime},#{iteration_desc},#{project_id})")
		@FunctionDescriber(shortName = "添加迭代计划")
		public void addPm_iteration(Pm_iteration pm_iteration);
		
		//根据项目id查询所有迭代
		@Select("select *  from pm_iteration where project_id=#{project_id}")
		@FunctionDescriber(shortName = "查询该项目所有迭代计划")
		public List<Pm_iteration> queryIteration(BigInteger project_id);
		
		//根据iteration_id查询某一迭代计划详情
		@Select("select * from pm_iteration where iteration_id=#{iteration_id}")
		@ResultType(Pm_iteration.class)
		@FunctionDescriber(shortName = "查询迭代计划详情")
		Pm_iteration queryIterationDetails(@Param("iteration_id") BigInteger iteration_id);
		
		//编辑某一迭代计划
		@Update("update pm_iteration set iteration_name=#{iteration_name},iteration_stime=#{iteration_stime},iteration_otime=#{iteration_otime},iteration_desc=#{iteration_desc} where iteration_id=#{iteration_id}")
		@ResultType(BigInteger.class)
		@FunctionDescriber(shortName = "编辑迭代计划")
		Integer updatePm_iteration(Pm_iteration pm_iteration);
		
		//删除迭代计划
		@Delete("delete from pm_iteration where iteration_id=#{iteration_id}")
		@FunctionDescriber(shortName = "根据iteration_id删除迭代计划")
		public void deletePm_iteration(@Param("iteration_id") BigInteger iteration_id);
	
	//卢湛兴（结束）----------------------------------------------------------------------
			
}
