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
import com.baomibing.query.helper.InnerHelper;
/**
 * SQL limit offset part
 * 
 * @author zening
 * @since 1.0.0
 */
public class LimitOffset implements QueryPart {

	private int limit;
	
	private int offset;
	
	
	public LimitOffset(int pageNumber, int pageSize) {
		this.limit = pageSize;
		this.offset =  InnerHelper.offsetCurrent(pageNumber, pageSize);
	}

	@Override
	public String toSQL() {
		return InnerHelper.format(SQLConsts.FUN_LIMIT_OFFSET, limit, offset);
	}
	
	
	
}