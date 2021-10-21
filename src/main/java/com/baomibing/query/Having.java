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

import java.util.List;
import java.util.stream.Collectors;

import com.baomibing.query.condition.ACondition;
import com.baomibing.query.constant.SQLConsts;
import com.google.common.collect.Lists;
/**
 * SQL having part
 * 
 * @author zening
 * @since 1.0.0
 */
public class Having implements QueryPart {

	
	public Having(ACondition... conditions) {
		this.conditions = Lists.newArrayList();
		for(ACondition c : conditions) {
			this.conditions.add(c);
		}
	}
	

	private List<ACondition>  conditions;

	@Override
	public String toSQL() {
		StringBuilder s = new StringBuilder();
		if (conditions != null && !conditions.isEmpty()) {
			s.append(SQLConsts.SQL_HAVING);
			
			String sql = conditions.stream().map(c -> c.toSQL()).collect(Collectors.joining());
			if (sql.trim().startsWith(SQLConsts.SQL_AND.trim())) {
				sql = sql.trim().substring(SQLConsts.SQL_AND.trim().length() + 1);
			} else if (sql.trim().startsWith(SQLConsts.SQL_OR.trim())) {
				sql = sql.trim().substring(SQLConsts.SQL_OR.trim().length() + 1);
			}
			s.append(sql);
		}
		return s.toString();
	}
	
	
	
}
