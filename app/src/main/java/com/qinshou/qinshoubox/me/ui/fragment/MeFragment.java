package com.qinshou.qinshoubox.me.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.me.contract.IMeContract;
import com.qinshou.qinshoubox.me.presenter.MePresenter;
import com.qinshou.qinshoubox.me.ui.activity.ChartActivity;
import com.qinshou.qinshoubox.me.ui.activity.ContactListActivity;
import com.qinshou.qinshoubox.me.ui.activity.PeiQiActivity;
import com.qinshou.qinshoubox.me.ui.activity.PuzzleActivity;
import com.qinshou.qinshoubox.me.ui.activity.TurningRobotActivity;
import com.qinshou.qinshoubox.me.ui.activity.WeatherActivity;
import com.qinshou.qinshoubox.me.ui.activity.WheelOfFortuneActivity;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;
import com.qinshou.qrcodemodule.QRCodeScanActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Description:"我"界面
 * Created by 禽兽先生
 * Created on 2018/4/7
 */

public class MeFragment extends QSFragment<MePresenter> implements IMeContract.IView {

    /**
     * 头像
     */
    private ImageView mIvHeadImg;
    private ImageButton ibLoginByUsernamePassword;
    private ImageButton ibLoginByQq;
    private ImageButton ibLoginByWechat;
    private ImageButton ibLoginByWeibo;
    private Button btnTurningRobot;
    private Button btnMagicTower;
    private Button btnPuzzle;
    private Button btnContactList;
    private Button btnWeather;
    private Button mBtnWheelOfFortune;
    private Button mBtnChart;
    private Button mBtnQRCodeScan;
    private Button mBtnPeiQi;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.iv_head_img:
                case R.id.tv_click_2_login:
                case R.id.tv_login_2_have_more_function:
                    UserStatusManager.SINGLETON.jump2DataSetting(getContext());
                    break;
                case R.id.iv_im:
                    UserStatusManager.SINGLETON.jump2IM(getContext());
                    break;
//                case R.id.ib_login_by_qq:
//                    break;
//                case R.id.ib_login_by_wechat:
//                    break;
//                case R.id.ib_login_by_weibo:
                case R.id.btn_puzzle:
                    startActivity(new Intent(getContext(), PuzzleActivity.class));
                    break;
                case R.id.btn_turning_robot:
                    startActivity(new Intent(getContext(), TurningRobotActivity.class));
                    break;
                case R.id.btn_magic_tower:
//                    startActivity(new Intent(getContext(), MagicTowerActivity.class));
                    break;
                case R.id.btn_contact_list:
                    startActivity(new Intent(getContext(), ContactListActivity.class));
                    break;
                case R.id.btn_weather:
                    startActivity(new Intent(getContext(), WeatherActivity.class));
                    break;
                case R.id.btn_wheel_of_fortune:
                    startActivity(new Intent(getContext(), WheelOfFortuneActivity.class));
                    break;
                case R.id.btn_chart:
                    startActivity(new Intent(getContext(), ChartActivity.class));
                    break;
                case R.id.btn_qr_code_scan:
                    startActivity(new Intent(getContext(), QRCodeScanActivity.class));
                    break;
                case R.id.btn_pei_qi:
                    startActivity(new Intent(getContext(), PeiQiActivity.class));
                    break;
                case R.id.btn_test:
                    startActivity(ContainerActivity.getJumpIntent(getContext(), TestFragment.class));
                    break;
                default:
                    break;

            }
        }
    };
    private TextView mTvNickname;
    private TextView mTvUsername;

    @Override
    public int initStatusBarColor() {
        return 0xFFFFFFFF;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }


    @Override
    public void initView() {
        mIvHeadImg = findViewByID(R.id.iv_head_img);
        mTvNickname = findViewByID(R.id.tv_click_2_login);
        mTvUsername = findViewByID(R.id.tv_login_2_have_more_function);
//        ibLoginByUsernamePassword = findViewByID(R.id.ib_login_by_username_password);
//        ibLoginByQq = findViewByID(R.id.ib_login_by_qq);
//        ibLoginByWechat = findViewByID(R.id.ib_login_by_wechat);
//        ibLoginByWeibo = findViewByID(R.id.ib_login_by_weibo);
        btnPuzzle = findViewByID(R.id.btn_puzzle);
        btnTurningRobot = findViewByID(R.id.btn_turning_robot);
        btnMagicTower = findViewByID(R.id.btn_magic_tower);
        btnContactList = findViewByID(R.id.btn_contact_list);
        btnWeather = findViewByID(R.id.btn_weather);
        mBtnWheelOfFortune = findViewByID(R.id.btn_wheel_of_fortune);
        mBtnChart = findViewByID(R.id.btn_chart);
        mBtnQRCodeScan = findViewByID(R.id.btn_qr_code_scan);
        mBtnPeiQi = findViewByID(R.id.btn_pei_qi);
    }

    @Override
    public void setListener() {
        mIvHeadImg.setOnClickListener(mOnClickListener);
        findViewByID(R.id.tv_click_2_login).setOnClickListener(mOnClickListener);
        findViewByID(R.id.tv_login_2_have_more_function).setOnClickListener(mOnClickListener);
        findViewByID(R.id.iv_im).setOnClickListener(mOnClickListener);
//        ibLoginByQq.setOnClickListener(mOnClickListener);
//        ibLoginByWechat.setOnClickListener(mOnClickListener);
//        ibLoginByWeibo.setOnClickListener(mOnClickListener);
        btnTurningRobot.setOnClickListener(mOnClickListener);
        btnMagicTower.setOnClickListener(mOnClickListener);
        btnPuzzle.setOnClickListener(mOnClickListener);
        btnContactList.setOnClickListener(mOnClickListener);
        btnWeather.setOnClickListener(mOnClickListener);
        mBtnWheelOfFortune.setOnClickListener(mOnClickListener);
        mBtnChart.setOnClickListener(mOnClickListener);
        mBtnQRCodeScan.setOnClickListener(mOnClickListener);
        mBtnPeiQi.setOnClickListener(mOnClickListener);
        findViewByID(R.id.btn_test).setOnClickListener(mOnClickListener);
    }

    @Override
    public void initData() {

    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
        if (eventBean.getType() == EventBean.Type.LOGIN || eventBean.getType() == EventBean.Type.REFRESH_USER_BEAN) {
            UserBean userBean = UserStatusManager.SINGLETON.getUserBean();
            ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImgSmall(), mIvHeadImg);
            mTvNickname.setText(userBean.getNickname());
            mTvUsername.setText(userBean.getUsername());
        } else if (eventBean.getType() == EventBean.Type.LOGOUT) {
            ImageLoadUtil.SINGLETON.loadImage(getContext(), R.drawable.default_head_img, mIvHeadImg);
            mTvNickname.setText(getString(R.string.me_tv_click_2_login_text));
            mTvUsername.setText(getString(R.string.me_tv_login_2_have_more_function_text));
        }
    }
}
