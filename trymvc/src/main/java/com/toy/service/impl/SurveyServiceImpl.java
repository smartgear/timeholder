package com.toy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.toy.data.extend.SurveyMapper;
import com.toy.data.generate.IdSequenceMapper;
import com.toy.model.extend.Limit;
import com.toy.model.extend.SurveyExample;
import com.toy.model.generate.IdSequence;
import com.toy.model.generate.Survey;
import com.toy.service.SurveyService;
import com.toy.service.SurveyState;
import com.toy.service.ToyException;
import javax.annotation.Resource;

@Service("surveyService")
public class SurveyServiceImpl implements SurveyService {
	public SurveyMapper getSurveyMapper() {
		return surveyMapper;
	}

	@Resource
	public void setSurveyMapper(SurveyMapper surveyMapper) {
		this.surveyMapper = surveyMapper;
	}

	public IdSequenceMapper getIdSequenceMapper() {
		return idSequenceMapper;
	}

	@Resource
	public void setIdSequenceMapper(IdSequenceMapper idSequenceMapper) {
		this.idSequenceMapper = idSequenceMapper;
	}

	private SurveyMapper surveyMapper;
	private IdSequenceMapper idSequenceMapper; 

	public Survey addSurvey(Survey survey) throws ToyException {
		IdSequence idSequence = new IdSequence();
		idSequenceMapper.insert(idSequence);
		String surveyID = "svy" + Long.toString(idSequence.getId());
		survey.setId(surveyID);
		survey.setCreateTime(new Date());
		survey.setState(SurveyState.inactive.name());
		surveyMapper.insert(survey);
		return survey;
	}

	public int getSurveyCount() throws ToyException {
		return surveyMapper.countByExample(null);
	}

	public List<Survey> listSurvey(int count, int page) throws ToyException {
		Limit limit = new Limit();
		limit.setRowcount(count);
		limit.setOffset(count * (page - 1));
		SurveyExample example = new SurveyExample();
		example.setLimitClause(limit);
		return surveyMapper.selectByExampleWithLimit(example);
	}

	public List<Survey> findSurveyByName(String name) throws ToyException {
		SurveyExample example = new SurveyExample();
		example.createCriteria().andNameLike("%" + name + "%");
		return surveyMapper.selectByExample(example);
	}

	public Survey getSurveyById(String id) throws ToyException {
		return surveyMapper.selectByPrimaryKey(id);
	}

	public Survey updateSurvey(Survey survery) throws ToyException {
		Survey originalSurvey  = surveyMapper.selectByPrimaryKey(survery.getId());
		survery.setCreateTime(originalSurvey.getCreateTime());
		surveyMapper.updateByPrimaryKey(survery);
		return survery;
	}

}
