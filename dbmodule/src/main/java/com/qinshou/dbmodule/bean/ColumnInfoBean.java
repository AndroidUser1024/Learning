package com.qinshou.dbmodule.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/20 11:01
 * Description:存储列信息的实体类
 */
public class ColumnInfoBean {
    private String columnName;
    private String fieldName;
    private Class<?> clazz;

    public ColumnInfoBean() {
    }

    public ColumnInfoBean(String columnName, String fieldName, Class<?> clazz) {
        this.columnName = columnName;
        this.fieldName = fieldName;
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "ColumnInfoBean{" +
                "columnName='" + columnName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getType() {
        if (clazz == int.class || clazz == Integer.class
                || clazz == long.class || clazz == Long.class
                || clazz == float.class || clazz == Float.class
                || clazz == double.class || clazz == Double.class) {
            return "INTEGER";
        } else if (clazz == String.class) {
            return "TEXT";
        } else {
            return "";
        }
    }
}