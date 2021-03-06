package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.BaseItemView;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/7 20:23
 * Description:消息列表收到的消息的 ItemView 的基类
 */
public abstract class AbsRcvMessageAdapterFromMessageItemView extends BaseItemView<MessageBean> {
    private String mGroupChatId;
    private String[] mWeekArray;

    public AbsRcvMessageAdapterFromMessageItemView(Context context, int layoutId, String groupChatId) {
        super(context, layoutId);
        mGroupChatId = groupChatId;
        mWeekArray = context.getResources().getStringArray(R.array.conversation_tv_last_msg_time_text);
    }

    @Override
    public void bindViewHolder(BaseViewHolder baseViewHolder, MessageBean messageBean, int i) {
        setTime(baseViewHolder, messageBean, i);
        // 头像
        if (messageBean.getType() == MessageType.CHAT.getValue()) {
            UserDetailBean userDetailBean = IMClient.SINGLETON.getFriendManager().getById(messageBean.getFromUserId());
            if (userDetailBean != null) {
                ImageLoadUtil.SINGLETON.loadImage(getContext(), userDetailBean.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
            }
        } else if (messageBean.getType() == MessageType.GROUP_CHAT.getValue()) {
            if (!TextUtils.isEmpty(mGroupChatId)) {
                IMClient.SINGLETON.getGroupChatMemberManager().getByGroupChatIdAndUserId(mGroupChatId, messageBean.getFromUserId(), new QSCallback<UserDetailBean>() {
                    @Override
                    public void onSuccess(UserDetailBean data) {
                        ImageLoadUtil.SINGLETON.loadImage(getContext(), data.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });

            }
        }
//        // 单聊不显示昵称,群聊可以设置是否显示昵称
//        baseViewHolder.setVisibility(R.id.tv_nickname, messageBean.getType() == MessageBean.Type.CHAT.getValue() || ((RcvMessageAdapter) getRcvBaseAdapter()).isNotShowNickname()
//                ? View.GONE
//                : View.VISIBLE);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/9/16 15:06
     * Description:设置时间
     *
     * @param baseViewHolder description
     * @param messageBean    消息实体类
     * @param i              下标
     */
    void setTime(BaseViewHolder baseViewHolder, MessageBean messageBean, int i) {
        if (i == 0) {
            // 获取 Calendar 实例
            Calendar calendar = Calendar.getInstance();
            // Calendar 设置成当前时间
            calendar.setTime(new Date(System.currentTimeMillis()));
            // 获取当前时间是年份中第几天
            int currentDay = calendar.get(Calendar.DAY_OF_YEAR);
            // Calendar 设置成第一条消息的时间
            calendar.setTime(new Date(messageBean.getReceiveTimestamp()));
            // 获取第一条消息的时间是年份中第几天
            int day = calendar.get(Calendar.DAY_OF_YEAR);
            String time;
            // 0 表示上午,1 表示下午
            int amOrPm = calendar.get(Calendar.AM_PM);
            if (currentDay - day > 7) {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("yyyy-MM月dd日 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                } else {
                    time = new SimpleDateFormat("yyyy-MM月dd日 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                }
            } else if (currentDay - day > 1) {
                // 星期天为 1,依次增加,星期六为 7
                int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
                if (amOrPm == 0) {
                    time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " HH:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                } else {
                    time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " HH:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                }
            } else if (currentDay - day > 0) {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("昨天 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                } else {
                    time = new SimpleDateFormat("昨天 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                }
            } else {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                } else {
                    time = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                }
            }
            baseViewHolder.setTvText(R.id.tv_time, time);
            baseViewHolder.setVisibility(R.id.tv_time, View.VISIBLE);
            return;
        }
        // 前一条消息
        MessageBean previousMessageBean = getRcvBaseAdapter().getDataList().get(i - 1);
        // 与前一条消息的时间间隔
        long timeDiff;
        if (TextUtils.equals(previousMessageBean.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId())) {
            // 上一条消息是发送的,就和发送时间比较
            timeDiff = messageBean.getReceiveTimestamp() - previousMessageBean.getSendTimestamp();
        } else {
            // 上一条消息是收到的,就和接收时间比较
            timeDiff = messageBean.getReceiveTimestamp() - previousMessageBean.getReceiveTimestamp();
        }
        if (timeDiff <= 1000 * 60 * 5) {
            baseViewHolder.setVisibility(R.id.tv_time, View.GONE);
            return;
        }
        // 获取 Calendar 实例
        Calendar calendar = Calendar.getInstance();
        // Calendar 设置成当前时间
        calendar.setTime(new Date(System.currentTimeMillis()));
        // 获取当前时间是年份中第几天
        int currentDay = calendar.get(Calendar.DAY_OF_YEAR);
        // Calendar 设置成第一条消息的时间
        calendar.setTime(new Date(messageBean.getReceiveTimestamp()));
        // 获取第一条消息的时间是年份中第几天
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        String time;
        // 0 表示上午,1 表示下午
        int amOrPm = calendar.get(Calendar.AM_PM);
        if (currentDay - day > 7) {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("yyyy-MM月dd日 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            } else {
                time = new SimpleDateFormat("yyyy-MM月dd日 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            }
        } else if (currentDay - day > 1) {
            // 星期天为 1,依次增加,星期六为 7
            int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
            if (amOrPm == 0) {
                time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " HH:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            } else {
                time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " HH:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            }
        } else if (currentDay - day > 0) {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("昨天 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            } else {
                time = new SimpleDateFormat("昨天 HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            }
        } else {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            } else {
                time = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            }
        }
        baseViewHolder.setTvText(R.id.tv_time, time);
        baseViewHolder.setVisibility(R.id.tv_time, View.VISIBLE);
    }
}