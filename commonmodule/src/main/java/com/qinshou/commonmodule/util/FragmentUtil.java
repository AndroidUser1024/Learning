package com.qinshou.commonmodule.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.List;

/**
 * Description:Fragment 的工具类
 * Created by 禽兽先生
 * Created on 2017/3/22
 */
public class FragmentUtil {

    /**
     * Description:切换 Fragment 且不需要传递数据
     * Date:2017/3/22
     *
     * @param fragmentManager Fragment 管理者,FragmentActivity 为 fragmentActivity.getSupportFragmentManager()
     *                        Fragment 为 getChildFragmentManager()
     * @param containerId     Fragment 的容器的 Id
     * @param showFragment    需要显示的Fragment,不能为null
     */
    public static Fragment showFragment(FragmentManager fragmentManager, int containerId, Fragment showFragment) {
        return showFragment(fragmentManager, containerId, showFragment, null);
    }

    /**
     * Description:切换 Fragment 且需要传递数据
     * Date:2017/3/22
     *
     * @param fragmentManager Fragment 管理者,FragmentActivity 为 fragmentActivity.getSupportFragmentManager()
     *                        Fragment 为 getChildFragmentManager()
     * @param containerId     Fragment 的容器的 Id
     * @param showFragment    需要显示的Fragment,不能为null
     * @param bundle          传递的数据
     */
    public static Fragment showFragment(FragmentManager fragmentManager, int containerId, Fragment showFragment, Bundle bundle) {
        if (showFragment == null)
            throw new NullPointerException("The Fragment to be displayed can not be null");
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        List<Fragment> fragmentList = fragmentManager.getFragments();
        for (int i = 0; fragmentList != null && i < fragmentList.size(); i++) {
            Fragment fragment = fragmentList.get(i);
            if (fragment != null) {
                fragmentTransaction.hide(fragment);
            }
        }
        if (fragmentManager.findFragmentByTag(showFragment.getClass().getSimpleName()) == null) {
            if (bundle != null) {
                showFragment.setArguments(bundle);
            }
            fragmentTransaction.add(containerId, showFragment, showFragment.getClass().getSimpleName());
        } else {
            if (bundle != null) {
                showFragment.setArguments(bundle);
            }
            fragmentTransaction.show(showFragment);
        }
        fragmentTransaction.commitAllowingStateLoss();
        return showFragment;
    }

    /**
     * Description:添加指定 Fragment
     * Date:2017/3/24
     */
    public static void addFragment(FragmentManager fragmentManager, int containerId, Fragment addFragment) {
        fragmentManager.beginTransaction().add(containerId, addFragment, addFragment.getClass().getSimpleName())
                .hide(addFragment)
                .commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
    }

    /**
     * Description:删除指定Fragment
     * Date:2017/3/24
     */
    public static void removeFragment(FragmentManager fragmentManager, Fragment removeFragment) {
        fragmentManager.beginTransaction().remove(fragmentManager.findFragmentByTag(removeFragment.getClass().getSimpleName()))
                .commitAllowingStateLoss();
    }

    /**
     * Description:检查指定 Fragment 是否已添加
     * Date:2017/3/24
     *
     * @re
     */
    public static boolean checkFragment(FragmentManager fragmentManager, Fragment checkFragment) {
        return fragmentManager.findFragmentByTag(checkFragment.getClass().getSimpleName()) != null;
    }
}
