package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.UserBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 13:35
 * Description:QSBox 群聊模块的接口
 */
@Api(IUrlConstant.DEFAULT_HOST + "/groupChat")
public interface QSBoxGroupChatApi {

    @Json
    @Post("/create")
    Call<QinshouResultBean<GroupChatBean>> create(@Field(name = "ownerId") int ownerId
            , @Field(name = "memberIdList") List<Integer> memberIdList
            , @Field(name = "nickname") String nickname
            , @Field(name = "headImg") String headImg);

    @Json
    @Post("/getMyGroupChatList")
    Call<QinshouResultBean<List<GroupChatBean>>> getMyGroupChatList(@Field(name = "userId") int userId);

    @Json
    @Post("/getGroupChat")
    Call<QinshouResultBean<GroupChatBean>> getGroupChat(@Field(name = "groupChatId") int groupChatId
            , @Field(name = "userId") int userId);

    @Json
    @Post("/getMemberList")
    Call<QinshouResultBean<List<UserBean>>> getMemberList(@Field(name = "groupChatId") int groupChatId
            , @Field(name = "userId") int userId);

    @Json
    @Post("/addMember")
    Call<QinshouResultBean<Object>> addMember(@Field(name = "groupChatId") int groupChatId
            , @Field(name = "userId") int userId
            , @Field(name = "toUserIdList") List<Integer> toUserIdList);

    @Json
    @Post("/deleteMember")
    Call<QinshouResultBean<Object>> deleteMember(@Field(name = "groupChatId") int groupChatId
            , @Field(name = "userId") int userId
            , @Field(name = "toUserIdList") List<Integer> toUserIdList);
}
