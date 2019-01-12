import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

loadAssetsFile(BuildContext context, String fileName, onSuccessCallback,
    onErrorCallback) async {
  try {
    AssetBundle assetBundle = DefaultAssetBundle.of(context);
    final result = await assetBundle.loadString(fileName);
    if (result.length > 0 && result.trim() != "") {
      onSuccessCallback(result);
    } else {
      onErrorCallback("加载失败或者文件内容为空");
    }
  } catch (e) {
    print(e);
  }
}
