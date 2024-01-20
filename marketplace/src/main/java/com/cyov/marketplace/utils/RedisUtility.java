package com.cyov.marketplace.utils;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisUtility {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    Gson gson;

    public void setValue(String key, Object value) {
        String setValue = gson.toJson(value);
        redisTemplate.opsForValue().set(key, setValue);
        redisTemplate.expire(key, 160, TimeUnit.MINUTES);
    }

    public Object getValue(String key) {
        return gson.fromJson(redisTemplate.opsForValue().get(key), Object.class);
    }

    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }

}