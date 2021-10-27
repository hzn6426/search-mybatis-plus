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
package com.baomibing.query.relation;

import com.baomibing.query.QueryPart;
import com.baomibing.query.condition.ACondition;
import com.baomibing.query.condition.AND;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.helper.MyBatisPlusHelper;
import com.baomibing.query.select.Alias;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.stream.Collectors;
/**
 * Right join relation
 * 
 * @author zening
 * @since 1.0.0
 */
public class RightJoin extends Relation {

	public RightJoin(Class<?> clazz, ACondition... conditions) {
		this(true, clazz, conditions);
	}
	
	private Alias alias;
	
	//self join
	public RightJoin(Alias alias, ACondition... conditions) {
		this.alias = alias;
		if (this.conditions == null) {
			this.conditions = Lists.newArrayList();
		}
		if (conditions != null && conditions.length > 1) {
			this.conditions.add(new AND(conditions));
		} else {
			this.conditions.addAll(Arrays.asList(conditions));
		}
	}
	
	public RightJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
		if (beTrue) {
			this.relationClass = clazz;
			if (this.conditions == null) {
				this.conditions = Lists.newArrayList();
			}
			if (conditions != null && conditions.length > 1) {
				this.conditions.add(new AND(conditions));
			} else {
				this.conditions.addAll(Arrays.asList(conditions));
			}
		}
		this.beTrue = beTrue;
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		String tableName = alias == null ? MyBatisPlusHelper.getTableName(relationClass)
			: MyBatisPlusHelper.getTableName(alias.getTableClass()) + SQLConsts.SQL_AS + alias.getAliasName() + Strings.SPACE;
		StringBuilder s = new StringBuilder();
		s.append(SQLConsts.SQL_RIGHT_JOIN).append(tableName).append(SQLConsts.SQL_ON);
		String condtion = this.conditions.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		s.append(condtion);
		return s.toString();
	}
}
