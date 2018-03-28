package com.sankuai.spi.cartlist.impl.query;

import com.google.common.collect.Lists;
import com.sankuai.spi.SpiConfig;
import com.sankuai.spi.annotation.BizSpi;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.domain.Item;
import com.sankuai.spi.cartlist.SpiContext;
import com.sankuai.spi.cartlist.domain.QueryStrategyEnum;
import com.sankuai.spi.cartlist.spi.QueryItem;

import java.util.List;

@BizSpi
public class QueryItemFromSourceA implements QueryItem{
    @Override
    public boolean condition(CartListSDTO cartListSDTO) {
        SpiContext spiContext = cartListSDTO.getSpiContext();
        return QueryStrategyEnum.QueryFromSourceA.getName().equals(spiContext.getQueryStrategy());
    }

    @Override
    public List<Void> invoke(CartListSDTO cartListSDTO) {

        List<Item> itemList = query();
        cartListSDTO.setItemList(itemList);
        return null;
    }

    //query from soure A
    private List<Item> query() {
        List<Item> itemList = Lists.newArrayList();
        for (int i = 1; i <= 50; i++) {
            Item item = new Item();
            item.setName(i + " fromA");
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public SpiConfig config(CartListSDTO cartListSDTO) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setPriority(5);
        spiConfig.setMutex(true);
        spiConfig.setName("queryFromA");
        return spiConfig;
    }
}
