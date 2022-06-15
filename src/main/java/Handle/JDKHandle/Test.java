package Handle.JDKHandle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import Handle.Game;
import Handle.Games;

public class Test {

    public static void main(String[] args) {

        //创建委托对象
        Games games = new Games("双人火柴人", "双人游戏");
        GameHandle handle = new GameHandle(games);
        //获取代理对象
        Game proxyInstance = (Game) handle.getProxyInstance();
        proxyInstance.playGames();
    }
}
