package com.yonyou.energy.common.redis;
import java.util.List;

import org.springside.modules.nosql.redis.pool.JedisPool;
import org.springside.modules.nosql.redis.pool.JedisPoolBuilder;

/**
 * RedisPoolFactory
 *
 * @author licza
 */
public class RedisPoolFactory {
    /**
     * 根据Spring传入的jedis配置URL创建一个JedisPool,以供JedisTemplate注入
     *
     * @param url like direct://20.12.6.69:6379?poolSize=20&poolName=x
     *
     * @return JedisPool
     */
    public static JedisPool createJedisPool(String url){
        return new JedisPoolBuilder().setUrl(url).buildPool();
    }

    /**
     * 根据特殊格式的url构造分片形式的redis集群需要的池的集合
     *
     * @param shardedUrl
     * @return List<JedisPool>
     */
    public static List<JedisPool> createShardedJedisPools(String shardedUrl){
        return  new JedisPoolBuilder().setUrl(shardedUrl).buildShardedPools();
    }

}