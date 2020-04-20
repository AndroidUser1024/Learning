package com.qinshou.dbmodule.bean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/20 11:01
 * Description:存储表信息的实体类
 */
public class TableInfoBean {
    private String tableName;
    private IdColumnInfoBean mIdColumnInfoBean;
    private List<ColumnInfoBean> mColumnInfoBeanList;

    public TableInfoBean() {
    }

    @Override
    public String toString() {
        return "TableInfoBean{" +
                "tableName='" + tableName + '\'' +
                ", mIdColumnInfoBean=" + mIdColumnInfoBean +
                ", mColumnInfoBeanList=" + mColumnInfoBeanList +
                '}';
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public IdColumnInfoBean getIdColumnInfoBean() {
        return mIdColumnInfoBean;
    }

    public void setIdColumnInfoBean(IdColumnInfoBean idColumnInfoBean) {
        mIdColumnInfoBean = idColumnInfoBean;
    }

    public List<ColumnInfoBean> getColumnInfoBeanList() {
        return mColumnInfoBeanList;
    }

    public void setColumnInfoBeanList(List<ColumnInfoBean> columnInfoBeanList) {
        mColumnInfoBeanList = columnInfoBeanList;
    }


}
