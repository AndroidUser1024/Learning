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
import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.qinshoubox.me.ui.widget.SwitchButton;


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
//                ClearChatHistoryDialog.newInstance(mToUsername, null)
//                        .show(getChildFragmentManager(), "ClearChatHistoryDialog");
            }
        });
        mIvHeadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                UserDetailFragment.start(getContext(), UserDetailFragment.UserType.HUMAN, mToUsername);
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
        int toUserId = bundle.getInt(TO_USER_ID, 0);
        if (toUserId == 0) {
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
        mFriendBean.setTop(1);
    }

    @Override
    public void setTopFailure(Exception e) {

    }

    @Override
    public void setDoNotDisturbSuccess() {

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
     * @param context 上下文
     * @param id      好友 Id
     */
    public static void start(Context context, int id) {
        Bundle bundle = new Bundle();
        bundle.putInt(TO_USER_ID, id);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , ChatSettingFragment.class
                , bundle));
    }
}