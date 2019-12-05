package com.qinshou.qinshoubox.im.listener;

import com.qinshou.qinshoubox.im.bean.MessageBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/20 18:38
 * Description:消息监听器
 */
public interface IOnMessageListener {
    void onMessage(MessageBean messageBean);
}
