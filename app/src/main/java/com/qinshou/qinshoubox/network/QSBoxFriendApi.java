package com.qinshou.qinshoubox.network;

import com.qinshou.networkmodule.annotation.Api;
import com.qinshou.networkmodule.annotation.Json;
import com.qinshou.networkmodule.annotation.Param;
import com.qinshou.networkmodule.annotation.Post;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.networkmodule.enums.LogLevel;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;

import java.util.List;

/**
 * Description:类描述
 * Author: MrQinshou
 * Date: 19-11-25 下午10:20
 */

@Api(value = IUrlConstant.DEFAULT_HOST + "/friend", logLevel = LogLevel.BASIC)
public interface QSBoxFriendApi {
    @Json
    @Post("/add")
    AbsCall<QinshouResultBean<Object>> add(@Param("fromUserId") String fromUserId
            , @Param("toUserId") String toUserId
            , @Param("remark") String remark
            , @Param("additionalMsg") String additionalMsg
            , @Param("source") int source);

    @Json
    @Post("/agreeAdd")
    AbsCall<QinshouResultBean<Object>> agreeAdd(@Param("fromUserId") String fromUserId
            , @Param("toUserId") String toUserId
            , @Param("remark") String remark);

    @Json
    @Post("/getHistory")
    AbsCall<QinshouResultBean<List<FriendHistoryBean>>> getHistory(@Param("userId") String userId
            , @Param("page") int page
            , @Param("pageSize") int pageSize);

    @Json
    @Post("/getList")
    AbsCall<QinshouResultBean<List<UserDetailBean>>> getList(@Param("userId") String userId);

    @Json
    @Post("/delete")
    AbsCall<QinshouResultBean<Object>> delete(@Param("fromUserId") String fromUserId
            , @Param("toUserId") String toUserId);

    @Json
    @Post("/setInfo")
    AbsCall<QinshouResultBean<Object>> setInfo(@Param("fromUserId") String fromUserId
            , @Param("toUserId") String toUserId
            , @Param("remark") String remark
            , @Param("top") Integer top
            , @Param("doNotDisturb") Integer doNotDisturb
            , @Param("blackList") Integer blackList);

    @Json
    @Post("/getInfo")
    AbsCall<QinshouResultBean<UserDetailBean>> getInfo(@Param("fromUserId") String fromUserId
            , @Param("toUserId") String toUserId);
}
