package com.qinshou.qinshoubox.conversation.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.contract.IChatSettingContract;
import com.qinshou.qinshoubox.conversation.presenter.ChatSettingPresenter;
import com.qinshou.qinshoubox.conversation.view.dialog.ClearChatHistoryDialog;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.me.ui.widget.SwitchButton;

import org.greenrobot.eventbus.EventBus;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/03 15:05
 * Description:聊天设置界面
 */
public class ChatSettingFragment extends QSFragment<ChatSettingPresenter> implements IChatSettingContract.IView {
    public static final String TO_USER_ID = "ToUserId";
    /**
     * 头像
     */
    private ImageView mIvHeadImg;
    /**
     * 昵称
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
     * 加入黑名单开关
     */
    private SwitchButton mSwtBlackList;
    private FriendBean mFriendBean;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_chat_setting;
    }

    @Override
    public void initView() {
        mIvHeadImg = findViewByID(R.id.iv_head_img);
        mTvNickname = findViewByID(R.id.tv_nickname);
        mSwtTop = findViewByID(R.id.swt_top);
        mSwtDoNotDisturb = findViewByID(R.id.swt_do_not_disturb);
        mSwtBlackList = findViewByID(R.id.swt_black_list);
    }

    @Override
    public void setListener() {
        super.setListener();
        ((TitleBar) findViewByID(R.id.title_bar)).setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewByID(R.id.ll_chat_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ChatHistoryFragment.start(getContext(), mToUsername, mTvNickname.getText().toString());
            }
        });
        mSwtTop.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                getPresenter().setTop(mFriendBean.getId(), checked ? 1 : 0);
            }
        });
        mSwtDoNotDisturb.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                getPresenter().setDoNotDisturb(mFriendBean.getId(), checked ? 1 : 0);
            }
        });
        mSwtBlackList.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(boolean checked, boolean fromUser) {
                if (!fromUser) {
                    return;
                }
                getPresenter().setBlackList(mFriendBean.getId(), checked ? 1 : 0);
            }
        });
        findViewByID(R.id.ll_clear_chat_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = TextUtils.isEmpty(mFriendBean.getRemark())
                        ? mFriendBean.getNickname()
                        : mFriendBean.getRemark();
                ClearChatHistoryDialog.newInstance(MessageType.CHAT, mFriendBean.getId(), nickname)
                        .show(getChildFragmentManager(), "ClearChatHistoryDialog");
            }
        });
        mIvHeadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetailFragment.start(getContext(), mFriendBean.getId());
            }
        });
        // 发起群聊
        findViewByID(R.id.btn_join_group_chat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        String toUserId = bundle.getString(TO_USER_ID);
        if (TextUtils.isEmpty(toUserId)) {
            return;
        }
        getPresenter().getFriend(toUserId);
    }


    @Override
    public void getFriendSuccess(FriendBean friendBean) {
        mFriendBean = friendBean;
        ImageLoadUtil.SINGLETON.loadImage(getContext(), friendBean.getHeadImgSmall(), mIvHeadImg);
        mTvNickname.setText(TextUtils.isEmpty(friendBean.getRemark()) ? friendBean.getNickname() : friendBean.getRemark());
        mSwtTop.setChecked(friendBean.getTop() == 1);
        mSwtDoNotDisturb.setChecked(friendBean.getDoNotDisturb() == 1);
        mSwtBlackList.setChecked(friendBean.getBlackList() == 1);
    }

    @Override
    public void getFriendFailure(Exception e) {

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
    public void setBlackListSuccess() {
    }

    @Override
    public void setBlackListFailure(Exception e) {

    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/3 15:09
     * Description:获取跳转到该界面需要传递的 Bundle
     *
     * @param context  上下文
     * @param toUserId 好友 Id
     */
    public static void start(Context context, String toUserId) {
        Bundle bundle = new Bundle();
        bundle.putString(TO_USER_ID, toUserId);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , ChatSettingFragment.class
                , bundle));
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() != EventBean.Type.REFRESH_FRIEND_LIST) {
            return;
        }
        getPresenter().getFriend(mFriendBean.getId());
    }
}