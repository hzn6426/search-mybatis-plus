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

import java.util.Collection;

import com.baomibing.query.condition.ACondition;
import com.baomibing.query.condition.AND;
import com.baomibing.query.condition.BETWEEN;
import com.baomibing.query.condition.CTMCondition;
import com.baomibing.query.condition.EQ;
import com.baomibing.query.condition.EXISTS;
import com.baomibing.query.condition.FalseCondition;
import com.baomibing.query.condition.GT;
import com.baomibing.query.condition.GTE;
import com.baomibing.query.condition.IN;
import com.baomibing.query.condition.IS_NULL;
import com.baomibing.query.condition.LIKE;
import com.baomibing.query.condition.LLIKE;
import com.baomibing.query.condition.LT;
import com.baomibing.query.condition.LTE;
import com.baomibing.query.condition.NOT_EQ;
import com.baomibing.query.condition.NOT_EXISTS;
import com.baomibing.query.condition.NOT_IN;
import com.baomibing.query.condition.NOT_NULL;
import com.baomibing.query.condition.OR;
import com.baomibing.query.condition.RLIKE;
import com.baomibing.query.condition.TrueCondition;
import com.baomibing.query.select.AS;
import com.baomibing.query.select.AVG;
import com.baomibing.query.select.CASE_WHEN;
import com.baomibing.query.select.COUNT;
import com.baomibing.query.select.CTMFunction;
import com.baomibing.query.select.DISTINCT;
import com.baomibing.query.select.MAX;
import com.baomibing.query.select.MIN;
import com.baomibing.query.select.SQLFunction;
import com.baomibing.query.select.SUM;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * tool for create instance
 * 
 * @author zening
 * @since 1.0.0
 */
public class QDL {

	public static AND and(ACondition... conditions) {
		return new AND(conditions);
	}

	public static OR or(ACondition... conditions) {
		return new OR(conditions);
	}

	public static <T> LIKE like(SFunction<T, ?> propertyFunction, String value) {
		return new LIKE(propertyFunction, value);
	}

	public static <T> LIKE like(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LIKE(propertyFunction, sqlFunction);
	}

	public static <T> LLIKE llike(SFunction<T, ?> propertyFunction, String value) {
		return new LLIKE(propertyFunction, value);
	}

	public static <T> RLIKE rlike(SFunction<T, ?> propertyFunction, String value) {
		return new RLIKE(propertyFunction, value);
	}

	public static <T> EQ eq(SFunction<T, ?> propertyFunction, Object value) {
		return new EQ(propertyFunction, value);
	}

	public static <T1, T2> EQ eq(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new EQ(propertyFunction, valueFunction);
	}

	public static EQ eq(SQLFunction sqlFunction, Object value) {
		return new EQ(sqlFunction, value);
	}

	public static <T> EQ eq(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new EQ(sqlFunction, valueFunction);
	}

	public static <T> NOT_EQ not_eq(SFunction<T, ?> propertyFunction, Object value) {
		return new NOT_EQ(propertyFunction, value);
	}

