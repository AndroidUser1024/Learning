图片加载组件

当前具备功能:
1.加载图片，内部使用 Glide 实现，具体用法参考 ImageLoadUtil。

2.支持查看大图，点击跳转到 PhotoViewActivity 即可,大图显示使用 'com.bm.photoview:library:1.4.1' 库的 PhotoView，支持缩放、旋转，具体用法参考 PhotoViewActivity。

3.支持图片选择，需要在项目的 build.gradle 中 allprojects {repositories {}} 中添加 jcenter()，图片选择使用知乎开源库，具体用法参考 ImageChooseUtil。

4.支持图片裁剪，裁剪使用 'com.yanzhenjie:durban:1.0.1' 第三方库，支持选择、缩放手势，多图裁剪，具体用法参考 ImageCropUtil。