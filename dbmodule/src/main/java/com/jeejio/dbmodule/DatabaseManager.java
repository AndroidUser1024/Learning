package com.jeejio.dbmodule;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;


import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.annotation.Delete;
import com.jeejio.dbmodule.annotation.Id;
import com.jeejio.dbmodule.annotation.Insert;
import com.jeejio.dbmodule.annotation.ObjParam;
import com.jeejio.dbmodule.annotation.Param;
import com.jeejio.dbmodule.annotation.Select;
import com.jeejio.dbmodule.annotation.Table;
import com.jeejio.dbmodule.annotation.Update;
import com.jeejio.dbmodule.bean.ColumnInfoBean;
import com.jeejio.dbmodule.bean.IdColumnInfoBean;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.dao.impl.DefaultDaoImpl;
import com.jeejio.dbmodule.util.SqlUtil2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            HashMap<String, String> map = new HashMap<>();
            map.put("${insert}", SqlUtil2.getInsertSql(clazz));
            map.put("${deleteById}", SqlUtil2.getDeleteByIdSql(clazz));
            map.put("${updateById}", SqlUtil2.getUpdateByIdSql(clazz));
            map.put("${selectById}", SqlUtil2.getSelectByIdSql(clazz));
            map.put("${selectList}", SqlUtil2.getSelectListSql(clazz));
            mSqlMap.put(clazz, map);
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
        Log.i(TAG, "sql--->" + sql);
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

    public <T> T getDao(final Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 获取注解上的 sql 语句
                String sql = getSql(clazz, method);
                // 获取参数集合
                Map<String, Object> paramMap = getParamMap(method, args);
                // 将参数集合替换预定义 sql 中对应的占位符
                sql = formatSql(sql, paramMap);
                Type returnType = method.getGenericReturnType();
                Cursor cursor = null;
                try {
                    if (method.getAnnotation(Insert.class) != null) {
                        return executeSql(sql);
                    } else if (method.getAnnotation(Delete.class) != null) {
                        return executeSql(sql);
                    } else if (method.getAnnotation(Update.class) != null) {
                        return executeSql(sql);
                    } else if (method.getAnnotation(Select.class) != null) {
                        cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
                        if (returnType == int.class || returnType == Integer.class) {
                            // 返回 int
                            if (cursor.moveToNext()) {
                                return cursor.getInt(0);
                            }
                            return 0;
                        } else if (returnType == long.class || returnType == Long.class) {
                            // 返回 long
                            if (cursor.moveToNext()) {
                                return cursor.getInt(0);
                            }
                            return 0l;
                        } else if (returnType == float.class || returnType == Float.class) {
                            // 返回 float
                            if (cursor.moveToNext()) {
                                return cursor.getInt(0);
                            }
                            return 0f;
                        } else if (returnType == double.class || returnType == Double.class) {
                            // 返回 double
                            if (cursor.moveToNext()) {
                                return cursor.getInt(0);
                            }
                            return 0d;
                        } else {
                            // 除了 int,long,float,double,其他类型暂时都统一作为对象处理
                            if (returnType instanceof ParameterizedType) {
                                // 如果 returnType 为 ParameterizedType 则是使用了泛型,认为是集合
                                ((ParameterizedType) returnType).getActualTypeArguments();
                                List<Object> list = new ArrayList();
                                if (((ParameterizedType) returnType).getActualTypeArguments().length == 0) {
                                    return list;
                                }
                                Type actualTypeArgument = ((ParameterizedType) returnType).getActualTypeArguments()[0];
                                while (cursor.moveToNext()) {
                                    Object obj = getObj(actualTypeArgument.toString().replace("class ", ""), cursor);
                                    if (obj != null) {
                                        list.add(obj);
                                    }
                                }
                                return list;
                            } else {
                                // 单个对象
                                if (cursor.moveToNext()) {
                                    return getObj(returnType.toString().replace("class ", ""), cursor);
                                }
                                return null;
                            }
                        }
                    }
                } catch (SQLException ignored) {
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                return null;
            }
        });
    }

    private Map<Class, Map<String, String>> mSqlMap = new HashMap<>();


    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/4/19 21:50
     * Description:获取预定义 sql 语句
     *
     * @param clazz  被代理的类
     * @param method 被调用的方法
     */
    private String getSql(Class<?> clazz, Method method) {
        String value = null;
        if (method.getAnnotation(Insert.class) != null) {
            value = method.getAnnotation(Insert.class).value();
        } else if (method.getAnnotation(Delete.class) != null) {
            value = method.getAnnotation(Delete.class).value();
        } else if (method.getAnnotation(Update.class) != null) {
            value = method.getAnnotation(Update.class).value();
        } else if (method.getAnnotation(Select.class) != null) {
            value = method.getAnnotation(Select.class).value();
        }
        // 获取该接口真实泛型,第一个真实泛型是表的映射类
        Type[] genericInterfaces = clazz.getGenericInterfaces();
        if (genericInterfaces.length == 0) {
            return value;
        }
        Type type = genericInterfaces[0];
        if (!(type instanceof ParameterizedType)) {
            return value;
        }
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (actualTypeArguments.length == 0) {
            return value;
        }
        Map<String, String> map = mSqlMap.get(actualTypeArguments[0]);
        if (map == null) {
            return value;
        }
        // 先查询是否是已安装的内置的 sql
        if (!TextUtils.isEmpty(map.get(value))) {
            // 如果不是,则使用 value 作为需要执行的预定义 sql
            return map.get(value);
        }
        return value;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/4/19 21:50
     * Description:获取参数集合
     *
     * @param method 被调用的方法
     * @param args   参数值集合
     */
    private Map<String, Object> getParamMap(Method method, Object[] args) throws IllegalAccessException {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        // 定义一个集合来保存参数
        Map<String, Object> paramMap = new HashMap<>();
        if (parameterAnnotations.length == 1
                && parameterAnnotations[0].length == 1
                && (parameterAnnotations[0][0] instanceof ObjParam)) {
            Object arg = args[0];
            for (Field field : args[0].getClass().getDeclaredFields()) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                paramMap.put(field.getName(), field.get(arg));
            }
        } else {
            for (int i = 0; i < parameterAnnotations.length; i++) {
                boolean hasParamAnnotation = false;
                for (Annotation annotation : parameterAnnotations[i]) {
                    if (!(annotation instanceof Param)) {
                        continue;
                    }
                    String name = ((Param) annotation).value();
                    paramMap.put(name, args[i]);
                    hasParamAnnotation = true;
                }
                if (!hasParamAnnotation) {
                    throw new IllegalArgumentException("The param must be have Param Annotation");
                }
            }
        }
        return paramMap;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/4/19 21:50
     * Description:格式化 sql,将参数值替换到 sql 语句中
     *
     * @param sql      自定义 sql
     * @param paramMap 参数集合
     */
    private String formatSql(String sql, Map<String, Object> paramMap) {
        Pattern pattern = Pattern.compile("#\\{([a-z]|[A-Z]|[0-9])+\\}");
        Matcher matcher = pattern.matcher(sql);
        while (matcher.find()) {
            String substring = sql.substring(matcher.start(), matcher.end());
            String key = substring.replace("#{", "")
                    .replace("}", "");
            Object paramValue = paramMap.get(key);
            if (paramValue instanceof String) {
                sql = sql.replace(substring, "\'" + paramValue + "\'");
            } else {
                sql = sql.replace(substring, "" + paramValue);
            }
            matcher = pattern.matcher(sql);
        }
        return sql;
    }


    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/4/19 21:50
     * Description:将原生 sql 查询的结果封装成对象
     */
    private Object getObj(String className, Cursor cursor) {
        Object obj;
        Class<?> cls;
        try {
            cls = Class.forName(className);
            obj = cls.newInstance();
        } catch (Exception e) {
            return null;
        }
        String[] columnNameArray = cursor.getColumnNames();
        for (String columnName : columnNameArray) {
            Field field = null;
            // 找不到列名对应的变量,直接跳过
            try {
                field = cls.getDeclaredField(columnName);
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
                    field.set(obj, cursor.getInt(columnIndex));
                } else if (fieldType == long.class || fieldType == Long.class) {
                    field.set(obj, cursor.getLong(columnIndex));
                } else if (fieldType == float.class || fieldType == Float.class) {
                    field.set(obj, cursor.getFloat(columnIndex));
                } else if (fieldType == double.class || fieldType == Double.class) {
                    field.set(obj, cursor.getDouble(columnIndex));
                } else if (fieldType == String.class) {
                    field.set(obj, cursor.getString(columnIndex));
                }
            } catch (IllegalAccessException ignored) {
            }
        }
        return obj;
    }
}
