package com.shiyu.weather.service;

public interface RedisService {
     void set(String key, String value, long seconds);
     Object get(String key);
}
