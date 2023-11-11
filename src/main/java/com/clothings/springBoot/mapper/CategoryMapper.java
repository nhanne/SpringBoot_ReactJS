package com.clothings.springBoot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.clothings.springBoot.model.Category;
import com.clothings.springBoot.model.CategoryExample;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
	long countByExample(CategoryExample example);
	int deleteByExample(CategoryExample example);
	int deleteByPrimaryKey(Integer id);
	int insert(Category row);
	int insertSelective(Category row);
	List<Category> selectByExample(CategoryExample example);
	Category selectByPrimaryKey(Integer id);
	int updateByExampleSelective(@Param("row") Category row, @Param("example") CategoryExample example);
	int updateByExample(@Param("row") Category row, @Param("example") CategoryExample example);
	int updateByPrimaryKeySelective(Category row);
	int updateByPrimaryKey(Category row);

	List<Map<String, Object>> getCategories();
	
}