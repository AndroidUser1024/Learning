package com.qinshou.qinshoubox.homepage.model;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.homepage.transformer.QinshouBoxApiTransformer;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQinshouBoxApi;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 17:18
 * Description:{@link HomepageFragment} 的 M 层
 */
public class HomepageModel implements IHomepageContract.IModel {
    @Override
    public void getWallpaperList(Callback<List<WallpaperBean>> callback) {
        OkHttpHelperForQinshouBoxApi.SINGLETON.getWallpaperList(1, 5)
                .transform(new QinshouBoxApiTransformer<List<WallpaperBean>>())
                .enqueue(callback);
    }
}
