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
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class Test {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\jiafeng.liu\\Desktop");
        GameCglibHandle handle = new GameCglibHandle();
        Games games2 = (Games) GameCglibHandle.getProxy(handle);
        games2.setName("双人火柴人");
//        games2.setGamesType("双人小游戏");
        games2.playGames();
    }


}
