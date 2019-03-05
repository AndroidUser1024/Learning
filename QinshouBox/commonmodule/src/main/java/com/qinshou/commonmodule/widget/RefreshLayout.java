package com.qinshou.commonmodule.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * Description:下来刷新和上拉加载更多的框架的封装类
 * 即使使用了第三方库,最好也是封装一下,方便统一管理,还有今后替换库的时候只需要修改这一个地方就行了
 * <p>
 * Created by 禽兽先生
 * Created on 2017/10/13
 */

public class RefreshLayout extends SmartRefreshLayout {
    private Context mContext;

    public RefreshLayout(Context context) {
        this(context, null);
    }

    public RefreshLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
    }

    /**
     * Description:从 xml 中加载完成后自动调用该方法,目前是统一在这里设置下拉刷新头布局和上拉加载脚布局
     * Date:2017/10/13
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setRefreshHeader(new ClassicsHeader(mContext));
        setRefreshFooter(new ClassicsFooter(mContext));
    }

    /**
     * Description:开始下拉刷新
     * Date:2017/10/13
     */
    public void startRefresh() {
        super.autoRefresh();
    }

    /**
     * Description:开始上拉加载更多
     * Date:2017/10/13
     */
    public void startLoadMore() {
        super.autoLoadMore();
    }

    /**
     * Description:结束下拉刷新
     * Date:2017/10/13
     */
    public void stopRefresh() {
        stopRefresh(200);
    }

    /**
     * Description:结束上拉加载更多
     * Date:2017/10/13
     */
    public void stopLoadMore() {
        stopLoadMore(200);
    }

    /**
     * Description:延时结束下拉刷新
     *
     * @param delayed 延迟时间(毫秒)
     *                Date:2017/10/13
     */
    public void stopRefresh(int delayed) {
        super.finishRefresh(delayed);
    }

    /**
     * Description:延时结束上拉加载更多
     *
     * @param delayed 延迟时间(毫秒)
     *                Date:2017/10/13
     */
    public void stopLoadMore(int delayed) {
        super.finishLoadMore(delayed);
    }

    /**
     * Description:停止下拉刷新和上拉加载
     * Date:2018/4/7
     */
    public void stopRefreshAndLoadMore() {
        super.finishRefresh(1000);
        super.finishLoadMore(1000);
    }

    /**
     * Description:是否可以下拉刷新
     * Date:2017/10/13
     */
    public void canRefresh(boolean can) {
        super.setEnableRefresh(can);
    }

    /**
     * Description:是否可以上拉加载更多
     * Date:2017/10/13
     */
    public void canLoadMore(boolean can) {
        super.setEnableLoadMore(can);
    }

    /**
     * Description:是否正在下拉刷新
     * Date:2017/10/13
     */
    public boolean isRefresh() {
        return super.isRefreshing();
    }

    /**
     * Description:是否正在上拉加载更多
     * Date:2017/10/13
     */
    public boolean isLoadMore() {
        return super.isLoading();
    }

    /**
     * Description:设置下拉刷新监听器
     * Date:2017/10/13
     */
    public void setOnRefreshListener(final IOnRefreshListener IOnRefreshListener) {
        //调用继承的控件的下拉刷新监听器
        setOnRefreshListener(new com.scwang.smartrefresh.layout.listener.OnRefreshListener() {
            @Override
            public void onRefresh(com.scwang.smartrefresh.layout.api.RefreshLayout refreshlayout) {
                //当继承的控件回调时再调用自己的回调方法
                IOnRefreshListener.onRefresh((RefreshLayout) refreshlayout);
            }
        });
    }

    /**
     * Description:设置上拉加载监听器
     * Date:2017/10/13
     */
    public void setOnLoadMoreListener(final IOnLoadMoreListener IOnLoadMoreListener) {
        //调用继承的控件的上拉加载更多监听器
        setOnLoadMoreListener(new com.scwang.smartrefresh.layout.listener.OnLoadMoreListener() {
            @Override
            public void onLoadMore(com.scwang.smartrefresh.layout.api.RefreshLayout refreshlayout) {
                //当继承的控件回调时再调用自己的回调方法
                IOnLoadMoreListener.onLoadMore((RefreshLayout) refreshlayout);
            }
        });
    }

    /**
     * Description:设置上拉加载和下拉刷新监听器
     * Date:2017/10/13
     */
    public void setOnRefreshLoadMoreListener(final IOnRefreshLoadMoreListener onRefreshLoadmoreListener) {
        setOnRefreshLoadMoreListener(new com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(com.scwang.smartrefresh.layout.api.RefreshLayout refreshLayout) {
                onRefreshLoadmoreListener.onLoadMore((RefreshLayout) refreshLayout);
            }

            @Override
            public void onRefresh(com.scwang.smartrefresh.layout.api.RefreshLayout refreshLayout) {
                onRefreshLoadmoreListener.onRefresh((RefreshLayout) refreshLayout);
            }
        });
    }

    public interface IOnRefreshListener {
        void onRefresh(RefreshLayout refreshLayout);
    }

    public interface IOnLoadMoreListener {
        void onLoadMore(RefreshLayout refreshLayout);
    }

    public interface IOnRefreshLoadMoreListener {
        void onRefresh(RefreshLayout refreshLayout);

        void onLoadMore(RefreshLayout refreshLayout);
    }
}