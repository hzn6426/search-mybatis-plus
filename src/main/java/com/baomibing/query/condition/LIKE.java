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

import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.helper.InnerHelper;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.SQLFunction;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * SQL like condition
 * 
 * @author zening
 * @since 1.0.0
 */
public class LIKE extends ACondition {
	
	private boolean beValueFun = false;

	public LIKE(SFunction<?, ?> propertyFunction, String value) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.LIKE.getOp();
		this.value = value;
	}

	public <T1> LIKE(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this.selectablePart = new Field<>(propertyFunction);
		this.operator = Operator.LIKE.getOp();
		this.value = sqlFunction;
	}

	public LIKE(boolean beTrue, SFunction<?, ?> propertyFunction, String value) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			this.operator = Operator.LIKE.getOp();
			this.value = value;
		}
		this.beTrue = beTrue;
	}

	public <T1> LIKE(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			this.operator = Operator.LIKE.getOp();
			this.value = sqlFunction;
		}
		this.beTrue = beTrue;
	}
	
	
	public  LIKE(Alias alias1, Alias alias2) {
		this.selectablePart = alias1;
		this.operator = Operator.LIKE.getOp();
		this.value = alias2;
		this.beValueFun = true;
	}
	
	public LIKE(Alias alias, String value) {
		this.selectablePart = alias;
		this.operator = Operator.LIKE.getOp();
		this.value = value;
	}
	
	public  LIKE(boolean beTrue, Alias alias1, Alias alias2) {
    if (beTrue) {
      this.selectablePart = alias1;
      this.operator = Operator.LIKE.getOp();
      this.value = alias2;
      this.beValueFun = true;
		}
    this.beTrue = beTrue;
	}
	
	public LIKE(boolean beTrue, Alias alias, String value) {
    if (beTrue) {
      this.selectablePart = alias;
      this.operator = Operator.LIKE.getOp();
      this.value = value;
		}
    this.beTrue = beTrue;
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		if (value instanceof SQLFunction) {
			s.append(selectablePart.toSQL()).append(OP_LIKE).append(((SQLFunction) value).toSQL());
		} else {
			if (beValueFun) {
				s.append(selectablePart.toSQL()).append(OP_LIKE).append(InnerHelper.format(SQLConsts.FUN_CONCAT, "'%'", displayValue(value),"'%'"));
      } else {
        s.append(selectablePart.toSQL()).append(OP_LIKE).append("'%").append(value).append("%'");
			}
		}
		return s.toString();
	}

}
