package com.qinshou.qinshoubox.friend.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的契约类
 */
public interface IFriendContract {
    interface IModel extends IBaseModel {
        void getMyGroupChatList(QSCallback<List<GroupChatBean>> qsCallback);

        void getFriendList(QSCallback<List<FriendBean>> qsCallback);
    }

    interface IView extends IBaseView {
        void getMyGroupChatListSuccess(List<GroupChatBean> groupChatBeanList);

        void getMyGroupChatListFailure(Exception e);

        void getFriendListSuccess(List<FriendBean> userBeanList);

        void getFriendListFailure(Exception e);
    }

    interface IPresenter {
        void getMyGroupChatList();

        void getFriendList();
    }
}