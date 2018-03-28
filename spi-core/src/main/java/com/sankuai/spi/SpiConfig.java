package com.sankuai.spi;

public class SpiConfig {
    private boolean mutex;

    private int priority;

    private String name;

    public SpiConfig() {
        mutex = true;
        priority = 0;
        name = null;
    }

    public SpiConfig(boolean mutex, int priority) {
        this.mutex = mutex;
        this.priority = priority;
        this.name = null;
    }

    public SpiConfig(boolean mutex, int priority, String name) {
        this.mutex = mutex;
        this.priority = priority;
        this.name = name;
    }

    public boolean isMutex() {
        return mutex;
    }

    public void setMutex(boolean mutex) {
        this.mutex = mutex;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
