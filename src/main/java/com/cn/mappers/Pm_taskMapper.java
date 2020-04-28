package com.cn.mappers;

import java.math.BigInteger;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
	
	//刘天琪
	//根据迭代id展示该迭代的所有任务
		@Select("select * from pm_task where iteration_id =#{iteration_id}")
		@ResultType(Pm_task.class)
		@FunctionDescriber(shortName = "根据迭代id展示该任务")
		public List<Pm_task> listPm_task1(BigInteger iteration_id);
		
		//根据任务id展示该任务
//		@Select("select task_con, task_esti,task_pri,task_state,task_desc from pm_task where task_id=#{task_id}")
		@Select("select * from pm_task where task_id=#{task_id}")
		@ResultType(Pm_task.class)
		@FunctionDescriber(shortName = "根据任务id展示该任务")
		Pm_task queryById(@Param("task_id") BigInteger task_id);
		
		//根据任务id更新任务
		//卢添加lane_id
		@Update("update pm_task set lane_id=#{lane_id},task_con=#{task_con},task_desc=#{task_desc},task_esti=#{task_esti},task_pri=#{task_pri},task_state=#{task_state} where task_id = #{task_id}")
		@ResultType(BigInteger.class)
		@FunctionDescriber(shortName = "根据任务id更新任务")
		Integer updatePm_task(Pm_task pm_task);
		
		//邢娇娇
		//根据迭代id和泳道id查询任务
			@Select("select * from pm_task where lane_id=#{lane_id} and iteration_id=#{iteration_id}")
			@FunctionDescriber(shortName = "根据迭代id和泳道id查询任务") 
			public List<Pm_task> getProLaneTask(@Param("lane_id") BigInteger lane_id,@Param("iteration_id") BigInteger iteration_id);
		
	
}
