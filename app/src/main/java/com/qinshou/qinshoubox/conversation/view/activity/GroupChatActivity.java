package com.qinshou.qinshoubox.conversation.view.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qinshou.commonmodule.util.MediaPlayerHelper;
import com.qinshou.commonmodule.util.MediaRecorderHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.SoftKeyboardUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.commonmodule.util.permissionutil.IOnRequestPermissionResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.db.dao.impl.GroupChatDaoImpl;
import com.qinshou.immodule.enums.MessageContentType;
import com.qinshou.immodule.enums.MessageType;
import com.qinshou.immodule.listener.IOnMessageListener;
import com.qinshou.immodule.manager.ChatManager;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatContract;
import com.qinshou.qinshoubox.conversation.presenter.GroupChatPresenter;
import com.qinshou.qinshoubox.listener.ClearErrorInfoTextWatcher;
import com.qinshou.qinshoubox.me.ui.adapter.RcvMessageAdapter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:群聊界面
 */
public class GroupChatActivity extends QSActivity<GroupChatPresenter> implements IGroupChatContract.IView {
    private static final String TO_USER_ID = "ToUserId";
    private final int VOICE_MAX_TIME = 1000 * 60;
    private final int MESSAGE_WHAT_VOLUME_LEVEL = 1;
    private final int MESSAGE_WHAT_SEND_VOICE = 2;
    /**
     * 打开系统图库界面的意图的请求码
     */
    private final int PICK_PHOTO_REQUEST_CODE = 100;
    /**
     * 接收消息方的用户名
     */
    private int mToUserId;
    /**
     * 标题栏
     */
    private TitleBar mTitleBar;
    private RcvMessageAdapter mRcvMessageAdapter;
    private RefreshLayout mRefreshLayout;
    private RecyclerView mRcvMessage;
    /**
     * 消息类型的指示图标
     */
    private ImageView mIvContentType;
    /**
     * 消息输入框
     */
    private EditText mEtContent;
    /**
     * 按住说话按钮
     */
    private Button mBtnPressToSpeech;
    /**
     * 更多按钮
     */
    private ImageView mIvMore;
    /**
     * 发送按钮
     */
    private Button mBtnSend;
    /**
     * 发送语音时的音量和上滑取消的提示布局
     */
    private LinearLayout mLlSendVoicePrompt;
    /**
     * 发送语音时音量提示的外部布局
     */
    private LinearLayout mLlVolume;
    /**
     * 语音音量变化图标
     */
    private ImageView mIvVolume;
    /**
     * 取消发送的提示文字的文本框
     */
    private TextView mTvCancelSendPrompt;
    /**
     * 取消发送生效的图片区域
     */
    private ImageView mIvCancelSend;
    /**
     * 更多功能
     */
    private LinearLayout mLlMore;
    //    /**
//     * 会话实体类
//     */
//    private ConversationBean mConversationBean;
    private int mPage = IConstant.PAGE_START;
    /**
     * 消息模式,默认文本模式
     */
    private MessageContentType mMessageContentType = MessageContentType.TEXT;
    /**
     * 是否发送语音的标志位
     */
    private boolean sendVoice = false;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == MESSAGE_WHAT_VOLUME_LEVEL) {
                int level = (int) msg.obj;
                switch (level) {
                    case 1:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_1);
                        break;
                    case 2:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_2);
                        break;
                    case 3:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_3);
                        break;
                    case 4:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_4);
                        break;
                    case 5:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_5);
                        break;
                    case 6:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_6);
                        break;
                    default:
                        mIvVolume.setImageResource(R.drawable.chat_iv_volume_src_1);
                        break;
                }
            } else if (msg.what == MESSAGE_WHAT_SEND_VOICE) {
                if (!sendVoice) {
                    return true;
                }
                Map<String, Object> map = (Map<String, Object>) msg.obj;
                File file = (File) map.get("file");
                long recordTime = (long) map.get("recordTime");
                if (file == null) {
                    return true;
                }
//                MessageBean message = MessageBean.createVoiceMessage(mToUserId, recordTime, file.getAbsolutePath());
//                JMClient.SINGLETON.getChatManager().sendVoiceMessage(message, file, recordTime, new JMCallback<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        ShowLogUtil.logi("发送失败--->" + e.getMessage());
//                    }
//                });
//                mRcvMessageAdapter.getDataList().add(message);
//                mRcvMessageAdapter.notifyItemInserted(mRcvMessageAdapter.getDataList().size() - 1);
//                // 消息列表滚动到底部
//                mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
            }
            return true;
        }
    });
    /**
     * 停止播放语音的线程
     */
    private Runnable mStopRecordRunnable = new Runnable() {
        @Override
        public void run() {
            MediaRecorderHelper.SINGLETON.stopRecord();
        }
    };

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.iv_content_type:
                    showTextOrVoiceType();
                    break;
                case R.id.et_content:
                    // 点击输入框会弹出软键盘,然后遮挡 RecyclerView 部分内容
                    // 延时 100ms 再将 RecyclerView 消息列表滚动到底部
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // 隐藏更多功能布局
                            mLlMore.setVisibility(View.GONE);
                            mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
                        }
                    }, 100);
                    break;
                case R.id.iv_more:
                    if (mLlMore.getVisibility() == View.GONE) {
                        mLlMore.setVisibility(View.VISIBLE);
                        SoftKeyboardUtil.hideSoftKeyboard(getActivity());
                        mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
                    } else {
                        mLlMore.setVisibility(View.GONE);
                    }
                    break;
                case R.id.btn_send:
                    sendMessage();
                    break;
                case R.id.ll_send_img:
                    pickPhoto();
                    break;
            }
        }
    };
    /**
     * 按住说话按钮触摸监听器
     */
    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            float x, y;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mLlSendVoicePrompt.setVisibility(View.VISIBLE);
                    mBtnPressToSpeech.setText(getString(R.string.chat_btn_press_to_speech_text2));
                    mBtnPressToSpeech.setSelected(true);
                    sendVoice = true;
                    File file = new File(getActivity().getCacheDir()
                            + File.separator
                            + "Audio"
                            + File.separator
                            + System.currentTimeMillis()
                            + ".m4a");
                    MediaRecorderHelper.SINGLETON.startRecordAudio(file, new MediaRecorderHelper.IOnMediaRecorderListener() {
                        @Override
                        public void onStart() {
                        }

                        @Override
                        public void onError(String errorInfo) {
                        }

                        @Override
                        public void onStop(final File file, final long recordTime) {
                            mHandler.removeCallbacks(mStopRecordRunnable);
                            Map<String, Object> map = new HashMap<>();
                            map.put("file", file);
                            map.put("recordTime", recordTime);
                            Message.obtain(mHandler, MESSAGE_WHAT_SEND_VOICE, map).sendToTarget();
                        }

                        @Override
                        public void onVolumeChange(int currentVolume) {
                            final int level = (int) ((double) currentVolume / (double) MediaRecorderHelper.MAX_AMPLITUDE * 6 + 1);
                            Message.obtain(mHandler, MESSAGE_WHAT_VOLUME_LEVEL, level).sendToTarget();
                        }
                    });
                    mHandler.postDelayed(mStopRecordRunnable, VOICE_MAX_TIME);
                    break;
                case MotionEvent.ACTION_MOVE:
                    mBtnPressToSpeech.setSelected(true);
                    x = event.getRawX();
                    y = event.getRawY();
                    // 触摸点在屏幕高度 3/4 以上时,显示取消发送语音的界面
                    if (y < SystemUtil.getRealScreenHeight(getContext()) / 4 * 3) {
                        showCancelSendVoiceLayout(x, y);
                    } else {
                        showSendVoiceLayout();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    mLlSendVoicePrompt.setVisibility(View.GONE);
                    mIvCancelSend.setVisibility(View.GONE);
                    mBtnPressToSpeech.setText(getString(R.string.chat_btn_press_to_speech_text));
                    mBtnPressToSpeech.setSelected(false);
                    MediaRecorderHelper.SINGLETON.stopRecord();
                    x = event.getRawX();
                    y = event.getRawY();
                    if (x > mIvCancelSend.getLeft()
                            && x < mIvCancelSend.getRight()
                            && y > mIvCancelSend.getTop() + SystemUtil.getStatusBarHeight(getContext())
                            && y < mIvCancelSend.getBottom() + SystemUtil.getStatusBarHeight(getContext())) {
                        // 在取消发送生效的图片区域内,不发送语音
                        sendVoice = false;
                    }
                    MediaRecorderHelper.SINGLETON.stopRecord();
                    break;
            }
            return false;
        }
    };
    private IOnMessageListener mOnMessageListener = new IOnMessageListener() {
        @Override
        public void onMessage(MessageBean messageBean) {
            // 不是当前群聊的消息,不添加到列表中
            if (messageBean.getType() != MessageType.GROUP_CHAT.getValue() || mToUserId != messageBean.getToUserId()) {
                return;
            }
            mRcvMessageAdapter.getDataList().add(messageBean);
            mRcvMessageAdapter.notifyItemInserted(mRcvMessageAdapter.getDataList().size() - 1);
            // 消息列表滚动到底部
            mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        ChatManager.SINGLETON.removeOnMessageListener(mOnMessageListener);
        MediaPlayerHelper.SINGLETON.stop();
        MediaRecorderHelper.SINGLETON.stopRecord();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_group_chat;
    }

    @Override
    public void initView() {
        PermissionUtil.requestPermission(getSupportFragmentManager(), new IOnRequestPermissionResultCallBack() {
            @Override
            public void onSuccess() {
                ShowLogUtil.logi("获取录音权限成功");
            }

            @Override
            public void onFailure(List<String> deniedPermissionList) {
                ShowLogUtil.logi("onFailure");
                ShowLogUtil.logi("获取录音权限失败");
                if (getActivity() != null) {
                    finish();
                }
            }
        }, Manifest.permission.RECORD_AUDIO);
        mTitleBar = findViewByID(R.id.title_bar);
        mRefreshLayout = findViewByID(R.id.refresh_layout);
        mRefreshLayout.canLoadMore(false);
        mRcvMessage = findViewByID(R.id.rcv_message);
        mRcvMessage.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcvMessageAdapter = new RcvMessageAdapter(getContext());
        mRcvMessage.setAdapter(mRcvMessageAdapter);
        mIvContentType = findViewByID(R.id.iv_content_type);
        mEtContent = findViewByID(R.id.et_content);
        mBtnPressToSpeech = findViewByID(R.id.btn_press_to_speech);
        mIvMore = findViewByID(R.id.iv_more);
        mBtnSend = findViewByID(R.id.btn_send);
        mLlSendVoicePrompt = findViewByID(R.id.ll_send_voice_prompt);
        mLlVolume = findViewByID(R.id.ll_volume);
        mIvVolume = findViewByID(R.id.iv_volume);
        mTvCancelSendPrompt = findViewByID(R.id.tv_cancel_send_voice_prompt);
        mIvCancelSend = findViewByID(R.id.iv_cancel_send);
        mLlMore = findViewByID(R.id.ll_more);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void setListener() {
        ChatManager.SINGLETON.addOnMessageListener(mOnMessageListener);
        mTitleBar.setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        mTitleBar.setRightImageOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ChatSettingFragment.start(getContext(), mToUserId);
//            }
//        });

        mIvContentType.setOnClickListener(mOnClickListener);
        mBtnPressToSpeech.setOnTouchListener(mOnTouchListener);
        mRefreshLayout.setOnRefreshLoadMoreListener(new RefreshLayout.IOnRefreshLoadMoreListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                mPage++;
                // 加载消息列表
                getPresenter().getMessageList(MessageType.GROUP_CHAT.getValue(), mToUserId, mPage, IConstant.PAGE_SIZE);
            }

            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {

            }
        });
        mEtContent.setOnClickListener(mOnClickListener);
        mEtContent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // 输入框获取焦点会弹出软键盘,然后遮挡 RecyclerView 部分内容
                if (!hasFocus) {
                    return;
                }
                // 延时 100ms 再将 RecyclerView 消息列表滚动到底部
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 隐藏更多功能布局
                        mLlMore.setVisibility(View.GONE);
                        mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
                    }
                }, 100);
            }
        });
        mRcvMessage.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                // 用户滑动聊天列表,关闭软键盘
                if (newState == RecyclerView.SCROLL_STATE_DRAGGING) {
                    // 隐藏更多功能布局
                    mLlMore.setVisibility(View.GONE);
                    SoftKeyboardUtil.hideSoftKeyboard(getActivity());
                }
            }
        });
        // 监听软键盘右下角按键
        mEtContent.addTextChangedListener(new ClearErrorInfoTextWatcher(null) {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                super.onTextChanged(s, start, before, count);
                if (TextUtils.isEmpty(mEtContent.getText().toString().trim())) {
                    mBtnSend.setVisibility(View.GONE);
                    mIvMore.setVisibility(View.VISIBLE);
                } else {
                    mBtnSend.setVisibility(View.VISIBLE);
                    mIvMore.setVisibility(View.GONE);
                }
            }
        });
        mIvMore.setOnClickListener(mOnClickListener);
        mBtnSend.setOnClickListener(mOnClickListener);
        findViewByID(R.id.ll_send_img).setOnClickListener(mOnClickListener);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        mToUserId = intent.getIntExtra(TO_USER_ID, 0);
        if (mToUserId == 0) {
            return;
        }
        GroupChatBean groupChatBean = new GroupChatDaoImpl().getById(mToUserId);
        if (groupChatBean != null) {
            // 群昵称
            mTitleBar.setTitleText(TextUtils.isEmpty(groupChatBean.getNickname())
                    ? groupChatBean.getNicknameDefault()
                    : groupChatBean.getNickname());
        }
