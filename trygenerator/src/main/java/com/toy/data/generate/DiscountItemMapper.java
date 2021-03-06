package com.toy.data.generate;

import com.toy.model.generate.DiscountItem;
import com.toy.model.generate.DiscountItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiscountItemMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int countByExample(DiscountItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int deleteByExample(DiscountItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int insert(DiscountItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int insertSelective(DiscountItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	List<DiscountItem> selectByExample(DiscountItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	DiscountItem selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByExampleSelective(@Param("record") DiscountItem record, @Param("example") DiscountItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByExample(@Param("record") DiscountItem record, @Param("example") DiscountItemExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByPrimaryKeySelective(DiscountItem record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table discount_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByPrimaryKey(DiscountItem record);
}