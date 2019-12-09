package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Get;
import com.qinshou.okhttphelper.annotation.Query;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.NewsBean;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/27 19:52
 * Description:新闻模块的接口
 */
@Api(IUrlConstant.DEFAULT_HOST + IUrlConstant.NEWS_API)
public interface QSBoxNewsApi {
    @Get("/getList")
    Call<QinshouResultBean<PageResultBean<NewsBean>>> getList(@Query(name = "page") int page, @Query(name = "pageSize") int pageSize);
}
