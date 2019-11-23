package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.immodule.bean.ConversationBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的契约类
 */
public interface IConversationContract {
    interface IModel extends IBaseModel {
        void getConversationList(QSCallback<List<ConversationBean>> qsCallback);
    }

    interface IView extends IBaseView {
        void getConversationListSuccess(List<ConversationBean> conversationBeanList);

        void getConversationListFailure(Exception e);
    }

    interface IPresenter {
        void getConversationList();
    }
}