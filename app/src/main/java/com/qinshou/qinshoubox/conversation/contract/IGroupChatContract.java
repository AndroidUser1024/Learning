package com.qinshou.qinshoubox.conversation.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.conversation.bean.UploadImgResultBean;
import com.qinshou.qinshoubox.conversation.bean.UploadVoiceResultBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.view.activity.GroupChatActivity;

import java.io.File;
import java.util.List;

/**
 * Author: QinHao
 * Email:cqflqinhao@126.com
 * Date: 2019/06/20 10:26
 * Description:{@link GroupChatActivity} 的契约类
 */
public interface IGroupChatContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:29
         * Description:获取消息列表
         *
         * @param toUserId 群 id
         * @param page     分页加载页码
         * @param pageSize 分页加载每页条数
         */
        void getMessageList(String toUserId, int page, int pageSize, QSCallback<List<MessageBean>> qsCallback);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:24
         * Description:上传语音
         *
         * @param time  语音时长
         * @param voice 语音文件
         */
        void uploadVoice(long time, File voice, QSCallback<UploadVoiceResultBean> qsCallback);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:24
         * Description:上传图片
         *
         * @param img 图片文件
         */
        void uploadImg(File img, QSCallback<UploadImgResultBean> qsCallback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:31
         * Description:获取消息列表成功
         *
         * @param messageBeanList 消息列表
         */
        void getMessageListSuccess(List<MessageBean> messageBeanList);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:31
         * Description:获取消息列表失败
         *
         * @param e 错误信息
         */
        void getMessageListFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:27
         * Description:上传语音成功
         *
         * @param uploadVoiceResultBean 上传结果
         */
        void uploadVoiceSuccess(UploadVoiceResultBean uploadVoiceResultBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:27
         * Description:上传语音失败
         *
         * @param e 错误信息
         */
        void uploadVoiceFailure(Exception e);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:27
         * Description:上传图片
         *
         * @param uploadImgResultBean 上传图片结果
         */
        void uploadImgSuccess(UploadImgResultBean uploadImgResultBean);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:27
         * Description:上传图片失败
         *
         * @param e 错误信息
         */
        void uploadImgFailure(Exception e);
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2019/12/6 11:31
         * Description:获取消息列表
         *
         * @param toUserId 群 id
         * @param page     分页加载页码
         * @param pageSize 分页加载每页条数
         */
        void getMessageList(String toUserId, int page, int pageSize);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:45
         * Description:上传语音
         *
         * @param voice 语音文件
         */
        void uploadVoice(long time, File voice);

        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/12/30 16:45
         * Description:上传图片
         *
         * @param img 图片文件
         */
        void uploadImg(File img);
    }
}