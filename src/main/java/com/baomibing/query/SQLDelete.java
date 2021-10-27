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

import com.baomibing.query.condition.ACondition;
import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.relation.InnerJoin;
import com.baomibing.query.relation.LeftJoin;
import com.baomibing.query.relation.Relation;
import com.baomibing.query.relation.RightJoin;
import com.baomibing.query.select.Alias;
import com.baomibing.query.sql.DeleterSQL;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SQL for delete
 * 
 * @author : zening
 * @since: 1.0.2
 */
public class SQLDelete extends DeleterSQL implements IQuery {
    
    private From from;
    
    private List<Relation> relations;
    
    private Where where;
    
    private OrderBy orderBy;
    
    private Limit limiter;
    
    public SQLDelete from(Class<?> clazz) {
        this.from = new From(clazz);
        this.fromPart = from.toSQL();
        fromClass = clazz;
        return this;
    }
    
    public SQLDelete from(Alias alias) {
        this.from = new From(alias);
        this.fromPart = from.toSQL();
        fromClass = alias.getTableClass();
        return this;
    }
    
    public SQLDelete leftJoin(Class<?> clazz, ACondition... conditions) {
        relations.add(new LeftJoin(clazz, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete leftJoin(Alias alias, ACondition... conditions) {
        relations.add(new LeftJoin(alias, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete leftJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
        relations.add(new LeftJoin(beTrue, clazz, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete rightJoin(Class<?> clazz, ACondition... conditions) {
        relations.add(new RightJoin(clazz, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete rightJoin(Alias alias, ACondition... conditions) {
        relations.add(new RightJoin(alias, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete rightJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
        relations.add(new RightJoin(beTrue, clazz, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete innerJoin(Class<?> clazz, ACondition... conditions) {
        relations.add(new InnerJoin(clazz, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete innerJoin(Alias alias, ACondition... conditions) {
        relations.add(new InnerJoin(alias, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete innerJoin(boolean beTrue, Class<?> clazz, ACondition... conditions) {
        relations.add(new InnerJoin(beTrue, clazz, conditions));
        relationPart = relations.stream().map(QueryPart::toSQL).collect(Collectors.joining());
        return this;
    }
    
    public SQLDelete where(ACondition... conditions) {
        this.where = new Where(conditions);
        this.wherePart = where.toSQL();
        return this;
    }
    
    public SQLDelete limit(int limit) {
        this.limiter = new Limit(limit);
        this.limitPart = limiter.toSQL();
        return this;
    }
    
    public  SQLDelete orderBydesc(Alias... aliases) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(aliases);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public  SQLDelete orderByasc(Alias... aliases) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(aliases);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1> SQLDelete orderByasc(SFunction<T1, ?> fun) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
                                                         SFunction<T6, ?> fun6) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
                                                             SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
                                                                 SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                     SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                          SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                               SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                                    SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
                                                                                    SFunction<T12, ?> fun12) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                                         SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
                                                                                         SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
                                                                                              SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
                                                                                              SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
                                                                                                   SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
                                                                                                   SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
                                                                                                        SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
                                                                                                        SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.asc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLDelete orderByasc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1> SQLDelete orderBydesc(SFunction<T1, ?> fun) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
                                                          SFunction<T6, ?> fun6) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
                                                              SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5,
                                                                  SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                      SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                           SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                                SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                                     SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
                                                                                     SFunction<T12, ?> fun12) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4,
                                                                                          SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11,
                                                                                          SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
                                                                                               SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
                                                                                               SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
                                                                                                    SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
                                                                                                    SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
                                                                                                         SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10,
                                                                                                         SFunction<T11, ?> fun11, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
        if (orderBy == null) {
            orderBy = new OrderBy();
            orderBy.desc(fun1, fun2, fun3, fun4, fun5, fun6, fun7, fun8, fun9, fun10, fun11, fun12, fun13, fun14, fun15, fun16);
            orderByPart = orderBy.toSQL();
        }
        return this;
    }
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SQLDelete orderBydesc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2,
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
    
    public String toSQL() {
        StringBuilder s = new StringBuilder();
        s.append(SQLConsts.SQL_DELETE).append(SQLConsts.SQL_FROM).append(from.toSQL());
        if (relations != null && !relations.isEmpty()) {
          s.append(relations.stream().map(r -> r.toSQL()).collect(Collectors.joining()));
        }
        if (where != null) {
          s.append(where.toSQL());
        }
        if (orderBy != null) {
          s.append(orderBy.toSQL());
        }
        if (limiter != null) {
          s.append(limiter.toSQL());
        }
        return s.toString();
    }
}
