package com.qinshou.qinshoubox.login.view.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jeejio.dbmodule.DatabaseManager;
import com.jeejio.dbmodule.dao.IBaseDao;
import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.widget.CountDownView;
import com.qinshou.qinshoubox.MainActivity;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.login.bean.PoemBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.contract.ISplashContract;
import com.qinshou.qinshoubox.login.presenter.SplashPresenter;
import com.qinshou.qinshoubox.login.view.fragment.LoginOrRegisterFragment;
import com.qinshou.qinshoubox.util.EncryptUtil;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Description:闪屏界面
 * Author: QinHao
 * Date: 2019/4/4 19:24
 */
public class SplashActivity extends QSActivity<SplashPresenter> implements ISplashContract.ISplashView {
    private CountDownView mCountDownView;
    private TextView mTvContent;
    private TextView mTvTitle;
    private TextView mTvAuthor;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        mCountDownView = findViewByID(R.id.count_down_view);
        mTvContent = findViewByID(R.id.tv_content);
        mTvTitle = findViewByID(R.id.tv_title);
        mTvAuthor = findViewByID(R.id.tv_author);
    }

    @Override
    public void setListener() {
        mCountDownView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumpToMainActivity();
            }
        });
        mCountDownView.setOnCountDownListener(new CountDownView.onCountDownListener() {
            @Override
            public void onTick(int tick) {

            }

            @Override
            public void onFinish() {
                jumpToMainActivity();
            }
        });
    }

    @Override
    public void initData() {
        getPresenter().getRandomPoem();
        IBaseDao<UserDetailBean> userDetailBeanDao = DatabaseManager.getInstance().getDaoByClass(UserDetailBean.class);
//        for (int i = 0; i < 1000; i++) {
//            UserDetailBean userDetailBean = new UserDetailBean();
//            userDetailBean.setId(i + "");
//            userDetailBean.setUsername("cqflqinhao" + i + i + i + i);
//            userDetailBean.setNickname("Mr禽兽" + i + "号");
//            userDetailBeanDao.insert(userDetailBean);
//        }
//
//        List<UserDetailBean> userDetailBeanList = userDetailBeanDao.selectList();
//        for (int i = 0; i < userDetailBeanList.size(); i++) {
//            ShowLogUtil.logi("userDetailBeanList.get(i)--->" + userDetailBeanList.get(i));
//        }

//        UserDetailBean userDetailBean = userDetailBeanDao.selectById("999");
//        ShowLogUtil.logi("userDetailBean--->" + userDetailBean);
//        userDetailBean.setGender(100);
//        userDetailBeanDao.update(userDetailBean);
//        userDetailBean = userDetailBeanDao.selectById("999");
//        ShowLogUtil.logi("userDetailBean--->" + userDetailBean);

        UserDetailBean userDetailBean = userDetailBeanDao.selectById("998");
        userDetailBeanDao.delete(userDetailBean);
    }

    @Override
    public void onAuthenticated() {
        super.onAuthenticated();
        startActivity(new Intent(getContext(), MainActivity.class));
        finish();
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    private void jumpToMainActivity() {
        if (isFinishing()) {
            return;
        }
        String username = SharedPreferencesHelper.SINGLETON.getString(IConstant.SP_KEY_LAST_LOGIN_USERNAME);
        String password = SharedPreferencesHelper.SINGLETON.getString(IConstant.SP_KEY_LAST_LOGIN_PASSWORD);
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            // 对存储的密码进行解密,并自动登录
            getPresenter().login(username, EncryptUtil.decrypt(password));
        } else {
            startActivity(ContainerActivity.getJumpIntent(getContext(), LoginOrRegisterFragment.class));
//        startActivity(new Intent(getContext(), MainActivity.class));
            finish();
        }
    }

    @Override
    public void getRandomSuccess(PoemBean poemBean) {
        String content = poemBean.getContent();
        content = content.replace("，", "\n")
                .replace("。", "\n");
        String[] split = content.split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append(split[i]);
            if (i == 2) {
                break;
            } else {
                stringBuilder.append("\n");
            }
        }
        mTvContent.setText(stringBuilder);
        mTvTitle.setText("--" + poemBean.getTitle());
        mTvAuthor.setText("--" + poemBean.getAuthor());
    }

    @Override
    public void getRandomFailure(Exception e) {

    }

    @Override
    public void loginSuccess(UserBean userBean) {
        ShowLogUtil.logi("loginSuccess" + " : " + "userBean--->" + userBean);
        UserStatusManager.SINGLETON.setUserBean(userBean);

        // 连接 IM 服务
        IMClient.SINGLETON.connect(userBean.getId());
    }

    @Override
    public void loginFailure(Exception e) {
        ShowLogUtil.logi("loginFailure" + " : " + "e--->" + e.getMessage());
        toastShort(e.getMessage());
        // 刪除保存的密码,这样下次打开应用就不会自动登录了
        SharedPreferencesHelper.SINGLETON.remove(IConstant.SP_KEY_LAST_LOGIN_PASSWORD);
        startActivity(ContainerActivity.getJumpIntent(getContext(), LoginOrRegisterFragment.class));
        finish();
    }
}
