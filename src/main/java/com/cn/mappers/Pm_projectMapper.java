package com.cn.mappers;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**

 * @author GMZ

 * @since 2020.4.8

 */

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.models.Pm_project;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_projectMapper {

	/***************************** 耿明泽 ***********************************/
	/* 展现当前项目是否归档 */
	@Select("select project_state from pm_project where project_id=#{project_id}")
	@FunctionDescriber(shortName = "展现当前项目是否归档")
	public String getProject_State(BigInteger project_id);

	/* 归档项目/取消归档项目 */
	@Update("update  pm_project set project_state=#{project_state} where project_id=#{project_id}")
	@FunctionDescriber(shortName = "归档项目/取消归档项目")
	public void updatePm_project(BigInteger project_id, String project_state);

	/* 查询成员列表某成员参与的所有项目信息 */
	@Select("select * from pm_member,pm_project where user_id=#{user_id} "
			+ "and pm_member.project_id=pm_project.project_id")
	@FunctionDescriber(shortName = "查询成员列表某成员参与的所有项目信息")
	public List<Pm_project> queryUserAllProjects(Integer user_id);
	
	@Select("select project_id from pm_member where user_id=#{user_id}")
	@FunctionDescriber(shortName = "查询成员列表参与项目的id")
	public List<Integer> project_ids(BigInteger user_id);
	
	
	@Select("select * from pm_project where project_type=#{project_type} and "
			+ "project_state=#{project_state}")
	@FunctionDescriber(shortName = "通过项目状态和项目类型查找项目")
	public List<Pm_project> getShowProjects(@Param("project_type")String project_type,@Param("project_state")String project_state);
	
	@Select("select * from pm_project,pm_member where project_state=#{project_state} and user_id=#{user_id} "
			+ "and pm_member.project_id=pm_project.project_id")
	@FunctionDescriber(shortName = "通过项目状态和项目类型查找项目")
	public List<Pm_project> getProjectsByProjectState(String project_state,BigInteger user_id);

	/***************************** 耿明泽 ***********************************/
	/*
	 * 查询用户进入项目得权限
	 * 
	 * @Select("select * from pm_member where ")
	 * 
	 * @FunctionDescriber(shortName = "查询用户进入项目得权限") public List<Pm_project>
	 * getPm_project();
	 */

	@Insert("INSERT INTO pm_project(project_des, project_name,project_type,project_men,project_spr,project_time) VALUES(#{project_des},#{project_name},#{project_type},#{project_men},#{project_spr},#{project_time})")
	@FunctionDescriber(shortName = "添加项目信息")
	public void addProjectInfo(Pm_project pm_project);

	@Select("select project_des, project_name,project_type,project_men,project_spr,project_time from pm_project where project_id=#{project_id}")
	@ResultType(Pm_project.class)
	@FunctionDescriber(shortName = "根据项目id查询项目信息")
	Pm_project queryById(@Param("project_id") BigInteger project_id);

	@Update("update pm_project set project_des=#{project_des},project_name=#{project_name},project_type=#{project_type},project_men=#{project_men},project_spr=#{project_spr},project_time=#{project_time} where project_id = #{project_id}")
	@ResultType(BigInteger.class)
	@FunctionDescriber(shortName = "更新项目信息")
	Integer updateProject(Pm_project pm_project);

	/*
	 * @Delete("delete from pm_project where project_id = #{project_id}")
	 * 
	 * @FunctionDescriber(shortName = "删除项目信息") public void deleteProject(Pm_project
	 * pm_project);
	 */

	@Select("select * from pm_project")
	@FunctionDescriber(shortName = "查询所有项目")
	public List<Pm_project> getProjects();


}
