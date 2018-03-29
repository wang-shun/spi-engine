package com.sankuai.spi.cartlist.domain.strategy;

/**
 * Defines the query source.
 */
public enum QueryStrategyEnum {

    QueryFromSourceA("queryFromSourceA", "return 50 items"),
    QueryFromSourceB("queryFromSourceB", "return 100 items"),
    ;


    QueryStrategyEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    private String name;

    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
