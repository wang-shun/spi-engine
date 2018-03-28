package com.sankuai.spi.cartlist;

import com.sankuai.spi.cartlist.spi.GroupStrategy;
import com.sankuai.spi.cartlist.spi.QueryItem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 */
@Component
public class CartListTemplateExecutor {

    @Resource(name = "queryItem")
    private QueryItem queryItem;

    @Resource(name = "group")
    private GroupStrategy groupStrategy;




}
