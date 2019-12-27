package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.ConversationBean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/7 15:32
 * Description:会话列表适配器
 */
public class RcvConversationAdapter extends RcvSingleBaseAdapter<ConversationBean> {
    private String[] mWeekArray;

    public RcvConversationAdapter(Context context) {
        super(context, R.layout.item_rcv_conversation);
        mWeekArray = context.getResources().getStringArray(R.array.conversation_tv_last_msg_time_text);
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final ConversationBean conversationBean, final int position) {
        baseViewHolder.getItemView().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return new MyGestureDetector(getContext(), baseViewHolder, conversationBean, position).onTouchEvent(event);
            }
        });
        ImageLoadUtil.SINGLETON.loadImage(getContext(), conversationBean.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
        baseViewHolder.setTvText(R.id.tv_title, conversationBean.getTitle());
        baseViewHolder.setTvText(R.id.tv_last_msg_content, conversationBean.getLastMsgContent());

        // 根据是否置顶设置背景颜色
        baseViewHolder.setBackgroundColor(R.id.root_view, conversationBean.getTop() == 1
                ? 0xFFF5F6F9
                : 0xFFFFFFFF);
        // 根据是否免打扰设置免打扰标识是否显示
        baseViewHolder.setVisibility(R.id.iv_do_not_disturb, conversationBean.getDoNotDisturb() == 1
                ? View.VISIBLE
                : View.INVISIBLE);

        setUnreadCount(baseViewHolder, conversationBean);

        // 最后一条消息的时间
        setTime(baseViewHolder, conversationBean);
    }

    private void setUnreadCount(BaseViewHolder baseViewHolder, ConversationBean conversationBean) {
        if (conversationBean.getDoNotDisturb() == 1) {
            // 免打扰,显示免打扰图标
            baseViewHolder.setVisibility(R.id.iv_do_not_disturb, View.VISIBLE);
            if (conversationBean.getUnreadCount() > 0) {
                // 有未读消息,显示未读消息圆点,不显示未读数
                baseViewHolder.setVisibility(R.id.tv_unread_count, View.GONE);
                baseViewHolder.setVisibility(R.id.iv_do_not_disturb_unread, View.VISIBLE);
            } else {
                baseViewHolder.setVisibility(R.id.tv_unread_count, View.GONE);
                baseViewHolder.setVisibility(R.id.iv_do_not_disturb_unread, View.GONE);
            }
        } else {
            // 非免打扰,不显示免打扰图标
            baseViewHolder.setVisibility(R.id.iv_do_not_disturb_unread, View.GONE);
            if (conversationBean.getUnreadCount() > 0) {
                // 有未读消息,显示未读消息数量
                baseViewHolder.setVisibility(R.id.tv_unread_count, View.VISIBLE);
                // 设置未读消息数量 大于99条：'···'
                baseViewHolder.setTvText(R.id.tv_unread_count, conversationBean.getUnreadCount() > 99
                        ? "···"
                        : "" + conversationBean.getUnreadCount());
            } else {
                baseViewHolder.setVisibility(R.id.tv_unread_count, View.GONE);
            }
        }
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/21 15:48
     * Description:设置时间
     *
     * @param baseViewHolder   description
     * @param conversationBean 会话实体类
     */
    private void setTime(BaseViewHolder baseViewHolder, ConversationBean conversationBean) {
        // 获取 Calendar 实例
        Calendar calendar = Calendar.getInstance();
        // Calendar 设置成最新消息的时间
        calendar.setTime(new Date(System.currentTimeMillis()));
        // 获取当前消息的时间是年份中第几天
        int currentDay = calendar.get(Calendar.DAY_OF_YEAR);
        // Calendar 设置成最后一条消息的时间
        calendar.setTime(new Date(conversationBean.getLastMsgTimestamp()));
        // 获取最后一条消息的时间是年份中第几天
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        String time;
        if (currentDay - day > 7) {
            time = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(new Date(conversationBean.getLastMsgTimestamp()));
        } else if (currentDay - day > 1) {
            // 星期天为 1,依次增加,星期六为 7
            int weekIndex = calendar.get(Calendar.DAY_OF_WEEK);
            time = mWeekArray[weekIndex - 1];
        } else if (currentDay - day > 0) {
            time = new SimpleDateFormat("昨天", Locale.CHINA).format(new Date(conversationBean.getLastMsgTimestamp()));
        } else {
            // 0 表示上午,1 表示下午
            int amOrPm = calendar.get(Calendar.AM_PM);
            if (amOrPm == 0) {
                time = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(conversationBean.getLastMsgTimestamp()));
            } else {
                time = new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(conversationBean.getLastMsgTimestamp()));
            }
        }
        baseViewHolder.setTvText(R.id.tv_last_msg_time, time);
    }

    private class MyGestureDetector extends GestureDetector {

        public MyGestureDetector(Context context, BaseViewHolder holder, ConversationBean itemData, int position) {
            super(context, new OnGestureListener() {
                @Override
                public boolean onDown(MotionEvent e) {
                    return false;
                }

                @Override
                public void onShowPress(MotionEvent e) {

                }

                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return false;
                }

                @Override
                public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                    return false;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    ShowLogUtil.logi("长按");
                }

                @Override
                public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                    return false;
                }
            });
        }
    }

}