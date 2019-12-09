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

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/09 14:42
         * Description:设置置顶
         *
         * @param toUserId 好友的用户 id
         * @param top      0 表示不置顶,1 表示置顶
         * @param callback 回调接口
         */
        void setTop(String toUserId, int top, Callback<Object> callback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/09 14:42
         * Description:设置免打扰
         *
         * @param toUserId     好友的用户 id
         * @param doNotDisturb 0 表示非免打扰,1 表示免打扰
         * @param callback     回调接口
         */
        void setDoNotDisturb(String toUserId, int doNotDisturb, Callback<Object> callback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/09 14:42
         * Description:设置是否显示群成员昵称
         *
         * @param toUserId                    好友的用户 id
         * @param showGroupChatMemberNickname 0 表示不显示,1 表示显示
         * @param callback                    回调接口
         */
        void setShowGroupChatMemberNickname(String toUserId, int showGroupChatMemberNickname, Callback<Object> callback);
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


        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/09 14:52
         * Description:设置置顶成功
         */
        void setTopSuccess();

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/09 14:52
         * Description:设置置顶失败
         *
         * @param e 错误信息
         */
        void setTopFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/09 14:52
         * Description:设置免打扰成功
         */
        void setDoNotDisturbSuccess();

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/09 14:52
         * Description:设置免打扰失败
         *
         * @param e 错误信息
         */
        void setDoNotDisturbFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/09 14:52
         * Description:设置是否显示群成员昵称成功
         */
        void setShowGroupChatMemberNicknameSuccess();

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/09 14:52
         * Description:设置是否显示群成员昵称失败
         *
         * @param e 错误信息
         */
        void setShowGroupChatMemberNicknameFailure(Exception e);
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

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/09 14:42
         * Description:设置置顶
         *
         * @param toUserId 好友的用户 id
         * @param top      0 表示不置顶,1 表示置顶
         */
        void setTop(String toUserId, int top);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/09 14:42
         * Description:设置免打扰
         *
         * @param toUserId     好友的用户 id
         * @param doNotDisturb 0 表示非免打扰,1 表示免打扰
         */
        void setDoNotDisturb(String toUserId, int doNotDisturb);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/09 14:42
         * Description:设置是否显示群成员昵称
         *
         * @param toUserId                    好友的用户 id
         * @param showGroupChatMemberNickname 0 表示不显示,1 表示显示
         */
        void setShowGroupChatMemberNickname(String toUserId, int showGroupChatMemberNickname);
    }
}