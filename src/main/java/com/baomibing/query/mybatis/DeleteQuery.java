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

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

import com.baomidou.mybatisplus.core.metadata.TableInfo;

/**
 * QBaseMapper for deleteQuery method
 * 
 * @author zening
 * @since 1.0.2
 */
@SuppressWarnings("serial")
public class DeleteQuery extends QueryMethod {

	@Override
	public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
		SqlMethod sqlMethod = SqlMethod.DELETE_QUERY;
		
		String sql = String.format(sqlMethod.getSql(), from(), relation(),
	            where(), orderBy(), limit());
	        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
			return this.addDeleteMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource);
	}

}
