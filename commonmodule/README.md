# 通用模块

## base,基本架构采用 MVP 架构,M,V,P 各层的接口由对应契约类 Contract 维护
### AbsMVPActivity,Activity 基类,继承该类可以使其在 BaseApplication 中统一管理,可以轻松实现沉浸式,并封装了一些常规操作
    *.public void toastShort(String content),短时间吐丝.
    *.public void toastLong(String content),长时间吐丝.
    *.public boolean isImmersive(),返回 true 表示开始沉浸式(内容延伸到状态栏下并使状态栏透明).
    *.public int initStatusBarColor(),设置状态栏颜色,需在 initLayoutId() 方法前调用.
    *.public boolean initStatusBarDark(),设置状态栏图标是否为深色,需在 initLayoutId() 方法前调用.
### AbsMVPFragment,Fragment 基类,继承该类可以轻松实现沉浸式,并封装了一些常规操作
    *.public void toastShort(String content),短时间吐丝.
    *.public void toastLong(String content),长时间吐丝.
    *.public void finish(),关闭当前 Fragment 的宿主 Activity
    *.public boolean isImmersive(),返回 true 表示开始沉浸式(内容延伸到状态栏下并使状态栏透明).
    *.public int initStatusBarColor(),设置状态栏颜色,需在 initLayoutId() 方法前调用.
    *.public boolean initStatusBarDark(),设置状态栏图标是否为深色,需在 initLayoutId() 方法前调用.
### BaseApplication,继承该类可以轻松管理 AbsMVPActivity 的实现类
    *.public List<Reference<FragmentActivity>> getActivityList(),获取 Activity 集合.
    *.public void exit(),退出所有 Activity.
    *.public FragmentActivity getTopActivity(),获取最上层的 Activity.
### BaseDialogFragment,Android 建议使用 DialogFragment 代替 Dialog,方便管理生命周期,继承该类可以快速实现.
    *.public Dialog customDialog(Dialog dialog),如果对对话框样式有个性需求，可覆写该方法.

## crash,全局异常处理,还不稳定
### CrashHandler,全局异常处理类,还不稳定,初始化该类后,可以友好的捕捉 Crash 并保存日志到内部存储中
    *.public void init(Context context),初始化该类,将异常交给我们自定义的处理类来处理.

## rcvbaseadapter,RecyclerView 的通用适配器,简单快速实现一对一,一对多,多对对,空布局的需求
### BaseViewHolder,封装一些常规操作
    *.public <T extends View> T findViewById(int viewId),根据 id 查找控件.
    *.public TextView getTextView(int textViewId),根据 id 获取 TextView.
    *.public ImageView getImageView(int imageViewId),根据 id 获取 ImageView.
    *.public BaseViewHolder setVisibility(int viewId, int visibility),设置控件是否可见.
    *.public BaseViewHolder setTvText(int viewId, CharSequence text),设置 TextView 文本内容.
    *.public BaseViewHolder setTvText(int viewId, @StringRes int resId),设置 TextView 文本资源.
    *.public BaseViewHolder setBtnText(int viewId, CharSequence text),设置 Button 文本内容.
    *.public BaseViewHolder setBtnText(int viewId, @StringRes int resId),设置 Button 文本资源.
    *.public BaseViewHolder setIvImage(int viewId, Bitmap bitmap),设置 ImageView 图片.
    *.public BaseViewHolder setIvImage(int viewId, @DrawableRes int resId),设置 ImageView 图片资源.
    *.public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener),设置控件点击监听器.
    *.public BaseViewHolder setSelected(int viewId, boolean selected),设置控件的 selected 状态.
    *.public BaseViewHolder setBackgroundColor(int viewId, @ColorInt int color),设置控件的背景色.
    *.public BaseViewHolder setBackgroundResource(int viewId, @DrawableRes int resId).设置控件背景资源.
### BaseItemView,一对多和多对多时才会用到该类
    *.public boolean isForViewType(T item, int position),多对多时不用操心该方法,一对多时需覆写该方法来决定各布局引入时机.
### RcvMultipleBaseAdapter,多布局类型的 RecyclerView 的适配器,可以实现一对多(一个实体类对应多种布局)和多对多(多个实体类对应多个布局)
,使用时创建该适配器实例,创建不同的 ItemView 继承 BaseItemView,然后调用 addItemView() 方法传入 ItemView 即可,BaseItemView 中有一个方法
isForViewType() 用来判断何时引入哪种子布局,多对多时不用覆盖该方法,内部会根据泛型的真实类型和该 position 的数据的类型判断,
一对多时需覆盖该方法加入自己的逻辑判断,否则同一类型只会使用传入的第一个 ItemView.
    *.public void addItemView(BaseItemView baseItemView),添加 itemView.
    *.public void removeItemView(BaseItemView baseItemView),移除 itemView.
### RcvSingleBaseAdapter,item 为单布局的 RecyclerView 的适配器,如果列表只是相同布局的 item,只需要继承该适配器,
实现 public abstract void bindViewHolder(BaseViewHolder holder, T t) 这一个方法即可

## rcvdecoration,封装一些 RecyclerView 常用的 Decoration
### DividerDecoration,分隔线样式的 Decoration
    *.public DividerDecoration(),默认方向是垂直方向,
    *.public DividerDecoration(Orientation orientation),默认宽度是 1px,
    *.public DividerDecoration(Orientation orientation, int width),默认颜色是 0xFF000000
    *.public DividerDecoration(Orientation orientation, int width, @ColorInt int color)
    *.public void setMargin(int left, int top, int right, int bottom),设置分隔线 margin
    *.public void setShowLast(boolean showLast),设置是否显示最后一条分隔线,默认不显示

## permissionutil
封装的 Android 6.0 权限工具类


## util
常用工具类

## widget
常用自定义控件