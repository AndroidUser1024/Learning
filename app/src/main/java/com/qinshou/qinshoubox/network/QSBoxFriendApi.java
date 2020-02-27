package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.okhttphelper.enums.LogLevel;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;

import java.util.List;

/**
 * Description:类描述
 * Author: MrQinshou
 * Date: 19-11-25 下午10:20
 */

@Api(value = IUrlConstant.DEFAULT_HOST + "/friend", logLevel = LogLevel.BODY)
public interface QSBoxFriendApi {
    @Json
    @Post("/add")
    Call<QinshouResultBean<Object>> add(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId
            , @Field(name = "remark") String remark
            , @Field(name = "additionalMsg") String additionalMsg
            , @Field(name = "source") int source);

    @Json
    @Post("/agreeAdd")
    Call<QinshouResultBean<Object>> agreeAdd(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId
            , @Field(name = "remark") String remark);

    @Json
    @Post("/getHistory")
    Call<QinshouResultBean<List<FriendHistoryBean>>> getHistory(@Field(name = "userId") String userId
            , @Field(name = "page") int page
            , @Field(name = "pageSize") int pageSize);

    @Json
    @Post("/getList")
    Call<QinshouResultBean<List<FriendBean>>> getList(@Field(name = "userId") String userId);

    @Json
    @Post("/delete")
    Call<QinshouResultBean<Object>> delete(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId);

    @Json
    @Post("/setInfo")
    Call<QinshouResultBean<Object>> setInfo(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId
            , @Field(name = "remark") String remark
            , @Field(name = "top") Integer top
            , @Field(name = "doNotDisturb") Integer doNotDisturb
            , @Field(name = "blackList") Integer blackList);

    @Json
    @Post("/getInfo")
    Call<QinshouResultBean<FriendBean>> getInfo(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId);
}
