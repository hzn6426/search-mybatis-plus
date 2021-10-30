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

import java.util.List;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
/**
 * 
 * Inject method in QBaseMapper
 * 
 * @author zening
 * @since 1.0.0
 */
public class QuerySqlInject extends DefaultSqlInjector {

	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
		methodList.add(new FetchQuery());
		methodList.add(new FetchQueryInto());
		methodList.add(new CountQuery());
		methodList.add(new UpdateQuery());
		methodList.add(new DeleteQuery());
		return methodList;
	}

	// mybatis-plus v3.4.0
//	@Override
//	public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
//		List<AbstractMethod> methodList = super.getMethodList(mapperClass);
//		methodList.add(new FetchQuery());
//		methodList.add(new FetchQueryInto());
//		methodList.add(new CountQuery());
//		methodList.add(new UpdateQuery());
//		methodList.add(new DeleteQuery());
//		return methodList;
//	}
	
}
