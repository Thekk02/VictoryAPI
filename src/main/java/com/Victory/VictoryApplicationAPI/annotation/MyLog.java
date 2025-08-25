package com.Victory.VictoryApplicationAPI.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author kk
 * @description 自定义日志注解
 * @date 2025-07-01 14:40:36
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {

    String title() default "";

    String  content() default "";
}
