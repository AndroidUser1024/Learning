package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatSettingModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;


/**
 * Author：WangGuifa
 * Email：wangguifa@jeejio.com
 * Date：2019/9/10 15:14
 * Description：{@link GroupChatSettingFragment} 的 P 层
 */
public class GroupChatSettingPresenter extends AbsPresenter<IGroupChatSettingContract.IView, IGroupChatSettingContract.IModel> implements IGroupChatSettingContract.IPresenter {
    @Override
    public IGroupChatSettingContract.IModel initModel() {
        return new GroupChatSettingModel();
    }

    @Override
    public void getGroupChat(int groupChatId) {
        getModel().getGroupChat(groupChatId, new QSCallback<GroupChatBean>() {
            @Override
            public void onSuccess(GroupChatBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getGroupChatSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getGroupChatFailure(e);
            }
        });
    }
}