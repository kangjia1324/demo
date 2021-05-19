package com.example.demo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Jedis 事务操作
 *
 * @author kangJia
 * @date 2021/1/22 15:03
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        /// 开启数据
        final Transaction multi = jedis.multi();

        try {
            jedis.set("user1", "a");
            jedis.set("user2", "aa");
            jedis.set("user3", "aaa");
            int i = 1/0;
            multi.exec();
        } catch (Exception e) {
            multi.discard();  // 放弃事务
            e.printStackTrace();
        } finally {
            jedis.close();  // 关闭连接
        }
    }
}
