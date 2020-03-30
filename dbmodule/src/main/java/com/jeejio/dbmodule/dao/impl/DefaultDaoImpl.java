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
import com.jeejio.dbmodule.condition.QueryCondition;
import com.jeejio.dbmodule.util.SqlUtil;
import com.jeejio.dbmodule.condition.Where;

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
    public synchronized T save(T t) {
        try {
            IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
            Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
            if (!idField.isAccessible()) {
                idField.setAccessible(true);
            }
            Object id = idField.get(t);
            // 先根据 id 判断该数据是否存在,存在则修改,不存在则新增
            if (existsById(id)) {
                return update(t);
            } else {
                return insert(t);
            }
        } catch (Exception e) {
            Log.e(TAG, "save" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        }
        return t;
    }

    @Override
    public T insert(T t) {
        Cursor cursor = null;
        try {
            String sql = SqlUtil.getInsertSql(t);
            mSQLiteDatabase.execSQL(sql);

            IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
            // 如果不是自增长 id 或者不需要返回自增长 id,在这里就可以返回了
            if (!idColumnInfo.isAutoIncrement() || !idColumnInfo.isUseGeneratedKeys()) {
                return t;
            }
            Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
            if (!idField.isAccessible()) {
                idField.setAccessible(true);
            }
            sql = "SELECT" +
                    " MAX(" + idColumnInfo.getColumnName() + ") AS lastInsertId" +
                    " FROM" +
                    " " + idColumnInfo.getTableName();
            cursor = mSQLiteDatabase.rawQuery(sql, new String[]{});
            if (cursor.moveToFirst()) {
                int lastInsertId = cursor.getInt(cursor.getColumnIndex("lastInsertId"));
                idField.set(t, lastInsertId);
            }
        } catch (Exception e) {
            Log.e(TAG, "insert" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
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
    public int delete(QueryCondition... queryConditionArray) {
        try {
            String sql = SqlUtil.getDeleteSql(mClass, queryConditionArray);
            mSQLiteDatabase.execSQL(sql);
        } catch (SQLException e) {
            Log.e(TAG, "delete" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
            return 0;
        }
        return 1;
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
            this.update(t, new Where.Builder()
                    .equal(idColumnInfo.getColumnName(), idField.get(t))
                    .build());
        } catch (Exception e) {
            Log.e(TAG, "update" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        }
        return t;
    }

    @Override
    public T update(T t, QueryCondition... queryConditionArray) {
        try {
            String sql = SqlUtil.getUpdateSql(t, queryConditionArray);
            mSQLiteDatabase.execSQL(sql);
        } catch (Exception e) {
            Log.e(TAG, "update" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        }
        return null;
    }

    @Override
    public T select(QueryCondition... queryConditionArray) {
        T t = null;
        Cursor cursor = null;
        try {
            t = mClass.newInstance();
            String sql = SqlUtil.getQuerySql(mClass, queryConditionArray);
            cursor = mSQLiteDatabase.rawQuery(sql, new String[]{});
            if (cursor.moveToNext()) {
                // 主键
                IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
                Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
                if (!idField.isAccessible()) {
                    idField.setAccessible(true);
                }
                if (idColumnInfo.getType() == Column.Type.INTEGER) {
                    idField.set(t, cursor.getInt(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else if (idColumnInfo.getType() == Column.Type.LONG) {
                    idField.set(t, cursor.getLong(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else {
                    idField.set(t, cursor.getString(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                }
                // 其余列
                for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(mClass)) {
                    Field field = mClass.getDeclaredField(columnInfoBean.getFieldName());
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (columnInfoBean.getType() == Column.Type.INTEGER) {
                        field.set(t, cursor.getInt(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else if (columnInfoBean.getType() == Column.Type.LONG) {
                        field.set(t, cursor.getLong(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "select" + " : " + "mClass--->" + mClass + ",e--->" + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
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
                if (idColumnInfo.getType() == Column.Type.INTEGER) {
                    idField.set(t, cursor.getInt(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else if (idColumnInfo.getType() == Column.Type.LONG) {
                    idField.set(t, cursor.getLong(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else {
                    idField.set(t, cursor.getString(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                }
                // 其余列
                for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(mClass)) {
                    Field field = mClass.getDeclaredField(columnInfoBean.getFieldName());
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (columnInfoBean.getType() == Column.Type.INTEGER) {
                        field.set(t, cursor.getInt(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else if (columnInfoBean.getType() == Column.Type.LONG) {
                        field.set(t, cursor.getLong(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnInfoBean.getColumnName())));
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
            String sql = SqlUtil.getQuerySql(mClass);
            cursor = mSQLiteDatabase.rawQuery(sql, new String[]{});
            while (cursor.moveToNext()) {
                T t = mClass.newInstance();
                // 主键
                IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
                Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
                if (!idField.isAccessible()) {
                    idField.setAccessible(true);
                }
                if (idColumnInfo.getType() == Column.Type.INTEGER) {
                    idField.set(t, cursor.getInt(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else if (idColumnInfo.getType() == Column.Type.LONG) {
                    idField.set(t, cursor.getLong(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else {
                    idField.set(t, cursor.getString(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                }
                // 其余列
                for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(mClass)) {
                    Field field = mClass.getDeclaredField(columnInfoBean.getFieldName());
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (columnInfoBean.getType() == Column.Type.INTEGER) {
                        field.set(t, cursor.getInt(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else if (columnInfoBean.getType() == Column.Type.LONG) {
                        field.set(t, cursor.getLong(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnInfoBean.getColumnName())));
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

    @Override
    public List<T> selectList(QueryCondition... queryConditionArray) {
        List<T> tList = new ArrayList<>();
        Cursor cursor = null;
        try {
            String sql = SqlUtil.getQuerySql(mClass, queryConditionArray);
            cursor = mSQLiteDatabase.rawQuery(sql, new String[]{});
            while (cursor.moveToNext()) {
                T t = mClass.newInstance();
                // 主键
                IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
                Field idField = mClass.getDeclaredField(idColumnInfo.getFieldName());
                if (!idField.isAccessible()) {
                    idField.setAccessible(true);
                }
                if (idColumnInfo.getType() == Column.Type.INTEGER) {
                    idField.set(t, cursor.getInt(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else if (idColumnInfo.getType() == Column.Type.LONG) {
                    idField.set(t, cursor.getLong(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                } else {
                    idField.set(t, cursor.getString(cursor.getColumnIndex(idColumnInfo.getColumnName())));
                }
                // 其余列
                for (ColumnInfoBean columnInfoBean : DatabaseManager.getInstance().getColumnByClass(mClass)) {
                    Field field = mClass.getDeclaredField(columnInfoBean.getFieldName());
                    if (!field.isAccessible()) {
                        field.setAccessible(true);
                    }
                    if (columnInfoBean.getType() == Column.Type.INTEGER) {
                        field.set(t, cursor.getInt(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else if (columnInfoBean.getType() == Column.Type.LONG) {
                        field.set(t, cursor.getLong(cursor.getColumnIndex(columnInfoBean.getColumnName())));
                    } else {
                        field.set(t, cursor.getString(cursor.getColumnIndex(columnInfoBean.getColumnName())));
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

    @Override
    public boolean existsById(Object id) {
        // 主键
        IdColumnInfoBean idColumnInfo = DatabaseManager.getInstance().getIdByClass(mClass);
        StringBuilder sql = new StringBuilder();

        sql.append("SELECT")
                .append(" COUNT(").append(idColumnInfo.getColumnName()).append(") AS count")
                .append(" FROM ")
                .append(idColumnInfo.getTableName())
                .append(" WHERE ");
        if (id instanceof String) {
            sql.append(idColumnInfo.getColumnName()).append("=\'").append(id).append("\'");
        } else {
            sql.append(idColumnInfo.getColumnName()).append("=").append(id).append("");
        }
        Cursor cursor = mSQLiteDatabase.rawQuery(sql.toString(), new String[]{});
        try {
            if (cursor.moveToNext()) {
                int count = cursor.getInt(cursor.getColumnIndex("count"));
                return count > 0;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return false;
    }
}
