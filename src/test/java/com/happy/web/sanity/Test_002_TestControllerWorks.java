package com.happy.web.sanity;

import com.happy.controller.HusbandController;
import com.happy.controller.IntroController;
import com.happy.controller.ProductController;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by VicLim on 29/12/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test_002_TestControllerWorks {

    @Autowired
    private IntroController introController;

    @Autowired
    private HusbandController husbandController;

    @Autowired
    private ProductController productController;

    @Test
    public void test_001_controller_intro(){
        assertThat(this.introController).isNotNull();
    }

    @Test
    public void test_002_controller_husband(){
        assertThat(this.husbandController).isNotNull();
    }

    @Test
    public void test_003_controller_productController(){
        assertThat(this.productController).isNotNull();
    }

}