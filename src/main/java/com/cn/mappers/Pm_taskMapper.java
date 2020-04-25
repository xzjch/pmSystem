package com.cn.mappers;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cn.models.Pm_iteration;
import com.cn.models.Pm_task;
import com.cn.models.Pm_version;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_taskMapper {
	//在某个用户故事中录入任务
	@Insert("INSERT INTO pm_task(task_con, task_esti, task_pri, task_desc,story_id) "
			+ "VALUES(#{task_con}, #{task_esti}, #{task_pri}, #{task_desc},#{story_id})")
	@FunctionDescriber(shortName = "录入任务")
	public void addPm_task(Pm_task pm_task);
	
	//根据用户故事id展示该用户故事的任务
	@Select("select * from pm_task where story_id =#{story_id}")
	@FunctionDescriber(shortName = "根据用户故事id展示该用户故事的任务")
	public List<Pm_task> listPm_task(BigInteger story_id);
	
	//根据任务id删除任务
	@Delete("delete from pm_task where task_id = #{task_id}")
	@FunctionDescriber(shortName = "根据任务id删除任务")
	public void deletePm_task(Pm_task pm_task);

	
}
