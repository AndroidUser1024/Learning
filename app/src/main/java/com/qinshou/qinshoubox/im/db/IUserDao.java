package com.qinshou.qinshoubox.im.db;

import com.jeejio.dbmodule.annotation.Insert;
import com.jeejio.dbmodule.annotation.ObjParam;
import com.jeejio.dbmodule.annotation.Param;
import com.qinshou.qinshoubox.im.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/17 9:08
 * Description:类描述
 */
public interface IUserDao {
    @Insert("INSERT INTO USER(" +
            "id" +
            ",username" +
            ",nickname" +
            ",headImg" +
            ",headImgSmall" +
            ") VALUES (" +
            "#{id}" +
            ",#{username}" +
            ",#{nickname}" +
            ",#{headImg}" +
            ",#{headImgSmall}" +
            ")")
    UserBean insert(@Param("id") String id
            , @Param("username") String username
            , @Param("nickname") String nickname
            , @Param("headImg") String headImg
            , @Param("headImgSmall") String headImgSmall);

    @Insert("INSERT INTO USER(" +
            "id" +
            ",username" +
            ",nickname" +
            ",headImg" +
            ",headImgSmall" +
            ") VALUES (" +
            "#{id}" +
            ",#{username}" +
            ",#{nickname}" +
            ",#{headImg}" +
            ",#{headImgSmall}" +
            ")")
    UserBean insert(@ObjParam() UserBean userBean);
}
