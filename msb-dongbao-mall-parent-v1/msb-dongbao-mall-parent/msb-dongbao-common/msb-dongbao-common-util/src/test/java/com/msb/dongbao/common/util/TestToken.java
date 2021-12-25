package com.msb.dongbao.common.util;

import org.junit.jupiter.api.Test;

public class TestToken {

    @Test
    public void testToken(){

        String subject = "hello";
        String token = JWTUtils.createToken(subject);
        System.out.println("token: " + token);

        String sub = JWTUtils.parseToken(token);
        System.out.println("subject: " + sub);

    }




}
