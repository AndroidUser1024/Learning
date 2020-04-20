package com.qinshou.dbmodule.tmp;

import android.util.Log;

import com.qinshou.dbmodule.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:SQL 语句工具类
 */
public class SqlUtil {
    private static final String TAG = "SqlUtil";

    private static void printSql(String sql) {
        Log.i(TAG, sql);
//        System.out.println(sql);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/18 19:44
     * Description:获取建表语句
     *
     * @param clazz 表对应的实体类
     * @return 自动生成的 sql
     */
    public static String getCreateTableSql(Class<?> clazz) throws IllegalStateException {
        StringBuilder sql = new StringBuilder();
        TableInfoBean tableInfoBean = DatabaseManager.getInstance().getTableInfoByClass(clazz);
        sql.append("CREATE TABLE IF NOT EXISTS ").append(tableInfoBean.getTableName()).append("(");
        // 主键
        if (tableInfoBean.getIdColumnInfoBean().isAutoIncrement()) {
            sql.append(tableInfoBean.getIdColumnInfoBean().getColumnName()).append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            sql.append(tableInfoBean.getIdColumnInfoBean().getColumnName())
                    .append(" ")
                    .append(tableInfoBean.getIdColumnInfoBean().getType()).append(" PRIMARY KEY,");
        }
        // 其余列
        for (ColumnInfoBean columnInfoBean : tableInfoBean.getColumnInfoBeanList()) {
            sql.append(columnInfoBean.getColumnName())
                    .append(" ")
                    .append(columnInfoBean.getType())
                    .append(",");
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        sql.append(")");
        printSql(sql.toString());
        return sql.toString();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/18 19:44
     * Description:获取插入语句
     *
     * @return 自动生成的 sql
     */
    public static String getInsertSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        List<String> columnNameList = new ArrayList<>();
        List<Object> columnValueList = new ArrayList<>();
        TableInfoBean tableInfoBean = DatabaseManager.getInstance().getTableInfoByClass(clazz);
        sql.append("INSERT INTO ").append(tableInfoBean.getTableName()).append(" (");

        // 主键不是自增长主键才添加
        if (!tableInfoBean.getIdColumnInfoBean().isAutoIncrement()) {
            columnNameList.add(tableInfoBean.getIdColumnInfoBean().getColumnName());
            columnValueList.add("#{" + tableInfoBean.getIdColumnInfoBean().getColumnName() + "}");
        }
        // 其他列
        for (ColumnInfoBean columnInfoBean : tableInfoBean.getColumnInfoBeanList()) {
            columnNameList.add(columnInfoBean.getColumnName());
            columnValueList.add("#{" + columnInfoBean.getColumnName() + "}");
        }
        // 拼接列名
        for (String columnName : columnNameList) {
            sql.append(columnName).append(",");
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        // 拼接值
        sql.append(") VALUES (");
        for (Object columnValue : columnValueList) {
            sql.append(columnValue).append(",");
        }
        // 去掉最后一个 ","
        start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        sql.append(")");
        printSql(sql.toString());
        return sql.toString();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/18 19:44
     * Description:获取删除语句
     *
     * @param clazz 需要删除的对象的 class
     * @return 自动生成的 sql
     */
    public static String getDeleteByIdSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        TableInfoBean tableInfoBean = DatabaseManager.getInstance().getTableInfoByClass(clazz);
        sql.append("DELETE FROM ").append(tableInfoBean.getTableName())
                .append(" WHERE ")
                .append(tableInfoBean.getIdColumnInfoBean().getColumnName())
                .append("=#{id}");
        printSql(sql.toString());
        return sql.toString();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/18 19:44
     * Description:获取更新语句
     *
     * @return 自动生成的 sql
     */
    public static String getUpdateByIdSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        TableInfoBean tableInfoBean = DatabaseManager.getInstance().getTableInfoByClass(clazz);
        sql.append("UPDATE ").append(tableInfoBean.getTableName()).append(" SET ");

        for (ColumnInfoBean columnInfoBean : tableInfoBean.getColumnInfoBeanList()) {
            sql.append(columnInfoBean.getColumnName())
                    .append("=#{id}");
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        sql.append(" WHERE ")
                .append(tableInfoBean.getIdColumnInfoBean().getColumnName())
                .append("=#{")
                .append(tableInfoBean.getIdColumnInfoBean().getFieldName())
                .append("}");
        printSql(sql.toString());
        return sql.toString();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/18 19:44
     * Description:获取查询语句
     *
     * @param clazz 需要查询的对象的 class
     * @return 自动生成的 sql
     */
    public static String getSelectByIdSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        TableInfoBean tableInfoBean = DatabaseManager.getInstance().getTableInfoByClass(clazz);
        sql.append("SELECT * FROM ")
                .append(tableInfoBean.getTableName())
                .append(" WHERE ")
                .append(tableInfoBean.getIdColumnInfoBean().getColumnName())
                .append("=#{id}");
        printSql(sql.toString());
        return sql.toString();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/18 19:44
     * Description:获取查询语句
     *
     * @param clazz 需要查询的对象的 class
     * @return 自动生成的 sql
     */
    public static String getSelectListSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        TableInfoBean tableInfoBean = DatabaseManager.getInstance().getTableInfoByClass(clazz);
        sql.append("SELECT * FROM ")
                .append(tableInfoBean.getTableName());
        printSql(sql.toString());
        return sql.toString();
    }
}
