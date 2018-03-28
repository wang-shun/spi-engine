package com.sankuai.spi;



import com.sankuai.spi.cartlist.CartListTemplateExecutor;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.SpiContext;
import com.sankuai.spi.cartlist.domain.QueryStrategyEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class CartListTest {

    @Autowired
    CartListTemplateExecutor cartListTemplateExecutor;

    @Test
    public void testQuryFromSourceA(){

        SpiContext spiContext = new SpiContext();
        spiContext.setQueryStrategy(QueryStrategyEnum.QueryFromSourceA.getName());

        CartListSDTO cartListSDTO = cartListTemplateExecutor.execute(spiContext);

        Assert.assertTrue(cartListSDTO.getItemList().size() == 50);

    }

    @Test
    public void testQuryFromSourceB(){

        SpiContext spiContext = new SpiContext();
        spiContext.setQueryStrategy(QueryStrategyEnum.QueryFromSourceB.getName());

        CartListSDTO cartListSDTO = cartListTemplateExecutor.execute(spiContext);

        Assert.assertTrue(cartListSDTO.getItemList().size() == 100);

    }

}
