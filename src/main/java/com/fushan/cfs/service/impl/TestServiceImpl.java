/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.service.impl;

import com.fushan.cfs.annotation.TrackRunTime;
import com.fushan.cfs.log.LogUtil;
import com.fushan.cfs.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author fushan.cfs
 * @version $Id: TestServiceImpl.java, v 0.1 2018年11月14日 1:21 AM fushan.cfs Exp $
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    @TrackRunTime
    public void test() {
        LogUtil.infoLog(LOGGER, "this is call service");
    }

    @Override
    public boolean testBool() {
        return true;
    }
}