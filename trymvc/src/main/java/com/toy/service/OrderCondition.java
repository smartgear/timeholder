package com.toy.service;

public class OrderCondition {
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public boolean isAsc() {
		return isAsc;
	}

	public void setAsc(boolean isAsc) {
		this.isAsc = isAsc;
	}

	private String field;
	private boolean isAsc;

	public OrderCondition(String field, boolean isAsc) {
		this.field = field;
		this.isAsc = isAsc;
	}
	
	public String  toString(){
		return field + " " + (isAsc? "ASC":"DESC");
	}
}
