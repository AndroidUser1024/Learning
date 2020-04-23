package com.qinshou.qinshoubox.me.bean.monster;

import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.enums.Monster;

import androidx.fragment.app.FragmentManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 23:28
 * Description:青头怪
 */
public class QingTouGuai extends AbsMonster {

    public QingTouGuai() {
        super("青头怪"
                , R.drawable.magic_tower_monster_qing_tou_guai
                , 200
                , 35
                , 10
                , 5
                , 5);
    }
}
