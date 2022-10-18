package com.demo.thinkinjava.Handle.JDKHandle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import com.demo.thinkinjava.Handle.Games;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Data
public class GameHandle implements InvocationHandler {

    private Games games;

    public GameHandle(Games games) {
        this.games = games;
    }

    //定义方法获取动态生成的代理对象
    public Object getProxyInstance() {
        //通过Proxy类的newInstance方法 动态生成代理对象
        Object proxyInstance = Proxy.newProxyInstance(games.getClass().getClassLoader(), games.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("看看是什么游戏！");
        method.invoke(games, args);
        System.out.println("游戏体验如何？");
        return games;
    }
}
