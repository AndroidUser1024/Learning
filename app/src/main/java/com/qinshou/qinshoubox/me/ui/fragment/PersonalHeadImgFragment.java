package com.qinshou.qinshoubox.me.ui.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.util.activityresultutil.ActivityResultUtil;
import com.qinshou.commonmodule.util.activityresultutil.OnActivityResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.IOnRequestPermissionResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;
import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.imagemodule.callback.Callback;
import com.qinshou.imagemodule.callback.IOnImageChooseResultCallback;
import com.qinshou.imagemodule.callback.IOnImageCropResultCallback;
import com.qinshou.imagemodule.util.BitmapUtil;
import com.qinshou.imagemodule.util.ImageChooseUtil;
import com.qinshou.imagemodule.util.ImageCropUtil;
import com.qinshou.imagemodule.util.ImageLoadUtil;
import com.qinshou.imagemodule.util.ImagePathUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IPersonalHeadImgContract;
import com.qinshou.qinshoubox.me.presenter.PersonalHeadImgPresenter;
import com.qinshou.qinshoubox.me.ui.dialog.PersonalHeadImgDialog;
import com.qinshou.qinshoubox.util.QSUtil;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;
import com.qinshou.qrcodemodule.decode.ImageUtil;

import org.greenrobot.eventbus.EventBus;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 16:40
 * Description:个人头像界面
 */
public class PersonalHeadImgFragment extends QSFragment<PersonalHeadImgPresenter> implements IPersonalHeadImgContract.IView {
    /**
     * 打开系统相机的意图的请求码
     */
    private static final int TAKE_PHOTO_REQUEST_CODE = 100;
    /**
     * 打开系统图库界面的意图的请求码
     */
    private static final int PICK_PHOTO_REQUEST_CODE = 101;
    /**
     * 打开系统裁剪图片的意图的请求码
     */
    private static final int CROP_PHOTO_REQUEST_CODE = 102;

