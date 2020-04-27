package com.qinshou.qinshoubox.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Download;
import com.qinshou.networkmodule.annotation.DownloadCallback;
import com.qinshou.networkmodule.annotation.FileTarget;
import com.qinshou.networkmodule.annotation.Get;
import com.qinshou.networkmodule.annotation.Multipart;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.annotation.Post;
import com.qinshou.networkmodule.annotation.Range;
import com.qinshou.networkmodule.annotation.Url;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.networkmodule.callback.IDownloadCallback;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.conversation.bean.UploadImgResultBean;
import com.qinshou.qinshoubox.conversation.bean.UploadVoiceResultBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/30 16:01
 * Description:通用模块 api
 */
@Api(value = IUrlConstant.DEFAULT_HOST + "/common")
public interface QSBoxCommonApi {
    @Multipart
    @Post("/uploadVoice")
    AbsCall<QinshouResultBean<UploadVoiceResultBean>> uploadVoice(@Param("userId") String userId
            , @Param("time") long time
            , @Param("voice") File voice);

    @Multipart
    @Post("/uploadImg")
    AbsCall<QinshouResultBean<UploadImgResultBean>> uploadImg(@Param("userId") String userId
            , @Param("img") File img);

    @Download
    @Get()
    AbsCall<File> download(@Url String url, @FileTarget File file);

    @Download
    @Get()
    AbsCall<File> download(@Url String url, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);

    /**
     * 断点续传
     * RANGE:bytes=start-
     */
    @Download
    @Get()
    AbsCall<File> download(@Url String url, @Range long start, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);
}
