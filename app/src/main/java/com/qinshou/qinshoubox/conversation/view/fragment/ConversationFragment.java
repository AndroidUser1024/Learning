package com.qinshou.qinshoubox.conversation.view.fragment;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.enums.MessageType;
import com.qinshou.immodule.listener.IOnMessageListener;
import com.qinshou.immodule.manager.ChatManager;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.presenter.ConversationPresenter;
import com.qinshou.qinshoubox.conversation.view.adapter.RcvConversationAdapter;
import com.qinshou.qinshoubox.util.QSUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:聊天会话列表界面
 */
public class ConversationFragment extends QSFragment<ConversationPresenter> implements IConversationContract.IView {


    private RcvConversationAdapter mRcvConversationAdapter;
    /**
     * 聊天消息监听器
     */
    private IOnMessageListener mOnMessageListener = new IOnMessageListener() {
        @Override
        public void onMessage(MessageBean messageBean) {
            ShowLogUtil.logi("onReceive: messageBean--->" + messageBean);
            int toUserId = 0;
            if (messageBean.getType() == MessageType.CHAT.getValue()) {
                toUserId = messageBean.getFromUserId();
            } else if (messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                toUserId = messageBean.getToUserId();
            }
            ConversationBean conversationBean = ChatManager.SINGLETON.getConversationManager().getByTypeAndToUserId(messageBean.getType(), toUserId);
            List<ConversationBean> conversationBeanList = mRcvConversationAdapter.getDataList();
            boolean contains = false;
            int index = 0;
            for (int i = 0; i < conversationBeanList.size(); i++) {
                if (conversationBeanList.get(i).getId() == conversationBean.getId()) {
                    contains = true;
                    index = i;
                    break;
                }
            }
            if (contains) {
                if (index == 0) {
                    // 如果该会话本来就在第一个,直接修改
                    conversationBeanList.set(index, conversationBean);
                    mRcvConversationAdapter.notifyItemChanged(index);
                } else {
                    // 如果该会话不在第一个,放到第一个
                    conversationBeanList.remove(index);
                    conversationBeanList.add(0, conversationBean);
                    mRcvConversationAdapter.notifyItemMoved(index, 0);
                }
            } else {
                // 原来的会话列表中没有该会话,则添加到第一个
                conversationBeanList.add(0, conversationBean);
                mRcvConversationAdapter.notifyItemChanged(0);
            }
            try {
                if (SystemUtil.isBackground(getContext())) {
                    // 如果应用在后台显示通知
                    QSUtil.showNotification(getContext(), messageBean);
                } else {
                    // 如果在前台则播放声音和震动
                    QSUtil.playRingtone(getContext());
                    QSUtil.playVibration(getContext());
                }
            } catch (Exception ignoreException) {
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().getConversationList();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ChatManager.SINGLETON.removeOnMessageListener(mOnMessageListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_conversation;
    }

    @Override
    public void initView() {
        RecyclerView rcvConversation = findViewByID(R.id.rcv_conversation);
        rcvConversation.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvConversation.setAdapter(mRcvConversationAdapter = new RcvConversationAdapter(getContext()));
        ((DefaultItemAnimator) rcvConversation.getItemAnimator()).setSupportsChangeAnimations(false);
    }


    @Override
    public void setListener() {
        // 设置聊天监听器,监听收到的消息
        ChatManager.SINGLETON.addOnMessageListener(mOnMessageListener);
    }

    @Override
    public void initData() {
    }


    @Override
    public void getConversationListSuccess(List<ConversationBean> conversationBeanList) {
        mRcvConversationAdapter.setDataList(conversationBeanList);
    }

    @Override
    public void getConversationListFailure(Exception e) {

    }
}