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

import com.baomibing.query.constant.ParameterConsts;
import com.baomibing.query.constant.Strings;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.toolkit.sql.SqlScriptUtils;
/**
 * Inject method for QBaseMapper 
 * 
 * @author zening
 * @data 2021-10-20 11:50:24
 * @since 1.0.0
 */
public abstract class QueryMethod extends AbstractMethod {

	protected final String QUERY_WRAPPER = ParameterConsts.QUERY_WRAPPER;

	protected final String QUERY_WRAPPER_SELECT = QUERY_WRAPPER + Strings.DOT + "selectPart";

	protected final String QUERY_WRAPPER_FROM = QUERY_WRAPPER + Strings.DOT + "fromPart";
	
	protected final String QUERY_WRAPPER_RELATION = QUERY_WRAPPER + Strings.DOT + "relationPart";
	
	protected final String QUERY_WRAPPER_WHERE = QUERY_WRAPPER + Strings.DOT + "wherePart";
	
	protected final String QUERY_WRAPPER_GROUP_BY = QUERY_WRAPPER + Strings.DOT + "groupByPart";
	
	protected final String QUERY_WRAPPER_ORDER_BY = QUERY_WRAPPER + Strings.DOT + "orderByPart";
	
	protected final String QUERY_WRAPPER_HAVING = QUERY_WRAPPER + Strings.DOT + "havingPart";
	
	protected final String QUERY_WRAPPER_LIMIT_OFFSET = QUERY_WRAPPER + Strings.DOT + "limitOffsetPart";
	
	
	protected String convertIfQwParam(final String param, final boolean newLine) {
        return SqlScriptUtils.convertIf(SqlScriptUtils.unSafeParam(param),
            String.format("%s != null and %s != null", QUERY_WRAPPER, param), newLine);
    }
	
	protected String select() {
		return convertChooseQwSelect(ASTERISK);
	}
	
	protected String from() {
		return convertIfQwParam(QUERY_WRAPPER_FROM, true);
	}
	
	protected String relation() {
		return convertIfQwParam(QUERY_WRAPPER_RELATION, true);
	}
	
	protected String where() {
		return convertIfQwParam(QUERY_WRAPPER_WHERE, true);
	}
	
	protected String groupBy() {
		return convertIfQwParam(QUERY_WRAPPER_GROUP_BY, true);
	}
	
	protected String orderBy() {
		return convertIfQwParam(QUERY_WRAPPER_ORDER_BY, true);
	}
	
	protected String having() {
		return convertIfQwParam(QUERY_WRAPPER_HAVING, true);
	}
	
	protected String limitOffset() {
		return convertIfQwParam(QUERY_WRAPPER_LIMIT_OFFSET, true);
	}
	
	
	protected String convertChooseQwSelect(final String otherwise) {
        return SqlScriptUtils.convertChoose(String.format("%s != null and %s != null", QUERY_WRAPPER, QUERY_WRAPPER_SELECT),
            SqlScriptUtils.unSafeParam(QUERY_WRAPPER_SELECT), otherwise);
    }
}
