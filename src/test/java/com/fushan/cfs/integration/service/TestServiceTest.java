package com.fushan.cfs.integration.service;

import com.fushan.cfs.common.util.AssertUtil;
import com.fushan.cfs.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * unit test service
 * Created by alps on 2020/1/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource({ "/application-test.properties"})
public class TestServiceTest {
    @Autowired
    private TestService testService;

    @Test
    public void normalTestHandle(){
        boolean result = testService.testHandle();
        AssertUtil.isTrue(result);
    }
}
