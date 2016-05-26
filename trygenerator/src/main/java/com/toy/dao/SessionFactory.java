package com.toy.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactory {

	private static SessionFactory instance = null;
	private static String configResource = "com/toy/dao/mybatis-config.xml";
	private SqlSessionFactory sqlSessionFactory = null;

	public static synchronized SessionFactory getInstance() throws IOException {
		if (instance == null) {
			instance = new SessionFactory();
		}
		return instance;
	}

	public SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}

	private SessionFactory() throws IOException {
		// Reader reader = null;
		// reader =
		// Resources.getResourceAsReader(this.getClass().getClassLoader(),
		// configResource);
		// if(reader!=null ){
		// sqlSessionFactory = new
		// SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream(configResource));
		// }
		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(this.getClass().getClassLoader().getResourceAsStream(configResource));
	}
}
