package com.toy.data.generate;

import com.toy.model.generate.Image;
import com.toy.model.generate.ImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int countByExample(ImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int deleteByExample(ImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int insert(Image record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int insertSelective(Image record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	List<Image> selectByExample(ImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	Image selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int updateByExampleSelective(@Param("record") Image record, @Param("example") ImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int updateByExample(@Param("record") Image record, @Param("example") ImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int updateByPrimaryKeySelective(Image record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table image
	 * @mbggenerated  Tue Feb 16 13:20:25 CST 2016
	 */
	int updateByPrimaryKey(Image record);
}