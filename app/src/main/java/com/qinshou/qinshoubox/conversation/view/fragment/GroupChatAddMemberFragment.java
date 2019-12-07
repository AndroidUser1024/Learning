package com.qinshou.qinshoubox.conversation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatAddMemberContract;
import com.qinshou.qinshoubox.conversation.presenter.GroupChatAddMemberPresenter;
import com.qinshou.qinshoubox.friend.bean.GroupChatMemberForCreateBean;
import com.qinshou.qinshoubox.friend.view.adapter.RcvGroupChatMemberForCreateAdapter;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.login.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:41
 * Description:添加群成员界面
 */
public class GroupChatAddMemberFragment extends QSFragment<GroupChatAddMemberPresenter> implements IGroupChatAddMemberContract.IView {
    public static final String GROUP_CHAT_ID = "GroupChatId";
    /**
     * 群聊成员列表适配器
     */
    private RcvGroupChatMemberForCreateAdapter mRcvGroupChatMemberForCreateAdapter;
    /**
     * 完成按钮
     */
    private TextView mTvFinish;
    private String mGroupChatId;
    private List<Integer> mFriendIdList;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_group_chat_add_member;
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
                List<String> deleteMemberIdList = new ArrayList<>();
                for (GroupChatMemberForCreateBean groupChatMemberForCreateBean : mRcvGroupChatMemberForCreateAdapter.getDataList()) {
                    if (groupChatMemberForCreateBean.isChoose()) {
                        deleteMemberIdList.add(groupChatMemberForCreateBean.getId());
                    }
                }
                getPresenter().addMember(mGroupChatId, deleteMemberIdList);
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
                    if (groupChatMemberForCreateBean.isChoose() && groupChatMemberForCreateBean.isEnable()) {
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
        getPresenter().getFriendList();
    }

    @Override
    public void getMemberListSuccess(List<UserBean> userBeanList) {
        for (GroupChatMemberForCreateBean groupChatMemberForCreateBean : mRcvGroupChatMemberForCreateAdapter.getDataList()) {
            for (UserBean userBean : userBeanList) {
                if (groupChatMemberForCreateBean.getId() == userBean.getId()) {
                    groupChatMemberForCreateBean.setChoose(true);
                    groupChatMemberForCreateBean.setEnable(false);
                    continue;
                }
            }
        }
        mRcvGroupChatMemberForCreateAdapter.notifyDataSetChanged();
    }

    @Override
    public void getMemberListFailure(Exception e) {
    }

    @Override
    public void getFriendListSuccess(List<FriendBean> friendBeanList) {
        List<GroupChatMemberForCreateBean> groupChatMemberForCreateBeanList = new ArrayList<>();
        for (FriendBean friendBean : friendBeanList) {
//            if (friendBean.getId() == UserStatusManager.SINGLETON.getUserBean().getId()) {
//                continue;
//            }
//            GroupChatMemberForCreateBean groupChatMemberForCreateBean = new GroupChatMemberForCreateBean();
//            groupChatMemberForCreateBean.setId(friendBean.getId());
//            groupChatMemberForCreateBean.setHeadImgSmall(friendBean.getHeadImgSmall());
//            groupChatMemberForCreateBean.setRemark(friendBean.getRemark());
//            groupChatMemberForCreateBean.setNickname(friendBean.getNickname());
//            groupChatMemberForCreateBeanList.add(groupChatMemberForCreateBean);
        }
        mRcvGroupChatMemberForCreateAdapter.setDataList(groupChatMemberForCreateBeanList);
        getPresenter().getMemberList(mGroupChatId);
    }

    @Override
    public void getFriendListFailure(Exception e) {
    }

    @Override
    public void addMemberSuccess() {
        finish();
    }

    @Override
    public void addMemberFailure(Exception e) {

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
                , GroupChatAddMemberFragment.class
                , bundle));
    }
}