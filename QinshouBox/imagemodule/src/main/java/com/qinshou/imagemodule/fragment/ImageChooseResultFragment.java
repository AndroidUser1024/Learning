package com.qinshou.imagemodule.fragment;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.qinshou.imagemodule.R;
import com.qinshou.imagemodule.callback.OnImageChooseResultCallback;
import com.qinshou.imagemodule.imageengine.Glide4Engine;
import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Description:选择图片的结果的无界面的代理 Fragment
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ImageChooseResultFragment extends Fragment {
    public static final int REQUEST_CODE = 200;
    //    public static final int RESULT_CODE = 201;
    private OnImageChooseResultCallback mCallBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivityForResult(int maxSize, OnImageChooseResultCallback onImageChooseResultCallback) {
        this.mCallBack = onImageChooseResultCallback;
        Matisse.from(this)
                //设置可选择图片类型
                .choose(MimeType.ofAll())
                .theme(R.style.Matisse_Dracula) //主题有两个 蓝色 R.style.Matisse_Zhihu |黑暗 R.style.Matisse_Dracula
                .countable(true)
                //最大选中张数
                .maxSelectable(maxSize)
                //图片引擎，知乎内部集成的 Glide3，所以如果图片加载库使用 Glide4 的话需自定义引擎
                .imageEngine(new Glide4Engine())
                .thumbnailScale(0.85f)
                //设置允许拍照
                .capture(true)
                //设置拍照策略，如果允许拍照则必须进行该设置
                .captureStrategy(new CaptureStrategy(true, getContext().getApplicationInfo().processName + ".fileProvider"))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                .forResult(REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE
                && resultCode == RESULT_OK
                && mCallBack != null) {
            List<Uri> uriList = Matisse.obtainResult(data);
            ArrayList<String> resultsPathList = new ArrayList<>();
            List<Bitmap> results = new ArrayList<>();
            for (int i = 0; i < uriList.size(); i++) {
                String path = getPath(uriList.get(i));
                if (!TextUtils.isEmpty(path)) {
                    resultsPathList.add(path);
                    Bitmap bitmap = BitmapFactory.decodeFile(path);
                    results.add(bitmap);
                }
            }
            mCallBack.onSuccess(resultsPathList);
            mCallBack.onSuccess(results);
        }
    }

    /**
     * Description:根据 Uri 得到路径
     * Date:2018/4/20
     */
    private String getPath(Uri uri) {
        String path = null;
        Cursor cursor = getContext().getContentResolver().query(uri, new String[]{MediaStore.Images.Media.DATA}, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                if (columnIndex > -1) {
                    path = cursor.getString(columnIndex);
                }
            }
            cursor.close();
        }
        return path;
    }
}
