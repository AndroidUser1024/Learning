package com.jeejio.dbmodule.util;

import android.util.Log;

import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.bean.ColumnInfoBean;
import com.jeejio.dbmodule.bean.IdColumnInfoBean;
import com.jeejio.dbmodule.condition.QueryCondition;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:SQL 语句工具类
 */
public class SqlUtil2 {
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
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(clazz);
        sql.append("CREATE TABLE IF NOT EXISTS ").append(idColumnInfo.getTableName()).append("(");
        // 主键
        if (idColumnInfo.isAutoIncrement()) {
            sql.append(idColumnInfo.getColumnName()).append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
        } else {
            sql.append(idColumnInfo.getColumnName()).append(" ").append(idColumnInfo.getType()).append(" PRIMARY KEY,");
        }
        // 其余列
        for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(clazz)) {
            sql.append(columnInfoBean.getColumnName()).append(" ").append(columnInfoBean.getType()).append(",");
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
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(clazz);
        sql.append("INSERT INTO ").append(idColumnInfo.getTableName()).append(" (");

        // 不是自增长主键才添加
        if (!idColumnInfo.isAutoIncrement()) {
            columnNameList.add(idColumnInfo.getColumnName());
            columnValueList.add("#{" + idColumnInfo.getColumnName() + "}");
        }
        // 其他列
        for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(clazz)) {
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
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(clazz);
        sql.append("DELETE FROM ").append(idColumnInfo.getTableName())
                .append(" WHERE ")
                .append(idColumnInfo.getColumnName())
                .append("=#{")
                .append(idColumnInfo.getFieldName())
                .append("}");
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
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(clazz);
        sql.append("UPDATE ").append(idColumnInfo.getTableName()).append(" SET ");

        for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(clazz)) {
            sql.append(columnInfoBean.getColumnName())
                    .append("=#{")
                    .append(columnInfoBean.getFieldName())
                    .append("},");
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        sql.append(" WHERE ")
                .append(idColumnInfo.getColumnName())
                .append("=#{")
                .append(idColumnInfo.getFieldName())
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
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(clazz);
        sql.append("SELECT * FROM ")
                .append(idColumnInfo.getTableName())
                .append(" WHERE ")
                .append(idColumnInfo.getColumnName())
                .append("=#{")
                .append(idColumnInfo.getFieldName())
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
    public static String getSelectListSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(clazz);
        sql.append("SELECT * FROM ")
                .append(idColumnInfo.getTableName());
        printSql(sql.toString());
        return sql.toString();
    }
}
