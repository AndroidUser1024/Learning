package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.immodule.bean.MessageBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的契约类
 */
public interface IChatContract {
    interface IModel extends IBaseModel {
        void getMessageList(int type, int toUserId, int page, int pageSize, QSCallback<List<MessageBean>> qsCallback);
    }

    interface IView extends IBaseView {
        void getMessageListSuccess(List<MessageBean> messageBeanList);

        void getMessageListFailure(Exception e);
    }

    interface IPresenter {
        void getMessageList(int type, int toUserId, int page, int pageSize);
    }
}