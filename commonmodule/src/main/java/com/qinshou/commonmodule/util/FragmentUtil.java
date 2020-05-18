package com.qinshou.commonmodule.util;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        if (checkFragment(fragmentManager, showFragment)) {
            if (bundle != null) {
                showFragment.setArguments(bundle);
            }
            fragmentTransaction.show(showFragment);
        } else {
            if (bundle != null) {
                showFragment.setArguments(bundle);
            }
            fragmentTransaction.add(containerId, showFragment, showFragment.getClass().getSimpleName() + "_" + showFragment.hashCode());
        }
        fragmentTransaction.commitNowAllowingStateLoss();
        return showFragment;
    }

    /**
     * Description:添加指定 Fragment
     * Date:2017/3/24
     */
    public static void addFragment(FragmentManager fragmentManager, int containerId, Fragment addFragment) {
        fragmentManager.beginTransaction().add(containerId, addFragment, addFragment.getClass().getSimpleName() + "_" + addFragment.hashCode())
                .hide(addFragment)
                .commitNowAllowingStateLoss();
    }

    /**
     * Description:删除指定Fragment
     * Date:2017/3/24
     */
    public static void removeFragment(FragmentManager fragmentManager, Fragment removeFragment) {
        Fragment fragmentByTag = fragmentManager.findFragmentByTag(removeFragment.getClass().getSimpleName() + "_" + removeFragment.hashCode());
        if (fragmentByTag == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(fragmentByTag)
                .commitNowAllowingStateLoss();
    }

    /**
     * Description:检查指定 Fragment 是否已添加
     * Date:2017/3/24
     *
     * @re
     */
    public static boolean checkFragment(FragmentManager fragmentManager, Fragment checkFragment) {
        return fragmentManager.findFragmentByTag(checkFragment.getClass().getSimpleName() + "_" + checkFragment.hashCode()) != null;
    }
}
