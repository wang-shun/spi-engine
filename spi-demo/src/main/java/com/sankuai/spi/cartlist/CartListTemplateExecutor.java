package com.sankuai.spi.cartlist;

import com.sankuai.spi.cartlist.spi.GroupStrategy;
import com.sankuai.spi.cartlist.spi.QueryItem;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * cartlist executor
 */
@Component
public class CartListTemplateExecutor {

    @Resource(name = "queryItem")
    private QueryItem queryItem;

    @Resource(name = "group")
    private GroupStrategy groupStrategy;


    public CartListSDTO execute(SpiContext spiContext) {

        //1.init
        CartListSDTO cartListSDTO = new CartListSDTO();
        cartListSDTO.setSpiContext(spiContext);

        //2.query
        query(cartListSDTO);

        //3.group
        group(cartListSDTO);

        //4.return
        return cartListSDTO;

    }

    private void query(CartListSDTO cartListSDTO) {
        queryItem.invoke(cartListSDTO);
    }

    private void group(CartListSDTO cartListSDTO) {
        groupStrategy.invoke(cartListSDTO);
    }

}
