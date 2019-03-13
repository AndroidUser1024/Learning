package com.qinshou.qinshoubox.me.handler;

import android.support.v4.app.FragmentActivity;

import com.qinshou.qinshoubox.me.bean.CaseBean;


/**
 * Description:事件处理器,由具体实体类决定自己与勇士接触将会发生什么事件
 * Created by 禽兽先生
 * Created on 2018/4/11
 */

public interface IEventHandler {
    /**
     * Description:当勇士的坐标需要改变时返回 true,否则返回 false
     * Date:2018/4/25
     */
    boolean handleEvent(FragmentActivity activity, CaseBean fromCase, CaseBean toCase);
}
