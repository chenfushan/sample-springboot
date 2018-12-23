/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.log;

import org.slf4j.Logger;

/**
 * slf4j log util
 * @author fushan.cfs
 * @version $Id: LogUtil.java, v 0.1 2018年10月26日 下午2:23 fushan.cfs Exp $
 */
public class LogUtil {
    /**
     * write log
     * @param logger slf4j log
     * @param message log message
     */
    public static void infoLog(Logger logger, Object message) {
        if (logger.isInfoEnabled()) {
            logger.info(message.toString());
        }
    }
}