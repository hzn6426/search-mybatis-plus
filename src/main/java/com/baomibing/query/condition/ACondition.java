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

import com.baomibing.query.QueryPart;
import com.baomibing.query.helper.InnerHelper;
import com.baomibing.query.select.SelectablePart;
/**
 * 条件抽象
 * 
 * @author zening
 * @since 1.0.0
 */
public abstract class ACondition implements QueryPart {

	protected int operator;
	
	protected SelectablePart selectablePart;


	protected Object value;

	protected Object value2;


	protected Object displayValue(Object v) {
		return InnerHelper.displayValue(v);
	}


	protected final String OP_EQUAL = " = ";

	protected final String OP_NOT_EQUAL = " != ";

	protected final String OP_LT = " < ";

	protected final String OP_GT = " > ";

	protected final String OP_LTE = " <= ";

	protected final String OP_GTE = " >= ";

	protected final String OP_LIKE = " LIKE ";

	protected final String OP_IN = " IN ";

	protected final String OP_NOT_IN = " NOT IN ";

	protected final String OP_IS_NULL = " IS NULL ";

	protected final String OP_NOT_NULL = " IS NOT NULL ";

	protected final String OP_AND = " AND ";

	protected final String OP_OR = " OR ";

	protected final String OP_BETWEEN = " BETWEEN ";

}
