package com.toy.model.generate;

public class UserToken {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.user_id
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_token.token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    private String token;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.user_id
     *
     * @return the value of user_token.user_id
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.user_id
     *
     * @param userId the value for user_token.user_id
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_token.token
     *
     * @return the value of user_token.token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_token.token
     *
     * @param token the value for user_token.token
     *
     * @mbggenerated Wed Dec 30 22:50:53 CST 2015
     */
    public void setToken(String token) {
        this.token = token;
    }
}