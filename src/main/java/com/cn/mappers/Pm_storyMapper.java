package com.cn.mappers;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.models.Pm_story;
import com.github.tools.annotations.api.FunctionDescriber;



@Mapper
public interface Pm_storyMapper {

	//@Insert("INSERT INTO pm_story(story_con,story_not,story_stan,story_pri,story_state,lane_id,project_id) VALUES(#{story_con},#{story_not},#{story_stan},#{story_pri},#{story_state},#{lane_id},#{project_id})")
	@Insert("INSERT INTO pm_story(story_con,story_not,story_stan,project_id) VALUES(#{story_con},#{story_not},#{story_stan},#{project_id})")
	
	@FunctionDescriber(shortName = "添加用户故事")
	public void addPmStory(Pm_story pm_story);
	
	
	@Select("select story_con,story_not,story_stan,story_pri,story_state,lane_id from pm_story where story_id=#{story_id}")
	@ResultType(Pm_story.class)  
	@FunctionDescriber(shortName = "根据id查询用户故事")
	public Pm_story getPmStory(@Param("story_id") Integer story_id);
	
	
	/*
	 * @Select("select * from pm_story where lane_id=#{lane_id} and project_id=#{project_id}"
	 * )
	 * 
	 * @FunctionDescriber(shortName = "根据泳道id和项目id查询用户故事") public Pm_story
	 * getLaneStory(Pm_story pm_story);
	 */
	 @Select("select * from pm_story where lane_id=#{lane_id} and project_id=#{project_id}")
	
	 @FunctionDescriber(shortName = "根据泳道id和项目id查询用户故事") 
	 public Pm_story getLaneStory(@Param("lane_id") Integer lane_id,@Param("project_id") Integer project_id);
	
	
	@Delete("delete from pm_story where story_id=#{story_id}")
	
	@FunctionDescriber(shortName = "根据Id删除用户故事")
	public void deletePmStory(Pm_story pm_story);
	
	
    @Update("update pm_story set story_con=#{story_con},story_not=#{story_not},story_stan=#{story_stan},story_pri=#{story_pri} where story_id=#{story_id}")
	
	@FunctionDescriber(shortName = "根据id更新用户故事")
	public void updatePmStory(Pm_story pm_story);
    
    
}
