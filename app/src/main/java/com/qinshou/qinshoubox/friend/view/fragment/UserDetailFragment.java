package com.qinshou.qinshoubox.friend.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.activityresultutil.ActivityResultUtil;
import com.qinshou.commonmodule.util.activityresultutil.OnActivityResultCallBack;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.contract.IUserDetailContract;
import com.qinshou.qinshoubox.friend.presenter.UserDetailPresenter;
import com.qinshou.qinshoubox.friend.view.activity.SetRemarkActivity;
import com.qinshou.qinshoubox.friend.view.dialog.DeleteFriendDialog;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.enums.FriendSource;
import com.qinshou.qinshoubox.im.enums.UserSource;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;

import org.greenrobot.eventbus.EventBus;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:用户详情界面
 */
public class UserDetailFragment extends QSFragment<UserDetailPresenter> implements IUserDetailContract.IView {
    private static final String KEYWORD = "Keyword";

    private TitleBar mTitleBar;
    /**
     * 头像
     */
    private ImageView mIvHeadImg;
    /**
     * 备注或者昵称
     */
    private TextView mTvRemarkOrNickname;
    /**
     * 性别
     */
    private ImageView mIvGender;
    /**
     * 用户名
     */
    private TextView mTvUsername;
    /**
     * 昵称
     */
    private TextView mTvNickname;
    private LinearLayout mLlAdditionalMsg;
    /**
     * 附加验证信息
     */
    private TextView mTvAdditionalMsg;
    /**
     * 备注
     */
    private TextView mTvRemark;
    /**
     * 手机号码
     */
    private TextView mTvPhoneNumber;
    /**
     * 邮箱
     */
    private TextView mTvEmail;
    /**
     * 个性签名
     */
    private TextView mTvSignature;
    /**
     * 用户来源
     */
    private TextView mTvSource;
    /**
     * 添加好友/接受请求/发送消息按钮
     */
    private Button mBtnAddFriend;
    /**
     * 用户详情实体类
     */
    private UserDetailBean mUserDetailBean;
    private IOnFriendStatusListener mOnFriendStatusListener = new IOnFriendStatusListener() {
        @Override
        public void add(UserDetailBean fromUser, boolean newFriend) {
        }

        @Override
        public void agreeAdd(UserDetailBean fromUser) {
            if (TextUtils.equals(fromUser.getId(), mUserDetailBean.getId())) {
                // 监听到发起的添加请求被同意了,更新 UI
                showFriendUI(mUserDetailBean);
            }
        }

        @Override
        public void refuseAdd(UserDetailBean fromUser) {
        }

        @Override
        public void delete(UserDetailBean fromUser) {
        }

        @Override
        public void online(UserDetailBean fromUser) {
        }

        @Override
        public void offline(UserDetailBean fromUser) {
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        IMClient.SINGLETON.removeOnFriendStatusListener(mOnFriendStatusListener);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_detail;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        mIvHeadImg = findViewByID(R.id.iv_head_img);
        mTvRemarkOrNickname = findViewByID(R.id.tv_remark_or_nickname);
        mIvGender = findViewByID(R.id.iv_gender);
        mTvUsername = findViewByID(R.id.tv_username);
        mTvNickname = findViewByID(R.id.tv_nickname);
        mLlAdditionalMsg = findViewByID(R.id.ll_additional_msg);
        mTvAdditionalMsg = findViewByID(R.id.tv_additional_msg);
        mTvRemark = findViewByID(R.id.tv_remark);
        mTvPhoneNumber = findViewByID(R.id.tv_phone_number);
        mTvEmail = findViewByID(R.id.tv_email);
        mTvSignature = findViewByID(R.id.tv_signature);
        mTvSource = findViewByID(R.id.tv_source);
        mBtnAddFriend = findViewByID(R.id.btn_add_friend);
    }

    @Override
    public void setListener() {
        IMClient.SINGLETON.addOnFriendStatusListener(mOnFriendStatusListener);
        ((TitleBar) findViewByID(R.id.title_bar)).setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewByID(R.id.ll_set_remark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SetRemarkActivity.getJumpIntent(getContext(), mUserDetailBean.getRemark());
                ActivityResultUtil.startActivityForResult(getActivity(), intent, SetRemarkActivity.REQUEST_CODE, new OnActivityResultCallBack() {
                    @Override
                    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                        // 验证请求码和返回码
                        if (requestCode != SetRemarkActivity.REQUEST_CODE || resultCode != SetRemarkActivity.RESULT_CODE) {
                            return;
                        }
                        String remark = data.getStringExtra(SetRemarkActivity.NEW_REMARK);
                        // 设置新备注,是允许为空的
                        mTvRemark.setText(remark);
                        if (TextUtils.isEmpty(remark)) {
                            mTvRemarkOrNickname.setText(mUserDetailBean.getNickname());
                        } else {
                            mTvRemarkOrNickname.setText(remark);
                        }
                        getPresenter().setRemark(mUserDetailBean.getId(), remark);
                    }
                });
            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        String keyword = bundle.getString(KEYWORD);
        if (TextUtils.isEmpty(keyword)) {
            return;
        }
        getPresenter().getUserDetail(keyword);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    @Override
    public void getUserDetailSuccess(UserDetailBean userDetailBean) {
        mUserDetailBean = userDetailBean;
        if (userDetailBean.getReceive() == 1) {
            showWaitAcceptUI(userDetailBean);
        } else {
            if (userDetailBean.getStatus() == 1 || userDetailBean.getStatus() == 3) {
                showFriendUI(userDetailBean);
            } else {
                showNotFriendUI(userDetailBean);
            }
        }
    }

    @Override
    public void getUserDetailFailure(Exception e) {

    }

    @Override
    public void agreeAddFriendSuccess() {
        showFriendUI(mUserDetailBean);
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_FRIEND_LIST, mUserDetailBean.getId()));
    }

