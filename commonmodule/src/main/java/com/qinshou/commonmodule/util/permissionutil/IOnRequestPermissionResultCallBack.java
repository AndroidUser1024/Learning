package com.qinshou.commonmodule.util.permissionutil;

import java.util.List;

/**
 * Description:申请权限的结果的回调监听
 * Created by 禽兽先生
 * Created on 2018/4/18
 */
public interface IOnRequestPermissionResultCallBack {
    void onSuccess();

    void onFailure(List<String> deniedPermissionList);
}