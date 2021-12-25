package com.msb.dongbao.portal.web.interceptor;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.common.base.exceptions.TokenException;
import com.msb.dongbao.common.util.JWTUtils;
import com.msb.dongbao.ums.service.UmsMemberService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final String TOKEN = "token";

    @Autowired
    UmsMemberService umsMemberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Enter PreHandle");

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String subject = null;
        if (method.isAnnotationPresent(TokenCheck.class)) {
            TokenCheck check = method.getAnnotation(TokenCheck.class);
            if (!check.required()) {
                return true;
            }
            // token check required
            String token = request.getHeader(TOKEN);
            // if token is empty
            if (StringUtils.isBlank(token)) {
                throw new TokenException("Token is Empty");
            }
            try {
                subject = JWTUtils.parseToken(token);
            } catch (Exception e) {
                throw new TokenException("Token Error");
            }
        }

        /* renewed token */
        String renewedToken = JWTUtils.createToken(subject);
        response.addHeader("token", renewedToken);
        // No TokenCheck annotated => no check
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
