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
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.FieldPart;
import com.baomibing.query.select.SelectablePart;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * SQL between and Condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class BETWEEN extends ACondition {
	
	private BETWEEN(SelectablePart field, Object value1, Object value2, boolean beTrue) {
		if (beTrue) {
			this.selectablePart = field;
			this.operator = Operator.BETWEEN.getOp();
			this.value = value1;
			this.value2 = value2;
		}
		this.beTrue = beTrue;
	}

	public <T> BETWEEN(SFunction<T, ?> propertyFunction, Object value1, Object value2) {
		this(new Field<>(propertyFunction), value1, value2, true);
	}
	
	public  BETWEEN(boolean beTrue, FieldPart field, Object value1, Object value2) {
		this(field, value1, value2, beTrue);
	}
	
	public  BETWEEN(FieldPart field, Object value1, Object value2) {
		this(field, value1, value2, true);
	}

	public BETWEEN(boolean beTrue, SFunction<?, ?> propertyFunction, Object value1, Object value2) {
		
		this(new Field<>(propertyFunction), value1, value2, beTrue);
	}
	
	public BETWEEN(Alias alias, Object value1, Object value2) {
		this(alias, value1, value2, true);
	}
	
	public BETWEEN(boolean beTrue, Alias alias, Object value1, Object value2) {
		this(alias, value1, value2, beTrue);
	}
	
	

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_BETWEEN).append(displayValue(value)).append(OP_AND).append(displayValue(value2));
		return s.toString();
	}
	
	
}
