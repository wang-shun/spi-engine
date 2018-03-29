package com.sankuai.spi.cartlist.domain.strategy;

public enum TagStrategyEnum {

    TagStrategyA("tagStrategyA", "tag1 + tag2 + tag3"),
    TagStrategyB("tagStrategyB", "tag2 + tag3"),
    ;

    TagStrategyEnum(String name, String desc) {
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
