package com.qinshou.qinshoubox.me.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.qinshou.commonmodule.database.DatabaseCondition;
import com.qinshou.commonmodule.database.DatabaseManager;
import com.qinshou.commonmodule.util.DialogUtil;
import com.qinshou.commonmodule.util.SharedPreferencesUtil;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.networkmodule.BaseObserver;
import com.qinshou.qinshoubox.me.bean.AFloor;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.Floor0;
import com.qinshou.qinshoubox.me.bean.Floor1;
import com.qinshou.qinshoubox.me.bean.Floor10;
import com.qinshou.qinshoubox.me.bean.Floor11;
import com.qinshou.qinshoubox.me.bean.Floor12;
import com.qinshou.qinshoubox.me.bean.Floor13;
import com.qinshou.qinshoubox.me.bean.Floor14;
import com.qinshou.qinshoubox.me.bean.Floor15;
import com.qinshou.qinshoubox.me.bean.Floor16;
import com.qinshou.qinshoubox.me.bean.Floor17;
import com.qinshou.qinshoubox.me.bean.Floor18;
import com.qinshou.qinshoubox.me.bean.Floor19;
import com.qinshou.qinshoubox.me.bean.Floor2;
import com.qinshou.qinshoubox.me.bean.Floor20;
import com.qinshou.qinshoubox.me.bean.Floor21;
import com.qinshou.qinshoubox.me.bean.Floor3;
import com.qinshou.qinshoubox.me.bean.Floor4;
import com.qinshou.qinshoubox.me.bean.Floor5;
import com.qinshou.qinshoubox.me.bean.Floor6;
import com.qinshou.qinshoubox.me.bean.Floor7;
import com.qinshou.qinshoubox.me.bean.Floor8;
import com.qinshou.qinshoubox.me.bean.Floor9;
import com.qinshou.qinshoubox.me.constant.Constant;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:地图管理类
 * Created by 禽兽先生
 * Created on 2018/4/11
 */

public class MapManager {
    private int floor;
    private List<AFloor> floorList;
    private TableLayout mTableLayout;

    private MapManager() {
        floor = 0;
        floorList = new ArrayList<>();
        floorList.add(new Floor0());
        floorList.add(new Floor1());
        floorList.add(new Floor2());
        floorList.add(new Floor3());
        floorList.add(new Floor4());
        floorList.add(new Floor5());
        floorList.add(new Floor6());
        floorList.add(new Floor7());
        floorList.add(new Floor8());
        floorList.add(new Floor9());
        floorList.add(new Floor10());
        floorList.add(new Floor11());
        floorList.add(new Floor12());
        floorList.add(new Floor13());
        floorList.add(new Floor14());
        floorList.add(new Floor15());
        floorList.add(new Floor16());
        floorList.add(new Floor17());
        floorList.add(new Floor18());
        floorList.add(new Floor19());
        floorList.add(new Floor20());
        floorList.add(new Floor21());
    }

    public static MapManager getInstance() {
        return SingleHolder.singleton;
    }


    private static class SingleHolder {
        private static final MapManager singleton = new MapManager();
    }

