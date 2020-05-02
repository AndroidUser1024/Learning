package com.qinshou.qinshoubox.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;

import com.google.gson.Gson;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.homepage.bean.EventBean;
import com.qinshou.qinshoubox.me.bean.CaseBean;
import com.qinshou.qinshoubox.me.bean.IHandleEventCallback;
import com.qinshou.qinshoubox.me.bean.MagicTowerGameProgressBean;
import com.qinshou.qinshoubox.me.bean.Position;
import com.qinshou.qinshoubox.me.bean.building.Road;
import com.qinshou.qinshoubox.me.bean.floor.AbsFloor;
import com.qinshou.qinshoubox.me.bean.floor.Floor0;
import com.qinshou.qinshoubox.me.bean.floor.Floor1;
import com.qinshou.qinshoubox.me.bean.floor.Floor10;
import com.qinshou.qinshoubox.me.bean.floor.Floor11;
import com.qinshou.qinshoubox.me.bean.floor.Floor12;
import com.qinshou.qinshoubox.me.bean.floor.Floor13;
import com.qinshou.qinshoubox.me.bean.floor.Floor14;
import com.qinshou.qinshoubox.me.bean.floor.Floor15;
import com.qinshou.qinshoubox.me.bean.floor.Floor16;
import com.qinshou.qinshoubox.me.bean.floor.Floor17;
import com.qinshou.qinshoubox.me.bean.floor.Floor18;
import com.qinshou.qinshoubox.me.bean.floor.Floor19;
import com.qinshou.qinshoubox.me.bean.floor.Floor2;
import com.qinshou.qinshoubox.me.bean.floor.Floor20;
import com.qinshou.qinshoubox.me.bean.floor.Floor21;
import com.qinshou.qinshoubox.me.bean.floor.Floor3;
import com.qinshou.qinshoubox.me.bean.floor.Floor4;
import com.qinshou.qinshoubox.me.bean.floor.Floor5;
import com.qinshou.qinshoubox.me.bean.floor.Floor6;
import com.qinshou.qinshoubox.me.bean.floor.Floor7;
import com.qinshou.qinshoubox.me.bean.floor.Floor8;
import com.qinshou.qinshoubox.me.bean.floor.Floor9;
import com.qinshou.qinshoubox.me.bean.monster.AbsMonster;
import com.qinshou.qinshoubox.me.bean.warrior.WarriorBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 20-4-21 下午10:14
 * Description:
 */
public enum MagicGameManager {
    SINGLETON;

    private static final int MAX_ROW = 11;
    private static final int MAX_COLUMN = 11;
    private WarriorBean mWarriorBean;
    private List<AbsFloor> mFloorList = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private TableLayout mTableLayout;
    private int mCurrentFloor;
    private int mMaxFloorHaveBeTo;

