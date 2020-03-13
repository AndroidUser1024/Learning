package com.qinshou.commonmodule.db;

import android.util.Log;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class SqlUtil {
    private static final String TAG = "SqlUtil";

    private static String getTableName(Class<?> clazz, Table table) {
        String tableName;
        if (table == null) {
            // 如果没有使用 Table 注解修饰需要存储的类，则使用类名作为表名
            throw new IllegalArgumentException("该类没有使用  Table 注解修饰");
        }
        tableName = table.name();
        // 如果使用了 Table 注解修饰需要存储的类，则判断设置的表名是否为空字符串
        // 如果为空则抛出异常，不为空则使用该值作为表名
        if ("".equals(tableName.trim())) {
            tableName = clazz.getSimpleName();
        }
        return tableName;
    }

    static String getColumnName(Field field, Column column) {
        String columnName = column.name();
        if ("".equals(columnName.trim())) {
            columnName = field.getName();
        }
        return columnName;
    }

    public static String getCreateTableSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        String tableName;
        tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append("(");
        Field[] fields = clazz.getDeclaredFields();
        // 遍历所有的成员变量，得到需要存储的列名
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            // 列类型
            Column.Type type = column.type();
            String columnName = getColumnName(field, column);
            // 寻找主键
            Id id = field.getAnnotation(Id.class);
            if (id == null) {
                sql.append(columnName).append(" ").append(type).append(",");
            } else {
                // 自动增长
                if (id.autoIncrement()) {
                    sql.append(columnName).append(" INTEGER PRIMARY KEY AUTOINCREMENT,");
                } else {
                    sql.append(columnName).append(" ").append(type).append(" PRIMARY KEY,");
                }
            }
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        sql.append(")");
        System.out.println("sql--->" + sql);
        return sql.toString();
    }

    public static String getInsertSql(Object object) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        Class<?> clazz = object.getClass();
        String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("INSERT INTO ").append(tableName).append(" (");

        Field[] fields = clazz.getDeclaredFields();
        List<String> columnNameList = new ArrayList<>();
        List<Object> columnValueList = new ArrayList<>();
        // 遍历所有的成员变量，得到需要存储的列名
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            // 寻找主键
            Id id = field.getAnnotation(Id.class);
            if (id != null && id.autoIncrement()) {
                continue;
            }
            // 列类型
            Column.Type type = column.type();
            String columnName = getColumnName(field, column);
            columnNameList.add(columnName);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            if (type == Column.Type.TEXT) {
                columnValueList.add("\"" + field.get(object) + "\"");
            } else {
                columnValueList.add(field.get(object));
            }
        }
        for (String columnName : columnNameList) {
            sql.append(columnName).append(",");
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
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
        System.out.println("sql--->" + sql);
        return sql.toString();
    }

    public static String getDeleteSql(Object object) throws IllegalArgumentException, IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        Class<?> clazz = object.getClass();
        String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("DELETE FROM ").append(tableName);

        Field[] fields = clazz.getDeclaredFields();
        // 遍历所有的成员变量，得到需要存储的列名
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            // 寻找主键
            Id id = field.getAnnotation(Id.class);
            if (id == null) {
                continue;
            }
            Column.Type type = column.type();
            String columnName = getColumnName(field, column);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            // 自动增长
            if (id.autoIncrement()) {
                sql.append(" WHERE ").append(columnName).append("=").append(field.get(object));
            } else {
                if (type == Column.Type.TEXT) {
                    sql.append(" WHERE ").append(columnName).append("=\"").append(field.get(object)).append("\"");
                } else {
                    sql.append(" WHERE ").append(columnName).append("=").append(field.get(object));
                }
            }
        }
//        System.out.println("sql--->" + sql);
        System.out.println("sql--->" + sql);
        return sql.toString();
    }

    public static String getDeleteSql(Class<?> clazz, @Nullable Where where) throws IllegalArgumentException {
        StringBuilder sql = new StringBuilder();
        String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("DELETE FROM ").append(tableName);
        if (where != null) {
            sql.append(where.getSql());
        }
        System.out.println("sql--->" + sql);
        return sql.toString();
    }

    public static String getUpdateSql(Object object) throws IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        Class<?> clazz = object.getClass();
        String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("UPDATE ").append(tableName).append(" SET ");

        Field[] fields = clazz.getDeclaredFields();
        StringBuilder where = new StringBuilder();
        // 遍历所有的成员变量，得到需要更新的列名和值
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            // 列类型
            Column.Type type = column.type();
            String columnName = getColumnName(field, column);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            // 寻找主键
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                // 自动增长
                if (id.autoIncrement()) {
                    where.append(" WHERE ").append(columnName).append("=").append(field.get(object));
                } else {
                    if (type == Column.Type.TEXT) {
                        where.append(" WHERE ").append(columnName).append("=\"").append(field.get(object)).append("\"");
                    } else {
                        where.append(" WHERE ").append(columnName).append("=").append(field.get(object));
                    }
                }
                continue;
            }
            if (type == Column.Type.TEXT) {
                sql.append(columnName).append("=\"").append(field.get(object)).append("\"").append(",");
            } else {
                sql.append(columnName).append("=").append(field.get(object)).append(",");
            }
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        sql.append(where);
        System.out.println("sql--->" + sql);
        return sql.toString();
    }

    public static String getUpdateSql(Object object, @Nullable Where where) throws IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        Class<?> clazz = object.getClass();
        String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("UPDATE ").append(tableName).append(" SET ");

        Field[] fields = clazz.getDeclaredFields();
        // 遍历所有的成员变量，得到需要更新的列名和值
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            // 列类型
            Column.Type type = column.type();
            String columnName = getColumnName(field, column);
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            // 寻找主键
            Id id = field.getAnnotation(Id.class);
            if (id != null) {
                continue;
            }
            if (type == Column.Type.TEXT) {
                sql.append(columnName).append("=\"").append(field.get(object)).append("\"").append(",");
            } else {
                sql.append(columnName).append("=").append(field.get(object)).append(",");
            }
        }
        // 去掉最后一个 ","
        int start = sql.lastIndexOf(",");
        if (start != -1) {
            sql.delete(start, start + ",".length());
        }
        if (where != null) {
            sql.append(where.getSql());
        }
        System.out.println("sql--->" + sql);
        return sql.toString();
    }

    public static String getQuerySql(Class<?> clazz, @Nullable Where where) throws IllegalAccessException {
        StringBuilder sql = new StringBuilder();
        String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
        sql.append("SELECT * FROM ").append(tableName);
        if (where != null) {
            sql.append(where.getSql());
        }
        System.out.println("sql--->" + sql);
        return sql.toString();
    }
}
