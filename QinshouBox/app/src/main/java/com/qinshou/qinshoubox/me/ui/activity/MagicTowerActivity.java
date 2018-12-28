package com.qinshou.qinshoubox.me.ui.activity;

import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.qinshou.commonmodule.util.SharedPreferencesUtil;
import com.qinshou.commonmodule.util.SnackbarUtil;
import com.qinshou.networkmodule.rxbus.RxBus;
import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.MyBaseActivity;
import com.qinshou.qinshoubox.me.bean.WarriorBean;
import com.qinshou.qinshoubox.me.constant.Constant;
import com.qinshou.qinshoubox.me.util.MapManager;

import io.reactivex.functions.Consumer;

/**
 * Description:魔塔游戏界面
 * Date:2018/4/10
 */
public class MagicTowerActivity extends MyBaseActivity {

    private ImageButton ibKeyboardUp;
    private ImageButton ibKeyboardDown;
    private ImageButton ibKeyboardLeft;
    private ImageButton ibKeyboardRight;
    private TextView tvLevel;
    private TextView tvExperience;
    private TextView tvMoney;
    private TextView tvLifeValue;
    private TextView tvAttackValue;
    private TextView tvDefenseValue;
    private TextView tvYellowKeyCount;
    private TextView tvBlueKeyCount;
    private TextView tvRedKeyCount;
    private Button btnSave;
    private Button btnRead;

