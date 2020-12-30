package com.happy.web.sanity;

import com.happy.service.IntroServiceImpl;
import com.happy.service.ProductServiceImpl;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by VicLim on 29/12/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_005_http_request_mockServer_Service {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IntroServiceImpl introService;

    @MockBean
    private ProductServiceImpl productService;

    @Test
    public void test_001_Http_Request_MockServer_introService() throws Exception{
        when(introService.greet()).thenReturn("Welcome Here !!!!");
        this.mockMvc.perform(get("/intro"))
                .andDo(print())
                .andExpect(
                        content().string(containsString("Welcome Here !!!!"))
                );
    }

    @Test
    public void test_002_Http_Request_MockServer_productService_CheckStatus() throws Exception{
        when(productService.getEggsQty()).thenReturn(12);
        this.mockMvc.perform(get("/store/haseggs"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_003_Http_Request_MockServer_productService_CheckResponse() throws Exception{
        when(productService.getEggsQty()).thenReturn(12);
        this.mockMvc.perform(get("/store/haseggs"))
                .andDo(print())
                .andExpect(jsonPath("$.eggs").value(12));
    }

    @Test
    public void test_004_Http_Request_MockServer_productService_CheckStatus() throws Exception{
        when(productService.getEggsQty()).thenReturn(12);
        this.mockMvc.perform(get("/store/hasmilk"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_005_Http_Request_MockServer_productService_CheckResponse() throws Exception{
        when(productService.getMilkQty()).thenReturn(12);
        this.mockMvc.perform(get("/store/hasmilk"))
                .andDo(print())
                .andExpect(jsonPath("$.milk").value(12));
    }

    @Test
    public void test_006_Http_Request_MockServer_productService_CheckStatus() throws Exception{
        this.mockMvc.perform(post("/store/buymilk")
                .param("quantity","12"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_007_Http_Request_MockServer_productService_CheckResponse() throws Exception{
        when(productService.buyMilk(12)).thenReturn(12);
        this.mockMvc.perform(post("/store/buymilk")
                .param("quantity","12"))
                .andDo(print())
                .andExpect(jsonPath("$.milk").value(12));
    }

    @Test
    public void test_008_Http_Request_MockServer_productService_CheckStatus() throws Exception{
        this.mockMvc.perform(post("/store/buyeggs")
                .param("quantity","12"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void test_009_Http_Request_MockServer_productService_CheckResponse() throws Exception{
        when(productService.buyEggs(12)).thenReturn(12);
        this.mockMvc.perform(post("/store/buyeggs")
                .param("quantity","12"))
                .andDo(print())
                .andExpect(jsonPath("$.milk").value(12));
    }
}