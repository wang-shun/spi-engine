package com.sankuai.spi;



import com.sankuai.spi.cartlist.CartListTemplateExecutor;
import com.sankuai.spi.cartlist.spi.QueryItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class SpiTest {

    @Autowired
    CartListTemplateExecutor cartListTemplateExecutor;

    @Test
    public void test111(){

    }
}
