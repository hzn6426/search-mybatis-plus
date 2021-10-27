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

import com.baomibing.query.select.SelectablePart;

/**
 * An abstract expression for operating
 *
 * @author : zening
 * @since: 1.0.0
 */
public abstract class Expression extends SelectablePart {
    
    protected SelectablePart fieldPart;
    
    protected int operator;
    
    protected Number value;
    
    protected final String OP_PLUS = " + ";
    
    protected final String OP_SUBTRACT = " - ";
    
    protected final String OP_MULTIPL = " * ";
    
    protected final String OP_DIVISION = " / ";
    
}
