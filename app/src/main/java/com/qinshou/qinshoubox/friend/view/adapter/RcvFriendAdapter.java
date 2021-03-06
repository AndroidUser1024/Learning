package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/22 17:44
 * Description:联系人列表的适配器
 */
public class RcvFriendAdapter extends RcvBaseAdapter<UserDetailBean> {

    public RcvFriendAdapter(Context context) {
        super(context, R.layout.item_rcv_friend);
        setOnItemClickListener(new IOnItemClickListener<UserDetailBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, UserDetailBean itemData, int position) {
//                ChatActivity.start(getContext(), itemData.getId());
                UserDetailFragment.start(getContext(), itemData.getId());
            }
        });
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, UserDetailBean itemData, int position) {
        // 头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
        // 昵称
        baseViewHolder.setTvText(R.id.tv_name, TextUtils.isEmpty(itemData.getRemark())
                ? itemData.getNickname()
                : itemData.getRemark());
        // 个性签名
        baseViewHolder.setTvText(R.id.tv_signature, itemData.getSignature());
    }
}
