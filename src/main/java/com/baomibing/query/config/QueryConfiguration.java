package com.baomibing.query.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomibing.query.mybatis.QuerySqlInject;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;

@Configuration
@AutoConfigureAfter({MybatisPlusInterceptor.class})
public class QueryConfiguration {

	@Bean
	public QueryInterceptorInject injuect() {
		return new QueryInterceptorInject();
	}
	
	@Bean
	public QuerySqlInject queryInject() {
		return new QuerySqlInject();
	}
}
