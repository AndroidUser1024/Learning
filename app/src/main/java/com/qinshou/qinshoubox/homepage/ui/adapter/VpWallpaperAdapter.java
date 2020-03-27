
package com.qinshou.qinshoubox.homepage.ui.adapter;

import android.content.Context;

import androidx.viewpager2.widget.ViewPager2;

import com.qinshou.commonmodule.adapter.InfiniteCycleViewPagerAdapter2;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.imagemodule.PhotoViewActivity;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;

import java.util.ArrayList;

public class VpWallpaperAdapter extends InfiniteCycleViewPagerAdapter2<WallpaperBean> {

    public VpWallpaperAdapter(Context context, ViewPager2 viewPager2) {
        super(context, R.layout.item_rcv_wallpaper, viewPager2);
        setOnItemClickListener(new IOnItemClickListener<WallpaperBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, WallpaperBean itemData, int position) {
                ArrayList<String> imageList = new ArrayList<>();
                for (WallpaperBean wallpaperBean : getDataList()) {
                    imageList.add(wallpaperBean.getUrl());
                }
                getContext().startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList, position % getDataList().size()));
            }
        });
    }

    @Override
    public void bindViewHolder(BaseViewHolder holder, WallpaperBean itemData, int position) {
        ImageLoadUtil.SINGLETON.loadImage(getContext(), itemData.getUrl(), holder.getImageView(R.id.iv_wallpaper));
    }
}
