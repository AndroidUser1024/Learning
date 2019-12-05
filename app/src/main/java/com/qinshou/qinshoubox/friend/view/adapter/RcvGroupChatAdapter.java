package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/22 17:44
 * Description:群聊列表的适配器
 */
public class RcvGroupChatAdapter extends RcvBaseAdapter<GroupChatBean> {

    public RcvGroupChatAdapter(Context context) {
        super(context, R.layout.item_rcv_group_chat);
        setOnItemClickListener(new IOnItemClickListener<GroupChatBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, GroupChatBean itemData, int position) {
//                GroupChatActivity.start(getContext(), itemData.getId());
            }
        });
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, GroupChatBean itemData, int position) {
        // 头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
        // 昵称
        baseViewHolder.setTvText(R.id.tv_name, TextUtils.isEmpty(itemData.getNickname())
                ? itemData.getNicknameDefault()
                : itemData.getNickname());
        // 群公告
//        baseViewHolder.setTvText(R.id.tv_notice, itemData.getSignature());
    }
}
