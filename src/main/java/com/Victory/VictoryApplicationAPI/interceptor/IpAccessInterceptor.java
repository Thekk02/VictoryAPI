package com.Victory.VictoryApplicationAPI.interceptor;

import com.Victory.VictoryApplicationAPI.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Set;

/**
 * @author kk
 * @description ip地址拦截器
 * @date 2025-07-02 13:44:20
 */
@Component
@Slf4j
public class IpAccessInterceptor implements HandlerInterceptor {

    @Value("${ip.blacklist}")
    private Set<String> blackIpList;

    @Value("${ip.whitelist}")
    private Set<String> whiteIpList;

    private final static String LOCAL = "127.0.0.1";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)throws Exception{
        log.info("拦截器启动");
        String ip = IpUtil.getIpAddress();
        //如果是本机ip直接放行
//        if(Objects.equals(ip,LOCAL)){
//            return true;
//        }
//        //获取黑白名单
//        if(blackIpList.contains(ip)){
//            log.info("ip:{}在黑名单中拒绝访问......",ip);
//            return false;
//        }
//        if(!whiteIpList.contains(ip)){
//            //不在白名单中，也拒绝访问
//            log.info("ip:{}不在白名单中拒绝访问......",ip);
//            return false;
//        }
        return true;
    }

}
