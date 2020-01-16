package com.qinshou.qinshoubox.me.ui.activity;

import android.graphics.Color;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.commonmodule.widget.WheelOfFortuneView;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By:禽兽先生
 * Create On:2019-01-12 15:53
 * Description:
 */
public class WheelOfFortuneActivity extends QSActivity<AbsPresenter> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_wheel_of_fortune;
    }

    @Override
    public void initView() {
        WheelOfFortuneView wheelOfFortuneView = findViewById(R.id.wheel_of_fortune_view);
        List<WheelOfFortuneView.Prize> prizeList = new ArrayList();
        prizeList.add(new WheelOfFortuneView.Prize("玩游戏", Color.parseColor("#FFCD5C5C")));  //印度红
        prizeList.add(new WheelOfFortuneView.Prize("看电视", Color.parseColor("#FF1E90FF")));  //道奇蓝
        prizeList.add(new WheelOfFortuneView.Prize("看书", Color.parseColor("#FF7FFFAA")));   //碧绿色
        prizeList.add(new WheelOfFortuneView.Prize("学Android", Color.parseColor("#FF3CB371"))); //春天的绿色
        prizeList.add(new WheelOfFortuneView.Prize("学MySQL", Color.parseColor("#FFFF8C00")));   //深橙色
        prizeList.add(new WheelOfFortuneView.Prize("学Java", Color.parseColor("#FFDC143C"))); //猩红
        prizeList.add(new WheelOfFortuneView.Prize("学小程序", Color.parseColor("#FF98FB98"))); //苍白的绿色
        prizeList.add(new WheelOfFortuneView.Prize("写博客", Color.parseColor("#FFF0E68C")));  //卡其布
        wheelOfFortuneView.setPrizeList(prizeList);
        wheelOfFortuneView.setOnPrizeDrawListener(new WheelOfFortuneView.IOnPrizeDrawListener() {
            @Override
            public void onPrizeDrawResult(WheelOfFortuneView.Prize prize) {
            }
        });
    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    public void initData() {

    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }
}
