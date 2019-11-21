package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.DefaultDomain;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.me.bean.UserBean;

import java.io.File;
import java.util.List;

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
    Call<QinshouResultBean<UserBean>> register(@Field(name = "username") String username
            , @Field(name = "password") String password);

    @Post("user/login/")
    Call<QinshouResultBean<UserBean>> login(@Field(name = "username") String username
            , @Field(name = "password") String password);

    @Post("user/logout/")
    Call<QinshouResultBean<UserBean>> logout(@Field(name = "username") String username);

    @Post("user/setInfo/")
    Call<QinshouResultBean<UserBean>> setInfo(@Field(name = "userId") int userId
            , @Field(name = "nickname") String nickname);

    @Multipart
    @Post("user/setHeadImg/")
    Call<QinshouResultBean<UserBean>> setHeadImg(@Field(name = "userId") int userId
            , @Field(name = "headImg") File headImg);

    @Post("user/getUserDetail/")
    Call<QinshouResultBean<UserBean>> getUserDetail(@Field(name = "userId") int userId
            , @Field(name = "keyword") String keyword);

    @Post("friend/addFriend/")
    Call<QinshouResultBean<Object>> addFriend(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "remark") String remark
            , @Field(name = "additionalMsg") String additionalMsg
            , @Field(name = "source") int source);

    @Post("friend/agreeAddFriend/")
    Call<QinshouResultBean<UserBean>> agreeAddFriend(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "remark") String remark);

    @Post("friend/getFriendHistory/")
    Call<QinshouResultBean<List<FriendHistoryBean>>> getFriendHistory(@Field(name = "page") int page
            , @Field(name = "pageSize") int pageSize
            , @Field(name = "toUserId") int toUserId);

    @Post("friend/getFriendList/")
    Call<QinshouResultBean<List<UserBean>>> getFriendList(@Field(name = "fromUserId") int fromUserId);
}
