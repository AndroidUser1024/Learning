package com.qinshou.qinshoubox.im.bean;

import com.jeejio.dbmodule.annotation.Column;
import com.jeejio.dbmodule.annotation.Id;
import com.jeejio.dbmodule.annotation.Table;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/03/21 15:56
 * Description:群成员实体类
 */
@Table(name = "group_chat_member")
public class GroupChatMemberBean {
    /**
     * 自增长 id
     */
    @Id(autoIncrement = true,useGeneratedKeys = true)
    @Column(type = Column.Type.INTEGER)
    private int id;
    /**
     * 群 id
     */
    @Column
    private String groupChatId;
    /**
     * 用户 id
     */
    @Column
    private String userId;
    /**
     * 在群中的昵称
     */
    @Column
    private String nicknameInGroupChat;
    /**
     * 成员状态,0 已不在该群中,1 在群聊中
     */
    @Column(type = Column.Type.INTEGER)
    private int status;

    public GroupChatMemberBean() {
    }

    @Override
    public String toString() {
        return "GroupChatMemberBean{" +
                "groupChatId='" + groupChatId + '\'' +
                ", userId='" + userId + '\'' +
                ", nicknameInGroupChat='" + nicknameInGroupChat + '\'' +
                ", status=" + status +
                '}';
    }

    public String getGroupChatId() {
        return groupChatId;
    }

    public void setGroupChatId(String groupChatId) {
        this.groupChatId = groupChatId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNicknameInGroupChat() {
        return nicknameInGroupChat;
    }

    public void setNicknameInGroupChat(String nicknameInGroupChat) {
        this.nicknameInGroupChat = nicknameInGroupChat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
