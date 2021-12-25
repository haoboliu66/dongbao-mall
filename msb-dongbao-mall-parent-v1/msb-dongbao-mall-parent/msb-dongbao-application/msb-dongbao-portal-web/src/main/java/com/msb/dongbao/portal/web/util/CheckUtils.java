package com.msb.dongbao.portal.web.util;

import com.msb.dongbao.common.util.MD5Util;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * check validity of request params with a unique secret key
 */
@Slf4j
public class CheckUtils {


    private static final String APP_SECRET = "SECRET_KEY";  // should be retrieved from db

    public static final long EXPIRATION_TIME = 1000 * 30;

    public static String generateSign(Map<String, Object> paramMap) {
        // 自定义参数组装格式
        paramMap.remove("sign");
        log.info("paramMap After Removing sign: " + paramMap);
        Set<Map.Entry<String, Object>> entries = paramMap.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : entries) {
            sb.append(entry.getKey()).append(entry.getValue()).append("#");
        }
        // 组装上secret
        sb.append("secret").append(APP_SECRET);

        // 根据参数和app secret, 生成sign进行校验
        return MD5Util.md5(sb.toString());
    }

    public static boolean checkSign(Map<String, Object> paramMap) {
        String timestamp = (String) paramMap.get("timestamp");
        try {
            long time = System.currentTimeMillis() - Long.parseLong(timestamp);
            if (time > EXPIRATION_TIME) {
                log.warn("API expired");
                return false;
            }
        } catch (NumberFormatException e) {
            log.error("timestamp cannot be converted to Long ");
            throw new NumberFormatException("timestamp cannot be converted to Long");
        }

        return Objects.equals(paramMap.get("sign"), generateSign(paramMap));
    }


    public static boolean checkParam(HttpServletRequest httpServletRequest, String sign) {
        Map<String, Object> paramMap = new TreeMap<>();
        Enumeration<String> parameterNames = httpServletRequest.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String paramValue = httpServletRequest.getParameter(paramName);
            paramMap.put(paramName, paramValue);
            // check validity of request timestamp
            if ("timestamp".equalsIgnoreCase(paramName)) {
                try {
                    long time = System.currentTimeMillis() - Long.parseLong(paramValue);
                    if (time > EXPIRATION_TIME) {
                        log.warn("API expired");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    log.error("timestamp cannot be converted to Long ");
                    throw new NumberFormatException("timestamp cannot be converted to Long");
                }
            }
        }
        log.info("sortedParamMap: " + paramMap);
        return Objects.equals(generateSign(paramMap), sign);
    }

    // for postman test
    public static void main(String[] args) {
        SortedMap<String, Object> sortedMap = new TreeMap<>();
        sortedMap.put("appId", 1);
        sortedMap.put("name", 2);
//        sortedMap.put("Key", "f9b8d141030648baa8ff3e59d2f27a84");
        long ts = System.currentTimeMillis();
        System.out.println(ts);
        sortedMap.put("timestamp", ts);

        String sign = generateSign(sortedMap);
        // c05425539d1a832a817a5d759ea4ec7b
        System.out.println(sign);

    }
}