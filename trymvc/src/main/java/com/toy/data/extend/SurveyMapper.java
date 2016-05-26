package com.toy.data.extend;

import java.util.List;

import com.toy.model.extend.SurveyExample;
import com.toy.model.generate.Survey;

public interface SurveyMapper extends com.toy.data.generate.SurveyMapper {
	List<Survey> selectByExampleWithLimit(SurveyExample example);
}
