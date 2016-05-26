package com.toy.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.toy.data.generate.IdSequenceMapper;
import com.toy.model.generate.IdSequence;

public class IDSequenceDAO {
	public IdSequence create() throws DAOException{
		IdSequence newID = new IdSequence();
		SqlSession session = null;
		try {
			session = SessionFactory.getInstance().getSession();
			IdSequenceMapper  mapper = session.getMapper(IdSequenceMapper.class);
			mapper.insert(newID);
			session.commit();
			return newID;
		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
