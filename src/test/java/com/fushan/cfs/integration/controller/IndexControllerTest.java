package com.fushan.cfs.integration.controller;

import com.fushan.cfs.component.cache.CacheComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by alps on 2020/1/20.
 */
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CacheComponent cacheComponent;

    @Test
    public void normalHello(){
        Mockito.when(cacheComponent.get(Mockito.anyString())).thenReturn("normal_test");

        try {
            MvcResult mvcResult = mockMvc.perform(
                    MockMvcRequestBuilders.get("/hello").contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andExpect(
                            MockMvcResultMatchers.status().isOk()).andReturn();
            System.out.println(mvcResult.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
