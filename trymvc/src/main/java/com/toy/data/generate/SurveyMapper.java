package com.toy.data.generate;

import com.toy.model.generate.Survey;
import com.toy.model.generate.SurveyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int countByExample(SurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int deleteByExample(SurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int insert(Survey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int insertSelective(Survey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    List<Survey> selectByExample(SurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    Survey selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int updateByExampleSelective(@Param("record") Survey record, @Param("example") SurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int updateByExample(@Param("record") Survey record, @Param("example") SurveyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int updateByPrimaryKeySelective(Survey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table survey
     *
     * @mbggenerated Thu Feb 18 09:02:10 CST 2016
     */
    int updateByPrimaryKey(Survey record);
}