package com.qinshou.qinshoubox.conversation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.bean.GroupChatMemberFunction;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.presenter.GroupChatSettingPresenter;
import com.qinshou.qinshoubox.conversation.view.adapter.RcvGroupChatMemberAdapter;
import com.qinshou.qinshoubox.login.bean.UserBean;


/**
 * Author：WangGuifa
 * Email：wangguifa@jeejio.com
 * Date：2019/8/6 19:05
 * Description：群聊设置页面
 */
public class GroupChatSettingFragment extends QSFragment<GroupChatSettingPresenter> implements IGroupChatSettingContract.IView {
    public static final String GROUP_CHAT_ID = "GroupChatId";
    private TitleBar mTitleBar;
    private RcvGroupChatMemberAdapter mRcvGroupChatMemberAdapter;
    /**
     * 群昵称
     */
    private TextView mTvNickname;
    private GroupChatBean mGroupChatBean;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_group_chat_setting;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        RecyclerView rcvGroupChatMember = findViewByID(R.id.rcv_group_chat_member);
        rcvGroupChatMember.setLayoutManager(new GridLayoutManager(getContext(), 5));
        rcvGroupChatMember.setAdapter(mRcvGroupChatMemberAdapter = new RcvGroupChatMemberAdapter(getContext()));
        mTvNickname = findViewByID(R.id.tv_nickname);
    }

    @Override
    public void setListener() {
        mRcvGroupChatMemberAdapter.setOnItemClickListener(new IOnItemClickListener() {
            @Override
            public void onItemClick(BaseViewHolder holder, Object itemData, int position) {
                if (itemData instanceof UserBean) {

                } else if (itemData instanceof GroupChatMemberFunction) {
                    if (itemData == GroupChatMemberFunction.ADD_MEMBER) {
                        GroupChatAddMemberFragment.start(getContext(), mGroupChatBean.getId());
                    } else if (itemData == GroupChatMemberFunction.DELETE_MEMBER) {
                        GroupChatDeleteMemberFragment.start(getContext(), mGroupChatBean.getId());
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
        int groupChatId = bundle.getInt(GROUP_CHAT_ID, 0);
        if (groupChatId == 0) {
            return;
        }
        getPresenter().getGroupChat(groupChatId);
    }

    @Override
    public void getGroupChatSuccess(GroupChatBean groupChatBean) {
        mGroupChatBean = groupChatBean;
//        mTitleBar.setTitleText(getString(R.string.group_chat_setting_title, "" + groupChatBean.getMemberList().size()));
//        List list = new ArrayList(groupChatBean.getMemberList());
//        list.add(GroupChatMemberFunction.ADD_MEMBER);
//        if (groupChatBean.getOwnerId() == UserStatusManager.SINGLETON.getUserBean().getId()) {
//            list.add(GroupChatMemberFunction.DELETE_MEMBER);
//        }
//        mRcvGroupChatMemberAdapter.setDataList(list);
        mTvNickname.setText(TextUtils.isEmpty(groupChatBean.getNickname())
                ? getString(R.string.group_chat_setting_tv_nickname_text)
                : groupChatBean.getNickname());
    }

    @Override
    public void getGroupChatFailure(Exception e) {

    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/3 15:09
     * Description:跳转到该界面
     *
     * @param context     上下文
     * @param groupChatId 群 Id
     */
    public static void start(Context context, int groupChatId) {
        Bundle bundle = new Bundle();
        bundle.putInt(GROUP_CHAT_ID, groupChatId);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , GroupChatSettingFragment.class
                , bundle));
    }
}
