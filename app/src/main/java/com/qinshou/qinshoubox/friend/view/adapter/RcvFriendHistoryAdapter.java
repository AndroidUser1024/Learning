package com.qinshou.qinshoubox.friend.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/9/4 9:06
 * Description:好友申请历史列表适配器
 */
public class RcvFriendHistoryAdapter extends RcvSingleBaseAdapter<FriendHistoryBean> {

    public RcvFriendHistoryAdapter(Context context) {
        super(context, R.layout.item_rcv_friend_history);
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final FriendHistoryBean friendHistoryBean, int i) {
        ImageLoadUtil.SINGLETON.loadImage(getContext()
                , friendHistoryBean.getHeadImgSmall()
                , baseViewHolder.getImageView(R.id.iv_head_img));
        baseViewHolder.setTvText(R.id.tv_nickname, TextUtils.isEmpty(friendHistoryBean.getRemark())
                ? friendHistoryBean.getNickname()
                : friendHistoryBean.getRemark());
        // 附加消息
        baseViewHolder.setTvText(R.id.tv_status, friendHistoryBean.getAdditionalMsg());
        Button btnView = baseViewHolder.findViewById(R.id.btn_view);
        // 根据申请结果,查看按钮显示不同文字
        if (friendHistoryBean.getStatus() == 0) {
            btnView.setBackgroundResource(R.drawable.friend_history_btn_view_bg);
            btnView.setText(getContext().getString(R.string.friend_history_btn_view_text));
            btnView.setTextColor(0xFFFFFFFF);
            btnView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getContext().getResources().getDimensionPixelSize(R.dimen.px24));
        } else {
            btnView.setBackgroundResource(0);
            btnView.setText(getContext().getString(R.string.friend_history_btn_view_text_2));
            btnView.setTextColor(0xFF999999);
            btnView.setTextSize(TypedValue.COMPLEX_UNIT_PX, getContext().getResources().getDimensionPixelSize(R.dimen.px26));
        }
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDetailFragment.start(getContext(), friendHistoryBean.getFromUserId());
            }
        };
        btnView.setOnClickListener(onClickListener);
        baseViewHolder.getItemView().setOnClickListener(onClickListener);
    }
}
