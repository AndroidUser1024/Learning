package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.MediaPlayerHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.AbsDownloadCallback;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.bean.VoiceBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.util.QSUtil;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:32
 * Description:发送的消息,消息类型为语音
 */
public class RcvMessageAdapterToMessageVoiceItemView extends AbsRcvMessageAdapterToMessageItemView {
    private final RecyclerView mRecyclerView;
    private MessageBean mCurrentPlayMessageBean = null;

    public RcvMessageAdapterToMessageVoiceItemView(Context context, RecyclerView rcvMessage) {
        super(context, R.layout.item_rcv_message_to_message_voice);
        mRecyclerView = rcvMessage;
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户名不同,则是收到的消息
        // 且是语音类型
        return item.getContentType() == MessageContentType.VOICE.getValue()
                && TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId());
    }

    @Override
    public void bindViewHolder(BaseViewHolder baseViewHolder, final MessageBean messageBean, int i) {
        super.bindViewHolder(baseViewHolder, messageBean, i);
        // 语音
        VoiceBean voiceBean = new Gson().fromJson(messageBean.getExtend(), VoiceBean.class);
        StringBuilder stringBuilder = new StringBuilder();
        int time = (int) (voiceBean.getTime() / 1000);
        for (int a = 0; a < time; a++) {
            stringBuilder.append(" ");
        }
        baseViewHolder.setTvText(R.id.tv_placeholder, stringBuilder);
        baseViewHolder.setTvText(R.id.tv_voice_time, time + "\"");

        // 因为 item 的复用,虽然数据不会错乱,但是如果修改了一个 item 的控件
        // 那么复用该 ViewHolder 的 item 的状态和背景也会一起变化,所以需要设置当前条目的语音播放动画控件
        // 如果当前条目是正在播放的,则播放动画,否则设置静态图片
        if (messageBean == mCurrentPlayMessageBean) {
            updateVoiceUI(messageBean);
        } else {
            baseViewHolder.setIvImage(R.id.iv_voice_to, R.drawable.chat_iv_voice_to_3);
        }
        // 点击播放
        baseViewHolder.setOnClickListener(R.id.ll_content, new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //                 | --- 点击的 item 位置就是正在播放的 item 的位置 --- 停止播放
                // 当时是播放状态  |
                //                 | --- 点击的 item 位置不是正在播放的 item 的位置 --- 先停止上一个,再播放当前点击的
                // 当时是未播放状态,直接播放
                if (MediaPlayerHelper.SINGLETON.isPlaying()) {
                    if (messageBean == mCurrentPlayMessageBean) {
                        stopPlay(messageBean);
                    } else {
                        stopPlay(mCurrentPlayMessageBean);
                        startPlay(messageBean);
                    }
                } else {
                    startPlay(messageBean);
                }
            }
        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/19 15:38
     * Description:开始播放语音
     *
     * @param messageBean 待播放的那一条 message
     */
    private void startPlay(final MessageBean messageBean) {
        VoiceBean voiceBean = new Gson().fromJson(messageBean.getExtend(), VoiceBean.class);
        final MediaPlayerHelper.IOnMediaPlayerListener onMediaPlayerListener = new MediaPlayerHelper.IOnMediaPlayerListener() {
            @Override
            public void onStart(int totalProgress) {
                // 先赋值
                mCurrentPlayMessageBean = messageBean;
                // 再更新 UI
                updateVoiceUI(messageBean);
            }

            @Override
            public void onError() {
                stopPlay(messageBean);
            }

            @Override
            public void onComplete() {
                stopPlay(messageBean);
            }

            @Override
            public void onProgress(int progress, int totalProgress, int currentTimeMinute, final int currentTimeSecond, int totalTimeMinute, int totalTimeSecond) {
            }

            @Override
            public void onBufferingUpdate(int percent) {
            }
        };
        String fileName = voiceBean.getUrl().substring(voiceBean.getUrl().lastIndexOf("/") + "/".length());
        final File file = new File(QSUtil.getVoicePath(getContext(), messageBean.getType(), messageBean.getToUserId())
                + fileName);
        if (file.exists()) {
            MediaPlayerHelper.SINGLETON.playMusic(file.getAbsolutePath(), onMediaPlayerListener);
            return;
        }
        IMClient.SINGLETON.download(voiceBean.getUrl(), file, new AbsDownloadCallback() {
            @Override
            public void onStart(long length) {
                ShowLogUtil.logi("onStart: length--->" + length);
            }

            @Override
            public void onProgress(int progress) {
                ShowLogUtil.logi("onProgress: progress--->" + progress);
            }

            @Override
            public void onSuccess(File file) {
                ShowLogUtil.logi("onSuccess");

            }

            @Override
            public void onFailure(Exception e) {
                ShowLogUtil.logi("onFailure: e--->" + e.getMessage());
            }
        }, new QSCallback<File>() {
            @Override
            public void onSuccess(File data) {
                MediaPlayerHelper.SINGLETON.playMusic(data.getAbsolutePath(), onMediaPlayerListener);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/19 15:38
     * Description:停止播放语音
     *
     * @param messageBean 待停止的那一条 message
     */
    private void stopPlay(MessageBean messageBean) {
        MediaPlayerHelper.SINGLETON.stop();
        mCurrentPlayMessageBean = null;
        updateVoiceUI(messageBean);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/19 15:39
     * Description:更新 UI
     *
     * @param messageBean 待更新的那一条 message
     */
    private void updateVoiceUI(MessageBean messageBean) {
        // 获取目标 messageBean 在数据集合中的位置
        int position = getRcvBaseAdapter().getDataList().indexOf(messageBean);
        // 找到对应 ViewHolder
        RecyclerView.ViewHolder viewHolderForAdapterPosition = mRecyclerView.findViewHolderForAdapterPosition(position);
        if (viewHolderForAdapterPosition == null) {
            return;
        }
        if (!(viewHolderForAdapterPosition instanceof BaseViewHolder)) {
            return;
        }
        BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolderForAdapterPosition;
        final ImageView ivVoiceFrom = baseViewHolder.getImageView(R.id.iv_voice_to);
        if (ivVoiceFrom == null) {
            return;
        }
        // 如果需要更新 UI 的条目就是当前正在播放的,则播放动画,否则修改为静态图片
        if (messageBean == mCurrentPlayMessageBean) {
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_to_1), 300);
            animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_to_2), 300);
            animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_to_3), 300);
            animationDrawable.setOneShot(false);
            ivVoiceFrom.setImageDrawable(animationDrawable);
            animationDrawable.start();
        } else {
            ivVoiceFrom.setImageResource(R.drawable.chat_iv_voice_to_3);
        }
    }

    public void setCurrentPlayMessageBean(MessageBean sCurrentPlayMessageBean) {
        mCurrentPlayMessageBean = sCurrentPlayMessageBean;
    }

    public MessageBean getCurrentPlayMessageBean() {
        return mCurrentPlayMessageBean;
    }
}
