package com.space.db.game;

import java.io.InputStream;
import java.util.Properties;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GameDbServer {
	
	
	public static SqlSession getSession(InputStream inputStream, Properties properties){

		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	
	
}





