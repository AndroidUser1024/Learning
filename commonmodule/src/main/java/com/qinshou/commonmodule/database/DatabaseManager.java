package com.qinshou.commonmodule.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:数据库管理者类
 * Created by 禽兽先生
 * Created on 2017/6/26
 */

public class DatabaseManager {

    private SQLiteDatabase mSqLiteDatabase;

    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        return SingleHolder.singleton;
    }


    private static class SingleHolder {
        private static final DatabaseManager singleton = new DatabaseManager();
    }

    /**
     * Description:初始化数据库，使用数据库之前必须先调用该方法进行初始化
     * 否则会抛出异常 IllegalStateException("DatabaseManager 没有初始化");
     * Date:2018/11/15
     *
     * @param context    上下文
     * @param dbName     数据库名
     * @param dbVersion  数据库版本
     * @param classArray 需要存储的类的 class 集合，会根据该集合去创建对应表
     */
    public void init(Context context, String dbName, int dbVersion, Class<?>[] classArray) {
        if (!dbName.endsWith(".db")) {
            dbName = dbName.concat(".db");
        }
        //连接数据库
        SQLiteOpenHelper sqLiteOpenHelper = new DatabaseHelper(context
                , dbName
                , null
                , dbVersion
                , getCreateTableSqlArray(classArray));
        //获取数据库可读可写的操作对象
        mSqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    /**
     * Description:获取创建表的语句的集合
     * Date:2018/4/10
     */
    private String[] getCreateTableSqlArray(Class<?>[] classArray) {
        String[] createTableSqlArray = new String[classArray.length];
        for (int i = 0; i < createTableSqlArray.length; i++) {
            createTableSqlArray[i] = getCreateTableSql(classArray[i]);
        }
        return createTableSqlArray;
    }

    /**
     * Description:获取创建表的语句
     * Date:2018/4/10
     */
    public String getCreateTableSql(Class<?> clazz) {
        StringBuilder sql = new StringBuilder();
        String tableName;
        DatabaseTable databaseTable = clazz.getAnnotation(DatabaseTable.class);
        if (databaseTable == null) {
            //如果没有使用 DatabaseTable 注解修饰需要存储的类，则使用类名作为表名
            tableName = clazz.getSimpleName();
        } else {
            //如果使用了 DatabaseTable 注解修饰需要存储的类，则判断设置的表名是否为空字符串
            // 如果为空则抛出异常，不为空则使用该值作为表名
            if (TextUtils.isEmpty(databaseTable.tableName())) {
                throw new IllegalArgumentException("表名不能为空");
            }
            tableName = databaseTable.tableName();
        }
        sql.append("CREATE TABLE ")
                .append(tableName)
                //默认给一个自增长的 id 作为主键
                .append(" (pid INTEGER PRIMARY KEY AUTOINCREMENT,");
        Field[] fields = clazz.getDeclaredFields();
        //遍历所有的成员变量，得到需要存储的列名
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            int modifiers = field.getModifiers();
            //不存储 static 和 final 修饰的成员变量，这两个修饰符修饰的变量一般为常量
            if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                continue;
            }
            String columnName;
            String type;
            DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
            if (databaseField == null) {
                //如果没有使用 DatabaseField 注解修饰需要存储的成员变量，则使用变量名作为列名，存储类型默认为 TEXT
                columnName = field.getName();
                type = "TEXT";
            } else {
                //如果使用了 DatabaseField 注解修饰需要存储的成员变量，则判断设置的列名是否为空字符串
                //如果为空则抛出异常，不为空则使用该值作为列名，类型使用设置的类型，默认是 TEXT
                if (TextUtils.isEmpty(databaseField.columnName())) {
                    throw new IllegalArgumentException("列名不能为空");
                }
                columnName = databaseField.columnName();
                type = databaseField.type().toString();
            }
            sql.append(columnName).append(" ").append(type).append(",");
        }
        //去掉最后一个 ","
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        Log.d("DatabaseManager", "sql--->" + sql);
        return sql.toString();
    }

    /**
     * Description:插入数据
     * Date:2018/4/10
     *
     * @param obj 需要存储的数据
     */
    public void insert(Object obj) throws IllegalAccessException {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        if (obj == null) {
            return;
        }
        StringBuilder sql = new StringBuilder();
        String tableName;
        DatabaseTable databaseTable = obj.getClass().getAnnotation(DatabaseTable.class);
        //这里的注释同 getCreateTableSql() 方法
        if (databaseTable == null) {
            tableName = obj.getClass().getSimpleName();
        } else {
            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
            tableName = databaseTable.tableName();
        }
        sql.append("INSERT INTO ").append(tableName).append(" (");
        //创建一个 map 集合，存放需要存储的值和对应列名
        Map<String, String> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                continue;
            }
            String value;
            if (field.get(obj) == null) {
                //变量的值为 null 时存储为数据库对应 NULL 类型
                value = "NULL";
            } else {
                //变量的值不为 null 时则先转成字符串，如果该变量的存储类型是 TEXT，在下面会使用 '' 包裹该值
                value = field.get(obj).toString();
            }
            String columnName;
            DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
            //这里的注释同 getCreateTableSql() 方法
            if (databaseField == null) {
                columnName = field.getName();
            } else {
                //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
                columnName = databaseField.columnName();
                if (databaseField.type() == DatabaseField.TYPE.TEXT && !value.equals("NULL")) {
                    //如果存储类型是 TEXT 且不为 NULL 则使用 '' 包裹
                    value = "'" + value + "'";
                }
            }
            //先将值和对应的列名存入集合，方便后面 sql 语句的编写
            map.put(columnName, value);
        }
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            columns.append(entry.getKey()).append(",");
            values.append(entry.getValue()).append(",");
        }
        //去掉最后的 ","
        columns.deleteCharAt(columns.length() - 1);
        values.deleteCharAt(values.length() - 1);
        sql.append(columns).append(") VALUES(").append(values).append(");");
        Log.d("DatabaseManager", "sql--->" + sql);
        mSqLiteDatabase.execSQL(sql.toString());
    }

    /**
     * Description:删除数据
     * Date:2018/11/15
     *
     * @param clazz              需要操作的类名，用于确定操作哪张表
     * @param databaseConditions 可选参数，数据过滤的条件，如果不添加过滤条件则会删除所有行
     *                           具体注释参考 {@link DatabaseCondition}
     */
    public void delete(Class<?> clazz, DatabaseCondition... databaseConditions) throws NoSuchFieldException {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        String tableName;
        DatabaseTable databaseTable = clazz.getAnnotation(DatabaseTable.class);
        //这里的注释同 getCreateTableSql() 方法
        if (databaseTable == null) {
            tableName = clazz.getSimpleName();
        } else {
            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
            tableName = databaseTable.tableName();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ").append(tableName);
        Field[] fields = clazz.getDeclaredFields();
        //添加过滤条件
        sql.append(addConditions(clazz, databaseConditions));
        sql.append(";");
        Log.d("DatabaseManager", "sql--->" + sql);
        mSqLiteDatabase.execSQL(sql.toString());
    }

    /**
     * Description:修改数据，类似 insert 操作，相关注释可以参考
     * Date:2018/11/15
     *
     * @param obj                用于替换旧数据的新数据
     * @param databaseConditions 可选参数，数据过滤的条件，如果不添加过滤条件则会修改所有行
     *                           具体注释参考 {@link DatabaseCondition}
     */
    public void update(Object obj, DatabaseCondition... databaseConditions) throws IllegalAccessException, NoSuchFieldException {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        String tableName;
        DatabaseTable databaseTable = obj.getClass().getAnnotation(DatabaseTable.class);
        //这里的注释同 getCreateTableSql() 方法
        if (databaseTable == null) {
            tableName = obj.getClass().getSimpleName();
        } else {
            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
            tableName = databaseTable.tableName();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ").append(tableName).append(" SET ");
        Map<String, String> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            int modifiers = field.getModifiers();
            if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                continue;
            }
            String value;
            if (field.get(obj) == null) {
                value = "NULL";
            } else {
                value = field.get(obj).toString();
            }
            String columnName;
            DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
            if (databaseField == null) {
                columnName = field.getName();
            } else {
                //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
                columnName = databaseField.columnName();
                if (databaseField.type() == DatabaseField.TYPE.TEXT && !value.equals("NULL")) {
                    value = "'" + value + "'";
                }
            }
            map.put(columnName, value);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sql.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
        }
        //删除最后一个 ','
        sql.deleteCharAt(sql.length() - 1);
        //添加过滤条件
        sql.append(addConditions(obj.getClass(), databaseConditions));
        sql.append(";");
        Log.d("DatabaseManager", "sql--->" + sql);
        mSqLiteDatabase.execSQL(sql.toString());
    }

    /**
     * Description:查询数据
     * Date:2018/11/15
     *
     * @param clazz              需要操作的类名，用于确定操作哪张表
     * @param databaseConditions 可选参数，数据过滤的条件，如果不添加过滤条件则会查询所有行
     *                           具体注释参考 {@link DatabaseCondition}
     */
    public <T> List<T> queryList(Class<T> clazz, DatabaseCondition... databaseConditions)
            throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        List<T> tList = new ArrayList<>();
        String tableName;
        DatabaseTable databaseTable = clazz.getAnnotation(DatabaseTable.class);
        //这里的注释同 getCreateTableSql() 方法
        if (databaseTable == null) {
            tableName = clazz.getSimpleName();
        } else {
            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
            tableName = databaseTable.tableName();
        }
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ")
                .append(tableName)
                .append(addConditions(clazz, databaseConditions))
                .append(";");
        Log.d("DatabaseManager", "sql--->" + sql);
        Cursor cursor = mSqLiteDatabase.rawQuery(sql.toString(), new String[]{});
        while (cursor.moveToNext()) {
            //创建新对象
            T t = clazz.newInstance();
            Field[] fields = t.getClass().getDeclaredFields();
            //遍历所有成员变量
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                int modifiers = field.getModifiers();
                //不操作 static 和 final 修饰符修饰的变量
                if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                    continue;
                }
                String columnName;
                DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
                //这里的注释同 getCreateTableSql() 方法
                if (databaseField == null) {
                    columnName = field.getName();
                } else {
                    //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
                    columnName = databaseField.columnName();
                }
                //查询到的值先使用 String 接收，然后通过反射获取变量类型再转为基础类型
                String value = cursor.getString(cursor.getColumnIndex(columnName));
                if (field.getType() == byte.class) {
                    field.set(t, Byte.valueOf(value));
                } else if (field.getType() == short.class) {
                    field.set(t, Short.valueOf(value));
                } else if (field.getType() == int.class) {
                    field.set(t, Integer.valueOf(value));
                } else if (field.getType() == long.class) {
                    field.set(t, Long.valueOf(value));
                } else if (field.getType() == float.class) {
                    field.set(t, Float.valueOf(value));
                } else if (field.getType() == double.class) {
                    field.set(t, Double.valueOf(value));
                } else if (field.getType() == char.class) {
                    field.set(t, value);
                } else if (field.getType() == boolean.class) {
                    //boolean 被当成字符串存储
                    field.set(t, value.equals("true"));
                } else {
                    field.set(t, value);
                }
            }
            tList.add(t);
        }
        //关闭游标
        cursor.close();
        return tList;
    }

    /**
     * Description:分页查询数据，类似queryList(Class<T> clazz, DatabaseCondition... databaseConditions)
     * 只是分页需要多加两个关键字 LIMIT（限制每次查询的条数，即 pageSize）和 OFFSET（限制偏移量，相当于页码，即 page）
     * Date:2018/11/15
     *
     * @param clazz              需要操作的类名，用于确定操作哪张表
     * @param databaseConditions 可选参数，数据过滤的条件，如果不添加过滤条件则会查询所有行
     *                           具体注释参考 {@link DatabaseCondition}
     */
    public <T> List<T> queryList(Class<T> clazz, int page, int pageSize, DatabaseCondition... databaseConditions)
            throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        List<T> tList = new ArrayList<>();
        String tableName;
        DatabaseTable databaseTable = clazz.getAnnotation(DatabaseTable.class);
        if (databaseTable == null) {
            tableName = clazz.getSimpleName();
        } else {
            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
            tableName = databaseTable.tableName();
        }
        int offset = (page - 1) * pageSize;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ")
                .append(tableName)
                .append(addConditions(clazz, databaseConditions))
                .append(" LIMIT ")
                .append(pageSize)
                .append(" OFFSET ")
                .append(offset)
                .append(";");
        Log.d("DatabaseManager", "sql--->" + sql);
        Cursor cursor = mSqLiteDatabase.rawQuery(sql.toString(), new String[]{});
        while (cursor.moveToNext()) {
            T t = clazz.newInstance();
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                int modifiers = field.getModifiers();
                if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
                    continue;
                }
                String columnName;
                DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
                if (databaseField == null) {
                    columnName = field.getName();
                } else {
                    //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
                    columnName = databaseField.columnName();
                }
                String value = cursor.getString(cursor.getColumnIndex(columnName));
                if (field.getType() == byte.class) {
                    field.set(t, Byte.valueOf(value));
                } else if (field.getType() == short.class) {
                    field.set(t, Short.valueOf(value));
                } else if (field.getType() == int.class) {
                    field.set(t, Integer.valueOf(value));
                } else if (field.getType() == long.class) {
                    field.set(t, Long.valueOf(value));
                } else if (field.getType() == float.class) {
                    field.set(t, Float.valueOf(value));
                } else if (field.getType() == double.class) {
                    field.set(t, Double.valueOf(value));
                } else if (field.getType() == char.class) {
                    field.set(t, value);
                } else if (field.getType() == boolean.class) {
                    //boolean 被当成字符串存储
                    field.set(t, value.equals("true"));
                } else {
                    field.set(t, value);
                }
            }
            tList.add(t);
        }
        cursor.close();
        return tList;
    }

    /**
     * Description:添加 WHERE 子句过滤条件
     * Date:2018/11/15
     */
    private StringBuilder addConditions(Class<?> clazz, DatabaseCondition[] databaseConditions) throws NoSuchFieldException {
        StringBuilder where = new StringBuilder();
        //如果条件数为 0，返回空字符串
        if (databaseConditions.length > 0) {
            where.append(" WHERE");
            for (int i = 0; i < databaseConditions.length; i++) {
                DatabaseCondition databaseCondition = databaseConditions[i];
                //如果条件的左或右为空则不添加该条件
                if (TextUtils.isEmpty(databaseCondition.getFieldName()) || TextUtils.isEmpty(databaseCondition.getValue())) {
                    continue;
                }
                //先将条件的类型添加到前面，等遍历完后再去掉第一个条件前面的 AND 或 OR
                where.append(" ")
                        .append(databaseCondition.getType().toString())
                        .append(" ");
                Field field = clazz.getDeclaredField(databaseCondition.getFieldName());
                String columnName;
                DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
                if (databaseField == null) {
                    columnName = field.getName();
                } else {
                    //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
                    columnName = databaseField.columnName();
                }
                where.append(columnName)
                        .append(databaseCondition.getCondition().getOperator())
                        .append(databaseCondition.getValue());
            }
            //找到 WHERE 关键字后面第一个空格的下标作为开始下标
            int startIndex = where.indexOf(" ", where.indexOf(" WHERE") + " WHERE".length());
            //如果开始下标为 -1 则说明 WHERE 后面没有条件，如果不为 1, 则删掉 WHERE 后面第一个空格到下一个空格（不包括）
            // 之间的字符串，即第一个 AND 或 OR 关键字
            if (startIndex > 0) {
                int endIndex = where.indexOf(" ", startIndex + 1);
                where.delete(startIndex, endIndex);
            }
            //如果 WHERE 没有条件则去掉 " WHERE"
            if (where.indexOf(" WHERE") == where.length() - " WHERE".length()) {
                where.delete(where.indexOf(" WHERE"), where.length());
            }
        }
        return where;
    }
}
