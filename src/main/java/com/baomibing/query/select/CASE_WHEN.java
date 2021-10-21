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

import java.util.List;
import java.util.stream.Collectors;

import com.baomibing.query.condition.ACondition;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.helper.InnerHelper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;
/**
 * SQL case when clause
 * 
 * @author zening
 * @date 2021-10-20 13:35:18
 * @since 1.0.0
 */
public class CASE_WHEN extends SQLFunction {

	private List<WHEN> whenList;
	public WHEN WHEN(ACondition... conditions) {
		if (whenList == null) {
			whenList = Lists.newArrayList();
		}
		WHEN when = new WHEN(conditions);
		whenList.add(when);
		return when;
	}
	
	private Object elseSQL;
	
	public <T> CASE_WHEN ELSE (SFunction<T, ?> fun) {
		elseSQL = new Field<T>(fun).toSQL();
		return this;
	}
	
	public <T> CASE_WHEN ELSE (Object v) {
		elseSQL = InnerHelper.displayValue(v);
		return this;
	}
	
	public CASE_WHEN THEN(Object v) {
		elseSQL = InnerHelper.displayValue(v);
		return this;
	}
	
	@Override
	public String toSQL() {
		String whenThenSql = whenList.stream().map(w -> w.toSQL()).collect(Collectors.joining());
		return Strings.LEFT_BRACKET + InnerHelper.format(SQLConsts.FUN_CASE_ELSE, whenThenSql, elseSQL) + Strings.RIGHT_BRACKET;
	}
	
	public class WHEN extends SQLFunction {
		
		private List<ACondition>  whenConditions;
		
		public WHEN(ACondition... conditions) {
			this.whenConditions = Lists.newArrayList();
			for(ACondition c : conditions) {
				this.whenConditions.add(c);
			}
		}
		
		private Object thenSQL;
		public <T> CASE_WHEN THEN(SFunction<T, ?> fun) {
			thenSQL = new Field<T>(fun).toSQL();
			return CASE_WHEN.this;
		}
		
		public CASE_WHEN THEN(Object v) {
			thenSQL = InnerHelper.displayValue(v);
			return CASE_WHEN.this;
			
		}
		
		@Override
		public String toSQL() {
			String whenSQL = whenConditions.stream().map(c -> c.toSQL()).collect(Collectors.joining());
			return InnerHelper.format(SQLConsts.FUN_WHEN_THEN, whenSQL, thenSQL);
		}
		
		
	}



	
	
}
