package com.qinshou.qinshoubox.login.view.fragment;

import android.widget.Button;

import com.qinshou.commonmodule.background.Background;
import com.qinshou.commonmodule.background.BackgroundManager;
import com.qinshou.commonmodule.background.State;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/18 15:59
 * Description:未登录提示界面
 */
public class NotLoginFragment extends QSFragment<AbsPresenter> {

    @Background(solid = 0xFFFFFFFF, strokeColor = 0xFFE9403B, strokeWidth = 1, radius = 6)
    private Button mBtnLoginOrRegister;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_not_login;
    }

    @Override
    public void initView() {
        mBtnLoginOrRegister = findViewByID(R.id.btn_login_or_register);
        BackgroundManager.SINGLETON.init(this);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }
}
