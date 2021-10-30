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
import com.baomibing.query.helper.InnerHelper;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.apache.commons.lang3.ArrayUtils;
/**
 * SQL customer function(where part)
 * 
 * <P> Example:
 * <pre><code>
 * abc REGEXP 'a$' - QDL.condition(xxx::abc, "REGEXP '{0}'", "a$")
 * substr(abc,2 , 10) - QDL.condition("substr({0},{1},{2}", xxx::abc, new Integer[]{2,10})
 * substr(abc, LOCATE('#', abc) + 1, 10 ) - QDL.condition("substr({0}, LOCATE('''#''', {0}) + 1, {1})", xxx:abc, 10)
 * </code></pre>
 * 
 * @author zening
 * @since 1.0.0
 */
public class CTMCondition extends ACondition {

	private String funSQL = "";

	public <T> CTMCondition(SFunction<T, ?> propertyFunction, String sql, Object... args) {
		this(true, propertyFunction, sql, args);
	}
	
	public <T> CTMCondition(Alias alias, String sql, Object... args) {
		this(true, alias, sql, args);
	}
	
	public <T> CTMCondition(String sql, Alias alias, Object... args) {
		this(true, sql, alias, args);
	}
	
	public <T> CTMCondition(String sql, SFunction<T, ?> propertyFunction, Object... args) {
		this(true, sql, propertyFunction, args);
	}
	
	public CTMCondition(String sql, Object... args) {
		this(true, sql, args);
	}
	
	public <T> CTMCondition(boolean beTrue, SFunction<T, ?> propertyFunction, String sql, Object... args) {
		if (beTrue) {
			this.selectablePart = new Field<>(propertyFunction);
			funSQL = InnerHelper.format(sql, args);
		}
		this.beTrue = beTrue;
	}
	
	public <T> CTMCondition(boolean beTrue, Alias alias, String sql, Object... args) {
		if (beTrue) {
			this.selectablePart = alias;
			funSQL = InnerHelper.format(sql, args);
		}
		this.beTrue = beTrue;
	}

	public <T> CTMCondition(boolean beTrue, String sql, SFunction<T, ?> propertyFunction, Object... args) {
		if (beTrue) {
			String column = new Field<T>(propertyFunction).toSQL();
			args = ArrayUtils.add(args, column);
			funSQL = InnerHelper.format(sql, args);
		}
		this.beTrue = beTrue;
	}
	
	public <T> CTMCondition(boolean beTrue, String sql, Alias alias, Object... args) {
		if (beTrue) {
			String column = alias.toSQL();
			args = ArrayUtils.add(args, column);
			funSQL = InnerHelper.format(sql, args);
		}
		this.beTrue = beTrue;
	}

	public CTMCondition(boolean beTrue, String sql, Object... args) {
		if (beTrue) {
			funSQL = InnerHelper.format(sql, args);
		}
		this.beTrue = beTrue;
	}

	@Override
	public String toSQL() {
		if (!beTrue) {
			return Strings.EMPTY;
		}
		return selectablePart == null ? "" : selectablePart.toSQL() + funSQL;
	}
}
