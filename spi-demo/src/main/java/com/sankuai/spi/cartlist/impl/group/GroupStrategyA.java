package com.sankuai.spi.cartlist.impl.group;

import com.google.common.collect.Lists;
import com.sankuai.spi.SpiConfig;
import com.sankuai.spi.annotation.BizSpi;
import com.sankuai.spi.cartlist.CartListSDTO;
import com.sankuai.spi.cartlist.SpiContext;
import com.sankuai.spi.cartlist.domain.strategy.GroupStrategyEnum;
import com.sankuai.spi.cartlist.domain.Item;
import com.sankuai.spi.cartlist.domain.ItemGroup;
import com.sankuai.spi.cartlist.functionpoint.GroupStrategy;

import java.util.List;

/**
 * Group by stratey A, 5 items each group.
 */
@BizSpi
public class GroupStrategyA implements GroupStrategy{
    @Override
    public boolean condition(CartListSDTO cartListSDTO) {
        SpiContext spiContext = cartListSDTO.getSpiContext();
        return GroupStrategyEnum.GroupStrategyA.getName().equals(spiContext.getGroupStrategy());
    }

    @Override
    public List<Void> invoke(CartListSDTO cartListSDTO) {

        List<ItemGroup> itemGroupList = Lists.newArrayList();

        List<Item> itemList = cartListSDTO.getItemList();
        int GROUP_COUNT = 5;
        for (int start = 0;  start < itemList.size(); start = start + GROUP_COUNT) {
            int end = start + GROUP_COUNT;
            List<Item> itemsOfOneGroup = itemList.subList(start, end < itemList.size() ? end : itemList.size());
            ItemGroup itemGroup = new ItemGroup();
            itemGroup.setItemList(itemsOfOneGroup);

            itemGroupList.add(itemGroup);
        }

        cartListSDTO.setItemGroupList(itemGroupList);
        return null;
    }

    @Override
    public SpiConfig config(CartListSDTO cartListSDTO) {
        SpiConfig spiConfig = new SpiConfig();
        spiConfig.setPriority(5);
        spiConfig.setMutex(true);
        spiConfig.setName("groupStrategyA");
        return spiConfig;
    }
}
