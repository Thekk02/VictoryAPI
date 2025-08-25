package com.Victory.VictoryApplicationAPI.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kk
 * @description 获取请求ip工具类
 * @date 2025-07-02 13:13:35
 */
public class IpUtil {
    private static final String UNKNOWN = "unknown";

    public static String getIpAddress(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = request.getHeader("x-forwardede-for");
        if(ip == null || UNKNOWN.equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || UNKNOWN.equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || UNKNOWN.equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        if(ip != null && ip.indexOf(",") > 0){
            ip = ip.substring(0,ip.indexOf(","));
        }
        return ip;
    }
}
