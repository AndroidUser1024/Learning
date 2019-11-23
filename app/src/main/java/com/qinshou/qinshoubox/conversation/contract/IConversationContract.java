package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的契约类
 */
public interface IConversationContract {
    interface IModel extends IBaseModel {
        void getConversationList();
    }

    interface IView extends IBaseView {
        void getConversationListSuccess();

        void getConversationListFailure();
    }

    interface IPresenter {
        void getConversationList();
    }
}