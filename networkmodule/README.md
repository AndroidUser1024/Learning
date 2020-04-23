用法类似 Retrofit
# 基本使用
1. 定义接口用于管理所有请求，在该接口上添加 @Api 注解，注解的值为 baseUrl。

    eg：
    ```java
    @Api("https://bggw.jeejio.com/jeejiousergateway/usergateway/jeejiouser/user/")
    public interface UserApi {
    }
    ```
2. 在接口中定义方法，每一个方法对应一个具体的网络请求，使用 @Param 注解来标识请求参数。

    eg：
    ```java
	@Json
    @Post("/getList")
    AbsCall<JeejioResultBean<UserInfoBean>> login(@Param("userKey") String username
            , @Param("userPasswd") String password
            , @Param("tool") int tool
            , @Param("platform") String platform
            , @Param("sessionId") String sessionId);
    ```
3. 使用 OkHttpHelper 发起网络请求。
    eg：
    ```java
    OkHttpHelper.SINGLETON.getCaller(UserApi.class)
            .login(username, password, 2, "control", "659E083D09561D85EFF76FE0A26EAC3687FBCF99")
            .enqueue(new Callback<JeejioResultBean<UserInfoBean>>() {
                @Override
                public void onSuccess(JeejioResultBean<UserInfoBean> data) {
                    Log.i("xxx", "onSuccess" + " : " + "data--->" + data);
                }

                @Override
                public void onFailure(Exception e) {
                    Log.i("xxx", "onFailure" + " : " + "e--->" + e.getMessage());
                }
            });
    ```

# Get 请求
使用 @Get 注解定义该请求为一个 Get 请求。

eg：
```java
@Get("test")
AbsCall<Object> get(@Param("username") String username, @Param("password") String password);
```

```java
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .get("test1", "test1")
        .enqueue(new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                Log.i(TAG, "onSuccess" + " : " + data);
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```

## @Download、@FileTarget
如果需要下载文件，则需要在 Get 请求上添加 Download 注解，方法的参数中需要 @FileTarget 来指定下载文件需要保存到的地方

@FileTarget 用于指定下载的内容保存的位置。

@DownloadCallback 用于指定下载进度的监听器，该注解只能添加在 IDownloadCallback 类型的参数上

eg：
```java
@Download
@Get()
AbsCall<File> download(@Url String url, @FileTarget File file);
```


```java
String url = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312143927981075.mp4";
String fileName = "tmp1.mp4";
File file = new File(mContext.getCacheDir() + File.separator + fileName);
// 创建新文件
if (file.getParentFile() != null && !file.getParentFile().exists()) {
    file.getParentFile().mkdirs();
}
if (file.exists()) {
    file.delete();
}
try {
    file.createNewFile();
} catch (IOException e) {
    e.printStackTrace();
}
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .download(url, file)
        .enqueue(new Callback<File>() {
            @Override
            public void onSuccess(File data) {
                Log.i(TAG, "onSuccess" + " : " + data.getAbsolutePath());
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
}
```

## @DownloadCallback
该注解用于指定下载进度的监听器，该注解只能添加在 IDownloadCallback 类型的参数上；

eg：
```java
@Download
@Get()
AbsCall download(@Url String url, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);
```
```java
String url = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312143927981075.mp4";
String fileName = "tmp2.mp4";
File file = new File(mContext.getCacheDir() + File.separator + fileName);
// 创建新文件
if (file.getParentFile() != null && !file.getParentFile().exists()) {
    file.getParentFile().mkdirs();
}
if (file.exists()) {
    file.delete();
}
try {
    file.createNewFile();
} catch (IOException e) {
    e.printStackTrace();
}
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .download(url, file, new IDownloadCallback() {
            @Override
            public void onStart(long length) {
                Log.i(TAG, "onStart" + " : " + "length--->" + length);
            }

            @Override
            public void onProgress(int progress) {
                Log.i(TAG, "onProgress" + " : " + "progress--->" + progress);
            }

            @Override
            public void onSuccess(File file) {
                Log.i(TAG, "onSuccess" + " : " + "file--->" + file.getAbsolutePath());
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + "e--->" + e.getMessage());
            }
        })
        .enqueue(new Callback<File>() {
            @Override
            public void onSuccess(File data) {
                Log.i(TAG, "onSuccess" + " : " + data.getAbsolutePath());
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```

## Range
断点续传其实在 Http 协议中只是添加了 RANGE 请求头，该库中已经封装了断点续传的功能，使用 @Range 参数指定需要开始下载的位置即可
```java
@Download
@Get()
AbsCall download(@Url String url, @Range long start, @FileTarget File file, @DownloadCallback IDownloadCallback downloadCallback);
```

