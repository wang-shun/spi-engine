package com.sankuai.spi.cartlist;

import com.google.common.collect.Lists;
import com.sankuai.spi.cartlist.domain.Item;
import com.sankuai.spi.cartlist.domain.ItemGroup;
import com.sankuai.spi.cartlist.domain.Tag;

import java.util.List;

/**
 * The model used during the whole spi flow.
 */
public class CartListSDTO {

    /**
     * spi context, for spi selection usage.
     */
    private SpiContext spiContext;

    /**
     * items
     */
    private List<Item> itemList = Lists.newArrayList();

    /**
     * groups
     */
    private List<ItemGroup> itemGroupList = Lists.newArrayList();

    /**
     * tags
     */
    private List<Tag> tagList = Lists.newArrayList();

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

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
