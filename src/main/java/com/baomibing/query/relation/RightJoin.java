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

import java.util.stream.Collectors;

import com.baomibing.query.condition.ACondition;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.helper.MyBatisPlusHelper;
import com.google.common.collect.Lists;
/**
 * Right join relation
 * 
 * @author zening
 * @date 2021-10-20 13:34:42
 * @since 1.0.0
 */
public class RightJoin extends Relation {

	public RightJoin(Class<?> clazz, ACondition... conditions) {
		this.relationClass = clazz;
		if (this.conditions == null) {
			this.conditions = Lists.newArrayList();
		}
		for(ACondition c : conditions) {
			this.conditions.add(c);
		}
	}
	
	@Override
	public String toSQL() {
		StringBuilder s = new StringBuilder();
		s.append(SQLConsts.SQL_RIGHT_JOIN).append(MyBatisPlusHelper.getTableName(relationClass)).append(SQLConsts.SQL_ON);
		String condtion = this.conditions.stream().map(c -> c.toSQL()).collect(Collectors.joining());
		s.append(condtion);
		return s.toString();
	}
}
