package com.sankuai.spi.cartlist.domain;

import java.util.List;

/**
 * A group of item
 */
public class ItemGroup {

    List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
