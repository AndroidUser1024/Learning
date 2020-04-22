package com.qinshou.qinshoubox.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Json;
import com.qinshou.networkmodule.annotation.Multipart;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.annotation.Post;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.login.bean.UserBean;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/16 13:27
 * Description:类描述
 */
@Api(value = IUrlConstant.DEFAULT_HOST + "/user")
public interface QSBoxUserApi {
    @Json
    @Post("/register")
    AbsCall<QinshouResultBean<UserBean>> register(@Param("username") String username
            , @Param("password") String password);

    @Json
    @Post("/login")
    AbsCall<QinshouResultBean<UserBean>> login(@Param("username") String username
            , @Param("password") String password);

    @Json
    @Post("/logout")
    AbsCall<QinshouResultBean<UserBean>> logout(@Param("username") String username);

    @Json
    @Post("/setInfo")
    AbsCall<QinshouResultBean<UserBean>> setInfo(@Param("id") String userId
            , @Param("nickname") String nickname);

    @Multipart
    @Post("/setHeadImg")
    AbsCall<QinshouResultBean<UserBean>> setHeadImg(@Param("id") String userId
            , @Param("headImg") File headImg);

    @Json
    @Post("/getUserDetail")
    AbsCall<QinshouResultBean<UserDetailBean>> getUserDetail(@Param("keyword") String keyword
            , @Param("fromUserId") String fromUserId);

    @Json
    @Post("/getUserDetail")
    AbsCall<QinshouResultBean<UserDetailBean>> getUserDetail(@Param("keyword") String keyword
            , @Param("fromUserId") String fromUserId
            , @Param("groupChatId") String groupChatId);
}
