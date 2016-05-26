package com.toy.data.generate;

import com.toy.model.generate.UserCoin;
import com.toy.model.generate.UserCoinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCoinMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int countByExample(UserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int deleteByExample(UserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int insert(UserCoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int insertSelective(UserCoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    List<UserCoin> selectByExample(UserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    UserCoin selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int updateByExampleSelective(@Param("record") UserCoin record, @Param("example") UserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int updateByExample(@Param("record") UserCoin record, @Param("example") UserCoinExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int updateByPrimaryKeySelective(UserCoin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_coin
     *
     * @mbggenerated Wed Dec 16 22:26:23 CST 2015
     */
    int updateByPrimaryKey(UserCoin record);
}