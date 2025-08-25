package com.Victory.VictoryApplicationAPI.config;

import com.Victory.VictoryApplicationAPI.interceptor.IpAccessInterceptor;
import com.Victory.VictoryApplicationAPI.interceptor.RatelimitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @author kk
 * @description 拦截器配置以及注册
 * @date 2025-07-02 13:57:07
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private IpAccessInterceptor ipAccessInterceptor;

    @Autowired
    private RatelimitInterceptor ratelimitInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(ipAccessInterceptor).addPathPatterns("/**");
        registry.addInterceptor(ratelimitInterceptor).addPathPatterns("/**");
    }
}
