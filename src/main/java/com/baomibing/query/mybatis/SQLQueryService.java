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
package com.baomibing.query.mybatis;

import java.util.Collection;

import com.baomibing.query.LimitOffset;
import com.baomibing.query.SQLDelete;
import com.baomibing.query.SQLQuery;
import com.baomibing.query.SQLUpdate;
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
 * An interface which can be implements in service.
 * It contains the common static condition methods.
 *
 * @author zening
 * @since 1.0.0
 */
public interface SQLQueryService {
	
	
	default SQLQuery sqlQuery() {return new SQLQuery();}
	
	default SQLUpdate sqlUpdate(Class<?> clazz) {return new SQLUpdate(clazz);}
	
	default SQLDelete sqlDelete() {return new SQLDelete();}
	
	default Alias alias(Class<?> table, String aliasName) {
		return new Alias(table, aliasName);
	}

	default AND and(ACondition... conditions) {
		return new AND(conditions);
	}

	default OR or(ACondition... conditions) {
		return new OR(conditions);
	}

	default AND and(boolean beTrue, ACondition... conditions) {
		return new AND(beTrue, conditions);
	}

	default OR or(boolean beTrue, ACondition... conditions) {
		return new OR(beTrue, conditions);
	}
	
	default <T> Field<T> field(String column) {return new Field<>(column);}
	
	default LIKE like(FieldPart field, String value) {return new LIKE(field, value);}
	
	default LIKE like(boolean beTrue, FieldPart field, String value) {return new LIKE(beTrue, field, value);}
	
	default <T> LIKE like(SFunction<T, ?> propertyFunction, String value) {
		return new LIKE(propertyFunction, value);
	}

	default <T> LIKE like(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LIKE(propertyFunction, sqlFunction);
	}

	default <T> LIKE like(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		return new LIKE(beTrue, propertyFunction, value);
	}

	default <T> LIKE like(boolean beTrue, SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LIKE(beTrue, propertyFunction, sqlFunction);
	}
	
	default <T> LIKE like(Alias alias, String value) {
		return new LIKE(alias, value);
	}
	
	default <T> LIKE like(Alias alias1, Alias alias2) {
		return new LIKE(alias1, alias2);
	}
	
	default <T> LIKE like(boolean beTrue, Alias alias, String value) {
		return new LIKE(beTrue, alias, value);
	}
	
	default <T> LIKE like(boolean beTrue, Alias alias1, Alias alias2) {
		return new LIKE(beTrue, alias1, alias2);
	}
	
	default <T> LLIKE llike(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LLIKE(propertyFunction, sqlFunction);
	}

	default <T> LLIKE llike(boolean beTrue, SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LLIKE(beTrue, propertyFunction, sqlFunction);
	}

	default <T> LLIKE llike(FieldPart field, String value) {
		return new LLIKE(field, value);
	}
	
	default <T> LLIKE llike(boolean beTrue, FieldPart field, String value) {
		return new LLIKE(beTrue, field, value);
	}
	
	default <T> LLIKE llike(SFunction<T, ?> propertyFunction, String value) {
		return new LLIKE(propertyFunction, value);
	}
	

	default <T> LLIKE llike(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		return new LLIKE(beTrue, propertyFunction, value);
	}

	
	default <T> LLIKE llike(Alias alias, String value) {
		return new LLIKE(alias, value);
	}
	
	default <T> LLIKE llike(Alias alias1, Alias alias2) {
		return new LLIKE(alias1, alias2);
	}
	
	default <T> LLIKE llike(boolean beTrue, Alias alias, String value) {
		return new LLIKE(beTrue, alias, value);
	}
	
	default <T> LLIKE llike(boolean beTrue, Alias alias1, Alias alias2) {
		return new LLIKE(beTrue, alias1, alias2);
	}
	
	default <T> RLIKE rlike(SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new RLIKE(propertyFunction, sqlFunction);
	}

