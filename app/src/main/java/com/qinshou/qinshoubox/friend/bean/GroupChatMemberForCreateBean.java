package com.qinshou.qinshoubox.friend.bean;

import com.qinshou.qinshoubox.login.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/22 16:25
 * Description:创建群聊时的群成员实体类
 */
public class GroupChatMemberForCreateBean extends UserBean {
    private boolean choose;
    private boolean enable = true;

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
