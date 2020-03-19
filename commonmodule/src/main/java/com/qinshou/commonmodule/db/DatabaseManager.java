package com.qinshou.commonmodule.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.qinshou.commonmodule.db.annotation.Column;
import com.qinshou.commonmodule.db.annotation.Id;
import com.qinshou.commonmodule.db.annotation.Table;
import com.qinshou.commonmodule.db.bean.ColumnInfoBean;
import com.qinshou.commonmodule.db.bean.IdColumnInfoBean;
import com.qinshou.commonmodule.db.dao.IBaseDao;
import com.qinshou.commonmodule.db.dao.impl.DefaultDaoImpl;

import java.lang.reflect.Field;
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
                mIdMap.put(clazz, new IdColumnInfoBean(tableName, columnName, field.getName(), column.type(), id.autoIncrement()));
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
}