```java
String url = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312143927981075.mp4";
String fileName = "tmp3.mp4";
File file = new File(mContext.getCacheDir() + File.separator + fileName);
// 创建新文件
if (file.getParentFile() != null && !file.getParentFile().exists()) {
    file.getParentFile().mkdirs();
}
if (!file.exists()) {
    try {
        file.createNewFile();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
final AbsCall<File> call = OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .download(url, file.length(), file, new IDownloadCallback() {
            @Override
            public void onStart(long length) {
                Log.i(TAG, "onStart" + " : " + "length--->" + length);
            }

            @Override
            public void onProgress(int progress) {
                Log.i(TAG, "onProgress" + " : " + "progress--->" + progress);
            }

            @Override
            public void onSuccess(File file) {
                Log.i(TAG, "onSuccess" + " : " + "file--->" + file.getAbsolutePath());
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + "e--->" + e.getMessage());
            }
        });
call.enqueue(new Callback<File>() {
    @Override
    public void onSuccess(File data) {
        Log.i(TAG, "onSuccess" + " : " + data.getAbsolutePath());
    }

    @Override
    public void onFailure(Exception e) {
        Log.i(TAG, "onFailure" + " : " + e.getMessage());
    }
});
new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
    @Override
    public void run() {
        call.cancel();
    }
}, 5000);
```
---
# Post 请求
使用 @Post 注解定义该请求为一个 Post 请求，参数会以表单方式提交。

eg：
```java
@Post("test")
AbsCall<Object> post(@Param("username") String username, @Param("password") String password);
```

```java
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .post("test1", "test1")
        .enqueue(new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                Log.i(TAG, "onSuccess" + " : " + data);
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```

## @Json 注解
如果希望参数以 json 格式传递，只需要在 Post 请求上添加 @Json 注解即可。

eg：
```java
@Json
@Post("test")
AbsCall<Object> postJson(@Param("username") String username, @Param("password") String password);
```
```java
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .postJson("test1", "test1")
        .enqueue(new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                Log.i(TAG, "onSuccess" + " : " + data);
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```
## @Multipart
如果需要上传文件，只需要在 Post 请求上添加 @Multipart 注解，在创建请求时就会识别方法中的 File 类型的参数。

eg：
```java
@Multipart
@Post("/test")
AbsCall<Object> postUpload(@Param("img") File img);
```

```java
File file = new File("");
if (!file.exists()) {
    return;
}
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .postUpload(file)
        .enqueue(new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {
                Log.i(TAG, "onSuccess" + " : " + data);
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```

# @Url
在上面的下载请求中已经出现过该注解，在请求时默认的 url 是 @Api 注解的值拼接上 @Get 或 @Post 注解的值，如果某个参数添加了 @Url 注解，则该参数的值将会作为完整的 url 替换默认规则。

# 解析实体类
我们一般的请求都是需要返回实体类，这里只需要像 Retrofit 一样写，在方法的返回值 AbsCall 通过泛型来指定返回类型即可，也支持泛型嵌套。

eg：
```java
@Get("/wallpaper/getList")
AbsCall<QinshouResultBean<PageResultBean<WallpaperBean>>> getWallpaperList(@Param("page") int page, @Param("pageSize") int pageSize);
```

```java
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .getWallpaperList(1, 5)
        .enqueue(new Callback<QinshouResultBean<PageResultBean<WallpaperBean>>>() {
            @Override
            public void onSuccess(QinshouResultBean<PageResultBean<WallpaperBean>> data) {
                Log.i(TAG, "onSuccess" + " : " + data);
            }
            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```

# 请求结果转换 ResponseTransformer
现在后台大部分返回的数据都是这样的。
```xml
{
	"success":1,
	"failureCode":0,
	"failureInfo":"",
	"data":{}
}
```
返回结果通常都会在外面包一层请求成功与否的信息，里面还可能包含错误码和错误信息，而我们真正需要的数据则是作为 JsonObjct 或者 JsonArray 包在里面的。
在使用 Retrofit 的时候可以通过 ResponseTransformer 来预处理数据，这里我们也是定义了一个 ResponseTransformer 接口来完成同样的功能。
```java
OkHttpHelper.SINGLETON.getCaller(TestApi.class)
        .getWallpaperList(1, 5)
        .transform(new ResponseTransformer<QinshouResultBean<PageResultBean<WallpaperBean>>, PageResultBean<WallpaperBean>>() {
            @Override
            public PageResultBean<WallpaperBean> transform(QinshouResultBean<PageResultBean<WallpaperBean>> pageResultBeanQinshouResultBean) throws Exception {
                if (pageResultBeanQinshouResultBean.getSuccess() == 0) {
                    throw new Exception(pageResultBeanQinshouResultBean.getFailureInfo());
                }
                return pageResultBeanQinshouResultBean.getData();
            }
        })
        .enqueue(new Callback<PageResultBean<WallpaperBean>>() {
            @Override
            public void onSuccess(PageResultBean<WallpaperBean> data) {
                Log.i(TAG, "onSuccess" + " : " + data);
            }
            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
            }
        });
```

# 其余功能
OkHttpHelper 中创建一个默认的 OkHttpClient，如果有个性化需求，则可以调用 OkHttpHelper.SINGLETON.recreateOkHttpClient(OkHttpClient okHttpClient) 重新创建。

## HttpParameterInterceptor
该拦截器用于添加公共参数

## HttpHeaderInterceptor
该拦截器用于添加公共 Header

## LogInterceptor
该拦截器用于打印网络请求和响应结果，注意在上传和下载时打印级别不要设置成 Level.BODY，否则一不小心就会栈溢出。

