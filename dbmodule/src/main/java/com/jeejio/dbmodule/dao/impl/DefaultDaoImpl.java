package com.jeejio.dbmodule.dao.impl;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.bean.ColumnInfoBean;
import com.jeejio.dbmodule.bean.IdColumnInfoBean;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.jeejio.dbmodule.util.SqlUtil;
import com.jeejio.dbmodule.util.Where;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/18 18:40
 * Description:默认 Dao 实现类
 */
public class DefaultDaoImpl<T> implements IBaseDao<T> {
    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase mSQLiteDatabase;
    private Class<T> mClass;

    public DefaultDaoImpl(SQLiteDatabase SQLiteDatabase, Class<T> aClass) {
        mSQLiteDatabase = SQLiteDatabase;
        mClass = aClass;
    }

    @Override
    public T insert(T t) {
        try {
            String sql = SqlUtil.getInsertSql(t);
            mSQLiteDatabase.execSQL(sql);
        } catch (Exception e) {
            Log.e(TAG, "insert" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        }
        return t;
    }

    @Override
    public int deleteById(Object id) {
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
        String sql = SqlUtil.getDeleteSql(mClass, new Where.Builder()
                .equal(idColumnInfo.getColumnName(), id)
                .build());
        try {
            mSQLiteDatabase.execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG, "deleteById" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
            return 0;
        }
        return 1;
    }

    @Override
    public int delete(T t) {
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
        try {
            Field idField = t.getClass().getDeclaredField(idColumnInfo.getFieldName());
            if (!idField.isAccessible()) {
                idField.setAccessible(true);
            }
            Object id = idField.get(t);
            return deleteById(id);
        } catch (Exception e) {
            Log.e(TAG, "deleteById" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        }
        return 0;
    }

    @Override
    public T update(T t) {
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
        try {
            Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
            if (!idField.isAccessible()) {
                idField.setAccessible(true);
            }
            String sql = SqlUtil.getUpdateSql(t, new Where.Builder()
                    .equal(idColumnInfo.getColumnName(), idField.get(t))
                    .build());
            mSQLiteDatabase.execSQL(sql);
        } catch (Exception e) {
            Log.e(TAG, "update" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        }
        return t;
    }

    @Override
    public T selectById(Object id) {
        T t = null;
        Cursor cursor = null;
        try {
            t = mClass.newInstance();
            // 主键
            IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
            String sql = SqlUtil.getQuerySql(mClass, new Where.Builder()
                    .equal(idColumnInfo.getColumnName(), id)
                    .build());
            cursor = mSQLiteDatabase.rawQuery(sql, new String[]{});
            if (cursor.moveToNext()) {
                Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
                if (!idField.isAccessible()) {
                    idField.setAccessible(true);
                }
                if (idColumnInfo.getType() == Column.Type.TEXT) {
                    idField.set(t, cursor.getString(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else {
                    idField.set(t, cursor.getInt(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                }
                // 其余列
                for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(mClass)) {
                    Field field = mClass.getDeclaredField(columnInfoBean.getFieldName());
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (columnInfoBean.getType() == Column.Type.TEXT) {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else {
                        field.set(t, cursor.getInt(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "selectById" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return t;
    }

    @Override
    public List<T> selectList() {
        List<T> tList = new ArrayList<>();
        Cursor cursor = null;
        try {
            String sql = SqlUtil.getQuerySql(mClass, null);
            cursor = mSQLiteDatabase.rawQuery(sql, new String[]{});
            while (cursor.moveToNext()) {
                T t = mClass.newInstance();
                // 主键
                IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
                Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
                if (!idField.isAccessible()) {
                    idField.setAccessible(true);
                }
                if (idColumnInfo.getType() == Column.Type.TEXT) {
                    idField.set(t, cursor.getString(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else {
                    idField.set(t, cursor.getInt(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                }
                // 其余列
                for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(mClass)) {
                    Field field = mClass.getDeclaredField(columnInfoBean.getFieldName());
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (columnInfoBean.getType() == Column.Type.TEXT) {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else {
                        field.set(t, cursor.getInt(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    }
                }
                tList.add(t);
            }
        } catch (Exception e) {
            Log.e(TAG, "selectList" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return tList;
    }
}
