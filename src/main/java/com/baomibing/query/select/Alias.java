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

import com.baomibing.query.QueryPart;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.google.common.collect.Lists;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Field alias
 *
 * @author : zening
 * @since: 1.0.3
 */
public class Alias extends FieldPart {
    
    private List<FieldPart> fields;
    @Getter
    private Class<?> tableClass;
    @Getter
    private String aliasName;
    
    public Alias(Class<?> table, String aliasName) {
        this.tableClass = table;
        this.aliasName = aliasName;
    }
    
    private Alias(List<FieldPart> parts, Class<?> tableClass, String aliasName) {
        this.fields = parts;
        this.tableClass = tableClass;
        this.aliasName = aliasName;
    }
    
    
    public <T> Alias Fields(SFunction<T, ?> fun) {
        return Fields(new Field<>(fun, aliasName));
    }
    
    public <T1,T2> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName));
    }
    
    public <T1,T2,T3> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName));
    }
    
    public <T1,T2,T3,T4> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName));
    }
    
    public <T1,T2,T3,T4,T5> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName)
            , new Field<>(fun17, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName)
            , new Field<>(fun17, aliasName), new Field<>(fun18, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName)
            , new Field<>(fun17, aliasName), new Field<>(fun18, aliasName), new Field<>(fun19, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName)
            , new Field<>(fun17, aliasName), new Field<>(fun18, aliasName), new Field<>(fun19, aliasName), new Field<>(fun20, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName)
            , new Field<>(fun17, aliasName), new Field<>(fun18, aliasName), new Field<>(fun19, aliasName), new Field<>(fun20, aliasName), new Field<>(fun21, aliasName));
    }
    
    public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21,T22> Alias Fields(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
        , SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21, SFunction<T22, ?> fun22) {
        return Fields(new Field<>(fun1, aliasName), new Field<>(fun2, aliasName), new Field<>(fun3, aliasName), new Field<>(fun4, aliasName), new Field<>(fun5, aliasName), new Field<>(fun6, aliasName), new Field<>(fun7, aliasName), new Field<>(fun8, aliasName), new Field<>(fun9, aliasName), new Field<>(fun10, aliasName), new Field<>(fun11, aliasName), new Field<>(fun12, aliasName), new Field<>(fun13, aliasName), new Field<>(fun14, aliasName), new Field<>(fun15, aliasName), new Field<>(fun16, aliasName)
            , new Field<>(fun17, aliasName), new Field<>(fun18, aliasName), new Field<>(fun19, aliasName), new Field<>(fun20, aliasName), new Field<>(fun21, aliasName), new Field<>(fun22, aliasName));
    }
    
    
    public Alias Fields(FieldPart... parts) {
        List<FieldPart> partsList = Lists.newArrayList();
//        if (fields == null) {
//            fields = Lists.newArrayList();
//        }
        partsList.addAll(Arrays.asList(parts));
        return new Alias(partsList, tableClass, aliasName);
    }
    
    
    @Override
    public String toSQL() {
       return fields.stream().map(QueryPart::toSQL).collect(Collectors.joining(","));
    }
}
