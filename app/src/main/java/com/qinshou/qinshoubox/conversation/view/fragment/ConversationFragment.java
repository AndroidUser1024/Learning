package com.qinshou.qinshoubox.conversation.view.fragment;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.rcvdecoration.DividerDecoration;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IConversationContract;
import com.qinshou.qinshoubox.conversation.presenter.ConversationPresenter;
import com.qinshou.qinshoubox.conversation.view.adapter.RcvConversationAdapter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.IOnMessageListener;
import com.qinshou.qinshoubox.util.QSUtil;

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
            String toUserId = null;
            if (messageBean.getType() == MessageType.CHAT.getValue()) {
                toUserId = messageBean.getFromUserId();
            } else if (messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
                toUserId = messageBean.getToUserId();
            }
            ConversationDetailBean conversationDetailBean = IMClient.SINGLETON.getConversationManager().selectDetailByTypeAndToUserId(messageBean.getType(), toUserId);
            if (conversationDetailBean == null) {
                return;
            }
            // 更新会话列表
            updateConversationList(conversationDetailBean);
            // 更新未读数
            updateUnreadCount(conversationDetailBean);
            // 如果免打扰,则不震动,不显示通知
            if (conversationDetailBean.getDoNotDisturb() == 1) {
                return;
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
        rcvConversation.addItemDecoration(new DividerDecoration.Builder()
                .setWidth(getResources().getDimensionPixelSize(R.dimen.px1))
                .setColor(0xFFF2F2F2)
                .build());
        ((DefaultItemAnimator) rcvConversation.getItemAnimator()).setSupportsChangeAnimations(false);
        rcvConversation.setAdapter(mRcvConversationAdapter = new RcvConversationAdapter(getContext()));

        TabLayout tlMain = getActivity().findViewById(R.id.tl_main);
        if (tlMain == null) {
            return;
        }
        TabLayout.Tab tab = tlMain.getTabAt(MainActivity.TAB_INDEX_CONVERSATION);
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
    }

    @Override
    public void initData() {
        updateUnreadCount(null);
        getPresenter().getConversationList();
    }

    @Override
    public void onAuthenticated() {
        super.onAuthenticated();
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.REFRESH_CONVERSATION_UNREAD_COUNT) {
            updateUnreadCount((ConversationDetailBean) eventBean.getData());
        } else if (eventBean.getType() == EventBean.Type.REFRESH_CONVERSATION_LIST) {
            if (eventBean.getData() == null) {
                getPresenter().getConversationList();
                // 更新未读数
                updateUnreadCount((ConversationDetailBean) eventBean.getData());
            } else if (eventBean.getData() instanceof ConversationDetailBean) {
                updateConversationList((ConversationDetailBean) eventBean.getData());
                // 更新未读数
                updateUnreadCount((ConversationDetailBean) eventBean.getData());
            }
        } else if (eventBean.getType() == EventBean.Type.CLEAR_CHAT_HISTORY) {
            clearChatHistory((ConversationDetailBean) eventBean.getData());
        }
    }

    @Override
    public void getConversationListSuccess(List<ConversationDetailBean> conversationDetailBeanList) {
        mRcvConversationAdapter.setDataList(conversationDetailBeanList);
    }

    @Override
    public void getConversationListFailure(Exception e) {

    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 18:48
     * Description:更新会话列表
     *
     * @param conversationDetailBean 需要插入或更新的会话
     */
    private void updateConversationList(ConversationDetailBean conversationDetailBean) {
        List<ConversationDetailBean> conversationDetailBeanList = mRcvConversationAdapter.getDataList();
        if (conversationDetailBean.getTop() == 1) {
            // 置顶的会话
            boolean contains = false;
            // 如果会话列表中包含该会话,定义一个变量记录该会话原来的位置
            int index = 0;
            for (int i = 0; i < conversationDetailBeanList.size(); i++) {
                if (conversationDetailBeanList.get(i).getId() == conversationDetailBean.getId()) {
                    contains = true;
                    index = i;
                    break;
                }
            }
            if (contains) {
                if (index == 0) {
                    // 如果该会话本来就在第一个,直接修改
                    conversationDetailBeanList.set(index, conversationDetailBean);
                    mRcvConversationAdapter.notifyItemChanged(index);
                } else {
                    // 如果该会话不在第一个,放到第一个
                    conversationDetailBeanList.remove(index);
                    conversationDetailBeanList.add(0, conversationDetailBean);
                    mRcvConversationAdapter.notifyItemRangeChanged(0, index - 0 + 1);
                }
            } else {
                // 原来的会话列表中没有该会话,则添加到第一个
                conversationDetailBeanList.add(0, conversationDetailBean);
                mRcvConversationAdapter.notifyItemRangeChanged(0, conversationDetailBeanList.size() - 0 + 1);
            }
        } else {
            // 非置顶的会话
            boolean contains = false;
            // 如果会话列表中包含该会话,定义一个变量记录该会话原来的位置
            int index = 0;
            // 定义一个变量记录非置顶的第一条会话的位置
            int firstNotTopIndex = conversationDetailBeanList.size();
            for (int i = 0; i < conversationDetailBeanList.size(); i++) {
                // firstNotTopIndex 只修改一次
                if (conversationDetailBeanList.get(i).getTop() == 0 && firstNotTopIndex == conversationDetailBeanList.size()) {
                    firstNotTopIndex = i;
                }
                if (conversationDetailBeanList.get(i).getId() == conversationDetailBean.getId()) {
                    contains = true;
                    index = i;
                    break;
                }
            }
            if (contains) {
                if (index == firstNotTopIndex) {
                    // 如果该会话本来就在非置顶会话的第一个,直接修改
                    conversationDetailBeanList.set(index, conversationDetailBean);
                    mRcvConversationAdapter.notifyItemChanged(index);
                } else {
                    // 如果该会话不在非置顶会话第一个,放到非置顶会话第一个
                    conversationDetailBeanList.remove(index);
                    conversationDetailBeanList.add(firstNotTopIndex, conversationDetailBean);
                    mRcvConversationAdapter.notifyItemRangeChanged(firstNotTopIndex, index - firstNotTopIndex + 1);
                }
            } else {
                // 原来的会话列表中没有该会话,则添加到非置顶会话第一个
                conversationDetailBeanList.add(firstNotTopIndex, conversationDetailBean);
                mRcvConversationAdapter.notifyItemRangeChanged(firstNotTopIndex, conversationDetailBeanList.size() - firstNotTopIndex + 1);
            }
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 19:12
     * Description:更新未读数
     *
     * @param conversationDetailBean
     */
    private void updateUnreadCount(@Nullable ConversationDetailBean conversationDetailBean) {
        int totalUnreadCount = IMClient.SINGLETON.getConversationManager().getTotalUnreadCount();
        if (totalUnreadCount > 0) {
            mTvUnreadCountInTlMain.setVisibility(View.VISIBLE);
            mTvUnreadCountInTlMain.setText("" + totalUnreadCount);
        } else {
            mTvUnreadCountInTlMain.setVisibility(View.GONE);
        }
        if (conversationDetailBean == null) {
            return;
        }
        for (int i = 0; i < mRcvConversationAdapter.getDataList().size(); i++) {
            ConversationDetailBean c = mRcvConversationAdapter.getDataList().get(i);
            if (c.getId() == conversationDetailBean.getId()) {
                c.setUnreadCount(conversationDetailBean.getUnreadCount());
                mRcvConversationAdapter.notifyItemChanged(i);
                break;
            }
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/3/23 16:45
     * Description:清空聊天历史
     *
     * @param data 目标会话
     */
    private void clearChatHistory(ConversationDetailBean data) {
        List<ConversationDetailBean> conversationDetailBeanList = mRcvConversationAdapter.getDataList();
        for (int i = 0; i < conversationDetailBeanList.size(); i++) {
            ConversationDetailBean conversationDetailBean = conversationDetailBeanList.get(i);
            if (conversationDetailBean.getType() == data.getType() && TextUtils.equals(conversationDetailBean.getToUserId(), data.getToUserId())) {
                conversationDetailBean.setLastMsgContent("");
                conversationDetailBean.setLastMsgPid(0);
                mRcvConversationAdapter.notifyItemChanged(i);
                break;
            }
        }
    }
}