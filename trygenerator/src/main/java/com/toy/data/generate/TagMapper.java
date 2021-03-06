package com.toy.data.generate;

import com.toy.model.generate.Tag;
import com.toy.model.generate.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int countByExample(TagExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int deleteByExample(TagExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int insert(Tag record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int insertSelective(Tag record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	List<Tag> selectByExample(TagExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	Tag selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByPrimaryKeySelective(Tag record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByPrimaryKey(Tag record);
}