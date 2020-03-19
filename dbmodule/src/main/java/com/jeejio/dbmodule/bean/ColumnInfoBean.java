package com.jeejio.dbmodule.bean;


import com.jeejio.dbmodule.annotation.Column;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 19:30
 * Description:存储普通列信息的实体类
 */
public class ColumnInfoBean {
    private String tableName;
    private String columnName;
    private String fieldName;
    private Column.Type type;

    public ColumnInfoBean(String tableName, String columnName, String fieldName, Column.Type type) {
        this.tableName = tableName;
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.type = type;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Column.Type getType() {
        return type;
    }
}
