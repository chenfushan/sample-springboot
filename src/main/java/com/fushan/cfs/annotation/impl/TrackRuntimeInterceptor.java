package com.fushan.cfs.annotation.impl;

import com.fushan.cfs.log.LogUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author fushan.cfs
 * @version $Id: TestInterceptor.java, v 0.1 2018年11月14日 1:08 AM fushan.cfs Exp $
 */
@Aspect
@Component
public class TrackRuntimeInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger("AOP-DIGEST-LOG");

    @Pointcut("@annotation(com.fushan.cfs.annotation.TrackRunTime)")
    public void annotationTrackRuntime(){}

    @Around("annotationTrackRuntime()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        LogUtil.infoLog(LOGGER, "=========================");
        return joinPoint.proceed();
    }

    @Before("annotationTrackRuntime()")
    public void before(){

    }

    @After("annotationTrackRuntime()")
    public void after(){

    }
}