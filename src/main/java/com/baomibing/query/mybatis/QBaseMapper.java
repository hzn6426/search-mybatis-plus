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

import static com.baomibing.query.constant.ParameterConsts.QUERY_TO_CLASS;
import static com.baomibing.query.constant.ParameterConsts.QUERY_WRAPPER;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomibing.query.SQLQuery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
/**
 * A BaseMapper for fetch data by SQLQuery
 * 
 * @author zening
 * @date 2021-10-20 11:48:38
 * @since 1.0.0
 */
public interface QBaseMapper<T> extends BaseMapper<T> {

	<Q> List<Q> fetchQuery(@Param(QUERY_WRAPPER) SQLQuery query);
	
	int countQuery(@Param(QUERY_WRAPPER) SQLQuery query);
	
	<Q> List<Q> fetchQueryInto(@Param(QUERY_WRAPPER) SQLQuery query, @Param(QUERY_TO_CLASS)Class<Q> clazz);
	
}
