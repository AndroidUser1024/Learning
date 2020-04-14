package com.qinshou.qinshoubox.network;

import com.jeejio.networkmodule.annotation.Api;
import com.jeejio.networkmodule.annotation.Get;
import com.jeejio.networkmodule.call.AbsCall;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.login.bean.PoemBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/10 11:05
 * Description:QSBox 诗词模块的 api
 */

@Api(IUrlConstant.DEFAULT_HOST + "/poem")
public interface QSBoxPoemApi {
    @Get("/getRandomOne")
    AbsCall<QinshouResultBean<PoemBean>> getRandomOne();
}
