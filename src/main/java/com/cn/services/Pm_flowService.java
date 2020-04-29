/**
 * Copyrigt (2020, ) Institute of Software, Chinese Academy of Sciences
 */
package com.cn.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.mappers.Pm_flowMapper;
import com.cn.models.Pm_flow;
import com.github.tools.annotations.api.FunctionDescriber;
import com.github.webfrk.core.HttpBodyHandler;
import com.github.tools.annotations.ServiceDefinition;
import java.math.BigInteger;
import javax.validation.*;

/**
 * This code is auto-generated by <code>ServiceGenerator<code>
 *
 */
@ServiceDefinition
public class Pm_flowService extends HttpBodyHandler {

	@Autowired
	private Pm_flowMapper pm_flowMapper;

	@FunctionDescriber(shortName = "查询改项目所有流转规则名称", description = "暂无", prerequisite = "暂无")
	public java.util.List<com.cn.models.Pm_flow> queryFlow_rule(BigInteger project_id) {
		return pm_flowMapper.queryFlow_rule(project_id);
	}

	@FunctionDescriber(shortName = "编辑流转规则", description = "暂无", prerequisite = "暂无")
	public Integer updateFlow_rule(@Valid BigInteger flow_id,String flow_rule,String lane_name1,String flow_condition,String lane_name2,String lane_state) {
		Pm_flow flow = new Pm_flow();
		String flowid=String.valueOf(flow_id);
		flow.setFlow_id(Integer.valueOf(flowid));
		flow.setFlow_rule(flow_rule);
		flow.setLane_name1(lane_name1);
		flow.setFlow_condition(flow_condition);
		flow.setLane_name2(lane_name2);
		flow.setLane_state(lane_state);
		return pm_flowMapper.updateFlow_rule(flow);
		
	}

	@FunctionDescriber(shortName = "创建流转规则", description = "暂无", prerequisite = "暂无")
	public void addPm_flow(@Valid Pm_flow pm_flow) {
		 pm_flowMapper.addPm_flow(pm_flow);
	}

	@FunctionDescriber(shortName = "根据flow_id删除流转规则", description = "暂无", prerequisite = "暂无")
	public void deletePm_flow(BigInteger flow_id) {
		 pm_flowMapper.deletePm_flow(flow_id);
	}

	@FunctionDescriber(shortName = "查询流转内的所有字段", description = "暂无", prerequisite = "暂无")
	public com.cn.models.Pm_flow queryPm_flow(BigInteger flow_id) {
		return pm_flowMapper.queryPm_flow(flow_id);
	}

}