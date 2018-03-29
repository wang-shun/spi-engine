package com.sankuai.spi.cartlist.domain.strategy;


public enum  GroupStrategyEnum {
    GroupStrategyA("strategyA", "5 items each group"),
    GroupStrategyB("strategyB", "10 items each group"),
    ;

    GroupStrategyEnum(String name, String desc) {
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
