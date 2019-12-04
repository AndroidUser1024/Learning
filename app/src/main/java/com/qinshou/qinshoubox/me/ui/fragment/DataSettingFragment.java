package com.qinshou.qinshoubox.me.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IDataSettingContract;
import com.qinshou.qinshoubox.me.presenter.DataSettingPresenter;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/19 15:56
 * Description:资料设置界面
 */
public class DataSettingFragment extends QSFragment<DataSettingPresenter> implements IDataSettingContract.IView {
    /**
     * 本人头像
     */
    private ImageView mIvHeadImg;
    /**
     * 本人昵称
     */
    private TextView mTvNickname;
    /**
     * 本人系统账号
     */
    private TextView mTvUsername;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ll_head_img:
                    startActivity(ContainerActivity.getJumpIntent(getContext(), PersonalHeadImgFragment.class));
                    break;
                case R.id.ll_nickname:
                    String nickname = mTvNickname.getText().toString().trim();
                    SetNameFragment.start(getContext(), nickname);
                    break;
                case R.id.ll_qr_code:
                    startActivity(ContainerActivity.getJumpIntent(getContext(), MyQRCodeFragment.class));
                    break;
                case R.id.btn_logout:
                    getPresenter().logout(UserStatusManager.SINGLETON.getUserBean().getUsername());
                    UserStatusManager.SINGLETON.logout(getContext());
                    break;
            }
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public int getLayoutId() {
        EventBus.getDefault().register(this);
        return R.layout.fragment_data_setting;
    }

    @Override
    public void initView() {
        mIvHeadImg = findViewByID(R.id.iv_head_img);
        mTvNickname = findViewByID(R.id.tv_nickname);
        mTvUsername = findViewByID(R.id.tv_username);
    }

    @Override
    public void setListener() {
        ((TitleBar) findViewByID(R.id.title_bar)).setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewByID(R.id.ll_head_img).setOnClickListener(mOnClickListener);
        findViewByID(R.id.ll_nickname).setOnClickListener(mOnClickListener);
        findViewByID(R.id.ll_qr_code).setOnClickListener(mOnClickListener);
        findViewByID(R.id.btn_logout).setOnClickListener(mOnClickListener);
    }

    @Override
    public void initData() {
        UserBean userBean = UserStatusManager.SINGLETON.getUserBean();
        if (userBean == null) {
            ImageLoadUtil.SINGLETON.loadImage(getContext(), R.drawable.default_head_img, mIvHeadImg);
            mTvNickname.setText(getString(R.string.me_tv_click_2_login_text));
            mTvUsername.setText(getString(R.string.me_tv_login_2_have_more_function_text));
        } else {
            ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImgSmall(), mIvHeadImg);
            mTvNickname.setText(userBean.getNickname());
            mTvUsername.setText(userBean.getUsername());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void receiveEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.REFRESH_USER_BEAN) {
            UserBean userBean = UserStatusManager.SINGLETON.getUserBean();
            ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImgSmall(), mIvHeadImg);
            mTvNickname.setText(userBean.getNickname());
            mTvUsername.setText(userBean.getUsername());
        }
    }
}