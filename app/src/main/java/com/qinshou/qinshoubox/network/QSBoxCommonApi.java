package com.qinshou.qinshoubox.network;

import com.jeejio.networkmodule.annotation.Api;
import com.jeejio.networkmodule.annotation.Download;
import com.jeejio.networkmodule.annotation.DownloadCallback;
import com.jeejio.networkmodule.annotation.FileTarget;
import com.jeejio.networkmodule.annotation.Get;
import com.jeejio.networkmodule.annotation.Header;
import com.jeejio.networkmodule.annotation.Multipart;
import com.jeejio.networkmodule.annotation.Param;
import com.jeejio.networkmodule.annotation.Post;
import com.jeejio.networkmodule.annotation.Range;
import com.jeejio.networkmodule.annotation.Url;
import com.jeejio.networkmodule.call.AbsCall;
import com.jeejio.networkmodule.callback.IDownloadCallback;
import com.jeejio.networkmodule.enums.LogLevel;
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
@Api(value = IUrlConstant.DEFAULT_HOST + "/common", logLevel = LogLevel.BASIC)
public interface QSBoxCommonApi {
    @Multipart
    @Post(value = "/uploadVoice")
    AbsCall<QinshouResultBean<UploadVoiceResultBean>> uploadVoice(@Param("userId") String userId
            , @Param("time") long time
            , @Param("voice") File voice);

    @Multipart
    @Post(value = "/uploadImg")
    AbsCall<QinshouResultBean<UploadImgResultBean>> uploadImg(@Param("userId") String userId
            , @Param("img") File img);

    @Download
    @Get()
    AbsCall download(@Url String url, @FileTarget File file);

    @Download
    @Get()
    AbsCall download(@Url String url, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);

    /**
     * 断点续传
     * RANGE:bytes=start-
     */
    @Download
    @Get()
    AbsCall download(@Url String url, @Range long start, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);
}
