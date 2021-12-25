package com.msb.dongbao.portal.web.filter;


import com.alibaba.fastjson.JSONObject;
import com.msb.dongbao.common.base.ResultWrapper;
import com.msb.dongbao.common.base.StateCodeEnum;
import com.msb.dongbao.portal.web.util.BodyReaderHttpServletRequestWrapper;
import com.msb.dongbao.portal.web.util.CheckUtils;
import com.msb.dongbao.portal.web.util.HttpParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.SortedMap;

@Component
@Slf4j
public class SignAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        /* HttpServletRequestWrapper to clone InputStream
            or  StreamUtils.copyToByteArray(httpServletRequest.getInputStream());
        */

        SortedMap<String, Object> requestParamsMap = HttpParamUtil.getAllRequestParams(httpServletRequest);
        log.info("All Request Params in Sorted Map: " + requestParamsMap);

        if (CheckUtils.checkSign(requestParamsMap)) {
            log.info("Valid Request, Do Filter");
            chain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            ResultWrapper<Map<String, Object>> resultWrapper = ResultWrapper.getFailureBuilder()
                    .code(StateCodeEnum.INVALID_REQUEST.getCode())
                    .msg(StateCodeEnum.INVALID_REQUEST.getMsg())
                    .data(requestParamsMap)
                    .build();
            writer.write(JSONObject.toJSONString(resultWrapper));
        }

//        BufferedReader reader = new BufferedReader(new InputStreamReader(httpServletRequest.getInputStream()));
//        StringBuilder sb = new StringBuilder();
//        String line;
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        StringBuilder sb1 = new StringBuilder();
//        for (int i = 0; i < sb.length(); i++) {
//            if (sb.charAt(i) != '{' && sb.charAt(i) != ' ' && sb.charAt(i) != '}' && sb.charAt(i) != '"') {
//                sb1.append(sb.charAt(i));
//            }
//        }
//        Map<String, Object> bodyMap = new TreeMap<>();
//        String[] keyValuePairs = sb1.toString().split(",");
//        for (String pair : keyValuePairs) {
//            int index = pair.indexOf(":");
//            bodyMap.put(pair.substring(0, index), pair.substring(index + 1));
//        }
//        System.out.println("map from body: " + bodyMap);
//        String requestSign = (String) bodyMap.remove("sign");
//        String checkSign = CheckUtils.generateSign(bodyMap);
//        System.out.println(checkSign);
//        System.out.println(requestSign);
//        if (Objects.equals(checkSign, requestSign)) {
//            log.info("Valid Request, Do Filter");
//            chain.doFilter(httpServletRequest, httpServletResponse);
//        }else{
//            System.out.println("Oops");
//        }


//        if ("POST".equalsIgnoreCase((httpServletRequest.getMethod()))) {
//            String res = httpServletRequest.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//            System.out.println(res);
//            return;
//        }

        // get parameters from request, either url params or request body
//        SortedMap<String, Object> urlParamsMap = HttpParamUtil.getUrlParams(httpServletRequest);
//        log.info("paramsMap in Filter: " + urlParamsMap);
//        urlParamsMap.remove("sign");
//        String checkSign = CheckUtils.generateSign(urlParamsMap);
//        String requestSign = httpServletRequest.getParameter("sign");
//        if (Objects.equals(checkSign, requestSign)) {
//            log.info("Valid Request, Do Filter");
//            chain.doFilter(httpServletRequest, httpServletResponse);
//        } else {
//
//        }


    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Init Filter");
    }

    @Override
    public void destroy() {
        log.info("Destroy Filter");
    }
}
