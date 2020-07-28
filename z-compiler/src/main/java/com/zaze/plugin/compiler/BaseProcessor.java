package com.zaze.plugin.compiler;


import com.zaze.plugin.compiler.utils.Logger;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.util.Elements;

/**
 * Description :
 *
 * @author : ZAZE
 * @version : 2020-07-24 - 13:43
 */
public abstract class BaseProcessor extends AbstractProcessor {

    Logger logger;
    Filer mFiler;
    Elements elementUtils;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mFiler = processingEnvironment.getFiler();
        logger = new Logger(processingEnvironment.getMessager());
        elementUtils = processingEnvironment.getElementUtils();
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
