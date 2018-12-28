package com.qinshou.qinshoubox.me.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseFragment;
import com.qinshou.qinshoubox.me.ui.activity.ContactListActivity;
import com.qinshou.qinshoubox.me.ui.activity.MagicTowerActivity;
import com.qinshou.qinshoubox.me.ui.activity.PuzzleActivity;
import com.qinshou.qinshoubox.me.ui.activity.TestActivity;
import com.qinshou.qinshoubox.me.ui.activity.TurningRobotActivity;
import com.qinshou.qinshoubox.me.ui.activity.WeatherActivity;

/**
 * Description:"我"界面
 * Created by 禽兽先生
 * Created on 2018/4/7
 */

public class MeFragment extends MyBaseFragment {

    private ImageButton ibLoginByUsernamePassword;
    private ImageButton ibLoginByQq;
    private ImageButton ibLoginByWechat;
    private ImageButton ibLoginByWeibo;
    private Button btnTurningRobot;
    private Button btnMagicTower;
    private Button btnPuzzle;
    private Button btnContactList;
    private Button btnWeather;

    @Override
    public boolean getIsImmersive() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        ibLoginByUsernamePassword = findViewByID(R.id.ib_login_by_username_password);
        ibLoginByQq = findViewByID(R.id.ib_login_by_qq);
        ibLoginByWechat = findViewByID(R.id.ib_login_by_wechat);
        ibLoginByWeibo = findViewByID(R.id.ib_login_by_weibo);
        btnPuzzle = findViewByID(R.id.btn_puzzle);
        btnTurningRobot = findViewByID(R.id.btn_turning_robot);
        btnMagicTower = findViewByID(R.id.btn_magic_tower);
        btnContactList = findViewByID(R.id.btn_contact_list);
        btnWeather = findViewByID(R.id.btn_weather);
    }

    @Override
    public void setListener() {
        ibLoginByUsernamePassword.setOnClickListener(mOnClickListener);
        ibLoginByQq.setOnClickListener(mOnClickListener);
        ibLoginByWechat.setOnClickListener(mOnClickListener);
        ibLoginByWeibo.setOnClickListener(mOnClickListener);
        btnTurningRobot.setOnClickListener(mOnClickListener);
        btnMagicTower.setOnClickListener(mOnClickListener);
        btnPuzzle.setOnClickListener(mOnClickListener);
        btnContactList.setOnClickListener(mOnClickListener);
        btnWeather.setOnClickListener(mOnClickListener);
    }

    @Override
    public void initData() {
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            switch (v.getId()) {
                case R.id.btn_puzzle:
                    startActivity(new Intent(getContext(), PuzzleActivity.class));
                    break;
                case R.id.btn_turning_robot:
                    startActivity(new Intent(getContext(), TurningRobotActivity.class));
                    break;
                case R.id.btn_magic_tower:
                    startActivity(new Intent(getContext(), MagicTowerActivity.class));
                    break;
                case R.id.btn_contact_list:
                    startActivity(new Intent(getContext(), ContactListActivity.class));
                    break;
                case R.id.btn_weather:
                    startActivity(new Intent(getContext(), WeatherActivity.class));
                    break;
                case R.id.ib_login_by_username_password:
                    startActivity(new Intent(getContext(), TestActivity.class));
//                    EMClient.getInstance().login("cqflqinhao", "123456", new EMCallBack() {//回调
//                        @Override
//                        public void onSuccess() {
//                            EMClient.getInstance().groupManager().loadAllGroups();
//                            EMClient.getInstance().chatManager().loadAllConversations();
//                            ShowLogUtil.logi("登录聊天服务器成功！");
//                        }
//
//                        @Override
//                        public void onProgress(int progress, String status) {
//
//                        }
//
//                        @Override
//                        public void onError(int code, String message) {
//                            ShowLogUtil.logi("登录聊天服务器失败！");
//                        }
//                    });
                    break;
                case R.id.ib_login_by_qq:
                    break;
                case R.id.ib_login_by_wechat:
                    break;
                case R.id.ib_login_by_weibo:
                    break;
                default:
                    break;

            }
        }
    };

    /**
     * Description:选择手机中的图片并进行裁剪
     * Date:2018/7/10
     */
    private void chooseImage() {
    }
}
