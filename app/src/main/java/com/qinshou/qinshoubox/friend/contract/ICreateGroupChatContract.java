package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/19 17:27
 * Description:{@link CreateGroupChatFragment} 的契约类
 */
public interface ICreateGroupChatContract {
    interface IModel extends IBaseModel {
        void getFriendList(QSCallback<List<UserDetailBean>> qsCallback);

        void createGroupChat(List<String> memberIdList, String nickname, String headImg, QSCallback<GroupChatBean> qsCallback);
    }

    interface IView extends IBaseView {
        void getFriendListSuccess(List<UserDetailBean> userBeanList);

        void getFriendListFailure(Exception e);

        void createGroupChatSuccess(GroupChatBean groupChatBean);

        void createGroupChatFailure(Exception e);
    }

    interface IPresenter {
        void getFriendList();

        void createGroupChat(List<String> memberIdList, String nickname, String headImg);
    }
}