package com.toy.service;

import java.util.List;

import com.toy.model.generate.User;
import com.toy.model.generate.UserCoin;
import com.toy.model.generate.UserToken;

public interface UserService {

	public List<User> listUsers(int count, int page) throws ToyException;

	/**
	 * @return
	 * @throws ToyException
	 */
	public int getUserCount() throws ToyException;

	/**
	 * @param username
	 * @param password
	 * @return user token
	 * @throws ToyException
	 */
	public UserToken login(String username, String password) throws UserNotFoundException, InvalidPasswordException, ToyException;

	
	/**
	 * @param token
	 * @return
	 */
	public User getUserWithToken(String token);
	
	/**
	 * @param user
	 * @return
	 * @throws ToyException
	 */
	public User createUser(User user) throws ToyException;

	/**
	 * @param user
	 * @return
	 * @throws ToyException
	 */
	public User updateUser(User user) throws ToyException;
	
	/**
	 * @param id
	 * @return
	 * @throws ToyException
	 */
	public User getUser(String id) throws ToyException;

	/**
	 * @param name
	 * @return
	 * @throws ToyException
	 */
	public List<User> findUserByName(String name) throws ToyException;
	
	/**
	 * @param userID
	 * @param count
	 * @return
	 * @throws ToyException
	 */
	public UserCoin updateUserCoin(String userID, int count) throws ToyException;
	
	/**
	 * @param userID
	 * @return
	 * @throws ToyException
	 */
	public UserCoin getUserCoin(String userID) throws ToyException;

}
