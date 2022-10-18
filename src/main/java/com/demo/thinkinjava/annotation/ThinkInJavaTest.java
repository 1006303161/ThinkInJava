package com.demo.thinkinjava.annotation;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解标记 可用于属性 方法
@Target({ElementType.FIELD, ElementType.METHOD})
//运行时可触发
@Retention(RetentionPolicy.RUNTIME)
public @interface ThinkInJavaTest {

    String gameName() default "";

    String gameType() default "";

}
