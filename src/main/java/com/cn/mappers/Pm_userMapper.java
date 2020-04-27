package com.cn.mappers;

import java.math.BigInteger;

/**

 * @author GMZ

 * @since 2020.4.8

 */
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.github.tools.annotations.api.FunctionDescriber;

@Mapper
public interface Pm_userMapper {
	
	/*****************************耿明泽***********************************/
	
	  @Select("select department_id from pm_user where user_id=#{user_id} ")
	  @FunctionDescriber(shortName = "查询用户所在部门") 
	  public Integer getDepartmentId(BigInteger user_id);
	  
	  
	/*****************************耿明泽***********************************/

}
