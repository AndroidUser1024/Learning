package com.qinshou.qinshoubox.me.ui.dialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.WarriorBean;


/**
 * Description:3 层的小商店对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */
public class StoreSmallDialogFragment extends AbsDialogFragment {
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
//        View rootView = inflater.inflate(R.layout.dialog_store_small, null);
//        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
//        rootView.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (radioGroup.getCheckedRadioButtonId()) {
//                    case R.id.radio_button_1:
//                        if (WarriorBean.getInstance().getMoney() < 25) {
//                            Toast.makeText(getContext(), "金币不足", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        WarriorBean.getInstance().buy800LifeValueWith25Money();
//                        break;
//                    case R.id.radio_button_2:
//                        if (WarriorBean.getInstance().getMoney() < 25) {
//                            Toast.makeText(getContext(), "金币不足", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        WarriorBean.getInstance().buy4AttackValueWith25Money();
//                        break;
//                    case R.id.radio_button_3:
//                        if (WarriorBean.getInstance().getMoney() < 25) {
//                            Toast.makeText(getContext(), "金币不足", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//                        WarriorBean.getInstance().buy4DefenseValueWith25Money();
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
