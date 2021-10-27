package com.baomibing.query;

import com.baomibing.query.constant.SQLConsts;
import com.baomibing.query.helper.InnerHelper;

/**
 * SQL limit clause
 *
 * @author : zening
 * @since: 1.0.0
 */
public class Limit implements QueryPart {
    private int limit;
    
    public Limit(int limit) {
        this.limit = limit;
    }
    
    @Override
    public String toSQL() {
        return InnerHelper.format(SQLConsts.FUN_LIMIT, limit);
    }
}
