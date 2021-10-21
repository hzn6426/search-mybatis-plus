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
package com.baomibing.query.select;

import com.baomibing.query.Type;
import com.baomibing.query.helper.MyBatisPlusHelper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * SQL select field(table column)
 * 
 * @author zening
 * @date 2021-10-20 13:36:08
 * @since 1.0.0
 */
public class Field<T> extends FieldPart implements Type<T> {

	private SFunction<T, ?> columnFun;
	
	private String columnName;
	
	public Field(SFunction<T, ?> fun) {
		this.columnFun = fun;
		columnName = MyBatisPlusHelper.columnToString(columnFun);
	}
	
	public Field(String field) {
		columnName = field;
	}
	
	@Override
	public String toSQL() {
		return columnName;
	}
}
