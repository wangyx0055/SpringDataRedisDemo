package com.moui.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by MOTUI on 2016/10/23.
 *
 * 集群测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-redis-cluster.xml")
public class TestRedisClusterTemplate {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        System.out.println(redisTemplate);
    }

    /**
     * key-value 存储
     */
    @Test
    public void test01(){
        ValueOperations operations = redisTemplate.opsForValue();
        String key = "age";
        //存入key-value
        operations.set("age","12");
        //根据key取出Value
        Object age = operations.get("age");
        System.out.println("age:"+age);
        //追加
        operations.append("age","30");
        //获得并修改
        operations.getAndSet("age","40");
        Object age1 = operations.get("age");
        System.out.println("修改后："+age1);

    }


}
