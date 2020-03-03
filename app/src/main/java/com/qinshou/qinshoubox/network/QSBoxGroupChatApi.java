package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.ICall;
import com.qinshou.okhttphelper.enums.LogLevel;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.login.bean.UserBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 13:35
 * Description:QSBox 群聊模块的接口
 */
@Api(value = IUrlConstant.DEFAULT_HOST + "/groupChat", logLevel = LogLevel.BODY)
public interface QSBoxGroupChatApi {

    @Json
    @Post("/create")
    ICall<QinshouResultBean<GroupChatBean>> create(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserIdList") List<String> toUserIdList
            , @Field(name = "nickname") String nickname
            , @Field(name = "headImg") String headImg);

    @Json
    @Post("/getMyGroupChatList")
    ICall<QinshouResultBean<List<GroupChatBean>>> getMyGroupChatList(@Field(name = "fromUserId") String fromUserId);

    @Json
    @Post("/getDetail")
    ICall<QinshouResultBean<GroupChatDetailBean>> getDetail(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "fromUserId") String fromUserId);

    @Json
    @Post("/getMemberList")
    ICall<QinshouResultBean<List<UserDetailBean>>> getMemberList(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "fromUserId") String fromUserId);

    @Json
    @Post("/addMember")
    ICall<QinshouResultBean<Object>> addMember(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserIdList") List<String> toUserIdList);

    @Json
    @Post("/deleteMember")
    ICall<QinshouResultBean<Object>> deleteMember(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserIdList") List<String> toUserIdList);

    @Json
    @Post("/setNickname")
    ICall<QinshouResultBean<Object>> setNickname(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "userId") String userId
            , @Field(name = "nickname") String nickname);

    @Json
    @Post("/setInfo")
    ICall<QinshouResultBean<Object>> setInfo(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "userId") String userId
            , @Field(name = "nicknameInGroupChat") String nicknameInGroupChat
            , @Field(name = "top") Integer top
            , @Field(name = "doNotDisturb") Integer doNotDisturb
            , @Field(name = "showGroupChatMemberNickname") Integer showGroupChatMemberNickname);

    @Json
    @Post("/exit")
    ICall<QinshouResultBean<Object>> exit(@Field(name = "groupChatId") String groupChatId
            , @Field(name = "userId") String userId);
}
