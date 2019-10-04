package com.shiyu.weather.service.impl;

import cn.hutool.http.HttpUtil;
import com.shiyu.weather.service.RedisService;
import com.shiyu.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl implements WeatherService {
    @Autowired
    RedisService redisService;
    @Override
    public String getweather(String city, String url) {

        if (redisService.get(city)== null) {
            String json = HttpUtil.get(url + city);
            if (json.endsWith("\"no data\"}")||json.endsWith("\"invilad-citykey\"}")) {
            return "查无此项";
            }
            redisService.set(city,json,2);
            return json;
        }
        return redisService.get(city).toString();
    }
}
