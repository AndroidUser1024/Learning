常用工具类组件

当前具备功能:
1.res 目录下有一套以 1280*720 为基准的屏幕适配的 dimens.适配了 800*480,1280*720,1920&1080,1776*1080(这个分辨率是为了适配像华为这样有虚拟按键的机型,因为计算分辨率时并不会把虚拟按键的高度计算进去),内部以 px 为尺寸单位,所以如果 UI给的是 1280*720 尺寸的设计图,图上是多少 px 就给控件设置对应px 即可.

2.RecyclerView 通用适配器,不用再写繁琐的 onCreateViewHolder(),getItemCount() 方法了,具体用法参考 RcvBaseAdapter,单布局的 item 的列表用法参考 RcvSingleBaseAdapter,单数据对应多类型的布局和多数据对应多类型的布局的 item 的列表用法参考 RcvMultipleBaseAdapter.

3.BaseActivity 和 BaseFragment,只是为了让结构清晰一点.

4.DisplayUtil,用于 px,dp,sp 之间的换算.

5.对 Log.i() 的简单封装.

6.RCRelativeLayout,通用圆角布局,具体用法参考类的备注.

7.RefreshLayout 下拉刷新,上拉加载框架,依赖于 "com.scwang.smartrefresh:SmartRefreshLayout:1.0.4-7",自己又封装了一层,方便第三方库的替换,具体用法参考类的备注.

8.SlideBackLayout 侧滑关闭 Activity 的控件,自己写的,可能存在 Bug,边用边优化好了,具体用法参考类的备注.当前在 BaseActivity 中默认实现.

9.StatusBarUtil 可以实现沉浸式,该类中还有一个仿 iOS 点击使 ScrollView,ListView,RecyclerView 回到顶部的功能,但是需要申请悬浮窗权限.

10.ViewPagerPoint 是为 ViewPager 添加小圆点的控件,具体用法参考该类.

11.WebActivity 中封装了点击网页中的图片查看大图的功能.

12.HtmlTextUtil 可以将文本转成 Html 格式，Android 原生的 TextView 可以直接显示 Html.

13.SwipeDelMenuLayout 需要在项目的 build.gradle 中 allprojects {repositories {}} 中添加 maven { url "https://jitpack.io" },该库可以很方便的实现侧滑菜单,在需要侧滑的布局(称为 ContentItem)中使用 SwipeDelMenuLayout 作为最外层布局,然后依次排列 ContentItem 和菜单即可,需要注意的是这时候设置 item 的点击事件不能设置根布局的点击事件了,而要设置 ContentItem 的点击事件.