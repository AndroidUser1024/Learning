package com.qinshou.commonmodule.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qinshou.commonmodule.adapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.adapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.adapter.listener.IOnItemLongClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:RecyclerView 的适配器的基类
 * Created by 禽兽先生
 * Created on 2017/11/22
 */
public abstract class RcvBaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private Context mContext;
    private int layoutId;
    private List<T> dataList = new ArrayList<>();
    private IOnItemClickListener<T> mOnItemClickListener;
    private IOnItemLongClickListener<T> mOnItemLongClickListener;
    private View mEmptyView;
    public static final int EMPTY_ITEM_VIEW_TYPE = Integer.MAX_VALUE - 1;

    public RcvBaseAdapter(Context context, int layoutId) {
        this.mContext = context;
        this.layoutId = layoutId;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if ((dataList == null || dataList.size() == 0) && mEmptyView != null) {
            return new BaseViewHolder(mContext, mEmptyView);
        }
        View itemView = LayoutInflater.from(mContext).inflate(layoutId, parent, false);
        return new BaseViewHolder(mContext, itemView);
    }

    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        if (dataList == null || dataList.size() == 0) {
            return;
        }
        if (mOnItemClickListener != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder, dataList.get(position), position);
                }
            });
        }
        if (mOnItemLongClickListener != null) {
            holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder, dataList.get(position), position);
                    return true;
                }
            });
        }
        bindViewHolder(holder, dataList.get(position), position);
    }

    @Override
    public int getItemCount() {
        if (dataList == null || dataList.size() == 0) {
            return mEmptyView == null ? 0 : 1;
        }
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if ((dataList == null || dataList.size() == 0) && mEmptyView != null) {
            return EMPTY_ITEM_VIEW_TYPE;
        }
        return super.getItemViewType(position);
    }

    public abstract void bindViewHolder(BaseViewHolder holder, T itemData, int position);

    public Context getContext() {
        return mContext;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public List<T> getDataList() {
        return dataList;
    }

    /**
     * Description:设置数据,所有数据将被替换
     * Date:2018/3/9
     *
     * @param dataList 需要添加的数据
     */
    public void setDataList(List<T> dataList) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    /**
     * Description:添加数据
     * Date:2018/3/9
     *
     * @param dataList 需要添加的数据
     */
    public void addDataList(List<T> dataList) {
        addDataList(dataList, false);
    }

    /**
     * Description:添加数据
     * Date:2018/3/9
     *
     * @param dataList  需要添加的数据
     * @param isRefresh 是否是刷新,如果为 true 则会先清空当前数据再添加,为 false 则会追加
     */
    public void addDataList(List<T> dataList, boolean isRefresh) {
        if (dataList == null) {
            dataList = new ArrayList<>();
        }
        if (isRefresh) {
            this.dataList.clear();
        }
        this.dataList.addAll(dataList);
        if (isRefresh) {
            notifyDataSetChanged();
        } else {
            notifyItemRangeInserted(this.dataList.size() - dataList.size(), this.dataList.size());
        }
    }

    /**
     * Description:设置 item 的点击监听器
     * Date:2018/3/9
     */
    public void setOnItemClickListener(IOnItemClickListener<T> onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /**
     * Description:设置 item 的长按点击监听器
     * Date:2018/3/9
     */
    public void setOnItemLongClickListener(IOnItemLongClickListener<T> onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public void setEmptyView(View emptyView) {
        mEmptyView = emptyView;
    }

    public View getEmptyView() {
        return mEmptyView;
    }
}