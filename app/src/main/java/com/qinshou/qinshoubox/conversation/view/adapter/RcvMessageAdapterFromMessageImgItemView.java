package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.imagemodule.callback.IOnGetImgCallback;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.bean.ImgBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.enums.MessageContentType;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/1 15:26
 * Description:接收的消息,消息类型为图片
 */
public class RcvMessageAdapterFromMessageImgItemView extends AbsRcvMessageAdapterFromMessageItemView {

    public RcvMessageAdapterFromMessageImgItemView(Context context) {
        super(context, R.layout.item_rcv_message_from_message_img);
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户名不同,则是收到的消息
        return item.getContentType() == MessageContentType.IMAGE.getValue()
                && !TextUtils.equals(item.getFromUserId(), UserStatusManager.SINGLETON.getUserBean().getId());
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, int position) {
        super.bindViewHolder(baseViewHolder, messageBean, position);
        ImgBean imgBean = new Gson().fromJson(messageBean.getExtend(), ImgBean.class);
        ImageLoadUtil.SINGLETON.getImage(getContext(), imgBean.getSmallUrl(), new IOnGetImgCallback() {
            @Override
            public void onSuccess(Drawable drawable) {
                // 获取图片宽高
                int width = drawable.getIntrinsicWidth();
                int height = drawable.getIntrinsicHeight();

                // 计算缩放比
                double scale = 1.0d;
                ImageView ivContent = baseViewHolder.getImageView(R.id.iv_content);
                final int maxWidth = ivContent.getMaxWidth();
                int maxHeight = ivContent.getMaxHeight();
                // 如果图片宽高大于控件最大宽高才需要缩放
                if (Math.max(width, height) > maxWidth) {
                    if (width > height) {
                        scale = (double) maxWidth / (double) width;
                    } else {
                        scale = (double) maxWidth / (double) height;
                    }
                }
                ivContent.getLayoutParams().width = (int) (width * scale);
                ivContent.getLayoutParams().height = (int) (height * scale);
                // 重新设置控件宽高
                ivContent.requestLayout();
                ivContent.setImageDrawable(drawable);
            }

            @Override
            public void onFailure(String error, Drawable errorDrawable) {

            }
        });
    }
}