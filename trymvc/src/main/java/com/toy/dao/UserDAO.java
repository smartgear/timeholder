package com.toy.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.toy.data.extend.UserMapper;
import com.toy.model.generate.User;
import com.toy.model.extend.Limit;
import com.toy.model.extend.UserExample;

public class UserDAO {
	public int addUser(User user) throws DAOException {
		SqlSession session = null;
		try {
			session = SessionFactory.getInstance().getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			int result = mapper.insert(user);
			session.commit();
			return result;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public int updateUser(User user) throws DAOException {
		SqlSession session = null;
		try {
			session = SessionFactory.getInstance().getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			int result = mapper.updateByPrimaryKey(user);
			session.commit();
			return result;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public User getUser(String userID) throws DAOException {
		SqlSession session = null;
		try {
			session = SessionFactory.getInstance().getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			User result = mapper.selectByPrimaryKey(userID);
			session.commit();
			return result;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<User> getUserByName(String userName, long offset, long count) throws DAOException {
		SqlSession session = null;
		try {
			session = SessionFactory.getInstance().getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			UserExample example = new UserExample();
			example.createCriteria().andUsernameEqualTo(userName);
			Limit limit = new Limit();
			limit.setOffset(0);
			limit.setRowcount(100);
			example.setLimitClause(limit);
			List<User> result = mapper.selectByExampleWithLimit(example);
			session.commit();
			return result;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	public List<User> listUser(long offset, long count) throws DAOException {
		SqlSession session = null;
		try {
			session = SessionFactory.getInstance().getSession();
			UserMapper mapper = session.getMapper(UserMapper.class);
			UserExample example = new UserExample();
			Limit limit = new Limit();
			limit.setOffset(offset);
			limit.setRowcount(count);
			example.setLimitClause(limit);
			example.setOrderByClause("create_time");
			List<User> result = mapper.selectByExampleWithLimit(example);
			session.commit();
			return result;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
