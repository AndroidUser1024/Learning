package com.qinshou.qinshoubox.me.ui.dialog;

import android.os.Bundle;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.me.bean.TalkerBean;

/**
 * Description:与 NPC 对话的对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class TalkDialogFragment extends AbsDialogFragment {
    private static final String TALKER_1 = "Talker1";
    private static final String TALKER_2 = "Talker2";
//    private int mTalker1Index = 0;
//    private int mTalker2Index = 0;
//    private OnDismissListener mOnDismissListener;
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //设置对话框无标题
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        //设置对话框自带背景透明,才能显示布局的背景
//        final Window mWindow = getDialog().getWindow();
//        if (mWindow != null) {
//            mWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        //设置点击外部不可消失
//        getDialog().setCanceledOnTouchOutside(false);
//
//        final TalkerBean talker1 = getArguments().getParcelable(TALKER_1);
//        final TalkerBean talker2 = getArguments().getParcelable(TALKER_2);
//
//        View rootView = inflater.inflate(R.layout.dialog_talk, container);
//        if (talker1 == null || talker2 == null
//                || talker1.getContent().length == 0 || talker2.getContent().length == 0) {
//            return rootView;
//        }
//        final ImageView imageView1 = rootView.findViewById(R.id.image_view_1);
//        final ImageView imageView2 = rootView.findViewById(R.id.image_view_2);
//        final TextView textView = rootView.findViewById(R.id.text_view);
//        Button button = rootView.findViewById(R.id.button);
//        imageView1.setImageResource(talker1.getResourceId());
//        imageView2.setImageResource(talker2.getResourceId());
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (mTalker1Index == talker1.getContent().length && mTalker2Index == talker2.getContent().length) {
//                    dismiss();
//                    return;
//                }
//                if (mTalker2Index < mTalker1Index) {
//                    textView.setText(talker2.getContent()[mTalker2Index++]);
//                    imageView1.setVisibility(View.INVISIBLE);
//                    imageView2.setVisibility(View.VISIBLE);
//                } else {
//                    textView.setText(talker1.getContent()[mTalker1Index++]);
//                    imageView1.setVisibility(View.VISIBLE);
//                    imageView2.setVisibility(View.INVISIBLE);
//                }
//            }
//        });
//        button.performClick();
//        return rootView;
//    }

//    @Override
//    public void onDismiss(DialogInterface dialog) {
//        super.onDismiss(dialog);
//        if (mOnDismissListener == null) {
//            return;
//        }
//        mOnDismissListener.onDismiss(dialog);
//    }
//
    public static TalkDialogFragment newInstance(TalkerBean talker1, TalkerBean talker2) {
        //谷歌推荐使用这种方式保存传进来的数据
        TalkDialogFragment talkDialogFragment = new TalkDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TALKER_1, talker1);
        bundle.putParcelable(TALKER_2, talker2);
        talkDialogFragment.setArguments(bundle);
        return talkDialogFragment;
    }
//
//    public void setOnDismissListener(OnDismissListener onDismissListener) {
//        mOnDismissListener = onDismissListener;
//    }

    @Override
    public int initLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {

    }
}
