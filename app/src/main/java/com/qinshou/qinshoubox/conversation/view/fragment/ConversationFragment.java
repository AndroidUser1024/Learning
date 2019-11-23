package com.qinshou.qinshoubox.conversation.view.fragment;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.presenter.ConversationPresenter;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:聊天会话列表界面
 */
public class ConversationFragment extends QSFragment<ConversationPresenter> implements IConversationContract.IView {

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public void initView() {
    }


    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        getPresenter().getConversationList();
    }

    @Override
    public void getConversationListSuccess() {

    }

    @Override
    public void getConversationListFailure() {

    }
}