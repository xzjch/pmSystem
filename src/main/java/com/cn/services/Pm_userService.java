package com.cn.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.mappers.Pm_userMapper;
import com.cn.models.Pm_user;
import com.github.tools.annotations.api.FunctionDescriber;
import com.github.webfrk.core.HttpBodyHandler;


import com.github.tools.annotations.ServiceDefinition;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@ServiceDefinition
public class Pm_userService extends HttpBodyHandler {

	@Autowired
	private Pm_userMapper pm_userMapper;

	/***************************** 耿明泽 ***********************************/
	@FunctionDescriber(shortName = "登录", description = "暂无", prerequisite = "暂无")
	public Integer getLogin(String user_name ,String user_password) {
		List<Pm_user> users = pm_userMapper.getAllUsers();
		for (Pm_user user : users) {
			if (user.getUser_name().equals(user_name)) { //判断是否存在用户名
				if (user.getUser_password().equals(user_password)) {//判断密码是否正确
					return user.getUser_id();
				} else {
					return 0;//密码不正确
				}
			}
		}
		return 10000;//用户名不正确
	}

	@FunctionDescriber(shortName = "注册", description = "暂无", prerequisite = "暂无")
	public String getRegister(String user_name,String user_realname,String user_phone,
			String user_email,String user_password) {
		List<Pm_user> users = pm_userMapper.getAllUsers();
		Pm_user pm_user=new Pm_user();
		for (int i = 0; i < users.size(); i++) {
			// 判断昵称是否重复
			if (user_name.equals(users.get(i).getUser_name())) {
				return "1";
			}
			/*
			 * // 判断手机号是否已注册 if (user_phone.equals(users.get(i).getUser_phone())) { return
			 * "2"; } // 判断邮箱是否已注册 if (user_email.equals(users.get(i).getUser_email())) {
			 * return "3"; }
			 */
		}
		pm_user.setUser_name(user_name);
		pm_user.setUser_password(user_password);
		pm_user.setUser_phone(user_phone);
		pm_user.setUser_realname(user_realname);
		pm_user.setUser_email(user_email);
		pm_userMapper.addUser(pm_user);
		return "0";
	}

	@FunctionDescriber(shortName = "展示某用户个人信息", description = "暂无", prerequisite = "暂无")
	public com.cn.models.Pm_user getMyInformation(BigInteger user_id) {
		return pm_userMapper.getMyInformation(user_id);
	}

	@FunctionDescriber(shortName = "修改用户真实姓名", description = "暂无", prerequisite = "暂无")
	public void updateUserRealname(@Valid String user_name, BigInteger user_id) {
		pm_userMapper.updateUserRealname(user_id, user_name);
	}

	@FunctionDescriber(shortName = "修改用户密码", description = "暂无", prerequisite = "暂无")
	public void updateUserPassword(@Valid String user_password, BigInteger user_id) {
		pm_userMapper.updateUserPassword(user_id, user_password);
	}

	@FunctionDescriber(shortName = "修改用户手机号", description = "暂无", prerequisite = "暂无")
	public void updateUserPhone(@Valid String user_phone, BigInteger user_id) {
		pm_userMapper.updateUserPhone(user_id, user_phone);
	}

	@FunctionDescriber(shortName = "修改用户邮箱", description = "暂无", prerequisite = "暂无")
	public void updateUserEmail(@Valid String user_email, BigInteger user_id) {
		pm_userMapper.updateUserEmail(user_id, user_email);
	}

	/***************************** 耿明泽 ***********************************/
	/***************************** 刘天琪 ***********************************/
	@FunctionDescriber(shortName = "根据用户id展示该用户信息", description = "暂无", prerequisite = "暂无")
	public com.cn.models.Pm_user queryById(BigInteger user_id) {
		return (Pm_user) pm_userMapper.queryById(user_id);
	}

	@FunctionDescriber(shortName = "展示所有的用户", description = "暂无", prerequisite = "暂无")
	public java.util.List<com.cn.models.Pm_user> getUsers() {
		return pm_userMapper.getUsers();
	}

	@FunctionDescriber(shortName = "根据用户id更新用户信息", description = "暂无", prerequisite = "暂无")
	public java.lang.Integer updatePm_user(@Valid String user_id, String user_name, String user_realname,
			String user_password, String user_phone, String user_email, int role_id, int department_id) {
		Pm_user user = new Pm_user();
		user.setUser_id(Integer.parseInt(user_id));
		user.setUser_name(user_name);
		user.setUser_realname(user_realname);
		user.setUser_password(user_password);
		user.setUser_phone(user_phone);
		user.setUser_email(user_email);
		user.setDepartment_id(department_id);
		user.setRole_id(role_id);
		return pm_userMapper.updatePm_user(user);

	}
	/***************************** 刘天琪 ***********************************/

}