package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMsgFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMsgFragment} 的契约类
 */
public interface ISetAdditionalMsgContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:53
         * Description:添加好友
         *
         * @param toUserId      待添加的好友的 id
         * @param remark        备注
         * @param additionalMsg 附加验证信息
         * @param source        添加来源
         */
        void addFriend(String toUserId, String remark, String additionalMsg, int source, QSCallback<Object> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:54
         * Description:发送添加好友请求成功
         */
        void addFriendSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:54
         * Description:发送添加好友请求失败
         *
         * @param e 错误信息
         */
        void addFriendFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:54
         * Description:添加好友
         *
         * @param toUserId      待添加的好友的 id
         * @param remark        备注
         * @param additionalMsg 附加验证信息
         * @param source        添加来源
         */
        void addFriend(String toUserId, String remark, String additionalMsg, int source);
    }
}