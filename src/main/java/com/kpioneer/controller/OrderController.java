package com.kpioneer.controller;


import com.kpioneer.error.BusinessException;
import com.kpioneer.error.EmBusinessError;
import com.kpioneer.response.CommonReturnType;
import com.kpioneer.service.OrderService;
import com.kpioneer.service.model.OrderModel;
import com.kpioneer.service.model.UserModel;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzllb on 2018/11/18.
 */
@Controller("order")
@RequestMapping("/order")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")

public class OrderController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private RedisTemplate redisTemplate;

    //封装下单请求
    @RequestMapping(value = "/createorder", method = {RequestMethod.POST}, consumes = {CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType createOrder(@RequestParam(name = "itemId") Integer itemId,
                                        @RequestParam(name = "amount") Integer amount,
                                        @RequestParam(name = "promoId", required = false) Integer promoId) throws BusinessException {


        // LOG.error("createorder session id={}",httpServletRequest.getSession().getId());
        // Boolean isLogin = (Boolean) httpServletRequest.getSession().getAttribute("IS_LOGIN");
//        if (isLogin == null || !isLogin.booleanValue()) {
//            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN, "用户还未登陆，不能下单");
//        }
//
        String[] tokenArray = httpServletRequest.getParameterMap().get("token");
        if (ArrayUtils.isEmpty(tokenArray) || StringUtils.isEmpty(tokenArray[0])||tokenArray[0].equals("null")) {
            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN, "用户还未登陆，不能下单");
        }

        //获取用户的登陆信息
        //UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute("LOGIN_USER");
        UserModel userModel = (UserModel) redisTemplate.opsForValue().get(tokenArray[0]);

        if(userModel == null){
            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN,"用户还未登陆，不能下单");
        }
        OrderModel orderModel = orderService.createOrder(userModel.getId(), itemId, promoId, amount);

        return CommonReturnType.create(null);
    }
}
