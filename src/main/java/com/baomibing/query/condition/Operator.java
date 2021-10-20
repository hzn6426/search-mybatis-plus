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
package com.baomibing.query.condition;

import lombok.Getter;

public enum Operator {
	
	EQ(0), NOT_EQ(1), LT(2), GT(3), LTE(4), GTE(5), IN(6), NOT_IN(7), IS_NULL(8), NOT_NULL(9), AND(10), OR(11),  BETWEEN(12), TRUE(13), FLASE(14), LIKE(15), EXIST(16), NOT_EXISTS(17);
	
	@Getter
	private int op;
	
	Operator(int op)  {
		this.op = op;
	}
}
