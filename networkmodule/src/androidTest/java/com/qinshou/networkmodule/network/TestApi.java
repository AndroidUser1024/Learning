package com.qinshou.networkmodule.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Download;
import com.qinshou.networkmodule.annotation.DownloadCallback;
import com.qinshou.networkmodule.annotation.FileTarget;
import com.qinshou.networkmodule.annotation.Get;
import com.qinshou.networkmodule.annotation.Json;
import com.qinshou.networkmodule.annotation.Multipart;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.annotation.Post;
import com.qinshou.networkmodule.annotation.Range;
import com.qinshou.networkmodule.annotation.Url;
import com.qinshou.networkmodule.bean.PageResultBean;
import com.qinshou.networkmodule.bean.QinshouResultBean;
import com.qinshou.networkmodule.bean.WallpaperBean;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.networkmodule.callback.IDownloadCallback;

import java.io.File;

@Api("http://www.mrqinshou.com:7000/")
public interface TestApi {
    @Get("test")
    AbsCall<Object> get(@Param("username") String username, @Param("password") String password);

    @Download
    @Get()
    AbsCall<File> download(@Url String url, @FileTarget File file);

    @Download
    @Get()
    AbsCall<File> download(@Url String url, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);

    @Download
    @Get()
    AbsCall<File> download(@Url String url, @Range long start, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);

    @Post("test")
    AbsCall<Object> post(@Param("username") String username, @Param("password") String password);

    @Json
    @Post("test")
    AbsCall<Object> postJson(@Param("username") String username, @Param("password") String password);

    @Multipart
    @Post("/test")
    AbsCall<Object> postUpload(@Param("img") File img);

    @Get("/wallpaper/getList")
    AbsCall<QinshouResultBean<PageResultBean<WallpaperBean>>> getWallpaperList(@Param("page") int page, @Param("pageSize") int pageSize);
}