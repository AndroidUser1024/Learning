package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.conversation.view.fragment.ConversationFragment;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/07 15:08
 * Description:{@link ConversationFragment} 的契约类
 */
public interface IConversationContract {
    interface IModel extends IBaseModel {
        void getConversationList(Callback<List<ConversationDetailBean>> callback);
    }

    interface IView extends IBaseView {
        void getConversationListSuccess(List<ConversationDetailBean> conversationDetailBeanList);

        void getConversationListFailure(Exception e);
    }

    interface IPresenter {
        void getConversationList();
    }
}