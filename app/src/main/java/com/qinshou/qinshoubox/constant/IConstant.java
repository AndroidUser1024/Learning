package com.qinshou.qinshoubox.constant;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/14
 */
public interface IConstant {
    /**
     * 分页加载数据的起始页
     */
    int PAGE_START = 0;
    /**
     * 分页加载数据每页的条数
     */
    int PAGE_SIZE = 20;
    /**
     * 最后一次登录成功的用户名存储在 SharedPreferences 中的 key
     */
    String SP_KEY_LAST_LOGIN_USERNAME = "lastLoginUsername";
    /**
     * 好友申请历史未读数在 SharedPreferences 中的 key
     */
    String SP_KEY_FRIEND_HISTORY_UNREAD_COUNT = "friendHistoryUnreadCount";
    String DATABASE_NAME = "QinshouBox.db";
    int DATABASE_VERSION = 1;
    //天气界面
    String LAST_CHOOSE_CITY = "lastChooseCity";
    //魔塔界面
    String WARRIOR_BEAN_JSON = "warriorBeanJson";
    String FLOOR = "floor";
    //友盟推送
    String UMENG_KEY = "5be28f97f1f5563b0f000070";
    String UMENG_SECRET = "212a6a59153e7caf27b6f32db77fa974";

}
