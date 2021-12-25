package com.msb.dongbao.common.util;

import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestMD5 {

    @Test
    public void testMD5() {
        String data = "hello world";
        String salt = "secret";
        String res1 = MD5Util.md5WithSalt(data, salt);
        String res2 = MD5Util.md5WithSalt(data + "1", salt);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(Objects.equals(res1, res2));
    }

}
