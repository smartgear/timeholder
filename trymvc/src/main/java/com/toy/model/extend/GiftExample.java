package com.toy.model.extend;

public class GiftExample extends com.toy.model.generate.GiftExample {
	protected Limit limitClause = null;

	public Limit getLimitClause() {
		return limitClause;
	}

	public void setLimitClause(Limit limitClause) {
		this.limitClause = limitClause;
	}
}