    @Override
    public boolean getIsImmersive() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_magic_tower;
    }

    @Override
    public void setPresenter() {

    }

    @Override
    public void initView() {
        final TableLayout tlMap = findViewByID(R.id.tl_map);
        tlMap.post(new Runnable() {
            @Override
            public void run() {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) tlMap.getLayoutParams();
                layoutParams.width = Math.min(tlMap.getMeasuredWidth(), tlMap.getMeasuredHeight());
                layoutParams.height = Math.min(tlMap.getMeasuredWidth(), tlMap.getMeasuredHeight());
                tlMap.setLayoutParams(layoutParams);
            }
        });
        for (int i = 0; i < 11; i++) {
            TableRow tableRow = new TableRow(getContext());
            TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, 0);
            layoutParams.weight = 1;
            tableRow.setLayoutParams(layoutParams);
            tableRow.setOrientation(TableLayout.HORIZONTAL);
            for (int j = 0; j < 11; j++) {
                ImageView imageView = new ImageView(getContext());
                TableRow.LayoutParams layoutParams1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.MATCH_PARENT);
                layoutParams1.weight = 1;
                imageView.setLayoutParams(layoutParams1);
                imageView.setBackgroundResource(R.drawable.building_road);
                tableRow.addView(imageView);
            }
            tlMap.addView(tableRow);
        }
        MapManager.getInstance().initMap(tlMap);
        btnSave = findViewByID(R.id.btn_save);
        btnRead = findViewByID(R.id.btn_read);
        tvLevel = findViewByID(R.id.tv_level);
        tvExperience = findViewByID(R.id.tv_experience);
        tvMoney = findViewByID(R.id.tv_money);
        tvLifeValue = findViewByID(R.id.tv_life_value);
        tvAttackValue = findViewByID(R.id.tv_attack_value);
        tvDefenseValue = findViewByID(R.id.tv_defense_value);
        tvYellowKeyCount = findViewByID(R.id.tv_yellow_key_count);
        tvBlueKeyCount = findViewByID(R.id.tv_blue_key_count);
        tvRedKeyCount = findViewByID(R.id.tv_red_key_count);

        ibKeyboardUp = findViewByID(R.id.ib_keyboard_up);
        ibKeyboardDown = findViewByID(R.id.ib_keyboard_down);
        ibKeyboardLeft = findViewByID(R.id.ib_keyboard_left);
        ibKeyboardRight = findViewByID(R.id.ib_keyboard_right);
    }

    @Override
    public void setListener() {
        btnSave.setOnClickListener(mOnClickListener);
        btnRead.setOnClickListener(mOnClickListener);
        ibKeyboardUp.setOnClickListener(mOnClickListener);
        ibKeyboardDown.setOnClickListener(mOnClickListener);
        ibKeyboardLeft.setOnClickListener(mOnClickListener);
        ibKeyboardRight.setOnClickListener(mOnClickListener);
        RxBus.getInstance().register(WarriorBean.class).subscribe(new Consumer<WarriorBean>() {
            @Override
            public void accept(WarriorBean warriorBean) throws Exception {
                updateWarriorInfo(warriorBean);
            }
        });
        RxBus.getInstance().register(String.class).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                new SnackbarUtil.Builder(getActivity())
                        .setContent(s)
                        .setButtonText("知道了")
                        .build().showSnackbar();
            }
        });
    }

    @Override
    public void initData() {
        updateWarriorInfo(WarriorBean.getInstance());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregisterAll();
    }

    private void updateWarriorInfo(WarriorBean warriorBean) {
        tvLevel.setText("等级：" + warriorBean.getLevel());
        tvExperience.setText("经验：" + warriorBean.getExperience());
        tvMoney.setText("金币：" + warriorBean.getMoney());
        tvLifeValue.setText("生命：" + warriorBean.getLifeValue());
        tvAttackValue.setText("攻击：" + warriorBean.getAttackValue());
        tvDefenseValue.setText("防御：" + warriorBean.getDefenseValue());
        tvYellowKeyCount.setText(warriorBean.getYellowKeyCount() + "");
        tvBlueKeyCount.setText(warriorBean.getBlueKeyCount() + "");
        tvRedKeyCount.setText(warriorBean.getRedKeyCount() + "");
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_save:
                    SharedPreferencesUtil.putString(getContext(), Constant.WARRIOR_BEAN_JSON, new Gson().toJson(WarriorBean.getInstance()));
                    MapManager.getInstance().save(getContext());
                    break;
                case R.id.btn_read:
                    WarriorBean warriorBean = new Gson().fromJson(SharedPreferencesUtil.getString(App.getInstance(), Constant.WARRIOR_BEAN_JSON), WarriorBean.class);
                    WarriorBean.getInstance().setName(warriorBean.getName());
                    WarriorBean.getInstance().setType(warriorBean.getType());
                    WarriorBean.getInstance().setResourceId(warriorBean.getResourceId());
                    WarriorBean.getInstance().setPosition(warriorBean.getPosition());
                    WarriorBean.getInstance().setLevel(warriorBean.getLevel());
                    WarriorBean.getInstance().setLifeValue(warriorBean.getLifeValue());
                    WarriorBean.getInstance().setAttackValue(warriorBean.getAttackValue());
                    WarriorBean.getInstance().setDefenseValue(warriorBean.getDefenseValue());
                    WarriorBean.getInstance().setMoney(warriorBean.getMoney());
                    WarriorBean.getInstance().setExperience(warriorBean.getExperience());
                    WarriorBean.getInstance().setYellowKeyCount(warriorBean.getYellowKeyCount());
                    WarriorBean.getInstance().setBlueKeyCount(warriorBean.getBlueKeyCount());
                    WarriorBean.getInstance().setRedKeyCount(warriorBean.getRedKeyCount());
                    WarriorBean.getInstance().setHasShengGuangHui(warriorBean.isHasShengGuangHui());
                    WarriorBean.getInstance().setHasFengZhiLuoPan(warriorBean.isHasFengZhiLuoPan());
                    WarriorBean.getInstance().setHasXingGuangShenLang(warriorBean.isHasXingGuangShenLang());
                    MapManager.getInstance().read(getContext());
                    break;
                case R.id.ib_keyboard_up:
                    WarriorBean.getInstance().moveUp(getActivity());
                    break;
                case R.id.ib_keyboard_down:
                    WarriorBean.getInstance().moveDown(getActivity());
                    break;
                case R.id.ib_keyboard_left:
                    WarriorBean.getInstance().moveLeft(getActivity());
                    break;
                case R.id.ib_keyboard_right:
                    WarriorBean.getInstance().moveRight(getActivity());
                    break;
            }
        }
    };
}
