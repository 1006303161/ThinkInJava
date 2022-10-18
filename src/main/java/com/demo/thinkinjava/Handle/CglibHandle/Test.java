package com.demo.thinkinjava.Handle.CglibHandle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */



import com.demo.thinkinjava.Handle.Game;
import com.demo.thinkinjava.Handle.Games;
import org.springframework.cglib.core.DebuggingClassWriter;

public class Test {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\jiafeng.liu\\Desktop");
        GameCglibHandle handle = new GameCglibHandle();
        Games games = (Games) GameCglibHandle.getProxy(handle);
        games.setName("双人火柴人");
//        games2.setGamesType("双人小游戏");
        games.playGames();
    }


}
