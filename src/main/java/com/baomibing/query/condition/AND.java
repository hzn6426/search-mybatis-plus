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
package com.baomibing.query.condition;

import java.util.List;
import java.util.stream.Collectors;

import com.baomibing.query.constant.Strings;
import com.google.common.collect.Lists;
/**
 * SQL and condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class AND extends ACondition {

	
	public AND(ACondition... conditions) {
		this(true, conditions);
	}

	@SuppressWarnings("unchecked")
	public AND(boolean beTrue, ACondition... conditions) {
		this.beTrue = beTrue;
		if (beTrue) {
			operator = Operator.AND.getOp();
			value = Lists.newArrayList();
			for (ACondition c : conditions) {
				((List<ACondition>) value).add(c);
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		if (value instanceof List) {
			List<ACondition> conditons = (List<ACondition>) value;
			s.append("( ");
			s.append(conditons.stream().map(c -> c.toSQL()).collect(Collectors.joining(OP_AND)));
			s.append(" )");
		}
		return s.toString();
	}
	
	
}
