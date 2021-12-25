package com.msb.dongbao.common.util;

import javax.swing.text.Caret;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class MD5Util {


    public static String md5(String data) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(data.getBytes(StandardCharsets.UTF_8));
            byte[] s = m.digest();
            StringBuilder encryptedData = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                encryptedData.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            return encryptedData.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String md5WithSalt(String data, String salt) {
        return md5(data + salt);
    }


}
