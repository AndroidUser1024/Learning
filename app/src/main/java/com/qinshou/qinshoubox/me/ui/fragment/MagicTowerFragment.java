
package com.qinshou.qinshoubox.me.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.qinshou.commonmodule.base.AbsMVPFragment;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.MonsterBean;
import com.qinshou.qinshoubox.me.bean.WarriorBean;
import com.qinshou.qinshoubox.me.contract.IMagicTowerContract;
import com.qinshou.qinshoubox.me.enums.Monster;
import com.qinshou.qinshoubox.me.presenter.MagicTowerPresenter;
import com.qinshou.qinshoubox.me.ui.dialog.MonsterInfoDialogFragment;
import com.qinshou.qinshoubox.util.MagicGameManager;
import com.qinshou.qinshoubox.util.MonsterFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;


/**
 * Description:魔塔游戏界面
 * Date:2018/4/10
 */
public class MagicTowerFragment extends AbsMVPFragment<MagicTowerPresenter> implements IMagicTowerContract.IView, Observer {

    private ImageButton ibMoveUp;
    private ImageButton ibMoveDown;
    private ImageButton ibMoveLeft;
    private ImageButton ibMoveRight;
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
    private TableLayout mTlMap;
    /**
     * 圣光徽
     */
    private ImageView mIvShengGuangHui;
    /**
     * 风之罗盘
     */
    private ImageView mIvFengZhiLuoPan;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_save:
                    MagicGameManager.SINGLETON.save();
                    break;
                case R.id.btn_read:
                    MagicGameManager.SINGLETON.read();
                    break;
                case R.id.iv_sheng_guang_hui:
                    ShowLogUtil.logi("圣光徽");
                    showMonsterInfo();
                    break;
                case R.id.iv_feng_zhi_luo_pan:
                    break;
                case R.id.ib_move_up:
                    MagicGameManager.SINGLETON.warriorMoveUp();
                    break;
                case R.id.ib_move_down:
                    MagicGameManager.SINGLETON.warriorMoveDown();
                    break;
                case R.id.ib_move_left:
                    MagicGameManager.SINGLETON.warriorMoveLeft();
                    break;
                case R.id.ib_move_right:
                    MagicGameManager.SINGLETON.warriorMoveRight();
                    break;
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        WarriorBean.getInstance().deleteObserver(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_magic_tower;
    }

    @Override
    public void initView() {
        mTlMap = findViewByID(R.id.tl_map);
        mTlMap.post(new Runnable() {
            @Override
            public void run() {
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mTlMap.getLayoutParams();
                layoutParams.width = Math.min(mTlMap.getMeasuredWidth(), mTlMap.getMeasuredHeight());
                layoutParams.height = Math.min(mTlMap.getMeasuredWidth(), mTlMap.getMeasuredHeight());
                mTlMap.setLayoutParams(layoutParams);
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
                imageView.setBackgroundResource(R.drawable.magic_tower_building_road);
                tableRow.addView(imageView);
            }
            mTlMap.addView(tableRow);
        }
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

        mIvShengGuangHui = findViewByID(R.id.iv_sheng_guang_hui);
        mIvFengZhiLuoPan = findViewByID(R.id.iv_feng_zhi_luo_pan);

        ibMoveUp = findViewByID(R.id.ib_move_up);
        ibMoveDown = findViewByID(R.id.ib_move_down);
        ibMoveLeft = findViewByID(R.id.ib_move_left);
        ibMoveRight = findViewByID(R.id.ib_move_right);
    }

    @Override
    public void setListener() {
        btnSave.setOnClickListener(mOnClickListener);
        btnRead.setOnClickListener(mOnClickListener);
        mIvShengGuangHui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowLogUtil.logi("圣光徽");
                showMonsterInfo();
            }
        });
        findViewByID(R.id.linear_layout_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowLogUtil.logi("点这里呢");
            }
        });
        ibMoveUp.setOnClickListener(mOnClickListener);
        ibMoveDown.setOnClickListener(mOnClickListener);
        ibMoveLeft.setOnClickListener(mOnClickListener);
        ibMoveRight.setOnClickListener(mOnClickListener);
//        RxBus.getInstance().register(WarriorBean.class).subscribe(new Consumer<WarriorBean>() {
//            @Override
//            public void accept(WarriorBean warriorBean) throws Exception {
//                updateWarriorInfo(warriorBean);
//            }
//        });
//        RxBus.getInstance().register(String.class).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                new SnackbarUtil.Builder(getActivity())
//                        .setContent(s)
//                        .setButtonText("知道了")
//                        .build().showSnackbar();
//            }
//        });
    }

    @Override
    public void initData() {
        WarriorBean.getInstance().addObserver(this);
        MagicGameManager.SINGLETON.startGame(getChildFragmentManager(),mTlMap);
        updateWarriorInfo(WarriorBean.getInstance());
    }

    @Override
    public void update(Observable o, Object arg) {
        updateWarriorInfo(WarriorBean.getInstance());
    }


    private void updateWarriorInfo(WarriorBean warriorBean) {
        tvLevel.setText(warriorBean.getLevel() + "");
        tvExperience.setText(warriorBean.getExperience() + "");
        tvMoney.setText(warriorBean.getMoney() + "");
        tvLifeValue.setText(warriorBean.getLifeValue() + "");
        tvAttackValue.setText(warriorBean.getAttackValue() + "");
        tvDefenseValue.setText(warriorBean.getDefenseValue() + "");
        tvYellowKeyCount.setText(warriorBean.getYellowKeyCount() + "");
        tvBlueKeyCount.setText(warriorBean.getBlueKeyCount() + "");
        tvRedKeyCount.setText(warriorBean.getRedKeyCount() + "");
        if (warriorBean.isHasShengGuangHui()) {
            mIvShengGuangHui.setVisibility(View.VISIBLE);
        } else {
            mIvShengGuangHui.setVisibility(View.INVISIBLE);
        }
        if (warriorBean.isHasFengZhiLuoPan()) {
            mIvFengZhiLuoPan.setVisibility(View.VISIBLE);
        } else {
            mIvFengZhiLuoPan.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 18:29
     * Description:显示怪物信息
     */
    private void showMonsterInfo() {
        List<List<CaseBean>> currentFloor = MagicGameManager.SINGLETON.getCurrentFloor();
        Set<MonsterBean> monsterBeanSet = new HashSet<>();
        for (List<CaseBean> caseBeanList : currentFloor) {
            for (CaseBean caseBean : caseBeanList) {
                if (caseBean.getType() instanceof Monster) {
                    monsterBeanSet.add(MonsterFactory.getMonster((Monster) caseBean.getType()));
                }
            }
        }
        ArrayList<MonsterBean> monsterBeanList = new ArrayList<>(monsterBeanSet);
        MonsterInfoDialogFragment.newInstance(monsterBeanList).show(getChildFragmentManager(), "MonsterInfoDialogFragment");
        ShowLogUtil.logi("显示怪物信息");
    }
}
