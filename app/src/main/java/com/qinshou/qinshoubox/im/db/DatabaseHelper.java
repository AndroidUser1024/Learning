package com.qinshou.qinshoubox.im.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.qinshou.qinshoubox.im.db.dao.IBaseDao;
import com.qinshou.qinshoubox.im.db.dao.IConversationDao;
import com.qinshou.qinshoubox.im.db.dao.IConversationMessageRelDao;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatDao;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatMemberDao;
import com.qinshou.qinshoubox.im.db.dao.IMessageDao;
import com.qinshou.qinshoubox.im.db.dao.impl.ConversationDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.ConversationMessageRelDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.FriendDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.GroupChatDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.GroupChatMemberDaoImpl;
import com.qinshou.qinshoubox.im.db.dao.impl.MessageDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/05 10:43
 * Description:数据库操作类
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private final String CREATE_FRIEND_TABLE_SQL = "CREATE TABLE IF NOT EXISTS friend(" +
            " id TEXT PRIMARY KEY" +
            " ,nickname TEXT" +
            " ,headImg TEXT" +
            " ,headImgSmall TEXT" +
            " ,signature TEXT" +
            " ,remark TEXT" +
            " ,top INTEGER" +
            " ,doNotDisturb INTEGER" +
            " ,blackList INTEGER" +
            " )";
    private final String CREATE_GROUP_CHAT_TABLE_SQL = "CREATE TABLE IF NOT EXISTS group_chat(" +
            " id TEXT PRIMARY KEY" +
            " ,ownerId TEXT" +
            " ,nickname TEXT" +
            " ,headImg TEXT" +
            " ,headImgSmall TEXT" +
            " ,nicknameDefault TEXT" +
            " ,nicknameInGroupChat TEXT" +
            " ,top INTEGER" +
            " ,doNotDisturb INTEGER" +
            " ,showGroupChatMemberNickname INTEGER" +
            " )";
    private final String CREATE_MESSAGE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS message(" +
            " pid INTEGER PRIMARY KEY AUTOINCREMENT" +
            " ,id TEXT" +
            " ,fromUserId TEXT" +
            " ,toUserId TEXT" +
            " ,type INTEGER" +
            " ,contentType INTEGER" +
            " ,content TEXT" +
            " ,sendTimestamp INTEGER" +
            " ,receiveTimestamp INTEGER" +
            " ,status INTEGER" +
            " ,extend TEXT" +
            " )";
    private final String CREATE_CONVERSATION_TABLE_SQL = "CREATE TABLE IF NOT EXISTS conversation(" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT" +
            " ,toUserId TEXT" +
            " ,type INTEGER" +
            " ,lastMsgContentType INTEGER" +
            " ,lastMsgContent TEXT" +
            " ,lastMsgTimestamp INTEGER" +
            " ,lastMsgPid INTEGER" +
            " ,unreadCount INTEGER" +
            " )";
    private final String CREATE_CONVERSATION_MESSAGE_REL_TABLE_SQL = "CREATE TABLE IF NOT EXISTS conversation_message_rel(" +
            " id INTEGER PRIMARY KEY AUTOINCREMENT" +
            " ,conversationId INTEGER" +
            " ,messagePid INTEGER" +
            " )";
    private final String CREATE_GROUP_CHAT_MEMBER_TABLE_SQL = "CREATE TABLE IF NOT EXISTS group_chat_member(" +
            " group_chat_id TEXT" +
            ",userId TEXT" +
            ",nickname TEXT" +
            ",headImg TEXT" +
            ",headImgSmall TEXT" +
            ",remark TEXT" +
            ",nicknameInGroupChat TEXT" +
            " )";

    private Map<Class<? extends IBaseDao>, IBaseDao> mDaoMap = new HashMap<>();

    public DatabaseHelper(Context context, String name) {
        this(context, name, null, DB_VERSION);
    }

    /**
     * @param context 上下文
     * @param name    数据库名称
     * @param factory 游标工厂,一般为null
     * @param version 数据库版本
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // 获取数据库可读可写的操作对象
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        mDaoMap.put(IFriendDao.class, new FriendDaoImpl(sqLiteDatabase));
        mDaoMap.put(IGroupChatDao.class, new GroupChatDaoImpl(sqLiteDatabase));
        mDaoMap.put(IMessageDao.class, new MessageDaoImpl(sqLiteDatabase));
        mDaoMap.put(IConversationDao.class, new ConversationDaoImpl(sqLiteDatabase));
        mDaoMap.put(IConversationMessageRelDao.class, new ConversationMessageRelDaoImpl(sqLiteDatabase));
        mDaoMap.put(IGroupChatMemberDao.class, new GroupChatMemberDaoImpl(sqLiteDatabase));
    }

    /**
     * 初始化表,第一次创建表时调用
     *
     * @param db 数据库的操作类的对象
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建 friend 表
        db.execSQL(CREATE_FRIEND_TABLE_SQL);
        // 创建 group_chat 表
        db.execSQL(CREATE_GROUP_CHAT_TABLE_SQL);
        // 创建 message 表
        db.execSQL(CREATE_MESSAGE_TABLE_SQL);
        // 创建 conversation 表
        db.execSQL(CREATE_CONVERSATION_TABLE_SQL);
        // 创建 conversation_message_rel 表
        db.execSQL(CREATE_CONVERSATION_MESSAGE_REL_TABLE_SQL);
        // 创建 group_chat_member 表
        db.execSQL(CREATE_GROUP_CHAT_MEMBER_TABLE_SQL);
    }

    /**
     * 更新数据库,如果数据库的版本号发生变化,执行此方法
     *
     * @param db         数据库的操作类的对象
     * @param oldVersion 旧版本
     * @param newVersion 新版本
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public <T extends IBaseDao> T getDao(Class<T> tClass) {
        return (T) mDaoMap.get(tClass);
    }
}