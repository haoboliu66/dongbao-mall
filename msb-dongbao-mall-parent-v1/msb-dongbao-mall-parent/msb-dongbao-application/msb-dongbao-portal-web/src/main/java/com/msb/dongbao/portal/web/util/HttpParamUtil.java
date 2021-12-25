package com.msb.dongbao.portal.web.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

@Slf4j
public class HttpParamUtil {

    /**
     * get all parameters from the request, both url and body
     *
     * @param httpServletRequest
     * @return
     * @throws IOException
     */
    public static SortedMap<String, Object> getAllRequestParams(HttpServletRequest httpServletRequest) throws IOException {
        log.info("Getting All Request Params");
        Map<String, Object> urlParams = getUrlParams(httpServletRequest);

        Map<String, String> bodyParams = getBodyParams(httpServletRequest);

        SortedMap<String, Object> sortedParamsMap = new TreeMap<>(urlParams);
        for (Map.Entry<String, String> e : bodyParams.entrySet()) {
            sortedParamsMap.put(e.getKey(), e.getValue());
        }
        log.info("Sorted All Request Parameters in Map: " + sortedParamsMap);
        return sortedParamsMap;
    }

    private static Map<String, Object> getUrlParams(HttpServletRequest httpServletRequest) {
        String queryParam = "";
        try {
            if (StringUtils.isBlank(httpServletRequest.getQueryString())) {
                log.info("Request Query String: " + httpServletRequest.getQueryString());
                queryParam = URLDecoder.decode(httpServletRequest.getQueryString(), "utf-8");
                log.info("Decoded Request Query String: " + queryParam);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String, Object> paramsMap = new HashMap<>();
        String[] params = queryParam.split("&");
        if (params.length == 0) {
            return paramsMap;
        }
        log.info("Request URL Params in Array: " + Arrays.toString(params));
        for (String s : params) {
            int index = s.indexOf("=");
            if (index < 0) {
                continue;
            }
            paramsMap.put(s.substring(0, index), s.substring(index + 1));
        }

        log.info("Request URL paramsMap: " + paramsMap);
        return paramsMap;
    }

    private static Map<String, String> getBodyParams(HttpServletRequest httpServletRequest) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        log.info("Request Body String: " + sb);
        Map bodyMap = JSONObject.parseObject(sb.toString(), Map.class);
        log.info("Request Body ParamsMap: " + bodyMap);
        return bodyMap;
    }


}
