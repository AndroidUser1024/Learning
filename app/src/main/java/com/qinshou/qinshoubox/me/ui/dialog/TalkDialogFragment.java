package com.qinshou.qinshoubox.me.ui.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.TalkerEntity;

/**
 * Description:与 NPC 对话的对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class TalkDialogFragment extends DialogFragment {
    private int mTalker1Index = 0;
    private int mTalker2Index = 0;

    public static TalkDialogFragment newInstance(TalkerEntity talker1, TalkerEntity talker2) {
        //谷歌推荐使用这种方式保存传进来的数据
        TalkDialogFragment talkDialogFragment = new TalkDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("talker1", talker1);
        bundle.putParcelable("talker2", talker2);
        talkDialogFragment.setArguments(bundle);
        return talkDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //设置对话框无标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        //设置对话框自带背景透明,才能显示布局的背景
        final Window mWindow = getDialog().getWindow();
        if (mWindow != null) {
            mWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        //设置点击外部不可消失
        getDialog().setCanceledOnTouchOutside(false);

        final TalkerEntity talker1 = getArguments().getParcelable("talker1");
        final TalkerEntity talker2 = getArguments().getParcelable("talker2");

        View rootView = inflater.inflate(R.layout.dialog_talk, container);
        if (talker1 == null || talker2 == null
                || talker1.getContent().length == 0 || talker2.getContent().length == 0) {
            return rootView;
        }
        final ImageView imageView1 = rootView.findViewById(R.id.image_view_1);
        final ImageView imageView2 = rootView.findViewById(R.id.image_view_2);
        final TextView textView = rootView.findViewById(R.id.text_view);
        Button button = rootView.findViewById(R.id.button);
        imageView1.setImageResource(talker1.getResourceId());
        imageView2.setImageResource(talker2.getResourceId());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTalker1Index == talker1.getContent().length && mTalker2Index == talker2.getContent().length) {
                    dismiss();
                    return;
                }
                if (mTalker2Index < mTalker1Index) {
                    textView.setText(talker2.getContent()[mTalker2Index++]);
                    imageView1.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                } else {
                    textView.setText(talker1.getContent()[mTalker1Index++]);
                    imageView1.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                }
            }
        });
        button.performClick();

        return rootView;
    }
}
