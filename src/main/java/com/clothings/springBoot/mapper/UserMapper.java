package com.clothings.springBoot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clothings.springBoot.model.User;
import com.clothings.springBoot.model.UserExample;

public interface UserMapper {
	long countByExample(UserExample example);
	int deleteByExample(UserExample example);
	int insert(User row);
	int insertSelective(User row);
	List<User> selectByExample(UserExample example);
	int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);
	int updateByExample(@Param("row") User row, @Param("example") UserExample example);
}