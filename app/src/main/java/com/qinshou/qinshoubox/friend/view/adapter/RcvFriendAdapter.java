package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;
import android.text.TextUtils;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/22 17:44
 * Description:联系人列表的适配器
 */
public class RcvFriendAdapter extends RcvBaseAdapter<UserBean> {

    public RcvFriendAdapter(Context context) {
        super(context, R.layout.item_rcv_friend);
        setOnItemClickListener(new IOnItemClickListener<UserBean>() {
            @Override
            public void onItemClick(BaseViewHolder baseViewHolder, UserBean userBean, int i) {
            }
        });
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, UserBean userBean, int i) {
        // 头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
        // 昵称
        baseViewHolder.setTvText(R.id.tv_name, TextUtils.isEmpty(userBean.getRemark())
                ? userBean.getNickname()
                : userBean.getRemark());
    }
}
