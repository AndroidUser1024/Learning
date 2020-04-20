package com.qinshou.qinshoubox.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Get;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.NewsBean;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/27 19:52
 * Description:新闻模块的接口
 */
@Api(IUrlConstant.DEFAULT_HOST + "/news")
public interface QSBoxNewsApi {
    @Get("/getList")
    AbsCall<QinshouResultBean<PageResultBean<NewsBean>>> getList(@Param("page") int page, @Param("pageSize") int pageSize);
}
