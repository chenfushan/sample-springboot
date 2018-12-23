/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.filter;

import com.fushan.cfs.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.UUID;

/**
 * @author fushan.cfs
 * @version $Id: RequestFilter.java, v 0.1 2018年11月05日 下午2:31 fushan.cfs Exp $
 */
@Order(1)
@WebFilter(urlPatterns = "/*", filterName = "requestFilter")
public class RequestFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger("FILTER-LOG");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        try {
            MDC.clear();
            MDC.put("LOG_CONTEXT", UUID.randomUUID().toString());
            //filter chain. filter for next filter
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            MDC.remove("LOG_CONTEXT");
        }
    }

    @Override
    public void destroy() {

    }

}