package com.demo.thinkinjava.annotation;
/*
 * Copyright (C) 1997-2020 康成投资（中国）有限公司
 *
 * http://www.rt-mart.com
 *
 * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 注解实战
 */
@Data
public class TestEntity {

    @ThinkInJavaTest(gameName = "双人成行")
    private String name;

    @ThinkInJavaTest(gameType = "双人闯关游戏")
    private String type;

    /**
     * 注解为属性赋值
     * @param clazz
     * @param o
     * @return
     */
    public static Object getInfo(Class<?> clazz, Object o) {
        Field[] fields = clazz.getDeclaredFields();
        if (o instanceof TestEntity) {
            ObjectMapper objectMapper = new ObjectMapper();
            TestEntity entity = objectMapper.convertValue(o, TestEntity.class);
            for (Field field : fields) {
                //遍历到对应的注解类,处理
                if (field.isAnnotationPresent(ThinkInJavaTest.class)) {
                    ThinkInJavaTest annotation = field.getAnnotation(ThinkInJavaTest.class);
                    if(!("".equals(annotation.gameName())|| Objects.isNull(annotation.gameName()))){
                        entity.setName(annotation.gameName());
                    }
                    if(!("".equals(annotation.gameType())|| Objects.isNull(annotation.gameType()))){
                        entity.setType(annotation.gameType());
                    }
                }
            }
            return entity;
        }
        return null;
    }


}
