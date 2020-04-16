package com.qinshou.qinshoubox.me.ui.dialog;


import com.qinshou.commonmodule.base.AbsDialogFragment;

/**
 * Description:5 层的神秘老人对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class MysteriousOldManFloor5DialogFragment extends AbsDialogFragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // 设置对话框无标题
//        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
//
//        // 设置对话框自带背景透明,才能显示布局的背景
//        final Window mWindow = getDialog().getWindow();
//        if (mWindow != null) {
//            mWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        // 设置点击外部不可消失
//        getDialog().setCanceledOnTouchOutside(false);
//
//        View rootView = inflater.inflate(R.layout.dialog_mysterious_old_man_floor_5, null);
//        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
//        rootView.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (radioGroup.getCheckedRadioButtonId()) {
//                    case R.id.radio_button_1:
//                        WarriorBean.getInstance().levelUp();
//                        break;
//                    case R.id.radio_button_2:
//                        WarriorBean.getInstance().buy5AttackValueWith30Experience();
//                        break;
//                    case R.id.radio_button_3:
//                        WarriorBean.getInstance().buy5DefenseValueWith30Experience();
//                        break;
//                    case R.id.radio_button_4:
//                        dismiss();
//                        break;
//                }
//            }
//        });
//        return rootView;
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
