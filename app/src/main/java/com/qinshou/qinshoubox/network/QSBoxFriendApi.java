package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.UserBean;

import java.util.List;

/**
 * Description:类描述
 * Author: MrQinshou
 * Date: 19-11-25 下午10:20
 */

@Api(IUrlConstant.DEFAULT_HOST + "/friend")
public interface QSBoxFriendApi {

    @Post("/add")
    Call<QinshouResultBean<Object>> add(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "remark") String remark
            , @Field(name = "additionalMsg") String additionalMsg
            , @Field(name = "source") int source);

    @Post("/agreeAdd")
    Call<QinshouResultBean<Object>> agreeAdd(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "remark") String remark);

    @Post("/getHistory")
    Call<QinshouResultBean<List<FriendHistoryBean>>> getHistory(@Field(name = "page") int page
            , @Field(name = "pageSize") int pageSize
            , @Field(name = "toUserId") int toUserId);

    @Post("/getList")
    Call<QinshouResultBean<List<FriendBean>>> getList(@Field(name = "fromUserId") int fromUserId);

    @Json
    @Post("/delete")
    Call<QinshouResultBean<Object>> delete(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId);

    @Json
    @Post("/setRemark")
    Call<QinshouResultBean<Object>> setRemark(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "remark") String remark);

    @Json
    @Post("/setTop")
    Call<QinshouResultBean<FriendBean>> setTop(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "top") int top);

    @Json
    @Post("/setDoNotDisturb")
    Call<QinshouResultBean<FriendBean>> setDoNotDisturb(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "doNotDisturb") int doNotDisturb);

    @Json
    @Post("/setBlackList")
    Call<QinshouResultBean<FriendBean>> setBlackList(@Field(name = "fromUserId") int fromUserId
            , @Field(name = "toUserId") int toUserId
            , @Field(name = "blackList") int blackList);
}
