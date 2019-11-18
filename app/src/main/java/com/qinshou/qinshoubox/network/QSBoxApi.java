package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.DefaultDomain;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.me.bean.UserBean;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/16 13:27
 * Description:类描述
 */
@Api
public interface QSBoxApi {
    @DefaultDomain
    String DEFAULT_DOMAIN = "http://172.16.60.231:8080/";

    @Post("user/register/")
    Call<QinshouResultBean<UserBean>> register(@Field(name = "username") String username, @Field(name = "password") String password);

    @Post("user/login/")
    Call<QinshouResultBean<UserBean>> login(@Field(name = "username") String username, @Field(name = "password") String password);

    @Post("user/setInfo/")
    Call<QinshouResultBean<UserBean>> setInfo(@Field(name = "id") long id, @Field(name = "nickname") String nickname);

    @Multipart
    @Post("user/setHeadImg/")
    Call<QinshouResultBean<UserBean>> setHeadImg(@Field(name = "id") long id, @Field(name = "headImg") File headImg);
}