package com.qinshou.qinshoubox.me.bean.klotski;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/19 16:24
 * Description:华容道实体类
 */
public class KlotskiBean {
    /**
     * 华容道方块对应的图片
     */
     Bitmap bitmap;
    /**
     * 华容道方块对应的文字
     */
    private String text;
    private int color;
    private int width;
    private int height;
    private Type type;
    public static final KlotskiBean CAO_CAO = new KlotskiBean(Type.CAO_CAO);
    public static final KlotskiBean GUAN_YU = new KlotskiBean(Type.GUAN_YU);
    public static final KlotskiBean ZHANG_FEI = new KlotskiBean(Type.ZHANG_FEI);
    public static final KlotskiBean ZHAO_YUN = new KlotskiBean(Type.ZHAO_YUN);
    public static final KlotskiBean HUANG_ZHONG = new KlotskiBean(Type.HUANG_ZHONG);
    public static final KlotskiBean MA_CHAO = new KlotskiBean(Type.MA_CHAO);
    public static final KlotskiBean BING = new KlotskiBean(Type.SHI_BING);
    public static final KlotskiBean NULL = new KlotskiBean(Type.NULL);

    public KlotskiBean(String text, int width, int height, Type type) {
        this.text = text;
        this.width = width;
        this.height = height;
        this.type = type;
    }

    private KlotskiBean(Type type) {
        switch (type) {
            case CAO_CAO:
                text = "曹操";
                color = Color.WHITE;
                width = 2;
                height = 2;
                this.type = Type.CAO_CAO;
                break;
            case GUAN_YU:
                text = "关羽";
                color = Color.RED;
                width = 2;
                height = 1;
                this.type = Type.GUAN_YU;
                break;
            case ZHANG_FEI:
                text = "张飞";
                color = Color.BLACK;
                width = 1;
                height = 2;
                this.type = Type.ZHANG_FEI;
                break;
            case ZHAO_YUN:
                text = "赵云";
                color = Color.BLUE;
                width = 1;
                height = 2;
                this.type = Type.ZHAO_YUN;
                break;
            case HUANG_ZHONG:
                text = "黄忠";
                color = Color.YELLOW;
                width = 1;
                height = 2;
                this.type = Type.HUANG_ZHONG;
                break;
            case MA_CHAO:
                text = "马超";
                color = Color.CYAN;
                width = 1;
                height = 2;
                this.type = Type.MA_CHAO;
                break;
            case SHI_BING:
                text = "兵";
                color = Color.GREEN;
                width = 1;
                height = 1;
                this.type = Type.SHI_BING;
                break;
            case NULL:
                text = "空";
                color = Color.TRANSPARENT;
                width = 1;
                height = 1;
                this.type = Type.NULL;
                break;
        }
    }

    @Override
    public String toString() {
        return "KlotskiBean{" +
                "bitmap=" + bitmap +
                ", text='" + text + '\'' +
                ", color=" + color +
                ", width=" + width +
                ", height=" + height +
                ", type=" + type +
                '}';
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        CAO_CAO,
        GUAN_YU,
        ZHANG_FEI,
        ZHAO_YUN,
        HUANG_ZHONG,
        MA_CHAO,
        SHI_BING,
        NULL,
    }
}
