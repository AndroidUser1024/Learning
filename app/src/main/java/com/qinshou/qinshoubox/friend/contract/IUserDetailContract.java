package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的契约类
 */
public interface IUserDetailContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:15
         * Description:获取用户详情
         *
         * @param keyword 关键字,用户 id/用户名/手机号/邮箱
         */
        void getUserDetail(String keyword, QSCallback<UserDetailBean> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:15
         * Description:同意添加好友
         *
         * @param toUserId 待添加的用户 id
         * @param remark   备注
         */
        void agreeAddFriend(String toUserId, String remark, QSCallback<Object> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:16
         * Description:删除好友
         *
         * @param toUserId 待删除的用户 id
         */
        void deleteFriend(String toUserId, QSCallback<Object> qsCallback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:16
         * Description:设置备注
         *
         * @param toUserId 待修改的用户 id
         * @param remark   备注
         */
        void setRemark(String toUserId, String remark, QSCallback<Object> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:18
         * Description:获取用户详情成功
         *
         * @param userDetailBean 用户详情实体类
         */
        void getUserDetailSuccess(UserDetailBean userDetailBean);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:18
         * Description:获取用户详情失败
         *
         * @param e 错误信息
         */
        void getUserDetailFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:19
         * Description:同意添加好友成功
         */
        void agreeAddFriendSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:18
         * Description:同意添加好友失败
         *
         * @param e 错误信息
         */
        void agreeAddFriendFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:19
         * Description:删除好友成功
         */
        void deleteFriendSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:18
         * Description:删除好友失败
         *
         * @param e 错误信息
         */
        void deleteFriendFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:19
         * Description:设置备注成功
         */
        void setRemarkSuccess();

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:18
         * Description:设置备注失败
         *
         * @param e 错误信息
         */
        void setRemarkFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:17
         * Description:获取用户详情
         *
         * @param keyword 关键字,用户 id/用户名/手机号/邮箱
         */
        void getUserDetail(String keyword);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:17
         * Description:同意添加好友
         *
         * @param toUserId 待添加的用户 id
         * @param remark   备注
         */
        void agreeAddFriend(String toUserId, String remark);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:17
         * Description:删除好友
         *
         * @param toUserId 待删除的用户 id
         */
        void deleteFriend(String toUserId);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 13:17
         * Description:设置备注
         *
         * @param toUserId 待修改的用户 id
         * @param remark   备注
         */
        void setRemark(String toUserId, String remark);
    }
}