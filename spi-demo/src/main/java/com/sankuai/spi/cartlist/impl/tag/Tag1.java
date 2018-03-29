package com.sankuai.spi.cartlist.impl.tag;

import com.google.common.collect.Lists;
import com.sankuai.spi.SpiConfig;
import com.sankuai.spi.annotation.BizSpi;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.SpiContext;
import com.sankuai.spi.cartlist.domain.Tag;
import com.sankuai.spi.cartlist.domain.strategy.TagStrategyEnum;
import com.sankuai.spi.cartlist.functionpoint.TagStrategy;

import java.util.List;

@BizSpi
public class Tag1 implements TagStrategy {
    @Override
    public boolean condition(CartListSDTO cartListSDTO) {
        SpiContext spiContext = cartListSDTO.getSpiContext();
        return TagStrategyEnum.TagStrategyA.getName().equals(spiContext.getTagStrategy());
    }

    @Override
    public List<Void> invoke(CartListSDTO cartListSDTO) {
        Tag tag1 = new Tag("tag1");
        cartListSDTO.getTagList().add(tag1);

        return null;
    }

    @Override
    public SpiConfig config(CartListSDTO cartListSDTO) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setPriority(5);
        spiConfig.setMutex(false);
        spiConfig.setName("tag1");
        return spiConfig;
    }
}
