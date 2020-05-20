package com.qinshou.qinshoubox.me.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.contract.IKlotskiContract;
import com.qinshou.qinshoubox.me.presenter.KlotskiPresenter;
import com.qinshou.qinshoubox.me.ui.widget.KlotskiView;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/05/18 17:55
 * Description:华容道界面
 */
public class KlotskiFragment extends QSFragment<KlotskiPresenter> implements IKlotskiContract.IView {

    private KlotskiView mKlotskiView;
    private TextView mTvStep;
    private TextView mTvTime;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_klotski;
    }

    @Override
    public void initView() {
        mKlotskiView = findViewByID(R.id.klotski);
        mTvStep = findViewByID(R.id.tv_step);
        mTvStep.setText(getString(R.string.klotski_tv_step_text, 0));
        mTvTime = findViewByID(R.id.tv_time);
    }

    @Override
    public void setListener() {
        mKlotskiView.setOnCountCallback(new KlotskiView.IOnCountCallback() {
            @Override
            public void onCount(int count) {
                mTvStep.setText(getString(R.string.klotski_tv_step_text, count));
                ShowLogUtil.logi("count--->" + count);
            }
        });
        findViewByID(R.id.btn_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mKlotskiView.startGame();
            }
        });
    }

    @Override
    public void initData() {
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }
}