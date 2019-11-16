package com.qinshou.qinshoubox.knowledgesystem.ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.Settings;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.Result;
import com.qinshou.commonmodule.util.ScreenShotsUtil;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.commonmodule.widget.FlowLayout;
import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.qinshoubox.R;
import com.qinshou.qinshoubox.base.QSFragment;
import com.qinshou.qinshoubox.knowledgesystem.adapter.RvKnowledgeSystemAdapter;
import com.qinshou.qinshoubox.knowledgesystem.ui.activity.SearchActivity;
import com.qinshou.qrcodemodule.ICaptureView;
import com.qinshou.qrcodemodule.camera.CameraManager;
import com.qinshou.qrcodemodule.handler.CaptureHandler;
import com.qinshou.qrcodemodule.manager.ConfigManager;
import com.qinshou.qrcodemodule.widget.ViewfinderView;

/**
 * Description:知识体系界面
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class KnowledgeSystemFragment extends QSFragment {

    private RvKnowledgeSystemAdapter mRvKnowledgeSystemAdapter;
    private RefreshLayout refreshLayout;
    private FlowLayout flHotSearchWords;
    private FlowLayout flCommonWebSites;
    private int[] colors = new int[]{Color.parseColor("#FF7256AB")
            , Color.parseColor("#FF6B6D55")
            , Color.parseColor("#FFD455C0")
            , Color.parseColor("#FF9AA267")
            , Color.parseColor("#FF7FE0BF")
            , Color.parseColor("#FF3D977B")
            , Color.parseColor("#FFEA3778")};
    private AppBarLayout appBarLayout;
    private ConstraintLayout layoutFunctionsSmall;
    private LinearLayout layoutFunctionsBig;
    private ImageButton ibScanQRCodeBig;
    private ImageButton ibScanQRCodeSmall;
    private ImageButton ibScreenShotsBig;
    private ImageButton ibScreenShotsSmall;
    private ImageButton ibPayWayBig;
    private ImageButton ibPayWaySmall;
    private ImageButton ibSearchBig;
    private ImageButton ibSearchSmall;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_knowledge_system;
    }

    @Override
    public void initView() {
//        RecyclerView rvKnowledgeSystem = findViewByID(R.id.rv_knowledge_system);
//        rvKnowledgeSystem.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        mRvKnowledgeSystemAdapter = new RvKnowledgeSystemAdapter(getContext());
//        rvKnowledgeSystem.setAdapter(mRvKnowledgeSystemAdapter);
//        rvKnowledgeSystem.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
//        rvKnowledgeSystem.setNestedScrollingEnabled(false);
//
//        refreshLayout = findViewByID(R.id.refresh_layout);
//        refreshLayout.canLoadMore(false);
//
        flHotSearchWords = (FlowLayout) findViewByID(R.id.fl_hot_search_words);
        flHotSearchWords.removeAllViews();
        for (int i = 0; i < 20; i++) {
            //添加二级目录
            TextView mTextView = new TextView(getContext());
            ViewGroup.MarginLayoutParams mMarginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mMarginLayoutParams.rightMargin = 15;
            mMarginLayoutParams.topMargin = 10;
            mMarginLayoutParams.bottomMargin = 10;
            mTextView.setLayoutParams(mMarginLayoutParams);
            mTextView.setTextSize(14);
            mTextView.setText("测试文字" + i);
            ShowLogUtil.logi("mTextView--->" + mTextView.getMeasuredWidth());
            ShowLogUtil.logi("mTextView--->" + mTextView.getMeasuredHeight());
            flHotSearchWords.addView(mTextView);
        }
        ShowLogUtil.logi("flHotSearchWords--->" + flHotSearchWords.getMeasuredHeight());
//        flCommonWebSites = findViewByID(R.id.fl_common_web_sites);
//        appBarLayout = findViewByID(R.id.app_bar_layout);
//        layoutFunctionsBig = findViewByID(R.id.layout_functions_big);
//        layoutFunctionsSmall = findViewByID(R.id.layout_functions_small);
//        ibSearchBig = findViewByID(R.id.ib_search_big);
//        ibSearchSmall = findViewByID(R.id.ib_search_small);
//        ibScanQRCodeBig = findViewByID(R.id.ib_scan_qr_code_big);
//        ibScanQRCodeSmall = findViewByID(R.id.ib_scan_qr_code_small);
//        ibScreenShotsBig = findViewByID(R.id.ib_screen_shots_big);
//        ibScreenShotsSmall = findViewByID(R.id.ib_screen_shots_small);
//        ibPayWayBig = findViewByID(R.id.ib_pay_way_big);
//        ibPayWaySmall = findViewByID(R.id.ib_pay_way_small);
    }


    @Override
    public void setListener() {
//        refreshLayout.setOnRefreshListener(new RefreshLayout.IOnRefreshListener() {
//            @Override
//            public void onRefresh(RefreshLayout refreshLayout) {
//                initData();
//            }
//        });
//
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                int height = layoutFunctionsBig.getMeasuredHeight();
//                layoutFunctionsSmall.setAlpha((float) Math.abs(verticalOffset) / (float) height);
//                layoutFunctionsBig.setAlpha(1 - (float) Math.abs(verticalOffset) / (float) height);
//                layoutFunctionsSmall.setVisibility(layoutFunctionsSmall.getAlpha() == 0 ? View.GONE : View.VISIBLE);
//            }
//        });
//        ibPayWayBig.setOnClickListener(mOnClickListener);
//        ibSearchSmall.setOnClickListener(mOnClickListener);
//        ibSearchBig.setOnClickListener(mOnClickListener);
//        ibScanQRCodeSmall.setOnClickListener(mOnClickListener);
//        ibScreenShotsSmall.setOnClickListener(mOnClickListener);
//        ibScanQRCodeBig.setOnClickListener(mOnClickListener);
//        ibScreenShotsBig.setOnClickListener(mOnClickListener);
//        ibPayWaySmall.setOnClickListener(mOnClickListener);
    }

    @Override
    public void initData() {
//        WanAndroidApi.getInstance().getHotSearchWords(new BaseObserver<List<HotSearchWordsBean>>() {
//            @Override
//            public void onNext(List<HotSearchWordsBean> value) {
//                flHotSearchWords.removeAllViews();
//                for (int i = 0; i < value.size(); i++) {
//                    final TextView mTextView = new TextView(getContext());
//                    ViewGroup.MarginLayoutParams mMarginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                    mMarginLayoutParams.rightMargin = 30;
//                    mMarginLayoutParams.topMargin = 15;
//                    mMarginLayoutParams.bottomMargin = 15;
//                    mTextView.setLayoutParams(mMarginLayoutParams);
//                    mTextView.setTextSize(20);
//                    mTextView.setTextColor(colors[new Random().nextInt(colors.length)]);
//                    mTextView.setText(value.get(i).getName());
//                    mTextView.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            startActivity(SearchActivity.getJumpIntent(getContext(), mTextView.getText().toString()));
//                        }
//                    });
//                    flHotSearchWords.addView(mTextView);
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });
//        WanAndroidApi.getInstance().getCommonWebSite(new BaseObserver<List<CommonWebSiteBean>>() {
//
//            @Override
//            public void onNext(List<CommonWebSiteBean> value) {
//                flCommonWebSites.removeAllViews();
//                for (int i = 0; i < value.size(); i++) {
//                    TextView mTextView = new TextView(getContext());
//                    ViewGroup.MarginLayoutParams mMarginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                    mMarginLayoutParams.rightMargin = 15;
//                    mMarginLayoutParams.topMargin = 10;
//                    mMarginLayoutParams.bottomMargin = 10;
//                    mTextView.setLayoutParams(mMarginLayoutParams);
//                    mTextView.setTextSize(20);
//                    mTextView.setTextColor(colors[new Random().nextInt(colors.length)]);
//                    mTextView.setText(value.get(i).getName());
//                    flCommonWebSites.addView(mTextView);
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//        });
//        WanAndroidApi.getInstance().getKnowledgeSystem(new BaseObserver<List<KnowledgeSystemBean>>() {
//
//            @Override
//            public void onNext(List<KnowledgeSystemBean> value) {
//                mRvKnowledgeSystemAdapter.setDataList(value);
//                refreshLayout.stopRefreshAndLoadMore();
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                refreshLayout.stopRefreshAndLoadMore();
//            }
//
//        });
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.ib_search_big:
                case R.id.ib_search_small:
                    startActivity(SearchActivity.getJumpIntent(getContext(), null));
                    break;
                case R.id.ib_scan_qr_code_big:
                case R.id.ib_scan_qr_code_small:
//                    QRCodeUtil.startScanQRCode((AppCompatActivity) getActivity(), new OnScanQRCodeCallback() {
//                        @Override
//                        public void onSuccess(int width, int height, String result) {
//                        }
//
//                        @Override
//                        public void onFailure(String errorInfo) {
//
//                        }
//                    });
//                    startActivity(new Intent(getContext(), CaptureActivity.class));
                    break;
                case R.id.ib_screen_shots_big:
                case R.id.ib_screen_shots_small:
                    Bitmap bitmap = ScreenShotsUtil.shotActivity(getActivity());
                    break;
                case R.id.ib_pay_way_big:
                case R.id.ib_pay_way_small:
                    Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                    startActivity(intent);
                    break;
            }
        }
    };
    private ICaptureView mCaptureView = new ICaptureView() {
        @Override
        public ConfigManager getConfigManager() {
            return null;
        }

        @Override
        public CameraManager getCameraManager() {
            return null;
        }

        @Override
        public CaptureHandler getCaptureHandler() {
            return null;
        }

        @Override
        public ViewfinderView getViewfinderView() {
            return null;
        }

        @Override
        public void handleDecode(Result rawResult) {

        }
    };
}
