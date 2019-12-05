package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;


/**
 * Author：WangGuifa
 * Email：wangguifa@jeejio.com
 * Date：2019/9/10 15:07
 * Description：{@link GroupChatSettingFragment} 的契约类
 */
public interface IGroupChatSettingContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 14:39
         * Description:获取群信息
         *
         * @param groupChatId 群 id
         */
        void getGroupChat(int groupChatId, QSCallback<GroupChatBean> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 14:43
         * Description:获取群信息成功
         *
         * @param groupChatBean 群信息实体类
         */
        void getGroupChatSuccess(GroupChatBean groupChatBean);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 14:43
         * Description:获取群信息失败
         *
         * @param e 错误信息
         */
        void getGroupChatFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 14:43
         * Description:获取群信息
         *
         * @param groupChatId 群 id
         */
        void getGroupChat(int groupChatId);
    }
}