    MagicGameManager() {
        mWarriorBean = new WarriorBean("勇士"
                , WarriorBean.Type.UP
                , 1
                , 1000
                , 10
                , 10
                , 0
                , 0
                , 0
                , 0
                , 0
                , false
                , false
                , false
                , false
                , new Position(9, 5));
        mFloorList.add(new Floor0());
        mFloorList.add(new Floor1());
        mFloorList.add(new Floor2());
        mFloorList.add(new Floor3());
        mFloorList.add(new Floor4());
        mFloorList.add(new Floor5());
        mFloorList.add(new Floor6());
        mFloorList.add(new Floor7());
        mFloorList.add(new Floor8());
        mFloorList.add(new Floor9());
        mFloorList.add(new Floor10());
        mFloorList.add(new Floor11());
        mFloorList.add(new Floor12());
        mFloorList.add(new Floor13());
        mFloorList.add(new Floor14());
        mFloorList.add(new Floor15());
        mFloorList.add(new Floor16());
        mFloorList.add(new Floor17());
        mFloorList.add(new Floor18());
        mFloorList.add(new Floor19());
        mFloorList.add(new Floor20());
        mFloorList.add(new Floor21());
        mCurrentFloor = 0;
        mMaxFloorHaveBeTo = 0;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//9 11:27
     * Description:获取某一格
     */
    private CaseBean getCase(Position position) {
        return mFloorList.get(mCurrentFloor).getCase(position);
    }

    public void setCase(Position position, CaseBean toCase) {
        this.setCase(mCurrentFloor, position, toCase);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//9 11:32
     * Description:重设某一格
     *
     * @param caseBean 格子对象
     */
    public void setCase(int floor, Position position, CaseBean caseBean) {
        mFloorList.get(floor).setCase(position, caseBean);
        if (floor == mCurrentFloor) {
            updateUI(position, caseBean);
        }
    }

    public WarriorBean getWarriorBean() {
        return mWarriorBean;
    }

    public void startGame(FragmentManager fragmentManager, TableLayout tableLayout) {
        mFragmentManager = fragmentManager;
        mTableLayout = tableLayout;
        if (tableLayout.getChildCount() != MAX_ROW) {
            return;
        }
        mFloorList.get(mCurrentFloor).initFloor(tableLayout);
        mFloorList.get(mCurrentFloor).fromDownstairsToThisFloor();

        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_CURRENT_FLOOR, mCurrentFloor));
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:18
     * Description:勇士向左移动
     */
    public void warriorMoveLeft() {
        // 勇士原来的位置
        Position oldPosition = mWarriorBean.getPosition();
        if (oldPosition.getColumn() == 0) {
            return;
        }
        // 勇士需要移动到的位置
        Position newPosition = new Position(oldPosition.getRow(), oldPosition.getColumn() - 1);
        mFloorList.get(mCurrentFloor).getCase(newPosition).handleEvent(mFragmentManager, mCurrentFloor, newPosition, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(WarriorBean.Type.LEFT);
                mWarriorBean.setPosition(newPosition);

                // 更新勇士现在的位置的 UI
                setCase(mWarriorBean.getPosition(), mWarriorBean);

                // 勇士原来的位置变成 Building.ROAD
                setCase(oldPosition, new Road());
            }

            @Override
            public void onFailure(Exception e) {
                ShowLogUtil.logi("onFailure" + " : " + e.getMessage());
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:18
     * Description:勇士向上移动
     */
    public void warriorMoveUp() {
        // 勇士原来的位置
        Position oldPosition = mWarriorBean.getPosition();
        if (oldPosition.getRow() == 0) {
            return;
        }
        // 勇士需要移动到的位置
        Position newPosition = new Position(oldPosition.getRow() - 1, oldPosition.getColumn());
        mFloorList.get(mCurrentFloor).getCase(newPosition).handleEvent(mFragmentManager, mCurrentFloor, newPosition, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(WarriorBean.Type.UP);
                mWarriorBean.setPosition(newPosition);

                // 更新勇士现在的位置的 UI
                setCase(mWarriorBean.getPosition(), mWarriorBean);

                // 勇士原来的位置变成 Building.ROAD
                setCase(oldPosition, new Road());
            }

            @Override
            public void onFailure(Exception e) {
                ShowLogUtil.logi("onFailure" + " : " + e.getMessage());
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:19
     * Description:勇士向右移动
     */
    public void warriorMoveRight() {
        // 勇士原来的位置
        Position oldPosition = mWarriorBean.getPosition();
        if (oldPosition.getColumn() == MAX_COLUMN - 1) {
            return;
        }
        // 勇士需要移动到的位置
        Position newPosition = new Position(oldPosition.getRow(), oldPosition.getColumn() + 1);
        mFloorList.get(mCurrentFloor).getCase(newPosition).handleEvent(mFragmentManager, mCurrentFloor, newPosition, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(WarriorBean.Type.RIGHT);
                mWarriorBean.setPosition(newPosition);

                // 更新勇士现在的位置的 UI
                setCase(mWarriorBean.getPosition(), mWarriorBean);

                // 勇士原来的位置变成 Building.ROAD
                setCase(oldPosition, new Road());
            }

            @Override
            public void onFailure(Exception e) {
                ShowLogUtil.logi("onFailure" + " : " + e.getMessage());
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 16:19
     * Description:勇士向下移动
     */
    public void warriorMoveDown() {
        // 勇士原来的位置
        Position oldPosition = mWarriorBean.getPosition();
        if (oldPosition.getRow() == MAX_ROW - 1) {
            return;
        }
        // 勇士需要移动到的位置
        Position newPosition = new Position(oldPosition.getRow() + 1, oldPosition.getColumn());
        mFloorList.get(mCurrentFloor).getCase(newPosition).handleEvent(mFragmentManager, mCurrentFloor, newPosition, new IHandleEventCallback() {
            @Override
            public void onSuccess(boolean canMove) {
                if (!canMove) {
                    return;
                }
                // 可以移动过去,则修改勇士属性
                mWarriorBean.setType(WarriorBean.Type.DOWN);
                mWarriorBean.setPosition(newPosition);

                // 更新勇士现在的位置的 UI
                setCase(mWarriorBean.getPosition(), mWarriorBean);

                // 勇士原来的位置变成 Building.ROAD
                setCase(oldPosition, new Road());
            }

            @Override
            public void onFailure(Exception e) {
                ShowLogUtil.logi("onFailure" + " : " + e.getMessage());
            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019//8 18:52
     * Description:更新单个地图格的 UI
     *
     * @param caseBean 地图格子对象
     */
    public void updateUI(Position position, CaseBean caseBean) {
//        ((ImageView) ((TableRow) mTableLayout.getChildAt(caseBean.getRow())).getChildAt(caseBean.getColumn())).setImageResource(caseBean.getSpecificEntity(caseBean.getType()).getResId());
        TableRow tableRow = (TableRow) mTableLayout.getChildAt(position.getRow());
        ImageView imageView = (ImageView) tableRow.getChildAt(position.getColumn());
        imageView.setImageResource(caseBean.getResourceId());
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 20:19
     * Description:保存地图所有楼层当前状态
     */
    public void save(IGameProgressCallback gameProgressCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 遍历所有层
                List<List<List<String>>> floorList = new ArrayList<>();
                for (int i = 0; i < mFloorList.size(); i++) {
                    AbsFloor absFloor = mFloorList.get(i);
                    List<List<CaseBean>> data = absFloor.getData();
                    // 遍历每一层所有行
                    List<List<String>> rowList = new ArrayList<>();
                    for (int j = 0; j < data.size(); j++) {
                        List<CaseBean> caseBeanList = data.get(j);
                        // 遍历每一行所有列
                        List<String> columnList = new ArrayList<>();
                        for (int k = 0; k < caseBeanList.size(); k++) {
                            CaseBean caseBean = caseBeanList.get(k);
                            columnList.add(caseBean.getClass().getName());
                        }
                        rowList.add(columnList);
                    }
                    floorList.add(rowList);
                }
                MagicTowerGameProgressBean magicTowerGameProgressBean = new MagicTowerGameProgressBean(mWarriorBean
                        , floorList
                        , mCurrentFloor
                        , mMaxFloorHaveBeTo);
                SharedPreferencesHelper.SINGLETON.putString(IConstant.MAGIC_TOWER_GAME_PROGRESS, new Gson().toJson(magicTowerGameProgressBean));
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        gameProgressCallback.onSuccess();
                    }
                }, 1000);
            }
        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/9 20:41
     * Description:读取之前存储的地图状态
     */
    public void read(IGameProgressCallback gameProgressCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String magicTowerGameProgressJson = SharedPreferencesHelper.SINGLETON.getString(IConstant.MAGIC_TOWER_GAME_PROGRESS);
                if (TextUtils.isEmpty(magicTowerGameProgressJson)) {
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gameProgressCallback.onFailure();
                        }
                    }, 1000);
                    return;
                }
                MagicTowerGameProgressBean magicTowerGameProgressBean = new Gson().fromJson(magicTowerGameProgressJson, MagicTowerGameProgressBean.class);

                mWarriorBean = magicTowerGameProgressBean.getWarriorBean();
                for (int i = 0; i < magicTowerGameProgressBean.getFloorList().size(); i++) {
                    List<List<String>> rowList = magicTowerGameProgressBean.getFloorList().get(i);
                    for (int j = 0; j < rowList.size(); j++) {
                        List<String> columnList = rowList.get(j);
                        for (int k = 0; k < columnList.size(); k++) {
                            try {
                                Class<?> clazz = Class.forName(columnList.get(k));
                                Object o = clazz.newInstance();
                                if (o instanceof WarriorBean) {
                                    o = mWarriorBean;
                                }
                                if (i == 10 && j == 6 && k == 4) {
                                    ShowLogUtil.logi(o);
                                }
                                mFloorList.get(i).setCase(new Position(j, k), (CaseBean) o);
                            } catch (Exception e) {
                                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        gameProgressCallback.onFailure();
                                    }
                                }, 500);
                                return;
                            }
                        }
                    }
                }
                mCurrentFloor = magicTowerGameProgressBean.getCurrentFloor();
                mMaxFloorHaveBeTo = magicTowerGameProgressBean.getMaxFloorHaveBeTo();
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mWarriorBean.update();
                        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_CURRENT_FLOOR, mCurrentFloor));
                        mFloorList.get(mCurrentFloor).initFloor(mTableLayout);
                        gameProgressCallback.onSuccess();
                    }
                }, 1000);
            }
        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/10 18:33
     * Description:获取当前楼层
     */
    public int getCurrentFloor() {
        return mCurrentFloor;
    }

    public List<AbsMonster> getCurrentFloorMonsterList() {
        Map<String, AbsMonster> monsterMap = new HashMap<>();
        for (List<CaseBean> rowList : mFloorList.get(mCurrentFloor).getData()) {
            for (CaseBean caseBean : rowList) {
                if (caseBean instanceof AbsMonster
                        && !monsterMap.containsKey(((AbsMonster) caseBean).getName())) {
                    monsterMap.put(((AbsMonster) caseBean).getName(), (AbsMonster) caseBean);
                }
            }
        }
        return new ArrayList<>(monsterMap.values());
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/11 14:43
     * Description:上楼
     */
    public void goUpstairs() {
        if (mCurrentFloor == mFloorList.size() - 1) {
            return;
        }
        setCase(mWarriorBean.getPosition(), new Road());

        mCurrentFloor++;
        mFloorList.get(mCurrentFloor).initFloor(mTableLayout);
        mFloorList.get(mCurrentFloor).fromDownstairsToThisFloor();

        if (mMaxFloorHaveBeTo < mCurrentFloor) {
            mMaxFloorHaveBeTo = mCurrentFloor;
        }
        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_CURRENT_FLOOR, mCurrentFloor));
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/10/11 14:44
     * Description:下楼
     */
    public void goDownstairs() {
        if (mCurrentFloor == 0) {
            return;
        }
        setCase(mWarriorBean.getPosition(), new Road());

        mCurrentFloor--;
        mFloorList.get(mCurrentFloor).initFloor(mTableLayout);
        mFloorList.get(mCurrentFloor).fromUpstairsToThisFloor();
        EventBus.getDefault().post(new EventBean<>(EventBean.Type.REFRESH_CURRENT_FLOOR, mCurrentFloor));
    }

    public int getFloorListSize() {
        return mFloorList.size();
    }

    public int getMaxFloorHaveBeTo() {
        return mMaxFloorHaveBeTo;
    }

    public boolean goToFloor(int floor) {
        if (floor > MagicGameManager.SINGLETON.getMaxFloorHaveBeTo()) {
            Toast.makeText(App.getInstance(), "你还没有去过这一层呢", Toast.LENGTH_SHORT).show();
            return false;
        }
        setCase(mWarriorBean.getPosition(), new Road());
        mCurrentFloor = floor;
        mFloorList.get(mCurrentFloor).initFloor(mTableLayout);
        mFloorList.get(mCurrentFloor).fromDownstairsToThisFloor();
        return true;
    }

    public interface IGameProgressCallback {
        void onSuccess();

        void onFailure();
    }
}
