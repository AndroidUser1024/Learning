package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.BaseItemView;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.login.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/2 14:58
 * Description:群成员列表中的群成员
 */
public class RcvGroupChatMemberItemView extends BaseItemView<UserDetailBean> {
    public RcvGroupChatMemberItemView(Context context) {
        super(context, R.layout.item_rcv_group_chat_member);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, UserDetailBean itemData, int position) {
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getHeadImgSmall(), holder.getImageView(R.id.iv_head_img));
        if (!TextUtils.isEmpty(itemData.getRemark())) {
            holder.setTvText(R.id.tv_nickname, itemData.getRemark());
        } else if (!TextUtils.isEmpty(itemData.getNicknameInGroupChat())) {
            holder.setTvText(R.id.tv_nickname, itemData.getNicknameInGroupChat());
        } else {
            holder.setTvText(R.id.tv_nickname, itemData.getNickname());
        }
    }
}
