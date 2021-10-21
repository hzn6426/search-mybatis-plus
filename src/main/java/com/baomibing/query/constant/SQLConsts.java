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
package com.baomibing.query.constant;
/**
 * SQL keyword constant
 * 
 * @author zening
 * @since 1.0.0
 */
public abstract class SQLConsts {

	//=======================================================================//
	//                       SQL OPERATOR Constants                          //
	//=======================================================================//
	public static final String SQL_AND = "AND";
	
	public static final String SQL_OR = "OR";
	
	public static final String SQL_IN = "IN";
	
	public static final String SQL_NOT_IN = "NOT IN";
	
	//=======================================================================//
	//                        SQL Keyword Constants                              //
	//=======================================================================//
	public static final String SQL_SELECT = "SELECT ";
	
	public static final String SQL_AS = " AS ";
	
	public static final String SQL_DISTINCT = " DISTINCT ";
	
	public static final String SQL_FROM = " FROM ";
	
	public static final String SQL_WHERE = " WHERE ";
	
	public static final String SQL_JOIN = " JOIN ";
	
	public static final String SQL_ON = " ON ";
	
	public static final String SQL_LEFT_JOIN = " LEFT JOIN ";
	
	public static final String SQL_RIGHT_JOIN = " RIGHT JOIN ";
	
	public static final String SQL_INNER_JOIN = " INNER JOIN ";
	
	public static final String SQL_CROSS_JOIN = " CROSS JOIN ";
	
	public static final String SQL_ORDER_BY = " ORDER BY ";
	
	public static final String SQL_EXISTS = " EXISTS ";
	
	public static final String SQL_NOT_EXISTS = " NOT EXISTS ";
	
	public static final String SQL_DESC = " DESC ";
	
	public static final String SQL_ASC = " ASC ";
	
	public static final String SQL_GROUP_BY = " GROUP BY ";
	
	public static final String SQL_HAVING = " HAVING ";
	
	public static final String SQL_LIMIT = " LIMIT ";
	
	public static final String SQL_OFFSET = " OFFSET ";
	
	
	//=======================================================================//
	//                        SQL function Constants                         //
	//=======================================================================//
	public static final String FUN_SUM = " SUM({0})";
	
	public static final String FUN_COUNT = " COUNT({0})";
	
	public static final String FUN_MAX = " MAX({0})";
	
	public static final String FUN_MIN = " MIN({0})";
	
	public static final String FUN_AVG = " AVG({0})";
	
	public static final String FUN_WHEN_THEN = " WHEN {0} THEN {1}";
	
	public static final String FUN_CASE_ELSE = "CASE {0} ELSE {1} END";
	
	public static final String FUN_LIMIT_OFFSET = "LIMIT {0} OFFSET {1}";
}
