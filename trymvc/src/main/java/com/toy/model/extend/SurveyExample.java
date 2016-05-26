package com.toy.model.extend;

public class SurveyExample extends com.toy.model.generate.SurveyExample {
	protected Limit limitClause = null;

	public Limit getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(Limit limitClause) {
		this.limitClause = limitClause;
	}
}
