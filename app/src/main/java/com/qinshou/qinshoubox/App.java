package com.qinshou.qinshoubox;

import com.qinshou.commonmodule.base.BaseApplication;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化数据库
//        DatabaseManager.getInstance().init(this, Constant.DATABASE_NAME, Constant.DATABASE_VERSION, new Class[]{CaseBean.class});
//        //初始化友盟推送
//        PushUtil.init(this, Constant.UMENG_KEY, Constant.UMENG_SECRET);
//        //初始化第三方分享
//        ShareUtil.init(this);
    }
}
