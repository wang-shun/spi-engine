package com.sankuai.spi.cartlist;

/**
 * An spi implementation selector.
 */
public class SpiContext {

    private String queryStrategy;

    private String groupStrategy;

    private String tagStrategy;

    public String getQueryStrategy() {
        return queryStrategy;
    }

    public void setQueryStrategy(String queryStrategy) {
        this.queryStrategy = queryStrategy;
    }

    public String getGroupStrategy() {
        return groupStrategy;
    }

    public void setGroupStrategy(String groupStrategy) {
        this.groupStrategy = groupStrategy;
    }

    public String getTagStrategy() {
        return tagStrategy;
    }

    public void setTagStrategy(String tagStrategy) {
        this.tagStrategy = tagStrategy;
    }
}
