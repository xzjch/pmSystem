package com.cn.mappers;

import java.math.BigInteger;
import java.util.List;

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

import com.cn.models.Pm_department;
import com.cn.models.Pm_member;
import com.cn.models.Pm_project;
import com.cn.models.Pm_task;
import com.cn.models.Pm_user;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_userMapper {

	/***************************** 耿明泽 ***********************************/

	// 查询用户所在部门
	@Select("select department_id from pm_user user_id=#{user_id}")
	@FunctionDescriber(shortName = "查询用户所在部门")
	public Integer getDepartmentId(BigInteger user_id);

	// 查找所有用户
	@Select("select * from pm_user")
	@FunctionDescriber(shortName = "查找所有用户")
	public List<Pm_user> getAllUsers();

	// 注册用户
	@Insert("INSERT INTO pm_user(user_name,user_realname, user_password,user_phone,user_email,role_id) "
			+ "VALUES(#{user_name},#{user_realname},#{user_password},#{user_phone},#{user_email},9)")
	@FunctionDescriber(shortName = "注册用户")
	public void addUser(Pm_user pm_user);

	// 展示用户个人信息
	@Select("select * from pm_user where user_id=#{user_id}")
	@FunctionDescriber(shortName = "展示用户个人信息")
	public Pm_user getMyInformation(BigInteger user_id);

	// 修改用户真实姓名
	@Update("update pm_user set user_realname=#{user_realname} where user_id = #{user_id}")
	@FunctionDescriber(shortName = "修改用户个人信息")
	public void updateUserRealname(BigInteger user_id, String user_realname);

	// 修改用户密码
	@Update("update pm_user set user_password=#{user_password} where user_id = #{user_id}")
	@FunctionDescriber(shortName = "修改用户密码")
	public void updateUserPassword(BigInteger user_id, String user_password);

	// 修改用户手机号
	@Update("update pm_user set user_phone=#{user_phone} where user_id = #{user_id}")
	@FunctionDescriber(shortName = "修改用户手机号")
	public void updateUserPhone(BigInteger user_id, String user_phone);

	// 修改用户邮箱
	@Update("update pm_user set user_email=#{user_email} where user_id = #{user_id}")
	@FunctionDescriber(shortName = "修改用户邮箱")
	public void updateUserEmail(BigInteger user_id, String user_email);

	/***************************** 耿明泽 ***********************************/

	/***************************** 刘天琪 ***********************************/
	// 根据用户id展示该用户信息
	@Select("select * from pm_user user,pm_role role,pm_department department "
			+ "where user.department_id=department.department_id and user.role_id=role.role_id and "
			+ "user.user_id=#{user_id};")
	@ResultType(Pm_user.class)
	@FunctionDescriber(shortName = "根据用户id展示该用户信息")
	Pm_user queryById(@Param("user_id") BigInteger user_id);

	// 展示所有的用户：用户信息、角色名称、所在部门
	@Select("select * from pm_user user,pm_role role,pm_department department "
			+ "where user.department_id=department.department_id and user.role_id=role.role_id;")
	@ResultType(Pm_user.class)
	@FunctionDescriber(shortName = "展示所有的用户：用户信息、角色名称、所在部门")
	public List<Pm_user> getUsers();

	// 根据用户id更新用户信息
	@Update("update pm_user set user_name=#{user_name},user_realname=#{user_realname},"
			+ "user_password=#{user_password},user_phone=#{user_phone},user_email"
			+ "=#{user_email},role_id=#{role_id},department_id=#{department_id}" + " where user_id = #{user_id}")
	@ResultType(Pm_user.class)
	@FunctionDescriber(shortName = "根据用户id更新用户信息")
	Integer updatePm_user(Pm_user pm_user);

	/***************************** 刘天琪 ***********************************/

}