    public void initMap(TableLayout tableLayout) {
        if (tableLayout.getChildCount() != 11) {
            return;
        }
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            if (!(tableLayout.getChildAt(i) instanceof TableRow)) {
                return;
            }
            TableRow mTableRow = (TableRow) tableLayout.getChildAt(i);
            if (mTableRow.getChildCount() != 11) {
                return;
            }
            for (int j = 0; j < mTableRow.getChildCount(); j++) {
                if (!(mTableRow.getChildAt(j) instanceof ImageView)) {
                    return;
                }
            }
        }
        mTableLayout = tableLayout;
        floorList.get(floor).initFloor(tableLayout);
        floorList.get(floor).fromDownstairsToThisFloor();
    }

    /**
     * Description:获取某一格
     * Date:2018/4/25
     */
    public CaseBean getCase(int row, int column) {
        if (row < 0 || row > 11 || column < 0 || column > 11) {
            return null;
        }
        return floorList.get(floor).getCase(row, column);
    }

    /**
     * Description:重设某一格
     * Date:2018/4/25
     */
    public void setCase(int row, int column, CaseBean caseBean) {
        floorList.get(floor).setCase(row, column, caseBean);
    }

    /**
     * Description:更新整个地图的 UI
     * Date:2018/4/25
     */
    public void updateUI() {
        for (int i = 0; i < mTableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) mTableLayout.getChildAt(i);
            for (int j = 0; j < tableRow.getChildCount(); j++) {
                ImageView imageView = (ImageView) tableRow.getChildAt(j);
                CaseBean caseBean = floorList.get(floor).getCase(i, j);
                imageView.setImageResource(caseBean.getSpecificEntity(caseBean.getType()).getResourceId());
            }
        }
    }

    /**
     * Description:更新单个地图格的 UI
     * Date:2018/4/25
     */
    public void updateUI(CaseBean caseBean) {
//        ((ImageView) ((TableRow) mTableLayout.getChildAt(caseBean.getRow())).getChildAt(caseBean.getColumn())).setImageResource(caseBean.getSpecificEntity(caseBean.getType()).getResourceId());
        TableRow tableRow = (TableRow) mTableLayout.getChildAt(caseBean.getRow());
        ImageView imageView = (ImageView) tableRow.getChildAt(caseBean.getColumn());
        imageView.setImageResource(caseBean.getSpecificEntity(caseBean.getType()).getResourceId());
    }

    /**
     * author：MrQinshou
     * Description:上楼
     * date:2018/11/29 20:21
     * param
     * return
     */
    public void goUpstairs() {
        if (floor == floorList.size() - 1) {
            return;
        }
        floorList.get(floor).clearWarriorPosition();
        floor++;
        floorList.get(floor).initFloor(mTableLayout);
        floorList.get(floor).fromDownstairsToThisFloor();
    }

    /**
     * author：MrQinshou
     * Description:下楼
     * date:2018/11/29 20:21
     * param
     * return
     */
    public void goDownstairs() {
        if (floor == 0) {
            return;
        }
        floorList.get(floor).clearWarriorPosition();
        floor--;
        floorList.get(floor).initFloor(mTableLayout);
        floorList.get(floor).fromUpstairsToThisFloor();
    }

    /**
     * Description:保存地图所有楼层当前状态
     * Date:2018/11/22
     */
    public void save(final Context context) {
        Observable.create(new ObservableOnSubscribe<ProgressDialog>() {
            @Override
            public void subscribe(ObservableEmitter<ProgressDialog> emitter) {
                //显示不可取消的进度对话框，防止保存时再移动人物，导致数据错乱
                ProgressDialog progressDialog = new DialogUtil.Builder(context)
                        .setTitle("魔塔")
                        .setMessage("保存数据中，请稍后。")
                        .create()
                        .showWaitingDialog();
                emitter.onNext(progressDialog);
            }
        }).subscribeOn(AndroidSchedulers.mainThread())  //显示对话框在主线程中
                .observeOn(Schedulers.io()) //切换到子线程保存数据
                .doOnNext(new Consumer<ProgressDialog>() {
                    @Override
                    public void accept(ProgressDialog progressDialog) throws Exception {
                        //查询数据库中的数据，用于判断是更新还是新增
                        List<CaseBean> caseBeanList = DatabaseManager.getInstance().queryList(CaseBean.class, 1, 1);
                        //遍历所有层
                        for (int i = 0; i < floorList.size(); i++) {
                            List<List<CaseBean>> floor = floorList.get(i).getData();
                            //遍历所有行
                            for (int j = 0; j < floor.size(); j++) {
                                List<CaseBean> row = floor.get(j);
                                //遍历每一行
                                for (int k = 0; k < row.size(); k++) {
                                    try {
                                        if (caseBeanList.size() > 0) {
                                            //如果之前查询到的数据集合 size 大于 0 则表示之前有存储的进度，更新进度
                                            DatabaseManager.getInstance().update(row.get(k)
                                                    , new DatabaseCondition("floor", String.valueOf(i))
                                                    , new DatabaseCondition("row", String.valueOf(j))
                                                    , new DatabaseCondition("column", String.valueOf(k)));
                                        } else {
                                            //否则新增进度
                                            DatabaseManager.getInstance().insert(row.get(k));
                                        }
                                    } catch (IllegalAccessException e) {
                                        ShowLogUtil.logi(e.getMessage());
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        //保存当前楼层
                        SharedPreferencesUtil.putInt(context, Constant.FLOOR, floor);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())  //切换回主线程
                .subscribe(new BaseObserver<ProgressDialog>() {
                    @Override
                    public void onNext(ProgressDialog progressDialog) {
                        //给 Toast 提示，关闭对话框
                        Toast.makeText(context, "存储进度完毕", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onError(Throwable e) {
                        ShowLogUtil.loge("存储进度失败");
                    }
                });
    }

    /**
     * author：MrQinshou
     * Description:读取进度
     * date:2018/11/29 20:18
     * param
     * return
     */
    public void read(final Context context) {
        Observable.create(new ObservableOnSubscribe<ProgressDialog>() {
            @Override
            public void subscribe(ObservableEmitter<ProgressDialog> emitter) {
                //显示不可取消的进度对话框，防止读取时数据错乱
                ProgressDialog progressDialog = new DialogUtil.Builder(context)
                        .setTitle("魔塔")
                        .setMessage("读取数据中，请稍后。")
                        .create()
                        .showWaitingDialog();
                emitter.onNext(progressDialog);
            }
        }).subscribeOn(AndroidSchedulers.mainThread())  //显示对话框在主线程中
                .observeOn(Schedulers.io()) //切换到子线程中读取数据
                .doOnNext(new Consumer<ProgressDialog>() {
                    @Override
                    public void accept(ProgressDialog progressDialog) {
                        try {
                            //读取保存的数据
                            List<CaseBean> caseBeanList = DatabaseManager.getInstance().queryList(CaseBean.class);
                            if (caseBeanList.size() == 0) {
                                return;
                            }
                            //设置地图状态
                            for (CaseBean caseBean : caseBeanList) {
                                floorList.get(caseBean.getFloor()).setCase(caseBean.getRow(), caseBean.getColumn(), caseBean);
                            }
                            //设置当前楼层
                            floor = SharedPreferencesUtil.getInt(context, Constant.FLOOR);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())  //切换回主线程
                .subscribe(new BaseObserver<ProgressDialog>() {
                    @Override
                    public void onNext(ProgressDialog progressDialog) {
                        //给 Toast 提示，关闭对话框，更新地图 UI
                        Toast.makeText(context, "读取进度完毕", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                        updateUI();
                    }

                    @Override
                    public void onError(Throwable e) {
                        ShowLogUtil.loge("读取进度失败");
                    }
                });

    }

    public void setToCase2Road(CaseBean toCase) {
        toCase.setType(CaseBean.BUILDING_ROAD);
        setCase(toCase.getRow(), toCase.getColumn(), toCase);
        updateUI(toCase);
    }
}
