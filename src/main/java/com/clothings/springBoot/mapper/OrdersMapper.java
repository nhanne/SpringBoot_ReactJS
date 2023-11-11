package com.clothings.springBoot.mapper;

import com.clothings.springBoot.model.Orders;
import com.clothings.springBoot.model.OrdersExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrdersMapper {
	long countByExample(OrdersExample example);

	int deleteByExample(OrdersExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Orders row);

	int insertSelective(Orders row);

	List<Orders> selectByExample(OrdersExample example);

	Orders selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("row") Orders row, @Param("example") OrdersExample example);

	int updateByExample(@Param("row") Orders row, @Param("example") OrdersExample example);

	int updateByPrimaryKeySelective(Orders row);

	int updateByPrimaryKey(Orders row);

	List<Map<String, Object>> getOrders(Map<String, Object> param);
	
	void insertOrder(Map<String, Object> params);
	
	void updateOrder(Map<String, Object> params);
}