package com.qinshou.qinshoubox.me.ui.dialog;


import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;

/**
 * Description:12 层的商人对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class BusinessManFloor12Dialog extends AbsDialogFragment {
    private RadioGroup mRadioGroup;
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
//        View rootView = inflater.inflate(R.layout.dialog_business_man_floor_12, null);
//        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
//        rootView.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (radioGroup.getCheckedRadioButtonId()) {
//                    case R.id.radio_button_1:
//                        warriorBean.sellYellowKeyFor7Money();
//                        break;
//                    case R.id.radio_button_2:
//                        warriorBean.sellBlueKeyFor35Money();
//                        break;
//                    case R.id.radio_button_3:
//                        warriorBean.sellRedKeyFor70Money();
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
        return R.layout.dialog_business_man_floor_12;
    }

    @Override
    public void initView() {
        mRadioGroup = findViewByID(R.id.radio_group);
    }

    @Override
    public void setListener() {
        findViewByID(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WarriorBean warriorBean = MagicGameManager.SINGLETON.getWarriorBean();
                switch (mRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_button_1:
                        if (warriorBean.getYellowKeyCount() <= 0) {
                            Toast.makeText(getContext(), "黄钥匙不足", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        warriorBean.setYellowKeyCount(warriorBean.getYellowKeyCount() - 1);
                        warriorBean.setMoney(warriorBean.getMoney() + 7);
                        break;
                    case R.id.radio_button_2:
                        if (warriorBean.getBlueKeyCount() <= 0) {
                            Toast.makeText(getContext(), "蓝钥匙不足", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        warriorBean.setBlueKeyCount(warriorBean.getBlueKeyCount() - 1);
                        warriorBean.setMoney(warriorBean.getMoney() + 35);
                        break;
                    case R.id.radio_button_3:
                        if (warriorBean.getRedKeyCount() <= 0) {
                            Toast.makeText(getContext(), "红钥匙不足", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        warriorBean.setRedKeyCount(warriorBean.getRedKeyCount() - 1);
                        warriorBean.setMoney(warriorBean.getMoney() + 70);
                        break;
                    case R.id.radio_button_4:
                        dismiss();
                        break;
                }
                warriorBean.update();
            }
        });
    }

    @Override
    public void initData() {

    }
}
