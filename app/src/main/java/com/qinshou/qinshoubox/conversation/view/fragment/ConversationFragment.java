package com.qinshou.qinshoubox.conversation.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.immodule.db.DBHelper;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.presenter.ConversationPresenter;
import com.qinshou.qinshoubox.conversation.view.adapter.RcvConversationAdapter;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:聊天会话列表界面
 */
public class ConversationFragment extends QSFragment<ConversationPresenter> implements IConversationContract.IView {


    private RcvConversationAdapter mRcvConversationAdapter;

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
        RecyclerView rcvConversation = findViewByID(R.id.rcv_conversation);
        rcvConversation.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvConversation.setAdapter(mRcvConversationAdapter = new RcvConversationAdapter(getContext()));
    }


    @Override
    public void setListener() {
    }

    @Override
    public void initData() {
        getPresenter().getConversationList();
    }


    @Override
    public void getConversationListSuccess(List<ConversationBean> conversationBeanList) {
        mRcvConversationAdapter.setDataList(conversationBeanList);
    }

    @Override
    public void getConversationListFailure(Exception e) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(UserBean userBean) {
        getPresenter().getConversationList();
    }
}