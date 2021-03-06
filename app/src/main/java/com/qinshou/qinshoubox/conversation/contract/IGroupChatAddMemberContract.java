package com.qinshou.qinshoubox.conversation.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatAddMemberFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:40
 * Description:{@link GroupChatAddMemberFragment} 的契约类
 */
public interface IGroupChatAddMemberContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:12
         * Description:获取好友列表
         */
        void getFriendList(QSCallback<List<UserDetailBean>> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:12
         * Description:获取群成员列表
         *
         * @param groupChatId 群 id
         */
        void getMemberList(String groupChatId, QSCallback<List<UserDetailBean>> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:21
         * Description:添加群成员
         *
         * @param groupChatId     群 id
         * @param addMemberIdList 待添加的群成员的 id 列表
         */
        void addMember(String groupChatId, List<String> addMemberIdList, QSCallback<Object> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:13
         * Description:获取好友列表成功
         */
        void getFriendListSuccess(List<UserDetailBean> userDetailBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:13
         * Description:获取好友列表失败
         */
        void getFriendListFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:13
         * Description:获取群成员列表成功
         */
        void getMemberListSuccess(List<UserDetailBean> userDetailBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:13
         * Description:获取群成员列表失败
         */
        void getMemberListFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:添加群成员成功
         */
        void addMemberSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:添加群成员成功
         */
        void addMemberFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:14
         * Description:获取好友列表
         */
        void getFriendList();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:14
         * Description:获取群成员列表
         *
         * @param groupChatId 群 id
         */
        void getMemberList(String groupChatId);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:添加群成员
         *
         * @param groupChatId     群 id
         * @param addMemberIdList 待添加的群成员的 id 列表
         */
        void addMember(String groupChatId, List<String> addMemberIdList);
    }
}