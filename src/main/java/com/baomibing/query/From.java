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
package com.baomibing.query;


import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.helper.MyBatisPlusHelper;
import com.baomibing.query.select.Alias;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * SQL from part
 * 
 * @author zening
 * @since 1.0.1
 */
@Getter
public class From  implements QueryPart {
	
	private Class<?> relationClass;

	private SQLQuery sqlQuery = null;
	
	private String sqlQueryAlias = "";
	
	private Alias alias;

	public From(Class<?> clazz) {
		this.relationClass = clazz;
	}

	public From(SQLQuery query, String as) {
		sqlQuery = query;
		sqlQueryAlias = as;
		this.relationClass = query.getFromClass();
	}
	
	public From(Alias alias) {
		this.alias = alias;
		this.relationClass = alias.getTableClass();
	}
	
	@Override
	public String toSQL() {
		if (sqlQuery != null) {
			return Strings.LEFT_BRACKET + sqlQuery.toSQL() + Strings.RIGHT_BRACKET + (StringUtils.isNotBlank(sqlQueryAlias) ? SQLConsts.SQL_AS + sqlQueryAlias : "");
		}
		if (alias != null) {
			return MyBatisPlusHelper.getTableName(relationClass) + SQLConsts.SQL_AS + alias.getAliasName() + Strings.SPACE;
		}
		return  MyBatisPlusHelper.getTableName(relationClass);
	}
}
