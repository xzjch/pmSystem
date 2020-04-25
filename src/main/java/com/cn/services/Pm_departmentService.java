/**

 * @author GMZ

 * @since 2020.4.8

 */
package com.cn.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.mappers.Pm_departmentMapper;
import com.cn.models.Pm_department;
import com.github.tools.annotations.api.FunctionDescriber;
import com.github.webfrk.core.HttpBodyHandler;
import com.github.tools.annotations.ServiceDefinition;


@ServiceDefinition
public class Pm_departmentService extends HttpBodyHandler {

	@Autowired
	private Pm_departmentMapper pm_departmentMapper;
	
	/*****************************耿明泽***********************************/
	/*
	 * @FunctionDescriber(shortName = "查询所有部门下的所有的用户", description = "暂无",
	 * prerequisite = "暂无") public com.cn.models.Pm_department
	 * queryDepartmentUsers() { return pm_departmentMapper.queryDepartmentUsers(); }
	 */
	/*****************************耿明泽***********************************/

}