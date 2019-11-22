package com.qinshou.okhttphelperprocessor;


import com.google.auto.service.AutoService;
import com.google.gson.reflect.TypeToken;
import com.qinshou.okhttphelper.util.RequestFactory;
import com.qinshou.okhttphelper.util.TypeUtil;
import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.CommonParameter;
import com.qinshou.okhttphelper.annotation.DefaultHost;
import com.qinshou.okhttphelper.annotation.Host;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Get;
import com.qinshou.okhttphelper.annotation.Header;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Multipart;
import com.qinshou.okhttphelper.annotation.Path;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.annotation.Query;
import com.qinshou.okhttphelper.interceptor.HttpParameterInterceptor;
import com.qinshou.okhttphelper.interceptor.LogInterceptor;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.tools.Diagnostic;

import okhttp3.OkHttpClient;
import okhttp3.Request;


@AutoService(Processor.class)
public class OkHttpHelperProcessor extends AbstractProcessor {

    private Elements mElementUtils;
    private Filer mFiler;
    private Messager mMessager;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mElementUtils = processingEnv.getElementUtils();
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Api.class.getCanonicalName());
        types.add(CommonParameter.class.getCanonicalName());
        types.add(DefaultHost.class.getCanonicalName());
        types.add(Host.class.getCanonicalName());
        types.add(Field.class.getCanonicalName());
        types.add(Get.class.getCanonicalName());
        types.add(Header.class.getCanonicalName());
        types.add(Json.class.getCanonicalName());
        types.add(Multipart.class.getCanonicalName());
        types.add(Path.class.getCanonicalName());
        types.add(Post.class.getCanonicalName());
        types.add(Query.class.getCanonicalName());
        return types;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnv) {
        // 获取所有使用了 Api 注解的类
        Set<? extends Element> elementSetAnnotatedWithApi = roundEnv.getElementsAnnotatedWith(Api.class);
        for (Element apiElement : elementSetAnnotatedWithApi) {
            // 使用了 Api 注解的类必须是接口类
            if (apiElement.getKind() != ElementKind.INTERFACE) {
                continue;
            }
            // 创建一个工具类
            String packageName = mElementUtils.getPackageOf(apiElement).getQualifiedName().toString();
            ClassName className = ClassName.get(packageName, "OkHttpHelperFor" + apiElement.getSimpleName());
            TypeSpec.Builder typeSpecBuilder = TypeSpec.enumBuilder(className)
                    .addModifiers(Modifier.PUBLIC)
                    .addEnumConstant("SINGLETON")
                    // 添加 mOkHttpClient 成员变量
                    .addField(OkHttpClient.class, "mOkHttpClient", Modifier.PRIVATE)
                    // setOkHttpClient 方法
                    .addMethod(MethodSpec.methodBuilder("setOkHttpClient")
                            .addModifiers(Modifier.PUBLIC)
                            .addParameter(ParameterSpec.builder(OkHttpClient.class, "okHttpClient").build())
                            .returns(TypeName.VOID)
                            .addStatement("this.mOkHttpClient = okHttpClient")
                            .build());
            MethodSpec.Builder constructorBuilder = MethodSpec.constructorBuilder()
                    .addStatement("$T okHttpClientBuilder = new $T()", OkHttpClient.Builder.class, OkHttpClient.Builder.class)
                    // 连接超时时间
                    .addStatement("okHttpClientBuilder.connectTimeout($L,$T.$L)", 15 * 1000, TimeUnit.class, TimeUnit.MILLISECONDS)
                    // 读取超时时间
                    .addStatement("okHttpClientBuilder.readTimeout($L,$T.$L)", 15 * 1000, TimeUnit.class, TimeUnit.MILLISECONDS)
                    // 写入超时时间
                    .addStatement("okHttpClientBuilder.writeTimeout($L,$T.$L)", 15 * 1000, TimeUnit.class, TimeUnit.MILLISECONDS)
                    // 请求日志拦截器
                    .addStatement("okHttpClientBuilder.addInterceptor(new $T($T.Level.BODY, new $T.Logger() {\n" +
                            "@Override" +
                            "\n" +
                            "public void log(String message) {" +
                            "\n" +
                            "System.out.println(\"log:message--->\" + message);" +
                            "\n" +
                            "}" +
                            "\n" +
                            "}))", LogInterceptor.class, LogInterceptor.class, LogInterceptor.class)
                    // 创建一个 Map 集合,存放公共参数
                    .addStatement("$T<String,Object> commonParameterMap = new $T<>()", Map.class, HashMap.class);
            // defaultHostElement
            VariableElement defaultHostElement = null;
            // 获取类中所有元素,类似获取 DOM 树
            List<? extends Element> enclosedElements = apiElement.getEnclosedElements();
            for (Element element : enclosedElements) {
                if (element.getKind() == ElementKind.FIELD && element.getAnnotation(DefaultHost.class) != null && element instanceof VariableElement) {
                    // DefaultHost,默认域名,如果有多个,则会覆盖
                    defaultHostElement = (VariableElement) element;
                } else if (element.getKind() == ElementKind.FIELD && element.getAnnotation(CommonParameter.class) != null && element instanceof VariableElement) {
                    // 添加公共参数
                    constructorBuilder.addStatement("commonParameterMap.put($S,$S)", element.getAnnotation(CommonParameter.class).name(), ((VariableElement) element).getConstantValue());
                } else if (element.getKind() == ElementKind.METHOD && element instanceof ExecutableElement) {
                    // 请求方法
                    MethodSpec methodSpec = null;
                    if (element.getAnnotation(Get.class) != null) {
                        // Get 请求
                        methodSpec = createGetRequestMethod(element.getSimpleName().toString(), (ExecutableElement) element, defaultHostElement);
                    } else if (element.getAnnotation(Post.class) != null) {
                        // Post 请求
                        methodSpec = createPostRequestMethod(element.getSimpleName().toString(), (ExecutableElement) element, defaultHostElement);
                    }
                    if (methodSpec != null) {
                        typeSpecBuilder.addMethod(methodSpec);
                    }
                }
            }
            // 请求参数拦截器,用于添加公共参数
            constructorBuilder.addStatement("okHttpClientBuilder.addInterceptor(new $T.Builder()" +
                    "\n" +
                    ".addHeaderParameterMap(commonParameterMap)" +
                    "\n" +
                    ".build())", HttpParameterInterceptor.class)
                    .addStatement("mOkHttpClient = okHttpClientBuilder.build()");
            // 构造方法
            typeSpecBuilder.addMethod(constructorBuilder.build());
            // 创建文件
            JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build()).build();
            try {
                javaFile.writeTo(mFiler);
            } catch (IOException e) {
                return false;
            }
        }
        return true;
    }

    private void info(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(msg, args));
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/7/4 19:02
     * Description:创建 get 请求方法
     *
     * @param methodName    方法名
     * @param element
     * @param defaultDomain 默认域名
     * @return 方法模版
     */
    private MethodSpec createGetRequestMethod(String methodName, ExecutableElement element, VariableElement defaultDomain) {
        info("createGetRequestMethod");
        // 创建一个方法模版构造器
        // 设置方法名和 public 修饰符
        MethodSpec.Builder builder = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC);
        // 方法模版构造器设置返回值
        builder.returns(TypeName.get(element.getReturnType()));
        // 获取参数列表
        List<? extends VariableElement> parameterList = element.getParameters();
        // 创建一个 map 来保存请求头
        builder.addStatement("$T<String, String> headerMap = new $T<>()", Map.class, HashMap.class);
        // 获取 Header 注解数组
        Header[] headerAnnotationArray = element.getAnnotationsByType(Header.class);
        // 将所有 Header 注解添加到 map 中
        for (Header header : headerAnnotationArray) {
            builder.addStatement("headerMap.put($S,$S)", header.name(), header.value());
        }
        // 创建一个 map 来保存请求参数
        builder.addStatement("$T<String, Object> parameterMap = new $T<>()", Map.class, HashMap.class);
        // 获取 url
        String url = element.getAnnotation(Get.class).value();
        // 将 url 按 "/" 分开,拿到每一个 path 部分组成的数组,后面会判断这个数组中是否有 "{","}" 占位符
        String[] pathArray = url.split("/");
        // 遍历参数列表
        for (VariableElement variableElement : parameterList) {
            // 获取参数名
            Name parameterName = variableElement.getSimpleName();
            // 方法模版构造器添加参数
            builder.addParameter(TypeName.get(variableElement.asType()), parameterName.toString());
            if (variableElement.getAnnotation(Path.class) != null) {
                // 如果有 Path 注解,则遍历 pathArray
                for (String string : pathArray) {
                    // pathArray 中的 item 去掉 "{" 和 "}" 后与 Path 注解的值相同,则替换 value 中对应部分
                    if (string.startsWith("{") && string.endsWith("}")) {
                        String pathPlaceHolder = string.replace("{", "").replace("}", "");
                        if (pathPlaceHolder.equals(variableElement.getAnnotation(Path.class).value())) {
                            url = url.replace(string, "\"+" + parameterName.toString() + "+\"");
                            break;
                        }
                    }
                }
            } else if (variableElement.getAnnotation(Query.class) != null) {
                // 如果有 Query 注解则使用 Query 注解的值作为请求参数的参数名
                builder.addStatement("parameterMap.put($S,$L)", variableElement.getAnnotation(Query.class).name(), parameterName.toString());
            } else {
                // 使用参数名作为请求参数的参数名
                builder.addStatement("parameterMap.put($S,$L)", parameterName, parameterName.toString());
            }
        }
        // 如果 url 仍有 "{","}" 占位符,抛出异常
        if (url.contains("{") || url.contains("}")) {
            throw new IllegalStateException("The url is invalid");
        }
        // 如果没有 Host 注解也没有 defaultDomain,抛出异常
        if (element.getAnnotation(Host.class) == null && defaultDomain == null) {
            throw new NullPointerException("There is neither defaultDomain nor domain");
        }
        if (element.getAnnotation(Host.class) != null) {
            // 如果方法上有 Host 注解优先使用 Host 的值
            url = "\"" + element.getAnnotation(Host.class).value() + url + "\"";
        } else {
            // 否则使用 defaultDomain 拼接
            url = "\"" + defaultDomain.getConstantValue().toString() + url + "\"";
        }
        builder.addStatement("$T request = $T.newGetRequest($L,headerMap,parameterMap)", Request.class, RequestFactory.class, url);
        // 获取泛型
        String resultType = element.getReturnType().toString();
        resultType = resultType.replace("com.qinshou.okhttphelper.call.Call<", "");
        resultType = resultType.substring(0, resultType.length() - 1);
        builder.addStatement("$T type = new com.google.gson.reflect.TypeToken<" + resultType + ">(){}.getType()", Type.class);
        // 创建 Call 对象
        builder.addStatement(element.getReturnType().toString() + " call = new " + element.getReturnType().toString() + "(mOkHttpClient,request,type)");
        builder.addStatement("return call");
        return builder.build();
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/7/5 11:36
     * Description:创建 post 请求方法
     *
     * @param methodName    方法名
     * @param element
     * @param defaultDomain 默认域名
     * @return 方法模版
     */
    private MethodSpec createPostRequestMethod(String methodName, ExecutableElement element, VariableElement defaultDomain) {
        info("createPostRequestMethod");
        // 创建一个方法模版构造器
        // 设置方法名和 public 修饰符
        MethodSpec.Builder builder = MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC);
        // 方法模版构造器设置返回值
        builder.returns(TypeName.get(element.getReturnType()));
        // 获取参数列表
        List<? extends VariableElement> parameterList = ((ExecutableElement) element).getParameters();
        // 创建一个 map 来保存请求头
        builder.addStatement("$T<String, String> headerMap = new $T<>()", Map.class, HashMap.class);
        // 获取 Header 注解数组
        Header[] headerAnnotationArray = element.getAnnotationsByType(Header.class);
        // 将所有 Header 注解添加到 map 中
        for (Header header : headerAnnotationArray) {
            builder.addStatement("headerMap.put($S,$S)", header.name(), header.value());
        }
        // 创建一个 map 来保存请求参数
        builder.addStatement("$T<String, Object> parameterMap = new $T<>()", Map.class, HashMap.class);
        // 获取 url
        String url = element.getAnnotation(Post.class).value();
        // 遍历参数列表
        for (VariableElement variableElement : parameterList) {
            // 获取参数名
            Name parameterName = variableElement.getSimpleName();
            // 方法模版构造器添加参数
            builder.addParameter(TypeName.get(variableElement.asType()), parameterName.toString());
            if (variableElement.getAnnotation(Field.class) != null) {
                // 如果有 Field 注解则使用 Field 注解的值作为请求参数的参数名
                builder.addStatement("parameterMap.put($S,$L)", variableElement.getAnnotation(Field.class).name(), parameterName.toString());
            } else {
                // 使用参数名作为请求参数的参数名
                builder.addStatement("parameterMap.put($S,$L)", parameterName, parameterName.toString());
            }
        }
        // 如果没有 Host 注解也没有 defaultDomain,抛出异常
        if (element.getAnnotation(Host.class) == null && defaultDomain == null) {
            throw new NullPointerException("There is neither defaultDomain nor domain");
        }
        if (element.getAnnotation(Host.class) != null) {
            // 如果方法上有 Host 注解优先使用 Host 的值
            url = "\"" + element.getAnnotation(Host.class).value() + url + "\"";
        } else {
            // 否则使用 defaultDomain 拼接
            url = "\"" + defaultDomain.getConstantValue().toString() + url + "\"";
        }
        if (element.getAnnotation(Json.class) != null) {
            builder.addStatement("$T request=$T.newPostJsonRequest($L,headerMap,parameterMap)", Request.class, RequestFactory.class, url);
        } else if (element.getAnnotation(Multipart.class) != null) {
            builder.addStatement("$T request=$T.newPostFileRequest($L,headerMap,parameterMap)", Request.class, RequestFactory.class, url);
        } else {
            builder.addStatement("$T request=$T.newPostRequest($L,headerMap,parameterMap)", Request.class, RequestFactory.class, url);
        }
        // 获取泛型
        String resultType = element.getReturnType().toString();
        resultType = resultType.replace("com.qinshou.okhttphelper.call.Call<", "");
        resultType = resultType.substring(0, resultType.length() - 1);
        builder.addStatement("$T type = new com.google.gson.reflect.TypeToken<" + resultType + ">(){}.getType()", Type.class);
        // 创建 Call 对象
        builder.addStatement(element.getReturnType().toString() + " call = new " + element.getReturnType().toString() + "(mOkHttpClient,request,type)");
        builder.addStatement("return call");
        return builder.build();
    }
}
