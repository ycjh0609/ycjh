package com.ycjh.common.Interceptor;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CommonInterceptor extends HandlerInterceptorAdapter {

    Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestrUri = request.getRequestURI();
        String requestMehtod = request.getMethod();
        logger.info("=================================[COMMON LOGGER START]============================================");
        logger.info("RequestURI: "+requestrUri);
        logger.info("RequestMehtod: "+requestMehtod);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("=========================+=======[COMMON LOGGER END]===============+============================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {

    }
}
