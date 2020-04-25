package com.cn.services;

import java.math.BigInteger;
/**

 * @author GMZ

 * @since 2020.4.8

 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.mappers.Pm_memberMapper;
import com.cn.models.Pm_member;
import com.cn.models.Pm_user;
import com.github.tools.annotations.api.FunctionDescriber;
import com.github.webfrk.core.HttpBodyHandler;
import com.github.tools.annotations.ServiceDefinition;

@ServiceDefinition
public class Pm_memberService extends HttpBodyHandler {

	@Autowired
	private Pm_memberMapper pm_memberMapper;

	/***************************** 耿明泽 ***********************************/

	/* 展示某一项目所有成员的信息 */
	@FunctionDescriber(shortName = "展示某一项目所有成员的信息", description = "暂无", prerequisite = "暂无")
	public java.util.List<com.cn.models.Pm_member> getPm_member(BigInteger project_id) {
		return pm_memberMapper.getPm_member(project_id);
	}

	/* 查询用户进入项目得权限，返回角色ID，让前台判断是不是PO */
	@FunctionDescriber(shortName = "查询用户进入项目得权限", description = "暂无", prerequisite = "暂无")
	public java.lang.Integer getRoleById(BigInteger project_id, BigInteger user_id) {
		System.out.println(pm_memberMapper.getMemberRoleById(project_id, user_id));
		if (pm_memberMapper.getMemberRoleById(project_id, user_id) == null) {
			// 若用户没有在当前项目中成员列表查询到角色，就去查用户表里的角色。再返回对应的角色
			return pm_memberMapper.getUserRoleById(user_id);
		} else {
			// 返回用户在当前项目中成员列表对应的角色
			return pm_memberMapper.getMemberRoleById(project_id, user_id);
		}
	}

	/* 成员列表展示没有进入项目的所有用户信息--PO/SM */
	@FunctionDescriber(shortName = "成员列表展示没有进入项目的所有用户信息", description = "暂无", prerequisite = "暂无")
	public java.util.List<com.cn.models.Pm_user> getInviteMembers(BigInteger project_id, BigInteger userRole_id) {
		// 进入当前项目的所有成员
		List<Pm_member> pm_merbers = pm_memberMapper.getPm_member(project_id);
		// 查询所有用户
		List<Pm_user> pm_users = pm_memberMapper.getPm_user();
		// 存入已被分配部门的成员或客户----此时不涉及成员是否进入项目中
		List<Pm_user> users = new ArrayList<Pm_user>();
		// 像前台返回没有进入项目的所有用户信息
		List<Pm_user> userlist = new ArrayList<Pm_user>();
		//将BigInteger转换成String类型
		String userRoleid=String.valueOf(userRole_id);
		for (Pm_user pm_user : pm_users) {
			if (pm_user.getUser_state().equals("0")) {// 用户账号使用中
				// 是为了判断用户是否被分配了部门
				String departmentId = String.valueOf(pm_user.getDepartment_id());
				if (userRoleid.equals("5")) { // 判断哪些用户是PO可以选的，只选已被分配部门的成员和客户----此时不涉及成员是否进入项目中
					if (!departmentId.equals("0") || pm_user.getRole_id() == 8) {
						System.out.println(pm_user.getUser_id());
						// 角色为财务主管的用户不被PO/SM选入成员
						if (pm_user.getRole_id() != 3) {
							users.add(pm_user);
						}
					}
				} else if (userRoleid.equals("6")) { // 判断哪些用户是SM可以选的，只选已被分配部门的成员----此时不涉及成员是否进入项目中
					if (!departmentId.equals("0")) {
						System.out.println(pm_user.getUser_id());
						// 角色为财务主管的用户不被PO/SM选入成员
						if (pm_user.getRole_id() != 3) {
							users.add(pm_user);
						}
					}
				}
			}

		}
		// 向前台返回没有进入项目的所有用户信息
		for (Pm_user user : users) {
			for (int i = 0; i < pm_merbers.size(); i++) {
				// 判断用户是否成为某项目的成员
				if (i < pm_merbers.size() - 1) {
					if (user.getUser_id() == pm_merbers.get(i).getUser_id()) {
						break;
					}
				} else {// 最后一次
					if (user.getUser_id() == pm_merbers.get(i).getUser_id()) {
						break;
					} else {
						userlist.add(user);
					}
				}
			}

		}
		return userlist;
	}

	/* 判断当前项目是否已存在SM */
	@FunctionDescriber(shortName = "判断当前项目是否已存在SM", description = "暂无", prerequisite = "暂无")
	public Integer getMemberSM(BigInteger project_id) {
		List<Integer> role_ids = pm_memberMapper.getMemberRoles(project_id);
		for (Integer role_id : role_ids) {
			if (role_id == 6) {
				return 0;// 已存在SM
			}
		}
		return 1;// 没有存在SM
	}

	/* 添加成员 */
	@FunctionDescriber(shortName = "添加成员", description = "暂无", prerequisite = "暂无")
	public void addPm_member(BigInteger project_id, BigInteger user_id, BigInteger userRole_id) {
		// 先查询要添加的用户在pm_user用户表当中是什么角色
		// Integer i=Integer.valueOf(project_id.toString());
		System.out.println(userRole_id);

		int role_id = pm_memberMapper.getUserRoleById(user_id);
		if (role_id == 8) {
			pm_memberMapper.addPm_member(project_id, user_id, role_id);// =======PO要添加客户
		} else if (Integer.valueOf(userRole_id.toString()) == 5) {
			// 再将角色放入pm_成员表
			pm_memberMapper.addPm_member(project_id, user_id, 6);// =======PO要添加SM
		} else {
			pm_memberMapper.addPm_member(project_id, user_id, 7);// =======SM要添加开发人员
		}

	}

	/* 修改角色 */
	@FunctionDescriber(shortName = "修改角色", description = "暂无", prerequisite = "暂无")
	public void updateMemberRole(BigInteger project_id, BigInteger user_id,BigInteger memberUser_id) {
		System.out.println("user_id"+user_id);
		System.out.println("memberUser_id"+memberUser_id);
		pm_memberMapper.updateMemberRole(project_id, user_id,7);
		pm_memberMapper.updateMemberRole(project_id, memberUser_id,5);
	}

	/* 移除成员 */
	@FunctionDescriber(shortName = "移除成员", description = "暂无", prerequisite = "暂无")
	public void deletePm_member(BigInteger project_id, BigInteger user_id) {
		pm_memberMapper.deletePm_member(project_id, user_id);
	}
	/***************************** 耿明泽 ***********************************/
}