//        mConversationBean = JMClient.SINGLETON.getConversationManager().getByToUsername(mToUserId);
//        // 重置未读数
//        if (mConversationBean != null) {
//            JMClient.SINGLETON.getConversationManager().resetUnreadCount(mConversationBean.getId());
//        }
        // 加载消息列表
        getPresenter().getMessageList(MessageType.GROUP_CHAT.getValue(), mToUserId, mPage, IConstant.PAGE_SIZE);
    }


    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/10 16:28
     * Description:发送消息
     */
    private void sendMessage() {
        String content = mEtContent.getText().toString().trim();
        if (TextUtils.isEmpty(content)) {
            toastShort(getString(R.string.chat_toast_can_not_send_empty_message_text));
            return;
        }
        MessageBean messageBean = null;
        if (mMessageContentType == MessageContentType.TEXT) {
            messageBean = MessageBean.createTextMessage(mToUserId, content);
            messageBean.setType(MessageType.GROUP_CHAT.getValue());
            ChatManager.SINGLETON.sendMessage(messageBean);
        }
        mRcvMessageAdapter.getDataList().add(messageBean);
        mRcvMessageAdapter.notifyItemInserted(mRcvMessageAdapter.getDataList().size() - 1);
        // 消息列表滚动到底部
        mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
        mEtContent.setText("");
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/24 13:42
     * Description:显示文本或者语音输入模式
     */
    private void showTextOrVoiceType() {
        if (mMessageContentType == MessageContentType.TEXT) {
            // 切换为发送语音模式
            // 隐藏软键盘
            SoftKeyboardUtil.hideSoftKeyboard(getActivity());
            mIvContentType.setImageResource(R.drawable.chat_iv_content_type_src_text);
            mMessageContentType = MessageContentType.VOICE;
            mEtContent.setVisibility(View.GONE);
            mEtContent.setHint("");
            mBtnPressToSpeech.setVisibility(View.VISIBLE);
            // 隐藏更多功能布局
            mLlMore.setVisibility(View.GONE);
        } else if (mMessageContentType == MessageContentType.VOICE) {
            // 切换为发送文本模式
            // 显示软键盘
            SoftKeyboardUtil.showSoftKeyboard(getActivity(), mEtContent);
            mIvContentType.setImageResource(R.drawable.chat_iv_content_type_src_voice);
            mMessageContentType = MessageContentType.TEXT;
            mEtContent.setVisibility(View.VISIBLE);
            mEtContent.setHint("");
            mBtnPressToSpeech.setVisibility(View.GONE);
            // 隐藏更多功能布局
            mLlMore.setVisibility(View.GONE);
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/24 15:19
     * Description:显示取消发送语音的布局,即发送语音时,手指上滑后的布局
     *
     * @param x 触摸点 x 坐标
     * @param y 触摸点 y 坐标
     */
    private void showCancelSendVoiceLayout(float x, float y) {
        mLlSendVoicePrompt.setBackgroundColor(0xF2424242);
        mLlVolume.setBackgroundResource(0);
        mTvCancelSendPrompt.setText(getString(R.string.chat_tv_cancel_send_voice_prompt_text_2));
        mIvCancelSend.setVisibility(View.VISIBLE);
        if (x > mIvCancelSend.getLeft()
                && x < mIvCancelSend.getRight()
                && y > mIvCancelSend.getTop() + SystemUtil.getStatusBarHeight(getContext())
                && y < mIvCancelSend.getBottom() + SystemUtil.getStatusBarHeight(getContext())) {
            mIvCancelSend.setImageResource(R.drawable.chat_iv_cancel_send_voice_src_2);
        } else {
            mIvCancelSend.setImageResource(R.drawable.chat_iv_cancel_send_voice_src);
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/24 15:20
     * Description:显示发送语音,手指并没有上滑时的布局
     */

    private void showSendVoiceLayout() {
        mLlSendVoicePrompt.setBackgroundColor(0x00000000);
        mLlVolume.setBackgroundResource(R.drawable.chat_ll_volume_bg);
        mTvCancelSendPrompt.setText(getString(R.string.chat_tv_cancel_send_voice_prompt_text));
        mIvCancelSend.setVisibility(View.GONE);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/5 9:36
     * Description: 选择照片
     */
    private void pickPhoto() {
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/3 15:09
     * Description:获取跳转到该界面的 Intent
     *
     * @param context  上下文
     * @param toUserId 对方的用户 Id
     */
    public static void start(Context context, int toUserId) {
        Intent intent = new Intent(context, GroupChatActivity.class);
        intent.putExtra(TO_USER_ID, toUserId);
        context.startActivity(intent);
    }

    @Override
    public void getMessageListSuccess(List<MessageBean> messageBeanList) {
        mRcvMessageAdapter.getDataList().addAll(0, messageBeanList);
        mRcvMessageAdapter.notifyItemRangeInserted(0, messageBeanList.size());
        if (mPage == 0) {
            // 消息列表滚动到底部
            mRcvMessage.scrollToPosition(mRcvMessageAdapter.getItemCount() - 1);
        } else {
            if (messageBeanList.size() == 0) {
                toastShort(getString(R.string.chat_toast_no_more_message_text));
            }
        }
        // 停止下拉刷新和上拉加载
        mRefreshLayout.stopRefreshAndLoadMore();
    }

    @Override
    public void getMessageListFailure(Exception e) {

    }
}