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

import org.apache.commons.lang3.ArrayUtils;

import com.baomibing.query.helper.InnerHelper;
import com.baomibing.query.select.Field;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * SQL customer function(where part)
 * 
 * <P> Example:
 * <pre><code>
 * abc REGEXP 'a$' -> QDL.condition(xxx::abc, "REGEXP '{0}'", "a$")
 * substr(abc,2 , 10) -> QDL.condition("substr({0},{1},{2}", xxx::abc, new Integer[]{2,10})
 * substr(abc, LOCATE('#', abc) + 1, 10 ) -> QDL.condition("substr({0}, LOCATE('''#''', {0}) + 1, {1})", xxx:abc, 10)
 * </code></pre>
 * 
 * @author zening
 * @since 1.0.0
 */
public class CTMCondition extends ACondition {

	private String funSQL = "";

	public <T> CTMCondition(SFunction<T, ?> propertyFunction, String sql, Object... args) {
		this.selectablePart = new Field<>(propertyFunction);
		funSQL = InnerHelper.format(sql, args);
	}
	
	public <T> CTMCondition(String sql, SFunction<T, ?> propertyFunction, Object... args) {
		String column = new Field<T>(propertyFunction).toSQL();
		ArrayUtils.add(args, column);
		funSQL = InnerHelper.format(sql, args);
	}
	
	public CTMCondition(String sql, Object... args) {
		funSQL = InnerHelper.format(sql, args);
	}
	
	@Override
	public String toSQL() {
		return selectablePart == null ? "" : selectablePart.toSQL() + funSQL;
	}
}
