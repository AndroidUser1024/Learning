package com.qinshou.qinshoubox.knowledgesystem.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qinshou.commonmodule.adapter.RcvSingleBaseAdapter;
import com.qinshou.commonmodule.adapter.holder.BaseViewHolder;
import com.qinshou.commonmodule.widget.FlowLayout;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.knowledgesystem.bean.KnowledgeSystemBean;

/**
 * Description:首页文章的适配器
 * Created by 禽兽先生
 * Created on 2018/4/6
 */

public class RvKnowledgeSystemAdapter extends RcvSingleBaseAdapter<KnowledgeSystemBean> {
    public RvKnowledgeSystemAdapter(Context context) {
        super(context, R.layout.item_rv_knowledge_system);
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, final KnowledgeSystemBean itemData, int position) {
        holder.setTvText(R.id.tv_level_1_catalog, itemData.getName());
        FlowLayout flowLayout = holder.findViewById(R.id.flow_layout);
        flowLayout.removeAllViews();
        for (int i =0;i<itemData.getChildren().size();i++) {
            //添加二级目录
            TextView mTextView = new TextView(getContext());
            ViewGroup.MarginLayoutParams mMarginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mMarginLayoutParams.rightMargin= 15;
            mMarginLayoutParams.topMargin=10;
            mMarginLayoutParams.bottomMargin = 10;
            mTextView.setLayoutParams(mMarginLayoutParams);
            mTextView.setTextSize(14);
            mTextView.setText(itemData.getChildren().get(i).getName());
            flowLayout.addView(mTextView);
        }
        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}
