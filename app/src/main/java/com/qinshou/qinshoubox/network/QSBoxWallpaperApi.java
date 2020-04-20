package com.qinshou.qinshoubox.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Get;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 16:49
 * Description:壁纸模块 Api
 */
@Api(IUrlConstant.DEFAULT_HOST + "/wallpaper")
public interface QSBoxWallpaperApi {

    @Get("/getList")
    AbsCall<QinshouResultBean<PageResultBean<WallpaperBean>>> getWallpaperList(@Param("page") int page, @Param("pageSize") int pageSize);
}
