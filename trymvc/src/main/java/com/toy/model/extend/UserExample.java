package com.toy.model.extend;

public class UserExample extends com.toy.model.generate.UserExample {

	protected Limit limitClause = null;

	public Limit getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(Limit limitClause) {
		this.limitClause = limitClause;
	}
}