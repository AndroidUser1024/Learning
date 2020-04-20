package com.qinshou.qinshoubox.im.db;

import com.qinshou.dbmodule.annotation.Param;
import com.qinshou.dbmodule.annotation.Select;
import com.qinshou.dbmodule.dao.IBaseDao;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 15:56
 * Description:conversation 表的 Dao
 */
public interface IConversationDao extends IBaseDao<ConversationBean, Integer> {
    @Select("SELECT" +
            " c.id" +
            ",c.unreadCount" +
            ",c.type" +
            ",c.toUserId" +
            ",c.lastMsgTimestamp" +
            ",c.lastMsgPid" +
            ",m.content AS lastMsgContent" +
            ",m.contentType AS lastMsgContentType" +
            ",m.status AS lastMsgStatus" +
            ",u.nickname AS uNickname" +
            ",u.headImgSmall AS uHeadImgSmall" +
            ",f.remark AS fRemark" +
            ",f.top AS fTop" +
            ",f.doNotDisturb AS fDoNotDisturb" +
            ",gc.nickname AS gcNickname" +
            ",gc.headImgSmall AS gcHeadImgSmall" +
            ",gc.nicknameDefault AS gcNicknameDefault" +
            ",gc.top AS gcTop" +
            ",gc.doNotDisturb AS gcDoNotDisturb" +
            " FROM conversation AS c" +
            " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
            " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001+" +
            " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001")
    List<ConversationDetailBean> getList();

    @Select("SELECT" +
            " c.id" +
            ",c.unreadCount" +
            ",c.type" +
            ",c.toUserId" +
            ",c.lastMsgTimestamp" +
            ",c.lastMsgPid" +
            ",m.content AS lastMsgContent" +
            ",m.contentType AS lastMsgContentType" +
            ",m.status AS lastMsgStatus" +
            ",u.nickname AS uNickname" +
            ",u.headImgSmall AS uHeadImgSmall" +
            ",f.remark AS fRemark" +
            ",f.top AS fTop" +
            ",f.doNotDisturb AS fDoNotDisturb" +
            ",gc.nickname AS gcNickname" +
            ",gc.headImgSmall AS gcHeadImgSmall" +
            ",gc.nicknameDefault AS gcNicknameDefault" +
            ",gc.top AS gcTop" +
            ",gc.doNotDisturb AS gcDoNotDisturb" +
            " FROM conversation AS c" +
            " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
            " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
            " ORDER BY c.lastMsgTimestamp DESC")
    List<ConversationDetailBean> getListOrderByLastMsgTimeDesc();

    @Select("SELECT" +
            " c.id" +
            ",c.unreadCount" +
            ",c.type" +
            ",c.toUserId" +
            ",c.lastMsgTimestamp" +
            ",c.lastMsgPid" +
            ",m.content AS lastMsgContent" +
            ",m.contentType AS lastMsgContentType" +
            ",m.status AS lastMsgStatus" +
            ",u.nickname AS uNickname" +
            ",u.headImgSmall AS uHeadImgSmall" +
            ",f.remark AS fRemark" +
            ",f.top AS fTop" +
            ",f.doNotDisturb AS fDoNotDisturb" +
            ",gc.nickname AS gcNickname" +
            ",gc.headImgSmall AS gcHeadImgSmall" +
            ",gc.nicknameDefault AS gcNicknameDefault" +
            ",gc.top AS gcTop" +
            ",gc.doNotDisturb AS gcDoNotDisturb" +
            " FROM conversation AS c" +
            " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
            " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
            " ORDER BY" +
            " fTop OR gcTop DESC" +
            ",c.lastMsgTimestamp DESC")
    List<ConversationDetailBean> getListOrderByTopDescAndLastMsgTimeDesc();

    @Select("SELECT" +
            " c.id" +
            ",c.unreadCount" +
            ",c.type" +
            ",c.toUserId" +
            ",c.lastMsgTimestamp" +
            ",c.lastMsgPid" +
            ",m.content AS lastMsgContent" +
            ",m.contentType AS lastMsgContentType" +
            ",m.status AS lastMsgStatus" +
            ",u.nickname AS uNickname" +
            ",u.headImgSmall AS uHeadImgSmall" +
            ",f.remark AS fRemark" +
            ",f.top AS fTop" +
            ",f.doNotDisturb AS fDoNotDisturb" +
            ",gc.nickname AS gcNickname" +
            ",gc.headImgSmall AS gcHeadImgSmall" +
            ",gc.nicknameDefault AS gcNicknameDefault" +
            ",gc.top AS gcTop" +
            ",gc.doNotDisturb AS gcDoNotDisturb" +
            " FROM conversation AS c" +
            " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
            " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
            " WHERE" +
            " c.id=#{id}")
    ConversationDetailBean selectDetailById(@Param("id") int id);

    @Select("SELECT" +
            " c.id" +
            ",c.unreadCount" +
            ",c.type" +
            ",c.toUserId" +
            ",c.lastMsgTimestamp" +
            ",c.lastMsgPid" +
            ",m.content AS lastMsgContent" +
            ",m.contentType AS lastMsgContentType" +
            ",m.status AS lastMsgStatus" +
            ",u.nickname AS uNickname" +
            ",u.headImgSmall AS uHeadImgSmall" +
            ",f.remark AS fRemark" +
            ",f.top AS fTop" +
            ",f.doNotDisturb AS fDoNotDisturb" +
            ",gc.nickname AS gcNickname" +
            ",gc.headImgSmall AS gcHeadImgSmall" +
            ",gc.nicknameDefault AS gcNicknameDefault" +
            ",gc.top AS gcTop" +
            ",gc.doNotDisturb AS gcDoNotDisturb" +
            " FROM conversation AS c" +
            " LEFT OUTER JOIN message AS m ON m.pid=c.lastMsgPid" +
            " LEFT OUTER JOIN user AS u ON u.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN friend AS f ON f.id=c.toUserId AND c.type=2001" +
            " LEFT OUTER JOIN group_chat AS gc ON gc.id=c.toUserId AND c.type=3001" +
            " WHERE" +
            " c.type=#{type}" +
            " AND" +
            " c.toUserId=#{toUserId}")
    ConversationDetailBean selectDetailByTypeAndToUserId(@Param("type") int type
            , @Param("toUserId") String toUserId);

    @Select("SELECT * FROM" +
            " conversation" +
            " WHERE" +
            " type=#{type}" +
            " AND" +
            " toUserId=#{toUserId}")
    ConversationBean selectByTypeAndToUserId(@Param("type") int type
            , @Param("toUserId") String toUserId);

    @Select("SELECT" +
            " SUM(ABS(unreadCount)) AS totalUnreadCount" +
            " FROM conversation AS c" +
            " WHERE" +
            " (SELECT doNotDisturb FROM friend AS f WHERE c.type=2001 AND f.id=c.toUserId)=0" +
            " OR" +
            " (SELECT doNotDisturb FROM group_chat AS gc WHERE c.type=3001 AND gc.id=c.toUserId)=0" +
            " OR" +
            " (SELECT COUNT(id) FROM group_chat AS gc2 WHERE gc2.id=c.toUserId)=0")
    int getTotalUnreadCount();
}
