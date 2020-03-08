package com.qinshou.qinshoubox.friend.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的契约类
 */
public interface IFriendContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取群列表
         */
        void getMyGroupChatList(Callback<List<GroupChatBean>> callback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取好友列表
         */
        void getFriendList(Callback<List<UserDetailBean>> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取群列表成功
         */
        void getMyGroupChatListSuccess(List<GroupChatBean> groupChatBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取群列表失败
         */
        void getMyGroupChatListFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取好友列表成功
         */
        void getFriendListSuccess(List<UserDetailBean> userDetailBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取好友列表失败
         */
        void getFriendListFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取群列表
         */
        void getMyGroupChatList();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/5 17:44
         * Description:获取好友列表
         */
        void getFriendList();
    }
}