/**
 * Copyrigt (2020, ) Institute of Software, Chinese Academy of Sciences
 */
package com.cn.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.mappers.Pm_versionMapper;
import com.cn.models.Pm_version;
import com.github.tools.annotations.api.FunctionDescriber;
import com.github.webfrk.core.HttpBodyHandler;
import com.github.tools.annotations.ServiceDefinition;
import javax.validation.*;
import java.math.BigInteger;
import javax.validation.constraints.*;

/**
 * This code is auto-generated by <code>ServiceGenerator<code>
 *
 */
@ServiceDefinition
public class Pm_versionService extends HttpBodyHandler {

	@Autowired
	private Pm_versionMapper pm_versionMapper;
	@FunctionDescriber(shortName = "创建发布计划", description = "暂无", prerequisite = "暂无")
	public void addPm_version(@Valid Pm_version pm_version) {
		//项目id还不能获取，先写死
		 //pm_version.setProject_id(1);
		 pm_versionMapper.addPm_version(pm_version);
	}

	@FunctionDescriber(shortName = "修改发布计划", description = "暂无", prerequisite ="暂无")
	public Integer updatePm_version(@Valid String version_id, String version_name, String version_desc, String version_stime, String version_ptime,String version_state) {
		Pm_version version = new Pm_version();
		version.setVersion_id(Integer.parseInt(version_id));
		version.setVersion_name(version_name);
		version.setVersion_desc(version_desc);
		version.setVersion_stime(version_stime);
		version.setVersion_ptime(version_ptime);
		version.setVersion_state(version_state);
		return pm_versionMapper.updatePm_version(version);
	}
	
	/*
	 * @FunctionDescriber(shortName = "修改发布计划", description = "暂无", prerequisite ="暂无") 
	 * public void updatePm_version(@Valid Pm_version pm_version) {
	 * pm_versionMapper.updatePm_version(pm_version); }
	 */
	
	
	  @FunctionDescriber(shortName = "根据id删除发布计划", description = "暂无", prerequisite= "暂无") 
	  public void deletePm_version(@Valid Pm_version pm_version) {
		  pm_versionMapper.deletePm_version(pm_version);
	  }
	 

	@FunctionDescriber(shortName = "根据id获取到发布计划的发布名称、发布备注，发布开始时间，发布时间、发布状态，用户故事内容", description = "暂无", prerequisite = "暂无")
	public com.cn.models.Pm_version listPm_version(BigInteger version_id) {
		return pm_versionMapper.listPm_version(version_id);
	}

	@FunctionDescriber(shortName = "展示（本项目）发布计划信息", description = "暂无", prerequisite = "暂无")
	public java.util.List<com.cn.models.Pm_version> queryPm_version(BigInteger project_id) {
		return pm_versionMapper.queryPm_version(project_id);
	}
	
	@FunctionDescriber(shortName = "展示（本项目）用户故事内容信息", description = "暂无", prerequisite = "暂无")
	public java.util.List<com.cn.models.Pm_story> getPm_story() {
		return pm_versionMapper.getPm_story();
	}

}