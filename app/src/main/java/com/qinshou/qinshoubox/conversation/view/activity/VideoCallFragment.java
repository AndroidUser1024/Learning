package com.qinshou.qinshoubox.conversation.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.SurfaceView;

import com.qinshou.commonmodule.ContainerActivity;
import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.contract.IVideoCallContract;
import com.qinshou.qinshoubox.conversation.presenter.VideoCallPresenter;
import com.qinshou.qinshoubox.conversation.view.fragment.ChatSettingFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/9 16:12
 * Description:视频通话界面
 */
public class VideoCallFragment extends AbsMVPFragment<VideoCallPresenter> implements IVideoCallContract.IView {
    private static final String TO_USER_ID = "toUserId";

    private SurfaceView mSv1;
    private SurfaceView mSv2;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_video_call;
    }

    @Override
    public void initView() {
        mSv1 = findViewByID(R.id.sv_1);
        mSv2 = findViewByID(R.id.sv_2);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }

    public static void start(Context context, String toUserId) {
        Bundle bundle = new Bundle();
        bundle.putString(TO_USER_ID, toUserId);
        context.startActivity(ContainerActivity.getJumpIntent(context
                , VideoCallFragment.class
                , bundle));
        context.startActivity(ContainerActivity.getJumpIntent(context, VideoCallFragment.class));
    }
}
