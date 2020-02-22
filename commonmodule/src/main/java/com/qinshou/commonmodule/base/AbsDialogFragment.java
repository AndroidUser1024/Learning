package com.qinshou.commonmodule.base;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.fragment.app.DialogFragment;

/**
 * Description:DialogFragment 的基类
 * Created by 禽兽先生
 * Created on 2019/1/17
 */
public abstract class AbsDialogFragment extends DialogFragment {
    private View rootView;

    /**
     * Description:初始化布局资源 ID
     * Date:2019/1/17
     */
    public abstract int initLayoutId();

    /**
     * Description:初始化各控件
     * Date:2019/1/17
     */
    public abstract void initView();

    /**
     * Description:设置监听器
     * Date:2019/1/17
     */
    public abstract void setListener();

    /**
     * Description:初始化数据
     * Date:2019/1/17
     */
    public abstract void initData();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        rootView = LayoutInflater.from(getContext()).inflate(initLayoutId(), null);
        Dialog dialog = new Dialog(getContext());
        //设置对话框无标题，该方法必须在 setContentView() 之前调用
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(rootView);
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog = customDialog(dialog);
        initView();
        setListener();
        initData();
        return dialog;
    }

    /**
     * Description:如果对对话框样式有个性需求，可覆写该方法
     * Date:2019/2/19
     */
    public Dialog customDialog(Dialog dialog) {
        return dialog;
    }

    public <T extends View> T findViewByID(int viewId) {
        if (rootView != null) {
            return (T) rootView.findViewById(viewId);
        }
        return null;
    }
}
