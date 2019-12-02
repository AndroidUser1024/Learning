package com.qinshou.qinshoubox.conversation.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.contract.IGroupChatSettingContract;
import com.qinshou.qinshoubox.conversation.model.GroupChatSettingModel;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatSettingFragment;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;


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
}