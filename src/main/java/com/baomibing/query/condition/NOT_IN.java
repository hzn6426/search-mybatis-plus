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
import com.baomibing.query.constant.Strings;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.Collection;

/**
 * SQL not in condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class NOT_IN extends ACondition {

	public NOT_IN(SFunction<?, ?> propertyFunction, Collection<?> value) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.NOT_IN.getOp();
		this.value = value;
	}

	public NOT_IN(SFunction<?, ?> propertyFunction, SQLQuery query) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.NOT_IN.getOp();
		this.value = query;
	}

	public NOT_IN(boolean beTrue, SFunction<?, ?> propertyFunction, Collection<?> value) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			this.operator = Operator.NOT_IN.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}

	public NOT_IN(boolean beTrue, SFunction<?, ?> propertyFunction, SQLQuery query) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			this.operator = Operator.NOT_IN.getOp();
			this.value = query;
		}
		this.beTrue = beTrue;
	}
	
	public NOT_IN(Alias alias, Collection<?> value) {
		this.selectablePart = alias;
		this.operator = Operator.NOT_IN.getOp();
		this.value = value;
	}
	
	public NOT_IN(Alias alias, SQLQuery query) {
		this.selectablePart = alias;
		this.operator = Operator.NOT_IN.getOp();
		this.value = query;
	}
	
	public NOT_IN(boolean beTrue, Alias alias, Collection<?> value) {
		if (beTrue) {
			this.selectablePart = alias;
			this.operator = Operator.NOT_IN.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}
	
	public NOT_IN(boolean beTrue, Alias alias, SQLQuery query) {
		if (beTrue) {
			this.selectablePart = alias;
			this.operator = Operator.NOT_IN.getOp();
			this.value = query;
		}
		this.beTrue = beTrue;
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
