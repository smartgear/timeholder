package com.toy.data.generate;

import com.toy.model.generate.UserToken;
import com.toy.model.generate.UserTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int countByExample(UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int deleteByExample(UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int insert(UserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int insertSelective(UserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    List<UserToken> selectByExample(UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    UserToken selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int updateByExampleSelective(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int updateByExample(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int updateByPrimaryKeySelective(UserToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    int updateByPrimaryKey(UserToken record);
}