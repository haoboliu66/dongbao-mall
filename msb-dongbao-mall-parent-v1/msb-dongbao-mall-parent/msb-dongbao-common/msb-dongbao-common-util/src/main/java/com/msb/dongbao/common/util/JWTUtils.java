package com.msb.dongbao.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    private static final String SECRET_KEY = "secret";
    /**
     * create a token based on a subject
     *
     * @param subject
     * @return
     */
    public static String createToken(String subject) {
        return Jwts.builder().setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * parse token, return subject
     *
     * @param token
     * @return
     */
    public static String parseToken(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        return body.getSubject();
    }

    public static void main(String[] args) {
        String token = createToken("abcde");
        String sub = parseToken(token + "xx");
        System.out.println(sub);
    }

}
