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

import com.cn.models.Pm_story;
import com.cn.models.Pm_version;
import com.github.tools.annotations.api.FunctionDescriber;

/* 必须标注Mapper注解
 * 必须注明SQL (Insert, Select)
 * 必须FunctionDescriber注解，用于文档生成
*/

@Mapper
public interface Pm_versionMapper {
	// 发布计划表
	// 创建发布计划(本项目的发布计划项目id需要获取一下)
	@Insert("INSERT INTO pm_version(version_name, version_desc, version_stime, version_ptime,project_id) "
			+ "VALUES(#{version_name}, #{version_desc}, #{version_stime}, #{version_ptime},#{project_id})")
	@FunctionDescriber(shortName = "创建发布计划")
	public void addPm_version(Pm_version pm_version);
    //编辑发布计划
	@Update("Update pm_version SET version_name = #{version_name}, version_desc = #{version_desc}, "
			+ "version_stime = #{version_stime}, version_ptime = #{version_ptime}, version_state = #{version_state}, "
			+ "story_con = #{story_con} where version_id = #{version_id}")
	@FunctionDescriber(shortName = "修改发布计划")
	public Integer updatePm_version(Pm_version pm_version);
    //删除发布计划
	@Delete("delete from pm_version where version_id = #{version_id}")
	@FunctionDescriber(shortName = "根据id删除发布计划")
	public void deletePm_version(Pm_version pm_version);
   //展示（本项目）发布计划信息,还需要获取本项目的id
	//select * from pm_version where project_id = #{project_id}
	@Select("select * from pm_version")
	@FunctionDescriber(shortName = "展示（本项目）发布计划信息")
	public List<Pm_version> getPm_version();
    //详情页显示发布计划
	@Select("select version_name, version_desc, version_stime, version_ptime, version_state, story_con from pm_version where version_id = #{version_id}")
	@ResultType(Pm_version.class)
	@FunctionDescriber(shortName = "根据id获取到发布计划的发布名称、发布备注，发布开始时间，发布时间、发布状态，用户故事内容")
	Pm_version listPm_version(@Param("version_id") BigInteger version_id);

	 // 用户故事表
	 @Select("select * from pm_story")
	 @FunctionDescriber(shortName = "展示（本项目）用户故事内容信息") 
	 public List<Pm_story> getPm_story();
	 

}
