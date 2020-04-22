package com.cn.mappers;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cn.models.Pm_department;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_departmentMapper {
	
	/*****************************耿明泽***********************************/
	@Select("select user_id from pm_department")
	@FunctionDescriber(shortName = "查询所有部门下的所有的用户")
	public Pm_department queryDepartmentUsers();
	/*****************************耿明泽***********************************/

}
