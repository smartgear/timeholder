package com.toy.model.generate;

import java.util.ArrayList;
import java.util.List;

public class ToyTagExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public ToyTagExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
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

		public Criteria andToyIdIsNull() {
			addCriterion("toy_id is null");
			return (Criteria) this;
		}

		public Criteria andToyIdIsNotNull() {
			addCriterion("toy_id is not null");
			return (Criteria) this;
		}

		public Criteria andToyIdEqualTo(String value) {
			addCriterion("toy_id =", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdNotEqualTo(String value) {
			addCriterion("toy_id <>", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdGreaterThan(String value) {
			addCriterion("toy_id >", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdGreaterThanOrEqualTo(String value) {
			addCriterion("toy_id >=", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdLessThan(String value) {
			addCriterion("toy_id <", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdLessThanOrEqualTo(String value) {
			addCriterion("toy_id <=", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdLike(String value) {
			addCriterion("toy_id like", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdNotLike(String value) {
			addCriterion("toy_id not like", value, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdIn(List<String> values) {
			addCriterion("toy_id in", values, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdNotIn(List<String> values) {
			addCriterion("toy_id not in", values, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdBetween(String value1, String value2) {
			addCriterion("toy_id between", value1, value2, "toyId");
			return (Criteria) this;
		}

		public Criteria andToyIdNotBetween(String value1, String value2) {
			addCriterion("toy_id not between", value1, value2, "toyId");
			return (Criteria) this;
		}

		public Criteria andTagIdIsNull() {
			addCriterion("tag_id is null");
			return (Criteria) this;
		}

		public Criteria andTagIdIsNotNull() {
			addCriterion("tag_id is not null");
			return (Criteria) this;
		}

		public Criteria andTagIdEqualTo(String value) {
			addCriterion("tag_id =", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdNotEqualTo(String value) {
			addCriterion("tag_id <>", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdGreaterThan(String value) {
			addCriterion("tag_id >", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdGreaterThanOrEqualTo(String value) {
			addCriterion("tag_id >=", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdLessThan(String value) {
			addCriterion("tag_id <", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdLessThanOrEqualTo(String value) {
			addCriterion("tag_id <=", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdLike(String value) {
			addCriterion("tag_id like", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdNotLike(String value) {
			addCriterion("tag_id not like", value, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdIn(List<String> values) {
			addCriterion("tag_id in", values, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdNotIn(List<String> values) {
			addCriterion("tag_id not in", values, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdBetween(String value1, String value2) {
			addCriterion("tag_id between", value1, value2, "tagId");
			return (Criteria) this;
		}

		public Criteria andTagIdNotBetween(String value1, String value2) {
			addCriterion("tag_id not between", value1, value2, "tagId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table toy_tag
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
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
     * This class corresponds to the database table toy_tag
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 07 20:37:43 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}