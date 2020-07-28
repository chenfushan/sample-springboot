/**
 * Alps Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fushan.cfs.home;

import com.fushan.cfs.annotation.TrackRunTime;
import com.fushan.cfs.entity.UserEntity;
import com.fushan.cfs.log.LogUtil;
import com.fushan.cfs.repository.UserRepository;
import com.fushan.cfs.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author fushan.cfs
 * @version $Id: IndexController.java, v 0.1 2018年10月18日 下午12:13 fushan.cfs Exp $
 */
@RestController
public class IndexController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Value("${app.name}")
    private String name;

    @Value("${run.mode}")
    private String mode;

    @Resource
    private UserRepository userRepository;

    @Resource
    private TestService testService;

    @Resource(name = "sampleExecutor")
    private ThreadPoolTaskExecutor sampleExecutor;

    /**
     * controller
     * @param request request
     * @param response response
     * @return res
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(HttpServletRequest request, HttpServletResponse response) {
        testService.testCache();
        LogUtil.infoLog(LOGGER, "receive request, app-name:" + name);
        LOGGER.error("test error log");
        return mode;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @TrackRunTime
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return "hello";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public UserEntity queryUsers(HttpServletRequest request, HttpServletResponse response) {
        UserEntity userEntity = userRepository.findUserEntityById(1);
        List<UserEntity> userEntityList = userRepository.findUserEntitiesByUserName("alps");
        return userEntityList.get(0);
    }

    @RequestMapping(value = "/thread", method = RequestMethod.GET)
    public String thread(HttpServletRequest request, HttpServletResponse response) {
        sampleExecutor.submit(() -> {
            System.out.println("good");
        });
        return "run";
    }
}