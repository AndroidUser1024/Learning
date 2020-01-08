package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.enums.MessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/5 9:03
 * Description:conversation 表的 Dao 的实现类
 */
public class ConversationDaoImpl extends AbsDaoImpl<ConversationBean> implements IConversationDao {
    public ConversationDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public ConversationBean insert(ConversationBean conversationBean) {
        String sql = "INSERT INTO conversation" +
                " (toUserId,type,lastMsgContentType,lastMsgContent,lastMsgTimestamp,lastMsgPid,unreadCount)" +
                " VALUES" +
                " (%s,%s,%s,%s,%s,%s,%s)";
        sql = String.format(sql, getStringValue(conversationBean.getToUserId()), conversationBean.getType()
                , conversationBean.getLastMsgContentType(), getStringValue(conversationBean.getLastMsgContent())
                , conversationBean.getLastMsgTimestamp(), conversationBean.getLastMsgPid(), conversationBean.getUnreadCount());
        getSQLiteDatabase().execSQL(sql);
        Cursor cursor = getSQLiteDatabase().rawQuery("SELECT last_insert_rowid() FROM message", new String[]{});
        try {
            if (cursor.moveToFirst()) {
                int id = cursor.getInt(0);
                conversationBean.setId(id);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return conversationBean;
    }

    @Override
    public void update(ConversationBean conversationBean) {
        String sql = "UPDATE conversation SET\n" +
                " toUserId=%s,type=%s,lastMsgContentType=%s,lastMsgContent=%s" +
                " ,lastMsgTimestamp=%s,lastMsgPid=%s,unreadCount=%s" +
                " WHERE id=%s";
        sql = String.format(sql, getStringValue(conversationBean.getToUserId()), conversationBean.getType()
                , conversationBean.getLastMsgContentType(), getStringValue(conversationBean.getLastMsgContent())
                , conversationBean.getLastMsgTimestamp(), conversationBean.getLastMsgPid(), conversationBean.getUnreadCount()
                , conversationBean.getId());
        getSQLiteDatabase().execSQL(sql);
    }

    @Override
    public ConversationBean selectByTypeAndToUserId(int type, String toUserId) {
        String sql = "SELECT" +
                " c.id" +
                ",c.toUserId" +
                ",c.type" +
                ",c.lastMsgContentType" +
                ",c.lastMsgContent" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",c.unreadCount" +
                ",f.nickname AS fNickname" +
                ",f.headImgSmall AS fHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " WHERE c.type=%s AND c.toUserId=%s";
        sql = String.format(sql, type, getStringValue(toUserId));
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                ConversationBean conversationBean = new ConversationBean();
                conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
                conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
                conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
                conversationBean.setLastMsgPid(cursor.getInt(cursor.getColumnIndex("lastMsgPid")));
                conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                    // 单聊
                    String remark = cursor.getString(cursor.getColumnIndex("fRemark"));
                    if (!TextUtils.isEmpty(remark)) {
                        conversationBean.setTitle(remark);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("fNickname")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("fHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("fTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("fDoNotDisturb")));
                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    // 群聊
                    String nickname = cursor.getString(cursor.getColumnIndex("gcNickname"));
                    if (!TextUtils.isEmpty(nickname)) {
                        conversationBean.setTitle(nickname);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("gcNicknameDefault")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("gcHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("gcTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("gcDoNotDisturb")));
                }
                return conversationBean;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }

    @Override
    public List<ConversationBean> selectList() {
        String sql = "SELECT" +
                " c.id" +
                ",c.toUserId" +
                ",c.type" +
                ",c.lastMsgContentType" +
                ",c.lastMsgContent" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",c.unreadCount" +
                ",f.nickname AS fNickname" +
                ",f.headImgSmall AS fHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001;";
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                ConversationBean conversationBean = new ConversationBean();
                conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
                conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
                conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
                conversationBean.setLastMsgPid(cursor.getInt(cursor.getColumnIndex("lastMsgPid")));
                conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                    // 单聊
                    String remark = cursor.getString(cursor.getColumnIndex("fRemark"));
                    if (!TextUtils.isEmpty(remark)) {
                        conversationBean.setTitle(remark);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("fNickname")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("fHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("fTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("fDoNotDisturb")));
                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    // 群聊
                    String nickname = cursor.getString(cursor.getColumnIndex("gcNickname"));
                    if (!TextUtils.isEmpty(nickname)) {
                        conversationBean.setTitle(nickname);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("gcNicknameDefault")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("gcHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("gcTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("gcDoNotDisturb")));
                }
                conversationBeanList.add(conversationBean);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return conversationBeanList;
    }

