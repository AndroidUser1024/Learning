package com.qinshou.imagemodule.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.qinshou.imagemodule.callback.OnImageCropResultCallback;
import com.yanzhenjie.durban.Controller;
import com.yanzhenjie.durban.Durban;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

/**
 * Description:选择图片的结果的无界面的代理 Fragment
 * Created by 禽兽先生
 * Created on 2018/4/18
 */

public class ImageCropResultFragment extends Fragment {
    public static final int REQUEST_CODE = 200;
    //    public static final int RESULT_CODE = 201;
    private OnImageCropResultCallback mCallBack;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void startActivityForResult(ArrayList<String> imagePathList, OnImageCropResultCallback onImageCropResultCallback) {
        this.mCallBack = onImageCropResultCallback;
        Durban.with(this)
                // Che title of the UI.
                //TitleBar 标题
                .title("Crop")
//                .statusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark))
//                .toolBarColor(ContextCompat.getColor(this, R.color.colorPrimary))
//                .navigationBarColor(ContextCompat.getColor(this, R.color.colorPrimaryBlack))
                // Image path list/array.
                //需裁剪的图片路径集合
                .inputImagePaths(imagePathList)
                // Image output directory.
//                .outputDirectory(cropDirectory)
                // Image size limit.
                //最大宽高
                .maxWidthHeight(500, 500)
                // Aspect ratio.
                .aspectRatio(1, 1)
                // Output format: JPEG, PNG.
                .compressFormat(Durban.COMPRESS_JPEG)
                // Compress quality, see Bitmap#compress(Bitmap.CompressFormat, int, OutputStream)
                .compressQuality(90)
                // Gesture: ROTATE, SCALE, ALL, NONE.
                //支持哪些手势
                .gesture(Durban.GESTURE_SCALE)
                .controller(
                        Controller.newBuilder() // Create Builder of Controller.
                                .enable(false) // Enable the control panel.
                                .rotation(true) // Rotation button.
                                .rotationTitle(true) // Rotation button title.
                                .scale(true) // Scale button.
                                .scaleTitle(true) // Scale button title.
                                .build()) // Create Controller Config.
                .requestCode(REQUEST_CODE)
                .start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE
                && resultCode == RESULT_OK
                && mCallBack != null) {
            ArrayList<String> resultsPathList = Durban.parseResult(data);
            List<Bitmap> results = new ArrayList<>();
            for (int i = 0; i < resultsPathList.size(); i++) {
                Bitmap bitmap = BitmapFactory.decodeFile(resultsPathList.get(i));
                results.add(bitmap);
            }
            mCallBack.onSuccess(resultsPathList);
            mCallBack.onSuccess(results);
        }
    }
}
