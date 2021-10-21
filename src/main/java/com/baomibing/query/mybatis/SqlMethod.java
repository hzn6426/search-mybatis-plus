package com.baomibing.query.mybatis;

/**
 * Sql format
 * @see com.baomidou.mybatisplus.core.enums.SqlMethod
 * 
 *
 * @author frog
 * @since 1.0.0
 */
public enum SqlMethod {

    SELECT_FETCH("fetchQuery", "查询满足条件总记录数",
    	     "<script>\n SELECT %s FROM %s %s %s %s %s %s %s\n</script>"),

    SELECT_COUNT("countQuery", "返回一条记录",
            "<script>\n SELECT COUNT(1) FROM %s %s %s %s %s %s\n</script>"),

    SELECT_FETCH_INTO("fetchQueryInto", "查询满足条件总记录数",
   	     "<script>\n SELECT %s FROM %s %s %s %s %s %s %s\n</script>"),
    
    ;

    private final String method;
    private final String desc;
    private final String sql;

    SqlMethod(String method, String desc, String sql) {
        this.method = method;
        this.desc = desc;
        this.sql = sql;
    }

    public String getMethod() {
        return method;
    }

    public String getDesc() {
        return desc;
    }

    public String getSql() {
        return sql;
    }


}
