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
package com.baomibing.query.select;

import com.baomibing.query.SQLQuery;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * SQL as operator
 * 
 * @author zening
 * @since 1.0.1
 */
public class AS extends SQLFunction {
	
	private SelectablePart selectablePart;
	
	private String alias;

	public AS(FieldPart field, String alias) {
		this.selectablePart = field;
		this.alias = alias;
	}

	public AS(SQLFunction fun, String alias) {
		this.selectablePart = fun;
		this.alias = alias;
	}
	
	public <T> AS(SFunction<T, ?> fun, String alias) {
		this.selectablePart = new Field<T>(fun);
		this.alias = alias;
	}

	private SQLQuery sqlQuery;

	public <T> AS(SQLQuery query, String alias) {
		this.sqlQuery = query;
		this.alias = alias;
	}

	@Override
	public String toSQL() {
		if (sqlQuery != null) {
			return Strings.LEFT_BRACKET + sqlQuery.toSQL() + Strings.RIGHT_BRACKET + SQLConsts.SQL_AS
					+ alias;
		}
		return selectablePart.toSQL() + SQLConsts.SQL_AS + alias;
	}
	
	
}
