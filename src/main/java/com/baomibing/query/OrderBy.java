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

import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.select.Alias;
import com.baomibing.query.sort.ASC;
import com.baomibing.query.sort.DESC;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
/**
 * SQL order by part
 * 
 * @author zening
 * @since 1.0.0
 */
public class OrderBy {
	
	private ASC asc;
	private DESC desc;
	
	public <T> void asc(Alias... aliases) {
		asc = new ASC(aliases);
	}
	
	public <T> void asc(SFunction<T, ?> fun) {
		asc = new ASC(fun);
	}
	
	public <T1,T2> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
		asc = new ASC(fun1,fun2);
	}
	
	public <T1,T2,T3> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
		asc = new ASC(fun1,fun2,fun3);
	}
	
	public <T1,T2,T3,T4> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
		asc = new ASC(fun1,fun2,fun3,fun4);
	}
	
	public <T1,T2,T3,T4,T5> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5);
	}
	
	public <T1,T2,T3,T4,T5,T6> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18,fun19);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18,fun19,fun20);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21> void asc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
		asc = new ASC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18,fun19,fun20,fun21);
	}
	
	public <T> void desc(Alias... aliases) {
		desc = new DESC(aliases);
	}
	
	public <T> void desc(SFunction<T, ?> fun) {
		desc = new DESC(fun);
	}
	
	public <T1,T2> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2) {
		desc = new DESC(fun1,fun2);
	}
	
	public <T1,T2,T3> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3) {
		desc = new DESC(fun1,fun2,fun3);
	}
	
	public <T1,T2,T3,T4> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4) {
		desc = new DESC(fun1,fun2,fun3,fun4);
	}
	
	public <T1,T2,T3,T4,T5> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5);
	}
	
	public <T1,T2,T3,T4,T5,T6> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18,fun19);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18,fun19,fun20);
	}
	
	public <T1,T2,T3,T4,T5,T6,T7,T8,T9,T10,T11,T12,T13,T14,T15,T16,T17,T18,T19,T20,T21> void desc(SFunction<T1, ?> fun1, SFunction<T2, ?> fun2, SFunction<T3, ?> fun3, SFunction<T4, ?> fun4, SFunction<T5, ?> fun5, SFunction<T6, ?> fun6, SFunction<T7, ?> fun7, SFunction<T8, ?> fun8, SFunction<T9, ?> fun9, SFunction<T10, ?> fun10, SFunction<T11, ?> fun11
			, SFunction<T12, ?> fun12, SFunction<T13, ?> fun13, SFunction<T14, ?> fun14, SFunction<T15, ?> fun15, SFunction<T16, ?> fun16, SFunction<T17, ?> fun17, SFunction<T18, ?> fun18, SFunction<T19, ?> fun19, SFunction<T20, ?> fun20, SFunction<T21, ?> fun21) {
		desc = new DESC(fun1,fun2,fun3,fun4,fun5,fun6,fun7,fun8,fun9,fun10,fun11,fun12,fun13,fun14,fun15,fun16,fun17,fun18,fun19,fun20,fun21);
	}
	
	
	public String toSQL() {
		StringBuilder s = new StringBuilder(SQLConsts.SQL_ORDER_BY);
		if (asc != null) {
			s.append(asc.toSQL());
		}
		if (desc != null) {
			s.append(desc.toSQL());
		}
		return s.toString();
	}
}
