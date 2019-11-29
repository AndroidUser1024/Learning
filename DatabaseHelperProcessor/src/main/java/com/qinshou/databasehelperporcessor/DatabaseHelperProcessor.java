package com.qinshou.databasehelperporcessor;

import com.google.auto.service.AutoService;
import com.qinshou.databasehelper.annotation.Column;
import com.qinshou.databasehelper.annotation.Table;
import com.squareup.javapoet.MethodSpec;

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
//        // 获取所有使用了 Repository 注解的类
//        Set<? extends Element> elementAnnotatedWithRepository = roundEnvironment.getElementsAnnotatedWith(Repository.class);
//        for (Element repositoryElement : elementAnnotatedWithRepository) {
//            if (repositoryElement.getKind() != ElementKind.INTERFACE
//                    || !(repositoryElement instanceof TypeElement)) {
//                continue;
//            }
//            List<? extends TypeMirror> interfaces = ((TypeElement) repositoryElement).getInterfaces();
//            boolean extendCrudRepository = false;
//            for (TypeMirror typeMirror : interfaces) {
//                if (TextUtil.equals(mTypeUtils.asElement(typeMirror).toString(), CrudRepository.class.getName())) {
//                    extendCrudRepository = true;
//                }
//            }
//            if (!extendCrudRepository) {
//                continue;
//            }
//            String packageName = mElementUtils.getPackageOf(repositoryElement).getQualifiedName().toString();
//            ClassName className = ClassName.get(packageName, repositoryElement.getSimpleName() + "Impl");
//            TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(className)
//                    .addModifiers(Modifier.PUBLIC)
//                    .addSuperinterface(TypeName.get(repositoryElement.asType()));
//            // 创建文件
//            JavaFile javaFile = JavaFile.builder(packageName, typeSpecBuilder.build()).build();
//            try {
//                javaFile.writeTo(mFiler);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        // 获取所有使用了 Repository 注解的类
        Set<? extends Element> elementAnnotatedWithTable = roundEnvironment.getElementsAnnotatedWith(Table.class);
        for (Element tableElement : elementAnnotatedWithTable) {
            Table table = tableElement.getAnnotation(Table.class);
            String tableName = "";
            if (TextUtil.isEmpty(table.name())) {
                tableName = tableElement.getSimpleName().toString();
            } else {
                tableName = table.name();
            }
            StringBuilder createTableSql = new StringBuilder();
            createTableSql.append("CREATE TABLE IF NOT EXIST ")
                    .append(tableName)
                    .append(" (");

            StringBuilder insertSql = new StringBuilder();
            insertSql.append(" INSERT INTO ")
                    .append(tableName)
                    .append(" (");
            List<String> columnNameList = new ArrayList<>();
            List<String> columnTypeList = new ArrayList<>();
            int idIndex = -1;
            boolean generateId = false;
            for (Element element : tableElement.getEnclosedElements()) {
                if (element.getKind() != ElementKind.FIELD || element.getAnnotation(Column.class) == null) {
                    continue;
                }
                // 建表语句
                Column column = element.getAnnotation(Column.class);
                String columnName = TextUtil.isEmpty(column.name()) ? element.getSimpleName().toString() : column.name();
                columnNameList.add(columnName);
                columnTypeList.add(column.columnType().name());
                if (column.id() && idIndex == -1) {
                    // 主键
                    idIndex = columnNameList.indexOf(columnName);
                    // 自增主键
                    if (column.generateId()) {
                        generateId = true;
                    }
                }

                // Insert 语句
                insertSql.append(columnName)
                        .append(",");
            }
            for (int i = 0; i < columnNameList.size(); i++) {
                createTableSql.append(columnNameList.get(i))
                        .append(" ")
                        .append(columnTypeList.get(i));
                if (i == idIndex) {
                    createTableSql.append(" PRIMARY KEY");
                    if (generateId) {
                        createTableSql.append(" AUTOINCREMENT");
                    }
                }
                if (i != columnNameList.size() - 1) {
                    createTableSql.append(",");
                }
            }
            // 删除最后一个 ","
            createTableSql.append(");");
            info("createTableSql--->" + createTableSql);
//            String packageName = mElementUtils.getPackageOf(tableElement).getQualifiedName().toString();
//            ClassName className = ClassName.get(packageName, tableElement.getSimpleName() + "Impl");
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
