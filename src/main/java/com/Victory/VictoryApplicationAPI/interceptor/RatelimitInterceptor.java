package com.Victory.VictoryApplicationAPI.interceptor;

import com.Victory.VictoryApplicationAPI.utils.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.server.Http2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author kk
 * @description 限定一个ip一定时间内只能访问固定次数
 * @date 2025-07-02 15:00:34
 */
@Component
@Slf4j
public class RatelimitInterceptor implements HandlerInterceptor {
    private static final int MAX_REQUESTS = 10;
    private static final long TIME_PERIOD = 10 * 1000;

    private Map<String,Integer> requestCount = new HashMap<>();


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        String ipAddrress = IpUtil.getIpAddress();
        log.info("限制频繁访问拦截器启动");
        if(requestCount.containsKey(ipAddrress) && requestCount.get(ipAddrress) >= MAX_REQUESTS){
            response.setStatus(429);
            response.getWriter().write("Too many requests from this IP address");
            return false;
        }
        requestCount.put(ipAddrress,requestCount.getOrDefault(ipAddrress,0) + 1);
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        requestCount.remove(ipAddrress);
                    }
                },
                TIME_PERIOD
        );
        return true;
    }
}
