package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Get;
import com.qinshou.okhttphelper.annotation.Query;
import com.qinshou.okhttphelper.call.AbsCall;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 16:49
 * Description:类描述
 */
@Api(IUrlConstant.DEFAULT_HOST + "/wallpaper")
public interface QSBoxWallpaperApi {

    @Get("/getList")
    AbsCall<QinshouResultBean<PageResultBean<WallpaperBean>>> getWallpaperList(@Query(name = "page") int page, @Query(name = "pageSize") int pageSize);
}
