package com.zaze.plugin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description :
 *
 * @author : ZAZE
 * @version : 2020-07-24 - 13:27
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Factory {
    String name() default "Default";

    Class<?> interfaces();
}
