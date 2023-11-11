package com.clothings.springBoot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.clothings.springBoot.model.Product;
import com.clothings.springBoot.model.ProductExample;

@Mapper
public interface ProductMapper {
	long countByExample(ProductExample example);

	int deleteByExample(ProductExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Product row);

	int insertSelective(Product row);

	List<Product> selectByExample(ProductExample example);

	Product selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("row") Product row, @Param("example") ProductExample example);

	int updateByExample(@Param("row") Product row, @Param("example") ProductExample example);

	int updateByPrimaryKeySelective(Product row);

	int updateByPrimaryKey(Product row);

	List<Map<String, Object>> getProducts(Map<String, Object> param);

	List<Map<String, Object>> getProductById(Integer productId);

	Product productCart(Integer productId);

	void insertProduct(Map<String, Object> params);

	void deleteProductById(Integer productId);

}