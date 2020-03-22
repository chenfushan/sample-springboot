/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.service.impl;

import com.fushan.cfs.annotation.TrackRunTime;
import com.fushan.cfs.component.cache.CacheComponent;
import com.fushan.cfs.component.model.TransactionResult;
import com.fushan.cfs.entity.UserEntity;
import com.fushan.cfs.log.LogUtil;
import com.fushan.cfs.repository.UserRepository;
import com.fushan.cfs.service.TestService;
import com.fushan.cfs.service.template.TransactionHandleTemplate;
import com.fushan.cfs.service.template.TransactionTemplateCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author fushan.cfs
 * @version $Id: TestServiceImpl.java, v 0.1 2018年11月14日 1:21 AM fushan.cfs Exp $
 */
@Service("testService")
public class TestServiceImpl implements TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Resource
    private UserRepository userRepository;

    @Resource
    private TransactionHandleTemplate transactionHandleTemplate;

    @Resource
    private CacheComponent cacheComponent;

    @Override
    @TrackRunTime
    public void test() {
        LogUtil.infoLog(LOGGER, "this is call service");
    }

    @Override
    public boolean testBool() {
        return true;
    }

    @Override
    public boolean testHandle() {
        final TransactionResult result = new TransactionResult();
        transactionHandleTemplate.execute(result, new TransactionTemplateCallback() {
            @Override
            public void check() {

            }

            @Override
            public void doProcess() throws Exception {
                UserEntity userEntity = new UserEntity("chen", new Date());
                userRepository.save(userEntity);
            }

            @Override
            public void complete() {

            }
        });

        return true;
    }

    @Override
    public void testCache() {
//        cacheComponent.set("alps", "chenfushan");
        String v = cacheComponent.get("alps");
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("cache value:" + v);
        }
    }

    @Override
    public void testInsertCache() {
        cacheComponent.set("alps", "chenfushan", 2000);
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("set cache key: alps. value:chenfusha");
        }
    }
}