    /**
     * 头像
     */
    private ImageView mIvHeadImg;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_head_img;
    }

    @Override
    public void initView() {
        mIvHeadImg = findViewByID(R.id.iv_head_img);
    }

    @Override
    public void setListener() {
        ((TitleBar) findViewByID(R.id.title_bar)).setLeftImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TitleBar) findViewByID(R.id.title_bar)).setRightImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalHeadImgDialog personalHeadImgDialog = new PersonalHeadImgDialog();
                personalHeadImgDialog.setOnDismissListener(new PersonalHeadImgDialog.IOnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface, PersonalHeadImgDialog.Type type) {
                        if (type == PersonalHeadImgDialog.Type.TAKE_PHOTO) {
                            PermissionUtil.requestPermission(getChildFragmentManager(), new IOnRequestPermissionResultCallBack() {
                                @Override
                                public void onSuccess() {
                                    takePhoto();
                                }

                                @Override
                                public void onFailure(List<String> list) {
                                    toastShort(getString(R.string.common_get_camera_permission_failure));
                                }
                            }, Manifest.permission.CAMERA);
                        } else if (type == PersonalHeadImgDialog.Type.PICK_PHOTO) {
                            PermissionUtil.requestPermission(getChildFragmentManager(), new IOnRequestPermissionResultCallBack() {
                                @Override
                                public void onSuccess() {
                                    pickPhoto();
                                }

                                @Override
                                public void onFailure(List<String> list) {
                                    toastShort(getString(R.string.common_get_external_storage_permission_failure));
                                }
                            }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                        } else if (type == PersonalHeadImgDialog.Type.SAVE_IMAGE) {
                            PermissionUtil.requestPermission(getChildFragmentManager(), new IOnRequestPermissionResultCallBack() {
                                @Override
                                public void onSuccess() {
                                    saveImage();
                                }

                                @Override
                                public void onFailure(List<String> list) {
                                    toastShort(getString(R.string.common_get_external_storage_permission_failure));
                                }
                            }, Manifest.permission.WRITE_EXTERNAL_STORAGE);

                        }
                    }
                });
                personalHeadImgDialog.show(getChildFragmentManager(), "PersonalHeadImgDialog");
            }
        });
    }

    @Override
    public void initData() {
        mIvHeadImg.post(new Runnable() {
            @Override
            public void run() {
                // 重新设置头像控件大小,为正方形
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mIvHeadImg.getLayoutParams();
                layoutParams.width = Math.min(mIvHeadImg.getMeasuredWidth(), mIvHeadImg.getMeasuredHeight());
                layoutParams.height = Math.min(mIvHeadImg.getMeasuredWidth(), mIvHeadImg.getMeasuredHeight());
                mIvHeadImg.setLayoutParams(layoutParams);
                ImageLoadUtil.SINGLETON.loadImage(getContext(), UserStatusManager.SINGLETON.getUserBean().getHeadImg(), mIvHeadImg);
            }
        });
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    @Override
    public void setHeadImgSuccess(UserBean userBean) {
        UserStatusManager.SINGLETON.getUserBean().setHeadImg(userBean.getHeadImg());
        UserStatusManager.SINGLETON.getUserBean().setHeadImgSmall(userBean.getHeadImgSmall());
        // 设置头像
        ImageLoadUtil.SINGLETON.loadImage(getContext(), userBean.getHeadImg(), mIvHeadImg);
        EventBus.getDefault().post(new EventBean<Object>(EventBean.Type.REFRESH_USER_BEAN, null));
    }

    @Override
    public void setHeadImgFailure(Exception e) {
        toastShort(e.getMessage());
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/14 11:22
     * Description:调用系统相机进行拍照
     */
    public void takePhoto() {
        // 创建一个临时文件,会在上传成功后删除
        final File file = new File(QSUtil.getPicturePath() + "temp.jpg");
        // 如果已经存在,则已存在
        if (file.exists()) {
            file.delete();
        }
        // 创建新文件
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 根据文件路径获取 uri
        final Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(getActivity(), getActivity().getPackageName() + ".fileprovider", file);
        } else {
            uri = Uri.fromFile(file);
        }
        // 创建打开相机的 intent
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 指定照片存储路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        ActivityResultUtil.startActivityForResult(getActivity(), intent, TAKE_PHOTO_REQUEST_CODE, new OnActivityResultCallBack() {
            @Override
            public void onActivityResult(int i, int i1, Intent intent) {
                // 请求码和返回码不对则 return
                if (i != TAKE_PHOTO_REQUEST_CODE || i1 != Activity.RESULT_OK) {
                    return;
                }
                // 裁剪图片
                cropPhoto(uri);
            }
        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/14 11:52
     * Description:裁剪图片
     *
     * @param uri 保存图片结果的 Uri
     */
    private void cropPhoto(final Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        }
        // 指定文件类型
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // 设置保持比例
        intent.putExtra("scale", true);
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", Math.min(mIvHeadImg.getMeasuredWidth(), mIvHeadImg.getMeasuredHeight()));
        intent.putExtra("outputY", Math.min(mIvHeadImg.getMeasuredWidth(), mIvHeadImg.getMeasuredHeight()));
        // 不需要返回裁剪后的图片数据
        intent.putExtra("return-data", false);
        // 设置输出的格式
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        // 设置输出的地址
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        // 不启用人脸识别
        intent.putExtra("noFaceDetection", true);
        ActivityResultUtil.startActivityForResult(getActivity(), intent, CROP_PHOTO_REQUEST_CODE, new OnActivityResultCallBack() {
            @Override
            public void onActivityResult(int i, int i1, Intent intent) {
                // 请求码和返回码不对则 return
                if (i != CROP_PHOTO_REQUEST_CODE || i1 != Activity.RESULT_OK) {
                    return;
                }
                // 获取文件真实路径
                String path = ImageUtil.getImageAbsolutePath(getContext(), uri);
                if (path == null || "".equals(path)) {
                    toastShort(getString(R.string.personal_head_img_toast_take_photo_failure_text));
                    return;
                }
                // 上传头像
                File file = new File(path);
                getPresenter().setHeadImg(UserStatusManager.SINGLETON.getUserBean().getId(), file);
            }
        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/14 11:53
     * Description:选择图片
     */
    public void pickPhoto() {
//        Intent intent = new Intent(Intent.ACTION_PICK);
//        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
//        ActivityResultUtil.startActivityForResult(getActivity(), intent, PICK_PHOTO_REQUEST_CODE, new OnActivityResultCallBack() {
//            @Override
//            public void onActivityResult(int requestCode, int resultCode, Intent data) {
//                // 请求码和返回码不对则 return
//                if (requestCode != PICK_PHOTO_REQUEST_CODE || resultCode != Activity.RESULT_OK) {
//                    return;
//                }
//                // 数据为空则 return
//                if (data == null) {
//                    return;
//                }
//                Uri uri = data.getData();
//                // 获取图片的路径
//                String path = ImagePathUtil.getImageAbsolutePath(getContext(), uri);
//                if (path == null || "".equals(path)) {
//                    toastShort(getString(R.string.personal_head_img_toast_pick_photo_failure_text));
//                    return;
//                }
//                // 上传头像
//                FileTarget file = new FileTarget(path);
//                getPresenter().setHeadImg(UserStatusManager.SINGLETON.getUserBean().getId(), file);
//            }
//        });
        ImageChooseUtil.chooseImage(getActivity(), new IOnImageChooseResultCallback() {
            @Override
            public void onSuccess(List<Uri> uriList) {
                if (uriList == null || uriList.size() == 0) {
                    toastShort(getString(R.string.personal_head_img_toast_pick_photo_failure_text));
                    return;
                }
                String path = ImagePathUtil.getRealPathFromUri(getContext(), uriList.get(0));
                if (TextUtils.isEmpty(path)) {
                    toastShort(getString(R.string.personal_head_img_toast_pick_photo_failure_text));
                    return;
                }
                ArrayList<String> imagePathList = new ArrayList<>();
                imagePathList.add(path);
                ImageCropUtil.cropImage(getActivity(), imagePathList, new IOnImageCropResultCallback() {
                    @Override
                    public void onSuccess(List<String> resultList) {
                        if (resultList == null || resultList.size() == 0) {
                            toastShort(getString(R.string.personal_head_img_toast_pick_photo_failure_text));
                            return;
                        }
                        // 上传头像
                        File origin = new File(resultList.get(0));
                        File targetDir = new File(getContext().getCacheDir() + "/Image");
                        targetDir.mkdirs();
                        Luban.with(getContext())
                                .load(origin)
                                .ignoreBy(100)
                                .setTargetDir(targetDir.getAbsolutePath())
                                .filter(new CompressionPredicate() {
                                    @Override
                                    public boolean apply(String path) {
                                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                                    }
                                })
                                .setCompressListener(new OnCompressListener() {
                                    @Override
                                    public void onStart() {
                                        // 压缩开始前调用，可以在方法内启动 loading UI
                                    }

                                    @Override
                                    public void onSuccess(File file) {
                                        // 压缩成功后调用，返回压缩后的图片文件
                                        getPresenter().setHeadImg(UserStatusManager.SINGLETON.getUserBean().getId(), file);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        // 当压缩过程出现问题时调用
                                        ShowLogUtil.logi("onError: e--->" + e.getMessage());
                                    }
                                }).launch();
                    }
                });
            }
        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/5 11:17
     * Description:保存图片到手机
     */
    private void saveImage() {
        ImageLoadUtil.SINGLETON.getImage(getContext(), UserStatusManager.SINGLETON.getUserBean().getHeadImg(), new Callback() {
            @Override
            public void onSuccess(Drawable drawable) {
                Bitmap bitmap = BitmapUtil.drawable2Bitmap(drawable);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
                // 保存文件
                FileOutputStream fileOutputStream = null;
                try {
                    File file = new File(QSUtil.getPicturePath()
                            + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis())
                            + ".jpg"));
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
                    fileOutputStream.flush();
                    toastShort(getString(R.string.personal_head_img_toast_save_image_success_text, file.getAbsolutePath()));
                } catch (IOException e) {
                    toastShort(getString(R.string.personal_head_img_toast_save_image_failure_text));
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onFailure(String s, Drawable drawable) {
                toastShort(getString(R.string.personal_head_img_toast_save_image_failure_text));
            }
        });
    }
}