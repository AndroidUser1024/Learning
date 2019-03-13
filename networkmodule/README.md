网络请求组件
该组件封装还不完善

当前具备功能:
1.网络请求,内部使用 Retrofit 库，结合 'com.squareup.retrofit2:converter-gson:2.3.0' 可直接返回实体类，结合 'com.squareup.retrofit2:adapter-rxjava2:2.3.0' 可与 RxJava2 结合使用。关于这两个教程请自行百度。

2.CustomRetrofitBuilder 可快速构建 Retrofit 对象，建议 BaseURL 不变的情况下使用单例模式。

3.内置 HttpParameterInterceptor 添加公共参数的拦截器，LogInterceptor 打印网络请求和响应结果的拦截器，SetCookieInterceptor、GetCookieInterceptor 设置和获取 Cookie 的拦截器。

4.内置 RxBus，使用 Rx 套餐的话可使用该类代替 EventBus，减少依赖，缩小工程体积，具体用法参考 RxBus。

5.网络请求的回调请使用 BaseObserver，内部已对观察者进行处理，接收到结果后会自行断开连接，应用退出时可调用  DisposableManager 的 clear() 方法，防止 Activity 退出后还接收到结果。