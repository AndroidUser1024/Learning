package com.qinshou.qinshoubox.conversation.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.contract.ISetGroupChatNicknameContract;
import com.qinshou.qinshoubox.conversation.view.fragment.SetGroupChatNicknameFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetGroupChatNicknameFragment} 的 M 层
 */
public class SetGroupChatNicknameModel implements ISetGroupChatNicknameContract.IModel {
    @Override
    public void setGroupChatNickname(String groupChatId, String nickname, QSCallback<Object> qsCallback) {
        IMClient.SINGLETON.getGroupChatManager().setNickname(groupChatId, nickname, qsCallback);
    }
}