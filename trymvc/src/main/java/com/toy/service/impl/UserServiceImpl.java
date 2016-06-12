package com.toy.service.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.toy.data.extend.UserMapper;
import com.toy.data.generate.IdSequenceMapper;
import com.toy.data.generate.UserCoinMapper;
import com.toy.data.generate.UserTokenMapper;
import com.toy.model.extend.Limit;
import com.toy.model.extend.UserExample;
import com.toy.model.generate.IdSequence;
import com.toy.model.generate.User;
import com.toy.model.generate.UserCoin;
import com.toy.model.generate.UserToken;
import com.toy.model.generate.UserTokenExample;
import com.toy.service.InvalidPasswordException;
import com.toy.service.ToyException;
import com.toy.service.UserNotFoundException;
import com.toy.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	private UserMapper userMapper;
	private IdSequenceMapper idSequenceMapper;
	private UserCoinMapper userCoinMapper;
	private UserTokenMapper userTokenMapper;

	private Random randomGenerator;

	public List<User> listUsers(int count, int page) throws ToyException {
		UserExample userExample = new UserExample();
		Limit limit = new Limit();
		limit.setOffset((page - 1) * count);
		limit.setRowcount(count);
		userExample.setLimitClause(limit);
		return userMapper.selectByExampleWithLimit(userExample);
	}

	public int getUserCount() throws ToyException {
		return userMapper.countByExample(null);
	}

	public UserToken login(String username, String password) throws ToyException {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			throw new UserNotFoundException("user not found");
		}

		User user = users.get(0);
		String salt = user.getSalt();
		String md5pwd = toMD5(password, salt);
		if (user.getPassword().equals(md5pwd)) {
			UserToken token = new UserToken();
			String tokenValue = toMD5(UUID.randomUUID().toString(), "");
			token.setUserId(user.getUserId());
			token.setToken(tokenValue);
			userTokenMapper.insert(token);
			return token;
		} else {
			throw new InvalidPasswordException("invalid password");
		}
	}

	public User getUserWithToken(String token) {
		UserTokenExample example = new UserTokenExample();
		example.createCriteria().andTokenEqualTo(token);
		List<UserToken> tokens = userTokenMapper.selectByExample(example);
		if (tokens.size() > 0) {
			return userMapper.selectByPrimaryKey(tokens.get(0).getUserId());
		} else {
			return null;
		}
	}

	public User createUser(User user) throws ToyException {
		IdSequence id = new IdSequence();
		idSequenceMapper.insert(id);
		String userId = "u" + id.getId().toString();
		String salt = generateSalt();
		String md5pwd = toMD5(user.getPassword(), salt);
		user.setUserId(userId);
		user.setCreateTime(new Date());
		user.setSalt(salt);
		user.setPassword(md5pwd);
		userMapper.insert(user);
		UserCoin userCoin = new UserCoin();
		userCoin.setUserId(userId);
		userCoin.setCount(0);
		userCoinMapper.insert(userCoin);
		return user;
	}

	public User updateUser(User user) throws ToyException {
		User originalUser = userMapper.selectByPrimaryKey(user.getUserId());
		user.setCreateTime(originalUser.getCreateTime());
		user.setSalt(originalUser.getSalt());
		user.setPassword(toMD5(user.getPassword(), originalUser.getSalt()));
		if (user.getRole() == null) {
			user.setRole(originalUser.getRole());
		}
		if (user.getState() == null) {
			user.setState(originalUser.getState());
		}
		userMapper.updateByPrimaryKey(user);
		return user;
	}

	public List<User> findUserByName(String name) throws ToyException {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameLike("%" + name + "%");
		return userMapper.selectByExample(userExample);
	}

	public UserCoin updateUserCoin(String userID, int count) throws ToyException {
		UserCoin userCoin = new UserCoin();
		userCoin.setUserId(userID);
		userCoin.setCount(count);
		userCoinMapper.updateByPrimaryKey(userCoin);
		return userCoin;
	}

	public User getUser(String id) throws ToyException {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	public UserCoin getUserCoin(String userID) throws ToyException {
		UserCoin userCoin = userCoinMapper.selectByPrimaryKey(userID);
		return userCoin;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Resource
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public IdSequenceMapper getIdSequenceMapper() {
		return idSequenceMapper;
	}

	@Resource
	public void setIdSequenceMapper(IdSequenceMapper idSequenceMapper) {
		this.idSequenceMapper = idSequenceMapper;
	}

	public UserCoinMapper getUserCoinMapper() {
		return userCoinMapper;
	}

	@Resource
	public void setUserCoinMapper(UserCoinMapper userCoinMapper) {
		this.userCoinMapper = userCoinMapper;
	}
	
	public UserTokenMapper getUserTokenMapper() {
		return userTokenMapper;
	}

	@Resource
	public void setUserTokenMapper(UserTokenMapper userTokenMapper) {
		this.userTokenMapper = userTokenMapper;
	}

	private String toMD5(String password, String salt) {
		String source = password + salt;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new ToyException(e);
		}
		md.update(source.getBytes());
		byte byteData[] = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	private String generateSalt() {
		if (randomGenerator == null) {
			randomGenerator = new Random();
		}
		int randomInt = randomGenerator.nextInt(1000);
		return Integer.toString(randomInt);
	}
}
