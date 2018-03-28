package com.sankuai.spi;

import com.sankuai.spi.annotation.BizSpi;

import java.util.List;

@BizSpi
public class InA implements QueryItem {

    @Override
    public boolean condition(InSDTO bizContext) {
        return true;
    }

    @Override
    public List<Void> invoke(InSDTO bizContext) {
        System.out.println(bizContext.getName());

        return null;
    }

    @Override
    public SpiConfig config(InSDTO bizContext) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setName("Aconfig");
        spiConfig.setPriority(1);
        spiConfig.setMutex(false);
        return spiConfig;
    }
}
