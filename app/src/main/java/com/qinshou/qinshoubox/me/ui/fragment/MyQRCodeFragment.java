package com.qinshou.qinshoubox.me.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.widget.TitleBar;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.contract.IMyQRCodeContract;
import com.qinshou.qinshoubox.me.presenter.MyQRCodePresenter;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/19 16:22
 * Description:我的二维码界面
 */
public class MyQRCodeFragment extends QSFragment<MyQRCodePresenter> implements IMyQRCodeContract.IView {
    private TitleBar mTitleBar;
    /**
     * 本人头像
     */
    private ImageView mIvHeadImg;
    /**
     * 本人昵称
     */
    private TextView mTvNickname;
    /**
     * 性别
     */
    private ImageView mIvGender;
    /**
     * 地区
     */
    private TextView mTvArea;
    /**
     * 二维码
     */
    private ImageView mIvQRCode;
    /**
     * 有效期
     */
    private TextView mTvQRCodeValidity;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_qr_code;
    }

    @Override
    public void initView() {
        mTitleBar = findViewByID(R.id.title_bar);
        mIvHeadImg = findViewByID(R.id.iv_head_img);
        mTvNickname = findViewByID(R.id.tv_nickname);
        mIvGender = findViewByID(R.id.iv_gender);
        mTvArea = findViewByID(R.id.tv_area);
        mIvQRCode = findViewByID(R.id.iv_qr_code);
        mTvQRCodeValidity = findViewByID(R.id.tv_qr_code_validity);
    }

    @Override
    public void setListener() {
        mTitleBar.setLeftTextOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitleBar.setRightImageOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MyQRCodeMoreDialog myQRCodeMoreDialog = new MyQRCodeMoreDialog();
//                myQRCodeMoreDialog.setOnDismissListener(new MyQRCodeMoreDialog.IOnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialogInterface, MyQRCodeMoreDialog.Type type) {
//                        if (type == MyQRCodeMoreDialog.Type.SAVE_QR_CODE) {
//                            saveQRCode();
//                        } else if (type == MyQRCodeMoreDialog.Type.SCAN_QR_CODE) {
//                            startActivity(new Intent(getContext(), ScanQRCodeActivity.class));
//                        } else if (type == MyQRCodeMoreDialog.Type.RESET_QR_CODE) {
//                            generateQRCode();
//                        }
//                    }
//                });
//                myQRCodeMoreDialog.show(getChildFragmentManager(), "MyQRCodeMoreDialog");
            }
        });
    }

    @Override
    public void initData() {
//        final UserBean userBean = JMClient.SINGLETON.getUserBean();
//        JeejioUtil.loadHeadImg(getContext(), userBean.getImgUrl(), mIvHeadImg);
//        mTvNickname.setText(userBean.getUserName());
//        // 设置性别
//        if (userBean.getSex() == 1) {
//            mIvGender.setImageResource(R.drawable.user_detail_iv_male_src);
//        } else if (userBean.getSex() == 2) {
//            mIvGender.setImageResource(R.drawable.user_detail_iv_female_src);
//        }
//        mTvArea.setText(userBean.getProvince() + " " + userBean.getCity());
//        mIvQRCode.post(new Runnable() {
//            @Override
//            public void run() {
//                generateQRCode();
//            }
//        });
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/5 11:17
     * Description:生成二维码
     */
    private void generateQRCode() {
//        final UserBean userBean = JMClient.SINGLETON.getUserBean();
//        // 根据用户信息生成 json 串
//        QRCodeResultBean qrCodeResultBean = new QRCodeResultBean(QRCodeResultBean.QRCodeType.ADD_FRIEND.getValue()
//                , userBean.getSysAccount()
//                , System.currentTimeMillis());
//        String json = new Gson().toJson(qrCodeResultBean);
//        // 生成二维码图片
//        Bitmap qrCode = CodeCreator.createQRCode(json, mIvQRCode.getMeasuredWidth(), mIvQRCode.getMeasuredHeight(), null);
//        mIvQRCode.setImageBitmap(qrCode);
//        // 计算过期时间,7 天后过期
//        String expirationTime = new SimpleDateFormat("MM月dd日").format(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7));
//        mTvQRCodeValidity.setText(getString(R.string.group_chat_qr_code_tv_qr_code_validity_text_prefix)
//                + expirationTime
//                + getString(R.string.group_chat_qr_code_tv_qr_code_validity_text_suffix));
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/5 11:17
     * Description:保存二维码到手机
     */
    private void saveQRCode() {
//        PermissionUtil.requestPermission(getChildFragmentManager(), new IOnRequestPermissionResultCallBack() {
//            @Override
//            public void onSuccess() {
//                ConstraintLayout clQRCode = findViewByID(R.id.cl_qr_code);
//                // 根据二维码所在整个布局,包括过期时间,群聊头像,群聊名称生成图片
//                Bitmap bitmap = Bitmap.createBitmap(clQRCode.getMeasuredWidth(),
//                        clQRCode.getMeasuredHeight(),
//                        Bitmap.Config.ARGB_8888);
//                Canvas canvas = new Canvas(bitmap);
//                clQRCode.draw(canvas);
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
//                // 保存文件
//                FileOutputStream fileOutputStream = null;
//                try {
//                    FileTarget file = new FileTarget(Environment.getExternalStorageDirectory()
//                            + FileTarget.separator
//                            + "JeejioMessage"
//                            + FileTarget.separator
//                            + "Picture"
//                            + FileTarget.separator
//                            + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(System.currentTimeMillis()))
//                            + ".jpg");
//                    if (!file.exists()) {
//                        file.getParentFile().mkdirs();
//                        file.createNewFile();
//                    }
//                    fileOutputStream = new FileOutputStream(file);
//                    fileOutputStream.write(byteArrayOutputStream.toByteArray());
//                    fileOutputStream.flush();
//                    toastShort(getString(R.string.my_qr_code_toast_save_success_text_prefix) + file.getAbsolutePath());
//                } catch (IOException e) {
//                    toastShort(getString(R.string.my_qr_code_toast_save_failure_text));
//                } finally {
//                    if (fileOutputStream != null) {
//                        try {
//                            fileOutputStream.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(List<String> list) {
//                toastShort(getString(R.string.my_qr_code_toast_save_failure_text));
//            }
//        }, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }
}