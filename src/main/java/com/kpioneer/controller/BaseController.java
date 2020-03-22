package com.kpioneer.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * @author xionghu
 * @date 2020/3/18 14:06
 * @desc
 */
public class BaseController {
    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    /**
     * 因为服务端返回给客户端的set-cookie中带有samesite=lax，
     * 这就是问题的根源，它表示不能携带cookie进行跨域post访问，
     *    然而我们是需要携带cookie的
     *
     * @return
     */
    @Bean
    public CookieSerializer httpSessionIdResolver() {
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();

        cookieSerializer.setCookieName("SESSION");

        cookieSerializer.setUseHttpOnlyCookie(false);

        cookieSerializer.setSameSite(null);

        return cookieSerializer;
    }
//
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Object handlerException(HttpServletRequest httpServletRequest, Exception ex) {
//        CommonReturnType commonReturnType = new CommonReturnType();
//        Map<String, Object> responseData = new HashMap<>();
//        if (ex instanceof BusinessException) {
//            BusinessException businessException = (BusinessException) ex;
//            commonReturnType.setStatus("fail");
//            responseData.put("errCode", businessException.getErrCode());
//            responseData.put("errMsg", businessException.getErrMsg());
//        } else {
//            responseData.put("errCode", EmBusinessError.UNKNOWN_ERROR.getErrCode());
//            responseData.put("errMsg", EmBusinessError.UNKNOWN_ERROR.getErrMsg());
//        }
//        return CommonReturnType.create(responseData, "fail");
//    }

}
