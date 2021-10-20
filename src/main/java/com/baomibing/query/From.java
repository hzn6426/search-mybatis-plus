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
package com.baomibing.query;


import com.baomibing.query.helper.MyBatisPlusHelper;

import lombok.Getter;
/**
 * SQL from part
 * 
 * @author zening
 * @data 2021-10-20 13:39:49
 * @since 1.0.0
 */
@Getter
public class From  implements QueryPart {
	
	private Class<?> relationClass;

	public From(Class<?> clazz) {
		this.relationClass = clazz;
	}

	@Override
	public String toSQL() {
//		return SQLConsts.SQL_FROM +  MyBatisPlusHelper.getTableName(relationClass);
		return  MyBatisPlusHelper.getTableName(relationClass);
	}
}