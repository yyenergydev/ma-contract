package com.yonyou.energy.common.redis;

import org.springside.modules.nosql.redis.JedisTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author gaods 缓存公共类
 */

public class CacheManager {

    private JedisTemplate jedisTemplate;

    private int sessionTimeout = 3600;

    private static final ObjectMapper mapper = new ObjectMapper();

    public JedisTemplate getJedisTemplate() {
        return jedisTemplate;
    }

    public void setJedisTemplate(JedisTemplate jedisTemplate) {
        this.jedisTemplate = jedisTemplate;
    }

    public int getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(int sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public static ObjectMapper getMapper() {
        return mapper;
    };


}