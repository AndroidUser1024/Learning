package com.qinshou.qinshoubox.im.db.dao.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.enums.MessageType;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/5 9:03
 * Description:类描述
 */
public class ConversationDaoImpl extends AbsDaoImpl<ConversationBean> implements IConversationDao {
    public ConversationDaoImpl(SQLiteDatabase SQLiteDatabase) {
        super(SQLiteDatabase);
    }

    @Override
    public ConversationBean insert(ConversationBean conversationBean) {
        ConversationBean select = selectIdAndUnreadCountByTypeAndToUserId(conversationBean.getType(), conversationBean.getToUserId());
        if (select == null) {
            conversationBean.setUnreadCount(0);
            String sql = "INSERT INTO conversation" +
                    " (toUserId,type,lastMsgContent,lastMsgContentType,lastMsgTimestamp,unreadCount)" +
                    " VALUES" +
                    " ('%s','%s','%s','%s','%s','%s')";
            sql = String.format(sql, conversationBean.getToUserId(), conversationBean.getType()
                    , conversationBean.getLastMsgContent(), conversationBean.getLastMsgContentType()
                    , conversationBean.getLastMsgTimestamp(), conversationBean.getUnreadCount());
            getSQLiteDatabase().execSQL(sql);
            Cursor cursor = getSQLiteDatabase().rawQuery("SELECT last_insert_rowid() FROM message", new String[]{});
            try {
                if (cursor.moveToFirst()) {
                    int pid = cursor.getInt(0);
                    conversationBean.setId(pid);
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else {
            conversationBean.setId(select.getId());
            conversationBean.setUnreadCount(select.getUnreadCount() + 1);
            String sql = "UPDATE conversation SET\n" +
                    " toUserId='%s',type='%s',lastMsgContent='%s',lastMsgContentType='%s'" +
                    " ,lastMsgTimestamp='%s',unreadCount='%s'" +
                    " WHERE id='%s'";
            sql = String.format(sql, conversationBean.getToUserId(), conversationBean.getType()
                    , conversationBean.getLastMsgContent(), conversationBean.getLastMsgContentType()
                    , conversationBean.getLastMsgTimestamp(), conversationBean.getUnreadCount()
                    , conversationBean.getId());
            getSQLiteDatabase().execSQL(sql);
        }
        return conversationBean;
    }

    @Override
    public List<ConversationBean> selectList() {
        String sql = "SELECT" +
                " c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType" +
                " ,c.lastMsgTimestamp,c.unreadCount" +
                " ,f.nickname AS fNickname,f.headImgSmall AS fHeadImgSmall" +
                " ,f.remark AS fRemark,f.top AS fTop,f.doNotDisturb AS fDoNotDisturb" +
                " ,gc.nickname AS gcNickname,gc.headImgSmall AS gcHeadImgSmall" +
                " ,gc.nicknameDefault AS gcNicknameDefault,gc.top AS gcTop,gc.doNotDisturb AS gcDoNotDisturb" +
                " FROM conversation AS c" +
                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
                " ORDER BY c.lastMsgTimestamp DESC;";
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            while (cursor.moveToNext()) {
                ConversationBean conversationBean = new ConversationBean();
                conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
                conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
                conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
                conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
                conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
                conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
                conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                    // 单聊
                    if (!cursor.isNull(cursor.getColumnIndex("fRemark"))) {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("fRemark")));
                    } else {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("fNickname")));
                    }
                    conversationBean.setHeadImgSmall(cursor.getString(cursor.getColumnIndex("fHeadImgSmall")));
                    conversationBean.setTop(cursor.getInt(cursor.getColumnIndex("fTop")));
                    conversationBean.setDoNotDisturb(cursor.getInt(cursor.getColumnIndex("fDoNotDisturb")));
                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    if (!cursor.isNull(cursor.getColumnIndex("gcNickname"))) {
                        conversationBean.setTitle(cursor.getString(cursor.getColumnIndex("gcNickname")));
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

    //    @Override
//    public ConversationBean selectIdAndUnreadCountByTypeAndToUserId(String toUserId, int type) {
//        // SELECT
//        // c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType
//        // ,c.lastMsgTimestamp,c.unreadCount
//        // ,f.nickname,f.headImgSmall,f.remark,f.top,f.doNotDisturb
//        // ,gc.nickname,gc.headImgSmall,gc.nicknameDefault,gc.top,gc.doNotDisturb
//        // FROM conversation AS c
//        // LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001
//        // LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001
//        // WHERE c.toUserId=#{toUserId} AND c.type=#{type};
//        String sql = "SELECT" +
//                " c.id,c.toUserId,c.type,c.lastMsgContent,c.lastMsgContentType" +
//                " ,c.lastMsgTimestamp,c.unreadCount" +
//                " ,f.nickname AS fNickname,f.headImgSmall AS fHeadImgSmall" +
//                " ,f.remark AS fRemark,f.top AS fTop,f.doNotDisturb AS fDoNotDisturb" +
//                " ,gc.nickname AS gcNickname,gc.headImgSmall AS gcHeadImgSmall" +
//                " ,gc.nicknameDefault AS gcNicknameDefault,gc.top AS gcTop,gc.doNotDisturb AS gcDoNotDisturb" +
//                " FROM conversation AS c" +
//                " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
//                " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
//                " WHERE c.toUserId='%s' AND c.type='%s'";
//        sql = String.format(sql, toUserId, type);
//        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
//        if (cursor.moveToNext()) {
//            ConversationBean conversationBean = new ConversationBean();
//            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
//            conversationBean.setToUserId(cursor.getString(cursor.getColumnIndex("toUserId")));
//            conversationBean.setType(cursor.getInt(cursor.getColumnIndex("type")));
//            conversationBean.setLastMsgContent(cursor.getString(cursor.getColumnIndex("lastMsgContent")));
//            conversationBean.setLastMsgContentType(cursor.getInt(cursor.getColumnIndex("lastMsgContentType")));
//            conversationBean.setLastMsgTimestamp(cursor.getLong(cursor.getColumnIndex("lastMsgTimestamp")));
//            conversationBean.setUnreadCount(cursor.getInt(cursor.getColumnIndex("unreadCount")));
//            ShowLogUtil.logi("fNickname--->" + cursor.getColumnIndex("fNickname"));
//            ShowLogUtil.logi("fHeadImgSmall--->" + cursor.getColumnIndex("fHeadImgSmall"));
//            ShowLogUtil.logi("fRemark--->" + cursor.getColumnIndex("fRemark"));
//            ShowLogUtil.logi("fTop--->" + cursor.getColumnIndex("fTop"));
//            ShowLogUtil.logi("fDoNotDisturb--->" + cursor.getColumnIndex("fDoNotDisturb"));
//            ShowLogUtil.logi("gcNickname--->" + cursor.getColumnIndex("gcNickname"));
//            ShowLogUtil.logi("gcHeadImgSmall--->" + cursor.getColumnIndex("gcHeadImgSmall"));
//            ShowLogUtil.logi("gcNicknameDefault--->" + cursor.getColumnIndex("gcNicknameDefault"));
//            ShowLogUtil.logi("gcTop--->" + cursor.getColumnIndex("gcTop"));
//            ShowLogUtil.logi("gcDoNotDisturb--->" + cursor.getColumnIndex("gcDoNotDisturb"));
//            return conversationBean;
////            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
////            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
////            conversationBean.setId(cursor.getInt(cursor.getColumnIndex("id")));
//
//        }
//        cursor.close();
//        return null;
//    }
    @Override
    public ConversationBean selectIdAndUnreadCountByTypeAndToUserId(int type, String toUserId) {
        String sql = "SELECT id,unreadCount FROM conversation WHERE type='%s' AND toUserId='%s'";
        sql = String.format(sql, type, toUserId);
        Cursor cursor = getSQLiteDatabase().rawQuery(sql, new String[]{});
        try {
            if (cursor.moveToNext()) {
                ConversationBean conversationBean = new ConversationBean();
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                int unreadCount = cursor.getInt(cursor.getColumnIndex("unreadCount"));
                conversationBean.setId(id);
                conversationBean.setUnreadCount(unreadCount);
                return conversationBean;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
        return null;
    }
}
