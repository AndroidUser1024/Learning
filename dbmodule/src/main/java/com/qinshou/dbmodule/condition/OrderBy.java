package com.qinshou.dbmodule.condition;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/19 15:55
 * Description:Order By 子句
 */
public class OrderBy implements QueryCondition {
    private String mSql;

    private OrderBy(Builder builder) {
        // 去掉最后一个 ","
        int start = builder.mStringBuilder.lastIndexOf(",");
        if (start != -1) {
            builder.mStringBuilder.delete(start, start + ",".length());
        }
        mSql = builder.mStringBuilder.toString();
    }

    @Override
    public String getSql() {
        return mSql;
    }

    public static class Builder {
        private StringBuilder mStringBuilder = new StringBuilder(" ORDER BY ");

        public Builder Asc(String columnName) {
            mStringBuilder.append(columnName).append(" ASC,");
            return this;
        }

        public Builder Desc(String columnName) {
            mStringBuilder.append(columnName).append(" DESC,");
            return this;
        }


        public OrderBy build() {
            return new OrderBy(this);
        }
    }
}
