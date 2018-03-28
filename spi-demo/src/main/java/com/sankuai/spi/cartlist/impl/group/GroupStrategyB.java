package com.sankuai.spi.cartlist.impl.group;

import com.sankuai.spi.SpiConfig;
import com.sankuai.spi.annotation.BizSpi;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.functionpoint.GroupStrategy;

import java.util.List;

@BizSpi
public class GroupStrategyB implements GroupStrategy{
    @Override
    public boolean condition(CartListSDTO cartListSDTO) {
        return false;
    }

    @Override
    public List<Void> invoke(CartListSDTO cartListSDTO) {
        return null;
    }

    @Override
    public SpiConfig config(CartListSDTO cartListSDTO) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setPriority(5);
        spiConfig.setMutex(true);
        spiConfig.setName("groupStrategyB");
        return spiConfig;
    }
}
