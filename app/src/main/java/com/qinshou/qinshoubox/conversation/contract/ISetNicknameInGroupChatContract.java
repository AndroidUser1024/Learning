package com.qinshou.qinshoubox.conversation.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.fragment.SetNicknameInGroupChatFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/12/09 14:01
 * Description:{@link SetNicknameInGroupChatFragment} 的契约类
 */
public interface ISetNicknameInGroupChatContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/9 14:07
         * Description:设置群昵称
         *
         * @param groupChatId         群 Id
         * @param nicknameInGroupChat 群昵称
         */
        void setNicknameInGroupChat(String groupChatId, String nicknameInGroupChat, QSCallback<Object> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/9 14:08
         * Description:设置群昵称成功
         */
        void setNicknameInGroupChatSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/9 14:08
         * Description:设置群昵称失败
         *
         * @param e 错误信息
         */
        void setNicknameInGroupChatFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/9 14:07
         * Description:设置群昵称
         *
         * @param groupChatId         群 Id
         * @param nicknameInGroupChat 群昵称
         */
        void setNicknameInGroupChat(String groupChatId, String nicknameInGroupChat);
    }
}