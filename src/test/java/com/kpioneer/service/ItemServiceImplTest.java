package com.kpioneer.service;


import com.alibaba.fastjson.JSON;
import com.kpioneer.dao.ItemDOMapper;
import com.kpioneer.dao.ItemStockDOMapper;
import com.kpioneer.dataobject.ItemDO;
import com.kpioneer.service.cahce.CacheService;
import com.kpioneer.service.model.ItemModel;
import com.kpioneer.validator.ValidatorImpl;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by hzllb on 2018/11/18.
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ItemServiceImplTest {

    @Autowired
    private ValidatorImpl validator;

    @Resource
    private ItemDOMapper itemDOMapper;

//    @Autowired
//    private PromoService promoService;

    @Autowired
    private ItemStockDOMapper itemStockDOMapper;



    @Test
    public void insertItemDO() {
        ItemDO itemDO = new ItemDO();
        itemDO.setPrice(BigDecimal.valueOf(1000));
        itemDO.setImgUrl("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2100564653,556970053&fm=11&gp=0.jpg");
        itemDO.setDescription("苹果好好好");
        itemDO.setSales(1000);
        itemDO.setTitle("苹果");
        itemDOMapper.insertSelective(itemDO);
    }


    @Test
    public void list() {
        List<ItemDO> itemDOList = itemDOMapper.getItemList();

        System.out.println(JSON.toJSONString(itemDOList));

    }

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private CacheService cacheService;
    @Autowired
    private ItemService itemService;
    @Test
    public void setCache() {
        int id =6;
//        ItemModel itemModel = itemService.getItemById(id);
//
//        redisTemplate.opsForValue().set("item_" + id, itemModel, 10, TimeUnit.MINUTES);

        ItemModel itemModel = (ItemModel) redisTemplate.opsForValue().get("item_" + id);

        System.out.println(JSON.toJSONString(itemModel));
    }

}
