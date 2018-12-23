/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author fushan.cfs
 * @version $Id: WebMvcConfig.java, v 0.1 2018年11月05日 下午2:08 fushan.cfs Exp $
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource(name = "requestInterceptor")
    private HandlerInterceptor requestInterceptor;

    @Resource(name = "crosInterceptor")
    private HandlerInterceptor crosInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor);
        registry.addInterceptor(crosInterceptor);
    }
}