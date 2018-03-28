package com.sankuai.spi;

import com.sankuai.spi.annotation.BizSpi;

import java.util.List;

@BizSpi
public class InB implements QueryItem {
    @Override
    public boolean condition(InSDTO bizContext) {
        return true;
    }

    @Override
    public List<Void> invoke(InSDTO bizContext) {
        bizContext.setName("haha");
        return null;
    }

    @Override
    public SpiConfig config(InSDTO bizContext) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setName("Bconfig");
        spiConfig.setPriority(2);
        spiConfig.setMutex(false);
        return spiConfig;
    }
}
