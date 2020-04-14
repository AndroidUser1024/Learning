package com.qinshou.qinshoubox.friend.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.view.fragment.FriendHistoryFragment;
import com.qinshou.qinshoubox.im.listener.QSCallback;

import java.util.List;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:03
 * Description:{@link FriendHistoryFragment} 的契约类
 */
public interface IFriendHistoryContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/5 14:15
         * Description:获取好友申请历史
         *
         */
        void getFriendHistory(int page, int pageSize, QSCallback<List<FriendHistoryBean>> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/5 14:17
         * Description:获取好友申请历史列表成功
         *
         * @param pageResultBean 好友申请历史列表
         */
        void getFriendHistorySuccess(List<FriendHistoryBean> pageResultBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/5 14:17
         * Description:获取好友申请历史列表成功
         *
         * @param e 错误信息
         */
        void getFriendHistoryFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/9/5 14:17
         * Description:获取好友申请历史列表
         */
        void getFriendHistory(int page, int pageSize);
    }
}