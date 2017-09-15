package com.yonyou.energy.common.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yonyou.energy.common.utils.YCCookieUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springside.modules.nosql.redis.JedisTemplate;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Session属性管理类，session中需要存储的属性都放到redis缓存中，session丢失后从redis中复制回去
 * <br>
 * 要求session中不能存储复杂的数据结构，且存放的属性建议基本类型,属性值需要实现序列化接口
 *
 * @author zxs
 */
@Component
public class SessionCacheManager {

    private static final Logger logger = LoggerFactory.getLogger(SessionCacheManager.class);

    private int sessionTimeout = 3600;

    private JedisTemplate jedisTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();


    public <T extends Serializable> Map<String, T> getAllSessionAttrCache(String sid, Class<T> t) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            HashMap<String, T> hashMap = new HashMap<String, T>();
            Map<byte[], byte[]> redisMap = jedis.hgetAll(sid.getBytes(Charset.forName("UTF-8")));

            for (Iterator<byte[]> iterator = redisMap.keySet().iterator(); iterator.hasNext(); ) {
                byte[] byteKey = iterator.next();
                String key = new String(byteKey, Charset.forName("UTF-8"));
                T obj = toType(t, redisMap.get(byteKey));
                if (null == obj) {
                    hashMap.put(key, obj);
                }
            }
            jedis.expire(sid, sessionTimeout);
            return hashMap;
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public void removeSessionCache(String sid) {
        jedisTemplate.del(sid);
    }

    public <T extends Serializable> void putSessionCacheAttribute(String sid, String key, T value) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            byte[] valueBytes = toBytes(value);
            jedis.hset(sid.getBytes(Charset.forName("UTF-8")), key.getBytes(Charset.forName("UTF-8")), valueBytes);
            jedis.expire(sid, sessionTimeout);
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> void putSessionCacheAttribute(String key, T value) {
        putAttribute(key, value, sessionTimeout);
    }

    public <T extends Serializable> void putAttribute(String key, T value, int expiredTs) {

        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            byte[] valueBytes = toBytes(value);
            byte[] keyBytes = key.getBytes(Charset.forName("UTF-8"));
            jedis.set(keyBytes, valueBytes);
            if (expiredTs > 0) {
                jedis.expire(keyBytes, expiredTs);
            }
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> void updateSessionCacheAttribute(String sid, String key, T value) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            if (jedis.hexists(sid.getBytes(Charset.forName("UTF-8")), key.getBytes(Charset.forName("UTF-8")))) {
                putSessionCacheAttribute(sid, key, value);
            }
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> void updateSessionCacheAttribute(String key, T value) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            if (jedis.exists(key)) {
                putSessionCacheAttribute(key, value);
            }
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getAttribute(String sid, String key, Class<T> t) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            byte[] attrBytes = jedis
                    .hget(sid.getBytes(Charset.forName("UTF-8")), key.getBytes(Charset.forName("UTF-8")));
            if (attrBytes == null) {
                return null;
            }
            return toType(t, attrBytes);
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getAttribute(String key, Class<T> t) {
        return getAttribute(key, 0, t);
    }

    public <T extends Serializable> T getAttribute(String key, int ttl, Class<T> t) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
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
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getSessionCacheAttribute(String sid, String key, Class<T> t) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            boolean isExist = jedis.exists(sid);
            Object result = null;
            if (isExist) {
                jedis.expire(sid, sessionTimeout);
                byte[] attrBytes = jedis
                        .hget(sid.getBytes(Charset.forName("UTF-8")), key.getBytes(Charset.forName("UTF-8")));
                if (attrBytes == null) {
                    jedisTemplate.getJedisPool().returnResource(jedis);
                    return null;
                }
                result = toType(t, attrBytes);
            }
            return (T) result;
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }
    }

    public <T extends Serializable> T getSessionCacheAttribute(String key, Class<T> t) {
        Jedis jedis = jedisTemplate.getJedisPool().getResource();
        try {
            boolean isExist = jedis.exists(key);
            Object result = null;
            if (isExist) {
                jedis.expire(key, sessionTimeout);
                byte[] attrBytes = jedis.get(key.getBytes(Charset.forName("UTF-8")));
                if (attrBytes == null) {
                    jedisTemplate.getJedisPool().returnResource(jedis);
                    return null;
                }
                result = toType(t, attrBytes);
            }
            return (T) result;
        } finally {
            jedisTemplate.getJedisPool().returnResource(jedis);
        }

    }

    public long removeSessionCacheAttribute(String sid, String key) {
        if (StringUtils.isNotBlank(sid) && StringUtils.isNotBlank(key)) {
            return jedisTemplate.hdel(sid, key);
        }
        return 0;
    }

    public boolean removeSessionCacheAttribute(String key) {
        if (StringUtils.isNotBlank(key)) {
            return jedisTemplate.del(key);
        }
        return false;
    }

    public <T extends Serializable> T getCurUser(String uname, Class<T> clz) {
        T result = getSessionCacheAttribute(createUserCacheKey(uname), clz);
        return result;
    }

    public <T extends Serializable> T getCurUser(HttpServletRequest request, Class<T> clz) {
        String uname = YCCookieUtil.get(request.getCookies(), CookieConstants.UCUSERID);
        if (StringUtils.isNotBlank(uname)) {
            return getCurUser(uname, clz);
        }
        return null;
    }

    public <T extends Serializable> void cacheUser(String uname, T user) {
        try {
            putSessionCacheAttribute(createUserCacheKey(uname), mapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public <T extends Serializable> void refreshUser(String uname, T user) {
        try {
            updateSessionCacheAttribute(createUserCacheKey(uname), mapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public <T extends Serializable> void disCacheUser(String uname) {
        removeSessionCacheAttribute(createUserCacheKey(uname));
    }

    private <T extends Serializable> T toType(Class<T> t, byte[] data) {

        T obj = null;
        if (t.isAssignableFrom(String.class)) {
            obj = (T) new String(data);
        } else {
            try {
                JavaType type = mapper.getTypeFactory().constructType(t);
                obj = (T) mapper.readValue(new String(data, "UTF-8"), type);
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
                data = mapper.writeValueAsString(value).getBytes("UTF-8");
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
        return String.valueOf(jedisTemplate.incr(key));
    }

    private String createUserCacheKey(String uname) {
        return new StringBuffer(SessionCacheContants.USER_INFO_LOGIN).append(":").append(uname).toString();
    }

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
}