package com.sankuai.spi;



import com.sankuai.spi.cartlist.CartListTemplateExecutor;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.SpiContext;
import com.sankuai.spi.cartlist.domain.strategy.GroupStrategyEnum;
import com.sankuai.spi.cartlist.domain.strategy.QueryStrategyEnum;
import com.sankuai.spi.cartlist.domain.strategy.TagStrategyEnum;
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
    public void testQuryFromSourceA_groupByStrategyA_tagStrategyA(){

        SpiContext spiContext = new SpiContext();
        spiContext.setQueryStrategy(QueryStrategyEnum.QueryFromSourceA.getName());
        spiContext.setGroupStrategy(GroupStrategyEnum.GroupStrategyA.getName());
        spiContext.setTagStrategy(TagStrategyEnum.TagStrategyA.getName());

        CartListSDTO cartListSDTO = cartListTemplateExecutor.execute(spiContext);

        Assert.assertTrue(cartListSDTO.getItemList().size() == 50);
        Assert.assertTrue(cartListSDTO.getItemGroupList().size() == 50 / 5);
        Assert.assertTrue(cartListSDTO.getTagList().size() == 3);
    }

    @Test
    public void testQuryFromSourceB_groupByStrategyB_tagStrategyB(){

        SpiContext spiContext = new SpiContext();
        spiContext.setQueryStrategy(QueryStrategyEnum.QueryFromSourceB.getName());
        spiContext.setGroupStrategy(GroupStrategyEnum.GroupStrategyB.getName());
        spiContext.setTagStrategy(TagStrategyEnum.TagStrategyB.getName());


        CartListSDTO cartListSDTO = cartListTemplateExecutor.execute(spiContext);

        Assert.assertTrue(cartListSDTO.getItemList().size() == 100);
        Assert.assertTrue(cartListSDTO.getItemGroupList().size() == 100 / 10);
        Assert.assertTrue(cartListSDTO.getTagList().size() == 2);


    }

}
