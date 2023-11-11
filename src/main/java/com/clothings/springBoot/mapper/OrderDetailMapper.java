package com.clothings.springBoot.mapper;

import com.clothings.springBoot.model.OrderDetail;
import com.clothings.springBoot.model.OrderDetailExample;
import com.clothings.springBoot.model.OrderDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	long countByExample(OrderDetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int deleteByExample(OrderDetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int deleteByPrimaryKey(OrderDetailKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int insert(OrderDetail row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int insertSelective(OrderDetail row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	List<OrderDetail> selectByExample(OrderDetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	OrderDetail selectByPrimaryKey(OrderDetailKey key);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int updateByExampleSelective(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int updateByExample(@Param("row") OrderDetail row, @Param("example") OrderDetailExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int updateByPrimaryKeySelective(OrderDetail row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table orderdetail
	 * @mbg.generated  Mon Nov 06 16:24:17 ICT 2023
	 */
	int updateByPrimaryKey(OrderDetail row);
}