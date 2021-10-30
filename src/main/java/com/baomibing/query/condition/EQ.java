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
 * SQL equal condition
 * <P>
 * Note: some database maybe case-sensitive
 * 
 * @author zening
 * @since 1.0.0
 */
public class EQ extends ACondition {

	private boolean beValueFun = false;
	
	private EQ(boolean beTrue, SelectablePart field, Object value, boolean beValueFun) {
		if (beTrue) {
			this.selectablePart = field;
			this.operator = Operator.EQ.getOp();
			this.value = value;
			this.beValueFun = beValueFun;
		}
		this.beTrue = beTrue;
	}

	public EQ(FieldPart field, Object value) {
		this(true, field, value, true);
	}
	
	public EQ(boolean beTrue, FieldPart field, Object value) {
		this(beTrue, field, value ,true);
	}
	
	public <T1> EQ(SFunction<T1, ?> propertyFunction, Object value) {
		this(true, new Field<>(propertyFunction), value);
	}

	public <T1, T2> EQ(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		this(true, new Field<>(propertyFunction), MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1, T2> EQ(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this(true, new Field<>(propertyFunction), sqlFunction, true);
	}

	public <T1> EQ(SQLFunction sqlFunction, Object value) {
		this(true, sqlFunction, value, true);
	}

	public <T1> EQ(SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		this(true, sqlFunction, MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1> EQ(SFunction<T1, ?> propertyFunction, Expression expression) {
		this(true, new Field<>(propertyFunction), expression, true);
	}
	
	public EQ(Alias alias1, Alias alias2) {
		this(true, alias1, alias2, true);
	}
	
	public EQ(Alias alias, Object value) {
		this(true, alias, value, true);
	}
	
	public EQ(Alias alias, Expression expression) {
		this(true, alias, expression, true);
	}
	
	public EQ(boolean beTrue, Alias alias1, Alias alias2) {
		this(beTrue, alias1, alias2, true);
	}
	
	public EQ(boolean beTrue, Alias alias, Object value) {
		this(beTrue, alias, value, true);
	}
	
	public EQ(boolean beTrue, Alias alias, Expression expression) {
		this(beTrue, alias, expression, true);
	}

	public <T1> EQ(boolean beTrue, SFunction<T1, ?> propertyFunction, Object value) {
		this(beTrue, new Field<>(propertyFunction), value, true);
	}

	public <T1, T2> EQ(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		this(beTrue, new Field<>(propertyFunction), MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1, T2> EQ(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this(beTrue, new Field<>(propertyFunction), sqlFunction, true);
	}

	public <T1> EQ(boolean beTrue, SQLFunction sqlFunction, Object value) {
		this(beTrue, sqlFunction, value, true);
	}

	public <T1> EQ(boolean beTrue, SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		this(beTrue, sqlFunction, MyBatisPlusHelper.columnToString(valueFunction), false);
	}
	
	public <T1> EQ(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		this(beTrue, new Field<>(propertyFunction), expression, true);
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_EQUAL).append(beValueFun ?  displayValue(value) : value);
		return s.toString();
	}

}
