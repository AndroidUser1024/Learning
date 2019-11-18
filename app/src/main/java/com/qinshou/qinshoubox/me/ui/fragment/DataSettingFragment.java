package com.qinshou.qinshoubox.me.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.me.bean.UserBean;
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getLayoutId() {
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
        findViewByID(R.id.ll_head_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ContainerActivity.getJumpIntent(getContext(), PersonalHeadImgFragment.class));
            }
        });
        findViewByID(R.id.ll_nickname).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = mTvNickname.getText().toString().trim();
                SetNameFragment.start(getContext(), nickname);
            }
        });
        findViewByID(R.id.ll_qr_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ContainerActivity.getJumpIntent(getContext(), MyQRCodeFragment.class));
            }
        });
    }

    @Override
    public void initData() {
        final UserBean userBean = UserStatusManager.SINGLETON.getUserBean();
        ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImgSmall(), mIvHeadImg);
        mTvUsername.setText(userBean.getUsername());
        mTvNickname.setText(userBean.getNickname());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateUserBean(UserBean userBean) {
        initData();
    }
}