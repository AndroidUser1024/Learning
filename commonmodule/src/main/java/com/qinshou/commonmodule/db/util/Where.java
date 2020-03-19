package com.qinshou.commonmodule.db.util;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:Where 子句
 */
public class Where {
    private String mSql;

    public Where(Builder builder) {
        mSql = builder.mStringBuilder.toString();
    }

    public String getSql() {
        return mSql;
    }

    public static class Builder {
        private StringBuilder mStringBuilder = new StringBuilder(" WHERE ");

        public Builder equal(String columnName, Object columnValue) {
            if (columnValue instanceof String) {
                mStringBuilder.append(columnName).append("=\"").append(columnValue).append("\"");
            } else {
                mStringBuilder.append(columnName).append("=").append(columnValue).append("");
            }
            return this;
        }

        public Builder notEqual(String columnName, Object columnValue) {
            if (columnValue instanceof String) {
                mStringBuilder.append(columnName).append("!=\"").append(columnValue).append("\"");
            } else {
                mStringBuilder.append(columnName).append("!=").append(columnValue).append("");
            }
            return this;
        }

        public Builder greaterThan(String columnName, Object columnValue) {
            if (columnValue instanceof String) {
                mStringBuilder.append(columnName).append(">\"").append(columnValue).append("\"");
            } else {
                mStringBuilder.append(columnName).append(">").append(columnValue).append("");
            }
            return this;
        }

        public Builder greaterThanOrEqual(String columnName, Object columnValue) {
            if (columnValue instanceof String) {
                mStringBuilder.append(columnName).append(">=\"").append(columnValue).append("\"");
            } else {
                mStringBuilder.append(columnName).append(">=").append(columnValue).append("");
            }
            return this;
        }

        public Builder lessThan(String columnName, Object columnValue) {
            if (columnValue instanceof String) {
                mStringBuilder.append(columnName).append("<\"").append(columnValue).append("\"");
            } else {
                mStringBuilder.append(columnName).append("<").append(columnValue).append("");
            }
            return this;
        }

        public Builder lessThanOrEqual(String columnName, Object columnValue) {
            if (columnValue instanceof String) {
                mStringBuilder.append(columnName).append("<=\"").append(columnValue).append("\"");
            } else {
                mStringBuilder.append(columnName).append("<=").append(columnValue).append("");
            }
            return this;
        }

        public Builder and() {
            mStringBuilder.append(" AND ");
            return this;
        }

        public Builder or() {
            mStringBuilder.append(" OR ");
            return this;
        }

        public Builder openBracket() {
            mStringBuilder.append("(");
            return this;
        }

        public Builder closeBracket() {
            mStringBuilder.append(")");
            return this;
        }

        public Where build() {
            return new Where(this);
        }
    }
}
