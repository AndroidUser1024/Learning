package com.qinshou.qinshoubox.network;

import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.DefaultHost;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 13:35
 * Description:QSBox 离线数据模块的接口
 */
@Api
public interface QSBoxOfflineApi {
    @DefaultHost
    String DEFAULT_HOST = "http://172.16.60.231:8080/offline/";
//    String DEFAULT_HOST = "http://192.168.1.109:8080/offline";

    @Json
    @Post("/getOfflineMessageList")
    Call<QinshouResultBean<List<MessageBean>>> getOfflineMessageList(@Field(name = "toUserId") int toUserId);
}