	default <T> RLIKE rlike(boolean beTrue, SFunction<T, ?> propertyFunction, SQLFunction sqlFunction) {
		return new RLIKE(beTrue, propertyFunction, sqlFunction);
	}

	default <T> RLIKE rlike(FieldPart field, String value) {
		return new RLIKE(field, value);
	}

	default <T> RLIKE rlike(boolean beTrue, SFunction<T, ?> propertyFunction, String value) {
		return new RLIKE(beTrue, propertyFunction, value);
	}

	default <T> RLIKE rlike(boolean beTrue, FieldPart field, String value) {
		return new RLIKE(beTrue, field, value);
	}

	default <T> RLIKE rlike(SFunction<T, ?> propertyFunction, String value) {
		return new RLIKE(propertyFunction, value);
	}

	default <T> RLIKE rlike(Alias alias, String value) {
		return new RLIKE(alias, value);
	}
	
	default <T> RLIKE rlike(Alias alias1, Alias alias2) {
		return new RLIKE(alias1, alias2);
	}
	
	default <T> RLIKE rlike(boolean beTrue, Alias alias, String value) {
		return new RLIKE(beTrue, alias, value);
	}
	
	default <T> RLIKE rlike(boolean beTrue, Alias alias1, Alias alias2) {
		return new RLIKE(beTrue, alias1, alias2);
	}
	
	default <T> EQ eq(FieldPart field, Object value) {
		return new EQ(field, value);
	}
	
	default <T> EQ eq(boolean beTrue, FieldPart field, Object value) {
		return new EQ(beTrue, field, value);
	}
	
	default <T> EQ eq(SFunction<T, ?> propertyFunction, Object value) {
		return new EQ(propertyFunction, value);
	}

	default <T1, T2> EQ eq(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new EQ(propertyFunction, valueFunction);
	}

	default EQ eq(SQLFunction sqlFunction, Object value) {
		return new EQ(sqlFunction, value);
	}

	default <T> EQ eq(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new EQ(sqlFunction, valueFunction);
	}
	
	default  <T1> EQ eq(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new EQ(propertyFunction, expression);
	}
	
	default EQ eq(Alias alias1, Alias alias2) {
		return new EQ(alias1, alias2);
	}
	
	default EQ eq (Alias alias, Object value) {
		return new EQ(alias, value);
	}
	
	default EQ eq (Alias alias, Expression expression) {
		return new EQ(alias, expression);
	}
	
	default EQ eq (boolean beTrue, Alias alias1, Alias alias2) {
		return new EQ(beTrue, alias1, alias2);
	}
	
	default EQ eq (boolean beTrue, Alias alias, Object value) {
		return new EQ(beTrue, alias, value);
	}
	
	default EQ eq (boolean beTrue, Alias alias, Expression expression) {
		return new EQ(beTrue, alias, expression);
	}

	default <T> EQ eq(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new EQ(beTrue, propertyFunction, value);
	}

