package com.kpioneer.service;


import com.kpioneer.error.BusinessException;
import com.kpioneer.service.model.ItemModel;

import java.util.List;

/**
 * Created by hzllb on 2018/11/18.
 */
public interface ItemService {

    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表浏览
    List<ItemModel> getItemList();

    //商品详情浏览
    ItemModel getItemById(Integer id);

    //库存扣减
    boolean decreaseStock(Integer itemId, Integer amount)throws BusinessException;

    //商品销量增加
    void increaseSales(Integer itemId, Integer amount)throws BusinessException;

}
