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

import com.baomibing.query.select.Field;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * SQL between and Condition
 * 
 * @author zening
 * @data 2021-10-20 10:51:39
 * @since 1.0.0
 */
public class BETWEEN extends ACondition {
	

	public  BETWEEN(SFunction<?, ?> propertyFunction, Object value1, Object value2) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.BETWEEN.getOp();
		this.value = value1;
		this.value2 = value2;
		
	}

	@Override
	public String toSQL() {
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_BETWEEN).append(displayValue(value)).append(OP_AND).append(displayValue(value2));
		return s.toString();
	}
	
	
}
