package com.yonyou.energy.common.redis;
import java.io.Serializable;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springside.modules.nosql.redis.JedisTemplate.JedisAction;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisException;

import com.fasterxml.jackson.databind.JavaType;

/**
 * redis客户端 并提供公用的方法
 *
 * @author gaods
 *
 */

public class RedisClient extends CacheManager {

    private static final Logger logger = LoggerFactory
            .getLogger(RedisClient.class);

    /**
     * 判断有没有key
     *
     * @param key
     * @return
     */

    public boolean existKey(final String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                return jedis.exists(key);
            }
        });
    }

    /**
     * 根据key 获取值
     *
     * @param key 键
     * @return value
     */
    public String get(final String key) {
        if (StringUtils.isEmpty(key))
            return null;
        String result = getJedisTemplate().execute(new JedisAction<String>() {
            @Override
            public String action(Jedis jedis) throws JedisException {
                return jedis.get(key);
            }
        });
        return result;
    }

    /**
     * 根据key 获取值
     *
     * @param key 键
     * @return value
     */
    public String set(final String key, final String value) {
        if (StringUtils.isEmpty(key))
            return null;
        String result = getJedisTemplate().execute(new JedisAction<String>() {
            @Override
            public String action(Jedis jedis) throws JedisException {
                return jedis.set(key, value);
            }
        });
        return result;
    }

    /**
     * @param oldkey
     * @param newkey
     * @return
     */

    public String rename(final String oldkey, final String newkey) {
        if (StringUtils.isEmpty(oldkey) || StringUtils.isEmpty(newkey))
            return null;
        String result = getJedisTemplate().execute(new JedisAction<String>() {
            @Override
            public String action(Jedis jedis) throws JedisException {
                return jedis.rename(oldkey, newkey);
            }
        });
        return result;
    }


    /****
     * 将value关联到key上，并设置过期时间， 原子操作，非常实用，如果key已经存在的话，会覆盖旧值
     *
     * @param seconds
     *            过期时间秒
     * @param key
     *            键
     * @param value
     *            值
     * @return
     */
    public boolean putExpireTime(final String key, final String value,
                                 final int seconds) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)
                || seconds <= 0) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                String result = jedis.setex(key, seconds, value);
                return result.equalsIgnoreCase("ok");
            }
        });
    }

    /***
     * 删除key
     *
     * @param key
     * @return
     */
    public boolean delete(final String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                return jedis.del(key) > 0;
            }
        });
    }

    /***
     * 删除key
     *
     * @param key
     * @return
     */
    public boolean deleteKeys(final String... keys) {
        if (StringUtils.isEmpty(keys)) {
            return false;
        }
        return getJedisTemplate().del(keys);
    }

    /***
     * 返回对应Map下对应field的信息
     *
     * @param key
     * @param field
     * @return
     */
    public String getValueFromMap(final String key, final String field) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
            return null;
        }
        return getJedisTemplate().execute(new JedisAction<String>() {
            @Override
            public String action(Jedis jedis) throws JedisException {
                return jedis.hget(key, field);
            }
        });
    }

    /***
     * 讲对应的值存入到redis map中 当field不存在时候，返回的是1 当field存在的时候，返回的是0，表示的覆盖
     *
     * @param key
     * @param field
     * @param value
     * @return
     */

    public boolean storeToMap(final String key, final String field,
                              final String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)
                || StringUtils.isEmpty(value)) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                long result = jedis.hset(key, field, value);
                boolean isSuccess = result == 0 || result == 1;
                if (!isSuccess) {
                    jedis.del(key);
                }
                return isSuccess;
            }
        });
    }

    /***
     * 将field的值存入缓存中，如果已经存在，则返回失败
     *
     * @param key
     * @param field
     * @param value
     * @return
     */
    public boolean storeToMapIfNotExists(final String key, final String field,
                                         final String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)
                || StringUtils.isEmpty(value)) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                return jedis.hsetnx(key, field, value) > 0;
            }
        });
    }

    /****
     * 从hashmap中删除指定的field
     *
     * @param key
     * @param field
     * @return
     */
    public boolean removeFromMap(final String key, final String field) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(field)) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                return jedis.hdel(key, field) == 1;
            }
        });
    }

    /****
     * 将value关联到key上，并设置过期时间，原子操作，非常实用，如果key已经存在的话，会覆盖旧值
     *
     * @param key
     * @param value
     * @return
     */
    public boolean storeValueIfNotExists(final String key, final String value,
                                         final int seconds) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return false;
        }
        return getJedisTemplate().execute(new JedisAction<Boolean>() {
            @Override
            public Boolean action(Jedis jedis) throws JedisException {
                boolean success = jedis.setnx(key, value) > 0;
                if (success) {
                    jedis.expire(key, seconds);
                }
                return success;
            }
        });
    }

    /**
     * 把Java类放到redis里 *
     *
     * @param sid
     * @param key
     * @param value
     */

    public <T extends Serializable> void putCacheForClass(String sid,
                                                          String key, T value) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            byte[] valueBytes = toBytes(value);
            jedis.hset(sid.getBytes(Charset.forName("UTF-8")),
                    key.getBytes(Charset.forName("UTF-8")), valueBytes);
            jedis.expire(sid, getSessionTimeout());
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> void putSessionCacheAttribute(String key,
                                                                  T value) {
        putAttribute(key, value, getSessionTimeout());
    }

    /**
     * @param key
     * @param value
     * @param expiredTs
     */
    public <T extends Serializable> void putAttribute(String key, T value,
                                                      int expiredTs) {

        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            byte[] valueBytes = toBytes(value);
            byte[] keyBytes = key.getBytes(Charset.forName("UTF-8"));
            jedis.set(keyBytes, valueBytes);
            if (expiredTs > 0) {
                jedis.expire(keyBytes, expiredTs);
            }
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    /**
     * 如果存在该KEY 则更新类
     *
     * @param sid
     * @param key
     * @param value
     */

    public <T extends Serializable> void updateCacheAttribute(String sid,
                                                              String key, T value) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            if (jedis.hexists(sid.getBytes(Charset.forName("UTF-8")),
                    key.getBytes(Charset.forName("UTF-8")))) {
                putCacheForClass(sid, key, value);
            }
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> void updateSessionCacheAttribute(
            String key, T value) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            if (jedis.exists(key)) {
                putSessionCacheAttribute(key, value);
            }
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getAttribute(String sid, String key,
                                                   Class<T> t) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            byte[] attrBytes = jedis.hget(
                    sid.getBytes(Charset.forName("UTF-8")),
                    key.getBytes(Charset.forName("UTF-8")));
            if (attrBytes == null) {
                return null;
            }
            return toType(t, attrBytes);
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getAttribute(String key, Class<T> t) {
        return getAttribute(key, 0, t);
    }

    public <T extends Serializable> T getAttribute(String key, int ttl,
                                                   Class<T> t) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            byte[] attrBytes = jedis
                    .get(key.getBytes(Charset.forName("UTF-8")));
            if (attrBytes == null) {
                return null;
            }
            if (ttl > 0) {
                jedis.expire(key, ttl);
            }
            return toType(t, attrBytes);
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getSessionCacheAttribute(String sid,
                                                               String key, Class<T> t) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            boolean isExist = jedis.exists(sid);
            Object result = null;
            if (isExist) {
                jedis.expire(sid, getSessionTimeout());
                byte[] attrBytes = jedis.hget(
                        sid.getBytes(Charset.forName("UTF-8")),
                        key.getBytes(Charset.forName("UTF-8")));
                if (attrBytes == null) {
                    getJedisTemplate().getJedisPool().returnResource(jedis);
                    return null;
                }
                result = toType(t, attrBytes);
            }
            return (T) result;
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getSessionCacheAttribute(String key,
                                                               Class<T> t) {
        Jedis jedis = getJedisTemplate().getJedisPool().getResource();
        try {
            boolean isExist = jedis.exists(key);
            Object result = null;
            if (isExist) {
                jedis.expire(key, getSessionTimeout());
                byte[] attrBytes = jedis.get(key.getBytes(Charset
                        .forName("UTF-8")));
                if (attrBytes == null) {
                    getJedisTemplate().getJedisPool().returnResource(jedis);
                    return null;
                }
                result = toType(t, attrBytes);
            }
            return (T) result;
        } finally {
            getJedisTemplate().getJedisPool().returnResource(jedis);
        }

    }

    private <T extends Serializable> T toType(Class<T> t, byte[] data) {

        T obj = null;
        if (t.isAssignableFrom(String.class)) {
            obj = (T) new String(data);
        } else {
            try {
                JavaType type = getMapper().getTypeFactory().constructType(t);
                obj = (T) getMapper()
                        .readValue(new String(data, "UTF-8"), type);
            } catch (Exception e) {
                logger.error("Format failed", e);
            }
        }
        return obj;
    }

    private <T extends Serializable> byte[] toBytes(T value) {
        byte[] data = null;
        if (value instanceof String) {
            data = ((String) value).getBytes();
        } else {
            try {
                data = getMapper().writeValueAsString(value).getBytes("UTF-8");
            } catch (Exception e) {
                logger.error("JsonProcessingException", e);
            }
        }
        return data;
    }

    /**
     * @param key
     * @return
     */
    public String generateKey(String key) {
        return String.valueOf(getJedisTemplate().incr(key));
    }
}