package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvMultipleBaseAdapter;
import com.qinshou.qinshoubox.im.bean.MessageBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:29
 * Description:消息列表适配器
 */
public class RcvMessageAdapter extends RcvMultipleBaseAdapter<MessageBean> {

    public RcvMessageAdapter(final Context context) {
        super(context);
        // 添加不同类型的 item
        addItemView(new RcvMessageAdapterToMessageItemView(context));
        addItemView(new RcvMessageAdapterFromMessageTextItemView(context));
//        addItemView(new RcvMessageAdapterFromMessageVoiceItemView(context));
    }
}
