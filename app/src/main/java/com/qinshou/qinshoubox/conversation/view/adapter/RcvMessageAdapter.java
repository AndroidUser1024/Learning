package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.qinshou.commonmodule.rcvbaseadapter.RcvMultipleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.MediaPlayerHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.AbsDownloadCallback;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.bean.VoiceBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.util.QSUtil;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:29
 * Description:消息列表适配器
 */
public class RcvMessageAdapter extends RcvMultipleBaseAdapter<MessageBean> {
    private RecyclerView mRcvMessage;
    /**
     * 当前播放语音的位置
     */
    private int mCurrentPlayPosition = -1;
    /**
     * 当前播放的语音是发出去的还是收到的,true 表示收到的,false 表示发出去的
     */
    private boolean mCurrentFrom = false;

    public RcvMessageAdapter(final Context context, RecyclerView rcvMessage) {
        this(context, rcvMessage, null);
    }

    public RcvMessageAdapter(final Context context, RecyclerView rcvMessage, String groupChatId) {
        super(context);
        // 添加不同类型的 item
        addItemView(new RcvMessageAdapterToMessageTextItemView(context));
        addItemView(new RcvMessageAdapterToMessageVoiceItemView(context));
        addItemView(new RcvMessageAdapterToMessageImgItemView(context));
        addItemView(new RcvMessageAdapterFromMessageTextItemView(context, groupChatId));
        addItemView(new RcvMessageAdapterFromMessageSystemItemView(context, groupChatId));
        addItemView(new RcvMessageAdapterFromMessageVoiceItemView(context, groupChatId));
        addItemView(new RcvMessageAdapterFromMessageImgItemView(context, groupChatId));
    }

    public void playVoice(BaseViewHolder baseViewHolder, MessageBean messageBean, int position, boolean from) {
        if (mCurrentPlayPosition != -1) {
            // 当前是播放状态
            if (position == mCurrentPlayPosition) {
                // 点击的 item 位置就是正在播放的 item 的位置 --- 停止播放
                stopPlayVoice(baseViewHolder, from);
            } else {
                // 点击的 item 位置不是正在播放的 item 的位置 --- 先停止上一个,再播放当前点击的
                notifyItemChanged(mCurrentPlayPosition);
                BaseViewHolder lastBaseViewHolder = (BaseViewHolder) mRcvMessage.findViewHolderForAdapterPosition(mCurrentPlayPosition);
                stopPlayVoice(lastBaseViewHolder, mCurrentFrom);
                startPlayVoice(baseViewHolder, messageBean, position, from);
            }
        } else {
            // 当时是未播放状态,直接播放
            startPlayVoice(baseViewHolder, messageBean, position, from);
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/6 11:32
     * Description:开始播放语音
     *
     * @param baseViewHolder 对应 ViewHolder
     * @param messageBean    对应消息实体类
     * @param position       对应位置
     * @param from           是否是发出去的语音
     */
    private void startPlayVoice(final BaseViewHolder baseViewHolder, MessageBean messageBean, int position, final boolean from) {
        mCurrentPlayPosition = position;
        mCurrentFrom = from;
        VoiceBean voiceBean = new Gson().fromJson(messageBean.getExtend(), VoiceBean.class);
        final MediaPlayerHelper.IOnMediaPlayerListener onMediaPlayerListener = new MediaPlayerHelper.IOnMediaPlayerListener() {
            @Override
            public void onStart(int totalProgress) {
                updateVoiceUI(baseViewHolder, from, true);
            }

            @Override
            public void onError() {
                stopPlayVoice(baseViewHolder, from);
            }

            @Override
            public void onComplete() {
                stopPlayVoice(baseViewHolder, from);
            }

            @Override
            public void onProgress(int currentPosition, int duration, int currentHour, int currentTimeMinute, int currentTimeSecond, int totalTimeHour, int totalTimeMinute, int totalTimeSecond) {

            }

            @Override
            public void onBufferingUpdate(int percent) {
            }
        };
        String fileName = voiceBean.getUrl().substring(voiceBean.getUrl().lastIndexOf("/") + "/".length());
        File file = new File(QSUtil.getVoicePath(getContext(), messageBean.getType(), messageBean.getFromUserId())
                + fileName);
        if (file.exists()) {
            MediaPlayerHelper.SINGLETON.playMusic(file.getAbsolutePath(), onMediaPlayerListener);
            return;
        }
//        IMClient.SINGLETON.download(voiceBean.getUrl(), file, new AbsDownloadCallback() {
//            @Override
//            public void onStart(long length) {
//                ShowLogUtil.logi("onStart: length--->" + length);
//            }
//
//            @Override
//            public void onProgress(int progress) {
//                ShowLogUtil.logi("onProgress: progress--->" + progress);
//            }
//
//            @Override
//            public void onSuccess(File file) {
//                ShowLogUtil.logi("onSuccess");
//
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                ShowLogUtil.logi("onFailure: e--->" + e.getMessage());
//            }
//        }, new Callback<File>() {
//            @Override
//            public void onSuccess(File data) {
//                MediaPlayerHelper.SINGLETON.playMusic(data.getAbsolutePath(), onMediaPlayerListener);
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//
//            }
//        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/6 11:32
     * Description:停止播放语音
     *
     * @param baseViewHolder 对应 ViewHolder
     * @param from           是否是发出去的语音
     */
    public void stopPlayVoice(BaseViewHolder baseViewHolder, boolean from) {
        MediaPlayerHelper.SINGLETON.stop();
        updateVoiceUI(baseViewHolder, from, false);
        mCurrentPlayPosition = -1;
        mCurrentFrom = false;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/19 15:39
     * Description:更新 UI
     *
     * @param baseViewHolder 对应 ViewHolder
     * @param from           是否是发出去的语音
     * @param play           播放还是停止,true 表示播放,false 表示停止
     */
    public void updateVoiceUI(BaseViewHolder baseViewHolder, boolean from, boolean play) {
        if (baseViewHolder == null) {
            return;
        }
        final ImageView ivVoice;
        // 如果需要更新 UI 的条目就是当前正在播放的,则播放动画,否则修改为静态图片
        if (play) {
            AnimationDrawable animationDrawable = new AnimationDrawable();
            animationDrawable.setOneShot(false);
            if (from) {
                ivVoice = baseViewHolder.getImageView(R.id.iv_voice_from);
                animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_from_1), 300);
                animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_from_2), 300);
                animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_from_3), 300);
            } else {
                ivVoice = baseViewHolder.getImageView(R.id.iv_voice_to);
                animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_to_1), 300);
                animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_to_2), 300);
                animationDrawable.addFrame(getContext().getDrawable(R.drawable.chat_iv_voice_to_3), 300);
            }
            if (ivVoice == null) {
                return;
            }
            ivVoice.setImageDrawable(animationDrawable);
            animationDrawable.start();
        } else {
            int imageResource = 0;
            if (from) {
                ivVoice = baseViewHolder.getImageView(R.id.iv_voice_from);
                imageResource = R.drawable.chat_iv_voice_from_3;
            } else {
                ivVoice = baseViewHolder.getImageView(R.id.iv_voice_to);
                imageResource = R.drawable.chat_iv_voice_to_3;
            }
            if (ivVoice == null) {
                return;
            }
            ivVoice.setImageResource(imageResource);
        }
    }

    public int getCurrentPlayPosition() {
        return mCurrentPlayPosition;
    }

    public boolean isCurrentFrom() {
        return mCurrentFrom;
    }
}
