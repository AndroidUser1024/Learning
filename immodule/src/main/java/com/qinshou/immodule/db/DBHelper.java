package com.qinshou.immodule.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.ConversationMessageRelBean;
import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.bean.MessageBean;

import java.sql.SQLException;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/21 19:02
 * Description:数据库帮助者类
 */
// extends OrmLiteSqliteOpenHelper
public class DBHelper {
    // 定义数据库的版本号，当数据库需要升级时进行更改
    public static final int DATABASE_VERSION = 1;
    private static DBHelper instance;

//    private DBHelper(Context context, String databaseName) {
//        super(context, databaseName, null, DATABASE_VERSION);
//    }

//    @Override
//    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
//        try {
//            TableUtils.createTable(connectionSource, FriendBean.class);
//            TableUtils.createTable(connectionSource, GroupChatBean.class);
//            TableUtils.createTable(connectionSource, ConversationBean.class);
//            TableUtils.createTable(connectionSource, ConversationMessageRelBean.class);
//            TableUtils.createTable(connectionSource, MessageBean.class);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
//
//    }

//    public static void init(Context context, String databaseName) {
//        instance = new DBHelper(context, databaseName + ".db");
//    }

    public static DBHelper getInstance() {
        if (instance == null) {
            throw new NullPointerException("instance is null,please call init");
        }
        return instance;
    }
}
