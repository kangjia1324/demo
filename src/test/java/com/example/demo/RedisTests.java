package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        // opsForValue();  操作字符串
        // opsForList();  操作 list
        // opsForSet();
        // opsForHash();
        // opsForZset();
        // opsForHyperLogLog();
        // opsForGeo();

        redisTemplate.opsForValue().set("k1", "kangjia");

        // 获取连接对象
        final RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushDb();
        connection.flushAll();
    }
}
