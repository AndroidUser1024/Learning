package com.qinshou.qinshoubox.me.ui.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.qinshou.commonmodule.background.BackgroundManager;
import com.qinshou.commonmodule.background.Background;
import com.qinshou.commonmodule.background.State;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.commonmodule.rcvbaseadapter.baseholder.BaseViewHolder;
import com.qinshou.commonmodule.rcvbaseadapter.listener.IOnItemClickListener;
import com.qinshou.commonmodule.util.SnackbarUtil;
import com.qinshou.commonmodule.util.SystemUtil;
import com.qinshou.commonmodule.util.permissionutil.IOnRequestPermissionResultCallBack;
import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;
import com.qinshou.imagemodule.callback.IOnImageChooseResultCallback;
import com.qinshou.imagemodule.util.BitmapUtil;
import com.qinshou.imagemodule.util.ImageChooseUtil;
import com.qinshou.imagemodule.util.ImagePathUtil;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.ui.adapter.RvPuzzleAdapter;
import com.qinshou.qinshoubox.me.bean.PuzzleItemBean;
import com.qinshou.qinshoubox.util.PuzzleUtil;

import java.util.List;

/**
 * Description:拼图游戏界面
 * Created by 禽兽先生
 * Created on 2018/8/29
 */
public class PuzzleActivity extends QSActivity<AbsPresenter> {
    private RecyclerView rvPuzzle;  //拼图块列表容器
    private RvPuzzleAdapter mRvPuzzleAdapter;   //拼图块列表适配器

    @Background(solid = 0xFFFFFF00, strokeColor = 0xFFFF0000, strokeWidth = 5, radius = 10)
    @Background(state = State.SELECTED, solid = 0xFF00FF00, strokeColor = 0xFFFF0000, strokeWidth = 5, radius = 10)
    @Background(state = State.PRESSED, solid = 0xFF00FF00, strokeColor = 0xFFFF0000, strokeWidth = 5, radius = 10)
    private Button btnChooseImg;    //选择相册中的图片按钮
    private Button btnChooseDifficulty; //选择难度按钮
    private Button btnShowOriginImg;    //显示原图按钮
    private Button btnReset;    //重置按钮
    private Bitmap mPuzzleBitmap;   //拼图图片
    private TextView tvStep;    //计步显示框
    private TextView tvTime;    //计时显示框
    private int step = 0;   //所用步数
    private int time = 0;   //所用时间,单位（s）
    private Handler mHandler;   //计时处理者
    private TimeRunnable mTimeRunnable; //计时线程

    @Override
    public int getLayoutId() {
        return R.layout.activity_puzzle;
    }

    @Override
    public void initView() {
        rvPuzzle = findViewByID(R.id.rv_puzzle);
        rvPuzzle.setLayoutManager(new GridLayoutManager(getContext(), PuzzleUtil.PUZZLE_TYPE));
        mRvPuzzleAdapter = new RvPuzzleAdapter(getContext());
        rvPuzzle.setAdapter(mRvPuzzleAdapter);

        btnChooseImg = findViewByID(R.id.btn_choose_img);
        btnChooseDifficulty = findViewByID(R.id.btn_choose_difficulty);
        btnShowOriginImg = findViewByID(R.id.btn_show_origin_img);
        btnReset = findViewByID(R.id.btn_reset);
        tvStep = findViewByID(R.id.tv_step);
        tvTime = findViewByID(R.id.tv_time);
        BackgroundManager.SINGLETON.init(this);
    }

    @Override
    public void setListener() {
        btnChooseImg.setOnClickListener(mOnClickListener);
        btnChooseDifficulty.setOnClickListener(mOnClickListener);
        btnShowOriginImg.setOnClickListener(mOnClickListener);
        btnReset.setOnClickListener(mOnClickListener);
        mRvPuzzleAdapter.setOnItemClickListener(new IOnItemClickListener<PuzzleItemBean>() {
            @Override
            public void onItemClick(BaseViewHolder holder, PuzzleItemBean puzzleItemBean, int position) {
                //如果已经成功了，重新加载
                if (PuzzleUtil.success(mRvPuzzleAdapter.getDataList())) {
                    loadPuzzle(mPuzzleBitmap);
                    return;
                }
                //如果当前点击的拼图块不能执行交换操作，则 return
                if (!PuzzleUtil.canSwap(position)) {
                    return;
                }
                //步数 +1
                step++;
                tvStep.setText("计步：" + step);
                //如果计时线程为空，开始计时
                if (mTimeRunnable == null) {
                    mTimeRunnable = new TimeRunnable();
                    mHandler.postDelayed(mTimeRunnable, 1000);
                }
                //得到交换后的拼图块数组
                List<PuzzleItemBean> puzzleItemBeanList = PuzzleUtil.swapPuzzleItemBean(mRvPuzzleAdapter.getDataList(), position);
                //如果已经拼图成功，则给出提示，停止计时
                if (PuzzleUtil.success(puzzleItemBeanList)) {
                    puzzleItemBeanList = PuzzleUtil.addMissingBitmap(puzzleItemBeanList);
                    SnackbarUtil.showSnackbar(getActivity(), "拼图成功");
                    mHandler.removeCallbacks(mTimeRunnable);
                    mTimeRunnable = null;
                }
                //刷新拼图块列表
                mRvPuzzleAdapter.setDataList(puzzleItemBeanList);
            }
        });
    }

