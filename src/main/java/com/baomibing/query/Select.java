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

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import com.baomibing.query.select.DISTINCT;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.FieldPart;
import com.baomibing.query.select.SQLFunction;
import com.baomibing.query.select.SelectablePart;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;
/**
 * SQL select part
 * 
 * @author zening
 * @data 2021-10-20 13:44:40
 * @since 1.0.0
 */
public class Select implements QueryPart {

	protected List<SelectablePart> selectableParts;
	
	protected String columns;
	
	public Select(String select) {
		this.columns = select;
	}
	
	public Select(SQLFunction... sqlFunctions) {
		this(ArrayUtils.addAll(new FieldPart[] {}, sqlFunctions));
	}
	
	public Select(DISTINCT distinct) {
		this(new SelectablePart[] {distinct});
	}

	public <T1> Select(SFunction<T1, ?> fun, SQLFunction...sqlFunctions) {
		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun)}, sqlFunctions));
	}

	public <T1, T2> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SQLFunction...sqlFunctions) {
		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2)}, sqlFunctions));
	}

	public <T1, T2, T3> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3)}, sqlFunctions));
	}

	public <T1, T2, T3, T4> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Select(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Select(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Select(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Select(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Select(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Select(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Select(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Select(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Select(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SQLFunction...sqlFunctions) {

		this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20),
				new Field<>(fun21)}, sqlFunctions));
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Select(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SFunction<T22, ?> fun22, SQLFunction...sqlFunctions) {

	  this(ArrayUtils.addAll(new SelectablePart[] {new Field<>(fun1), new Field<>(fun2), new Field<>(fun3), new Field<>(fun4), new Field<>(fun5),
				new Field<>(fun6), new Field<>(fun7), new Field<>(fun8), new Field<>(fun9), new Field<>(fun10),
				new Field<>(fun11), new Field<>(fun12), new Field<>(fun13), new Field<>(fun14), new Field<>(fun15),
				new Field<>(fun16), new Field<>(fun17), new Field<>(fun18), new Field<>(fun19), new Field<>(fun20),
				new Field<>(fun21), new Field<>(fun22)}, sqlFunctions));
	}

	private Select(SelectablePart... parts) {
		if (selectableParts == null) {
			selectableParts = Lists.newArrayList();
		}
		for (SelectablePart q : parts) {
			selectableParts.add(q);
		}
		this.columns = this.selectableParts.stream().map(f -> f.toSQL()).collect(Collectors.joining(","));
	}

	

	public String toSQL() {
		return this.columns;
	}
}
