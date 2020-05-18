package com.qinshou.qinshoubox.util;

import android.graphics.Bitmap;

import com.qinshou.qinshoubox.me.bean.PuzzleItemBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:拼图游戏工具类
 * Created by 禽兽先生
 * Created on 2018/8/29
 */
public class PuzzleUtil {
    public static int PUZZLE_TYPE = 3;
    public static int BLANK_POSITION = 0;
    private static Bitmap sMissingBitmap;

    /**
     * author：MrQinshou
     * Description:根据拼图获取拼图块列表
     * date:2018/11/2 23:36
     *
     * @param puzzleBitmap 拼图原图
     * @return 随机打乱后并且有解的拼图块列表
     */
    public static List<PuzzleItemBean> getPuzzleItemBeanList(Bitmap puzzleBitmap) {
        List<PuzzleItemBean> puzzleItemBeanList = new ArrayList<>();
        for (int i = 0; i < PUZZLE_TYPE; i++) {
            for (int j = 0; j < PUZZLE_TYPE; j++) {
                PuzzleItemBean puzzleItemBean = new PuzzleItemBean();
                Bitmap bitmap = Bitmap.createBitmap(puzzleBitmap
                        , puzzleBitmap.getWidth() / PUZZLE_TYPE * j
                        , puzzleBitmap.getHeight() / PUZZLE_TYPE * i
                        , puzzleBitmap.getWidth() / PUZZLE_TYPE
                        , puzzleBitmap.getHeight() / PUZZLE_TYPE);
                puzzleItemBean.setItemPosition(i * PUZZLE_TYPE + j);
                puzzleItemBean.setBitmapId(i * PUZZLE_TYPE + j);
                puzzleItemBean.setBitmap(bitmap);
                puzzleItemBeanList.add(puzzleItemBean);
            }
        }
        puzzleItemBeanList = randomPuzzleItemBeanList(puzzleItemBeanList);
        for (int i = 0; i < puzzleItemBeanList.size(); i++) {
            if (puzzleItemBeanList.get(i).getItemPosition() == 0) {
                BLANK_POSITION = i;
                sMissingBitmap = puzzleItemBeanList.get(i).getBitmap();
                Bitmap blankBitmap = Bitmap.createBitmap(puzzleItemBeanList.get(i).getBitmap().getWidth()
                        , puzzleItemBeanList.get(i).getBitmap().getHeight()
                        , Bitmap.Config.RGB_565);
                puzzleItemBeanList.get(i).setBitmap(blankBitmap);
                break;
            }
        }
        return puzzleItemBeanList;
    }

    /**
     * author：MrQinshou
     * Description:随机打乱拼图块
     * date:2018/11/2 23:36
     *
     * @param puzzleItemBeanList 原始拼图块列表
     * @return 打乱后的拼图块列表
     */
    private static List<PuzzleItemBean> randomPuzzleItemBeanList(List<PuzzleItemBean> puzzleItemBeanList) {
        for (int i = 0; i < 100; i++) {
            int random = new Random().nextInt(puzzleItemBeanList.size() - 2) + 1;
            PuzzleItemBean temp = puzzleItemBeanList.get(0);
            puzzleItemBeanList.set(0, puzzleItemBeanList.get(random));
            puzzleItemBeanList.set(random, temp);
        }
        return puzzleItemBeanList;
    }

    /**
     * author：MrQinshou
     * Description:拼图块列表是否有解
     * date:2018/11/2 23:35
     *
     * @param list 拼图块列表
     * @return 是否有解
     */
    public static boolean canResolve(List<PuzzleItemBean> list) {
        if (PUZZLE_TYPE % 2 != 0) {
            // 宽度为奇数时，倒置和必须为偶数
            return getInversionSum(list) % 2 == 0;
        } else {
            // 宽度为偶数时
            // 空格位置位于从下往上数的奇数行时，倒置和必须为奇数
            // 空格位置位于从下往上数的偶数行时，倒置和必须为偶数
            int blankPositionRow = BLANK_POSITION / PUZZLE_TYPE + 1;
            int blankPositionRowReverse = PUZZLE_TYPE - blankPositionRow + 1;
            if (blankPositionRowReverse % 2 != 0) {
                return getInversionSum(list) % 2 != 0;
            } else {
                return getInversionSum(list) % 2 == 0;
            }
        }
    }

    public static int getInversionSum(List<PuzzleItemBean> list) {
        int inversion = 0;
        int inversionSum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            //空格位置不进行比较
            if (i == BLANK_POSITION) {
                continue;
            }
            for (int j = i + 1; j < list.size(); j++) {
                //空格位置不进行比较
                if (j == BLANK_POSITION) {
                    continue;
                }
                if (list.get(i).getItemPosition() > list.get(j).getItemPosition()) {
                    inversion++;
                }
            }
            inversionSum += inversion;
            inversion = 0;
        }
        return inversionSum;
    }

    /**
     * author：MrQinshou
     * Description:交换拼图块
     * date:2018/11/2 23:28
     *
     * @param puzzleItemBeanList 拼图块列表
     * @param clickPosition      点击的拼图块的位置
     * @return 交换后的拼图块列表
     */
    public static List<PuzzleItemBean> swapPuzzleItemBean(List<PuzzleItemBean> puzzleItemBeanList, int clickPosition) {
        if (canSwap(clickPosition)) {
            PuzzleItemBean temp = puzzleItemBeanList.get(clickPosition);
            puzzleItemBeanList.set(clickPosition, puzzleItemBeanList.get(BLANK_POSITION));
            puzzleItemBeanList.set(BLANK_POSITION, temp);
            BLANK_POSITION = clickPosition;
        }
        return puzzleItemBeanList;
    }

    /**
     * author：MrQinshou
     * Description:点击的拼图块上下左右是否有空白块可以交换
     * date:2018/11/2 23:29
     *
     * @param clickPosition 点击的位置
     * @return 是否可以交换
     */
    public static boolean canSwap(int clickPosition) {
        //同一行，空格位置与点击位置相差为 1 才可以移动
        if (BLANK_POSITION / PUZZLE_TYPE == clickPosition / PUZZLE_TYPE
                && (Math.abs(BLANK_POSITION - clickPosition) == 1)) {
            return true;
        }
        //不同行，空格位置与点击位置相差为拼图宽度才可以移动
        if (Math.abs(BLANK_POSITION - clickPosition) == PUZZLE_TYPE) {
            return true;
        }
        return false;
    }

    /**
     * author：MrQinshou
     * Description:判断拼图是否成功
     * date:2018/11/2 23:38
     *
     * @param puzzleItemBeanList 待判断的拼图块列表
     * @return 是否已拼图成功
     */
    public static boolean success(List<PuzzleItemBean> puzzleItemBeanList) {
        for (int i = 0; i < puzzleItemBeanList.size(); i++) {
            if (puzzleItemBeanList.get(i).getItemPosition() != i) {
                return false;
            }
        }
        return true;
    }

    /**
     * author：MrQinshou
     * Description:拼图成功后添加缺失的空白块
     * date:2018/11/2 23:37
     *
     * @param puzzleItemBeanList 拼图成功后的拼图块列表
     * @return 添加缺失的空白块后的拼图块列表
     */
    public static List<PuzzleItemBean> addMissingBitmap(List<PuzzleItemBean> puzzleItemBeanList) {
        if (BLANK_POSITION != -1) {
            puzzleItemBeanList.get(BLANK_POSITION).setBitmap(sMissingBitmap);
            BLANK_POSITION = -1;
        }
        return puzzleItemBeanList;
    }
}
