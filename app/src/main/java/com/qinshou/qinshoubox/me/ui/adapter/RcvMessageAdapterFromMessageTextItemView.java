package com.qinshou.qinshoubox.me.ui.adapter;

import android.content.Context;

import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.immodule.db.dao.IUserDao;
import com.qinshou.immodule.db.dao.impl.UserDaoImpl;
import com.qinshou.immodule.enums.MessageContentType;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/12 14:32
 * Description:收到的消息,消息类型为普通文本
 */
public class RcvMessageAdapterFromMessageTextItemView extends AbsRcvMessageAdapterFromMessageItemView {
    private IUserDao mUserDao;

    public RcvMessageAdapterFromMessageTextItemView(Context context) {
        super(context, R.layout.item_rcv_message_from_message_text);
        mUserDao = new UserDaoImpl();
    }

    @Override
    public boolean isForViewType(MessageBean item, int position) {
        // 消息来源与当前登录的用户名不同,则是收到的消息
        return item.getFromUserId() != UserStatusManager.SINGLETON.getUserBean().getId()
                && item.getContentType() == MessageContentType.TEXT.getValue();
    }

    @Override
    public void bindViewHolder(final BaseViewHolder baseViewHolder, final MessageBean messageBean, int i) {
        super.bindViewHolder(baseViewHolder, messageBean, i);
        // 头像
        UserBean userBean = mUserDao.getById(messageBean.getFromUserId());
        if (userBean != null) {
            ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImgSmall(), baseViewHolder.getImageView(R.id.iv_head_img));
        }
        // 消息内容
        baseViewHolder.setTvText(R.id.tv_content, messageBean.getContent());
    }
}