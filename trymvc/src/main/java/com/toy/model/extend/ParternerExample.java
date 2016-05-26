package com.toy.model.extend;

public class ParternerExample extends com.toy.model.generate.ParternerExample {
	protected Limit limitClause = null;

	public Limit getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(Limit limitClause) {
		this.limitClause = limitClause;
	}
}
