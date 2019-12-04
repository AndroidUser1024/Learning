package com.qinshou.qinshoubox;

import com.qinshou.commonmodule.base.BaseApplication;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.immodule.manager.IMClient;

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
//        DatabaseManager.getInstance().init(this, IConstant.DATABASE_NAME, IConstant.DATABASE_VERSION, new Class[]{CaseBean.class});
//        //初始化友盟推送
//        PushUtil.init(this, IConstant.UMENG_KEY, IConstant.UMENG_SECRET);
//        //初始化第三方分享
//        ShareUtil.init(this);
        // 初始化共享参数帮助者类
        SharedPreferencesHelper.SINGLETON.init(this);
        IMClient.SINGLETON.init(this);
    }
}
