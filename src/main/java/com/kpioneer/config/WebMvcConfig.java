package com.kpioneer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author xionghu
 * @date 2020/3/22 10:43
 * @desc
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        System.out.println("我是MyWebConfig跨域");
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")// 设置跨域访问的域名，如果是*，默认都可以访问。
                // 是否允许证书 不再默认开启
                .allowCredentials(true)// 设置是否允许客户端发送cookie信息。默认是false
                // 设置允许的方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                // 跨域允许时间
                .maxAge(3600);
    }


}
