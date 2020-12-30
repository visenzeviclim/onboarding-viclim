package com.happy.web.sanity;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by VicLim on 29/12/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_004_http_request_mockServer_Controller {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_001_Http_Request_MockServer_ConnectToIntroController() throws Exception{
        this.mockMvc.perform(get("/intro"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_002_Http_Request_MockServer_ConnectToIntroController() throws Exception{
        this.mockMvc.perform(get("/intro"))
                .andDo(print())
                .andExpect(
                        content().string(containsString("Welcome Here !!!!"))
                );
    }
}