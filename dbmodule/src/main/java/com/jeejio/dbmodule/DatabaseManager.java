package com.jeejio.dbmodule;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.annotation.Id;
import com.jeejio.dbmodule.annotation.Table;
import com.jeejio.dbmodule.bean.ColumnInfoBean;
import com.jeejio.dbmodule.bean.IdColumnInfoBean;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.dao.impl.DefaultDaoImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:数据库管理者类
 * Created by 禽兽先生
 * Created on 2017/6/26
 */

public class DatabaseManager {
    private final String TAG = DatabaseManager.class.getSimpleName();

    private SQLiteDatabase mSqLiteDatabase;
    /**
     * Map.Entry<String, String> 中 Key 为数据库的列名,Value 为实体类的属性名
     */
    private Map<Class, IdColumnInfoBean> mIdMap = new HashMap<>();
    /**
     * Map<String, String> 中 Key 为数据库的列名,Value 为实体类的属性名
     */
    private Map<Class, List<ColumnInfoBean>> mColumnMap = new HashMap<>();
    private Map<Class, IBaseDao<?>> mDaoMap = new HashMap<>();

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
        for (Class<?> clazz : classArray) {
            parseObj(clazz);
        }
        //连接数据库
        SQLiteOpenHelper sqLiteOpenHelper = new DatabaseHelper(context, dbName, null, dbVersion, classArray);
        //获取数据库可读可写的操作对象
        mSqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        for (Class<?> clazz : classArray) {
            mDaoMap.put(clazz, new DefaultDaoImpl<>(mSqLiteDatabase, clazz));
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/19 12:55
     * Description:获取表名
     *
     * @param clazz
     * @param table
     */
    private String getTableName(Class<?> clazz, Table table) {
        String tableName;
        if (table == null) {
            // 如果没有使用 Table 注解修饰需要存储的类则抛出异常
            throw new IllegalArgumentException("该类没有使用  Table 注解修饰");
        }
        tableName = table.name();
        // 如果没有指定 Table 的 name 属性,则使用类名作为表名
        if ("".equals(tableName.trim())) {
            tableName = clazz.getSimpleName();
        }
        return tableName;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/19 12:55
     * Description:获取列名
     *
     * @param field
     * @param column
     */
    private String getColumnName(Field field, Column column) {
        String columnName = column.name();
        // 如果没有指定 Column 的 name 属性,则使用属性名作为列名
        if ("".equals(columnName.trim())) {
            columnName = field.getName();
        }
        return columnName;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/19 12:57
     * Description:解析需要持久化的实体类,先解析一遍各属性,放到集合中,在创建 SQL 的时候就不用再次反射了
     *
     * @param clazz 需要持久化的实体类
     */
    private void parseObj(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<ColumnInfoBean> columnInfoBeanList = new ArrayList<>();
        for (Field field : fields) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            Id id = field.getAnnotation(Id.class);
            String tableName = getTableName(clazz, clazz.getAnnotation(Table.class));
            String columnName = getColumnName(field, column);
            if (id == null) {
                // 主键
                columnInfoBeanList.add(new ColumnInfoBean(tableName, columnName, field.getName(), column.type()));
            } else {
                // 非主键
                mIdMap.put(clazz, new IdColumnInfoBean(tableName, columnName, field.getName(), column.type(), id.autoIncrement(), id.useGeneratedKeys()));
            }
        }
        mColumnMap.put(clazz, columnInfoBeanList);
    }

    public IdColumnInfoBean getIdByClass(Class<?> clazz) {
        return mIdMap.get(clazz);
    }

    public List<ColumnInfoBean> getColumnByClass(Class<?> clazz) {
        return mColumnMap.get(clazz);
    }

    public <T> IBaseDao<T> getDaoByClass(Class<T> clazz) {
        return (IBaseDao<T>) mDaoMap.get(clazz);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/20 9:10
     * Description:执行自定义 sql
     */
    public int executeSql(String sql) {
//        Log.i(TAG, "sql--->" + sql);
        try {
            mSqLiteDatabase.execSQL(sql);
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/20 9:10
     * Description:执行自定义 sql 查询
     * 返回值是一个集合,集合中的元素是一个 Map
     * key 是 String 型.默认为列名,如果 sql 中有指定别名则为指定的别名
     * value 是 Object 型,是查询到的值,如果没有值则为 null,拿到后需要强转为自己需要的类型,注意强转前需要进行非空判断
     */
    public List<Map<String, Object>> rawQuery(String sql) {
        Log.i(TAG, "sql--->" + sql);
        List<Map<String, Object>> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
            while (cursor.moveToNext()) {
                Map<String, Object> map = new HashMap<>();
                String[] columnNameArray = cursor.getColumnNames();
                for (String columnName : columnNameArray) {
                    int columnIndex = cursor.getColumnIndex(columnName);
                    switch (cursor.getType(columnIndex)) {
                        case Cursor.FIELD_TYPE_NULL:
                            map.put(columnName, null);
                            break;
                        case Cursor.FIELD_TYPE_INTEGER:
                            map.put(columnName, cursor.getInt(columnIndex));
                            map.put(columnName + "_Int", cursor.getInt(columnIndex));
                            map.put(columnName + "_Long", cursor.getLong(columnIndex));
                            break;
                        case Cursor.FIELD_TYPE_FLOAT:
                            map.put(columnName, cursor.getFloat(columnIndex));
                            break;
                        case Cursor.FIELD_TYPE_STRING:
                            map.put(columnName, cursor.getString(columnIndex));
                            break;
                        case Cursor.FIELD_TYPE_BLOB:
                            map.put(columnName, cursor.getBlob(columnIndex));
                            break;
                    }
                }
                list.add(map);
            }
        } catch (SQLException ignored) {
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return list;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/20 9:10
     * Description:执行自定义 sql 查询
     *
     * @param sql   自定义 sql
     * @param clazz 装载查询出来的数据的映射类,需要提供无参构造方法,属性名需要与查询出来的数据列名对应
     */
    public <T> T rawQuery(String sql, Class<T> clazz) {
        Log.i(TAG, "sql--->" + sql);
        T t = null;
        Cursor cursor = null;
        try {
            cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
            if (cursor.moveToNext()) {
                try {
                    t = clazz.newInstance();
                } catch (Exception e) {
                    return t;
                }
                String[] columnNameArray = cursor.getColumnNames();
                for (String columnName : columnNameArray) {
                    Field field = null;
                    // 找不到列名对应的变量,直接跳过
                    try {
                        field = clazz.getDeclaredField(columnName);
                    } catch (NoSuchFieldException e) {
                        continue;
                    }
                    if (field == null) {
                        continue;
                    }
                    int columnIndex = cursor.getColumnIndex(columnName);
                    // 列对应的值为空,直接跳过
                    if (cursor.getType(columnIndex) == Cursor.FIELD_TYPE_NULL) {
                        continue;
                    }
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    // 根据类型,设置属性的值
                    Class<?> fieldType = field.getType();
                    try {
                        if (fieldType == int.class || fieldType == Integer.class) {
                            field.set(t, cursor.getInt(columnIndex));
                        } else if (fieldType == short.class || fieldType == Short.class) {
                            field.set(t, cursor.getShort(columnIndex));
                        } else if (fieldType == long.class || fieldType == Long.class) {
                            field.set(t, cursor.getLong(columnIndex));
                        } else if (fieldType == float.class || fieldType == Float.class) {
                            field.set(t, cursor.getFloat(columnIndex));
                        } else if (fieldType == double.class || fieldType == Double.class) {
                            field.set(t, cursor.getDouble(columnIndex));
                        } else if (fieldType == String.class) {
                            field.set(t, cursor.getString(columnIndex));
                        }
                    } catch (IllegalAccessException ignored) {
                    }
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return t;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/20 9:10
     * Description:执行自定义 sql 查询
     *
     * @param sql   自定义 sql
     * @param clazz 装载查询出来的数据的映射类,需要提供无参构造方法,属性名需要与查询出来的数据列名对应
     */
    public <T> List<T> rawQueryList(String sql, Class<T> clazz) {
        Log.i(TAG, "sql--->" + sql);
        List<T> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
            while (cursor.moveToNext()) {
                T t = null;
                try {
                    t = clazz.newInstance();
                } catch (Exception e) {
                    return list;
                }
                String[] columnNameArray = cursor.getColumnNames();
                for (String columnName : columnNameArray) {
                    Field field = null;
                    // 找不到列名对应的变量,直接跳过
                    try {
                        field = clazz.getDeclaredField(columnName);
                    } catch (NoSuchFieldException e) {
                        continue;
                    }
                    if (field == null) {
                        continue;
                    }
                    // 列对应的值为空,直接跳过
                    int columnIndex = cursor.getColumnIndex(columnName);
                    if (cursor.getType(columnIndex) == Cursor.FIELD_TYPE_NULL) {
                        continue;
                    }
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    // 根据类型,设置属性的值
                    Class<?> fieldType = field.getType();
                    try {
                        if (fieldType == int.class || fieldType == Integer.class) {
                            field.set(t, cursor.getInt(columnIndex));
                        } else if (fieldType == short.class || fieldType == Short.class) {
                            field.set(t, cursor.getShort(columnIndex));
                        } else if (fieldType == long.class || fieldType == Long.class) {
                            field.set(t, cursor.getLong(columnIndex));
                        } else if (fieldType == float.class || fieldType == Float.class) {
                            field.set(t, cursor.getFloat(columnIndex));
                        } else if (fieldType == double.class || fieldType == Double.class) {
                            field.set(t, cursor.getDouble(columnIndex));
                        } else if (fieldType == String.class) {
                            field.set(t, cursor.getString(columnIndex));
                        }
                    } catch (IllegalAccessException ignored) {
                    }
                }
                list.add(t);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return list;
    }
}
