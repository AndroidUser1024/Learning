package com.qinshou.qinshoubox.conversation.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.listener.IOnMessageListener;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.presenter.ConversationPresenter;
import com.qinshou.qinshoubox.conversation.view.adapter.RcvConversationAdapter;
import com.qinshou.qinshoubox.im.view.fragment.IMFragment;

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
     * 主界面 TabLayout 的未读消息总数
     */
    private TextView mTvUnreadCountInTlMain;
    /**
     * 聊天消息监听器
     */
    private IOnMessageListener mOnMessageListener = new IOnMessageListener() {
        @Override
        public void onMessage(MessageBean messageBean) {
            ShowLogUtil.logi("onReceive: messageBean--->" + messageBean);
            int toUserId = 0;
//            if (messageBean.getType() == MessageType.CHAT.getValue()) {
//                toUserId = messageBean.getFromUserId();
//            } else if (messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
//                toUserId = messageBean.getToUserId();
//            }
//            ConversationBean conversationBean = IMClient.SINGLETON.getConversationManager().getByTypeAndToUserId(messageBean.getType(), toUserId);
//            List<ConversationBean> conversationBeanList = mRcvConversationAdapter.getDataList();
//            boolean contains = false;
//            int index = 0;
//            for (int i = 0; i < conversationBeanList.size(); i++) {
//                if (conversationBeanList.get(i).getId() == conversationBean.getId()) {
//                    contains = true;
//                    index = i;
//                    break;
//                }
//            }
//            if (contains) {
//                if (index == 0) {
//                    // 如果该会话本来就在第一个,直接修改
//                    conversationBeanList.set(index, conversationBean);
//                    mRcvConversationAdapter.notifyItemChanged(index);
//                } else {
//                    // 如果该会话不在第一个,放到第一个
//                    conversationBeanList.remove(index);
//                    conversationBeanList.add(0, conversationBean);
//                    mRcvConversationAdapter.notifyItemMoved(index, 0);
//                }
//            } else {
//                // 原来的会话列表中没有该会话,则添加到第一个
//                conversationBeanList.add(0, conversationBean);
//                mRcvConversationAdapter.notifyItemChanged(0);
//            }
//            showMessageUnreadCount();
//            try {
//                if (SystemUtil.isBackground(getContext())) {
//                    // 如果应用在后台显示通知
//                    QSUtil.showNotification(getContext(), messageBean);
//                } else {
//                    // 如果在前台则播放声音和震动
//                    QSUtil.playRingtone(getContext());
//                    QSUtil.playVibration(getContext());
//                }
//            } catch (Exception ignoreException) {
//            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().getConversationList();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTvUnreadCountInTlMain.setVisibility(View.GONE);
        IMClient.SINGLETON.removeOnMessageListener(mOnMessageListener);
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

        TabLayout tlIM = getActivity().findViewById(R.id.tl_im);
        if (tlIM == null) {
            return;
        }
        TabLayout.Tab tab = tlIM.getTabAt(IMFragment.TAB_INDEX_CONVERSATION);
        if (tab == null) {
            return;
        }
        View view = tab.getCustomView();
        if (view == null) {
            return;
        }
        mTvUnreadCountInTlMain = view.findViewById(R.id.tv_unread_count);
    }


    @Override
    public void setListener() {
        // 设置聊天监听器,监听收到的消息
        IMClient.SINGLETON.addOnMessageListener(mOnMessageListener);
        mRcvConversationAdapter.setOnItemClickListener(new IOnItemClickListener<ConversationBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, ConversationBean itemData, int position) {
//                if (itemData.getType() == MessageType.CHAT.getValue()) {
//                    ChatActivity.start(getContext(), itemData.getToUserId());
//                } else if (itemData.getType() == MessageType.GROUP_CHAT.getValue()) {
//                    GroupChatActivity.start(getContext(), itemData.getToUserId());
//                }
//                // 重置未读数
//                IMClient.SINGLETON.getConversationManager().resetUnreadCount(itemData.getId());
//                itemData.setUnreadCount(0);
//                mRcvConversationAdapter.notifyItemChanged(position);
//                showMessageUnreadCount();
            }
        });
    }

    @Override
    public void initData() {
        getPresenter().getConversationList();
        showMessageUnreadCount();
    }


    @Override
    public void getConversationListSuccess(List<ConversationBean> conversationBeanList) {
        mRcvConversationAdapter.setDataList(conversationBeanList);
    }

    @Override
    public void getConversationListFailure(Exception e) {

    }

    private void showMessageUnreadCount() {
//        int totalUnreadCount = IMClient.SINGLETON.getConversationManager().getTotalUnreadCount();
//        if (totalUnreadCount > 0) {
//            mTvUnreadCountInTlMain.setVisibility(View.VISIBLE);
//            mTvUnreadCountInTlMain.setText("" + totalUnreadCount);
//        } else {
//            mTvUnreadCountInTlMain.setVisibility(View.GONE);
//        }
    }
}