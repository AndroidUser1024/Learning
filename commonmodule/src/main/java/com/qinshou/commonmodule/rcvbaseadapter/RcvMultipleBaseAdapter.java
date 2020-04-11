package com.qinshou.commonmodule.rcvbaseadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.qinshou.commonmodule.rcvbaseadapter.RcvBaseAdapter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.BaseItemView;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.EmptyItemView;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.FooterItemView;
import com.qinshou.commonmodule.rcvbaseadapter.itemview.HeaderItemView;


/**
 * Description:item 为多布局类型的 RecyclerView 的适配器
 * 可以实现一对多（一个实体类对应多种布局）和多对多（多个实体类对应多个布局）
 * 使用时创建该适配器实例,创建不同的 ItemView 继承 BaseItemView,
 * 然后调用 addItemView() 方法传入 ItemView 即可
 * {@link BaseItemView}
 * BaseItemView 中有一个方法 isForViewType() 用来判断何时引入哪种子布局，多对多时不用覆盖该方法，内部会根据泛型的真实类型和
 * 该 position 的数据的类型判断，一对多时需覆盖该方法加入自己的逻辑判断，否则同一类型只会使用传入的第一个 ItemView
 * <p>
 * 内置了几个 ItemView
 * {@link EmptyItemView},快速实现空布局
 * {@link HeaderItemView},快速实现头布局
 * {@link FooterItemView},快速实现脚布局
 * Created by 禽兽先生
 * Created on 2018/4/9
 */

public class RcvMultipleBaseAdapter<T> extends RcvBaseAdapter<T> {
    private SparseArray<BaseItemView> mItemViewSparseArray = new SparseArray<>();
    private SparseArray<BaseItemView> mHeaderItemViewSparseArray = new SparseArray<>();
    private SparseArray<BaseItemView> mFooterItemViewSparseArray = new SparseArray<>();

    public RcvMultipleBaseAdapter(Context context) {
        super(context, 0);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mItemViewSparseArray.get(viewType).onCreateViewHolder(parent);
    }

    @Override
    public int getItemViewType(int position) {
        for (int i = 0; i < mItemViewSparseArray.size(); i++) {
            BaseItemView baseItemView = mItemViewSparseArray.valueAt(i);
            // 显示空布局
            if (showEmptyItemView()) {
                if (baseItemView instanceof EmptyItemView && baseItemView.isForViewType(null, position)) {
                    return mItemViewSparseArray.keyAt(i);
                } else {
                    continue;
                }
            }
            // 如果头布局数量大于 1,则判断该 position 是否是头布局
            int headerItemViewCount = getHeaderItemViewCount();
            if (position < headerItemViewCount) {
                if (baseItemView instanceof HeaderItemView && baseItemView.isForViewType(null, position)) {
                    return mItemViewSparseArray.keyAt(i);
                } else {
                    continue;
                }
            }
            // 如果脚布局数量大于 1,则判断该 position 是否是脚布局
            if (position >= getDataList().size() + headerItemViewCount) {
                if (baseItemView instanceof FooterItemView && baseItemView.isForViewType(null, position)) {
                    return mItemViewSparseArray.keyAt(i);
                } else {
                    continue;
                }
            }
            // 正常布局
            if (baseItemView.isForViewType(getDataList().get(position - headerItemViewCount), position)) {
                return mItemViewSparseArray.keyAt(i);
            }
        }
        throw new IllegalArgumentException("No ItemView added that matches position=" + position + " in data source");
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/11 15:29
     * Description:重写父类该方法,因为会有头布局和脚布局,所以在取数据时防止下标越界
     */
    @Override
    public void onBindViewHolder(final BaseViewHolder holder, int position) {
        final T itemData = getItemData(position);
        if (getOnItemClickListener() != null) {
            holder.getItemView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    getOnItemClickListener().onItemClick(holder, itemData, position);
                }
            });
        }
        if (getOnItemLongClickListener() != null) {
            holder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    getOnItemLongClickListener().onItemLongClick(holder, itemData, position);
                    return true;
                }
            });
        }
        bindViewHolder(holder, itemData, position);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, Object itemData, int position) {
        for (int i = 0; i < mItemViewSparseArray.size(); i++) {
            BaseItemView baseItemView = mItemViewSparseArray.valueAt(i);
            if (baseItemView.isForViewType(itemData, position)) {
                baseItemView.bindViewHolder(holder, itemData, position);
                return;
            }
        }
    }

    @Override
    public int getItemCount() {
        // 如果需要显示空布局,则返回固定数量 1
        if (showEmptyItemView()) {
            return 1;
        }
        // 要加上头布局和脚布局数量
        return super.getItemCount() + getHeaderItemViewCount() + getFooterItemViewCount();
    }

    public void addItemView(BaseItemView baseItemView) {
        baseItemView.setRcvBaseAdapter(this);
        mItemViewSparseArray.put(baseItemView.hashCode(), baseItemView);
        if (baseItemView instanceof HeaderItemView) {
            mHeaderItemViewSparseArray.put(mHeaderItemViewSparseArray.size(), baseItemView);
        }
        if (baseItemView instanceof FooterItemView) {
            mFooterItemViewSparseArray.put(mFooterItemViewSparseArray.size(), baseItemView);
        }
    }

    public void removeItemView(BaseItemView baseItemView) {
        mItemViewSparseArray.remove(baseItemView.hashCode());
        if (baseItemView instanceof HeaderItemView) {
            mHeaderItemViewSparseArray.removeAt(mHeaderItemViewSparseArray.indexOfValue(baseItemView));
        }
        if (baseItemView instanceof FooterItemView) {
            mFooterItemViewSparseArray.removeAt(mFooterItemViewSparseArray.indexOfValue(baseItemView));
        }
    }

    public SparseArray<BaseItemView> getHeaderItemViewSparseArray() {
        return mHeaderItemViewSparseArray;
    }

    public SparseArray<BaseItemView> getFooterItemViewSparseArray() {
        return mFooterItemViewSparseArray;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/11 15:20
     * Description:是否可以显示空布局
     */
    private boolean showEmptyItemView() {
        if (getDataList().size() > 0) {
            return false;
        }
        for (int i = 0; i < mItemViewSparseArray.size(); i++) {
            if (mItemViewSparseArray.valueAt(i) instanceof EmptyItemView) {
                return true;
            }
        }
        return false;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/11 15:20
     * Description:获取头布局数量
     */
    private int getHeaderItemViewCount() {
        int headerItemViewCount = 0;
        for (int i = 0; i < mItemViewSparseArray.size(); i++) {
            if (mItemViewSparseArray.valueAt(i) instanceof HeaderItemView) {
                headerItemViewCount++;
            }
        }
        return headerItemViewCount;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/4/11 15:20
     * Description:获取脚布局数量
     */
    private int getFooterItemViewCount() {
        int footerItemViewCount = 0;
        for (int i = 0; i < mItemViewSparseArray.size(); i++) {
            if (mItemViewSparseArray.valueAt(i) instanceof FooterItemView) {
                footerItemViewCount++;
            }
        }
        return footerItemViewCount;
    }

    private T getItemData(int position) {
        int headerItemViewCount = getHeaderItemViewCount();
        int footerItemViewCount = getFooterItemViewCount();
        // 头布局
        if (position < headerItemViewCount) {
            return null;
        }
        // 脚布局
        if (position >= getDataList().size() + headerItemViewCount) {
            return null;
        }
        return getDataList().get(position - headerItemViewCount);
    }
}
