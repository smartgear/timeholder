package com.toy.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public TaskExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andTitleIsNull() {
			addCriterion("title is null");
			return (Criteria) this;
		}

		public Criteria andTitleIsNotNull() {
			addCriterion("title is not null");
			return (Criteria) this;
		}

		public Criteria andTitleEqualTo(String value) {
			addCriterion("title =", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotEqualTo(String value) {
			addCriterion("title <>", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThan(String value) {
			addCriterion("title >", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleGreaterThanOrEqualTo(String value) {
			addCriterion("title >=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThan(String value) {
			addCriterion("title <", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLessThanOrEqualTo(String value) {
			addCriterion("title <=", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleLike(String value) {
			addCriterion("title like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotLike(String value) {
			addCriterion("title not like", value, "title");
			return (Criteria) this;
		}

		public Criteria andTitleIn(List<String> values) {
			addCriterion("title in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotIn(List<String> values) {
			addCriterion("title not in", values, "title");
			return (Criteria) this;
		}

		public Criteria andTitleBetween(String value1, String value2) {
			addCriterion("title between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andTitleNotBetween(String value1, String value2) {
			addCriterion("title not between", value1, value2, "title");
			return (Criteria) this;
		}

		public Criteria andDetailIsNull() {
			addCriterion("detail is null");
			return (Criteria) this;
		}

		public Criteria andDetailIsNotNull() {
			addCriterion("detail is not null");
			return (Criteria) this;
		}

		public Criteria andDetailEqualTo(String value) {
			addCriterion("detail =", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailNotEqualTo(String value) {
			addCriterion("detail <>", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailGreaterThan(String value) {
			addCriterion("detail >", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailGreaterThanOrEqualTo(String value) {
			addCriterion("detail >=", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailLessThan(String value) {
			addCriterion("detail <", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailLessThanOrEqualTo(String value) {
			addCriterion("detail <=", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailLike(String value) {
			addCriterion("detail like", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailNotLike(String value) {
			addCriterion("detail not like", value, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailIn(List<String> values) {
			addCriterion("detail in", values, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailNotIn(List<String> values) {
			addCriterion("detail not in", values, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailBetween(String value1, String value2) {
			addCriterion("detail between", value1, value2, "detail");
			return (Criteria) this;
		}

		public Criteria andDetailNotBetween(String value1, String value2) {
			addCriterion("detail not between", value1, value2, "detail");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNull() {
			addCriterion("priority is null");
			return (Criteria) this;
		}

		public Criteria andPriorityIsNotNull() {
			addCriterion("priority is not null");
			return (Criteria) this;
		}

		public Criteria andPriorityEqualTo(Integer value) {
			addCriterion("priority =", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotEqualTo(Integer value) {
			addCriterion("priority <>", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThan(Integer value) {
			addCriterion("priority >", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
			addCriterion("priority >=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThan(Integer value) {
			addCriterion("priority <", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityLessThanOrEqualTo(Integer value) {
			addCriterion("priority <=", value, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityIn(List<Integer> values) {
			addCriterion("priority in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotIn(List<Integer> values) {
			addCriterion("priority not in", values, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityBetween(Integer value1, Integer value2) {
			addCriterion("priority between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
			addCriterion("priority not between", value1, value2, "priority");
			return (Criteria) this;
		}

		public Criteria andImportanceIsNull() {
			addCriterion("importance is null");
			return (Criteria) this;
		}

		public Criteria andImportanceIsNotNull() {
			addCriterion("importance is not null");
			return (Criteria) this;
		}

		public Criteria andImportanceEqualTo(Integer value) {
			addCriterion("importance =", value, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceNotEqualTo(Integer value) {
			addCriterion("importance <>", value, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceGreaterThan(Integer value) {
			addCriterion("importance >", value, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceGreaterThanOrEqualTo(Integer value) {
			addCriterion("importance >=", value, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceLessThan(Integer value) {
			addCriterion("importance <", value, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceLessThanOrEqualTo(Integer value) {
			addCriterion("importance <=", value, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceIn(List<Integer> values) {
			addCriterion("importance in", values, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceNotIn(List<Integer> values) {
			addCriterion("importance not in", values, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceBetween(Integer value1, Integer value2) {
			addCriterion("importance between", value1, value2, "importance");
			return (Criteria) this;
		}

		public Criteria andImportanceNotBetween(Integer value1, Integer value2) {
			addCriterion("importance not between", value1, value2, "importance");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Integer value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Integer value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Integer value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Integer value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Integer value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Integer value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Integer> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Integer> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Integer value1, Integer value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Integer value1, Integer value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andDuedateIsNull() {
			addCriterion("duedate is null");
			return (Criteria) this;
		}

		public Criteria andDuedateIsNotNull() {
			addCriterion("duedate is not null");
			return (Criteria) this;
		}

		public Criteria andDuedateEqualTo(Date value) {
			addCriterion("duedate =", value, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateNotEqualTo(Date value) {
			addCriterion("duedate <>", value, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateGreaterThan(Date value) {
			addCriterion("duedate >", value, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateGreaterThanOrEqualTo(Date value) {
			addCriterion("duedate >=", value, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateLessThan(Date value) {
			addCriterion("duedate <", value, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateLessThanOrEqualTo(Date value) {
			addCriterion("duedate <=", value, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateIn(List<Date> values) {
			addCriterion("duedate in", values, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateNotIn(List<Date> values) {
			addCriterion("duedate not in", values, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateBetween(Date value1, Date value2) {
			addCriterion("duedate between", value1, value2, "duedate");
			return (Criteria) this;
		}

		public Criteria andDuedateNotBetween(Date value1, Date value2) {
			addCriterion("duedate not between", value1, value2, "duedate");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNull() {
			addCriterion("createtime is null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIsNotNull() {
			addCriterion("createtime is not null");
			return (Criteria) this;
		}

		public Criteria andCreatetimeEqualTo(Date value) {
			addCriterion("createtime =", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotEqualTo(Date value) {
			addCriterion("createtime <>", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThan(Date value) {
			addCriterion("createtime >", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("createtime >=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThan(Date value) {
			addCriterion("createtime <", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
			addCriterion("createtime <=", value, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeIn(List<Date> values) {
			addCriterion("createtime in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotIn(List<Date> values) {
			addCriterion("createtime not in", values, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeBetween(Date value1, Date value2) {
			addCriterion("createtime between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
			addCriterion("createtime not between", value1, value2, "createtime");
			return (Criteria) this;
		}

		public Criteria andClosetimeIsNull() {
			addCriterion("closetime is null");
			return (Criteria) this;
		}

		public Criteria andClosetimeIsNotNull() {
			addCriterion("closetime is not null");
			return (Criteria) this;
		}

		public Criteria andClosetimeEqualTo(Date value) {
			addCriterion("closetime =", value, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeNotEqualTo(Date value) {
			addCriterion("closetime <>", value, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeGreaterThan(Date value) {
			addCriterion("closetime >", value, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeGreaterThanOrEqualTo(Date value) {
			addCriterion("closetime >=", value, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeLessThan(Date value) {
			addCriterion("closetime <", value, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeLessThanOrEqualTo(Date value) {
			addCriterion("closetime <=", value, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeIn(List<Date> values) {
			addCriterion("closetime in", values, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeNotIn(List<Date> values) {
			addCriterion("closetime not in", values, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeBetween(Date value1, Date value2) {
			addCriterion("closetime between", value1, value2, "closetime");
			return (Criteria) this;
		}

		public Criteria andClosetimeNotBetween(Date value1, Date value2) {
			addCriterion("closetime not between", value1, value2, "closetime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table task
	 * @mbggenerated  Mon May 30 23:47:37 CST 2016
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table task
     *
     * @mbggenerated do_not_delete_during_merge Mon May 30 22:49:39 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}