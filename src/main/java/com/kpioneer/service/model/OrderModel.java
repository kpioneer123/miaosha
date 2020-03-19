package com.kpioneer.service.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by hzllb on 2018/11/18.
 */
//用户下单的交易模型
@Data
public class OrderModel {
    //2018102100012828
    private String id;

    //购买的用户id
    private Integer userId;

    //购买的商品id
    private Integer itemId;

    /**
     * 若非空，则表示是以秒杀商品方式下单
     */
    private Integer promoId;

    //购买商品的单价,若promoId非空，则表示秒杀商品价格
    private BigDecimal itemPrice;

    //购买数量
    private Integer amount;

    //购买金额,若promoId非空，则表示秒杀商品价格
    private BigDecimal orderPrice;

}
