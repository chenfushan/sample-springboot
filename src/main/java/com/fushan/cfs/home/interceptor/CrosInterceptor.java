/**
 * Alps Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.home.interceptor;

import com.fushan.cfs.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fushan.cfs
 * @version $Id: CrosInterceptor.java, v 0.1 2018年11月06日 下午9:09 fushan.cfs Exp $
 */
@Component("crosInterceptor")
public class CrosInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger("FILTER-LOG");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LogUtil.infoLog(LOGGER, "start cros interceptor.");
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
}