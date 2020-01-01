package com.qinshou.qinshoubox.conversation.presenter;


import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.conversation.bean.UploadImgResultBean;
import com.qinshou.qinshoubox.conversation.bean.UploadResultBean;
import com.qinshou.qinshoubox.conversation.bean.UploadVoiceResultBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.conversation.contract.IChatContract;
import com.qinshou.qinshoubox.conversation.model.ChatModel;
import com.qinshou.qinshoubox.conversation.view.activity.ChatActivity;

import java.io.File;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的 P 层
 */
public class ChatPresenter extends AbsPresenter<IChatContract.IView, IChatContract.IModel> implements IChatContract.IPresenter {
    @Override
    public IChatContract.IModel initModel() {
        return new ChatModel();
    }

    @Override
    public void getMessageList(String toUserId, int page, int pageSize) {
        getModel().getMessageList(toUserId, page, pageSize, new QSCallback<List<MessageBean>>() {
            @Override
            public void onSuccess(List<MessageBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMessageListSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getMessageListFailure(e);
            }
        });
    }

    @Override
    public void uploadVoice(long time, File voice) {
        getModel().uploadVoice(time, voice, new QSCallback<UploadVoiceResultBean>() {
            @Override
            public void onSuccess(UploadVoiceResultBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().uploadVoiceSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().uploadVoiceFailure(e);
            }
        });
    }

    @Override
    public void uploadImg(File img) {
        getModel().uploadImg(img, new QSCallback<UploadImgResultBean>() {
            @Override
            public void onSuccess(UploadImgResultBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().uploadImgSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().uploadImgFailure(e);
            }
        });
    }
}