    @Override
    public void agreeAddFriendFailure(Exception e) {
        toastShort(e.getMessage());
    }

    @Override
    public void deleteFriendSuccess() {
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_FRIEND_LIST, null));
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_CONVERSATION_LIST, null));
        startActivity(new Intent(getContext(), MainActivity.class));
    }

    @Override
    public void deleteFriendFailure(Exception e) {
        toastShort(e.getMessage());
    }

    @Override
    public void setRemarkSuccess() {
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_FRIEND_LIST, null));
    }

    @Override
    public void setRemarkFailure(Exception e) {

    }

    private void showFriendUI(final UserDetailBean userDetailBean) {
        mTitleBar.setRightImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(userDetailBean);
            }
        });
        setData(userDetailBean);
        mLlAdditionalMsg.setVisibility(View.GONE);
        mBtnAddFriend.setText(getString(R.string.user_detail_btn_add_friend_text_2));
        mBtnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatActivity.start(getContext(), userDetailBean.getId());
            }
        });
        // 用户来源
        FriendSource friendSource = FriendSource.getByValue(userDetailBean.getSource());
        if (friendSource != null) {
            mTvSource.setText(friendSource.getDesc());
        }
    }

    private void showNotFriendUI(final UserDetailBean userDetailBean) {
        setData(userDetailBean);
        mLlAdditionalMsg.setVisibility(View.GONE);
        mBtnAddFriend.setText(getString(R.string.user_detail_btn_add_friend_text));
        mBtnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetAdditionalMsgFragment.start(getContext()
                        , userDetailBean.getId()
                        , mTvRemark.getText().toString().trim()
                        , userDetailBean.getSource()
                );
            }
        });
        UserSource userSource = UserSource.getByValue(userDetailBean.getSource());
        if (userSource != null) {
            mTvSource.setText(userSource.getDesc());
        }
    }

    private void showWaitAcceptUI(final UserDetailBean userDetailBean) {
        setData(userDetailBean);
        mLlAdditionalMsg.setVisibility(View.VISIBLE);
        mBtnAddFriend.setText(getString(R.string.user_detail_btn_add_friend_text_3));
        mBtnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().agreeAddFriend(userDetailBean.getId(), mTvRemark.getText().toString().trim());
            }
        });
        // 用户来源
        FriendSource friendSource = FriendSource.getByValue(userDetailBean.getSource());
        if (friendSource != null) {
            mTvSource.setText(friendSource.getDesc());
        }
    }

    private void setData(UserDetailBean userDetailBean) {
        // 头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), userDetailBean.getHeadImgSmall(), mIvHeadImg);
        // 备注
        mTvRemarkOrNickname.setText(TextUtils.isEmpty(userDetailBean.getRemark()) ? userDetailBean.getNickname() : userDetailBean.getRemark());
        // 0 为其他,1 为女,2 为男
        if (userDetailBean.getGender() == 1) {
            mIvGender.setImageResource(R.drawable.user_detail_iv_gender_src);
        } else {
            mIvGender.setImageResource(R.drawable.user_detail_iv_gender_src_2);
        }
        // 账号
        mTvUsername.setText(userDetailBean.getUsername());
        // 昵称
        mTvNickname.setText(userDetailBean.getNickname());
        // 附加消息
        mTvAdditionalMsg.setText(userDetailBean.getAdditionalMsg());
        // 功能栏的备注
        mTvRemark.setText(TextUtils.isEmpty(userDetailBean.getRemark()) ? "" : userDetailBean.getRemark());
        // 手机号
        mTvPhoneNumber.setText(userDetailBean.getPhoneNumber());
        // 邮箱
        mTvEmail.setText(userDetailBean.getEmail());
        // 个性签名
        mTvSignature.setText(userDetailBean.getSignature());
    }

    private void showPopupWindow(final UserDetailBean userDetailBean) {
        final PopupWindow popupWindow = new PopupWindow();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.ppw_user_detail_more, null);
        LinearLayout llDeleteContact = view.findViewById(R.id.ll_delete_contact);
        llDeleteContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteFriendDialog deleteFriendDialog = new DeleteFriendDialog();
                deleteFriendDialog.setTvDeleteOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().deleteFriend(userDetailBean.getId());
                    }
                });
                deleteFriendDialog.show(getChildFragmentManager(), "DeleteFriendDialog");
                popupWindow.dismiss();
            }
        });
        // PopupWindow 设置内容布局
        popupWindow.setContentView(view);
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        // PopupWindow 设置宽高
        popupWindow.setWidth(view.getMeasuredWidth());
        popupWindow.setHeight(view.getMeasuredHeight());
        // PopupWindow 获取焦点
        popupWindow.setFocusable(true);
        // PopupWindow 点击外部消失
        popupWindow.setOutsideTouchable(true);
        ImageView ivRight = mTitleBar.findViewById(R.id.iv_right);
        popupWindow.showAsDropDown(ivRight);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/12 9:20
     * Description:跳转到该界面
     *
     * @param context 上下文
     * @param keyword 用户名,可以是系统账号/手机号/邮箱
     */
    public static void start(Context context, String keyword) {
        Bundle bundle = new Bundle();
        bundle.putString(KEYWORD, keyword);
        context.startActivity(ContainerActivity.getJumpIntent(context, UserDetailFragment.class, bundle));
    }
}