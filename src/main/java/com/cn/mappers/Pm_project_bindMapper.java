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

import com.cn.models.Pm_project_bind;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_project_bindMapper {
	@Insert("INSERT INTO pm_project_bind(project_id,project_bd, project_sup) VALUES(#{project_id},#{project_bd},#{project_sup})") 
	@FunctionDescriber(shortName = "添加项目约束和假设")
	public void addProjectBind(Pm_project_bind pm_project_bind);
	
	@Select("select * from pm_project_bind where project_id=#{project_id}")
	@ResultType(Pm_project_bind.class)
	@FunctionDescriber(shortName = "根据项目id查询约束和假设")
	Pm_project_bind queryById(@Param("project_id") BigInteger  project_id);
	
    @Delete("delete from pm_project_bind where project_id=#{project_id}")
	@FunctionDescriber(shortName = "根据Id删除系统的约束与假设")
	public void deleteProjectBind(Pm_project_bind pm_project_bind);
    
    @Update("update pm_project_bind set project_bd=#{project_bd},project_sup=#{project_sup} where project_id=#{project_id}")
    @ResultType(BigInteger.class)
    @FunctionDescriber(shortName = "根据id更新系统的约束和假设")
    Integer updateProjectBind(Pm_project_bind pm_project_bind);
    
	@Select("select * from pm_project_bind")
	@FunctionDescriber(shortName = "展示所有的系统约束和假设信息")
	public List<Pm_project_bind> getPm_project_bind();


}
