package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.ISetGroupChatNameContract;
import com.qinshou.qinshoubox.conversation.view.fragment.SetGroupChatNicknameFragment;
import com.qinshou.qinshoubox.im.IMClient;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetGroupChatNicknameFragment} 的 M 层
 */
public class SetGroupChatNicknameModel implements ISetGroupChatNameContract.IModel {
    @Override
    public void setGroupChatNickname(String groupChatId, String nickname, Callback<Object> callback) {
        IMClient.SINGLETON.getGroupChatManager().setNickname(groupChatId, nickname, callback);
    }
}