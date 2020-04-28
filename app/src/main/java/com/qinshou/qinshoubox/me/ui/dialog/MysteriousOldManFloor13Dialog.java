package com.qinshou.qinshoubox.me.ui.dialog;

import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qinshou.commonmodule.base.AbsDialogFragment;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.util.MagicGameManager;


/**
 * Description:13 层的神秘老人对话框
 * Created by 禽兽先生
 * Created on 2018/4/27
 */

public class MysteriousOldManFloor13Dialog extends AbsDialogFragment {
    private RadioGroup mRadioGroup;

    @Override
    public int initLayoutId() {
        return R.layout.dialog_mysterious_old_man_floor_13;
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
                        if (warriorBean.getExperience() < 270) {
                            Toast.makeText(getContext(), "经验不足", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        warriorBean.setLevel(warriorBean.getLevel() + 1 * 3);
                        warriorBean.setLifeValue(warriorBean.getLifeValue() + 1000 * 3);
                        warriorBean.setAttackValue(warriorBean.getAttackValue() + 7 * 3);
                        warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 7 * 3);
                        warriorBean.setExperience(warriorBean.getExperience() - 270);
                        break;
                    case R.id.radio_button_2:
                        if (warriorBean.getExperience() < 95) {
                            Toast.makeText(getContext(), "经验不足", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        warriorBean.setAttackValue(warriorBean.getAttackValue() + 17);
                        warriorBean.setExperience(warriorBean.getExperience() - 95);
                        break;
                    case R.id.radio_button_3:
                        if (warriorBean.getExperience() < 95) {
                            Toast.makeText(getContext(), "经验不足", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        warriorBean.setDefenseValue(warriorBean.getDefenseValue() + 17);
                        warriorBean.setExperience(warriorBean.getExperience() - 95);
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
