package com.qinshou.qinshoubox.network;

import com.jeejio.networkmodule.annotation.Api;
import com.jeejio.networkmodule.annotation.Json;
import com.jeejio.networkmodule.annotation.Param;
import com.jeejio.networkmodule.annotation.Post;
import com.jeejio.networkmodule.call.AbsCall;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;

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
    AbsCall<QinshouResultBean<List<MessageBean>>> getOfflineMessageList(@Param("userId") String userId);

    @Json
    @Post("/deleteOfflineMessageList")
    AbsCall<QinshouResultBean<Object>> deleteOfflineMessageList(@Param("userId") String userId);
}
