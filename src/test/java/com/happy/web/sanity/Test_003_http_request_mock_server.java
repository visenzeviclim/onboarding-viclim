package com.happy.web.sanity;

import com.happy.service.IntroServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
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
public class Test_003_http_request_mock_server {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IntroServiceImpl introService;

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

    @Test
    public void test_003_Http_Request_MockServer_ConnectToIntroController() throws Exception{
        when(introService.greet()).thenReturn("Welcome Here !!!!");
        this.mockMvc.perform(get("/intro"))
                .andDo(print())
                .andExpect(
                        content().string(containsString("Welcome Here !!!!"))
                );
    }
}