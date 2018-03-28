package com.sankuai.spi;

import java.util.Comparator;

public class SpiComparator implements Comparator<SpiBase> {

    @Override
    public int compare(SpiBase spiBase1, SpiBase spiBase2) {
        return (spiBase2.config(null).getPriority() - spiBase1.config(null).getPriority());
    }
}
