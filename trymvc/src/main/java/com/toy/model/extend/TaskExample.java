package com.toy.model.extend;

public class TaskExample extends com.toy.model.generate.TaskExample {

	protected Limit limitClause = null;

	public Limit getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(Limit limitClause) {
		this.limitClause = limitClause;
	}

}
