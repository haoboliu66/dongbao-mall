package com.msb.dongbao.portal.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

//@Configuration
public class RedisConfiguration {


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(){
        return new RedisTemplate<Object, Object>();
    }

}
