package com.cn.mappers;

import java.math.BigInteger;
import java.util.List;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cn.models.Pm_department;
import com.cn.models.Pm_project;
import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_userMapper {
	
	/*****************************耿明泽***********************************/
	
	  @Select("select department_id from pm_user user_id=#{user_id}")
	  @FunctionDescriber(shortName = "查询用户所在部门") 
	  public Integer getDepartmentId(BigInteger user_id);
	  
	  @Select("select user_id from pm_user department_id=#{department_id}")
	  @FunctionDescriber(shortName = "查询某个部门下所有用户") 
	  public List<Integer> getDepartmentUserIds(Integer department_id);
	  
	/*****************************耿明泽***********************************/

}
