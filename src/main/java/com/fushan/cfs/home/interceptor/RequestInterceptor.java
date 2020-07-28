/**
 * Alps Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.home.interceptor;

import com.fushan.cfs.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求拦截器
 * 1. 增加MDC日志
 * @author fushan.cfs
 * @version $Id: RequestInterceptor.java, v 0.1 2018年11月04日 下午10:51 fushan.cfs Exp $
 */
@Component("requestInterceptor")
@PropertySource(value = "classpath:config/interceptor/interceptor.properties")
@ConfigurationProperties(prefix = "request.interceptor")
public class RequestInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger("FILTER-LOG");

    private List<String> urlWhiteList = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LogUtil.infoLog(LOGGER, "white list is:" + urlWhiteList);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView)
            throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex)
            throws Exception {

    }

    /**
     * Setter method for property <tt>urlWhiteList</tt>.
     *
     * @param urlWhiteList value to be assigned to property urlWhiteList
     */
    public void setUrlWhiteList(List<String> urlWhiteList) {
        this.urlWhiteList = urlWhiteList;
    }
}