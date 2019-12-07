package com.qinshou.qinshoubox.conversation.view.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.BaseItemView;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.conversation.enums.GroupChatMemberFunction;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/2 14:58
 * Description:群成员列表中的功能按键
 */
public class RcvGroupChatMemberFunctionItemView extends BaseItemView<GroupChatMemberFunction> {
    public RcvGroupChatMemberFunctionItemView(Context context) {
        super(context, R.layout.item_rcv_group_chat_member_function);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, GroupChatMemberFunction itemData, int position) {
        if (itemData == GroupChatMemberFunction.ADD_MEMBER) {
            holder.setIvImage(R.id.iv_function, R.drawable.group_chat_setting_iv_function_src_add_member);
            holder.setTvText(R.id.tv_function, R.string.group_chat_setting_tv_function_text_add_member);
        } else if (itemData == GroupChatMemberFunction.DELETE_MEMBER) {
            holder.setIvImage(R.id.iv_function, R.drawable.group_chat_setting_iv_function_src_delete_member);
            holder.setTvText(R.id.tv_function, R.string.group_chat_setting_tv_function_text_delete_member);
        }
    }
}
