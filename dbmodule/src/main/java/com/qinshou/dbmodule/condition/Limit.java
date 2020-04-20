package com.qinshou.dbmodule.condition;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/19 15:55
 * Description:Limit 子句
 */
public class Limit implements QueryCondition {
    private String mSql;

    public Limit(int count) {
        mSql = " LIMIT " + count;
    }

    public Limit(int count, int offset) {
        mSql = " LIMIT " + count + " OFFSET " + offset;
    }

    @Override
    public String getSql() {
        return mSql;
    }
}
