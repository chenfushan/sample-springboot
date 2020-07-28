/**
 * Alps Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.interceptor;

import com.fushan.cfs.log.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author fushan.cfs
 * @version $Id: ServiceInterceptor.java, v 0.1 2018年11月23日 5:53 PM fushan.cfs Exp $
 */
@Aspect
@Component
public class ServiceInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger("SERVICE-DIGEST-LOG");

    @Around("execution(* com.fushan.cfs.service.*Service.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        LogUtil.infoLog(LOGGER, "start service execution.");
        return point.proceed();
    }
}