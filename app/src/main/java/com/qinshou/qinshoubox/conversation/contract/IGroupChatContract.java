package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.activity.GroupChatActivity;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/06/20 10:26
 * Description:{@link GroupChatActivity} 的契约类
 */
public interface IGroupChatContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:29
         * Description:获取消息列表
         *
         * @param toUserId 群 id
         * @param page     分页加载页码
         * @param pageSize 分页加载每页条数
         */
        void getMessageList(String toUserId, int page, int pageSize, QSCallback<List<MessageBean>> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:31
         * Description:获取消息列表成功
         *
         * @param messageBeanList 消息列表
         */
        void getMessageListSuccess(List<MessageBean> messageBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:31
         * Description:获取消息列表失败
         *
         * @param e 错误信息
         */
        void getMessageListFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:31
         * Description:获取消息列表
         *
         * @param toUserId 群 id
         * @param page     分页加载页码
         * @param pageSize 分页加载每页条数
         */
        void getMessageList(String toUserId, int page, int pageSize);
    }
}