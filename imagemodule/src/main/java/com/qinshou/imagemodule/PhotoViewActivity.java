package com.qinshou.imagemodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bm.library.PhotoView;
import com.qinshou.imagemodule.util.ImageLoadUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:查看大图的界面，使用 ViewPager，可左右滑动。
 * 每个图片可点击放大，手势缩放，旋转。
 * Date:2018/3/9
 */
public class PhotoViewActivity extends AppCompatActivity {
    private static final String IMAGE_LIST = "imageList";
    private static final String INDEX = "index";
    private ViewPager vpPhotoView;
    private ArrayList mImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        //初始化控件
        vpPhotoView = findViewById(R.id.vp_photo_view);
        final TextView tvIndex = findViewById(R.id.tv_index);
        //初始化数据
        mImageList = getIntent().getStringArrayListExtra(IMAGE_LIST);
        final List<View> viewList = new ArrayList<>();
        if (mImageList != null && !mImageList.isEmpty()) {
            for (int i = 0; i < mImageList.size(); i++) {
                //创建 PhotoView
                PhotoView photoView = new PhotoView(this);
                //设置图片
                ImageLoadUtil.SINGLETON.loadImage(this, mImageList.get(i), photoView);
                //开启缩放功能
                photoView.enable();
                //设置图片显示类型
                photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //点击图片关闭界面
                photoView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                //长按图片
                photoView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        return false;
                    }
                });
                //将 PhotoView 添加到容器中
                viewList.add(photoView);
            }
            //初始化下标指示文本
            tvIndex.setText("1/" + mImageList.size());
        }
        //ViewPager 添加适配器,将 PhotoView 填充进 ViewPager
        vpPhotoView.setAdapter(new PagerAdapter() {
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

        });
        //ViewPager 添加页卡滑动的监听器,动态修改下标指示文本
        vpPhotoView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mImageList != null && !mImageList.isEmpty()) {
                    tvIndex.setText((position + 1) + "/" + mImageList.size());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        int index = getIntent().getIntExtra(INDEX, 0);
        if (index >= 0) {
            vpPhotoView.setCurrentItem(index);
        }
    }

    /**
     * Description:获取跳转到该界面的 Intent
     * Date:2018/3/9
     *
     * @param context   上下文环境
     * @param imageList 要显示的图片列表,元素类型可以是 Bitmap,String 类型的 url,int 类型的资源 Id
     */
    public static Intent getJumpIntent(Context context, ArrayList imageList) {
        return getJumpIntent(context, imageList, 0);
    }

    /**
     * Description:获取跳转到该界面的 Intent
     * Date:2018/3/9
     *
     * @param context   上下文环境
     * @param imageList 要显示的图片列表,元素类型可以是 Bitmap,String 类型的 url,int 类型的资源 Id
     * @param index     指定显示第几张图片,默认 0,显示第一张
     */
    public static Intent getJumpIntent(Context context, ArrayList imageList, int index) {
        Intent mIntent = new Intent(context, PhotoViewActivity.class);
        mIntent.putExtra(IMAGE_LIST, imageList);
        mIntent.putExtra(INDEX, index);
        return mIntent;
    }
}
