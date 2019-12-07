package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;
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
        void getGroupChatDetail(String groupChatId, Callback<GroupChatDetailBean> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 14:43
         * Description:获取群信息成功
         *
         * @param groupChatDetailBean 群详情实体类
         */
        void getGroupChatDetailSuccess(GroupChatDetailBean groupChatDetailBean);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 14:43
         * Description:获取群信息失败
         *
         * @param e 错误信息
         */
        void getGroupChatDetailFailure(Exception e);
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
        void getGroupChatDetail(String groupChatId);
    }
}