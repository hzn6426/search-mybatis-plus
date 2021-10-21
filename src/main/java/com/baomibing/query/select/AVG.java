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

import org.apache.commons.lang3.StringUtils;

import com.baomibing.query.QueryPart;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.helper.InnerHelper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;
/**
 * SQL AVG function
 * 
 * @author zening
 * @since 1.0.0
 */
public class AVG extends SQLFunction {

	private List<QueryPart> fields;
	
	private String sql;
	
	public AVG(String sql) {
		this.sql = sql;
	}
	

	public <T1> AVG(SFunction<T1, ?> fun) {

		this(new Field<>(fun));
	}

	
	private AVG(QueryPart... parts) {
		if (fields == null) {
			fields = Lists.newArrayList();
		}
		for (QueryPart q : parts) {
			fields.add(q);
		}
	}

	

	public String toSQL() {
		return InnerHelper.format(SQLConsts.FUN_AVG, StringUtils.isNotBlank(sql) ? sql : this.fields.stream().map(f -> f.toSQL()).collect(Collectors.joining(",")));
	}
}
