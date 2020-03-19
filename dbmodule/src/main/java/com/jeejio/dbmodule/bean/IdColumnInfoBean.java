package com.jeejio.dbmodule.bean;


import com.jeejio.dbmodule.annotation.Column;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 19:30
 * Description:存储主键列信息的实体类
 */
public class IdColumnInfoBean extends ColumnInfoBean {
    private boolean autoIncrement;

    public IdColumnInfoBean(String tableName, String columnName, String fieldName, Column.Type type, boolean autoIncrement) {
        super(tableName, columnName, fieldName, type);
        this.autoIncrement = autoIncrement;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }
}
