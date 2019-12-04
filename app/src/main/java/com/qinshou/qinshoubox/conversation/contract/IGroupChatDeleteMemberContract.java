package com.qinshou.qinshoubox.conversation.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.view.fragment.GroupChatDeleteMemberFragment;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.immodule.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/12/02 17:41
 * Description:{@link GroupChatDeleteMemberFragment} 的契约类
 */
public interface IGroupChatDeleteMemberContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:12
         * Description:获取群成员列表
         *
         * @param groupChatId 群 id
         */
        void getMemberList(int groupChatId, QSCallback<List<UserBean>> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:删除群成员
         *
         * @param groupChatId        群 id
         * @param deleteMemberIdList 待删除的群成员的 id 列表
         */
        void deleteMember(int groupChatId, List<Integer> deleteMemberIdList, QSCallback<Object> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:13
         * Description:获取群成员列表成功
         */
        void getMemberListSuccess(List<UserBean> userBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:13
         * Description:获取群成员列表失败
         */
        void getMemberListFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:删除群成员成功
         */
        void deleteMemberSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:删除群成员成功
         */
        void deleteMemberFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 18:14
         * Description:获取群成员列表
         *
         * @param groupChatId 群 id
         */
        void getMemberList(int groupChatId);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/2 20:09
         * Description:删除群成员
         *
         * @param groupChatId        群 id
         * @param deleteMemberIdList 待删除的群成员的 id 列表
         */
        void deleteMember(int groupChatId, List<Integer> deleteMemberIdList);
    }
}