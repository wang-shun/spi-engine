package com.sankuai.spi.schema;

public class AbstractSpiDefintion {

    protected String id;

    protected String target;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
