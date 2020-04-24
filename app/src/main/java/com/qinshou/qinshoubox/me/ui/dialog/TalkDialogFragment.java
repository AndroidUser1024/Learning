package com.qinshou.qinshoubox.me.ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.TalkerBean;

/**
 * Description:与 NPC 对话的对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */
public class TalkDialogFragment extends AbsDialogFragment {
    private static final String TALKER_1 = "Talker1";
    private static final String TALKER_2 = "Talker2";
    private ImageView mIvTalker1;
    private ImageView mIvTalker2;
    private TextView mTvContent;
    private Button mBtnNext;
    private int mTalker1Index = 0;
    private int mTalker2Index = 0;
    private TalkerBean mTalker1;
    private TalkerBean mTalker2;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_talk;
    }

    @Override
    public void initView() {
        mIvTalker1 = findViewByID(R.id.iv_talker_1);
        mIvTalker2 = findViewByID(R.id.iv_talker_2);
        mTvContent = findViewByID(R.id.tv_content);
        mBtnNext = findViewByID(R.id.btn_next);


    }

    @Override
    public void setListener() {
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTalker1Index == mTalker1.getContent().length && mTalker2Index == mTalker2.getContent().length) {
                    dismiss();
                    return;
                }
                if (mTalker2Index < mTalker1Index) {
                    mTvContent.setText(mTalker2.getContent()[mTalker2Index++]);
                    mIvTalker1.setVisibility(View.INVISIBLE);
                    mIvTalker2.setVisibility(View.VISIBLE);
                } else {
                    mTvContent.setText(mTalker1.getContent()[mTalker1Index++]);
                    mIvTalker1.setVisibility(View.VISIBLE);
                    mIvTalker2.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    public void initData() {
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        mTalker1 = bundle.getParcelable(TALKER_1);
        mTalker2 = bundle.getParcelable(TALKER_2);
        if (mTalker1 == null || mTalker2 == null
                || mTalker1.getContent().length == 0 || mTalker2.getContent().length == 0) {
            return;
        }
        mIvTalker1.setImageResource(mTalker1.getResourceId());
        mIvTalker2.setImageResource(mTalker2.getResourceId());
        mBtnNext.performClick();
    }

    @Override
    public Dialog customDialog(Dialog dialog) {
        //设置点击外部不可消失
        dialog.setCanceledOnTouchOutside(false);
        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                return keyCode == KeyEvent.KEYCODE_BACK;
            }
        });
        return dialog;
    }

    public static TalkDialogFragment newInstance(TalkerBean talker1, TalkerBean talker2) {
        //谷歌推荐使用这种方式保存传进来的数据
        TalkDialogFragment talkDialogFragment = new TalkDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TALKER_1, talker1);
        bundle.putParcelable(TALKER_2, talker2);
        talkDialogFragment.setArguments(bundle);
        return talkDialogFragment;
    }
}
