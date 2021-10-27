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

import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.helper.MyBatisPlusHelper;
/**
 * Cross join relation
 * 
 * @author zening
 * @since 1.0.0
 */
public class CrossJoin extends Relation {

	public CrossJoin(Class<?> clazz) {
		this.relationClass = clazz;
	}
	
	public CrossJoin(boolean beTrue, Class<?> clazz) {
		if (beTrue) {
			this.relationClass = clazz;
		}
		this.beTrue = beTrue;
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(SQLConsts.SQL_CROSS_JOIN).append(MyBatisPlusHelper.getTableName(relationClass));
		return s.toString();
	}
}
