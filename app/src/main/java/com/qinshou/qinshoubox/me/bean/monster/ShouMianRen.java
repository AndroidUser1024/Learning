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
 * Description:兽面人
 */
public class ShouMianRen extends AbsMonster {
    public ShouMianRen() {
        super("兽面人"
                , R.drawable.magic_tower_monster_shou_mian_ren
                , 300
                , 75
                , 45
                , 13
                , 10);
    }
}
