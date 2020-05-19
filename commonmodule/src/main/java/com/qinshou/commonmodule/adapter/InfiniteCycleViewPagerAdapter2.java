package com.qinshou.commonmodule.adapter;

import android.content.Context;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.qinshou.commonmodule.rcvbaseadapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.util.ShowLogUtil;

import java.util.List;

public abstract class InfiniteCycleViewPagerAdapter2<T> extends RcvSingleBaseAdapter<T> {
    private ViewPager2 mViewPager2;
    private long mInterval = 3000;
    private boolean mIsLooping;

    public InfiniteCycleViewPagerAdapter2(Context context, int layoutId, ViewPager2 viewPager2) {
        super(context, layoutId);
        mViewPager2 = viewPager2;
        mViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                if (!isLooping()) {
                    return;
                }
                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    mViewPager2.postDelayed(mLoopRunnable, mInterval);
                } else {
                    mViewPager2.removeCallbacks(mLoopRunnable);
                }
            }
        });
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (getDataList() == null || getDataList().size() == 0) {
            return;
        }
        if (getOnItemClickListener() != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    position = position % getDataList().size();
                    getOnItemClickListener().onItemClick(holder, getDataList().get(position), position);
                }
            });
        }
        if (getOnItemLongClickListener() != null) {
            holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    position = position % getDataList().size();
                    getOnItemLongClickListener().onItemLongClick(holder, getDataList().get(position), position);
                    return true;
                }
            });
        }
        position = position % getDataList().size();
        bindViewHolder(holder, getDataList().get(position), position);
    }

    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void setDataList(List<T> dataList) {
        super.setDataList(dataList);
        if (dataList == null || dataList.size() == 0) {
            return;
        }
        // 改变 ViewPager 当前下标,移动到中间,并且是 dataList 的第一个
        mViewPager2.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % getDataList().size(), false);
    }

    @Override
    public void addDataList(List<T> dataList, boolean isRefresh) {
        super.addDataList(dataList, isRefresh);
        if (isRefresh) {
            // 是刷新,才改变 ViewPager 当前下标
            mViewPager2.setCurrentItem(getDataList().size() / 2);
        }
    }

    private Runnable mLoopRunnable = new Runnable() {
        @Override
        public void run() {
            mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() + 1);
            mViewPager2.postDelayed(mLoopRunnable, mInterval);
        }
    };

    /**
     * Description:循环自动播放
     * Date:2018/4/24
     */
    public void startLoop() {
        mViewPager2.removeCallbacks(mLoopRunnable);
        mViewPager2.postDelayed(mLoopRunnable, mInterval);
        mIsLooping = true;
    }

    /**
     * Description:停止循环
     * Date:2018/5/14
     */
    public void stopLoop() {
        mViewPager2.removeCallbacks(mLoopRunnable);
        mIsLooping = false;
    }

    public boolean isLooping() {
        return mIsLooping;
    }

    public long getInterval() {
        return mInterval;
    }

    public void setInterval(long interval) {
        mInterval = interval;
    }
}