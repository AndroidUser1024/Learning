package com.qinshou.qinshoubox.me.bean.npc;

import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.enums.Type;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-4-21 下午11:20
 * Description:
 */
public abstract class NpcBean extends CaseBean {
    public NpcBean( Type type, int resourceId) {
        super(type, resourceId);
    }
}
