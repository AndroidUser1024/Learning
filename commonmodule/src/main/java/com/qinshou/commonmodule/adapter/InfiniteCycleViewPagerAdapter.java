package com.qinshou.commonmodule.adapter;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:无限循环的 ViewPager 适配器
 * Date:2018/4/4
 */
public class InfiniteCycleViewPagerAdapter extends PagerAdapter {
    private ViewPager mViewPager;
    private Activity mActivity;
    private List<View> mViewList;
    private List<String> mStringList;
    private long mInterval = 3000;
    private boolean mIsScrolling;
    private HandlerThread mHandlerThread;
    private Handler mHandler;
    private LoopRunnable mLoopRunnable;
    private boolean mIsLooping;

    public InfiniteCycleViewPagerAdapter(Activity activity, ViewPager viewPager) {
        this.mActivity = activity;
        this.mViewPager = viewPager;
        mViewList = new ArrayList<>();
        mHandlerThread = new HandlerThread("LoopHandlerThread");
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
        mLoopRunnable = new LoopRunnable();
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                mIsScrolling = i != 0;
            }
        });
    }


    public void setData(List<View> viewList) {
        this.setData(viewList, null);
    }

    public void setData(final List<View> viewList, List<String> stringList) {
        this.mViewList = viewList;
        this.mStringList = stringList;
        notifyDataSetChanged();
//        mViewPager.setOffscreenPageLimit(2);
        //currentItem 不要设置 Integer.MAX_VALUE/2,会阻塞主线程,也没有必要设置那么大
        new Thread(new Runnable() {
            @Override
            public void run() {
                mViewPager.setCurrentItem(viewList.size() * 100, false);
            }
        }).start();
    }

    @Override
    public int getCount() {
        return mViewList == null || mViewList.isEmpty() ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /**
     * Description:该方法可能会抛出这个异常
     * java.lang.IllegalStateException The specified child already has a parent. You must call removeView() on the child's parent first.
     * 所以在调用 container.addView(View view) 方法时,先判断需要添加的 view 是否已经有 parent,是否就是 container
     * 如果是则先调用 container.removeView(View view),这样的话 destroyItem() 方法里面就不需要写任何代码了
     * Date:2018/4/24
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mViewList == null || mViewList.isEmpty()) {
            return null;
        }
        View view = mViewList.get(position % mViewList.size());
        if (view.getParent() != null) {
            ((ViewPager) view.getParent()).removeView(view);
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewList.get(position % viewList.size()));
//        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mStringList == null || mStringList.isEmpty() ? "" : mStringList.get(position);
    }

    /**
     * Description:循环自动播放
     * Date:2018/4/24
     */
    public void startLoop() {
        mHandler.removeCallbacks(mLoopRunnable);
        mHandler.postDelayed(mLoopRunnable, 3000);
        mIsLooping = true;
    }

    /**
     * Description:停止循环
     * Date:2018/5/14
     */
    public void stopLoop() {
        mHandler.removeCallbacks(mLoopRunnable);
        mIsLooping = false;
    }

    public boolean isLooping() {
        return mIsLooping;
    }

    private class LoopRunnable implements Runnable {
        public void run() {
            // 运行到UI 线程的Thread
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (!mIsScrolling) {
                        mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                    }
                }
            });
            mHandler.postDelayed(this, 3000);
        }
    }

    public long getInterval() {
        return mInterval;
    }

    public void setInterval(long interval) {
        mInterval = interval;
    }
}