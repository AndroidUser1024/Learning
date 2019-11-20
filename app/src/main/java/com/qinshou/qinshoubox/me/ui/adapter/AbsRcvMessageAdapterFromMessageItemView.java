package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.BaseItemView;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.chat.ChatManager;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.UserBean;

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
    private String[] mWeekArray;

    public AbsRcvMessageAdapterFromMessageItemView(Context context, int layoutId) {
        super(context, layoutId);
        mWeekArray = context.getResources().getStringArray(R.array.conversation_tv_last_msg_time_text);
    }

    @Override
    public void bindViewHolder(BaseViewHolder baseViewHolder, MessageBean messageBean, int i) {
        setTime(baseViewHolder, messageBean, i);
//        // 单聊不显示昵称,群聊可以设置是否显示昵称
//        baseViewHolder.setVisibility(R.id.tv_nickname, messageBean.getType() == MessageBean.Type.CHAT.getValue() || ((RcvMessageAdapter) getRcvBaseAdapter()).isNotShowNickname()
//                ? View.GONE
//                : View.VISIBLE);
        // 先给昵称设置为sysAccount
//        baseViewHolder.setTvText(R.id.tv_nickname, messageBean.getFromUsername());
        // 加载用户信息
        loadUserInfo(messageBean, baseViewHolder.getTextView(R.id.tv_nickname), baseViewHolder.getImageView(R.id.iv_head_img));
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
                    time = new SimpleDateFormat("yyyy年MM月dd日 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                } else {
                    time = new SimpleDateFormat("yyyy年MM月dd日 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
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
                    time = new SimpleDateFormat("昨天 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                } else {
                    time = new SimpleDateFormat("昨天 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                }
            } else {
                if (amOrPm == 0) {
                    time = new SimpleDateFormat("上午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
                } else {
                    time = new SimpleDateFormat("下午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
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
        if (previousMessageBean.getFromUserId() == ChatManager.SINGLETON.getUserId()) {
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
                time = new SimpleDateFormat("yyyy年MM月dd日 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            } else {
                time = new SimpleDateFormat("yyyy年MM月dd日 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
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
                time = new SimpleDateFormat("昨天 上午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            } else {
                time = new SimpleDateFormat("昨天 下午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            }
        } else {
            if (amOrPm == 0) {
                time = new SimpleDateFormat("上午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            } else {
                time = new SimpleDateFormat("下午hh:mm", Locale.CHINA).format(new Date(messageBean.getReceiveTimestamp()));
            }
        }
        baseViewHolder.setTvText(R.id.tv_time, time);
        baseViewHolder.setVisibility(R.id.tv_time, View.VISIBLE);
    }

    /**
     * Author: WangGuifa
     * Email: wangguifa@jeejio.com
     * Date:2019/11/5 11:25
     * Description: 加载好友信息
     *
     * @param messageBean 消息实体类
     * @param tvNickname  昵称TextView
     * @param ivIcon      头像Imageview
     */
    void loadUserInfo(final MessageBean messageBean, final TextView tvNickname, final ImageView ivIcon) {
//        // 获取好友信息
//        JMClient.SINGLETON.getUserManager().getUserInfo(messageBean.getFromUsername(), new JMCallback<UserBean>() {
//            @Override
//            public void onSuccess(final UserBean userBean) {
//                // 头像
//                JeejioUtil.loadHeadImg(getContext(), userBean.getImgUrl(), ivIcon);
//                // 昵称
//                // 设置昵称 加载昵称优先级：好友昵称 > 群聊昵称 > 用户昵称 > 系统账号
//                if (!TextUtils.isEmpty(userBean.getRemarkName())) {
//                    // 好友备注
//                    tvNickname.setText(userBean.getRemarkName());
//                } else if (messageBean.getType() == MessageBean.Type.CHAT.getValue()) {
//                    // 单聊
//                    if (!TextUtils.isEmpty(userBean.getUserName())) {
//                        // 用户昵称
//                        tvNickname.setText(userBean.getUserName());
//                    } else {
//                        // 系统账号
//                        tvNickname.setText(userBean.getSysAccount());
//                    }
//
//                } else if (messageBean.getType() == MessageBean.Type.GROUP_CHAT.getValue()) {
//                    JMClient.SINGLETON.getGroupChatManager().getOccupantName(messageBean.getToUsername(), messageBean.getFromUsername(), new JMCallback<String>() {
//                        @Override
//                        public void onSuccess(String occupantName) {
//                            if (!TextUtils.isEmpty(occupantName)) {
//                                // 群成员昵称
//                                tvNickname.setText(occupantName);
//                            } else if (!TextUtils.isEmpty(userBean.getUserName())) {
//                                // 用户昵称
//                                tvNickname.setText(userBean.getUserName());
//                            } else {
//                                // 系统账号
//                                tvNickname.setText(userBean.getSysAccount());
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Exception e) {
//                            if (!TextUtils.isEmpty(userBean.getUserName())) {
//                                // 用户昵称
//                                tvNickname.setText(userBean.getUserName());
//                            } else {
//                                // 系统账号
//                                tvNickname.setText(userBean.getSysAccount());
//                            }
//                        }
//                    });
//                } else {
//                    // 系统账号
//                    tvNickname.setText(userBean.getSysAccount());
//                }
//            }
//
//            @Override
//            public void onFailure(Exception e) {
//                // 系统账号
//                tvNickname.setText(messageBean.getFromUsername());
//            }
//        });
    }
}