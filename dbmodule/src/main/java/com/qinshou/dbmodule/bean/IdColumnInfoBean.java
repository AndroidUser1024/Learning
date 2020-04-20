package com.qinshou.dbmodule.bean;


import com.qinshou.dbmodule.annotation.Column;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 19:30
 * Description:存储主键列信息的实体类
 */
public class IdColumnInfoBean extends ColumnInfoBean {
    private boolean autoIncrement;
    private boolean useGeneratedKeys;

    public IdColumnInfoBean(String tableName, String columnName, String fieldName, Column.Type type, boolean autoIncrement, boolean useGeneratedKeys) {
        super(tableName, columnName, fieldName, type);
        this.autoIncrement = autoIncrement;
        this.useGeneratedKeys = useGeneratedKeys;
    }

    @Override
    public String toString() {
        return "IdColumnInfoBean{" +
                "autoIncrement=" + autoIncrement +
                ", useGeneratedKeys=" + useGeneratedKeys +
                '}';
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public boolean isUseGeneratedKeys() {
        return useGeneratedKeys;
    }
}
