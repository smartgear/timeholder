package com.toy.model.generate;

public class WeixinPayment {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column weixin_payment.id
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	private String id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column weixin_payment.bill_id
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	private String billId;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column weixin_payment.id
	 * @return  the value of weixin_payment.id
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public String getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column weixin_payment.id
	 * @param id  the value for weixin_payment.id
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column weixin_payment.bill_id
	 * @return  the value of weixin_payment.bill_id
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public String getBillId() {
		return billId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column weixin_payment.bill_id
	 * @param billId  the value for weixin_payment.bill_id
	 * @mbggenerated  Mon Dec 07 22:17:15 CST 2015
	 */
	public void setBillId(String billId) {
		this.billId = billId;
	}
}