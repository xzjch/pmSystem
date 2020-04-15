package com.cn.services;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.tools.annotations.api.FunctionDescriber;
import com.github.webfrk.core.HttpBodyHandler;
import com.github.tools.annotations.ServiceDefinition;
import com.github.tools.annotations.api.Required;
import com.cn.mappers.Pm_projectMapper;
import com.cn.models.Pm_project;

/**
 * This code is auto-generated by <code>ServiceGenerator<code>
 *
 */
@ServiceDefinition
public class Pm_projectService extends HttpBodyHandler {

	@Autowired
	private Pm_projectMapper pm_projectMapper;

	/*
	 * @FunctionDescriber(shortName = "查询用户进入项目得权限", description = "暂无",
	 * prerequisite = "暂无") public java.util.List<com.cn.models.Pm_project>
	 * getPm_project() { return pm_projectMapper.getPm_project(); }
	 */

	@FunctionDescriber(shortName = "归档项目/取消归档项目", description = "暂无", prerequisite = "暂无")
	public void updatePm_project(Integer project_id, @Required(false) Integer project_state) {
		pm_projectMapper.updatePm_project(project_id, project_state);
	}

	@FunctionDescriber(shortName = "更新项目信息", description = "暂无", prerequisite = "暂无")
	public Integer updateProject(@Valid String project_id, String project_name, String project_spr, String project_type, String project_des,String project_men,String project_time) {
		Pm_project project = new Pm_project();
		project.setProject_id(Integer.parseInt(project_id));
		project.setProject_name(project_name);
		project.setProject_spr(project_spr);
		project.setProject_type(project_type);
		project.setProject_des(project_des);
		project.setProject_men(project_men);
		project.setProject_time(project_time);
		return pm_projectMapper.updateProject(project);
	}

	@FunctionDescriber(shortName = "添加项目信息", description = "暂无", prerequisite = "暂无")
	public void addProjectInfo(@Valid Pm_project pm_project) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pm_project.setProject_time(sdf.format(date));
		//还没有写登录，暂时直接确定创建人
		pm_project.setProject_men("魏文青");
		 pm_projectMapper.addProjectInfo(pm_project);
		 System.out.println(pm_project);
	}

	// 根据项目id查询项目信息
	@FunctionDescriber(shortName = "根据项目id查询项目信息", description = "暂无", prerequisite = "暂无")
	public com.cn.models.Pm_project queryById(BigInteger project_id) {
		return pm_projectMapper.queryById(project_id);
	}
	
	/*
	 * @FunctionDescriber(shortName = "删除项目信息", description = "暂无", prerequisite =
	 * "暂无") public void deleteProject(@Valid Pm_project pm_project) {
	 * pm_projectMapper.deleteProject(pm_project); }
	 */

	/*@FunctionDescriber(shortName = "查询所有项目", description = "暂无", prerequisite = "暂无")
	public List<Pm_project> getProjects(Integer param, Integer user_id) {
		List<Pm_project> projects = pm_projectMapper.getProjects();
		List<Pm_project> openProjects = new ArrayList<Pm_project>();
		List<Pm_project> closeProjects = new ArrayList<Pm_project>();
		List<Integer> project_ids = pm_projectMapper.project_ids(user_id);
		for (Pm_project project : projects) {

			if (project.getProject_state() == 1) {// 归档
				// 公开的
				if (project.getProject_type() == 0) {
					closeProjects.add(project);
				} else {
					// 私有的
					for (Integer project_id : project_ids) {
						// 参与的
						if (project.getProject_id() == project_id) {
							closeProjects.add(project);
						}
					}

				}
			} else {// 未归档
				if (project.getProject_type() == 0) {// 公开的
					openProjects.add(project);
				} else {// 私有的
					for (Integer project_id : project_ids) {
						// 参与的
						if (project.getProject_id() == project_id) {
							openProjects.add(project);
						}
					}
				}

			}

		}
		if (param == 0) {
			return openProjects;
		} else {
			return closeProjects;
		}

	}*/
}