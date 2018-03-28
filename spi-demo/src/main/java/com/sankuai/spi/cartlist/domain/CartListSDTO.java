package com.sankuai.spi.cartlist.domain;

import java.util.List;

public class CartListSDTO {

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
}
