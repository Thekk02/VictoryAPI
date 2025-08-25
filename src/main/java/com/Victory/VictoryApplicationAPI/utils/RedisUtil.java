package com.Victory.VictoryApplicationAPI.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author kk
 * @description redis工具类
 * @date 2025-07-04 08:19:58
 */
@Slf4j
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate redisTemplate;

    //指定缓存失效时间
    public Boolean expire(final String key,final long time){
        try{
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //根据键获取值
    public Object get(final String key){
        log.warn(key);
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    //将<key,value>键值对存入redia
    public Boolean set(final String key,final Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //将键值对存入value并设置过期时间
    public Boolean set(final String key,final Object value,final long time){
        try{
            if(time > 0){
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }else{
                set(key, value);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //删除键
    public Boolean del(final String key){
        try{
            redisTemplate.opsForValue().getAndDelete(key);
            return true;
        }catch (final Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
