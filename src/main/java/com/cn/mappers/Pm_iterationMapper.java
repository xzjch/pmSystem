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
}