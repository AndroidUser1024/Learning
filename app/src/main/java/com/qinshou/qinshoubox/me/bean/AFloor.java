package com.qinshou.qinshoubox.me.bean;

import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.qinshou.qinshoubox.me.util.MapManager;

import java.util.List;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/11
 */

public abstract class AFloor {
    private List<List<CaseBean>> mData;

    public AFloor() {
        mData = setData();
    }

    public abstract int getFloor();

    public abstract List<List<CaseBean>> setData();

    public List<List<CaseBean>> getData() {
        return mData;
    }

    public void initFloor(TableLayout tableLayout) {
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow mTableRow = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j < mTableRow.getChildCount(); j++) {
                ImageView mImageView = (ImageView) mTableRow.getChildAt(j);
                CaseBean mCaseBean = mData.get(i).get(j);
                ABaseBean mABaseBean = mCaseBean.getSpecificEntity(mCaseBean.getType());
                if (mABaseBean != null) {
                    mImageView.setImageResource(mABaseBean.getResourceId());
                } else {
                    mImageView.setImageResource(0);
                }
            }
        }
    }

    public CaseBean getCase(int row, int column) {
        return mData.get(row).get(column);
    }

    public void setCase(int row, int column, CaseBean caseBean) {
        mData.get(row).set(column, caseBean);
    }

    public abstract void fromUpstairsToThisFloor();

    public abstract void fromDownstairsToThisFloor();

    /**
     * Description:清除勇士当前位置,在上下楼时调用
     * Date:2018/4/26
     */
    public void clearWarriorPosition() {
        setCase(WarriorBean.getInstance().getPosition().getRow()
                , WarriorBean.getInstance().getPosition().getColumn()
                , new CaseBean(getFloor(), WarriorBean.getInstance().getPosition().getRow(), WarriorBean.getInstance().getPosition().getColumn(), CaseBean.BUILDING_ROAD));
    }

    /**
     * Description:重设勇士位置,在 clearWarriorPosition() 方法后且 floor 改变后调用
     * Date:2018/4/26
     */
    public void resetWarriorPosition(int row, int column) {
        CaseBean caseBean = new CaseBean(getFloor(), row, column, CaseBean.WARRIOR_UP);
        setCase(row, column, caseBean);
        MapManager.getInstance().updateUI(caseBean);
        WarriorBean.getInstance().setPosition(new WarriorBean.Position(row, column));
    }
}
