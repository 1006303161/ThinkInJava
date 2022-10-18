package com.demo.thinkinjava.Handle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import lombok.Data;

@Data
public class Games implements Game{
    private String name;

    private String gamesType;

    public Games() {

    }

    public Games(String name, String gamesType) {
        this.name = name;
        this.gamesType = gamesType;
    }

    @Override
    public void playGames() {
        System.out.println("游戏名称是:" + this.name + ",游戏类型是" + this.gamesType);
        int a = 2/0;
        viewGame();
    }

    public void viewGame() {
        System.out.println("推荐XBOX玩耍");
    }
}
