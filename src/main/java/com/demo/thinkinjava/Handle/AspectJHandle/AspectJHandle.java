package com.demo.thinkinjava.Handle.AspectJHandle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * 动态代理练习
 * @author jiafeng.liu
 * 五种通知注解：@Before/@Around/@After/@AfterReturning/@AfterThrowing
 * 一种 指定通知位置：@Pointcut
 */

@Aspect
@Component
public class AspectJHandle {

    @Pointcut(value = "execution(* com.demo.thinkinjava.Handle.Games.playGames(..))")
    public void pointCut()  {

    }

    @Before(value = "execution(* com.demo.thinkinjava.Handle.Games.playGames(..))")
    public void beforeCut(JoinPoint joinPoint){
        System.out.println("程序运行前A "+joinPoint.getSignature().getName()+"..."+joinPoint.getArgs());
    }

    @After(value = "pointCut()")
    public void afterCut(JoinPoint joinPoint){
        System.out.println("程序运行后B "+joinPoint.getSignature().getName()+"..."+joinPoint.getArgs());
    }

//    @AfterReturning(value = "pointCut()")
    public void AfterRenturnning(JoinPoint joinPoint){
        System.out.println("程序返回后C "+joinPoint.getSignature().getName()+"..."+joinPoint.getArgs());
    }

    @AfterThrowing(value = "pointCut()")
    public void AfterThrowing(JoinPoint joinPoint){
        System.out.println("程序抛出异常D "+joinPoint.getSignature().getName()+"..."+joinPoint.getArgs());
    }

//    @Around(value = "pointCut()")
    public void Around(JoinPoint joinPoint){
        System.out.println("全程增强E "+joinPoint.getSignature().getName()+"..."+joinPoint.getArgs());
    }
}
