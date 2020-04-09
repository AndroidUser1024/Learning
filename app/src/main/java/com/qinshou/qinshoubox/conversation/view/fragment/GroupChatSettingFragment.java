package com.qinshou.qinshoubox.conversation.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.im.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.enums.GroupChatMemberFunction;
import com.qinshou.qinshoubox.conversation.presenter.GroupChatSettingPresenter;
import com.qinshou.qinshoubox.conversation.view.adapter.RcvGroupChatMemberAdapter;
import com.qinshou.qinshoubox.conversation.view.dialog.ClearChatHistoryDialog;
import com.qinshou.qinshoubox.conversation.view.dialog.ExitGroupChatDialog;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.IOnGroupChatStatusListener;
import com.qinshou.qinshoubox.me.ui.widget.SwitchButton;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


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
     * 查看更多群成员
     */
    private TextView mTvShowMoreGroupChatMember;
    /**
     * 群昵称
     */
    private TextView mTvNickname;

    /**
     * 置顶开关
     */
    private SwitchButton mSwtTop;
    /**
     * 免打扰开关
     */
    private SwitchButton mSwtDoNotDisturb;
    /**
     * 是否显示群成员昵称开关
     */
    private SwitchButton mSwtShowGroupChatMemberNickname;
    /**
     * 我在本群中的昵称
     */
    private TextView mTvNicknameInGroup;
    private GroupChatDetailBean mGroupChatDetailBean;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_nickname:
                    SetGroupChatNicknameFragment.start(getContext(), mGroupChatDetailBean.getId(), mGroupChatDetailBean.getNickname());
                    break;
                case R.id.ll_nickname_in_group_chat:
                    SetNicknameInGroupChatFragment.start(getContext(), mGroupChatDetailBean.getId(), mGroupChatDetailBean.getNicknameInGroupChat());
                    break;
                case R.id.ll_clear_chat_history:
                    String nickname = TextUtils.isEmpty(mGroupChatDetailBean.getNickname())
                            ? mGroupChatDetailBean.getNicknameDefault()
                            : mGroupChatDetailBean.getNickname();
                    ClearChatHistoryDialog.newInstance(MessageType.GROUP_CHAT, mGroupChatDetailBean.getId(), nickname)
                            .show(getChildFragmentManager(), "ClearChatHistoryDialog");
                    break;
                case R.id.btn_exit:
                    ExitGroupChatDialog exitGroupChatDialog = new ExitGroupChatDialog();
                    exitGroupChatDialog.setTvPositiveOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getPresenter().exit(mGroupChatDetailBean.getId());
                        }
                    });
                    exitGroupChatDialog.show(getChildFragmentManager(), "ExitGroupChatDialog");
                    break;
            }
        }
    };
    private IOnGroupChatStatusListener mOnGroupChatStatusListener = new IOnGroupChatStatusListener() {
        @Override
        public void add(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList) {
        }

        @Override
        public void delete(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList) {
        }

        @Override
        public void otherAdd(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList) {
            getPresenter().getGroupChatDetail(groupChat.getId());
        }

        @Override
        public void otherDelete(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList) {
            getPresenter().getGroupChatDetail(groupChat.getId());
        }

        @Override
        public void nicknameChanged(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList) {
            getPresenter().getGroupChatDetail(groupChat.getId());
        }

        @Override
        public void nicknameInGroupChatChanged(GroupChatDetailBean groupChat, UserDetailBean fromUser, List<UserDetailBean> toUserList) {
            getPresenter().getGroupChatDetail(groupChat.getId());
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        IMClient.SINGLETON.removeOnGroupChatStatusListener(mOnGroupChatStatusListener);
    }

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
        mTvShowMoreGroupChatMember = findViewByID(R.id.tv_show_more_group_chat_member);

        mTvNickname = findViewByID(R.id.tv_nickname);

        mSwtTop = findViewByID(R.id.swt_top);
        mSwtDoNotDisturb = findViewByID(R.id.swt_do_not_disturb);
        mSwtShowGroupChatMemberNickname = findViewByID(R.id.swt_show_group_chat_member_nickname);
        mTvNicknameInGroup = findViewByID(R.id.tv_nickname_in_group_chat);
    }

    @Override
    public void setListener() {
        mRcvGroupChatMemberAdapter.setOnItemClickListener(new IOnItemClickListener() {
            @Override
            public void onItemClick(BaseViewHolder holder, Object itemData, int position) {
                if (itemData instanceof UserDetailBean) {
                    UserDetailFragment.start(getContext(), ((UserDetailBean) itemData).getId());
                } else if (itemData instanceof GroupChatMemberFunction) {
                    if (itemData == GroupChatMemberFunction.ADD_MEMBER) {
                        GroupChatAddMemberFragment.start(getContext(), mGroupChatDetailBean.getId());
                    } else if (itemData == GroupChatMemberFunction.DELETE_MEMBER) {
                        GroupChatDeleteMemberFragment.start(getContext(), mGroupChatDetailBean.getId());
                    }
                }
            }
        });
        findViewByID(R.id.ll_nickname).setOnClickListener(mOnClickListener);
        mSwtTop.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                getPresenter().setTop(mGroupChatDetailBean.getId(), checked ? 1 : 0);
            }
        });
        mSwtDoNotDisturb.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                getPresenter().setDoNotDisturb(mGroupChatDetailBean.getId(), checked ? 1 : 0);
            }
        });
        mSwtShowGroupChatMemberNickname.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                getPresenter().setShowGroupChatMemberNickname(mGroupChatDetailBean.getId(), checked ? 1 : 0);
            }
        });
        findViewByID(R.id.ll_nickname_in_group_chat).setOnClickListener(mOnClickListener);
        findViewByID(R.id.ll_clear_chat_history).setOnClickListener(mOnClickListener);
        findViewByID(R.id.btn_exit).setOnClickListener(mOnClickListener);
        IMClient.SINGLETON.addOnGroupChatStatusListener(mOnGroupChatStatusListener);
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        String groupChatId = bundle.getString(GROUP_CHAT_ID);
        if (TextUtils.isEmpty(groupChatId)) {
            return;
        }
        getPresenter().getGroupChatDetail(groupChatId);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.REFRESH_GROUP_CHAT_DETAIL) {
            getPresenter().getGroupChatDetail(mGroupChatDetailBean.getId());
        }
    }

    @Override
    public void getGroupChatDetailSuccess(GroupChatDetailBean groupChatDetailBean) {
        mGroupChatDetailBean = groupChatDetailBean;
        mTitleBar.setTitleText(getString(R.string.group_chat_setting_title, "" + groupChatDetailBean.getMemberList().size()));
        List<Object> list;
        List<UserDetailBean> memberList = groupChatDetailBean.getMemberList();
        if (TextUtils.equals(groupChatDetailBean.getOwnerId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
            if (memberList.size() > 13) {
                list = new ArrayList<>(memberList.subList(0, 13));
            } else {
                list = new ArrayList<>(memberList);
            }
            list.add(GroupChatMemberFunction.ADD_MEMBER);
            list.add(GroupChatMemberFunction.DELETE_MEMBER);
        } else {
            if (memberList.size() > 14) {
                list = new ArrayList<>(memberList.subList(0, 14));
            } else {
                list = new ArrayList<>(memberList);
            }
            list.add(GroupChatMemberFunction.ADD_MEMBER);
        }
        mRcvGroupChatMemberAdapter.setDataList(list);
        if (TextUtils.equals(IMClient.SINGLETON.getUserDetailBean().getId(), groupChatDetailBean.getOwnerId())) {
            mTvShowMoreGroupChatMember.setVisibility(mGroupChatDetailBean.getMemberCount() >= 13
                    ? View.VISIBLE
                    : View.GONE);
        } else {
            mTvShowMoreGroupChatMember.setVisibility(mGroupChatDetailBean.getMemberCount() >= 14
                    ? View.VISIBLE
                    : View.GONE);
        }

        mTvNickname.setText(TextUtils.isEmpty(groupChatDetailBean.getNickname())
                ? getString(R.string.group_chat_setting_tv_nickname_text)
                : groupChatDetailBean.getNickname());

        mSwtTop.setChecked(groupChatDetailBean.getTop() == 1);
        mSwtDoNotDisturb.setChecked(groupChatDetailBean.getDoNotDisturb() == 1);
        mSwtShowGroupChatMemberNickname.setChecked(groupChatDetailBean.getShowGroupChatMemberNickname() == 1);
        mTvNicknameInGroup.setText(groupChatDetailBean.getNicknameInGroupChat());
    }

    @Override
    public void getGroupChatDetailFailure(Exception e) {

    }

    @Override
    public void setTopSuccess() {
        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_CONVERSATION_LIST, null));
    }

    @Override
    public void setTopFailure(Exception e) {

    }

    @Override
    public void setDoNotDisturbSuccess() {
        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_CONVERSATION_LIST, null));
    }

    @Override
    public void setDoNotDisturbFailure(Exception e) {

    }

    @Override
    public void setShowGroupChatMemberNicknameSuccess() {
        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_MESSAGE_LIST, null));
    }

    @Override
    public void setShowGroupChatMemberNicknameFailure(Exception e) {

    }

    @Override
    public void exitSuccess() {
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_GROUP_CHAT_LIST, null));
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void exitFailure(Exception e) {

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
    public static void start(Context context, String groupChatId) {
        Bundle bundle = new Bundle();
        bundle.putString(GROUP_CHAT_ID, groupChatId);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , GroupChatSettingFragment.class
                , bundle));
    }
}
