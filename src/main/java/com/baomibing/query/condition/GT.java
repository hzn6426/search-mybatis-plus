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

import com.baomibing.query.helper.MyBatisPlusHelper;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.SQLFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * SQL greater than condition
 * 
 * @author zening
 * @data 2021-10-20 11:28:34
 * @since 1.0.0
 */
public class GT extends ACondition {
	
	private boolean beValueFun = false;

	public  GT(SFunction<?, ?> propertyFunction, Object value) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.GT.getOp();
		this.value = value;
	}
	
	public <T1,T2> GT(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.GT.getOp();
		this.value = MyBatisPlusHelper.columnToString(valueFunction);
		this.beValueFun = true;
	}
	
	public <T1> GT(SQLFunction sqlFunction, Object value) {
		this.selectablePart = sqlFunction;
		this.operator = Operator.GT.getOp();
		this.value = value;
	}
	
	public <T1> GT(SQLFunction sqlFunction, SFunction<T1, ?> valueFunction) {
		this.selectablePart = sqlFunction;
		this.operator = Operator.GT.getOp();
		this.value = MyBatisPlusHelper.columnToString(valueFunction);
		this.beValueFun = true;
	}

	@Override
	public String toSQL() {
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_GT).append(beValueFun ? value :  displayValue(value));
		return s.toString();
	}
	
	
}
