package com.qinshou.imagemodule.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

/**
 * Description:图片相关操作的工具类
 * Created by 禽兽先生
 * Created on 2018/3/5
 */

public class BitmapUtil {
    /**
     * Description:Drawable 转 Bitmap
     * Date:2018/3/5
     */
    public static Bitmap drawable2Bitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        Bitmap result = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(result);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return result;
    }

    public static byte[] bitmap2ByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /**
     * Description:圆角图片效果
     * Date:2017/9/26
     */
    public static Bitmap roundCornerEffect(Bitmap bitmap) {
        return roundCornerEffect(bitmap, 80);
    }

    /**
     * Description:圆角图片效果
     * Date:2017/9/26
     */
    public static Bitmap roundCornerEffect(Bitmap bitmap, float radius) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawRoundRect(new RectF(0, 0, width, height), radius, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Description:圆形图片效果
     * Date:2017/9/26
     */
    public static Bitmap roundEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(width / 2, height / 2, Math.min(width, height) / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Description:灰度效果
     * Date:2017/9/25
     */
    public static Bitmap grayEffect(Bitmap bitmap) {
        float[] src = new float[]{0.33F, 0.59F, 0.11F, 0, 0
                , 0.33F, 0.59F, 0.11F, 0, 0
                , 0.33F, 0.59F, 0.11F, 0, 0
                , 0, 0, 0, 1, 0};
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(src);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Description:怀旧效果
     * Date:2017/9/25
     */
    public static Bitmap nostalgicEffect(Bitmap bitmap) {
        float[] src = new float[]{0.393F, 0.769F, 0.189F, 0, 0
                , 0.349F, 0.686F, 0.168F, 0, 0
                , 0.272F, 0.534F, 0.131F, 0, 0
                , 0, 0, 0, 1, 0};
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(src);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Description:去色效果
     * Date:2017/9/25
     */
    public static Bitmap desaturatedEffect(Bitmap bitmap) {
        float[] src = new float[]{1.5F, 1.5F, 1.5F, 0, -1
                , 1.5F, 1.5F, 1.5F, 0, -1
                , 1.5F, 1.5F, 1.5F, 0, -1
                , 0, 0, 0, 1, 0};
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(src);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Description:高饱和度效果
     * Date:2017/9/25
     */
    public static Bitmap saturatedEffect(Bitmap bitmap) {
        float[] src = new float[]{1.438F, -0.122F, -0.016F, 0, -0.03F
                , -0.062F, 1.378F, -0.016F, 0, 0.05F
                , -0.062F, -0.122F, 1.483F, 0, -0.02F
                , 0, 0, 0, 1, 0};
        Bitmap result = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(src);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * Description:底片效果
     * Date:2017/9/25
     */
    public static Bitmap negativeEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color;
        int r, g, b, a;

        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];
        bitmap.getPixels(oldPx, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = 255 - r;
            g = 255 - g;
            b = 255 - b;

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }
            newPx[i] = Color.argb(a, r, g, b);
        }
        result.setPixels(newPx, 0, width, 0, 0, width, height);
        return result;
    }

    /**
     * Description:老照片效果
     * Date:2017/9/25
     */
    public static Bitmap oldPhotoEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color;
        int r, g, b, a;

        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];
        bitmap.getPixels(oldPx, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];
            r = Color.red(color);
            g = Color.green(color);
            b = Color.blue(color);
            a = Color.alpha(color);

            r = (int) (0.393 * r + 0.7469 * g + 0.189 * b);
            g = (int) (0.349 * r + 0.686 * g + 0.168 * b);
            b = (int) (0.272 * r + 0.534 * g + 0.131 * b);

            if (r > 255) {
                r = 255;
            } else if (r < 0) {
                r = 0;
            }
            if (g > 255) {
                g = 255;
            } else if (g < 0) {
                g = 0;
            }
            if (b > 255) {
                b = 255;
            } else if (b < 0) {
                b = 0;
            }
            newPx[i] = Color.argb(a, r, g, b);
        }
        result.setPixels(newPx, 0, width, 0, 0, width, height);
        return result;
    }

    /**
     * Description:浮雕效果
     * Date:2017/9/25
     */
    public static Bitmap reliefEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color1, color2;
        int r1, r2, g1, g2, b1, b2, a1, a2;

        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];
        bitmap.getPixels(oldPx, 0, width, 0, 0, width, height);
        for (int i = 1; i < width * height; i++) {
            color1 = oldPx[i - 1];
            r1 = Color.red(color1);
            g1 = Color.green(color1);
            b1 = Color.blue(color1);
            a1 = Color.alpha(color1);

            color2 = oldPx[i];
            r2 = Color.red(color2);
            g2 = Color.green(color2);
            b2 = Color.blue(color2);

            r1 = r1 - r2 + 127;
            g1 = g1 - g2 + 127;
            b1 = b1 - b2 + 127;

            if (r1 > 255) {
                r1 = 255;
            } else if (r1 < 0) {
                r1 = 0;
            }
            if (g1 > 255) {
                g1 = 255;
            } else if (g1 < 0) {
                g1 = 0;
            }
            if (b1 > 255) {
                b1 = 255;
            } else if (b1 < 0) {
                b1 = 0;
            }
            newPx[i] = Color.argb(a1, r1, g1, b1);
        }
        result.setPixels(newPx, 0, width, 0, 0, width, height);
        return result;
    }

    /**
     * Description:黑白效果
     * Date:2017/9/26
     */
    public static Bitmap blackAndWhiteEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int color;
        int r, g, b, a;
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        int[] oldPx = new int[width * height];
        int[] newPx = new int[width * height];
        bitmap.getPixels(oldPx, 0, width, 0, 0, width, height);
        for (int i = 0; i < width * height; i++) {
            color = oldPx[i];

            a = Color.alpha(color);
            // 分离三原色
            r = ((color & 0x00FF0000) >> 16);
            g = ((color & 0x0000FF00) >> 8);
            b = (color & 0x000000FF);

            // 转化成灰度像素
            color = (int) (r * 0.3 + g * 0.59 + b * 0.11);
            color = a << 24 | (color << 16) | (color << 8) | color;
            newPx[i] = color;
        }
        // 新建图片
        result.setPixels(newPx, 0, width, 0, 0, width, height);
        return result;
    }

    /**
     * Description:倒影效果
     * Date:2017/9/26
     */
    public static Bitmap reflectionEffect(Bitmap bitmap) {
        int reflectionGap = 4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1, -1);
        Bitmap reflectionBitmap = Bitmap.createBitmap(bitmap, 0, height / 2,
                width, height / 2, matrix, false);
        Bitmap result = Bitmap.createBitmap(width,
                (height + height / 2), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        canvas.drawBitmap(bitmap, 0, 0, null);
        Paint paint1 = new Paint();
        canvas.drawRect(0, height, width, height + reflectionGap, paint1);
        canvas.drawBitmap(reflectionBitmap, 0, height + reflectionGap, null);
        Paint paint2 = new Paint();
        LinearGradient shader = new LinearGradient(0, bitmap.getHeight(), 0,
                result.getHeight() + reflectionGap, 0x70ffffff,
                0x00ffffff, Shader.TileMode.CLAMP);
        paint2.setShader(shader);
        // Set the Transfer mode to be porter duff and destination in
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        // Draw a rectangle using the paint with our linear gradient
        canvas.drawRect(0, height, width, result.getHeight() + reflectionGap, paint2);
        return result;
    }

    /**
     * Description:遮盖罩效果
     * Date:2017/9/26
     */
    public static Bitmap coverEffect(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(67, 0, 0, 0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return result;
    }

    /**
     * 高斯模糊
     */
    public static Bitmap gaussianEffect(Bitmap bmp) {
        //水平方向模糊度
        float hRadius = 10;
        //竖直方向模糊度
        float vRadius = 10;
        //模糊迭代度
        int iterations = 7;
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] inPixels = new int[width * height];
        int[] outPixels = new int[width * height];
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bmp.getPixels(inPixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < iterations; i++) {
            blur(inPixels, outPixels, width, height, hRadius);
            blur(outPixels, inPixels, height, width, vRadius);
        }
        blurFractional(inPixels, outPixels, width, height, hRadius);
        blurFractional(outPixels, inPixels, height, width, vRadius);
        bitmap.setPixels(inPixels, 0, width, 0, 0, width, height);
        return bitmap;
    }


    private static void blur(int[] in, int[] out, int width, int height, float radius) {
        int widthMinus1 = width - 1;
        int r = (int) radius;
        int tableSize = 2 * r + 1;
        int divide[] = new int[256 * tableSize];
        for (int i = 0; i < 256 * tableSize; i++) {
            divide[i] = i / tableSize;
        }
        int inIndex = 0;
        for (int y = 0; y < height; y++) {
            int outIndex = y;
            int ta = 0, tr = 0, tg = 0, tb = 0;
            for (int i = -r; i <= r; i++) {
                int rgb = in[inIndex + clamp(i, 0, width - 1)];
                ta += (rgb >> 24) & 0xff;
                tr += (rgb >> 16) & 0xff;
                tg += (rgb >> 8) & 0xff;
                tb += rgb & 0xff;
            }
            for (int x = 0; x < width; x++) {
                out[outIndex] = (divide[ta] << 24) | (divide[tr] << 16) | (divide[tg] << 8) | divide[tb];
                int i1 = x + r + 1;
                if (i1 > widthMinus1) {
                    i1 = widthMinus1;
                }
                int i2 = x - r;
                if (i2 < 0) {
                    i2 = 0;
                }
                int rgb1 = in[inIndex + i1];
                int rgb2 = in[inIndex + i2];
                ta += ((rgb1 >> 24) & 0xff) - ((rgb2 >> 24) & 0xff);
                tr += ((rgb1 & 0xff0000) - (rgb2 & 0xff0000)) >> 16;
                tg += ((rgb1 & 0xff00) - (rgb2 & 0xff00)) >> 8;
                tb += (rgb1 & 0xff) - (rgb2 & 0xff);
                outIndex += height;
            }
            inIndex += width;
        }
    }

    private static void blurFractional(int[] in, int[] out, int width, int height, float radius) {
        radius -= (int) radius;
        float f = 1.0f / (1 + 2 * radius);
        int inIndex = 0;

        for (int y = 0; y < height; y++) {
            int outIndex = y;
            out[outIndex] = in[0];
            outIndex += height;
            for (int x = 1; x < width - 1; x++) {
                int i = inIndex + x;
                int rgb1 = in[i - 1];
                int rgb2 = in[i];
                int rgb3 = in[i + 1];

                int a1 = (rgb1 >> 24) & 0xff;
                int r1 = (rgb1 >> 16) & 0xff;
                int g1 = (rgb1 >> 8) & 0xff;
                int b1 = rgb1 & 0xff;
                int a2 = (rgb2 >> 24) & 0xff;
                int r2 = (rgb2 >> 16) & 0xff;
                int g2 = (rgb2 >> 8) & 0xff;
                int b2 = rgb2 & 0xff;
                int a3 = (rgb3 >> 24) & 0xff;
                int r3 = (rgb3 >> 16) & 0xff;
                int g3 = (rgb3 >> 8) & 0xff;
                int b3 = rgb3 & 0xff;
                a1 = a2 + (int) ((a1 + a3) * radius);
                r1 = r2 + (int) ((r1 + r3) * radius);
                g1 = g2 + (int) ((g1 + g3) * radius);
                b1 = b2 + (int) ((b1 + b3) * radius);
                a1 *= f;
                r1 *= f;
                g1 *= f;
                b1 *= f;
                out[outIndex] = (a1 << 24) | (r1 << 16) | (g1 << 8) | b1;
                outIndex += height;
            }
            out[outIndex] = in[width - 1];
            inIndex += width;
        }
    }

    private static int clamp(int x, int a, int b) {
        return (x < a) ? a : (x > b) ? b : x;
    }

    /**
     * Description:多张图片纵向拼接
     * Date:2018/6/4
     */
    public static Bitmap mergeBitmaps(Bitmap... bitmaps) {
        int width = 0;
        int height = 0;
        for (int i = 0; i < bitmaps.length; i++) {
            if (width < bitmaps[i].getWidth()) {
                width = bitmaps[i].getWidth();
            }
            height += bitmaps[i].getHeight();
        }
        Bitmap result = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        int top = 0;
        for (int i = 0; i < bitmaps.length; i++) {
            if (i == 0) {
                top = 0;
                canvas.drawBitmap(bitmaps[i], 0, top, paint);
            } else {
                top += bitmaps[i - 1].getHeight();
                canvas.drawBitmap(bitmaps[i], 0, top, paint);
            }
        }
        return result;
    }

    /**
     * Description:缩放图片
     * Date:2018/8/29
     */
    public static Bitmap scaleImage(Bitmap bitmap, int newWidth, int newHeight) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,
                true);
        if (bitmap != null & !bitmap.isRecycled()) {
            bitmap.recycle();
            bitmap = null;
        }
        return result;
    }
}
