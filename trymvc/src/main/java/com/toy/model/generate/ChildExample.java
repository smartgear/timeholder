package com.toy.model.generate;

import java.util.ArrayList;
import java.util.List;

public class ChildExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public ChildExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table child
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table child
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

		public Criteria andUidIsNull() {
			addCriterion("uid is null");
			return (Criteria) this;
		}

		public Criteria andUidIsNotNull() {
			addCriterion("uid is not null");
			return (Criteria) this;
		}

		public Criteria andUidEqualTo(String value) {
			addCriterion("uid =", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotEqualTo(String value) {
			addCriterion("uid <>", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThan(String value) {
			addCriterion("uid >", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidGreaterThanOrEqualTo(String value) {
			addCriterion("uid >=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThan(String value) {
			addCriterion("uid <", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLessThanOrEqualTo(String value) {
			addCriterion("uid <=", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidLike(String value) {
			addCriterion("uid like", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotLike(String value) {
			addCriterion("uid not like", value, "uid");
			return (Criteria) this;
		}

		public Criteria andUidIn(List<String> values) {
			addCriterion("uid in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotIn(List<String> values) {
			addCriterion("uid not in", values, "uid");
			return (Criteria) this;
		}

		public Criteria andUidBetween(String value1, String value2) {
			addCriterion("uid between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andUidNotBetween(String value1, String value2) {
			addCriterion("uid not between", value1, value2, "uid");
			return (Criteria) this;
		}

		public Criteria andChildIdIsNull() {
			addCriterion("child_id is null");
			return (Criteria) this;
		}

		public Criteria andChildIdIsNotNull() {
			addCriterion("child_id is not null");
			return (Criteria) this;
		}

		public Criteria andChildIdEqualTo(String value) {
			addCriterion("child_id =", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdNotEqualTo(String value) {
			addCriterion("child_id <>", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdGreaterThan(String value) {
			addCriterion("child_id >", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdGreaterThanOrEqualTo(String value) {
			addCriterion("child_id >=", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdLessThan(String value) {
			addCriterion("child_id <", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdLessThanOrEqualTo(String value) {
			addCriterion("child_id <=", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdLike(String value) {
			addCriterion("child_id like", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdNotLike(String value) {
			addCriterion("child_id not like", value, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdIn(List<String> values) {
			addCriterion("child_id in", values, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdNotIn(List<String> values) {
			addCriterion("child_id not in", values, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdBetween(String value1, String value2) {
			addCriterion("child_id between", value1, value2, "childId");
			return (Criteria) this;
		}

		public Criteria andChildIdNotBetween(String value1, String value2) {
			addCriterion("child_id not between", value1, value2, "childId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdIsNull() {
			addCriterion("user_user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserUserIdIsNotNull() {
			addCriterion("user_user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserUserIdEqualTo(String value) {
			addCriterion("user_user_id =", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdNotEqualTo(String value) {
			addCriterion("user_user_id <>", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdGreaterThan(String value) {
			addCriterion("user_user_id >", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_user_id >=", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdLessThan(String value) {
			addCriterion("user_user_id <", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_user_id <=", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdLike(String value) {
			addCriterion("user_user_id like", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdNotLike(String value) {
			addCriterion("user_user_id not like", value, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdIn(List<String> values) {
			addCriterion("user_user_id in", values, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdNotIn(List<String> values) {
			addCriterion("user_user_id not in", values, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdBetween(String value1, String value2) {
			addCriterion("user_user_id between", value1, value2, "userUserId");
			return (Criteria) this;
		}

		public Criteria andUserUserIdNotBetween(String value1, String value2) {
			addCriterion("user_user_id not between", value1, value2, "userUserId");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andAgeIsNull() {
			addCriterion("age is null");
			return (Criteria) this;
		}

		public Criteria andAgeIsNotNull() {
			addCriterion("age is not null");
			return (Criteria) this;
		}

		public Criteria andAgeEqualTo(String value) {
			addCriterion("age =", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotEqualTo(String value) {
			addCriterion("age <>", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeGreaterThan(String value) {
			addCriterion("age >", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeGreaterThanOrEqualTo(String value) {
			addCriterion("age >=", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLessThan(String value) {
			addCriterion("age <", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLessThanOrEqualTo(String value) {
			addCriterion("age <=", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLike(String value) {
			addCriterion("age like", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotLike(String value) {
			addCriterion("age not like", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeIn(List<String> values) {
			addCriterion("age in", values, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotIn(List<String> values) {
			addCriterion("age not in", values, "age");
			return (Criteria) this;
		}

		public Criteria andAgeBetween(String value1, String value2) {
			addCriterion("age between", value1, value2, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotBetween(String value1, String value2) {
			addCriterion("age not between", value1, value2, "age");
			return (Criteria) this;
		}

		public Criteria andGenderIsNull() {
			addCriterion("gender is null");
			return (Criteria) this;
		}

		public Criteria andGenderIsNotNull() {
			addCriterion("gender is not null");
			return (Criteria) this;
		}

		public Criteria andGenderEqualTo(String value) {
			addCriterion("gender =", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotEqualTo(String value) {
			addCriterion("gender <>", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderGreaterThan(String value) {
			addCriterion("gender >", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderGreaterThanOrEqualTo(String value) {
			addCriterion("gender >=", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLessThan(String value) {
			addCriterion("gender <", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLessThanOrEqualTo(String value) {
			addCriterion("gender <=", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLike(String value) {
			addCriterion("gender like", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotLike(String value) {
			addCriterion("gender not like", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderIn(List<String> values) {
			addCriterion("gender in", values, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotIn(List<String> values) {
			addCriterion("gender not in", values, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderBetween(String value1, String value2) {
			addCriterion("gender between", value1, value2, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotBetween(String value1, String value2) {
			addCriterion("gender not between", value1, value2, "gender");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table child
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
     * This class corresponds to the database table child
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 07 20:37:43 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}