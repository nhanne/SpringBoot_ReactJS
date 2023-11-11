package com.clothings.springBoot.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.clothings.springBoot.model.OrderDetail;
import com.clothings.springBoot.model.OrderDetailExample;
import com.clothings.springBoot.model.OrderDetailKey;

@Mapper
public interface OrderDetailMapper {
	long countByExample(OrderDetailExample example);

	int deleteByExample(OrderDetailExample example);

	int deleteByPrimaryKey(OrderDetailKey key);

	int insert(OrderDetail row);

	int insertSelective(OrderDetail row);

	List<OrderDetail> selectByExample(OrderDetailExample example);

	OrderDetail selectByPrimaryKey(OrderDetailKey key);

	int updateByExampleSelective(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

	int updateByExample(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

	int updateByPrimaryKeySelective(OrderDetail row);

	int updateByPrimaryKey(OrderDetail row);
	
	void insertDetail(Map<String, Object> params);
	
	List<Map<String, Object>> getOrderDetail(Map<String, Object> param);
}