package com.cn.mappers;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.models.Pm_member;

import com.cn.models.Pm_user;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_memberMapper {

	/* 一、展示某一项目所有成员的信息：用户名、角色名称 */
	@Select("select * from pm_member member,pm_user user,pm_role role "
			+ "where user.user_id=member.user_id and role.role_id=member.role_id and "
			+ "member.project_id=#{project_id};")
	@FunctionDescriber(shortName = "展示某一项目所有成员的信息")
	public List<Pm_member> getPm_member(Integer project_id);

	/* 二、添加某一项目成员 */
	// 1、展示所有用户的信息
	@Select("select * from pm_user")
	@FunctionDescriber(shortName = "展示所有用户的信息")
	public List<Pm_user> getPm_user();

	// 2、添加成员
	@Insert("insert into pm_member(project_id,user_id,role_id) values(#{project_id},#{user_id},9)")
	@FunctionDescriber(shortName = "添加成员")
	public void addPm_member(Integer project_id, Integer user_id);

	/* 三、移除某一项目成员 */
	@Delete("delete from pm_member where user_id=#{user_id} and project_id=#{project_id}")
	@FunctionDescriber(shortName = "移除成员")
	public void deletePm_member(Integer project_id, Integer user_id);

	/*
	 * 四、展示所有角色
	 * 
	 * @Select("select * from pm_role")
	 * 
	 * @FunctionDescriber(shortName = "展示所有角色") public List<Pm_role> getPm_role();
	 */

	/* 五、添加/修改成员角色 */
	@Update("update  pm_member set role_id=#{role_id} where member_id=#{member_id}")
	@FunctionDescriber(shortName = "修改角色")
	public void updateMemberRole(Integer member_id, Integer role_id);

	/* 六、查询用户进入项目得权限 */
	@Select("select role_id from pm_member where project_id=#{project_id} and user_id=#{user_id}")
	@FunctionDescriber(shortName = "查询用户进入项目得权限")
	public Integer getPm_project(Integer project_id, Integer user_id);

}
