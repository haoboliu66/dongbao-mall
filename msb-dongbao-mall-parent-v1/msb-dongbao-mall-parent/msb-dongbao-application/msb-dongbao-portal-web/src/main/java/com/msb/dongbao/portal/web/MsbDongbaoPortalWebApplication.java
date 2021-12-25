package com.msb.dongbao.portal.web;

import com.msb.dongbao.portal.web.filter.SignAuthFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication(scanBasePackages = {"com.msb"})
@MapperScan("com.msb.dongbao.ums.mapper")
public class MsbDongbaoPortalWebApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(MsbDongbaoPortalWebApplication.class, args);
//        System.out.println(ac.getBeansOfType(Filter.class));
//        RedisTemplate b = ac.getBean("redisTemplate", RedisTemplate.class);
//        System.out.println(b);

    }
}
