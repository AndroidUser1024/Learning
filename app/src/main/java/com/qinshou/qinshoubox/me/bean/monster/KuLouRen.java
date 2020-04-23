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
 * Description:骷髅人
 */
public class KuLouRen extends AbsMonster {
    public KuLouRen() {
        super("骷髅人"
                , R.drawable.magic_tower_monster_ku_lou_ren
                , 110
                , 25
                , 5
                , 5
                , 4);
    }
}
