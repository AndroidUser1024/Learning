package com.qinshou.qinshoubox.conversation.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;


import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.ConversationDetailBean;
import com.qinshou.qinshoubox.im.enums.MessageType;

import org.greenrobot.eventbus.EventBus;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/23 18:26
 * Description:清空聊天记录的对话框
 */
public class ClearChatHistoryDialog extends AbsDialogFragment {
    private static final String MESSAGE_TYPE = "MessageType";
    private static final String TO_USER_ID = "ToUserId";
    private static final String TO_NICKNAME = "ToNickname";


    @Override
    public int initLayoutId() {
        return R.layout.dialog_clear_chat_history;
    }

    @Override
    public void initView() {
    }

    @Override
    public void setListener() {
        findViewByID(R.id.tv_clear_chat_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getArguments();
                if (bundle == null) {
                    return;
                }
                MessageType messageType = (MessageType) bundle.getSerializable(MESSAGE_TYPE);
                String toUserId = bundle.getString(TO_USER_ID);
                if (messageType == null || TextUtils.isEmpty(toUserId)) {
                    return;
                }
                int clear = IMClient.SINGLETON.getConversationManager().clear(messageType.getValue(), toUserId);
                if (clear == 0) {
                    dismiss();
                    return;
                }
                Toast.makeText(getContext(), getString(R.string.chat_setting_toast_clear_chat_history_success_text), Toast.LENGTH_SHORT).show();
                // 发送事件,更新聊天界面和会话界面 UI
                ConversationDetailBean conversationDetailBean = IMClient.SINGLETON.getConversationManager().selectDetailByTypeAndToUserId(messageType.getValue(), toUserId);
                EventBus.getDefault().post(new EventBean<>(EventBean.Type.CLEAR_CHAT_HISTORY, conversationDetailBean));
                // 对话框消失
                dismiss();
            }
        });
        findViewByID(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    public void initData() {
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window != null) {
            //底部对话框
            window.setGravity(Gravity.BOTTOM);
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        }
        return dialog;
    }

    public static ClearChatHistoryDialog newInstance(MessageType messageType, String toUsername, String toNickname) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(MESSAGE_TYPE, messageType);
        bundle.putString(TO_USER_ID, toUsername);
        bundle.putString(TO_NICKNAME, toNickname);
        ClearChatHistoryDialog clearChatHistoryDialog = new ClearChatHistoryDialog();
        clearChatHistoryDialog.setArguments(bundle);
        return clearChatHistoryDialog;
    }
}
