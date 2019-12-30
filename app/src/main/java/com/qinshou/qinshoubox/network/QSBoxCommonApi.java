package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.conversation.bean.UploadResultBean;
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
    @Post(value = "/uploadVoice")
    Call<QinshouResultBean<UploadVoiceResultBean>> uploadVoice(@Field(name = "userId") String userId
            , @Field(name = "time") long time
            , @Field(name = "voice") File voice);

    @Multipart
    @Post(value = "/uploadImg")
    Call<QinshouResultBean<UploadResultBean>> uploadImg(@Field(name = "userId") String userId
            , @Field(name = "img") File img);
}
