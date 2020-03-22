package com.fushan.cfs;

import com.fushan.cfs.component.cache.CacheComponent;
import com.fushan.cfs.service.TestService;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by alps on 2018/12/10.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource({"/application-test.properties"})
public class ApplicationTest {

    @Autowired
    private TestService testService;

    @Value("${run.mode}")
    private String mode;

    @Value("${app.name}")
    private String name;

    @MockBean
    private CacheComponent cacheComponent;

    @Before
    public void before(){

    }

    @After
    public void after(){

    }

    @Test
    public void test(){
        System.out.println(mode + ", " + name);
        Mockito.when(cacheComponent.get(Mockito.anyString())).thenReturn("cache success.");
        testService.testCache();
        Assertions.assertThat("").isEqualTo("");
    }

    @Test
    public void testInsertCache(){
        testService.testInsertCache();
        Mockito.verify(cacheComponent).set("alps", "chenfushan", 2000);
    }

}