	public static <T1, T2> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new NOT_EQ(propertyFunction, valueFunction);
	}

	public static NOT_EQ not_eq(SQLFunction sqlFunction, Object value) {
		return new NOT_EQ(sqlFunction, value);
	}

	public static <T> NOT_EQ not_eq(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new NOT_EQ(sqlFunction, valueFunction);
	}

	public static <T> GT gt(SFunction<T, ?> propertyFunction, Object value) {
		return new GT(propertyFunction, value);
	}

	public static <T1, T2> GT gt(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GT(propertyFunction, valueFunction);
	}

	public static GT gt(SQLFunction sqlFunction, Object value) {
		return new GT(sqlFunction, value);
	}

	public static <T> GT gt(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GT(sqlFunction, valueFunction);
	}

	public static <T> GTE gte(SFunction<T, ?> propertyFunction, Object value) {
		return new GTE(propertyFunction, value);
	}

	public static <T1, T2> GTE gte(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GTE(propertyFunction, valueFunction);
	}

	public static GTE gte(SQLFunction sqlFunction, Object value) {
		return new GTE(sqlFunction, value);
	}

	public static <T> GTE gte(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GTE(sqlFunction, valueFunction);
	}

	public static <T> LTE lte(SFunction<T, ?> propertyFunction, Object value) {
		return new LTE(propertyFunction, value);
	}

	public static <T1, T2> LTE lte(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LTE(propertyFunction, valueFunction);
	}

	public static LTE lte(SQLFunction sqlFunction, Object value) {
		return new LTE(sqlFunction, value);
	}

	public static <T> LTE lte(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LTE(sqlFunction, valueFunction);
	}

	public static <T> LT lt(SFunction<T, ?> propertyFunction, Object value) {
		return new LT(propertyFunction, value);
	}

	public static <T1, T2> LT lt(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LT(propertyFunction, valueFunction);
	}

	public static LT lt(SQLFunction sqlFunction, Object value) {
		return new LT(sqlFunction, value);
	}

	public static <T> LT lt(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LT(sqlFunction, valueFunction);
	}

	public static TrueCondition trueCondition() {
		return new TrueCondition();
	}

	public static FalseCondition falseCondition() {
		return new FalseCondition();
	}

	public static <T> BETWEEN between(SFunction<T, ?> propertyFunction, Object value1, Object value2) {
		return new BETWEEN(propertyFunction, value1, value2);
	}

	public static <T> IN in(SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new IN(propertyFunction, value);
	}
	
	public static <T> IN in(SFunction<?, ?> propertyFunction, SQLQuery query) {
		return new IN(propertyFunction, query);
	}

	public static <T> NOT_IN not_in(SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new NOT_IN(propertyFunction, value);
	}
	
	public static <T> NOT_IN not_in(SFunction<?, ?> propertyFunction, SQLQuery query) {
		return new NOT_IN(propertyFunction, query);
	}

	public static <T> IS_NULL is_null(SFunction<T, ?> propertyFunction) {
		return new IS_NULL(propertyFunction);
	}

	public static <T> NOT_NULL not_null(SFunction<T, ?> propertyFunction) {
		return new NOT_NULL(propertyFunction);
	}

	public static EXISTS exists(SQLQuery queryer) {
		return new EXISTS(queryer);
	}

	public static NOT_EXISTS not_exists(SQLQuery queryer) {
		return new NOT_EXISTS(queryer);
	}
	
	public static <T> CTMCondition condition(SFunction<T, ?> propertyFunction, String sql, Object... args) {
		return new CTMCondition(propertyFunction, sql, args);
	}
	
	public static <T> CTMCondition condition(String sql, Object... args) {
		return new CTMCondition(sql, args);
	}
	
	public static <T> CTMCondition condition(String sql, SFunction<T, ?> propertyFunction, Object... args) {
		return new CTMCondition(sql, propertyFunction, args);
	}

	public static AS as(SQLFunction fun, String alias) {
		return new AS(fun, alias);
	}

	public static <T> AS as(SFunction<T, ?> fun, String alias) {
		return new AS(fun, alias);
	}

	public static <T> AVG avg(SFunction<T, ?> fun) {
		return new AVG(fun);
	}

	public static <T> AVG avg(String sql) {
		return new AVG(sql);
	}

	public static CASE_WHEN case_when() {
		return new CASE_WHEN();
	}

	public static <T> COUNT count(SFunction<T, ?> fun) {
		return new COUNT(fun);
	}

	public static <T> COUNT count(String sql) {
		return new COUNT(sql);
	}

	public static <T> COUNT count(DISTINCT distinct) {
		return new COUNT(distinct);
	}
	
	public static <T> LimitOffset limitOffset(int pageNo, int pageSize) {
		return new LimitOffset(pageNo, pageSize);
	}

	public static <T> CTMFunction sql_fun(String fun, Object... args) {
		return new CTMFunction(fun, args);
	}

	public static <T> MAX max(SFunction<T, ?> fun) {
		return new MAX(fun);
	}

	public static <T> MAX max(String sql) {
		return new MAX(sql);
	}

	public static <T> MIN min(SFunction<T, ?> fun) {
		return new MIN(fun);
	}

	public static <T> MIN min(String sql) {
		return new MIN(sql);
	}

	public static <T> SUM sum(DISTINCT distinct) {
		return new SUM(distinct);
	}

	public static <T1> SUM sum(SFunction<T1, ?> fun) {
		return new SUM(fun);
	}

	public static <T1, T2> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {

		return new SUM(fun1, fun2);
	}

	public static <T1, T2, T3> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {

		return new SUM(fun1, fun2, fun3);
	}

	public static <T1, T2, T3, T4> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4) {

		return new SUM(fun1, fun2, fun3, fun4);
	}

	public static <T1, T2, T3, T4, T5> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		return new SUM(fun1, fun2, fun3, fun4, fun5);
	}

	public static <T1, T2, T3, T4, T5, T6> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6);
	}

	public static <T1, T2, T3, T4, T5, T6, T7> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SUM sum(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SUM sum(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SUM sum(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SUM sum(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SUM sum(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SUM sum(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SUM sum(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SUM sum(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SUM sum(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19, fun20);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SUM sum(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19, fun20, fun21);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SUM sum(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SFunction<T22, ?> fun22) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19, fun20, fun21, fun22);
	}
	
	public static <T1> DISTINCT distinct(SFunction<T1, ?> fun) {
		return new DISTINCT(fun);
	}

	public static <T1, T2> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {

		return new DISTINCT(fun1, fun2);
	}

	public static <T1, T2, T3> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {

		return new DISTINCT(fun1, fun2, fun3);
	}

	public static <T1, T2, T3, T4> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4) {

		return new DISTINCT(fun1, fun2, fun3, fun4);
	}

	public static <T1, T2, T3, T4, T5> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5);
	}

	public static <T1, T2, T3, T4, T5, T6> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6);
	}

	public static <T1, T2, T3, T4, T5, T6, T7> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6,
			SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> DISTINCT distinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> DISTINCT distinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> DISTINCT distinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> DISTINCT distinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> DISTINCT distinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13,
			SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> DISTINCT distinct(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> DISTINCT distinct(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> DISTINCT distinct(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> DISTINCT distinct(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19, fun20);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> DISTINCT distinct(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19, fun20, fun21);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> DISTINCT distinct(
			SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12,
			SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SFunction<T22, ?> fun22) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15,
				fun16, fun17, fun18, fun19, fun20, fun21, fun22);
	}

}
