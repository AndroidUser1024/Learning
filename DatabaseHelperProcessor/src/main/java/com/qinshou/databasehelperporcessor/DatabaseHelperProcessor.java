package com.qinshou.databasehelperporcessor;

import com.google.auto.service.AutoService;
import com.qinshou.databasehelper.annotation.Column;
import com.qinshou.databasehelper.annotation.Table;
import com.squareup.javapoet.ClassName;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;

@AutoService(Processor.class)
public class DatabaseHelperProcessor extends AbstractProcessor {
    private Filer mFiler;
    private Elements mElementUtils;
    private Messager mMessager;
    private Types mTypeUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnv.getFiler();
        mElementUtils = processingEnv.getElementUtils();
        mMessager = processingEnv.getMessager();
        mTypeUtils = processingEnv.getTypeUtils();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        types.add(Table.class.getCanonicalName());
        return types;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        // 获取所有使用了 Repository 注解的类
        Set<? extends Element> elementAnnotatedWithTable = roundEnvironment.getElementsAnnotatedWith(Table.class);
        for (Element tableElement : elementAnnotatedWithTable) {
            String packageName = mElementUtils.getPackageOf(tableElement).getQualifiedName().toString();
            info(packageName);
            ClassName className = ClassName.get(packageName, tableElement.getSimpleName() + "Impl");
//            TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(className)
//                    .addModifiers(Modifier.PUBLIC)
//                    .addSuperinterface(TypeName.get(tableElement.asType()));
//            // 创建文件
//            JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build()).build();
//            try {
//                javaFile.writeTo(mFiler);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }

        return true;
    }

    private void info(String msg, Object... args) {
        mMessager.printMessage(Diagnostic.Kind.NOTE, String.format(msg, args));
    }

}