    @Override
    public List<ConversationBean> selectListOrderByLastMsgTimeDesc() {
        String sql = "SELECT" +
                " c.id" +
                ",c.toUserId" +
                ",c.type" +
                ",c.lastMsgContentType" +
                ",c.lastMsgContent" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",c.unreadCount" +
                ",f.nickname AS fNickname" +
                ",f.headImgSmall AS fHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " ORDER BY c.lastMsgTimestamp DESC";
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                ConversationBean conversationBean = new ConversationBean();
                conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
                conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
                conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
                conversationBean.setLastMsgPid(cursor.getInt(cursor.getColumnIndex("lastMsgPid")));
                conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                    // 单聊
                    String remark = cursor.getString(cursor.getColumnIndex("fRemark"));
                    if (!TextUtils.isEmpty(remark)) {
                        conversationBean.setTitle(remark);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("fNickname")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("fHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("fTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("fDoNotDisturb")));
                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    // 群聊
                    String nickname = cursor.getString(cursor.getColumnIndex("gcNickname"));
                    if (!TextUtils.isEmpty(nickname)) {
                        conversationBean.setTitle(nickname);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("gcNicknameDefault")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("gcHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("gcTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("gcDoNotDisturb")));
                }
                conversationBeanList.add(conversationBean);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return conversationBeanList;
    }

    @Override
    public List<ConversationBean> selectListOrderByTopDescAndLastMsgTimeDesc() {
        String sql = "SELECT" +
                " c.id" +
                ",c.toUserId" +
                ",c.type" +
                ",c.lastMsgContentType" +
                ",c.lastMsgContent" +
                ",c.lastMsgTimestamp" +
                ",c.lastMsgPid" +
                ",c.unreadCount" +
                ",f.nickname AS fNickname" +
                ",f.headImgSmall AS fHeadImgSmall" +
                ",f.remark AS fRemark" +
                ",f.top AS fTop" +
                ",f.doNotDisturb AS fDoNotDisturb" +
                ",gc.nickname AS gcNickname" +
                ",gc.headImgSmall AS gcHeadImgSmall" +
                ",gc.nicknameDefault AS gcNicknameDefault" +
                ",gc.top AS gcTop" +
                ",gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " ORDER BY fTop OR gcTop DESC,c.lastMsgTimestamp DESC";
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                ConversationBean conversationBean = new ConversationBean();
                conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
                conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
                conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
                conversationBean.setLastMsgPid(cursor.getInt(cursor.getColumnIndex("lastMsgPid")));
                conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                    // 单聊
                    String remark = cursor.getString(cursor.getColumnIndex("fRemark"));
                    if (!TextUtils.isEmpty(remark)) {
                        conversationBean.setTitle(remark);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("fNickname")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("fHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("fTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("fDoNotDisturb")));
                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    // 群聊
                    String nickname = cursor.getString(cursor.getColumnIndex("gcNickname"));
                    if (!TextUtils.isEmpty(nickname)) {
                        conversationBean.setTitle(nickname);
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("gcNicknameDefault")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("gcHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("gcTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("gcDoNotDisturb")));
                }
                conversationBeanList.add(conversationBean);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return conversationBeanList;
    }

    @Override
    public int getTotalUnreadCount() {
//        String sql = "SELECT SUM(unreadCount) AS totalUnreadCount FROM conversation";
        String sql = "SELECT SUM(ABS(unreadCount)) AS totalUnreadCount" +
                " FROM conversation AS c" +
                " WHERE" +
                " (SELECT doNotDisturb FROM friend AS f WHERE c.type=2001 AND f.id=c.toUserId)=0" +
                " OR" +
                " (SELECT doNotDisturb FROM group_chat AS gc WHERE c.type=3001 AND gc.id=c.toUserId)=0";
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                return cursor.getInt(cursor.getColumnIndex("totalUnreadCount"));
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return 0;
    }

    @Override
    public int resetUnreadCount(int id) {
        String sql = "UPDATE conversation SET unreadCount=0 WHERE id=%s";
        sql = String.format(sql, id);
        getSQLiteDatabase().execSQL(sql);
        return 1;
    }

    @Override
    public int deleteById(int id) {
        String sql = "DELETE FROM conversation WHERE id=%s";
        sql = String.format(sql, id);
        getSQLiteDatabase().execSQL(sql);
        return 1;
    }

    @Override
    public int setUnreadCount(int unreadCount, int id) {
        String sql = "UPDATE conversation SET unreadCount=%s WHERE id=%s";
        sql = String.format(sql, unreadCount, id);
        getSQLiteDatabase().execSQL(sql);
        return 1;
    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(id) FROM conversation WHERE id=%s";
        sql = String.format(sql, id);
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                int count = cursor.getInt(cursor.getColumnIndex("COUNT(id)"));
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
