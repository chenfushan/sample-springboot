package com.fushan.cfs;

import com.fushan.cfs.service.TestService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by alps on 2018/12/10.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {

    @Autowired
    private TestService testService;

    @Before
    public void before(){

    }

    @After
    public void after(){

    }

    @Test
    public void test(){
        Assert.assertEquals(true, testService.testBool());
    }
}
