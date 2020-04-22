package com.qinshou.networkmodule.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Get;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.bean.NewsBean;
import com.qinshou.networkmodule.bean.PageResultBean;
import com.qinshou.networkmodule.bean.QinshouResultBean;
import com.qinshou.networkmodule.call.AbsCall;

@Api("http://www.mrqinshou.com:7000/news")
public interface QSBoxNewsApi {
    @Get("/getList")
    AbsCall<QinshouResultBean<PageResultBean<NewsBean>>> getList(@Param("page") int page, @Param("pageSize") int pageSize);
}