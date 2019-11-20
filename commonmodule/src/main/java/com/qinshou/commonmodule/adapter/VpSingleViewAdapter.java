package com.qinshou.commonmodule.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Description:ViewPager 页卡为一个 View 的适配器
 * Created by 禽兽先生
 * Created on 2017/11/24
 */

public class VpSingleViewAdapter extends PagerAdapter {
    private List<? extends View> viewList;
    private List<String> titleList;

    public VpSingleViewAdapter(List<? extends View> viewList, List<String> titleList) {
        this.viewList = viewList;
        this.titleList = titleList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList != null ? titleList.get(position) : "";
    }
}
