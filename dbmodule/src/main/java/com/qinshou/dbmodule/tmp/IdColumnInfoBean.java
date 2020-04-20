
package com.qinshou.dbmodule.tmp;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/20 11:01
 * Description:存储主键列信息的实体类
 */
public class IdColumnInfoBean extends ColumnInfoBean {
    private boolean autoIncrement;
    private boolean useGeneratedKeys;

    public IdColumnInfoBean() {
    }

    public IdColumnInfoBean(String columnName, String fieldName, Class<?> clazz, boolean autoIncrement, boolean useGeneratedKeys) {
        super(columnName, fieldName, clazz);
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

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
    }

    public boolean isUseGeneratedKeys() {
        return useGeneratedKeys;
    }

    public void setUseGeneratedKeys(boolean useGeneratedKeys) {
        this.useGeneratedKeys = useGeneratedKeys;
    }

    public Object convertIdValue(Number id) {
        if (getClazz() == int.class || getClazz() == Integer.class) {
            return id.intValue();
        } else if (getClazz() == long.class || getClazz() == Long.class) {
            return id.longValue();
        } else if (getClazz() == float.class || getClazz() == Float.class) {
            return id.floatValue();
        } else if (getClazz() == double.class || getClazz() == Double.class) {
            return id.doubleValue();
        }
        return id;
    }
}