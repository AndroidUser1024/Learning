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
import com.qinshou.commonmodule.util.activityresultutil.ActivityResultUtil;
import com.qinshou.commonmodule.util.activityresultutil.OnActivityResultCallBack;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.dialog.DeleteContactDialog;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.friend.contract.IUserDetailContract;
import com.qinshou.qinshoubox.friend.presenter.UserDetailPresenter;
import com.qinshou.qinshoubox.friend.view.activity.SetRemarkActivity;
import com.qinshou.qinshoubox.im.view.fragment.IMActivity;

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
    private ImageView mIvHeadImg;
    private TextView mTvRemark;
    private ImageView mIvGender;
    private TextView mTvUsername;
    private TextView mTvNickname;
    private LinearLayout mLlAdditionalMsg;
    private TextView mTvAdditionalMsg;
    private TextView mTvRemark2;
    private TextView mTvPhoneNumber;
    private TextView mTvEmail;
    private TextView mTvSignature;
    private TextView mTvSource;
    private Button mBtnAddFriend;
    private UserDetailBean mUserDetailBean;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_user_detail;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        mIvHeadImg = findViewByID(R.id.iv_head_img);
        mTvRemark = findViewByID(R.id.tv_remark);
        mIvGender = findViewByID(R.id.iv_gender);
        mTvUsername = findViewByID(R.id.tv_username);
        mTvNickname = findViewByID(R.id.tv_nickname);
        mLlAdditionalMsg = findViewByID(R.id.ll_additional_msg);
        mTvAdditionalMsg = findViewByID(R.id.tv_additional_msg);
        mTvRemark2 = findViewByID(R.id.tv_remark_2);
        mTvPhoneNumber = findViewByID(R.id.tv_phone_number);
        mTvEmail = findViewByID(R.id.tv_email);
        mTvSignature = findViewByID(R.id.tv_signature);
        mTvSource = findViewByID(R.id.tv_source);
        mBtnAddFriend = findViewByID(R.id.btn_add_friend);
    }

    @Override
    public void setListener() {
        ((TitleBar) findViewByID(R.id.title_bar)).setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewByID(R.id.ll_set_remark).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = SetRemarkActivity.getJumpIntent(getContext(), mTvRemark.getText().toString().trim());
                ActivityResultUtil.startActivityForResult(getActivity(), intent, SetRemarkActivity.REQUEST_CODE, new OnActivityResultCallBack() {
                    @Override
                    public void onActivityResult(int requestCode, int resultCode, Intent data) {
                        // 验证请求码和返回码
                        if (requestCode != SetRemarkActivity.REQUEST_CODE || resultCode != SetRemarkActivity.RESULT_CODE) {
                            return;
                        }
                        String remark = data.getStringExtra(SetRemarkActivity.NEW_REMARK);
                        if (!TextUtils.isEmpty(remark)) {
                            mTvRemark.setText(remark);
                            mTvRemark2.setText(remark);
                        }
                        if (mUserDetailBean.getFriendStatus() == 1) {
                            getPresenter().setRemark(mUserDetailBean.getId(), mTvRemark.getText().toString().trim());
                        }
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
    public void getUserDetailSuccess(UserDetailBean userDetailBean) {
        mUserDetailBean = userDetailBean;
        if (userDetailBean.getFriendStatus() == 1) {
            showFriendUI(userDetailBean);
        } else {
            if (userDetailBean.getReceive() == 1) {
                showWaitAcceptUI(userDetailBean);
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
        mBtnAddFriend.setText(getString(R.string.user_detail_btn_add_friend_text_2));
        mBtnAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_FRIEND_LIST, null));
                ChatActivity.start(getContext(), mUserDetailBean.getId());
            }
        });
    }

    @Override
    public void agreeAddFriendFailure(Exception e) {
        toastShort(e.getMessage());
    }

    @Override
    public void deleteFriendSuccess() {
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_FRIEND_LIST, null));
        startActivity(new Intent(getContext(), IMActivity.class));
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
        String source = "";
        if (userDetailBean.getSource() == 1) {
            source = "通过用户名添加";
        } else if (userDetailBean.getSource() == 2) {
            source = "通过手机号添加";
        } else if (userDetailBean.getSource() == 3) {
            source = "通过邮箱添加";
        } else if (userDetailBean.getSource() == 4) {
            source = "通过扫一扫添加";
        } else if (userDetailBean.getSource() == 5) {
            source = "通过群聊添加";
        } else if (userDetailBean.getSource() == -1) {
            source = "对方通过用户名添加";
        } else if (userDetailBean.getSource() == -2) {
            source = "对方通过手机号添加";
        } else if (userDetailBean.getSource() == -3) {
            source = "对方通过邮箱添加";
        } else if (userDetailBean.getSource() == -4) {
            source = "对方通过扫一扫添加";
        } else if (userDetailBean.getSource() == -5) {
            source = "对方通过群聊添加";
        }
        mTvSource.setText(source);
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
        String source = "";
        if (userDetailBean.getSource() == 1) {
            source = "通过用户名搜索";
        } else if (userDetailBean.getSource() == 2) {
            source = "通过手机号搜索";
        } else if (userDetailBean.getSource() == 3) {
            source = "通过邮箱搜索";
        }
        mTvSource.setText(source);
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
        String source = "";
        if (userDetailBean.getSource() == 1) {
            source = "通过用户名添加";
        } else if (userDetailBean.getSource() == 2) {
            source = "通过手机号添加";
        } else if (userDetailBean.getSource() == 3) {
            source = "通过邮箱添加";
        } else if (userDetailBean.getSource() == 4) {
            source = "通过扫一扫添加";
        } else if (userDetailBean.getSource() == 5) {
            source = "通过群聊添加";
        } else if (userDetailBean.getSource() == -1) {
            source = "对方通过用户名添加";
        } else if (userDetailBean.getSource() == -2) {
            source = "对方通过手机号添加";
        } else if (userDetailBean.getSource() == -3) {
            source = "对方通过邮箱添加";
        } else if (userDetailBean.getSource() == -4) {
            source = "对方通过扫一扫添加";
        } else if (userDetailBean.getSource() == -5) {
            source = "对方通过群聊添加";
        }
        mTvSource.setText(source);
    }

    private void setData(UserDetailBean userDetailBean) {
        // 头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), userDetailBean.getHeadImgSmall(), mIvHeadImg);
        // 备注
        mTvRemark.setText(TextUtils.isEmpty(userDetailBean.getRemark()) ? userDetailBean.getNickname() : userDetailBean.getRemark());
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
        mTvRemark2.setText(TextUtils.isEmpty(userDetailBean.getRemark()) ? "" : userDetailBean.getRemark());
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
                DeleteContactDialog deleteContactDialog = new DeleteContactDialog();
                deleteContactDialog.setTvDeleteOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getPresenter().deleteFriend(userDetailBean.getId());
                    }
                });
                deleteContactDialog.show(getChildFragmentManager(), "DeleteContactDialog");
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