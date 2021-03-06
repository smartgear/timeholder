package com.toy.data.generate;

import com.toy.model.generate.Task;
import com.toy.model.generate.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int countByExample(TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int deleteByExample(TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int insert(Task record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int insertSelective(Task record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	List<Task> selectByExample(TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	Task selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int updateByPrimaryKeySelective(Task record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	int updateByPrimaryKey(Task record);
}