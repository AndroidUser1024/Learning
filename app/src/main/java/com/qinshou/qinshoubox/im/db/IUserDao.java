
package com.qinshou.qinshoubox.im.db;

import com.jeejio.dbmodule.annotation.Insert;
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
    UserBean insert(String id,String username,String nickname,String headImg,String headImgSmall);
}
