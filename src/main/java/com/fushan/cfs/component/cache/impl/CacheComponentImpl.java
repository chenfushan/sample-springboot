package com.fushan.cfs.component.cache.impl;

import com.fushan.cfs.component.cache.CacheCallback;
import com.fushan.cfs.component.cache.CacheComponent;
import com.fushan.cfs.component.model.CacheResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by alps on 2019/1/16.
 */
@Component("cacheComponent")
public class CacheComponentImpl implements CacheComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheComponentImpl.class);

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean set(final String key,final String value) {
        final CacheResult<String> result = new CacheResult<>();
        operate(result,() -> {
            stringRedisTemplate.opsForValue().set(key, value);
        });
        return result.isSuccess();
    }

    @Override
    public boolean set(String key, String value, long timeout) {
        final CacheResult<String> result = new CacheResult<>();
        operate(result, () -> {
            stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS);
        });
        return result.isSuccess();
    }

    @Override
    public String get(final String key) {
        final CacheResult<String> result = new CacheResult<>();
        operate(result, ()->{
            String value = stringRedisTemplate.opsForValue().get(key);
            result.setValue(value);
        });
        if (!result.isSuccess()) {
            return null;
        }
        return result.getValue();
    }

    @Override
    public boolean expire(String key, long timeout) {
        final CacheResult<Boolean> result = new CacheResult<>();
        operate(result, () -> {
            Boolean res = stringRedisTemplate.expire(key, timeout, TimeUnit.MILLISECONDS);
            if (!res) {
                result.setValue(res);
            }
        });
        return result.isSuccess() && result.getValue();
    }

    @Override
    public boolean expire(String key,long timeout, TimeUnit timeUnit) {
        return false;
    }

    private void operate(CacheResult result, CacheCallback callback){
        try {
            callback.action();
            result.setSuccess(true);
        }catch (Throwable throwable) {
            LOGGER.error("cache operate failed.", throwable);
            result.setSuccess(false);
            result.setMessage(throwable.getMessage());
        }
    }
}
