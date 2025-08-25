package com.Victory.VictoryApplicationAPI.utils;

import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.ToDoubleBiFunction;

/**
 * @author kk
 * @description jwt工具类
 * @date 2025-07-04 09:51:05
 */
@Slf4j
public class JwtUtil {
    //过期时间一小时
    private static final long EXPIRE_TIME =  60 * 60 * 1000;

    private static final String AUTH_KEY = "authkey";

    private static final RedisUtil redisUtil = new RedisUtil();


    //生成token
    public static String getToken(String name){
        try{
            //设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

            // 设置公钥加密算法
            Algorithm algorithm = Algorithm.HMAC256(AUTH_KEY);
            Map<String,Object> header = new HashMap<>(2);
            header.put("Type","jwt");
            header.put("alg","HS256");
            //返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("name",name)
                    .withExpiresAt(date)
                    .sign(algorithm);

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //验证token
    public static String verify(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(AUTH_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            log.warn("正在解析");
            return jwt.getClaim("name").toString();
        }catch (Exception e){
            return null;
        }
    }

}
