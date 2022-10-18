package com.demo.thinkinjava;

import com.demo.thinkinjava.Handle.AspectJHandle.HandleConfiguration;
import com.demo.thinkinjava.Handle.Games;
import com.demo.thinkinjava.annotation.TestEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class ThinkInJavaApplicationTests {

    @Autowired
    private HandleConfiguration configuration;

    @Test
    void HandleTest(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HandleConfiguration.class);
        Games games = configuration.getGames();
        games.playGames();
        ctx.close();
    }

    @Test
    void TestThinkInJavaTestAnnotation(){
        TestEntity entity = new TestEntity();
        Object info = TestEntity.getInfo(TestEntity.class, entity);
        System.out.println(info);
    }

    @Test
    void contextLoads() {
    }

}
