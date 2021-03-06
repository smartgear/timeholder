package com.toy.model.generate;

import java.util.ArrayList;
import java.util.List;

public class BillingItemExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public BillingItemExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
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
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table billing_item
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table billing_item
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

		public Criteria andBillIdIsNull() {
			addCriterion("bill_id is null");
			return (Criteria) this;
		}

		public Criteria andBillIdIsNotNull() {
			addCriterion("bill_id is not null");
			return (Criteria) this;
		}

		public Criteria andBillIdEqualTo(String value) {
			addCriterion("bill_id =", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdNotEqualTo(String value) {
			addCriterion("bill_id <>", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdGreaterThan(String value) {
			addCriterion("bill_id >", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdGreaterThanOrEqualTo(String value) {
			addCriterion("bill_id >=", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdLessThan(String value) {
			addCriterion("bill_id <", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdLessThanOrEqualTo(String value) {
			addCriterion("bill_id <=", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdLike(String value) {
			addCriterion("bill_id like", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdNotLike(String value) {
			addCriterion("bill_id not like", value, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdIn(List<String> values) {
			addCriterion("bill_id in", values, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdNotIn(List<String> values) {
			addCriterion("bill_id not in", values, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdBetween(String value1, String value2) {
			addCriterion("bill_id between", value1, value2, "billId");
			return (Criteria) this;
		}

		public Criteria andBillIdNotBetween(String value1, String value2) {
			addCriterion("bill_id not between", value1, value2, "billId");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andAmountIsNull() {
			addCriterion("amount is null");
			return (Criteria) this;
		}

		public Criteria andAmountIsNotNull() {
			addCriterion("amount is not null");
			return (Criteria) this;
		}

		public Criteria andAmountEqualTo(String value) {
			addCriterion("amount =", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotEqualTo(String value) {
			addCriterion("amount <>", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThan(String value) {
			addCriterion("amount >", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountGreaterThanOrEqualTo(String value) {
			addCriterion("amount >=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThan(String value) {
			addCriterion("amount <", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLessThanOrEqualTo(String value) {
			addCriterion("amount <=", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountLike(String value) {
			addCriterion("amount like", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotLike(String value) {
			addCriterion("amount not like", value, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountIn(List<String> values) {
			addCriterion("amount in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotIn(List<String> values) {
			addCriterion("amount not in", values, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountBetween(String value1, String value2) {
			addCriterion("amount between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andAmountNotBetween(String value1, String value2) {
			addCriterion("amount not between", value1, value2, "amount");
			return (Criteria) this;
		}

		public Criteria andResourceIdIsNull() {
			addCriterion("resource_id is null");
			return (Criteria) this;
		}

		public Criteria andResourceIdIsNotNull() {
			addCriterion("resource_id is not null");
			return (Criteria) this;
		}

		public Criteria andResourceIdEqualTo(String value) {
			addCriterion("resource_id =", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotEqualTo(String value) {
			addCriterion("resource_id <>", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdGreaterThan(String value) {
			addCriterion("resource_id >", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdGreaterThanOrEqualTo(String value) {
			addCriterion("resource_id >=", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdLessThan(String value) {
			addCriterion("resource_id <", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdLessThanOrEqualTo(String value) {
			addCriterion("resource_id <=", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdLike(String value) {
			addCriterion("resource_id like", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotLike(String value) {
			addCriterion("resource_id not like", value, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdIn(List<String> values) {
			addCriterion("resource_id in", values, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotIn(List<String> values) {
			addCriterion("resource_id not in", values, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdBetween(String value1, String value2) {
			addCriterion("resource_id between", value1, value2, "resourceId");
			return (Criteria) this;
		}

		public Criteria andResourceIdNotBetween(String value1, String value2) {
			addCriterion("resource_id not between", value1, value2, "resourceId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table billing_item
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
     * This class corresponds to the database table billing_item
     *
     * @mbggenerated do_not_delete_during_merge Mon Dec 07 20:37:42 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}