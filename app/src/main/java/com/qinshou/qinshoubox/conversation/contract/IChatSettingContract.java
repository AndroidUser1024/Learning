package com.qinshou.qinshoubox.conversation.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.fragment.ChatSettingFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/03 15:05
 * Description:{@link ChatSettingFragment} 的契约类
 */
public interface IChatSettingContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 17:40
         * Description:获取好友信息
         *
         * @param id         好友 id
         * @param qsCallback 回调接口
         */
        void getFriend(String id, QSCallback<UserDetailBean> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/11/29 18:28
         * Description:设置置顶
         *
         * @param toUserId   好友的用户 id
         * @param top        0 表示不置顶,1 表示置顶
         * @param qsCallback 回调接口
         */
        void setTop(String toUserId, int top, QSCallback<Object> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/11/29 18:29
         * Description:设置免打扰
         *
         * @param toUserId     好友的用户 id
         * @param doNotDisturb 0 表示非免打扰,1 表示免打扰
         * @param qsCallback   回调接口
         */
        void setDoNotDisturb(String toUserId, int doNotDisturb, QSCallback<Object> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/11/29 18:29
         * Description:设置加入黑名单
         *
         * @param toUserId   好友的用户 id
         * @param blackList  0 表示从黑名单中移除,1 表示加入黑名单
         * @param qsCallback 回调接口
         */
        void setBlackList(String toUserId, int blackList, QSCallback<Object> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 17:42
         * Description:获取好友信息成功
         *
         * @param userDetailBean 好友信息实体类
         */
        void getFriendSuccess(UserDetailBean userDetailBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 17:42
         * Description:获取好友信息失败
         *
         * @param e 错误信息
         */
        void getFriendFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 18:30
         * Description:设置置顶成功
         */
        void setTopSuccess();

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 18:30
         * Description:设置置顶失败
         *
         * @param e 错误信息
         */
        void setTopFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 18:30
         * Description:设置免打扰成功
         */
        void setDoNotDisturbSuccess();

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 18:30
         * Description:设置免打扰失败
         *
         * @param e 错误信息
         */
        void setDoNotDisturbFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 18:30
         * Description:设置黑名单成功
         */
        void setBlackListSuccess();

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 18:30
         * Description:设置黑名单失败
         *
         * @param e 错误信息
         */
        void setBlackListFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/29 17:42
         * Description:获取好友信息
         *
         * @param id 好友 id
         */
        void getFriend(String id);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/11/29 18:29
         * Description:设置置顶
         *
         * @param toUserId 好友的用户 id
         * @param top      0 表示不置顶,1 表示置顶
         */
        void setTop(String toUserId, int top);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/11/29 18:29
         * Description:设置免打扰
         *
         * @param toUserId     好友的用户 id
         * @param doNotDisturb 0 表示非免打扰,1 表示免打扰
         */
        void setDoNotDisturb(String toUserId, int doNotDisturb);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/11/29 18:29
         * Description:设置加入黑名单
         *
         * @param toUserId  好友的用户 id
         * @param blackList 0 表示从黑名单中移除,1 表示加入黑名单
         */
        void setBlackList(String toUserId, int blackList);
    }
}