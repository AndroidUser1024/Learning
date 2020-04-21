package com.qinshou.dbmodule;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;

import com.qinshou.dbmodule.annotation.Column;
import com.qinshou.dbmodule.annotation.Delete;
import com.qinshou.dbmodule.annotation.Id;
import com.qinshou.dbmodule.annotation.Insert;
import com.qinshou.dbmodule.annotation.ObjParam;
import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.annotation.Table;
import com.qinshou.dbmodule.annotation.Update;
import com.qinshou.dbmodule.bean.ColumnInfoBean;
import com.qinshou.dbmodule.bean.IdColumnInfoBean;
import com.qinshou.dbmodule.util.SqlUtil;
import com.qinshou.dbmodule.bean.TableInfoBean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
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
     * Map<Class, String> 中 Key 为表映射类 class,Value 为表信息
     */
    private Map<Class, TableInfoBean> mTableInfoBeanMap = new HashMap<>();

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
            HashMap<String, String> map = new HashMap<>();
            map.put("${insert}", SqlUtil.getInsertSql(clazz));
            map.put("${deleteById}", SqlUtil.getDeleteByIdSql(clazz));
            map.put("${updateById}", SqlUtil.getUpdateByIdSql(clazz));
            map.put("${selectById}", SqlUtil.getSelectByIdSql(clazz));
            map.put("${selectList}", SqlUtil.getSelectListSql(clazz));
            map.put("${existsById}", SqlUtil.getExistsByIdSql(clazz));
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
        TableInfoBean tableInfoBean = new TableInfoBean();
        tableInfoBean.setTableName(getTableName(clazz, clazz.getAnnotation(Table.class)));
        List<ColumnInfoBean> columnInfoBeanList = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            Column column = field.getAnnotation(Column.class);
            if (column == null) {
                continue;
            }
            Id id = field.getAnnotation(Id.class);
            if (id == null) {
                // 非主键
                columnInfoBeanList.add(new ColumnInfoBean(getColumnName(field, column), field.getName(), field.getType()));
            } else {
                // 主键
                tableInfoBean.setIdColumnInfoBean(new IdColumnInfoBean(getColumnName(field, column), field.getName(), field.getType(), id.autoIncrement(), id.useGeneratedKeys()));
            }
        }
        tableInfoBean.setColumnInfoBeanList(columnInfoBeanList);
        mTableInfoBeanMap.put(clazz, tableInfoBean);

    }

    public TableInfoBean getTableInfoByClass(Class<?> clazz) {
        return mTableInfoBeanMap.get(clazz);
    }

    private Semaphore mSemaphore = new Semaphore(1);

    public <T> T getDao(final Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 获取该接口真实泛型,第一个真实泛型是表的映射类
                Type[] genericInterfaces = clazz.getGenericInterfaces();
                if (genericInterfaces.length == 0) {
                    throw new Exception();
                }
                Type type = genericInterfaces[0];
                if (!(type instanceof ParameterizedType)) {
                    throw new Exception();
                }
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                if (actualTypeArguments.length == 0) {
                    throw new Exception();
                }
                // 获取注解上的 sql 语句
                String sql = getSql(actualTypeArguments[0], method);
                // 获取参数集合
                Map<String, Object> paramMap = getParamMap(method, args);
                // 将参数集合替换预定义 sql 中对应的占位符
                sql = formatSql(sql, paramMap);
                if (BuildConfig.DEBUG) {
                    Log.i(TAG, sql);
                }
                Cursor cursor = null;
                try {
                    if (method.getAnnotation(Insert.class) != null) {
                        TableInfoBean tableInfoBean = mTableInfoBeanMap.get(actualTypeArguments[0]);
                        SQLiteStatement sqLiteStatement = mSqLiteDatabase.compileStatement(sql);
                        long lastRowInserted = sqLiteStatement.executeInsert();
                        IdColumnInfoBean idColumnInfoBean = tableInfoBean.getIdColumnInfoBean();
                        if (isObjParam(method)
                                && idColumnInfoBean.isAutoIncrement()
                                && idColumnInfoBean.isUseGeneratedKeys()) {
                            // 返回自增长 id
                            Object arg = args[0];
                            Field idField = arg.getClass().getDeclaredField(idColumnInfoBean.getFieldName());
                            if (!idField.isAccessible()) {
                                idField.setAccessible(true);
                            }
                            idField.set(arg, idColumnInfoBean.convertIdValue(lastRowInserted));
                        }
                        return 1;
                    } else if (method.getAnnotation(Delete.class) != null) {
                        return mSqLiteDatabase.compileStatement(sql).executeUpdateDelete();
                    } else if (method.getAnnotation(Update.class) != null) {
                        return mSqLiteDatabase.compileStatement(sql).executeUpdateDelete();
                    } else if (method.getAnnotation(Select.class) != null) {
                        cursor = mSqLiteDatabase.rawQuery(sql, new String[]{});
                        Type returnType = method.getGenericReturnType();
                        if (returnType == int.class || returnType == Integer.class) {
                            // 返回 int
                            if (cursor.moveToNext()) {
                                return cursor.getInt(0);
                            }
                            return 0;
                        } else if (returnType == long.class || returnType == Long.class) {
                            // 返回 long
                            if (cursor.moveToNext()) {
                                return cursor.getLong(0);
                            }
                            return 0l;
                        } else if (returnType == float.class || returnType == Float.class) {
                            // 返回 float
                            if (cursor.moveToNext()) {
                                return cursor.getFloat(0);
                            }
                            return 0f;
                        } else if (returnType == double.class || returnType == Double.class) {
                            // 返回 double
                            if (cursor.moveToNext()) {
                                return cursor.getDouble(0);
                            }
                            return 0d;
                        } else {
                            // 除了 int,long,float,double,其他类型暂时都统一作为对象处理
                            if (returnType instanceof ParameterizedType) {
                                // 如果 returnType 为 ParameterizedType 则是使用了泛型,认为是集合,接口现在要不要只支持 list 呢
                                ((ParameterizedType) returnType).getActualTypeArguments();
                                if (((ParameterizedType) returnType).getActualTypeArguments().length == 0) {
                                    return new ArrayList<>();
                                }
                                String className;
                                if (mSqlMap.get(actualTypeArguments[0]).containsKey(method.getAnnotation(Select.class).value())) {
                                    // 内置的 sql,类型为该接口泛型的一个真实类型
                                    className = actualTypeArguments[0].toString().replace("class ", "");
                                } else {
                                    className = ((ParameterizedType) returnType).getActualTypeArguments()[0].toString().replace("class ", "");
                                }
                                List<Object> list = new ArrayList();
                                while (cursor.moveToNext()) {
                                    Object obj = getObj(className, cursor);
                                    if (obj != null) {
                                        list.add(obj);
                                    }
                                }
                                return list;
                            } else {
                                // 单个对象
                                String className = "";
                                if (mSqlMap.get(actualTypeArguments[0]).containsKey(method.getAnnotation(Select.class).value())) {
                                    // 内置的 sql,类型为该接口泛型的一个真实类型
                                    className = actualTypeArguments[0].toString().replace("class ", "");
                                } else {
                                    className = returnType.toString().replace("class ", "");
                                }
                                if (cursor.moveToNext()) {
                                    return getObj(className, cursor);
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
     * @param type   被代理的类
     * @param method 被调用的方法
     */
    private String getSql(Type type, Method method) {
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
        Map<String, String> map = mSqlMap.get(type);
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
    private Map<String, Object> getParamMap(Method method, Object[] args) throws Exception {
        // 定义一个集合来保存参数
        Map<String, Object> paramMap = new HashMap<>();
        if (isObjParam(method)) {
            Object arg = args[0];
            for (Field field : args[0].getClass().getDeclaredFields()) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                paramMap.put(field.getName(), field.get(arg));
            }
        } else {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
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
                    throw new Exception("The param must be have Param Annotation");
                }
            }
        }
        return paramMap;
    }

    private boolean isObjParam(Method method) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        return parameterAnnotations.length == 1
                && parameterAnnotations[0].length == 1
                && (parameterAnnotations[0][0] instanceof ObjParam);
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
            e.printStackTrace();
            return null;
        }
        String[] columnNameArray = cursor.getColumnNames();
        for (String columnName : columnNameArray) {
            Field field = null;
            // 找不到列名对应的变量,直接跳过
            try {
                field = cls.getDeclaredField(columnName);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
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
