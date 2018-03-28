package com.sankuai.spi;

import java.util.List;

public interface SpiBase<T, R> {
    /**
     * 是否执行当前实现的条件
     *
     * @return
     */
    boolean condition(T bizContext);

    /**
     * 具体操作
     *
     * @param bizContext
     * @return
     */
    List<R> invoke(T bizContext);

    /**
     * functionpoint 执行时的配置
     *
     * @return
     */
    SpiConfig config(T bizContext);
}
