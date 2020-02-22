package com.qinshou.commonmodule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.qinshou.commonmodule.base.AbsMVPActivity;


/**
 * Description:Fragment 的容器 Activity,一些简单界面可以使用 Fragment 实现,然后由该 Activity 作为容器显示,就不用去 AndroidManifest.xml 中注册 Activity 了
 * Author: QinHao
 * Date: 2019/3/25 17:21
 */
public class ContainerActivity extends AbsMVPActivity {
    private static final String FRAGMENT_CLASS = "FragmentClass";

    @Override
    public int getLayoutId() {
        return R.layout.activity_container;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public void initData() {
        Class<?> fragmentClass = (Class<?>) getIntent().getSerializableExtra(FRAGMENT_CLASS);
        if (fragmentClass == null) {
            return;
        }
        Fragment fragment = createFragment(fragmentClass);
        if (fragment == null) {
            return;
        }
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_container, fragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private Fragment createFragment(Class<?> fragmentClass) {
        try {
            return (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Intent getJumpIntent(Context context, Class<?> fragmentClass) {
        return getJumpIntent(context, fragmentClass, null);
    }

    public static Intent getJumpIntent(Context context, Class<?> fragmentClass, Bundle bundle) {
        Intent intent = new Intent(context, ContainerActivity.class);
        intent.putExtra(FRAGMENT_CLASS, fragmentClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }
}
