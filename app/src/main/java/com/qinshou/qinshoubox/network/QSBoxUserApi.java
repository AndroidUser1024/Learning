package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.UserBean;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/16 13:27
 * Description:类描述
 */
@Api(IUrlConstant.DEFAULT_HOST + "/user")
public interface QSBoxUserApi {
    String DEFAULT_HOST = IUrlConstant.DEFAULT_HOST;

    @Post("/register")
    Call<QinshouResultBean<UserBean>> register(@Field(name = "username") String username
            , @Field(name = "password") String password);

    @Post("/login")
    Call<QinshouResultBean<UserBean>> login(@Field(name = "username") String username
            , @Field(name = "password") String password);

    @Post("/logout")
    Call<QinshouResultBean<UserBean>> logout(@Field(name = "username") String username);

    @Post("/setInfo")
    Call<QinshouResultBean<UserBean>> setInfo(@Field(name = "userId") int userId
            , @Field(name = "nickname") String nickname);

    @Multipart
    @Post("/setHeadImg")
    Call<QinshouResultBean<UserBean>> setHeadImg(@Field(name = "userId") int userId
            , @Field(name = "headImg") File headImg);

    @Post("/getUserDetail")
    Call<QinshouResultBean<UserBean>> getUserDetail(@Field(name = "userId") int userId
            , @Field(name = "keyword") String keyword);
}
