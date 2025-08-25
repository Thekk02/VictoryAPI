package com.Victory.VictoryApplicationAPI.filter;

import com.Victory.VictoryApplicationAPI.utils.JwtUtil;
import com.Victory.VictoryApplicationAPI.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kk
 * @description 令牌鉴别过滤器,暂时注释不适用
 * @date 2025-07-04 10:30:16
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    private static final Set<String> WHiTE = new HashSet<>();
    static {
        WHiTE.add("/user/login");
        WHiTE.add("user/register");
    }

    private RedisUtil redisUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        try{
            //如果路径在白名单中但中则直接放行
            String path = request.getServletPath();
            if(WHiTE.contains(path)){
                filterChain.doFilter(request,response);
                return;
            }

            //如果token为空，过滤
            String token = request.getHeader("Authorization");
            if(StringUtils.isEmpty(token) || "null".equals(token)){
                response.sendError(0,"token为空！");
                return;
            }

            log.warn(token);
            //获取前端传输的auth绑定的用户名和id
            String authnamme = JwtUtil.verify(token);

            log.warn(authnamme);


            //如果解析失败，过滤
            if(authnamme == null){
                response.sendError(2,"token解析失败");
                return;
            }

            log.warn(authnamme);

            //如果token不在redis缓存中，过滤
            if(redisUtil.get(authnamme) == null){
                response.sendError(1,"无有效登录信息");
                return;
            }

            //如果鉴权成功，更新token
            String newToken = JwtUtil.getToken(authnamme);
            if(!redisUtil.del(token)){
                response.sendError(3,"token更新失败");
                return;
            }
            //加入新的token
            if(!redisUtil.set(newToken,authnamme,900)){
                response.sendError(4,"token更新失败");
                return;
            }
            response.addHeader("Authorization",newToken);
            filterChain.doFilter(request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
