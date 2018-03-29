package com.sankuai.spi.cartlist;

import com.sankuai.spi.cartlist.functionpoint.GroupStrategy;
import com.sankuai.spi.cartlist.functionpoint.QueryItem;
import com.sankuai.spi.cartlist.functionpoint.TagStrategy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * A cart list template executor which has threee spi points, QueryItem, GroupStrategy and TagStrategy.
 *
 * QueryItem: Query some items from an specific source depending on the selector parameter from SpiContext, impls are executed exclusively.
 * @see com.sankuai.spi.cartlist.domain.strategy.QueryStrategyEnum
 *
 * GroupStrategy: Split the items into couple of groups depending on the selector parameter from SpiContext, impls are executed exclusively.
 * @see com.sankuai.spi.cartlist.domain.strategy.GroupStrategyEnum
 *
 * TagStrategy: Adding some extra tag information to cart list result, impls are inclusively executed, one or more can be executed.
 * @see com.sankuai.spi.cartlist.domain.strategy.TagStrategyEnum
 */
@Component
public class CartListTemplateExecutor {

    @Resource(name = "queryItem")
    private QueryItem queryItem;

    @Resource(name = "group")
    private GroupStrategy groupStrategy;

    @Resource(name = "tag")
    private TagStrategy tagStrategy;


    public CartListSDTO execute(SpiContext spiContext) {

        //1.init
        CartListSDTO cartListSDTO = new CartListSDTO();
        cartListSDTO.setSpiContext(spiContext);

        //2.query
        query(cartListSDTO);

        //3.group
        group(cartListSDTO);

        //4.tag
        tag(cartListSDTO);

        //5.return
        return cartListSDTO;

    }

    private void query(CartListSDTO cartListSDTO) {
        queryItem.invoke(cartListSDTO);
    }

    private void group(CartListSDTO cartListSDTO) {
        groupStrategy.invoke(cartListSDTO);
    }

    private void tag(CartListSDTO cartListSDTO) {
        tagStrategy.invoke(cartListSDTO);
    }
}
