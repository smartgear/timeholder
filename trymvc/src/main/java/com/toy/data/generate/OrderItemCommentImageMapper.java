package com.toy.data.generate;

import com.toy.model.generate.OrderItemCommentImage;
import com.toy.model.generate.OrderItemCommentImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderItemCommentImageMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int countByExample(OrderItemCommentImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int deleteByExample(OrderItemCommentImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int insert(OrderItemCommentImage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int insertSelective(OrderItemCommentImage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	List<OrderItemCommentImage> selectByExample(OrderItemCommentImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	OrderItemCommentImage selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByExampleSelective(@Param("record") OrderItemCommentImage record,
			@Param("example") OrderItemCommentImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByExample(@Param("record") OrderItemCommentImage record,
			@Param("example") OrderItemCommentImageExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByPrimaryKeySelective(OrderItemCommentImage record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table order_item_comment_image
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	int updateByPrimaryKey(OrderItemCommentImage record);
}