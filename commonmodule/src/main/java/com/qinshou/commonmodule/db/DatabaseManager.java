package com.qinshou.commonmodule.db;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import com.qinshou.commonmodule.util.ShowLogUtil;

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
    public void init(Context context, String dbName, int dbVersion, Class<?>... classArray) {
        //连接数据库
        SQLiteOpenHelper sqLiteOpenHelper = new DatabaseHelper(context, dbName, null, dbVersion, classArray);
        //获取数据库可读可写的操作对象
        mSqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/13 15:58
     * Description:插入数据
     *
     * @param object 需要存储的数据
     */
    public int insert(Object object) {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        if (object == null) {
            return 0;
        }
        try {
            String sql = SqlUtil.getInsertSql(object);
            mSqLiteDatabase.execSQL(sql);
        } catch (IllegalAccessException e) {
            return 0;
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/13 15:58
     * Description:删除数据,重载
     *
     * @param clazz 需要操作的类名，用于确定操作哪张表
     */
    public int delete(Class<?> clazz) throws NoSuchFieldException {
        return this.delete(clazz, null);
    }

    /**
     * Description:删除数据
     * Date:2018/11/15
     *
     * @param clazz 需要操作的类名，用于确定操作哪张表
     * @param where 数据过滤的条件，如果不添加过滤条件则会删除所有行
     */
    public int delete(Class<?> clazz, Where where) {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        try {
            String sql = SqlUtil.getDeleteSql(clazz, where);
            mSqLiteDatabase.execSQL(sql);
        } catch (IllegalArgumentException e) {
            return 0;
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/13 16:16
     * Description:修改数据
     *
     * @param object 需要修改的数据
     * @param where  数据过滤的条件，如果不添加过滤条件则会删除所有行
     */
    public int update(Object object, Where where) {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        try {
            String sql = SqlUtil.getUpdateSql(object, where);
            mSqLiteDatabase.execSQL(sql);
        } catch (IllegalAccessException e) {
            return 0;
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/13 18:07
     * Description:查询数据
     *
     * @param clazz 目标类型
     * @param where 查询条件,如果不指定,则返回查询到的列表的第一条数据
     * @return 查询到的数据, 查询不到则为 null
     */
    public <T> T select(Class<T> clazz, Where where) {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        T t = null;
        Cursor cursor = null;
        try {
            String sql = SqlUtil.getQuerySql(clazz, where);
            cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
            if (cursor.moveToNext()) {
                t = clazz.newInstance();
                Field[] fieldArray = t.getClass().getDeclaredFields();
                for (Field field : fieldArray) {
                    Column column = field.getAnnotation(Column.class);
                    if (column == null) {
                        continue;
                    }
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    // 列类型
                    Column.Type type = column.type();
                    String columnName = SqlUtil.getColumnName(field, column);
                    if (type == Column.Type.TEXT) {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnName)));
                    } else {
                        field.setInt(t, cursor.getInt(cursor.getColumnIndex(columnName)));
                    }
                }
            }
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return t;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/13 18:07
     * Description:查询数据
     *
     * @param clazz 目标类型
     * @param where 查询条件
     * @return 查询到的数据列表, 查询不到则为 null
     */
    public <T> List<T> selectList(Class<T> clazz, Where where) {
        if (mSqLiteDatabase == null) {
            throw new IllegalStateException("DatabaseManager 没有初始化");
        }
        List<T> tList = new ArrayList<>();
        Cursor cursor = null;
        try {
            String sql = SqlUtil.getQuerySql(clazz, where);
            cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
            while (cursor.moveToNext()) {
                T t = clazz.newInstance();
                Field[] fieldArray = t.getClass().getDeclaredFields();
                for (Field field : fieldArray) {
                    Column column = field.getAnnotation(Column.class);
                    if (column == null) {
                        continue;
                    }
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    // 列类型
                    Column.Type type = column.type();
                    String columnName = SqlUtil.getColumnName(field, column);
                    if (type == Column.Type.TEXT) {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnName)));
                    } else {
                        field.setInt(t, cursor.getInt(cursor.getColumnIndex(columnName)));
                    }
                }
                tList.add(t);
            }
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return tList;
    }
//    /**
//     * Description:查询数据
//     * Date:2018/11/15
//     *
//     * @param clazz              需要操作的类名，用于确定操作哪张表
//     * @param databaseConditions 可选参数，数据过滤的条件，如果不添加过滤条件则会查询所有行
//     *                           具体注释参考 {@link DatabaseCondition}
//     */
//    public <T> List<T> queryList(Class<T> clazz, DatabaseCondition... databaseConditions)
//            throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//        if (mSqLiteDatabase == null) {
//            throw new IllegalStateException("DatabaseManager 没有初始化");
//        }
//        List<T> tList = new ArrayList<>();
//        String tableName;
//        DatabaseTable databaseTable = clazz.getAnnotation(DatabaseTable.class);
//        //这里的注释同 getCreateTableSql() 方法
//        if (databaseTable == null) {
//            tableName = clazz.getSimpleName();
//        } else {
//            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
//            tableName = databaseTable.tableName();
//        }
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM ")
//                .append(tableName)
//                .append(addConditions(clazz, databaseConditions))
//                .append(";");
//        Log.d("DatabaseManager", "sql--->" + sql);
//        Cursor cursor = mSqLiteDatabase.rawQuery(sql.toString(), new String[]{});
//        while (cursor.moveToNext()) {
//            //创建新对象
//            T t = clazz.newInstance();
//            Field[] fields = t.getClass().getDeclaredFields();
//            //遍历所有成员变量
//            for (Field field : fields) {
//                if (!field.isAccessible()) {
//                    field.setAccessible(true);
//                }
//                int modifiers = field.getModifiers();
//                //不操作 static 和 final 修饰符修饰的变量
//                if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
//                    continue;
//                }
//                String columnName;
//                DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
//                //这里的注释同 getCreateTableSql() 方法
//                if (databaseField == null) {
//                    columnName = field.getName();
//                } else {
//                    //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
//                    columnName = databaseField.columnName();
//                }
//                //查询到的值先使用 String 接收，然后通过反射获取变量类型再转为基础类型
//                String value = cursor.getString(cursor.getColumnIndex(columnName));
//                if (field.getType() == byte.class) {
//                    field.set(t, Byte.valueOf(value));
//                } else if (field.getType() == short.class) {
//                    field.set(t, Short.valueOf(value));
//                } else if (field.getType() == int.class) {
//                    field.set(t, Integer.valueOf(value));
//                } else if (field.getType() == long.class) {
//                    field.set(t, Long.valueOf(value));
//                } else if (field.getType() == float.class) {
//                    field.set(t, Float.valueOf(value));
//                } else if (field.getType() == double.class) {
//                    field.set(t, Double.valueOf(value));
//                } else if (field.getType() == char.class) {
//                    field.set(t, value);
//                } else if (field.getType() == boolean.class) {
//                    //boolean 被当成字符串存储
//                    field.set(t, value.equals("true"));
//                } else {
//                    field.set(t, value);
//                }
//            }
//            tList.add(t);
//        }
//        //关闭游标
//        cursor.close();
//        return tList;
//    }
//
//    /**
//     * Description:分页查询数据，类似queryList(Class<T> clazz, DatabaseCondition... databaseConditions)
//     * 只是分页需要多加两个关键字 LIMIT（限制每次查询的条数，即 pageSize）和 OFFSET（限制偏移量，相当于页码，即 page）
//     * Date:2018/11/15
//     *
//     * @param clazz              需要操作的类名，用于确定操作哪张表
//     * @param databaseConditions 可选参数，数据过滤的条件，如果不添加过滤条件则会查询所有行
//     *                           具体注释参考 {@link DatabaseCondition}
//     */
//    public <T> List<T> queryList(Class<T> clazz, int page, int pageSize, DatabaseCondition... databaseConditions)
//            throws IllegalAccessException, InstantiationException, NoSuchFieldException {
//        if (mSqLiteDatabase == null) {
//            throw new IllegalStateException("DatabaseManager 没有初始化");
//        }
//        List<T> tList = new ArrayList<>();
//        String tableName;
//        DatabaseTable databaseTable = clazz.getAnnotation(DatabaseTable.class);
//        if (databaseTable == null) {
//            tableName = clazz.getSimpleName();
//        } else {
//            //执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
//            tableName = databaseTable.tableName();
//        }
//        int offset = (page - 1) * pageSize;
//        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT * FROM ")
//                .append(tableName)
//                .append(addConditions(clazz, databaseConditions))
//                .append(" LIMIT ")
//                .append(pageSize)
//                .append(" OFFSET ")
//                .append(offset)
//                .append(";");
//        Log.d("DatabaseManager", "sql--->" + sql);
//        Cursor cursor = mSqLiteDatabase.rawQuery(sql.toString(), new String[]{});
//        while (cursor.moveToNext()) {
//            T t = clazz.newInstance();
//            Field[] fields = t.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                if (!field.isAccessible()) {
//                    field.setAccessible(true);
//                }
//                int modifiers = field.getModifiers();
//                if (Modifier.isFinal(modifiers) || Modifier.isStatic(modifiers)) {
//                    continue;
//                }
//                String columnName;
//                DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
//                if (databaseField == null) {
//                    columnName = field.getName();
//                } else {
//                    //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
//                    columnName = databaseField.columnName();
//                }
//                String value = cursor.getString(cursor.getColumnIndex(columnName));
//                if (field.getType() == byte.class) {
//                    field.set(t, Byte.valueOf(value));
//                } else if (field.getType() == short.class) {
//                    field.set(t, Short.valueOf(value));
//                } else if (field.getType() == int.class) {
//                    field.set(t, Integer.valueOf(value));
//                } else if (field.getType() == long.class) {
//                    field.set(t, Long.valueOf(value));
//                } else if (field.getType() == float.class) {
//                    field.set(t, Float.valueOf(value));
//                } else if (field.getType() == double.class) {
//                    field.set(t, Double.valueOf(value));
//                } else if (field.getType() == char.class) {
//                    field.set(t, value);
//                } else if (field.getType() == boolean.class) {
//                    //boolean 被当成字符串存储
//                    field.set(t, value.equals("true"));
//                } else {
//                    field.set(t, value);
//                }
//            }
//            tList.add(t);
//        }
//        cursor.close();
//        return tList;
//    }
//
//    /**
//     * Description:添加 WHERE 子句过滤条件
//     * Date:2018/11/15
//     */
//    private StringBuilder addConditions(Class<?> clazz, DatabaseCondition[] databaseConditions) throws NoSuchFieldException {
//        StringBuilder where = new StringBuilder();
//        //如果条件数为 0，返回空字符串
//        if (databaseConditions.length > 0) {
//            where.append(" WHERE");
//            for (int i = 0; i < databaseConditions.length; i++) {
//                DatabaseCondition databaseCondition = databaseConditions[i];
//                //如果条件的左或右为空则不添加该条件
//                if (TextUtils.isEmpty(databaseCondition.getFieldName()) || TextUtils.isEmpty(databaseCondition.getValue())) {
//                    continue;
//                }
//                //先将条件的类型添加到前面，等遍历完后再去掉第一个条件前面的 AND 或 OR
//                where.append(" ")
//                        .append(databaseCondition.getType().toString())
//                        .append(" ");
//                Field field = clazz.getDeclaredField(databaseCondition.getFieldName());
//                String columnName;
//                DatabaseField databaseField = field.getAnnotation(DatabaseField.class);
//                if (databaseField == null) {
//                    columnName = field.getName();
//                } else {
//                    //同理，执行该方法一定先执行了 init()，所以这里不用判断是否为空字符串
//                    columnName = databaseField.columnName();
//                }
//                where.append(columnName)
//                        .append(databaseCondition.getCondition().getOperator())
//                        .append(databaseCondition.getValue());
//            }
//            //找到 WHERE 关键字后面第一个空格的下标作为开始下标
//            int startIndex = where.indexOf(" ", where.indexOf(" WHERE") + " WHERE".length());
//            //如果开始下标为 -1 则说明 WHERE 后面没有条件，如果不为 1, 则删掉 WHERE 后面第一个空格到下一个空格（不包括）
//            // 之间的字符串，即第一个 AND 或 OR 关键字
//            if (startIndex > 0) {
//                int endIndex = where.indexOf(" ", startIndex + 1);
//                where.delete(startIndex, endIndex);
//            }
//            //如果 WHERE 没有条件则去掉 " WHERE"
//            if (where.indexOf(" WHERE") == where.length() - " WHERE".length()) {
//                where.delete(where.indexOf(" WHERE"), where.length());
//            }
//        }
//        return where;
//    }
}
