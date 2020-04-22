package com.qinshou.qinshoubox.me.bean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 12:17
 * Description:类描述
 */
public interface IHandleEventCallback {
    void onSuccess(boolean canMove);

    void onFailure(Exception e);
}
