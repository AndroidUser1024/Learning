package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.friend.bean.GroupChatMemberForCreateBean;
import com.qinshou.qinshoubox.me.bean.UserBean;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/12 15:25
 * Description:创建群聊时的群成员列表的适配器
 */
public class RcvGroupChatMemberForCreateChooseAdapter extends RcvSingleBaseAdapter<GroupChatMemberForCreateBean> {
    public RcvGroupChatMemberForCreateChooseAdapter(Context context) {
        super(context, R.layout.item_rcv_group_chat_member_for_create_choose);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, GroupChatMemberForCreateBean itemData, int position) {
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getHeadImgSmall(), holder.getImageView(R.id.iv_head_img));
    }
}
