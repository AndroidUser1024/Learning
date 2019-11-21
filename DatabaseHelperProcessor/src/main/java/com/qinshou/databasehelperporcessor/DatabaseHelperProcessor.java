package com.qinshou.databasehelperporcessor;

import com.google.auto.service.AutoService;
import com.qinshou.databasehelper.annotation.Column;
import com.qinshou.databasehelper.annotation.Id;
import com.qinshou.databasehelper.annotation.Table;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;

@AutoService(Processor.class)
public class DatabaseHelperProcessor extends AbstractProcessor {
    private Filer mFiler;
    private Elements mElementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnv.getFiler();
        mElementUtils = processingEnv.getElementUtils();
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
        // 获取所有使用了 Api 注解的类
        Set<? extends Element> elementAnnotatedWithTable = roundEnvironment.getElementsAnnotatedWith(Table.class);
        for (Element tableElement : elementAnnotatedWithTable) {
            if (tableElement.getKind() != ElementKind.CLASS) {
                continue;
            }
            String packageName = mElementUtils.getPackageOf(tableElement).getQualifiedName().toString();
            ClassName className = ClassName.get(packageName, tableElement.getSimpleName() + "Dao");
            TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(className)
                    .addModifiers(Modifier.PUBLIC);
            MethodSpec methodSpec = createTable(tableElement);
            typeSpecBuilder.addMethod(methodSpec);
            // 创建文件
            JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build()).build();
            try {
                javaFile.writeTo(mFiler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    private MethodSpec createTable(Element tableElement) {
        Table table = tableElement.getAnnotation(Table.class);
        String tableName = "";
        if (TextUtil.isEmpty(table.name())) {
            tableName = tableElement.getSimpleName().toString();
        } else {
            tableName = table.name();
        }
        StringBuilder columnStringBuilder = new StringBuilder();
        for (Element element : tableElement.getEnclosedElements()) {
            if (element.getKind() == ElementKind.FIELD
                    && element.getAnnotation(Column.class) != null) {
                Column column = element.getAnnotation(Column.class);
                if (TextUtil.isEmpty(column.name())) {
                    columnStringBuilder.append(element.getSimpleName())
                            .append(" ")
                            .append(column.columnType())
                            .append(",");
                } else {
                    columnStringBuilder.append(column.name())
                            .append(" ")
                            .append(column.columnType())
                            .append(",");
                }
                if (element.getAnnotation(Id.class) != null) {
                    columnStringBuilder.insert(columnStringBuilder.length() - 1, " PRIMARY KEY AUTOINCREMENT");
                }
            }
        }
        // 删除最后一个 ","
        columnStringBuilder.deleteCharAt(columnStringBuilder.length() - 1);
        return MethodSpec.methodBuilder("createTable")
                .returns(String.class)
                .addStatement("return \"CREATE TABLE IF NOT EXIST " + tableName + "("
                        + columnStringBuilder
                        + ")\"")
                .build();
    }
}
