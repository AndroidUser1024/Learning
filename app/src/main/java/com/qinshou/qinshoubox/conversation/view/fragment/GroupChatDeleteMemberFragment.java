package com.qinshou.qinshoubox.conversation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatDeleteMemberContract;
import com.qinshou.qinshoubox.conversation.presenter.GroupChatDeleteMemberPresenter;
import com.qinshou.qinshoubox.friend.bean.GroupChatMemberForCreateBean;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.adapter.RcvGroupChatMemberForCreateAdapter;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:41
 * Description:删除群成员界面
 */
public class GroupChatDeleteMemberFragment extends QSFragment<GroupChatDeleteMemberPresenter> implements IGroupChatDeleteMemberContract.IView {
    public static final String GROUP_CHAT_ID = "GroupChatId";
    /**
     * 完成按钮
     */
    private TextView mTvFinish;
    /**
     * 群聊成员列表适配器
     */
    private RcvGroupChatMemberForCreateAdapter mRcvGroupChatMemberForCreateAdapter;
    private String mGroupChatId;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_group_chat_delete_member;
    }

    @Override
    public void initView() {
        mTvFinish = findViewByID(R.id.tv_finish);

        RecyclerView rcvGroupChatMember = findViewByID(R.id.rcv_group_chat_member);
        rcvGroupChatMember.setLayoutManager(new LinearLayoutManager(getContext()));
        rcvGroupChatMember.setAdapter(mRcvGroupChatMemberForCreateAdapter = new RcvGroupChatMemberForCreateAdapter(getContext()));
        // 去掉 item 修改时默认动画
        ((DefaultItemAnimator) rcvGroupChatMember.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    public void setListener() {
        super.setListener();
        mTvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> deleteMemberIdList = new ArrayList<>();
                for (GroupChatMemberForCreateBean groupChatMemberForCreateBean : mRcvGroupChatMemberForCreateAdapter.getDataList()) {
                    if (groupChatMemberForCreateBean.isChoose()) {
                        deleteMemberIdList.add(groupChatMemberForCreateBean.getId());
                    }
                }
                getPresenter().deleteMember(mGroupChatId, deleteMemberIdList);
            }
        });
        mRcvGroupChatMemberForCreateAdapter.setOnItemClickListener(new IOnItemClickListener<GroupChatMemberForCreateBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, GroupChatMemberForCreateBean itemData, int position) {
                // 修改群成员列表中的状态
                itemData.setChoose(!itemData.isChoose());
                mRcvGroupChatMemberForCreateAdapter.notifyItemChanged(position);

                mTvFinish.setEnabled(false);
                for (GroupChatMemberForCreateBean groupChatMemberForCreateBean : mRcvGroupChatMemberForCreateAdapter.getDataList()) {
                    if (groupChatMemberForCreateBean.isChoose()) {
                        mTvFinish.setEnabled(true);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mGroupChatId = bundle.getString(GROUP_CHAT_ID);
        if (TextUtils.isEmpty(mGroupChatId)) {
            return;
        }
        getPresenter().getMemberList(mGroupChatId);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    @Override
    public void getMemberListSuccess(List<UserDetailBean> userDetailBeanList) {
        List<GroupChatMemberForCreateBean> groupChatMemberForCreateBeanList = new ArrayList<>();
        for (UserDetailBean userDetailBean : userDetailBeanList) {
            if (TextUtils.equals(userDetailBean.getId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
                continue;
            }
            GroupChatMemberForCreateBean groupChatMemberForCreateBean = new GroupChatMemberForCreateBean();
            groupChatMemberForCreateBean.setId(userDetailBean.getId());
            groupChatMemberForCreateBean.setHeadImgSmall(userDetailBean.getHeadImgSmall());
            groupChatMemberForCreateBean.setRemark(userDetailBean.getRemark());
            groupChatMemberForCreateBean.setNicknameInGroupChat(userDetailBean.getNicknameInGroupChat());
            groupChatMemberForCreateBean.setNickname(userDetailBean.getNickname());
            groupChatMemberForCreateBeanList.add(groupChatMemberForCreateBean);
        }
        mRcvGroupChatMemberForCreateAdapter.setDataList(groupChatMemberForCreateBeanList);
    }

    @Override
    public void getMemberListFailure(Exception e) {

    }

    @Override
    public void deleteMemberSuccess() {
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_GROUP_CHAT_DETAIL, null));
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_GROUP_CHAT_LIST, null));
        finish();
    }

    @Override
    public void deleteMemberFailure(Exception e) {
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/3 17:48
     * Description:跳转到该界面
     *
     * @param context     上下文
     * @param groupChatId 群 Id
     */
    public static void start(Context context, String groupChatId) {
        Bundle bundle = new Bundle();
        bundle.putString(GROUP_CHAT_ID, groupChatId);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , GroupChatDeleteMemberFragment.class
                , bundle));
    }
}