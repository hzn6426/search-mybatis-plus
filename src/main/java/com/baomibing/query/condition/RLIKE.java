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
import com.baomibing.query.select.*;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * SQL like condition(like 'xxx%')
 * 
 * @author zening
 * @since 1.0.0
 */
public class RLIKE extends ACondition {
	
	private boolean beValueFun = false;
	
	private RLIKE (boolean beTrue, SelectablePart field, Object value, boolean beValueFun) {
		if (beTrue) {
			this.selectablePart = field;
			this.operator = Operator.LIKE.getOp();
			this.value = value;
			this.beValueFun = beValueFun;
		}
		this.beTrue = beTrue;
	}
	
	public RLIKE(FieldPart field, String value) {
		this(true, field, value, false);
	}
	
	public RLIKE(boolean beTrue, FieldPart field, String value) {
		this(beTrue, field, value, false);
	}
	
	public <T> RLIKE(SFunction<T, ?> propertyFunction, String value) {
		this(true, new Field<>(propertyFunction), value, false);
	}
	
	public <T1> RLIKE(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this(true, new Field<>(propertyFunction), sqlFunction, false);
	}
	
	public <T> RLIKE(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		this(beTrue, new Field<>(propertyFunction), value, false);
	}
	
	public <T1> RLIKE(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		this(true, new Field<>(propertyFunction), sqlFunction, false);
	}
	
	
	public  RLIKE(Alias alias1, Alias alias2) {
		this(true, alias1, alias2, true);
	}
	
	public RLIKE(Alias alias, String value) {
		this(true, alias, value, false);
	}
	
	public  RLIKE(boolean beTrue, Alias alias1, Alias alias2) {
		this(beTrue, alias1, alias1, true);
	}
	
	public RLIKE(boolean beTrue, Alias alias, String value) {
		this(beTrue, alias, value, false);
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		StringBuilder s = new StringBuilder();
		if (beValueFun) {
			s.append(selectablePart.toSQL()).append(OP_LIKE).append(InnerHelper.format(SQLConsts.FUN_CONCAT, "", displayValue(value),"'%'"));
    } else {
      s.append(selectablePart.toSQL()).append(OP_LIKE).append("'").append(value).append("%'");
		}
		return s.toString();
	}

}
