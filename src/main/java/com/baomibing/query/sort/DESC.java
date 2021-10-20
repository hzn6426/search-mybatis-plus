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
package com.baomibing.query.sort;
import java.util.List;
import java.util.stream.Collectors;

import com.baomibing.query.QueryPart;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.select.Field;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;
/**
 * SQL order desc
 * 
 * @author zening
 * @data 2021-10-20 13:39:36
 * @since 1.0.0
 */
public class DESC implements QueryPart {
	
	private List<QueryPart> fields;
	
	public <T> DESC(SFunction<T, ?> fun) {
		this(new Field<T>(fun));
	}
	
	public <T1,T2> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
		this(new Field<>(fun1), new Field<>(fun2));
	}
	
	public <T1,T2,T3> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3));
	}
	
	public <T1,T2,T3,T4> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4));
	}
	
	public <T1,T2,T3,T4,T5> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5));
	}
	
	public <T1,T2,T3,T4,T5,T6> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15), new Field<>(fun16));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15), new Field<>(fun16)
				, new Field<>(fun17));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15), new Field<>(fun16)
				, new Field<>(fun17), new Field<>(fun18));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15), new Field<>(fun16)
				, new Field<>(fun17), new Field<>(fun18), new Field<>(fun19));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15), new Field<>(fun16)
				, new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20));
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21> DESC(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5), new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10), new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15), new Field<>(fun16)
				, new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20), new Field<>(fun21));
	}
	
	private DESC(QueryPart... parts) {
		if (fields == null) {
			fields = Lists.newArrayList();
		}
		for (QueryPart q : parts) {
			fields.add(q);
		}
	}
	
	@Override
	public String toSQL() {
		return fields.stream().map(f -> f.toSQL()).collect(Collectors.joining(",")) + SQLConsts.SQL_DESC;
	}

}