	default <T1, T2> EQ eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new EQ(beTrue, propertyFunction, valueFunction);
	}

	default <T1> EQ eq(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new EQ(propertyFunction, sqlFunction);
	}

	default <T1> EQ eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new EQ(beTrue, propertyFunction, sqlFunction);
	}

	default EQ eq(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new EQ(beTrue, sqlFunction, value);
	}

	default <T> EQ eq(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new EQ(beTrue, sqlFunction, valueFunction);
	}
	
	default  <T1> EQ eq(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new EQ(beTrue, propertyFunction, expression);
	}
	
	default <T> NOT_EQ not_eq(FieldPart field, Object value) {
		return new NOT_EQ(field, value);
	}
	
	default <T> NOT_EQ not_eq(boolean beTrue, FieldPart field, Object value) {
		return new NOT_EQ(beTrue, field, value);
	}

	default <T> NOT_EQ not_eq(SFunction<T, ?> propertyFunction, Object value) {
		return new NOT_EQ(propertyFunction, value);
	}

	default <T1, T2> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new NOT_EQ(propertyFunction, valueFunction);
	}

	default <T1> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new NOT_EQ(propertyFunction, sqlFunction);
	}

	default NOT_EQ not_eq(SQLFunction sqlFunction, Object value) {
		return new NOT_EQ(sqlFunction, value);
	}

	default <T> NOT_EQ not_eq(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new NOT_EQ(sqlFunction, valueFunction);
	}

	default <T1> NOT_EQ not_eq(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new NOT_EQ(propertyFunction, expression);
	}

	default <T> NOT_EQ not_eq(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new NOT_EQ(beTrue, propertyFunction, value);
	}

	default <T1, T2> NOT_EQ not_eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new NOT_EQ(beTrue, propertyFunction, valueFunction);
	}

	default NOT_EQ not_eq(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new NOT_EQ(beTrue, sqlFunction, value);
	}

	default <T> NOT_EQ not_eq(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new NOT_EQ(beTrue, sqlFunction, valueFunction);
	}
	
	default <T1> NOT_EQ not_eq(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new NOT_EQ(beTrue, propertyFunction, sqlFunction);
	}

	default <T1> NOT_EQ not_eq(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new NOT_EQ(beTrue, propertyFunction, expression);
	}

	default NOT_EQ not_eq(Alias alias1, Alias alias2) {
		return new NOT_EQ(alias1, alias2);
	}
	
	default NOT_EQ not_eq (Alias alias, Object value) {
		return new NOT_EQ(alias, value);
	}
	
	default NOT_EQ not_eq (Alias alias, Expression expression) {
		return new NOT_EQ(alias, expression);
	}
	
	default NOT_EQ not_eq (boolean beTrue, Alias alias1, Alias alias2) {
		return new NOT_EQ(beTrue, alias1, alias2);
	}
	
	default NOT_EQ not_eq (boolean beTrue, Alias alias, Object value) {
		return new NOT_EQ(beTrue, alias, value);
	}
	
	default NOT_EQ not_eq (boolean beTrue, Alias alias, Expression expression) {
		return new NOT_EQ(beTrue, alias, expression);
	}
	

	default <T> GT gt(FieldPart field, Object value) {
		return new GT(field, value);
	}
	
	default <T> GT gt(boolean beTrue, FieldPart field, Object value) {
		return new GT(beTrue, field, value);
	}

	default <T> GT gt(SFunction<T, ?> propertyFunction, Object value) {
		return new GT(propertyFunction, value);
	}

	default <T1, T2> GT gt(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GT(propertyFunction, valueFunction);
	}

	default <T1> GT gt(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GT(propertyFunction, sqlFunction);
	}

	default GT gt(SQLFunction sqlFunction, Object value) {
		return new GT(sqlFunction, value);
	}

	default <T> GT gt(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GT(sqlFunction, valueFunction);
	}

	default <T1> GT gt(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GT(propertyFunction, expression);
	}

	default <T> GT gt(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new GT(beTrue, propertyFunction, value);
	}

	default <T1, T2> GT gt(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GT(beTrue, propertyFunction, valueFunction);
	}

	default GT gt(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new GT(beTrue, sqlFunction, value);
	}

	default <T> GT gt(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GT(beTrue, sqlFunction, valueFunction);
	}
	
	default <T1> GT gt(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GT(beTrue, propertyFunction, sqlFunction);
	}

	default <T1> GT gt(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GT(beTrue, propertyFunction, expression);
	}

	default GT gt(Alias alias1, Alias alias2) {
		return new GT(alias1, alias2);
	}
	
	default GT gt (Alias alias, Object value) {
		return new GT(alias, value);
	}
	
	default GT gt (Alias alias, Expression expression) {
		return new GT(alias, expression);
	}
	
	default GT gt (boolean beTrue, Alias alias1, Alias alias2) {
		return new GT(beTrue, alias1, alias2);
	}
	
	default GT gt (boolean beTrue, Alias alias, Object value) {
		return new GT(beTrue, alias, value);
	}
	
	default GT gt (boolean beTrue, Alias alias, Expression expression) {
		return new GT(beTrue, alias, expression);
	}
	

	default <T> GTE gte(FieldPart field, Object value) {
		return new GTE(field, value);
	}
	
	default <T> GTE gte(boolean beTrue, FieldPart field, Object value) {
		return new GTE(beTrue, field, value);
	}

	default <T> GTE gte(SFunction<T, ?> propertyFunction, Object value) {
		return new GTE(propertyFunction, value);
	}

	default <T1, T2> GTE gte(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GTE(propertyFunction, valueFunction);
	}

	default <T1> GTE gte(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GTE(propertyFunction, sqlFunction);
	}

	default GTE gte(SQLFunction sqlFunction, Object value) {
		return new GTE(sqlFunction, value);
	}

	default <T> GTE gte(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GTE(sqlFunction, valueFunction);
	}

	default <T1> GTE gte(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GTE(propertyFunction, expression);
	}

	default <T> GTE gte(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new GTE(beTrue, propertyFunction, value);
	}

	default <T1, T2> GTE gte(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new GTE(beTrue, propertyFunction, valueFunction);
	}

	default GTE gte(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new GTE(beTrue, sqlFunction, value);
	}

	default <T> GTE gte(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new GTE(beTrue, sqlFunction, valueFunction);
	}
	
	default <T1> GTE gte(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new GTE(beTrue, propertyFunction, sqlFunction);
	}

	default <T1> GTE gte(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new GTE(beTrue, propertyFunction, expression);
	}

	default GTE gte(Alias alias1, Alias alias2) {
		return new GTE(alias1, alias2);
	}
	
	default GTE gte (Alias alias, Object value) {
		return new GTE(alias, value);
	}
	
	default GTE gte (Alias alias, Expression expression) {
		return new GTE(alias, expression);
	}
	
	default GTE gte (boolean beTrue, Alias alias1, Alias alias2) {
		return new GTE(beTrue, alias1, alias2);
	}
	
	default GTE gte (boolean beTrue, Alias alias, Object value) {
		return new GTE(beTrue, alias, value);
	}
	
	default GTE gte (boolean beTrue, Alias alias, Expression expression) {
		return new GTE(beTrue, alias, expression);
	}
	
	default <T> LTE lte(FieldPart field, Object value) {
		return new LTE(field, value);
	}
	
	default <T> LTE lte(boolean beTrue, FieldPart field, Object value) {
		return new LTE(beTrue, field, value);
	}

	default <T> LTE lte(SFunction<T, ?> propertyFunction, Object value) {
		return new LTE(propertyFunction, value);
	}

	default <T1, T2> LTE lte(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LTE(propertyFunction, valueFunction);
	}

	default <T1> LTE lte(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LTE(propertyFunction, sqlFunction);
	}

	default LTE lte(SQLFunction sqlFunction, Object value) {
		return new LTE(sqlFunction, value);
	}

	default <T> LTE lte(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LTE(sqlFunction, valueFunction);
	}

	default <T1> LTE lte(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LTE(propertyFunction, expression);
	}

	default <T> LTE lte(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new LTE(beTrue, propertyFunction, value);
	}

	default <T1, T2> LTE lte(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LTE(beTrue, propertyFunction, valueFunction);
	}

	default LTE lte(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new LTE(beTrue, sqlFunction, value);
	}

	default <T> LTE lte(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LTE(beTrue, sqlFunction, valueFunction);
	}
	
	default <T1> LTE lte(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LTE(beTrue, propertyFunction, sqlFunction);
	}

	default <T1> LTE lte(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LTE(beTrue, propertyFunction, expression);
	}

	default LTE lte(Alias alias1, Alias alias2) {
		return new LTE(alias1, alias2);
	}
	
	default LTE lte (Alias alias, Object value) {
		return new LTE(alias, value);
	}
	
	default LTE lte (Alias alias, Expression expression) {
		return new LTE(alias, expression);
	}
	
	default LTE lte (boolean beTrue, Alias alias1, Alias alias2) {
		return new LTE(beTrue, alias1, alias2);
	}
	
	default LTE lte (boolean beTrue, Alias alias, Object value) {
		return new LTE(beTrue, alias, value);
	}
	
	default LTE lte (boolean beTrue, Alias alias, Expression expression) {
		return new LTE(beTrue, alias, expression);
	}
	
	default <T> LT lt(FieldPart field, Object value) {
		return new LT(field, value);
	}
	
	default <T> LT lt(boolean beTrue, FieldPart field, Object value) {
		return new LT(beTrue, field, value);
	}

	default <T> LT lt(SFunction<T, ?> propertyFunction, Object value) {
		return new LT(propertyFunction, value);
	}

	default <T1, T2> LT lt(SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LT(propertyFunction, valueFunction);
	}

	default <T1> LT lt(SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LT(propertyFunction, sqlFunction);
	}

	default LT lt(SQLFunction sqlFunction, Object value) {
		return new LT(sqlFunction, value);
	}

	default <T> LT lt(SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LT(sqlFunction, valueFunction);
	}

	default <T1> LT lt(SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LT(propertyFunction, expression);
	}

	default <T> LT lt(boolean beTrue, SFunction<T, ?> propertyFunction, Object value) {
		return new LT(beTrue, propertyFunction, value);
	}

	default <T1, T2> LT lt(boolean beTrue, SFunction<T1, ?> propertyFunction, SFunction<T2, ?> valueFunction) {
		return new LT(beTrue, propertyFunction, valueFunction);
	}

	default LT lt(boolean beTrue, SQLFunction sqlFunction, Object value) {
		return new LT(beTrue, sqlFunction, value);
	}

	default <T> LT lt(boolean beTrue, SQLFunction sqlFunction, SFunction<T, ?> valueFunction) {
		return new LT(beTrue, sqlFunction, valueFunction);
	}
	
	default <T1> LT lt(boolean beTrue, SFunction<T1, ?> propertyFunction, SQLFunction sqlFunction) {
		return new LT(beTrue, propertyFunction, sqlFunction);
	}

	default <T1> LT lt(boolean beTrue, SFunction<T1, ?> propertyFunction, Expression expression) {
		return new LT(beTrue, propertyFunction, expression);
	}

	default LT lt(Alias alias1, Alias alias2) {
		return new LT(alias1, alias2);
	}
	
	default LT lt (Alias alias, Object value) {
		return new LT(alias, value);
	}
	
	default LT lt (Alias alias, Expression expression) {
		return new LT(alias, expression);
	}
	
	default LT lt (boolean beTrue, Alias alias1, Alias alias2) {
		return new LT(beTrue, alias1, alias2);
	}
	
	default LT lt (boolean beTrue, Alias alias, Object value) {
		return new LT(beTrue, alias, value);
	}
	
	default LT lt (boolean beTrue, Alias alias, Expression expression) {
		return new LT(beTrue, alias, expression);
	}

	default TrueCondition trueCondition() {
		return new TrueCondition();
	}

	default FalseCondition falseCondition() {
		return new FalseCondition();
	}
	
	default <T> BETWEEN between(FieldPart field, Object value1, Object value2) {
		return new BETWEEN(field, value1, value2);
	}
	
	default <T> BETWEEN between(boolean beTrue, FieldPart field, Object value1, Object value2) {
		return new BETWEEN(beTrue, field, value1, value2);
	}
	
	default <T> BETWEEN between(SFunction<T, ?> propertyFunction, Object value1, Object value2) {
		return new BETWEEN(propertyFunction, value1, value2);
	}

	default <T> BETWEEN between(boolean beTrue, SFunction<T, ?> propertyFunction, Object value1, Object value2) {
		return new BETWEEN(beTrue, propertyFunction, value1, value2);
	}
	
	default BETWEEN between(Alias alias, Object value1, Object value2) {
		return new BETWEEN(alias, value1, value2);
	}
	
	default BETWEEN between(boolean beTrue, Alias alias, Object value1, Object value2) {
		return new BETWEEN(beTrue, alias, value1, value2);
	}
	
	default <T> IN in(FieldPart field, Collection<?> value) {
		return new IN(field, value);
	}
	
	default <T> IN in(boolean beTrue, FieldPart field, Collection<?> value) {
		return new IN(beTrue, field, value);
	}

	default <T> IN in(SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new IN(propertyFunction, value);
	}

	default <T> IN in(SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new IN(propertyFunction, query);
	}
	
	default <T> NOT_IN not_in(FieldPart field, Collection<?> value) {
		return new NOT_IN(field, value);
	}
	
	default <T> NOT_IN not_in(boolean beTrue, FieldPart field, Collection<?> value) {
		return new NOT_IN(beTrue, field, value);
	}

	default <T> NOT_IN not_in(SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new NOT_IN(propertyFunction, value);
	}

	default <T> NOT_IN not_in(SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new NOT_IN(propertyFunction, query);
	}

	default <T> IN in(boolean beTrue, SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new IN(beTrue, propertyFunction, value);
	}

	default <T> IN in(boolean beTrue, SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new IN(beTrue, propertyFunction, query);
	}

	default <T> NOT_IN not_in(boolean beTrue, SFunction<T, ?> propertyFunction, Collection<?> value) {
		return new NOT_IN(beTrue, propertyFunction, value);
	}

	default <T> NOT_IN not_in(boolean beTrue, SFunction<T, ?> propertyFunction, SQLQuery query) {
		return new NOT_IN(beTrue, propertyFunction, query);
	}
	
	default IN in(Alias alias, Collection<?> value) {
		return new IN( alias, value);
	}
	
	default IN in( Alias alias, SQLQuery query) {
		return new IN(alias, query);
	}
	
	default IN in(boolean beTrue, Alias alias, Collection<?> value) {
		return new IN(beTrue, alias, value);
	}
	
	default IN in(boolean beTrue, Alias alias, SQLQuery query) {
		return new IN(beTrue, alias, query);
	}
	
	default NOT_IN not_in(Alias alias, Collection<?> value) {
		return new NOT_IN( alias, value);
	}
	
	default NOT_IN not_in( Alias alias, SQLQuery query) {
		return new NOT_IN(alias, query);
	}
	
	default NOT_IN not_in(boolean beTrue, Alias alias, Collection<?> value) {
		return new NOT_IN(beTrue, alias, value);
	}
	
	default NOT_IN not_in(boolean beTrue, Alias alias, SQLQuery query) {
		return new NOT_IN(beTrue, alias, query);
	}
	
	default <T> IS_NULL is_null(FieldPart field) {
		return new IS_NULL(field);
	}
	
	default <T> IS_NULL is_null(boolean beTrue, FieldPart field) {
		return new IS_NULL(beTrue, field);
	}

	default <T> IS_NULL is_null(SFunction<T, ?> propertyFunction) {
		return new IS_NULL(propertyFunction);
	}

	default <T> NOT_NULL not_null(SFunction<T, ?> propertyFunction) {
		return new NOT_NULL(propertyFunction);
	}
	
	default IS_NULL is_null(Alias alias) {
		return new IS_NULL(alias);
	}
	
	default IS_NULL is_null(boolean beTrue, Alias alias) {
		return new IS_NULL(beTrue, alias);
	}
	
	default <T> NOT_NULL not_null(FieldPart field) {
		return new NOT_NULL(field);
	}
	
	default <T> NOT_NULL not_null(boolean beTrue, FieldPart field) {
		return new NOT_NULL(beTrue, field);
	}
	
	default NOT_NULL not_null(Alias alias) {
		return new NOT_NULL(alias);
	}
	
	default NOT_NULL not_null(boolean beTrue, Alias alias) {
		return new NOT_NULL(beTrue, alias);
	}
	
	default <T> IS_NULL is_null(boolean beTrue, SFunction<T, ?> propertyFunction) {
		return new IS_NULL(beTrue, propertyFunction);
	}

	default <T> NOT_NULL not_null(boolean beTrue, SFunction<T, ?> propertyFunction) {
		return new NOT_NULL(beTrue, propertyFunction);
	}

	default EXISTS exists(SQLQuery queryer) {
		return new EXISTS(queryer);
	}

	default NOT_EXISTS not_exists(SQLQuery queryer) {
		return new NOT_EXISTS(queryer);
	}

	default EXISTS exists(boolean beTrue, SQLQuery queryer) {
		return new EXISTS(beTrue, queryer);
	}

	default NOT_EXISTS not_exists(boolean beTrue, SQLQuery queryer) {
		return new NOT_EXISTS(beTrue, queryer);
	}
	
	default <T> CTMCondition condition(Alias alias, String sql, Object... args) {
		return new CTMCondition(alias, sql, args);
	}
	
	default <T> CTMCondition condition(String sql, Alias alias, Object... args) {
		return new CTMCondition(sql, alias, args);
	}
	
	default <T> CTMCondition condition(boolean beTrue, Alias alias, String sql, Object... args) {
		return new CTMCondition(beTrue, alias, sql, args);
	}
	
	default <T> CTMCondition condition(boolean beTrue, String sql, Alias alias, Object... args) {
		return new CTMCondition(beTrue, sql, alias, args);
	}
	
	default <T> CTMCondition condition(SFunction<T, ?> propertyFunction, String sql, Object... args) {
		return new CTMCondition(propertyFunction, sql, args);
	}

	default <T> CTMCondition condition(String sql, Object... args) {
		return new CTMCondition(sql, args);
	}

	default <T> CTMCondition condition(String sql, SFunction<T, ?> propertyFunction, Object... args) {
		return new CTMCondition(sql, propertyFunction, args);
	}

	default <T> CTMCondition condition(boolean beTrue, SFunction<T, ?> propertyFunction, String sql, Object... args) {
		return new CTMCondition(beTrue, propertyFunction, sql, args);
	}

	default <T> CTMCondition condition(boolean beTrue, String sql, Object... args) {
		return new CTMCondition(beTrue, sql, args);
	}

	default <T> CTMCondition condition(boolean beTrue, String sql, SFunction<T, ?> propertyFunction, Object... args) {
		return new CTMCondition(beTrue, sql, propertyFunction, args);
	}
	
	default <T> ADD add(SFunction<T, ?> propertyFunction, Number value) {
		return new ADD(propertyFunction, value);
	}
	
	default <T> DIVISION divide(SFunction<T, ?> propertyFunction, Number value) {
		return new DIVISION(propertyFunction, value);
	}
	
	default <T> MULTIPL multiply(SFunction<T, ?> propertyFunction, Number value) {
		return new MULTIPL(propertyFunction, value);
	}
	
	default <T> SUBTRACT subtract(SFunction<T, ?> propertyFunction, Number value) {
		return new SUBTRACT(propertyFunction, value);
	}
	
	default <T> ADD add(Alias alias, Number value) {
		return new ADD(alias, value);
	}
	
	default <T> DIVISION divide(Alias alias, Number value) {
		return new DIVISION(alias, value);
	}
	
	default <T> MULTIPL multiply(Alias alias, Number value) {
		return new MULTIPL(alias, value);
	}
	
	default <T> SUBTRACT subtract(Alias alias, Number value) {
		return new SUBTRACT(alias, value);
	}
	
	default <T> MOD mod(Alias alias, Number value) {
		return new MOD(alias, value);
	}
	
	default <T> POW pow(Alias alias, Number value) {
		return new POW(alias, value);
	}
	
	default <T> MOD mod(SFunction<T, ?> propertyFunction, Number value) {
		return new MOD(propertyFunction, value);
	}
	
	default <T> POW pow(SFunction<T, ?> propertyFunction, Number value) {
		return new POW(propertyFunction, value);
	}

	default AS as(SQLFunction fun, String alias) {
		return new AS(fun, alias);
	}

	default AS as(FieldPart field, String alias) {
		return new AS(field, alias);
	}

	default <T> AS as(SFunction<T, ?> fun, String alias) {
		return new AS(fun, alias);
	}

	default <T> AVG avg(SFunction<T, ?> fun) {
		return new AVG(fun);
	}

	default <T> AVG avg(String sql) {
		return new AVG(sql);
	}

	default CASE_WHEN case_when() {
		return new CASE_WHEN();
	}

	default <T> COUNT count(SFunction<T, ?> fun) {
		return new COUNT(fun);
	}
	
	default <T> COUNT count() {
		return new COUNT();
	}

	default <T> COUNT count(String sql) {
		return new COUNT(sql);
	}

	default <T> COUNT count(DISTINCT distinct) {
		return new COUNT(distinct);
	}

	default <T> LimitOffset limitOffset(int pageNo, int pageSize) {
		return new LimitOffset(pageNo, pageSize);
	}

	default <T> CTMFunction sql_fun(String fun, Object... args) {
		return new CTMFunction(fun, args);
	}

	default <T> MAX max(SFunction<T, ?> fun) {
		return new MAX(fun);
	}

	default <T> MAX max(String sql) {
		return new MAX(sql);
	}

	default <T> MIN min(SFunction<T, ?> fun) {
		return new MIN(fun);
	}

	default <T> MIN min(String sql) {
		return new MIN(sql);
	}

	default <T> SUM sum(DISTINCT distinct) {
		return new SUM(distinct);
	}

	default <T1> SUM sum(SFunction<T1, ?> fun) {
		return new SUM(fun);
	}

	default <T1, T2> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {

		return new SUM(fun1, fun2);
	}

	default <T1, T2, T3> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {

		return new SUM(fun1, fun2, fun3);
	}

	default <T1, T2, T3, T4> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {

		return new SUM(fun1, fun2, fun3, fun4);
	}

	default <T1, T2, T3, T4, T5> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		return new SUM(fun1, fun2, fun3, fun4, fun5);
	}

	default <T1, T2, T3, T4, T5, T6> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6);
	}

	default <T1, T2, T3, T4, T5, T6, T7> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SUM sum(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21,
			SFunction<T22, ?> fun22) {

		return new SUM(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21, fun22);
	}
	
	default <T1> DISTINCT distinct(Alias... aliases) {
		return new DISTINCT(aliases);
	}

	default <T1> DISTINCT distinct(SFunction<T1, ?> fun) {
		return new DISTINCT(fun);
	}

	default <T1, T2> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {

		return new DISTINCT(fun1, fun2);
	}

	default <T1, T2, T3> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {

		return new DISTINCT(fun1, fun2, fun3);
	}

	default <T1, T2, T3, T4> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {

		return new DISTINCT(fun1, fun2, fun3, fun4);
	}

	default <T1, T2, T3, T4, T5> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5);
	}

	default <T1, T2, T3, T4, T5, T6> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6);
	}

	default <T1, T2, T3, T4, T5, T6, T7> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
			SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
			SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
			SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
			SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
			SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16,
			SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21);
	}

	default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> DISTINCT distinct(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
			SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9,
			SFunction<T10, ?> fun10, SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15,
			SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21,
			SFunction<T22, ?> fun22) {

		return new DISTINCT(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16, fun17, fun18, fun19, fun20, fun21, fun22);
	}
}
