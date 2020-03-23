package com.kpioneer.service.cahce;

/**
 * @author xionghu
 * @date 2020/3/22 15:19
 * @desc
 */
public interface CacheService {
    //存方法
    void setCommonCache(String key,Object value);

    //取方法
    Object getFromCommonCache(String key);
}
