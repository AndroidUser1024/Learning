package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Download;
import com.qinshou.okhttphelper.annotation.DownloadCallback;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.FileTarget;
import com.qinshou.okhttphelper.annotation.Get;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.annotation.Url;
import com.qinshou.okhttphelper.call.ICall;
import com.qinshou.okhttphelper.callback.AbsDownloadCallback;
import com.qinshou.okhttphelper.enums.LogLevel;
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
    ICall<QinshouResultBean<UploadVoiceResultBean>> uploadVoice(@Field(name = "userId") String userId
            , @Field(name = "time") long time
            , @Field(name = "voice") File voice);

    @Multipart
    @Post(value = "/uploadImg")
    ICall<QinshouResultBean<UploadImgResultBean>> uploadImg(@Field(name = "userId") String userId
            , @Field(name = "img") File img);

    @Download
    @Get()
    ICall download(@Url String url, @FileTarget File file);

    @Download
    @Get()
    ICall download(@Url String url, @FileTarget File file, @DownloadCallback AbsDownloadCallback downloadCallback);
}
