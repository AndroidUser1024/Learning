package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.friend.bean.GroupChatMemberForCreateBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/12 15:25
 * Description:创建群聊时的群成员列表的适配器
 */
public class RcvGroupChatMemberForCreateAdapter extends RcvSingleBaseAdapter<GroupChatMemberForCreateBean> {
    public RcvGroupChatMemberForCreateAdapter(Context context) {
        super(context, R.layout.item_rcv_group_chat_member_for_create);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, GroupChatMemberForCreateBean itemData, int position) {
        holder.setIvImage(R.id.iv_choose, itemData.isChoose()
                ? R.drawable.create_group_chat_iv_choose_src_2 :
                R.drawable.create_group_chat_iv_choose_src);
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getHeadImgSmall(), holder.getImageView(R.id.iv_head_img));
        holder.setTvText(R.id.tv_nickname, TextUtils.isEmpty(itemData.getRemark())
                ? itemData.getNickname() :
                itemData.getRemark());
    }
}
