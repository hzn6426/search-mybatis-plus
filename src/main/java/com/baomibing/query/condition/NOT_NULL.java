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
 * SQL is not null condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class NOT_NULL extends ACondition {
	
	private NOT_NULL(SelectablePart field, boolean beTrue) {
		if (beTrue) {
			this.selectablePart = field;
			this.operator = Operator.NOT_NULL.getOp();
		}
		this.beTrue = beTrue;
	}
	
	public NOT_NULL(FieldPart field) {
		this(field, true);
	}
	
	public NOT_NULL(boolean beTrue, FieldPart field) {
		this(field, beTrue);
	}
	
	public NOT_NULL(SFunction<?, ?> propertyFunction) {
		this(new Field<>(propertyFunction), true);
	}
	
	public NOT_NULL(boolean beTrue, SFunction<?, ?> propertyFunction) {
		this(new Field<>(propertyFunction), beTrue);
	}
	
	public NOT_NULL(Alias alias) {
		this(alias,true);
	}
	
	public NOT_NULL(boolean beTrue, Alias alias) {
		this(alias, beTrue);
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		s.append(selectablePart.toSQL()).append(OP_NOT_NULL);
		return s.toString();
	}
}
