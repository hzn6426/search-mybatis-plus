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
package com.baomibing.query.expression;

import com.baomibing.query.condition.Operator;
import com.baomibing.query.select.Alias;
import com.baomibing.query.select.Field;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

/**
 * Division expression
 *
 * @author : zening
 * @since: 1.0.0
 */
public class DIVISION extends Expression {


    public <T> DIVISION(SFunction<T, ?> propertyFunction, Number value) {
        this.fieldPart = new Field<>(propertyFunction);
        this.operator = Operator.DIV.getOp();
        this.value = value;
    }
    
    
    public <T> DIVISION(Alias alias, Number value) {
        this.fieldPart = alias;
        this.operator = Operator.DIV.getOp();
        this.value = value;
    }
    
    @Override
    public String toSQL() {
        return this.fieldPart.toSQL() + OP_DIVISION + value;
    }
}
