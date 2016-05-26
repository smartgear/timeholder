package com.toy.data.generate;

import com.toy.model.generate.GiftImageExample;
import com.toy.model.generate.GiftImageKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GiftImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int countByExample(GiftImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int deleteByExample(GiftImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int deleteByPrimaryKey(GiftImageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int insert(GiftImageKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int insertSelective(GiftImageKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    List<GiftImageKey> selectByExample(GiftImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") GiftImageKey record, @Param("example") GiftImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table gift_image
     *
     * @mbggenerated Tue Feb 16 13:20:25 CST 2016
     */
    int updateByExample(@Param("record") GiftImageKey record, @Param("example") GiftImageExample example);
}