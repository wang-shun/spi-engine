package com.sankuai.spi.cartlist.impl.tag;

import com.sankuai.spi.SpiConfig;
import com.sankuai.spi.annotation.BizSpi;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.SpiContext;
import com.sankuai.spi.cartlist.domain.Tag;
import com.sankuai.spi.cartlist.domain.strategy.TagStrategyEnum;
import com.sankuai.spi.cartlist.functionpoint.TagStrategy;

import java.util.List;

@BizSpi
public class Tag2 implements TagStrategy {
    @Override
    public boolean condition(CartListSDTO cartListSDTO) {
        SpiContext spiContext = cartListSDTO.getSpiContext();
        return TagStrategyEnum.TagStrategyA.getName().equals(spiContext.getTagStrategy()) || TagStrategyEnum.TagStrategyB.getName().equals(spiContext.getTagStrategy());
    }

    @Override
    public List<Void> invoke(CartListSDTO cartListSDTO) {
        Tag tag2 = new Tag("tag2");
        cartListSDTO.getTagList().add(tag2);
        return null;
    }

    @Override
    public SpiConfig config(CartListSDTO cartListSDTO) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setPriority(3);
        spiConfig.setMutex(false);
        spiConfig.setName("tag2");
        return spiConfig;
    }
}