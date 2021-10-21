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

import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.helper.InnerHelper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;
/**
 * SQL sum function
 * 
 * @author zening
 * @date 2021-10-20 13:38:59
 * @since 1.0.0
 */
public class SUM extends SQLFunction {

	private List<FieldPart> fields;
	
	
	public SUM(DISTINCT distinct) {
		this(new FieldPart[] {distinct});
	}

	public <T1> SUM(SFunction<T1, ?> fun) {

		this(new Field<>(fun));
	}

	public <T1, T2> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {

		this(new Field<>(fun1), new Field<>(fun2));
	}

	public <T1, T2, T3> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3));
	}

	public <T1, T2, T3, T4> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4));
	}

	public <T1, T2, T3, T4, T5> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5));
	}

	public <T1, T2, T3, T4, T5, T6> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6));
	}

	public <T1, T2, T3, T4, T5, T6, T7> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SUM(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SUM(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SUM(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SUM(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SUM(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SUM(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SUM(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SUM(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SUM(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SUM(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21) {

		this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20),
				new Field<>(fun21));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SUM(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SFunction<T22, ?> fun22) {

	  this(new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20),
				new Field<>(fun21), new Field<>(fun22));
	}

	private SUM(FieldPart... parts) {
		if (fields == null) {
			fields = Lists.newArrayList();
		}
		for (FieldPart q : parts) {
			fields.add(q);
		}
	}

	

	public String toSQL() {
		return InnerHelper.format(SQLConsts.FUN_SUM, this.fields.stream().map(f -> f.toSQL()).collect(Collectors.joining(",")));
	}
}
