package com.zaze.plugin.compiler;

import com.google.auto.service.AutoService;
import com.zaze.plugin.annotation.Factory;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Set;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.MirroredTypeException;

/**
 * Description :
 *
 * @author : ZAZE
 * @version : 2020-07-24 - 13:45
 */
@AutoService(Processor.class)
public class FactoryProcessor extends BaseProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
//        if (CollectionUtils.isNotEmpty(set)) {
//            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(Factory.class);
//            parseFactory(elements);
//            return true;
//        }
        return false;
    }

    private void parseFactory(Set<? extends Element> elements) {
        if (CollectionUtils.isEmpty(elements)) {
            return;
        }
        for (Element element : elements) {
            logger.info("A Factory verify over, its " + element);
            logger.info("A Factory verify over, its " + element.asType());
            Factory factory = element.getAnnotation(Factory.class);
            // Get the full QualifiedTypeName
            try {  // 该类已经被编译
                Class<?> clazz = factory.interfaces();
            } catch (MirroredTypeException mte) {// 该类未被编译
                DeclaredType classTypeMirror = (DeclaredType) mte.getTypeMirror();
                TypeElement classTypeElement = (TypeElement) classTypeMirror.asElement();
            }
//            String groupFileName = Consts.NAME_OF_GROUP + groupName;
//            JavaFile.builder(Consts.PACKAGE_OF_GENERATE_FILE,
//                    TypeSpec.classBuilder(groupFileName)
//                            .addJavadoc(WARNING_TIPS)
//                            .addSuperinterface(ClassName.get(type_IRouteGroup))
//                            .addModifiers(PUBLIC)
//                            .addMethod(loadIntoMethodOfGroupBuilder.build())
//                            .build()
//            ).build().writeTo(mFiler);
        }
    }
}