    @Override
    public void initData() {
        //创建计时处理者
        HandlerThread handlerThread = new HandlerThread("TimeHandlerThread");
        handlerThread.start();
        mHandler = new Handler(handlerThread.getLooper());

        //加载一张默认的图片作为拼图图片
        loadPuzzle(BitmapFactory.decodeResource(getResources(), R.drawable.img_puzzle1));
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {
    }

    private void loadPuzzle(Bitmap bitmap) {
        //按比例缩放拼图图片，宽高均为屏幕宽高较小的那一个
        mPuzzleBitmap = BitmapUtil.scaleImage(bitmap, Math.min(SystemUtil.getScreenWidth(getContext()), SystemUtil.getScreenHeight(getContext()))
                , Math.min(SystemUtil.getScreenWidth(getContext()), SystemUtil.getScreenHeight(getContext())));
        //根据拼图图片获取拼图块数组
        List<PuzzleItemBean> puzzleItemBeanList = PuzzleUtil.getPuzzleItemBeanList(mPuzzleBitmap);
        //如果拼图块数组有解，则设置拼图块列表，如果没有解则重新创建
        if (PuzzleUtil.canResolve(puzzleItemBeanList)) {
            mRvPuzzleAdapter.setDataList(puzzleItemBeanList);
        } else {
            loadPuzzle(mPuzzleBitmap);
        }
        //重置所用步数和所用时间
        tvStep.setText("计步：0");
        tvTime.setText("计时：0m0s");
        step = 0;
        time = 0;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_choose_img:
                    chooseImg();
                    break;
                case R.id.btn_choose_difficulty:
                    chooseDifficulty();
//                    View viewByID = findViewByID(R.id.btn_choose_img);
//                    viewByID.setEnabled(!viewByID.isEnabled());
//                    viewByID.setSelected(!viewByID.isSelected());
                    break;
                case R.id.btn_show_origin_img:
                    showOriginImg();
                    break;
                case R.id.btn_reset:
                    loadPuzzle(mPuzzleBitmap);
                    break;
            }
        }
    };

    /**
     * author：MrQinshou
     * Description:选择相册中的图片作为拼图
     * date:2018/11/2 23:27
     * param
     * return
     */
    private void chooseImg() {
        PermissionUtil.requestPermission(getSupportFragmentManager(), new IOnRequestPermissionResultCallBack() {
            @Override
            public void onSuccess() {
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
                        loadPuzzle(BitmapFactory.decodeFile(path));
                    }
                });
            }

            @Override
            public void onFailure(List<String> deniedPermissionList) {

            }
        }, Manifest.permission.READ_EXTERNAL_STORAGE);
    }

    /**
     * author：选择难度，有 3*3、4*4、5*5
     * Description:TODO
     * date:2018/11/2 23:28
     * param
     * return
     */
    private void chooseDifficulty() {
        String[] items = new String[]{"3*3", "4*4", "5*5"};
        new AlertDialog.Builder(getContext())
                .setTitle("选择难度")
                .setIcon(R.mipmap.ic_launcher)
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            PuzzleUtil.PUZZLE_TYPE = 3;
                        } else if (which == 1) {
                            PuzzleUtil.PUZZLE_TYPE = 4;
                        } else if (which == 2) {
                            PuzzleUtil.PUZZLE_TYPE = 5;
                        }
                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rvPuzzle.setLayoutManager(new GridLayoutManager(getContext(), PuzzleUtil.PUZZLE_TYPE));
                        loadPuzzle(mPuzzleBitmap);
                    }
                })
                .create()
                .show();
    }

    /**
     * author：MrQinshou
     * Description:显示原图
     * date:2018/11/2 23:28
     * param
     * return
     */
    private void showOriginImg() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_show_origin_img, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                .setView(view)
                .setCancelable(true)
                .create();
        //设置对话框自带背景透明,才能显示布局的背景
        alertDialog.setCanceledOnTouchOutside(true);
        ImageView ivOriginImg = view.findViewById(R.id.iv_origin_img);
        ivOriginImg.setImageBitmap(mPuzzleBitmap);
        ivOriginImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    /**
     * author：MrQinshou
     * Description:计时线程
     * date:2018/11/2 23:28
     * param
     * return
     */
    private class TimeRunnable implements Runnable {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    time++;
                    int min = time / 60;
                    int seconds = time % 60;
                    tvTime.setText("计时：" + min + "m" + seconds + "s");
                }
            });
            mHandler.postDelayed(mTimeRunnable, 1000);
        }
    }

}
