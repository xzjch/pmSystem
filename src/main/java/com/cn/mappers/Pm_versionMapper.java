package com.cn.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.cn.models.Pm_version;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_versionMapper {
	//发布计划表
	  @Insert("INSERT INTO pm_version(version_name, version_desc, version_stime, version_ptime) VALUES(#{version_name}, #{version_desc}, #{version_stime}, #{version_ptime})")
	  @FunctionDescriber(shortName = "创建发布计划")
	  public void addPm_version(Pm_version pm_version);

      @Update("Update pm_version SET version_name = #{version_name}, version_desc = #{version_desc}, version_stime = #{version_stime}, version_ptime = #{version_ptime}, version_state = #{version_state}, story_con = #{story_con} where version_id = #{version_id}")
	  @FunctionDescriber(shortName = "修改发布计划")
	  public void updatePm_version(Pm_version pm_version);
      
      @Delete("delete from pm_version where version_id = #{version_id}")
  	  @FunctionDescriber(shortName = "根据id删除发布计划")
  	  public void deletePm_version(Pm_version pm_version);
      
	
	  @Select("select version_name, version_ptime, version_state from pm_version where version_id = #{version_id}")
	  @ResultType(Pm_version.class)
	  @FunctionDescriber(shortName = "根据id获取到发布计划的发布名称、预计发布时间、发布状态") 
	  Pm_version queryPm_version(@Param("version_id") Integer version_id);
	  
	  @Select("select version_name, version_desc, version_stime, version_ptime, version_state, story_con from pm_version where version_id = #{version_id}")
	  @ResultType(Pm_version.class)
	  @FunctionDescriber(shortName ="根据id获取到发布计划的发布名称、发布备注，发布开始时间，发布时间、发布状态，用户故事内容") 
	  Pm_version listPm_version(@Param("version_id") Integer version_id);
	 
	/*
	 *用户故事表
	 * @Select("select story_con from pm_story where story_id = #{story_id}") 
	 * @FunctionDescriber(shortName = "根据用户故事id获取到用户故事内容") 
	 * public List<String> listPm_story(Pm_story pm_story);
	 */
       
	  
}

