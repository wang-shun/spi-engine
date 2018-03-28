package com.sankuai.spi;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-config.xml")
public class SpiTest {

    @Resource(name = "query")
    QueryItem queryItem;


    @Test
    public void test111(){
        System.out.println();

        InSDTO sdto =new InSDTO();
        sdto.setName("1");
        queryItem.invoke(sdto);
    }
}
