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

import com.baomibing.query.SQLQuery;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
/**
 * SQL not exists condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class NOT_EXISTS extends ACondition {

	public <T1> NOT_EXISTS(SQLQuery queryer) {
		this.operator = Operator.EXIST.getOp();
		this.value = queryer;
	}

	@Override
	public String toSQL() {
		return SQLConsts.SQL_NOT_EXISTS + Strings.LEFT_BRACKET + ((SQLQuery)this.value).toSQL() + Strings.RIGHT_BRACKET;
	}
	
	
}
