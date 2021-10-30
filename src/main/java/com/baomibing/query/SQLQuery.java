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

import com.baomibing.query.condition.ACondition;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.constant.Strings;
import com.baomibing.query.relation.CrossJoin;
import com.baomibing.query.relation.InnerJoin;
import com.baomibing.query.relation.LeftJoin;
import com.baomibing.query.relation.Relation;
import com.baomibing.query.relation.RightJoin;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.DISTINCT;
import com.baomibing.query.select.SelectablePart;
import com.baomibing.query.sql.QueryerSQL;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;

/**
 * Common SQL Query
 *
 * @author zening
 * @since 1.0.0
 */
public class SQLQuery extends QueryerSQL implements IQuery {

	private Select selector;

	private final List<Relation> relations = Lists.newArrayList();

	private Where where;

	private GroupBy groupBy;

	private OrderBy orderBy;

	private Having having;

	private From from;

	private LimitOffset limitOffset;

	public SQLQuery selectFrom(Class<?> clazz) {
		from = new From(clazz);
		this.fromPart = from.toSQL();
		fromClass = clazz;
//		this.selector = new Select(MyBatisPlusHelper.getAllColumnNames(from.getRelationClass()));
//		this.selectPart = selector.toSQL();
		return this;
	}

	public SQLQuery from(Class<?> clazz) {
		from = new From(clazz);
		this.fromPart = from.toSQL();
		fromClass = clazz;
		return this;
	}
	
	public SQLQuery from(SQLQuery query, String alias) {
		from = new From(query, alias);
		this.fromPart = from.toSQL();
		fromClass = from.getRelationClass();
		return this;
	}
	
	public SQLQuery from(Alias alias) {
		from = new From(alias);
		this.fromPart = from.toSQL();
		fromClass = alias.getTableClass();
		return this;
	}

	public SQLQuery where(ACondition... conditions) {
		this.where = new Where(conditions);
		this.wherePart = where.toSQL();
		return this;
	}

	public SQLQuery select(DISTINCT distinct) {
		this.selector = new Select(distinct);
		this.selectPart = selector.toSQL();
		return this;
	}
	
	public SQLQuery select(SelectablePart... selectableParts) {
		this.selector = new Select(selectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

//	public SQLQuery select(Alias... aliases) {
//		this.selector = new Select(aliases);
//		this.selectPart = selector.toSQL();
//		return this;
//	}
//
//	public SQLQuery select(SQLFunction... sqlFunctions) {
//		this.selector = new Select(sqlFunctions);
//		this.selectPart = selector.toSQL();
//		return this;
//	}

	public <T1> SQLQuery select(SFunction<T1, ?> fun, SelectablePart... SelectableParts) {
		this.selector = new Select(fun, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20,
				SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21,
			SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21,
				SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SQLQuery select(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21,
			SFunction<T22, ?> fun22, SelectablePart... SelectableParts) {
		this.selector = new Select(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21, fun22,
				SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}
	
//	public <T1> SQLQuery selectDistinct(Alias... aliases) {
//		this.selector = new SelectDistinct(aliases);
//		this.selectPart = selector.toSQL();
//		return this;
//	}

	public <T1> SQLQuery selectDistinct(SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1> SQLQuery selectDistinct(SFunction<T1, ?> fun, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19,
				SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20,
				SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLQuery selectDistinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21,
			SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21,
				SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SQLQuery selectDistinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14,
			SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SFunction<T22, ?> fun22, SelectablePart... SelectableParts) {
		this.selector = new SelectDistinct(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21,
				fun22, SelectableParts);
		this.selectPart = selector.toSQL();
		return this;
	}

	public SQLQuery leftJoin(Class<?> clazz, ACondition... conditions) {
		relations.add(new LeftJoin(clazz, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}
	
	public SQLQuery leftJoin(Alias alias, ACondition... conditions) {
		relations.add(new LeftJoin(alias, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery leftJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
		relations.add(new LeftJoin(beTrue, clazz, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery rightJoin(Class<?> clazz, ACondition... conditions) {
		relations.add(new RightJoin(clazz, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}
	
	public SQLQuery rightJoin(Alias alias, ACondition... conditions) {
		relations.add(new RightJoin(alias, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery rightJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
		relations.add(new RightJoin(beTrue, clazz, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery crossJoin(Class<?> clazz) {
		relations.add(new CrossJoin(clazz));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery crossJoin(boolean beTrue, Class<?> clazz) {
		relations.add(new CrossJoin(beTrue, clazz));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery innerJoin(Class<?> clazz, ACondition... conditions) {
		relations.add(new InnerJoin(clazz, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}
	
	public SQLQuery innerJoin(Alias alias, ACondition... conditions) {
		relations.add(new InnerJoin(alias, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}

	public SQLQuery innerJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
		relations.add(new InnerJoin(beTrue, clazz, conditions));
		relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
		return this;
	}
	
	public <T1> SQLQuery groupBy(Alias... aliases) {
		if (groupBy == null) {
			groupBy = new GroupBy(aliases);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}
	
	public <T1> SQLQuery groupBy(SFunction<T1, ?> fun) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLQuery groupBy(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
		if (groupBy == null) {
			groupBy = new GroupBy(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
			groupByPart = groupBy.toSQL();
		}
		return this;
	}
	
	public  SQLQuery orderByasc(Alias... aliases) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(aliases);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}
	
	public <T1> SQLQuery orderByasc(SFunction<T1, ?> fun) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLQuery orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}
	
	public SQLQuery orderBydesc(Alias... aliases) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(aliases);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1> SQLQuery orderBydesc(SFunction<T1, ?> fun) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLQuery orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
		if (orderBy == null) {
			orderBy = new OrderBy();
			orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
			orderByPart = orderBy.toSQL();
		}
		return this;
	}

	public SQLQuery having(ACondition... conditions) {
		having = new Having(conditions);
		havingPart = having.toSQL();
		return this;
	}

	public SQLQuery limitOffset(int pageNumber, int pageSize) {
		limitOffset = new LimitOffset(pageNumber, pageSize);
		limitOffsetPart = limitOffset.toSQL();
		return this;
	}

	public String toSQL() {
		StringBuilder s = new StringBuilder();
		String select = "";
		if (selector == null) {
			select = SQLConsts.SQL_SELECT + Strings.ASTERISK;
		} else {
			select = SQLConsts.SQL_SELECT + selector.toSQL();
		}
		s.append(select).append(SQLConsts.SQL_FROM + from.toSQL());
		if (relations != null && !relations.isEmpty()) {
			s.append(relations.stream().map(r -> r.toSQL()).collect(Collectors.joining()));
		}
		if (where != null) {
			s.append(where.toSQL());
		}
		if (groupBy != null) {
			s.append(groupBy.toSQL());
		}
		if (having != null) {
			s.append(having.toSQL());
		}
		if (orderBy != null) {
			s.append(orderBy.toSQL());
		}
		if (limitOffset != null) {
			s.append(limitOffset.toSQL());
		}
		return s.toString();
	}

}
