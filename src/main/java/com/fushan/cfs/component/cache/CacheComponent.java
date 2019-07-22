package com.fushan.cfs.component.cache;

import java.util.concurrent.TimeUnit;

/**
 * Created by alps on 2019/1/16.
 */
public interface CacheComponent {

    boolean set(String key, String value);

    boolean set(String key, String value, long timeout);

    String get(String key);

    boolean expire(String key, long timeout);

    boolean expire(String key, long timeout, TimeUnit timeUnit);
}
