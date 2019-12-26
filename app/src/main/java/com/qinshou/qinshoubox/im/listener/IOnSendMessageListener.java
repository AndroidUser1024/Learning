package com.qinshou.qinshoubox.im.listener;

import com.qinshou.qinshoubox.im.bean.MessageBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/26 13:52
 * Description:发送消息的监听器
 */
public interface IOnSendMessageListener {
    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/26 13:53
     * Description:发送中
     *
     * @param messageBean 对应的消息
     */
    void onSending(MessageBean messageBean);

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/26 13:54
     * Description:发送成功
     *
     * @param messageBean 对应的消息
     */
    void onSendSuccess(MessageBean messageBean);

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/12/26 13:54
     * Description:发送失败
     *
     * @param messageBean 对应的消息
     */
    void onSendFailure(MessageBean messageBean,int failureCode);
}
