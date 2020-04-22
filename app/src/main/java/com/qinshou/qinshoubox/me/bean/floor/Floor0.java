package com.qinshou.qinshoubox.me.bean.floor;


import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.FireSeaBean;
import com.qinshou.qinshoubox.me.bean.building.RoadBean;
import com.qinshou.qinshoubox.me.bean.building.StarrySkyBean;
import com.qinshou.qinshoubox.me.bean.building.WallBean;
import com.qinshou.qinshoubox.me.bean.npc.FairyBean;
import com.qinshou.qinshoubox.me.bean.npc.GateYellowBean;
import com.qinshou.qinshoubox.me.enums.Building;
import com.qinshou.qinshoubox.me.enums.Npc;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:第 0 层
 * Created by 禽兽先生
 * Created on 207/6/5
 */

public class Floor0 extends AbsFloor {

    @Override
    public int getFloor() {
        return 0;
    }

    @Override
    public List<List<CaseBean>> setData() {
        List<List<CaseBean>> floor0 = new ArrayList<>();
        List<CaseBean> row0 = new ArrayList<>();
        row0.add(new WallBean());
        row0.add(new StarrySkyBean());
        row0.add(new StarrySkyBean());
        row0.add(new StarrySkyBean());
        row0.add(new StarrySkyBean());
        row0.add(new CaseBean(Npc.GO_UPSTAIRS, R.drawable.magic_tower_npc_go_upstairs));
        row0.add(new StarrySkyBean());
        row0.add(new StarrySkyBean());
        row0.add(new StarrySkyBean());
        row0.add(new StarrySkyBean());
        row0.add(new WallBean());
        floor0.add(row0);

        List<CaseBean> row1 = new ArrayList<>();
        row1.add(new WallBean());
        row1.add(new StarrySkyBean());
        row1.add(new StarrySkyBean());
        row1.add(new StarrySkyBean());
        row1.add(new StarrySkyBean());
        row1.add(new RoadBean());
        row1.add(new StarrySkyBean());
        row1.add(new StarrySkyBean());
        row1.add(new StarrySkyBean());
        row1.add(new StarrySkyBean());
        row1.add(new WallBean());
        floor0.add(row1);

        List<CaseBean> row2 = new ArrayList<>();
        row2.add(new WallBean());
        row2.add(new StarrySkyBean());
        row2.add(new StarrySkyBean());
        row2.add(new StarrySkyBean());
        row2.add(new StarrySkyBean());
        row2.add(new RoadBean());
        row2.add(new StarrySkyBean());
        row2.add(new StarrySkyBean());
        row2.add(new StarrySkyBean());
        row2.add(new StarrySkyBean());
        row2.add(new WallBean());
        floor0.add(row2);

        List<CaseBean> row3 = new ArrayList<>();
        row3.add(new WallBean());
        row3.add(new StarrySkyBean());
        row3.add(new StarrySkyBean());
        row3.add(new StarrySkyBean());
        row3.add(new StarrySkyBean());
        row3.add(new RoadBean());
        row3.add(new StarrySkyBean());
        row3.add(new StarrySkyBean());
        row3.add(new StarrySkyBean());
        row3.add(new StarrySkyBean());
        row3.add(new WallBean());
        floor0.add(row3);

        List<CaseBean> row4 = new ArrayList<>();
        row4.add(new WallBean());
        row4.add(new StarrySkyBean());
        row4.add(new StarrySkyBean());
        row4.add(new StarrySkyBean());
        row4.add(new StarrySkyBean());
        row4.add(new RoadBean());
        row4.add(new StarrySkyBean());
        row4.add(new StarrySkyBean());
        row4.add(new StarrySkyBean());
        row4.add(new StarrySkyBean());
        row4.add(new WallBean());
        floor0.add(row4);

        List<CaseBean> row5 = new ArrayList<>();
        row5.add(new WallBean());
        row5.add(new StarrySkyBean());
        row5.add(new StarrySkyBean());
        row5.add(new StarrySkyBean());
        row5.add(new StarrySkyBean());
        row5.add(new RoadBean());
        row5.add(new StarrySkyBean());
        row5.add(new StarrySkyBean());
        row5.add(new StarrySkyBean());
        row5.add(new StarrySkyBean());
        row5.add(new WallBean());
        floor0.add(row5);

        List<CaseBean> row6 = new ArrayList<>();
        row6.add(new WallBean());
        row6.add(new WallBean());
        row6.add(new StarrySkyBean());
        row6.add(new StarrySkyBean());
        row6.add(new StarrySkyBean());
        row6.add(new RoadBean());
        row6.add(new StarrySkyBean());
        row6.add(new StarrySkyBean());
        row6.add(new StarrySkyBean());
        row6.add(new WallBean());
        row6.add(new WallBean());
        floor0.add(row6);

        List<CaseBean> row7 = new ArrayList<>();
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new GateYellowBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        row7.add(new WallBean());
        floor0.add(row7);

        List<CaseBean> row8 = new ArrayList<>();
        row8.add(new FireSeaBean());
        row8.add(new WallBean());
        row8.add(new FireSeaBean());
        row8.add(new WallBean());
        row8.add(new RoadBean());
        row8.add(new FairyBean());
        row8.add(new RoadBean());
        row8.add(new WallBean());
        row8.add(new FireSeaBean());
        row8.add(new WallBean());
        row8.add(new FireSeaBean());
        floor0.add(row8);

        List<CaseBean> row9 = new ArrayList<>();
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new RoadBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        row9.add(new FireSeaBean());
        floor0.add(row9);

        List<CaseBean> row10 = new ArrayList<>();
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new RoadBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        row10.add(new FireSeaBean());
        floor0.add(row10);

        return floor0;
    }

    @Override
    public void fromUpstairsToThisFloor() {
        resetWarriorPosition(new Position(1, 5));
    }

    @Override
    public void fromDownstairsToThisFloor() {
        resetWarriorPosition(new Position(9, 5));
    }
}
