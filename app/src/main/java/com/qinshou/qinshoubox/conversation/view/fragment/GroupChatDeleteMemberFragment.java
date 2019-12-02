package com.qinshou.qinshoubox.conversation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatDeleteMemberContract;
import com.qinshou.qinshoubox.conversation.presenter.GroupChatDeleteMemberPresenter;
import com.qinshou.qinshoubox.friend.bean.GroupChatMemberForCreateBean;
import com.qinshou.qinshoubox.friend.view.adapter.RcvGroupChatMemberForCreateAdapter;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

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
    private int mGroupChatId;

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
        mTvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> deleteMemberIdList = new ArrayList<>();
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
        mGroupChatId = bundle.getInt(GROUP_CHAT_ID, 0);
        if (mGroupChatId == 0) {
            return;
        }
        getPresenter().getMemberList(mGroupChatId);
    }

    @Override
    public void getMemberListSuccess(List<UserBean> userBeanList) {
        List<GroupChatMemberForCreateBean> groupChatMemberForCreateBeanList = new ArrayList<>();
        for (UserBean userBean : userBeanList) {
            if (userBean.getId() == UserStatusManager.SINGLETON.getUserBean().getId()) {
                continue;
            }
            GroupChatMemberForCreateBean groupChatMemberForCreateBean = new GroupChatMemberForCreateBean();
            groupChatMemberForCreateBean.setId(userBean.getId());
            groupChatMemberForCreateBean.setHeadImgSmall(userBean.getHeadImgSmall());
            groupChatMemberForCreateBean.setRemark(userBean.getRemark());
            groupChatMemberForCreateBean.setNickname(userBean.getNickname());
            groupChatMemberForCreateBeanList.add(groupChatMemberForCreateBean);
        }
        mRcvGroupChatMemberForCreateAdapter.setDataList(groupChatMemberForCreateBeanList);
    }

    @Override
    public void getMemberListFailure(Exception e) {

    }

    @Override
    public void deleteMemberSuccess() {
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
    public static void start(Context context, int groupChatId) {
        Bundle bundle = new Bundle();
        bundle.putInt(GROUP_CHAT_ID, groupChatId);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , GroupChatDeleteMemberFragment.class
                , bundle));
    }
}