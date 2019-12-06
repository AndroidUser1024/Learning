package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.login.bean.UserBean;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/16 13:27
 * Description:类描述
 */
@Api(IUrlConstant.DEFAULT_HOST + "/user")
public interface QSBoxUserApi {
    @Json
    @Post("/register")
    Call<QinshouResultBean<UserBean>> register(@Field(name = "username") String username
            , @Field(name = "password") String password);

    @Json
    @Post("/login")
    Call<QinshouResultBean<UserBean>> login(@Field(name = "username") String username
            , @Field(name = "password") String password);

    @Json
    @Post("/logout")
    Call<QinshouResultBean<UserBean>> logout(@Field(name = "username") String username);

    @Json
    @Post("/setRemark")
    Call<QinshouResultBean<UserBean>> setInfo(@Field(name = "id") String userId
            , @Field(name = "nickname") String nickname);

    @Multipart
    @Post("/setHeadImg")
    Call<QinshouResultBean<UserBean>> setHeadImg(@Field(name = "id") String userId
            , @Field(name = "headImg") File headImg);

    @Json
    @Post("/getUserDetail")
    Call<QinshouResultBean<UserDetailBean>> getUserDetail(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "keyword") String keyword);
}
