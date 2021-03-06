package com.toy.data.generate;

import com.toy.model.generate.Gift;
import com.toy.model.generate.GiftExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int countByExample(GiftExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int deleteByExample(GiftExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int insert(Gift record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int insertSelective(Gift record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	List<Gift> selectByExample(GiftExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	Gift selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int updateByExampleSelective(@Param("record") Gift record, @Param("example") GiftExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int updateByExample(@Param("record") Gift record, @Param("example") GiftExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int updateByPrimaryKeySelective(Gift record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table gift
	 * @mbggenerated  Thu Dec 17 23:07:56 CST 2015
	 */
	int updateByPrimaryKey(Gift record);
}