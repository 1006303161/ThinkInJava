package Handle.CglibHandle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */


import Handle.Game;
import Handle.Games;
import Handle.JDKHandle.GameHandle;
import com.sun.corba.se.spi.ior.ObjectKey;
import lombok.Data;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.beans.beancontext.BeanContext;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * cflib动态代理
 */
@Data
public class GameCglibHandle implements MethodInterceptor {

    private Games games;


    public static Object getProxy(GameCglibHandle handle) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Games.class);
        enhancer.setCallback(handle);
        return enhancer.create();
    }

    public GameCglibHandle(Games games) {
        super();
        this.games = games;
    }

    public GameCglibHandle() {
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("准备查看一下游戏内容！");
//        Object o1 = methodProxy.invoke(games, objects);
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("游戏体验如何呀？");
        return o1;
    }
}
