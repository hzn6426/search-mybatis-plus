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

import org.apache.commons.lang3.ArrayUtils;

import com.baomibing.query.constant.Strings;
import com.baomibing.query.helper.InnerHelper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * User customer sql function(select part)
 * 
 * @author zening
 * @date 2021-10-20 11:24:18
 * @since 1.0.0
 */
public class CTMFunction extends SQLFunction {
	
	private String funSQL = "";
	private String column = "";

	public CTMFunction(String fun, Object... args) {
		funSQL = InnerHelper.format(fun, args);
	}
	
	public <T> CTMFunction(SFunction<T, ?> propertyFunction, String sql, Object... args) {
		column = new Field<>(propertyFunction).toSQL();
		funSQL = InnerHelper.format(sql, args);
	}
	
	public <T> CTMFunction(String sql, SFunction<T, ?> propertyFunction, Object... args) {
		String column = new Field<T>(propertyFunction).toSQL();
		ArrayUtils.add(args, column);
		funSQL = InnerHelper.format(sql, args);
	}
	
	@Override
	public String toSQL() {
		return column + Strings.SPACE + funSQL;
	}

}
