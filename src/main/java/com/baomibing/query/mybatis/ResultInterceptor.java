/**
 * Copyright (c) 2021-2021, zening (316279828@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomibing.query.mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.baomibing.query.SQLQuery;
import com.baomibing.query.constant.ParameterConsts;
import com.baomibing.query.constant.Strings;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.handlers.AbstractSqlParserHandler;
import com.google.common.collect.ImmutableList;
/**
 * Intercepter for handling result data
 * 
 * @author zening
 * @data 2021-10-20 13:31:57
 * @since 1.0.0
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class }) })
public class ResultInterceptor extends AbstractSqlParserHandler implements Interceptor {
	
	private final List<String> interceptorMethods = ImmutableList.of(SqlMethod.SELECT_FETCH.getMethod().toUpperCase(),SqlMethod.SELECT_FETCH_INTO.getMethod().toUpperCase());
	
	@SuppressWarnings("unchecked")
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		 Object[] args = invocation.getArgs();
		//获取statement及mapper信息
		MappedStatement statement = (MappedStatement) args[0];
        BoundSql bindSql = statement.getBoundSql(args[1]);
		String mapperId = statement.getId();
		String methodName = mapperId.substring(mapperId.lastIndexOf(Strings.DOT) + 1);
		
		if (!interceptorMethods.contains(methodName.toUpperCase())) {
			return invocation.proceed();
		}
		
		List<ResultMap> list = statement.getResultMaps();
		ResultMap resultMap = null;
        if (CollectionUtils.isNotEmpty(list)) {
            resultMap = list.get(0);
            if (resultMap.getType() != QueryResult.class) {
            	return invocation.proceed();
            }
        }
		HashMap<String, Object> paramterObject = (HashMap<String, Object>)bindSql.getParameterObject();
		Object qwBindParam = paramterObject.get(ParameterConsts.QUERY_WRAPPER);
		Object clazzBinParam = paramterObject.get(ParameterConsts.QUERY_TO_CLASS);
		if (qwBindParam instanceof SQLQuery) {
			SQLQuery queryer = (SQLQuery)qwBindParam;
			Class<?> clazz = clazzBinParam == null ? queryer.getFromClass() : (Class<?>) clazzBinParam;
            args[0] = newMappedStatement(statement, clazz);
		}
		return invocation.proceed();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
    private MappedStatement newMappedStatement(MappedStatement ms, Class<?> resultType) {
		String id = ms.getId() + StringPool.UNDERSCORE + resultType.getName();
		 MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), id, ms.getSqlSource(), ms.getSqlCommandType())
                .resource(ms.getResource())
                .fetchSize(ms.getFetchSize())
                .statementType(ms.getStatementType())
                .keyGenerator(ms.getKeyGenerator())
                .timeout(ms.getTimeout())
                .parameterMap(ms.getParameterMap())
                .resultSetType(ms.getResultSetType())
                .cache(ms.getCache())
                .flushCacheRequired(ms.isFlushCacheRequired())
                .useCache(ms.isUseCache());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            builder.keyProperty(String.join(StringPool.COMMA, ms.getKeyProperties()));
        }
        List<ResultMap> resultMaps = new ArrayList<>();
        ResultMap resultMap = new ResultMap.Builder(ms.getConfiguration(), id, resultType,
                new ArrayList()).build();
        resultMaps.add(resultMap);
        builder.resultMaps(resultMaps);
        return builder.build();
    }

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	
}
