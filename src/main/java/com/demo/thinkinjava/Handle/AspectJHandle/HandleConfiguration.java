package com.demo.thinkinjava.Handle.AspectJHandle;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import com.demo.thinkinjava.Handle.Games;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableAspectJAutoProxy
public class HandleConfiguration {

    @Bean
    public AspectJHandle getAspectJHandle(){
        return new AspectJHandle();
    }

    @Bean
    public Games getGames(){
        Games games = new Games();
        games.setName("双人成行");
        games.setGamesType("冒险闯关");
        return games;
    }
}
