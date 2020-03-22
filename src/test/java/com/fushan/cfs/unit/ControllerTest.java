package com.fushan.cfs.unit;

import com.fushan.cfs.home.IndexController;
import com.fushan.cfs.repository.UserRepository;
import com.fushan.cfs.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by alps on 2020/1/14.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
@TestPropertySource({ "/application-test.properties"})
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService testService;

    @MockBean
    private StringRedisTemplate stringRedisTemplate;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PlatformTransactionManager platformTransactionManager;


    @Test
    public void normalHello() throws Exception {

        Mockito.doNothing().when(testService).testCache();

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello").contentType(
                MediaType.APPLICATION_JSON_UTF8)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
