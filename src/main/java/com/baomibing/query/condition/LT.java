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
import com.baomibing.query.select.SQLFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * SQL less than condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class LT extends ACondition {

	private boolean beValueFun = false;

	public <T> LT(SFunction<T, ?> propertyFunction, Object value) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.LT.getOp();
		this.value = value;
	}

	public <T1, T2> LT(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.LT.getOp();
		this.value = MyBatisPlusHelper.columnToString(valueFunction);
		this.beValueFun = true;
	}

	public <T1> LT(SQLFunction sqlFunction, Object value) {
		this.selectablePart = sqlFunction;
		this.operator = Operator.LT.getOp();
		this.value = value;
	}

	public <T1> LT(SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		this.selectablePart = sqlFunction;
		this.operator = Operator.LT.getOp();
		this.value = MyBatisPlusHelper.columnToString(valueFunction);
		this.beValueFun = true;
	}

	public <T> LT(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			this.operator = Operator.LT.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}

	public <T1, T2> LT(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			this.operator = Operator.LT.getOp();
			this.value = MyBatisPlusHelper.columnToString(valueFunction);
			this.beValueFun = true;
		}
		this.beTrue = beTrue;
	}

	public <T1> LT(boolean beTrue, SQLFunction sqlFunction, Object value) {
		if (beTrue) {
			this.selectablePart = sqlFunction;
			this.operator = Operator.LT.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}

	public <T1> LT(boolean beTrue, SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		if (beTrue) {
			this.selectablePart = sqlFunction;
			this.operator = Operator.LT.getOp();
			this.value = MyBatisPlusHelper.columnToString(valueFunction);
			this.beValueFun = true;
		}
		this.beTrue = beTrue;
	}
	
	public LT(Alias alias1, Alias alias2) {
		this.selectablePart = alias1;
		this.operator = Operator.LT.getOp();
		this.value = alias2;
		this.beValueFun = true;
	}
	
	public LT(Alias alias, Object value) {
		this.selectablePart = alias;
		this.operator = Operator.LT.getOp();
		this.value = value;
	}
	
	public LT(Alias alias, Expression expression) {
		this.selectablePart = alias;
		this.operator = Operator.LT.getOp();
		this.value = expression;
		this.beValueFun = true;
	}
	
	public LT(boolean beTrue, Alias alias1, Alias alias2) {
		if (beTrue) {
			this.selectablePart = alias1;
			this.operator = Operator.LT.getOp();
			this.value = alias2;
			this.beValueFun = true;
		}
		this.beTrue = beTrue;
	}
	
	public LT(boolean beTrue, Alias alias, Object value) {
		if (beTrue) {
			this.selectablePart = alias;
			this.operator = Operator.LT.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}
	
	public LT(boolean beTrue, Alias alias, Expression expression) {
		if (beTrue) {
			this.selectablePart = alias;
			this.operator = Operator.LT.getOp();
			this.value = expression;
			this.beValueFun = true;
		}
		this.beTrue = beTrue;
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_LT).append(beValueFun ? value : displayValue(value));
		return s.toString();
	}
}
