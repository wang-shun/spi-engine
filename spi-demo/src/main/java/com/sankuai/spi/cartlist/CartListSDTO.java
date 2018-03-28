package com.sankuai.spi.cartlist;

import com.sankuai.spi.cartlist.domain.Item;
import com.sankuai.spi.cartlist.domain.ItemGroup;

import java.util.List;

public class CartListSDTO {

    private SpiContext spiContext;

    private List<Item> itemList;

    private List<ItemGroup> itemGroupList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public void setItemGroupList(List<ItemGroup> itemGroupList) {
        this.itemGroupList = itemGroupList;
    }

    public SpiContext getSpiContext() {
        return spiContext;
    }

    public void setSpiContext(SpiContext spiContext) {
        this.spiContext = spiContext;
    }
}
