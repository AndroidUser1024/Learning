package com.qinshou.qinshoubox.me.ui.fragment;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.contract.IKlotskiContract;
import com.qinshou.qinshoubox.me.presenter.KlotskiPresenter;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/05/18 17:55
 * Description:华容道界面
 */
public class KlotskiFragment extends QSFragment<KlotskiPresenter> implements IKlotskiContract.IView {

    @Override
    public int getLayoutId() {
        return R.layout.fragment_klotski;
    }

    @Override
    public void initView() {
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