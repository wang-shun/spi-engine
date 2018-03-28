package com.sankuai.spi.cartlist.domain;

public enum QueryStrategyEnum {
    QueryFromSourceA("queryFromSourceA"),
    QueryFromSourceB("queryFromSourceB"),;


    QueryStrategyEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
