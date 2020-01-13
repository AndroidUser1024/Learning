package com.qinshou.qinshoubox.conversation.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.qinshou.qinshoubox.im.bean.ConversationBean;
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
            ConversationBean conversationBean = IMClient.SINGLETON.getConversationManager().getByTypeAndToUserId(messageBean.getType(), toUserId);
            // 更新会话列表
            updateConversationList(conversationBean);
            // 更新未读数
            updateUnreadCount();
            // 如果免打扰,则不震动,不显示通知
            if (conversationBean.getDoNotDisturb() == 1) {
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
        rcvConversation.addItemDecoration(new DividerDecoration(DividerDecoration.Orientation.VERTICAL, getResources().getDimensionPixelSize(R.dimen.px1), 0xFFF2F2F2));
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
        updateUnreadCount();
        getPresenter().getConversationList();
    }


    @Override
    public void getConversationListSuccess(List<ConversationBean> conversationBeanList) {
        mRcvConversationAdapter.setDataList(conversationBeanList);
    }

    @Override
    public void getConversationListFailure(Exception e) {

    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.REFRESH_CONVERSATION_UNREAD_COUNT) {
            updateUnreadCount();
        } else if (eventBean.getType() == EventBean.Type.REFRESH_CONVERSATION_LIST) {
            if (eventBean.getData() == null) {
                getPresenter().getConversationList();
                // 更新未读数
                updateUnreadCount();
            } else if (eventBean.getData() instanceof ConversationBean) {
                updateConversationList((ConversationBean) eventBean.getData());
                // 更新未读数
                updateUnreadCount();
            }
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 18:48
     * Description:更新会话列表
     *
     * @param conversationBean 需要插入或更新的会话
     */
    private void updateConversationList(ConversationBean conversationBean) {
        ShowLogUtil.logi("刷新会话列表--->" + conversationBean);
        List<ConversationBean> conversationBeanList = mRcvConversationAdapter.getDataList();
        if (conversationBean.getTop() == 1) {
            // 置顶的会话
            boolean contains = false;
            // 如果会话列表中包含该会话,定义一个变量记录该会话原来的位置
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
                    mRcvConversationAdapter.notifyItemChanged(0);
                }
            } else {
                // 原来的会话列表中没有该会话,则添加到第一个
                conversationBeanList.add(0, conversationBean);
                mRcvConversationAdapter.notifyItemInserted(0);
            }
        } else {
            // 非置顶的会话
            boolean contains = false;
            // 如果会话列表中包含该会话,定义一个变量记录该会话原来的位置
            int index = 0;
            // 定义一个变量记录非置顶的第一条会话的位置
            int firstNotTopIndex = conversationBeanList.size();
            for (int i = 0; i < conversationBeanList.size(); i++) {
                // firstNotTopIndex 只修改一次
                if (conversationBeanList.get(i).getTop() == 0 && firstNotTopIndex == conversationBeanList.size()) {
                    firstNotTopIndex = i;
                }
                if (conversationBeanList.get(i).getId() == conversationBean.getId()) {
                    contains = true;
                    index = i;
                    break;
                }
            }
            if (contains) {
                if (index == firstNotTopIndex) {
                    // 如果该会话本来就在非置顶会话的第一个,直接修改
                    conversationBeanList.set(index, conversationBean);
                    mRcvConversationAdapter.notifyItemChanged(index);
                } else {
                    // 如果该会话不在非置顶会话第一个,放到非置顶会话第一个
                    conversationBeanList.remove(index);
                    conversationBeanList.add(firstNotTopIndex, conversationBean);
                    mRcvConversationAdapter.notifyItemMoved(index, firstNotTopIndex);
                    mRcvConversationAdapter.notifyItemChanged(firstNotTopIndex);
                }
            } else {
                // 原来的会话列表中没有该会话,则添加到非置顶会话第一个
                conversationBeanList.add(firstNotTopIndex, conversationBean);
                mRcvConversationAdapter.notifyItemInserted(firstNotTopIndex);
            }
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 19:12
     * Description:更新未读数
     */
    private void updateUnreadCount() {
        int totalUnreadCount = IMClient.SINGLETON.getConversationManager().getTotalUnreadCount();
        if (totalUnreadCount > 0) {
            mTvUnreadCountInTlMain.setVisibility(View.VISIBLE);
            mTvUnreadCountInTlMain.setText("" + totalUnreadCount);
        } else {
            mTvUnreadCountInTlMain.setVisibility(View.GONE);
        }
    }
}