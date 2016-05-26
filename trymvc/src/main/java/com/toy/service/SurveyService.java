package com.toy.service;

import java.util.List;

import com.toy.model.generate.Survey;

public interface SurveyService {
	public Survey addSurvey(Survey survey) throws ToyException;
	
	public int getSurveyCount() throws ToyException;
	
	public List<Survey> listSurvey(int count, int page) throws ToyException;
	
	public List<Survey> findSurveyByName(String name) throws ToyException;
	
	public Survey getSurveyById(String id) throws ToyException;
	
	public Survey updateSurvey(Survey survery) throws ToyException;
}
