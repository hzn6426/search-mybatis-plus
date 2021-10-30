/**
 * Copyright (c) 2021-2021, zening (316279828@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless rGTuired by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomibing.query.condition;

import com.baomibing.query.constant.Strings;
import com.baomibing.query.expression.Expression;
import com.baomibing.query.helper.MyBatisPlusHelper;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.FieldPart;
import com.baomibing.query.select.SQLFunction;
import com.baomibing.query.select.SelectablePart;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * SQL greater than condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class GT extends ACondition {

	private boolean beValueFun = false;
	
	private GT(boolean beTrue, SelectablePart field, Object value, boolean beValueFun) {
		if (beTrue) {
			this.selectablePart = field;
			this.operator = Operator.GT.getOp();
			this.value = value;
			this.beValueFun = beValueFun;
		}
		this.beTrue = beTrue;
	}
	
	public GT(FieldPart field, Object value) {
		this(true, field, value, true);
	}
	
	public GT(boolean beTrue, FieldPart field, Object value) {
		this(beTrue, field, value ,true);
	}
	
	public <T1> GT(SFunction<T1, ?> propertyFunction, Object value) {
		this(true, new Field<>(propertyFunction), value);
	}
	
	public <T1, T2> GT(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		this(true, new Field<>(propertyFunction), MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1, T2> GT(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this(true, new Field<>(propertyFunction), sqlFunction, true);
	}
	
	public <T1> GT(SQLFunction sqlFunction, Object value) {
		this(true, sqlFunction, value, true);
	}
	
	public <T1> GT(SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		this(true, sqlFunction, MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1> GT(SFunction<T1, ?> propertyFunction, Expression expression) {
		this(true, new Field<>(propertyFunction), expression, true);
	}
	
	public GT(Alias alias1, Alias alias2) {
		this(true, alias1, alias2, true);
	}
	
	public GT(Alias alias, Object value) {
		this(true, alias, value, true);
	}
	
	public GT(Alias alias, Expression expression) {
		this(true, alias, expression, true);
	}
	
	public GT(boolean beTrue, Alias alias1, Alias alias2) {
		this(beTrue, alias1, alias2, true);
	}
	
	public GT(boolean beTrue, Alias alias, Object value) {
		this(beTrue, alias, value, true);
	}
	
	public GT(boolean beTrue, Alias alias, Expression expression) {
		this(beTrue, alias, expression, true);
	}
	
	public <T1> GT(boolean beTrue, SFunction<T1, ?> propertyFunction, Object value) {
		this(beTrue, new Field<>(propertyFunction), value, true);
	}
	
	public <T1, T2> GT(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		this(beTrue, new Field<>(propertyFunction), MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1, T2> GT(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this(beTrue, new Field<>(propertyFunction), sqlFunction, true);
	}
	
	public <T1> GT(boolean beTrue, SQLFunction sqlFunction, Object value) {
		this(beTrue, sqlFunction, value, true);
	}
	
	public <T1> GT(boolean beTrue, SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		this(beTrue, sqlFunction, MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1> GT(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		this(beTrue, new Field<>(propertyFunction), expression, true);
	}
	
	
	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_GT).append(beValueFun ? displayValue(value) : value);
		return s.toString();
	}

}
