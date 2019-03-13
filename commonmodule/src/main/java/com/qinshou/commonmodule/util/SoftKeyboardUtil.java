package com.qinshou.commonmodule.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Description:控制软键盘的显示与隐藏的工具类
 * Created by 禽兽先生
 * Created on 2017/4/14
 */
public class SoftKeyboardUtil {
    /**
     * Description:显示软键盘
     * Date:2017/10/12
     */
    public static void showSoftKeyboard(Context context, EditText editText) {
        InputMethodManager mInputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (mInputMethodManager != null) {
            mInputMethodManager.showSoftInput(editText, InputMethodManager.RESULT_SHOWN);
            mInputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        }
    }

    /**
     * Description:隐藏软键盘
     * Date:2017/4/14
     */
    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager mInputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (mInputMethodManager != null) {
            mInputMethodManager.hideSoftInputFromWindow(activity.getWindow().getDecorView().getWindowToken(), 0);
        }
    }
    /**
     * Description:隐藏软键盘
     * Date:2017/4/14
     */
    public static void hideSoftKeyboard(Context context, EditText editText) {
        InputMethodManager mInputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (mInputMethodManager != null) {
            mInputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        }
    }

    /**
     * Description:判断软键盘是否已显示
     * Date:2017/10/12
     */
    public static boolean isSoftKeyboardShown(Activity activity) {
        //虚拟键盘隐藏 判断view是否为空
        View view = activity.getWindow().peekDecorView();
        if (view != null) {
            // 隐藏虚拟键盘
            InputMethodManager mInputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            if (mInputMethodManager != null) {
                return mInputMethodManager.isActive() && activity.getWindow().getCurrentFocus() != null;
            }
        }
        return false;
    }
}
