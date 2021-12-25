package com.msb.dongbao;

import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages = {"com.msb"})
@MapperScan("com.msb.dongbao.ums.mapper")
public class MsbDongbaoUmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsbDongbaoUmsApplication.class, args);
    }

//    @Autowired
//    UmsMemberMapper um;
//
//    @RequestMapping("/mapper")
//    @ResponseBody
//    public String test() {
//        System.out.println("test local");
//        return um.selectInteger();
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
