package com.baomibing.query.config;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.baomibing.query.mybatis.ResultInterceptor;

public class QueryInterceptorInject {

	@Autowired
	private List<SqlSessionFactory> sqlSessionFactoryList;

	@EventListener(ApplicationReadyEvent.class)
	public void addMyInterceptor() {
		ResultInterceptor e = new ResultInterceptor();
		for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
			sqlSessionFactory.getConfiguration().addInterceptor(e);
		}
	}
}
