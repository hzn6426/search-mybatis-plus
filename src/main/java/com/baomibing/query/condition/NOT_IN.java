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
 * WARRANTIES OR CONDITIONS OF ANY KNOT_IND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomibing.query.condition;

import com.baomibing.query.SQLQuery;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.FieldPart;
import com.baomibing.query.select.SelectablePart;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Collection;

/**
 * SQL not in condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class NOT_IN extends ACondition {
	
	private NOT_IN(SelectablePart field, Object value, Boolean beTrue) {
		if (beTrue) {
			this.selectablePart = field;
			this.operator = Operator.NOT_IN.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}
	
	public NOT_IN(FieldPart field, Collection<?> value) {
		this( field, value, true);
	}
	
	public NOT_IN(boolean beTrue, FieldPart field, Collection<?> value) {
		this(field, value , beTrue);
	}
	
	public NOT_IN(SFunction<?, ?> propertyFunction, Collection<?> value) {
		this(new Field<>(propertyFunction), value, true);
	}
	
	public NOT_IN(SFunction<?, ?> propertyFunction, SQLQuery query) {
		this(new Field<>(propertyFunction), query, true);
	}
	
	public NOT_IN(boolean beTrue, SFunction<?, ?> propertyFunction, Collection<?> value) {
		this(new Field<>(propertyFunction), value, beTrue);
	}
	
	public NOT_IN(boolean beTrue, SFunction<?, ?> propertyFunction, SQLQuery query) {
		this(new Field<>(propertyFunction), query, beTrue);
	}
	
	public NOT_IN(Alias alias, Collection<?> value) {
		this(alias, value, true);
	}
	
	public NOT_IN(Alias alias, SQLQuery query) {
		this(alias, query, true);
	}
	
	public NOT_IN(boolean beTrue, Alias alias, Collection<?> value) {
		this(alias, value, beTrue);
	}
	
	public NOT_IN(boolean beTrue, Alias alias, SQLQuery query) {
		this(alias, query, beTrue);
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_NOT_IN).append("(").append(displayValue(value)).append(")");
		return s.toString();
	}
}
