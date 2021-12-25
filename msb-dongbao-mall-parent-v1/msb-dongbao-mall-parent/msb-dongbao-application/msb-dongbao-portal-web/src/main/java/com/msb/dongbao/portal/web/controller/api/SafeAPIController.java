package com.msb.dongbao.portal.web.controller.api;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.msb.dongbao.portal.web.util.CheckUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequestMapping("/api-safe")
public class SafeAPIController {

    @GetMapping("/hello")
    public String safeData() {
        return "hello-safe-api";
    }

    @Resource
    private RedisTemplate<String, String> redisTemplate;


    @RequestMapping("/get-test")
    public String getTest(HttpServletRequest httpServletRequest) {
        System.out.println("Enter Get-test");

        return "get-test done";
    }

    @PostMapping("/post-test")
    public String postTest(@RequestBody SignDTO signDTO) {
        System.out.println("Enter Post-test");

        return "post-test done";

    }


}

