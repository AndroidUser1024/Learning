package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 8:57
 * Description:
 */
public class FriendDaoImpl extends AbsDaoImpl<FriendBean> implements IFriendDao {
    private final String TAG = FriendDaoImpl.class.getSimpleName();

    public FriendDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public int insert(FriendBean friendBean) {
        // 先查询该 id 是否存在
        String sql = "SELECT COUNT(*) AS count FROM friend WHERE id=%s";
        sql = String.format(sql, getStringValue(friendBean.getId()));
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        int count = 0;
        try {
            if (cursor.moveToNext()) {
                count = cursor.getInt(cursor.getColumnIndex("count"));
            }
        } finally {
            cursor.close();
        }

        if (count == 0) {
            // 如果不存在,则新增
            sql = "INSERT INTO friend" +
                    " (id,nickname,headImg,headImgSmall,signature,remark,top,doNotDisturb,blackList)" +
                    " VALUES" +
                    " (%s,%s,%s,%s,%s,%s,%s,%s,%s)";
            sql = String.format(sql, getStringValue(friendBean.getId()), getStringValue(friendBean.getNickname())
                    , getStringValue(friendBean.getHeadImg()), getStringValue(friendBean.getHeadImgSmall())
                    , getStringValue(friendBean.getSignature()), getStringValue(friendBean.getRemark())
                    , friendBean.getTop(), friendBean.getDoNotDisturb(), friendBean.getBlackList());
            getSQLiteDatabase().execSQL(sql);
        } else {
            // 已存在则更新
            sql = "UPDATE friend SET" +
                    " nickname=%s,headImg=%s,headImgSmall=%s" +
                    " ,signature=%s,remark=%s,top=%s" +
                    " ,doNotDisturb=%s,blackList=%s" +
                    " WHERE id=%s";
            sql = String.format(sql, getStringValue(friendBean.getNickname()), getStringValue(friendBean.getHeadImg())
                    , getStringValue(friendBean.getHeadImgSmall()), getStringValue(friendBean.getSignature())
                    , getStringValue(friendBean.getRemark()), friendBean.getTop(), friendBean.getDoNotDisturb()
                    , friendBean.getBlackList(), getStringValue(friendBean.getId()));
            getSQLiteDatabase().execSQL(sql);
        }
        return 1;
    }


    @Override
    public FriendBean selectById(String id) {
        String sql = "SELECT" +
                " f.id,f.nickname,f.headImg,f.headImgSmall,f.signature,f.remark,f.top,f.doNotDisturb,f.blackList" +
                " FROM friend AS f" +
                " WHERE f.id=%s";
        sql = String.format(sql, getStringValue(id));
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                FriendBean friendBean = new FriendBean();
                friendBean.setId(cursor.getString(cursor.getColumnIndex("id")));
                friendBean.setNickname(cursor.getString(cursor.getColumnIndex("nickname")));
                friendBean.setHeadImg(cursor.getString(cursor.getColumnIndex("headImg")));
                friendBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("headImgSmall")));
                friendBean.setSignature(cursor.getString(cursor.getColumnIndex("signature")));
                friendBean.setRemark(cursor.getString(cursor.getColumnIndex("remark")));
                friendBean.setTop(cursor.getInt(cursor.getColumnIndex("top")));
                friendBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("doNotDisturb")));
                friendBean.setBlackList(cursor.getInt(cursor.getColumnIndex("blackList")));
                cursor.close();
                return friendBean;
            }
        } finally {
            cursor.close();
        }
        return null;
    }
}
