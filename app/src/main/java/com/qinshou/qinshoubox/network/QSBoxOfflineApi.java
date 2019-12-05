package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 13:35
 * Description:QSBox 离线数据模块的接口
 */
@Api(IUrlConstant.DEFAULT_HOST + "/offline")
public interface QSBoxOfflineApi {

    @Json
    @Post("/getOfflineMessageList")
    Call<QinshouResultBean<List<MessageBean>>> getOfflineMessageList(@Field(name = "userId") int userId);

    @Json
    @Post("/deleteOfflineMessageList")
    Call<QinshouResultBean<Object>> deleteOfflineMessageList(@Field(name = "userId") int userId);
}
