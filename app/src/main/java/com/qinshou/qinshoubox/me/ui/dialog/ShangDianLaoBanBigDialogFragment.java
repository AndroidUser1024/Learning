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
import android.widget.RadioGroup;

import com.qinshou.networkmodule.rxbus.RxBus;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.WarriorBean;

/**
 * Description:11 层的大商店对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class ShangDianLaoBanBigDialogFragment extends DialogFragment {
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

        View rootView = inflater.inflate(R.layout.dialog_shang_dian_lao_ban_big, null);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        rootView.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radio_button_1:
                        if (WarriorBean.getInstance().getMoney() >= 100) {
                            WarriorBean.getInstance().setLifeValue(WarriorBean.getInstance().getLifeValue() + 4000);
                            WarriorBean.getInstance().setMoney(WarriorBean.getInstance().getMoney() - 100);
                            RxBus.getInstance().post(WarriorBean.getInstance());
                        } else {
                            RxBus.getInstance().post("金币不足");
                        }
                        break;
                    case R.id.radio_button_2:
                        if (WarriorBean.getInstance().getMoney() >= 100) {
                            WarriorBean.getInstance().setAttackValue(WarriorBean.getInstance().getAttackValue() + 20);
                            WarriorBean.getInstance().setMoney(WarriorBean.getInstance().getMoney() - 100);
                            RxBus.getInstance().post(WarriorBean.getInstance());
                        } else {
                            RxBus.getInstance().post("金币不足");
                        }
                        break;
                    case R.id.radio_button_3:
                        if (WarriorBean.getInstance().getMoney() >= 100) {
                            WarriorBean.getInstance().setDefenseValue(WarriorBean.getInstance().getDefenseValue() + 20);
                            WarriorBean.getInstance().setMoney(WarriorBean.getInstance().getMoney() - 100);
                            RxBus.getInstance().post(WarriorBean.getInstance());
                        } else {
                            RxBus.getInstance().post("金币不足");
                        }
                        break;
                    case R.id.radio_button_4:
                        dismiss();
                        break;
                }
            }
        });
        return rootView;
    }
}
