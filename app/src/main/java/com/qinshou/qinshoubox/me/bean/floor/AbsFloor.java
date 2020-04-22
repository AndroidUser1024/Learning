package com.qinshou.qinshoubox.me.bean.floor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;
import com.qinshou.qinshoubox.me.enums.Warrior;
import com.qinshou.qinshoubox.util.MagicGameManager;

import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/11
 */

public abstract class AbsFloor {
    private List<List<CaseBean>> mData;

    public abstract int getFloor();

    public abstract List<List<CaseBean>> setData();

    public abstract void fromUpstairsToThisFloor();

    public abstract void fromDownstairsToThisFloor();

    @Override
    public String toString() {
        return "AbsFloor{" +
                "mData=" + mData +
                '}';
    }

    public AbsFloor() {
        mData = setData();
    }

    public List<List<CaseBean>> getData() {
        return mData;
    }

    public void initFloor(TableLayout tableLayout) {
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            View view = tableLayout.getChildAt(i);
            if (!(view instanceof TableRow)) {
                return;
            }
            TableRow tableRow = (TableRow) view;
            for (int j = 0; j < tableRow.getChildCount(); j++) {
                View view1 = tableRow.getChildAt(j);
                if (!(view1 instanceof ImageView)) {
                    return;
                }
                ImageView imageView = (ImageView) view1;
                CaseBean caseBean = mData.get(i).get(j);
                imageView.setImageResource(caseBean.getResourceId());
//                // 要注掉
//                if (caseBean.getType() == Npc.GO_UPSTAIRS) {
//                    imageView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            MagicGameManager.SINGLETON.goUpstairs();
//                        }
//                    });
//                } else if (caseBean.getType() == Npc.GO_DOWNSTAIRS) {
//                    imageView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            MagicGameManager.SINGLETON.goDownstairs();
//                        }
//                    });
//                }
            }
        }
    }

    public CaseBean getCase(Position position) {
        return mData.get(position.getRow()).get(position.getColumn());
    }

    public void setCase(Position position, CaseBean caseBean) {
        mData.get(position.getRow()).set(position.getColumn(), caseBean);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/8 18:43
     * Description:清除勇士当前位置,在上下楼时调用
     */
    public void clearWarriorPosition() {
//        setCase(WarriorBean.getInstance().getPosition().getRow()
//                , WarriorBean.getInstance().getPosition().getColumn()
//                , new CaseBean(getFloor(), WarriorBean.getInstance().getPosition().getRow(), WarriorBean.getInstance().getPosition().getColumn(), Building.ROAD, R.drawable.magic_tower_building_road));
    }

    /**
     * Description:重设勇士位置,在 clearWarriorPosition() 方法后且 floor 改变后调用
     * Date:2018/4/26
     */
    public void resetWarriorPosition(Position position) {
        MagicGameManager.SINGLETON.getWarriorBean().setPosition(position);
        MagicGameManager.SINGLETON.getWarriorBean().setType(WarriorBean.Type.UP);
        MagicGameManager.SINGLETON.updateUI(position, MagicGameManager.SINGLETON.getWarriorBean());
    }
}
