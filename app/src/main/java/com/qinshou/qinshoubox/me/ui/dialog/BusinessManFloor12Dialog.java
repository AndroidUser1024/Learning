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
