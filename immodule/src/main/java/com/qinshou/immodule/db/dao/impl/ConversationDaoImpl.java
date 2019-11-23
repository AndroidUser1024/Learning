package com.qinshou.immodule.db.dao.impl;

import android.text.TextUtils;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.RawRowMapperImpl;
import com.j256.ormlite.table.TableInfo;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.immodule.db.dao.IConversationDao;
import com.qinshou.immodule.enums.MessageType;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/5 17:34
 * Description:ConversationDao 的实现类
 */
public class ConversationDaoImpl implements IConversationDao {
    private Dao<ConversationBean, Integer> mDao;

    public ConversationDaoImpl() {
        try {
            mDao = DBHelper.getInstance().getDao(ConversationBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int insertOrUpdate(ConversationBean conversationBean) {
        try {
            return mDao.createOrUpdate(conversationBean).getNumLinesChanged();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ConversationBean getByToUserId(int toUserId) {
        try {
            return mDao.queryBuilder()
                    .where()
                    .eq("toUserId", toUserId)
                    .queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ConversationBean> getList() {
        List<ConversationBean> conversationBeanList = new ArrayList<>();
        try {
            GenericRawResults<String[]> genericRawResults = mDao.queryRaw("SELECT" +
                    " conversation.id," +
                    " conversation.toUserId," +
                    " conversation.type," +
                    " conversation.lastMsgContent," +
                    " conversation.lastMsgContentType," +
                    " conversation.lastMsgTimestamp ," +
                    " conversation.unreadCount," +
                    " user.headImgSmall," +
                    " user.nickname," +
                    " user.remark," +
                    " group_chat.headImgSmall," +
                    " group_chat.nickname," +
                    " group_chat.nicknameDefault" +
                    " FROM" +
                    " conversation" +
                    " LEFT OUTER JOIN" +
                    " user" +
                    " ON conversation.type=2001 AND conversation.toUserId=user.id" +
                    " LEFT OUTER JOIN" +
                    " group_chat" +
                    " ON conversation.type=3001 AND conversation.toUserId=group_chat.id");
            String[] columnNames = genericRawResults.getColumnNames();
            for (String columnName : columnNames) {
                Log.i("daolema", "columnName--->" + columnName);
            }
            List<String[]> results = genericRawResults.getResults();

            for (int i = 0; i < results.size(); i++) {
                String[] strings = results.get(i);
                ConversationBean conversationBean = new ConversationBean();
                conversationBean.setId(Integer.valueOf(strings[0]));
                conversationBean.setToUserId(Integer.valueOf(strings[1]));
                conversationBean.setType(Integer.valueOf(strings[2]));
                conversationBean.setLastMsgContent(strings[3]);
                conversationBean.setLastMsgContentType(Integer.valueOf(strings[4]));
                conversationBean.setLastMsgTimestamp(Long.valueOf(strings[5]));
                conversationBean.setUnreadCount(Integer.valueOf(strings[6]));
                if (conversationBean.getType() == MessageType.CHAT.getValue()) {
                    // 单聊头像
                    conversationBean.setHeadImgSmall(strings[7]);
                    // 备注为空,则会话标题设置为用户昵称,否则设置为备注
                    conversationBean.setTitle(TextUtils.isEmpty(strings[9])
                            ? strings[8]
                            : strings[9]);
                } else if (conversationBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                    // 群聊头像
                    conversationBean.setHeadImgSmall(strings[10]);
                    // 群昵称为空,则会话标题设置为群默认昵称,否则设置为昵称
                    conversationBean.setTitle(TextUtils.isEmpty(strings[11])
                            ? strings[12]
                            : strings[11]);
                }
                conversationBeanList.add(conversationBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conversationBeanList;
    }
}
