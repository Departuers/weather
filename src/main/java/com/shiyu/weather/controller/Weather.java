package com.shiyu.weather.controller;

import com.shiyu.weather.service.RedisService;
import com.shiyu.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api")
public class Weather {

    private static final String citykeyurl = "http://wthrcdn.etouch.cn/weather_mini?citykey=";
    private static final String cityurl = "http://wthrcdn.etouch.cn/weather_mini?city=";

    @Autowired
    RedisService redisService;

    @Autowired
    WeatherService weatherService;

    @GetMapping("/cityid/{cityid}")
    public Mono<String> getweather(@PathVariable String cityid) {
        return Mono.just(weatherService.getweather(cityid, citykeyurl));
    }

    @GetMapping("/city/{city}")
    public Mono<String> cityweather(@PathVariable String city) {
        return Mono.just(weatherService.getweather(city, cityurl));
    }

    @GetMapping("/city")
    public Mono<String> cityweatherby(String city) {
        if (city==null||"".equals(city))
            return Mono.just("bad request");
        return Mono.just(weatherService.getweather(city, cityurl));
    }
}
