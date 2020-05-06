package com.cn.mappers;

import com.cn.models.Pm_bug;
import com.github.tools.annotations.api.FunctionDescriber;
import org.apache.ibatis.annotations.*;

import java.math.BigInteger;
import java.util.List;

public interface Pm_bugMapper {

	@Insert("INSERT INTO pm_bug(bug_name, bug_test,bug_rem,bug_state,bug_pri,bug_ptime,bug_user,project_id,bug_spr) VALUES(#{bug_name},#{bug_test},#{bug_rem},#{bug_state},#{bug_pri},#{bug_ptime},#{bug_user},#{project_id},#{bug_spr})")
	@FunctionDescriber(shortName = "添加缺陷信息")
	public void addBugInfo(Pm_bug pm_bug);

	//修改缺陷操作，根据缺陷id查询单个缺陷信息
	@Select("select bug_name, bug_test,bug_rem,bug_state,bug_pri,bug_ptime,bug_user,project_id,bug_spr from pm_bug where bug_id=#{bug_id}")
	@ResultType(Pm_bug.class)
	@FunctionDescriber(shortName = "根据缺陷id查询缺陷信息")
	Pm_bug queryBugById(@Param("bug_id") BigInteger bug_id);

	//修改缺陷后更新数据库
	@Update("update pm_bug set bug_name = #{bug_name},bug_test = #{bug_test},bug_rem = #{bug_rem},bug_state = #{bug_state},bug_pri = #{bug_pri},bug_ptime = #{bug_ptime},bug_user = #{bug_user},project_id = #{project_id},bug_spr = #{bug_spr} where bug_id = #{bug_id}")
	@ResultType(BigInteger.class)
	@FunctionDescriber(shortName = "更新项目信息")
	Integer updateBug(Pm_bug pm_bug);

	@Select("select * from pm_bug where  project_id=#{project_id}")
	@FunctionDescriber(shortName = "根据项目id展示该项目的所有缺陷")
	public List<Pm_bug> getPm_bug(@Param("project_id") BigInteger project_id);

	@Select("select * from pm_bug where project_id=#{project_id} and bug_user='' ")
	@FunctionDescriber(shortName = "根据领取人展示该项目的所有缺陷")
	public List<Pm_bug> getBugByUser(@Param("project_id") BigInteger project_id );

	@Select("select * from pm_bug where project_id=#{project_id} and bug_user=#{bug_user} and bug_state='待消缺' ")
	@FunctionDescriber(shortName = "根据领取人和状态展示该项目的所有缺陷")
	public List<Pm_bug> getBugByStatea(@Param("project_id") BigInteger project_id,@Param("bug_user") String bug_user);

	@Select("select * from pm_bug where project_id=#{project_id} and bug_user=#{bug_user} and bug_state='消缺中' ")
	@FunctionDescriber(shortName = "根据领取人和状态展示该项目的所有缺陷")
	public List<Pm_bug> getBugByStateb(@Param("project_id") BigInteger project_id,@Param("bug_user") String bug_user);

	@Select("select * from pm_bug where project_id=#{project_id} and bug_user=#{bug_user} and bug_state='已消缺' ")
	@FunctionDescriber(shortName = "根据领取人和状态展示该项目的所有缺陷")
	public List<Pm_bug> getBugByStatec(@Param("project_id") BigInteger project_id,@Param("bug_user") String bug_user);

	@Select("select * from pm_bug where project_id=#{project_id} and bug_user=#{bug_user} and bug_state='已关闭' ")
	@FunctionDescriber(shortName = "根据领取人和状态展示该项目的所有缺陷")
	public List<Pm_bug> getBugByStated(@Param("project_id") BigInteger project_id,@Param("bug_user") String bug_user);

}
