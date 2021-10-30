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
import com.baomibing.query.expression.ADD;
import com.baomibing.query.expression.DIVISION;
import com.baomibing.query.expression.Expression;
import com.baomibing.query.expression.MOD;
import com.baomibing.query.expression.MULTIPL;
import com.baomibing.query.expression.POW;
import com.baomibing.query.expression.SUBTRACT;
import com.baomibing.query.select.AS;
import com.baomibing.query.select.AVG;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.CASE_WHEN;
import com.baomibing.query.select.COUNT;
import com.baomibing.query.select.CTMFunction;
import com.baomibing.query.select.DISTINCT;
import com.baomibing.query.select.Field;
import com.baomibing.query.select.FieldPart;
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
	
	public static Alias alias(Class<?> table, String aliasName) {
		return new Alias(table, aliasName);
	}
	
	public static AND and(ACondition... conditions) {
		return new AND(conditions);
	}

	public static OR or(ACondition... conditions) {
		return new OR(conditions);
	}

	public static AND and(boolean beTrue, ACondition... conditions) {
		return new AND(beTrue, conditions);
	}

	public static OR or(boolean beTrue, ACondition... conditions) {
		return new OR(beTrue, conditions);
	}

	public static <T> Field<T> field(String column) {return new Field<>(column);}
	
	public static LIKE like(FieldPart field, String value) {return new LIKE(field, value);}
	
	public static LIKE like(boolean beTrue, FieldPart field, String value) {return new LIKE(beTrue, field, value);}
	
	public static <T> LIKE like(SFunction<T, ?> propertyFunction, String value) {
		return new LIKE(propertyFunction, value);
	}

	public static <T> LIKE like(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		return new LIKE(beTrue, propertyFunction, value);
	}

	public static <T> LIKE like(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LIKE(propertyFunction, sqlFunction);
	}

	public static <T> LIKE like(boolean beTrue, SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LIKE(beTrue, propertyFunction, sqlFunction);
	}
	
	public static <T> LIKE like(Alias alias, String value) {
		return new LIKE(alias, value);
	}
	
	public static <T> LIKE like(Alias alias1, Alias alias2) {
		return new LIKE(alias1, alias2);
	}
	
	public static <T> LIKE like(boolean beTrue, Alias alias, String value) {
		return new LIKE(beTrue, alias, value);
	}
	
	public static <T> LIKE like(boolean beTrue, Alias alias1, Alias alias2) {
		return new LIKE(beTrue, alias1, alias2);
	}
	

	public static <T> LLIKE llike(FieldPart field, String value) {
		return new LLIKE(field, value);
	}
	
	public static <T> LLIKE llike(boolean beTrue, FieldPart field, String value) {
		return new LLIKE(beTrue, field, value);
	}
	
	public static <T> LLIKE llike(SFunction<T, ?> propertyFunction, String value) {
		return new LLIKE(propertyFunction, value);
	}

	public static <T> LLIKE llike(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		return new LLIKE(beTrue, propertyFunction, value);
	}

	public static <T> LLIKE llike(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LLIKE(propertyFunction, sqlFunction);
	}

	public static <T> LLIKE llike(boolean beTrue, SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LLIKE(beTrue, propertyFunction, sqlFunction);
	}
	
	public static <T> LLIKE llike(Alias alias, String value) {
		return new LLIKE(alias, value);
	}
	
	public static <T> LLIKE llike(Alias alias1, Alias alias2) {
		return new LLIKE(alias1, alias2);
	}
	
	public static <T> LLIKE llike(boolean beTrue, Alias alias, String value) {
		return new LLIKE(beTrue, alias, value);
	}
	
	public static <T> LLIKE llike(boolean beTrue, Alias alias1, Alias alias2) {
		return new LLIKE(beTrue, alias1, alias2);
	}
	
	public static <T> RLIKE rlike(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new RLIKE(propertyFunction, sqlFunction);
	}

	public static <T> RLIKE rlike(boolean beTrue, SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new RLIKE(beTrue, propertyFunction, sqlFunction);
	}

	public static <T> RLIKE rlike(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		return new RLIKE(beTrue, propertyFunction, value);
	}

	public static <T> RLIKE rlike(SFunction<T, ?> propertyFunction, String value) {
		return new RLIKE(propertyFunction, value);
	}

	public static <T> RLIKE rlike(FieldPart field, String value) {
		return new RLIKE(field, value);
	}
	
	public static <T> RLIKE rlike(boolean beTrue, FieldPart field, String value) {
		return new RLIKE(beTrue, field, value);
	}
	
	public static <T> RLIKE rlike(Alias alias, String value) {
		return new RLIKE(alias, value);
	}
	
	public static <T> RLIKE rlike(Alias alias1, Alias alias2) {
		return new RLIKE(alias1, alias2);
	}
	
	public static <T> RLIKE rlike(boolean beTrue, Alias alias, String value) {
		return new RLIKE(beTrue, alias, value);
	}
	
	public static <T> RLIKE rlike(boolean beTrue, Alias alias1, Alias alias2) {
		return new RLIKE(beTrue, alias1, alias2);
	}
	
	public static <T> EQ eq(FieldPart field, Object value) {
		return new EQ(field, value);
	}
	
	public static <T> EQ eq(boolean beTrue, FieldPart field, Object value) {
		return new EQ(beTrue, field, value);
	}

	public static <T> EQ eq(SFunction<T, ?> propertyFunction, Object value) {
		return new EQ(propertyFunction, value);
	}

	public static <T1, T2> EQ eq(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new EQ(propertyFunction, valueFunction);
	}
	
	public static <T1> EQ eq(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new EQ(propertyFunction, sqlFunction);
	}

	public static EQ eq(SQLFunction sqlFunction, Object value) {
		return new EQ(sqlFunction, value);
	}

	public static <T> EQ eq(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new EQ(sqlFunction, valueFunction);
	}
	
	public static <T1> EQ eq(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new EQ(propertyFunction, expression);
	}
	
	public static <T> EQ eq(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new EQ(beTrue, propertyFunction, value);
	}

	public static <T1, T2> EQ eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new EQ(beTrue, propertyFunction, valueFunction);
	}

	public static EQ eq(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new EQ(beTrue, sqlFunction, value);
	}

	public static <T> EQ eq(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new EQ(beTrue, sqlFunction, valueFunction);
	}
	
	public static <T1> EQ eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new EQ(beTrue, propertyFunction, sqlFunction);
	}
	
	public static <T1> EQ eq(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new EQ(beTrue, propertyFunction, expression);
	}
	
	public static EQ eq(Alias alias1, Alias alias2) {
		return new EQ(alias1, alias2);
	}
	
	public static EQ eq (Alias alias, Object value) {
		return new EQ(alias, value);
	}
	
	public static EQ eq (Alias alias, Expression expression) {
		return new EQ(alias, expression);
	}
	
	public static EQ eq (boolean beTrue, Alias alias1, Alias alias2) {
		return new EQ(beTrue, alias1, alias2);
	}
	
	public static EQ eq (boolean beTrue, Alias alias, Object value) {
		return new EQ(beTrue, alias, value);
	}
	
	public static EQ eq (boolean beTrue, Alias alias, Expression expression) {
		return new EQ(beTrue, alias, expression);
	}
	

	public static <T> NOT_EQ not_eq(FieldPart field, Object value) {
		return new NOT_EQ(field, value);
	}
	
	public static <T> NOT_EQ not_eq(boolean beTrue, FieldPart field, Object value) {
		return new NOT_EQ(beTrue, field, value);
	}

	public static <T> NOT_EQ not_eq(SFunction<T, ?> propertyFunction, Object value) {
		return new NOT_EQ(propertyFunction, value);
	}

	public static <T1, T2> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new NOT_EQ(propertyFunction, valueFunction);
	}

	public static <T1> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new NOT_EQ(propertyFunction, sqlFunction);
	}

	public static NOT_EQ not_eq(SQLFunction sqlFunction, Object value) {
		return new NOT_EQ(sqlFunction, value);
	}

	public static <T> NOT_EQ not_eq(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new NOT_EQ(sqlFunction, valueFunction);
	}

	public static <T1> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new NOT_EQ(propertyFunction, expression);
	}

	public static <T> NOT_EQ not_eq(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new NOT_EQ(beTrue, propertyFunction, value);
	}

	public static <T1, T2> NOT_EQ not_eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new NOT_EQ(beTrue, propertyFunction, valueFunction);
	}

	public static NOT_EQ not_eq(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new NOT_EQ(beTrue, sqlFunction, value);
	}

	public static <T> NOT_EQ not_eq(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new NOT_EQ(beTrue, sqlFunction, valueFunction);
	}
	
	public static <T1> NOT_EQ not_eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new NOT_EQ(beTrue, propertyFunction, sqlFunction);
	}

	public static <T1> NOT_EQ not_eq(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new NOT_EQ(beTrue, propertyFunction, expression);
	}

	public static NOT_EQ not_eq(Alias alias1, Alias alias2) {
		return new NOT_EQ(alias1, alias2);
	}
	
	public static NOT_EQ not_eq (Alias alias, Object value) {
		return new NOT_EQ(alias, value);
	}
	
	public static NOT_EQ not_eq (Alias alias, Expression expression) {
		return new NOT_EQ(alias, expression);
	}
	
	public static NOT_EQ not_eq (boolean beTrue, Alias alias1, Alias alias2) {
		return new NOT_EQ(beTrue, alias1, alias2);
	}
	
	public static NOT_EQ not_eq (boolean beTrue, Alias alias, Object value) {
		return new NOT_EQ(beTrue, alias, value);
	}
	
	public static NOT_EQ not_eq (boolean beTrue, Alias alias, Expression expression) {
		return new NOT_EQ(beTrue, alias, expression);
	}
	

	public static <T> GT gt(FieldPart field, Object value) {
		return new GT(field, value);
	}
	
	public static <T> GT gt(boolean beTrue, FieldPart field, Object value) {
		return new GT(beTrue, field, value);
	}

	public static <T> GT gt(SFunction<T, ?> propertyFunction, Object value) {
		return new GT(propertyFunction, value);
	}

	public static <T1, T2> GT gt(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GT(propertyFunction, valueFunction);
	}

	public static <T1> GT gt(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GT(propertyFunction, sqlFunction);
	}

	public static GT gt(SQLFunction sqlFunction, Object value) {
		return new GT(sqlFunction, value);
	}

	public static <T> GT gt(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GT(sqlFunction, valueFunction);
	}

	public static <T1> GT gt(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GT(propertyFunction, expression);
	}

	public static <T> GT gt(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new GT(beTrue, propertyFunction, value);
	}

	public static <T1, T2> GT gt(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GT(beTrue, propertyFunction, valueFunction);
	}

	public static GT gt(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new GT(beTrue, sqlFunction, value);
	}

	public static <T> GT gt(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GT(beTrue, sqlFunction, valueFunction);
	}
	
	public static <T1> GT gt(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GT(beTrue, propertyFunction, sqlFunction);
	}

	public static <T1> GT gt(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GT(beTrue, propertyFunction, expression);
	}

	public static GT gt(Alias alias1, Alias alias2) {
		return new GT(alias1, alias2);
	}
	
	public static GT gt (Alias alias, Object value) {
		return new GT(alias, value);
	}
	
	public static GT gt (Alias alias, Expression expression) {
		return new GT(alias, expression);
	}
	
	public static GT gt (boolean beTrue, Alias alias1, Alias alias2) {
		return new GT(beTrue, alias1, alias2);
	}
	
	public static GT gt (boolean beTrue, Alias alias, Object value) {
		return new GT(beTrue, alias, value);
	}
	
	public static GT gt (boolean beTrue, Alias alias, Expression expression) {
		return new GT(beTrue, alias, expression);
	}
	

	

	public static <T> GTE gte(FieldPart field, Object value) {
		return new GTE(field, value);
	}
	
	public static <T> GTE gte(boolean beTrue, FieldPart field, Object value) {
		return new GTE(beTrue, field, value);
	}

	public static <T> GTE gte(SFunction<T, ?> propertyFunction, Object value) {
		return new GTE(propertyFunction, value);
	}

	public static <T1, T2> GTE gte(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GTE(propertyFunction, valueFunction);
	}

	public static <T1> GTE gte(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GTE(propertyFunction, sqlFunction);
	}

	public static GTE gte(SQLFunction sqlFunction, Object value) {
		return new GTE(sqlFunction, value);
	}

	public static <T> GTE gte(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GTE(sqlFunction, valueFunction);
	}

	public static <T1> GTE gte(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GTE(propertyFunction, expression);
	}

	public static <T> GTE gte(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new GTE(beTrue, propertyFunction, value);
	}

	public static <T1, T2> GTE gte(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GTE(beTrue, propertyFunction, valueFunction);
	}

	public static GTE gte(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new GTE(beTrue, sqlFunction, value);
	}

	public static <T> GTE gte(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GTE(beTrue, sqlFunction, valueFunction);
	}
	
	public static <T1> GTE gte(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GTE(beTrue, propertyFunction, sqlFunction);
	}

	public static <T1> GTE gte(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GTE(beTrue, propertyFunction, expression);
	}

	public static GTE gte(Alias alias1, Alias alias2) {
		return new GTE(alias1, alias2);
	}
	
	public static GTE gte (Alias alias, Object value) {
		return new GTE(alias, value);
	}
	
	public static GTE gte (Alias alias, Expression expression) {
		return new GTE(alias, expression);
	}
	
	public static GTE gte (boolean beTrue, Alias alias1, Alias alias2) {
		return new GTE(beTrue, alias1, alias2);
	}
	
	public static GTE gte (boolean beTrue, Alias alias, Object value) {
		return new GTE(beTrue, alias, value);
	}
	
	public static GTE gte (boolean beTrue, Alias alias, Expression expression) {
		return new GTE(beTrue, alias, expression);
	}
	
	

	public static <T> LTE lte(FieldPart field, Object value) {
		return new LTE(field, value);
	}
	
	public static <T> LTE lte(boolean beTrue, FieldPart field, Object value) {
		return new LTE(beTrue, field, value);
	}

	public static <T> LTE lte(SFunction<T, ?> propertyFunction, Object value) {
		return new LTE(propertyFunction, value);
	}

	public static <T1, T2> LTE lte(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LTE(propertyFunction, valueFunction);
	}

	public static <T1> LTE lte(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LTE(propertyFunction, sqlFunction);
	}

	public static LTE lte(SQLFunction sqlFunction, Object value) {
		return new LTE(sqlFunction, value);
	}

	public static <T> LTE lte(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LTE(sqlFunction, valueFunction);
	}

	public static <T1> LTE lte(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LTE(propertyFunction, expression);
	}

	public static <T> LTE lte(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new LTE(beTrue, propertyFunction, value);
	}

	public static <T1, T2> LTE lte(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LTE(beTrue, propertyFunction, valueFunction);
	}

	public static LTE lte(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new LTE(beTrue, sqlFunction, value);
	}

	public static <T> LTE lte(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LTE(beTrue, sqlFunction, valueFunction);
	}
	
	public static <T1> LTE lte(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LTE(beTrue, propertyFunction, sqlFunction);
	}

	public static <T1> LTE lte(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LTE(beTrue, propertyFunction, expression);
	}

	public static LTE lte(Alias alias1, Alias alias2) {
		return new LTE(alias1, alias2);
	}
	
	public static LTE lte (Alias alias, Object value) {
		return new LTE(alias, value);
	}
	
	public static LTE lte (Alias alias, Expression expression) {
		return new LTE(alias, expression);
	}
	
	public static LTE lte (boolean beTrue, Alias alias1, Alias alias2) {
		return new LTE(beTrue, alias1, alias2);
	}
	
	public static LTE lte (boolean beTrue, Alias alias, Object value) {
		return new LTE(beTrue, alias, value);
	}
	
	public static LTE lte (boolean beTrue, Alias alias, Expression expression) {
		return new LTE(beTrue, alias, expression);
	}
	

	public static <T> LT lt(FieldPart field, Object value) {
		return new LT(field, value);
	}
	
	public static <T> LT lt(boolean beTrue, FieldPart field, Object value) {
		return new LT(beTrue, field, value);
	}

	public static <T> LT lt(SFunction<T, ?> propertyFunction, Object value) {
		return new LT(propertyFunction, value);
	}

	public static <T1, T2> LT lt(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LT(propertyFunction, valueFunction);
	}

	public static <T1> LT lt(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LT(propertyFunction, sqlFunction);
	}

	public static LT lt(SQLFunction sqlFunction, Object value) {
		return new LT(sqlFunction, value);
	}

	public static <T> LT lt(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LT(sqlFunction, valueFunction);
	}

	public static <T1> LT lt(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LT(propertyFunction, expression);
	}

	public static <T> LT lt(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new LT(beTrue, propertyFunction, value);
	}

	public static <T1, T2> LT lt(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LT(beTrue, propertyFunction, valueFunction);
	}

	public static LT lt(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new LT(beTrue, sqlFunction, value);
	}

	public static <T> LT lt(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LT(beTrue, sqlFunction, valueFunction);
	}
	
	public static <T1> LT lt(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LT(beTrue, propertyFunction, sqlFunction);
	}

	public static <T1> LT lt(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LT(beTrue, propertyFunction, expression);
	}

	public static LT lt(Alias alias1, Alias alias2) {
		return new LT(alias1, alias2);
	}
	
	public static LT lt (Alias alias, Object value) {
		return new LT(alias, value);
	}
	
	public static LT lt (Alias alias, Expression expression) {
		return new LT(alias, expression);
	}
	
	public static LT lt (boolean beTrue, Alias alias1, Alias alias2) {
		return new LT(beTrue, alias1, alias2);
	}
	
	public static LT lt (boolean beTrue, Alias alias, Object value) {
		return new LT(beTrue, alias, value);
	}
	
	public static LT lt (boolean beTrue, Alias alias, Expression expression) {
		return new LT(beTrue, alias, expression);
	}


	public static TrueCondition trueCondition() {
		return new TrueCondition();
	}

	public static FalseCondition falseCondition() {
		return new FalseCondition();
	}
	
	public static <T> BETWEEN between(FieldPart field, Object value1, Object value2) {
		return new BETWEEN(field, value1, value2);
	}
	
	public static <T> BETWEEN between(boolean beTrue, FieldPart field, Object value1, Object value2) {
		return new BETWEEN(beTrue, field, value1, value2);
	}

	public static <T> BETWEEN between(SFunction<T, ?> propertyFunction, Object value1, Object value2) {
		return new BETWEEN(propertyFunction, value1, value2);
	}

	public static <T> BETWEEN between(boolean beTrue, SFunction<T, ?> propertyFunction, Object value1, Object value2) {
		return new BETWEEN(beTrue, propertyFunction, value1, value2);
	}
	
	public static BETWEEN between(Alias alias, Object value1, Object value2) {
		return new BETWEEN(alias, value1, value2);
	}
	
	public static BETWEEN between(boolean beTrue, Alias alias, Object value1, Object value2) {
		return new BETWEEN(beTrue, alias, value1, value2);
	}
	
	public static <T> IN in(FieldPart field, Collection<?> value) {
		return new IN(field, value);
	}
	
	public static <T> IN in(boolean beTrue, FieldPart field, Collection<?> value) {
		return new IN(beTrue, field, value);
	}

	public static <T> IN in(SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new IN(propertyFunction, value);
	}

	public static <T> IN in(SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new IN(propertyFunction, query);
	}
	
	
	public static <T> IN in(boolean beTrue, SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new IN(beTrue, propertyFunction, value);
	}
	
	public static <T> IN in(boolean beTrue, SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new IN(beTrue, propertyFunction, query);
	}
	
	public static IN in(Alias alias, Collection<?> value) {
		return new IN( alias, value);
	}
	
	public static IN in( Alias alias, SQLQuery query) {
		return new IN(alias, query);
	}
	
	public static IN in(boolean beTrue, Alias alias, Collection<?> value) {
		return new IN(beTrue, alias, value);
	}
	
	public static IN in(boolean beTrue, Alias alias, SQLQuery query) {
		return new IN(beTrue, alias, query);
	}
	
	public static <T> NOT_IN not_in(FieldPart field, Collection<?> value) {
		return new NOT_IN(field, value);
	}
	
	public static <T> NOT_IN not_in(boolean beTrue, FieldPart field, Collection<?> value) {
		return new NOT_IN(beTrue, field, value);
	}
	
	public static NOT_IN not_in(Alias alias, Collection<?> value) {
		return new NOT_IN( alias, value);
	}
	
	public static NOT_IN not_in( Alias alias, SQLQuery query) {
		return new NOT_IN(alias, query);
	}
	
	public static NOT_IN not_in(boolean beTrue, Alias alias, Collection<?> value) {
		return new NOT_IN(beTrue, alias, value);
	}
	
	public static NOT_IN not_in(boolean beTrue, Alias alias, SQLQuery query) {
		return new NOT_IN(beTrue, alias, query);
	}
	
	public static <T> NOT_IN not_in(SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new NOT_IN(propertyFunction, value);
	}

	public static <T> NOT_IN not_in(SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new NOT_IN(propertyFunction, query);
	}


	public static <T> NOT_IN not_in(boolean beTrue, SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new NOT_IN(beTrue, propertyFunction, value);
	}

	public static <T> NOT_IN not_in(boolean beTrue, SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new NOT_IN(beTrue, propertyFunction, query);
	}
	
	public static <T> IS_NULL is_null(FieldPart field) {
		return new IS_NULL(field);
	}
	
	public static <T> IS_NULL is_null(boolean beTrue, FieldPart field) {
		return new IS_NULL(beTrue, field);
	}

	public static <T> IS_NULL is_null(SFunction<T, ?> propertyFunction) {
		return new IS_NULL(propertyFunction);
	}
	
	public static <T> IS_NULL is_null(boolean beTrue, SFunction<T, ?> propertyFunction) {
		return new IS_NULL(beTrue, propertyFunction);
	}
	
	public static IS_NULL is_null(Alias alias) {
		return new IS_NULL(alias);
	}
	
	public static IS_NULL is_null(boolean beTrue, Alias alias) {
		return new IS_NULL(beTrue, alias);
	}
	
	public static <T> NOT_NULL not_null(FieldPart field) {
		return new NOT_NULL(field);
	}
	
	public static <T> NOT_NULL not_null(boolean beTrue, FieldPart field) {
		return new NOT_NULL(beTrue, field);
	}
	
	public static NOT_NULL not_null(Alias alias) {
		return new NOT_NULL(alias);
	}
	
	public static NOT_NULL not_null(boolean beTrue, Alias alias) {
		return new NOT_NULL(beTrue, alias);
	}

	public static <T> NOT_NULL not_null(SFunction<T, ?> propertyFunction) {
		return new NOT_NULL(propertyFunction);
	}

	public static <T> NOT_NULL not_null(boolean beTrue, SFunction<T, ?> propertyFunction) {
		return new NOT_NULL(beTrue, propertyFunction);
	}

	public static EXISTS exists(SQLQuery queryer) {
		return new EXISTS(queryer);
	}

	public static NOT_EXISTS not_exists(SQLQuery queryer) {
		return new NOT_EXISTS(queryer);
	}

	public static EXISTS exists(boolean beTrue, SQLQuery queryer) {
		return new EXISTS(beTrue, queryer);
	}

	public static NOT_EXISTS not_exists(boolean beTrue, SQLQuery queryer) {
		return new NOT_EXISTS(beTrue, queryer);
	}

	public static <T> CTMCondition condition(SFunction<T, ?> propertyFunction, String sql, Object... args) {
		return new CTMCondition(propertyFunction, sql, args);
	}
	
	public static <T> CTMCondition condition(Alias alias, String sql, Object... args) {
		return new CTMCondition(alias, sql, args);
	}
	
	public static <T> CTMCondition condition(String sql, Alias alias, Object... args) {
		return new CTMCondition(sql, alias, args);
	}
	
	public static <T> CTMCondition condition(boolean beTrue, Alias alias, String sql, Object... args) {
		return new CTMCondition(beTrue, alias, sql, args);
	}
	
	public static <T> CTMCondition condition(boolean beTrue, String sql, Alias alias, Object... args) {
		return new CTMCondition(beTrue, sql, alias, args);
	}
	
	public static <T> CTMCondition condition(String sql, Object... args) {
		return new CTMCondition(sql, args);
	}

	public static <T> CTMCondition condition(String sql, SFunction<T, ?> propertyFunction, Object... args) {
		return new CTMCondition(sql, propertyFunction, args);
	}

	public static <T> CTMCondition condition(boolean beTrue, SFunction<T, ?> propertyFunction, String sql, Object... args) {
		return new CTMCondition(beTrue, propertyFunction, sql, args);
	}

	public static <T> CTMCondition condition(boolean beTrue, String sql, Object... args) {
		return new CTMCondition(beTrue, sql, args);
	}

	public static <T> CTMCondition condition(boolean beTrue, String sql, SFunction<T, ?> propertyFunction, Object... args) {
		return new CTMCondition(beTrue, sql, propertyFunction, args);
	}
	
	public static <T> ADD add(SFunction<T, ?> propertyFunction, Number value) {
		return new ADD(propertyFunction, value);
	}
	
	public static <T> DIVISION divide(SFunction<T, ?> propertyFunction, Number value) {
		return new DIVISION(propertyFunction, value);
	}
	
	public static <T> MULTIPL multiply(SFunction<T, ?> propertyFunction, Number value) {
		return new MULTIPL(propertyFunction, value);
	}
	
	public static <T> SUBTRACT subtract(SFunction<T, ?> propertyFunction, Number value) {
		return new SUBTRACT(propertyFunction, value);
	}
	
	public static <T> ADD add(Alias alias, Number value) {
		return new ADD(alias, value);
	}
	
	public static <T> DIVISION divide(Alias alias, Number value) {
		return new DIVISION(alias, value);
	}
	
	public static <T> MULTIPL multiply(Alias alias, Number value) {
		return new MULTIPL(alias, value);
	}
	
	public static <T> SUBTRACT subtract(Alias alias, Number value) {
		return new SUBTRACT(alias, value);
	}
	
	public static <T> MOD mod(Alias alias, Number value) {
		return new MOD(alias, value);
	}
	
	public static <T> POW pow(Alias alias, Number value) {
		return new POW(alias, value);
	}
	
	public static <T> MOD mod(SFunction<T, ?> propertyFunction, Number value) {
		return new MOD(propertyFunction, value);
	}
	
	public static <T> POW pow(SFunction<T, ?> propertyFunction, Number value) {
		return new POW(propertyFunction, value);
	}

	public static AS as(FieldPart field, String alias) {
		return new AS(field, alias);
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
	
	public static COUNT count() {
		return new COUNT();
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

	public static <T1, T2, T3, T4> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {

		return new SUM(fun1, fun2, fun3, fun4);
	}

	public static <T1, T2, T3, T4, T5> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		return new SUM(fun1, fun2, fun3, fun4, fun5);
	}

	public static <T1, T2, T3, T4, T5, T6> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6);
	}

	public static <T1, T2, T3, T4, T5, T6, T7> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21,
			SFunction<T22, ?> fun22) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21, fun22);
	}
	
	public static <T1> DISTINCT distinct(Alias... aliases) {
		return new DISTINCT(aliases);
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

	public static <T1, T2, T3, T4> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {

		return new DISTINCT(fun1, fun2, fun3, fun4);
	}

	public static <T1, T2, T3, T4, T5> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5);
	}

	public static <T1, T2, T3, T4, T5, T6> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6);
	}

	public static <T1, T2, T3, T4, T5, T6, T7> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
	}

	public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> DISTINCT distinct(SFunction<T1, ?> fun1,
			SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8,
			SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14,
			SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20,
			SFunction<T21, ?> fun21, SFunction<T22, ?> fun22) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21, fun22);
	}

}
