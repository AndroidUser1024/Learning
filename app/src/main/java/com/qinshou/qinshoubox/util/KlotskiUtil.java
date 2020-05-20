package com.qinshou.qinshoubox.util;

import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao1;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao2;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao3;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao4;
import com.qinshou.qinshoubox.me.bean.klotski.GuanYu1;
import com.qinshou.qinshoubox.me.bean.klotski.GuanYu2;
import com.qinshou.qinshoubox.me.bean.klotski.HuangZhong1;
import com.qinshou.qinshoubox.me.bean.klotski.HuangZhong2;
import com.qinshou.qinshoubox.me.bean.klotski.KlotskiBean;
import com.qinshou.qinshoubox.me.bean.klotski.MaChao1;
import com.qinshou.qinshoubox.me.bean.klotski.MaChao2;
import com.qinshou.qinshoubox.me.bean.klotski.Null;
import com.qinshou.qinshoubox.me.bean.klotski.ShiBing;
import com.qinshou.qinshoubox.me.bean.klotski.ZhangFei1;
import com.qinshou.qinshoubox.me.bean.klotski.ZhangFei2;
import com.qinshou.qinshoubox.me.bean.klotski.ZhaoYun1;
import com.qinshou.qinshoubox.me.bean.klotski.ZhaoYun2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/20 18:45
 * Description:华容道工具类
 */
public class KlotskiUtil {
    private static List<KlotskiBean[][]> sKlotskiLevelList = new ArrayList<>();

    static {
        // 横刀立马
        sKlotskiLevelList.add(new KlotskiBean[][]{
                new KlotskiBean[]{new ZhangFei1(App.getInstance()), new CaoCao1(App.getInstance()), new CaoCao2(App.getInstance()), new ZhaoYun1(App.getInstance())}
                , new KlotskiBean[]{new ZhangFei2(App.getInstance()), new CaoCao3(App.getInstance()), new CaoCao4(App.getInstance()), new ZhaoYun2(App.getInstance())}
                , new KlotskiBean[]{new HuangZhong1(App.getInstance()), new GuanYu1(App.getInstance()), new GuanYu2(App.getInstance()), new MaChao1(App.getInstance())}
                , new KlotskiBean[]{new HuangZhong2(App.getInstance()), new ShiBing(App.getInstance()), new ShiBing(App.getInstance()), new MaChao2(App.getInstance())}
                , new KlotskiBean[]{new ShiBing(App.getInstance()), new Null(), new Null(), new ShiBing(App.getInstance())}
        });
        // 指挥若定
        sKlotskiLevelList.add(new KlotskiBean[][]{
                new KlotskiBean[]{new ZhangFei1(App.getInstance()), new CaoCao1(App.getInstance()), new CaoCao2(App.getInstance()), new ZhaoYun1(App.getInstance())}
                , new KlotskiBean[]{new ZhangFei2(App.getInstance()), new CaoCao3(App.getInstance()), new CaoCao4(App.getInstance()), new ZhaoYun2(App.getInstance())}
                , new KlotskiBean[]{new ShiBing(App.getInstance()), new GuanYu1(App.getInstance()), new GuanYu2(App.getInstance()), new ShiBing(App.getInstance())}
                , new KlotskiBean[]{new HuangZhong1(App.getInstance()), new ShiBing(App.getInstance()), new ShiBing(App.getInstance()), new MaChao1(App.getInstance())}
                , new KlotskiBean[]{new HuangZhong2(App.getInstance()), new Null(), new Null(), new MaChao2(App.getInstance())}
        });
        // 将拥曹营
        sKlotskiLevelList.add(new KlotskiBean[][]{
                new KlotskiBean[]{new Null(), new CaoCao1(App.getInstance()), new CaoCao2(App.getInstance()), new Null()}
                , new KlotskiBean[]{new ZhangFei1(App.getInstance()), new CaoCao3(App.getInstance()), new CaoCao4(App.getInstance()), new ZhaoYun1(App.getInstance())}
                , new KlotskiBean[]{new ZhangFei2(App.getInstance()), new HuangZhong1(App.getInstance()), new MaChao1(App.getInstance()), new ZhaoYun2(App.getInstance())}
                , new KlotskiBean[]{new ShiBing(App.getInstance()), new HuangZhong2(App.getInstance()), new MaChao2(App.getInstance()), new ShiBing(App.getInstance())}
                , new KlotskiBean[]{new GuanYu1(App.getInstance()), new GuanYu2(App.getInstance()), new ShiBing(App.getInstance()), new ShiBing(App.getInstance())}
        });

    }

    public static KlotskiBean[][] getRandomLevel() {
        return sKlotskiLevelList.get(new Random().nextInt(sKlotskiLevelList.size()));
    }
}
