package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.BaseItemView;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:32
 * Description:发送的消息
 */
public class RcvMessageAdapterToMessageItemView extends BaseItemView<MessageBean> {
    private String[] mWeekArray;

    public RcvMessageAdapterToMessageItemView(Context context) {
        super(context, R.layout.item_rcv_message_to_message);
        mWeekArray = context.getResources().getStringArray(R.array.conversation_tv_last_msg_time_text);
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户 id 相同,则是发送的消息
        return TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId());
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, final int i) {
        setTime(baseViewHolder, messageBean, i);
        // 头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), UserStatusManager.SINGLETON.getUserBean().getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
//        // 单聊不显示昵称,群聊才显示昵称
//        baseViewHolder.setVisibility(R.id.tv_nickname, messageBean.getType() == MessageType.CHAT.getValue()
//                ? View.GONE
//                : View.VISIBLE);
        // 昵称
//        baseViewHolder.setTvText(R.id.tv_nickname, JMClient.SINGLETON.getUserBean().getUserName());
        // 消息内容
        final TextView tvContent = baseViewHolder.findViewById(R.id.tv_content);
        // 普通文本
        tvContent.setText(messageBean.getContent());
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
    private void setTime(BaseViewHolder baseViewHolder, MessageBean messageBean, int i) {
        if (i == 0) {
            // 第一条消息
            // 获取 Calendar 实例
            Calendar calendar = Calendar.getInstance();
            // Calendar 设置成当前时间
            calendar.setTime(new Date(System.currentTimeMillis()));
            // 获取当前时间是年份中第几天
            int currentDay = calendar.get(Calendar.DAY_OF_YEAR);
            // Calendar 设置成第一条消息的时间
            calendar.setTime(new Date(messageBean.getSendTimestamp()));
            // 获取第一条消息的时间是年份中第几天
            int day = calendar.get(Calendar.DAY_OF_YEAR);
            String time;
            // 0 表示上午,1 表示下午
            int amOrPm = calendar.get(Calendar.AM_PM);
            if (currentDay - day > 7) {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("yyyy年MM月dd日 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                } else {
                    time = new SimpleDateFormat("yyyy年MM月dd日 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                }
            } else if (currentDay - day > 1) {
                // 星期天为 1,依次增加,星期六为 7
                int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
                if (amOrPm == 0) {
                    time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                } else {
                    time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                }
            } else if (currentDay - day > 0) {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("昨天 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                } else {
                    time = new SimpleDateFormat("昨天 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                }
            } else {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                } else {
                    time = new SimpleDateFormat("下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
                }
            }
            baseViewHolder.setTvText(R.id.tv_time, time);
            baseViewHolder.setVisibility(R.id.tv_time, View.VISIBLE);
            return;
        }
        // 前一条消息
        MessageBean previousMessageBean = getRcvBaseAdapter().getDataList().get(i - 1);
        // 与前一条消息的时间间隔
        long timeDiff = 0;
//        if (previousMessageBean.getFromUserId() == UserStatusManager.SINGLETON.getUserBean().getId()) {
//            // 上一条消息是发送的,就和发送时间比较
//            timeDiff = messageBean.getSendTimestamp() - previousMessageBean.getSendTimestamp();
//        } else {
//            // 上一条消息是收到的,就和接收时间比较
//            timeDiff = messageBean.getSendTimestamp() - previousMessageBean.getReceiveTimestamp();
//        }
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
        calendar.setTime(new Date(messageBean.getSendTimestamp()));
        // 获取第一条消息的时间是年份中第几天
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        String time;
        // 0 表示上午,1 表示下午
        int amOrPm = calendar.get(Calendar.AM_PM);
        if (currentDay - day > 7) {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("yyyy年MM月dd日 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            } else {
                time = new SimpleDateFormat("yyyy年MM月dd日 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            }
        } else if (currentDay - day > 1) {
            // 星期天为 1,依次增加,星期六为 7
            int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
            if (amOrPm == 0) {
                time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            } else {
                time = new SimpleDateFormat(mWeekArray[weekIndex - 1] + " 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            }
        } else if (currentDay - day > 0) {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("昨天 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            } else {
                time = new SimpleDateFormat("昨天 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            }
        } else {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("上午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            } else {
                time = new SimpleDateFormat("下午hh:mm", Locale.CHINA).format(new Date(messageBean.getSendTimestamp()));
            }
        }
        baseViewHolder.setTvText(R.id.tv_time, time);
        baseViewHolder.setVisibility(R.id.tv_time, View.VISIBLE);
    }
}
