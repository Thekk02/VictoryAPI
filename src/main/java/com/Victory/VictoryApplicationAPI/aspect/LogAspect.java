package com.Victory.VictoryApplicationAPI.aspect;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.system.SysLog;

import com.Victory.VictoryApplicationAPI.service.system.SysLogService;
import com.alibaba.fastjson.JSON;
import net.bytebuddy.asm.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.Timestamp;

/**
 * @author kk
 * @description 日志切面类
 * @date 2025-07-01 14:43:27
 */
@Aspect
@Component
public class LogAspect {
    @Autowired
    private SysLogService sysLogService;

    ThreadLocal<Long> startTime = new ThreadLocal<>();



    @Pointcut("@annotation(com.Victory.VictoryApplicationAPI.annotation.MyLog)")
    public void LogPointCut(){
    }

    @Before("LogPointCut()")
    public void beforePoinCut(JoinPoint pint){
        startTime.set(System.currentTimeMillis());
    }

    @Pointcut("execution(* com.Victory.VictoryApplicationAPI.controller..*.*(..))")
    public void ExceptionLogPointCut(){
    }

    @AfterReturning(value = "LogPointCut()",returning = "result")
    public void saveLog(JoinPoint joinPoint,Object result){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = (HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        try{
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Method method = signature.getMethod();
            MyLog myLog = method.getAnnotation(MyLog.class);
            SysLog sysLog = new SysLog();
            if(myLog != null){
                sysLog.setTitle(myLog.title());
                sysLog.setContent(myLog.content());
            }
            //将入参转换为json
            String params = argsArrayToString(joinPoint.getArgs());
            //获取请求的类名
            String classname = joinPoint.getTarget().getClass().getName();
            //获取请求的方法名
            String methodName = method.getName();
            methodName = classname + methodName;

            sysLog.setLogTime(new Timestamp(System.currentTimeMillis()));
            sysLog.setRequestIp(getIP(request));
            sysLog.setBusinessController(methodName);
            sysLog.setRequestParamenters(params);
            sysLogService.InsertLog(sysLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
    * @Description: 获取参数并拼接成字符串
    * @Params:
    * @Return:
    */
    private String argsArrayToString(Object[] paramsArray){
        String params = "";
        if(paramsArray != null && paramsArray.length > 0){
            for(Object o : paramsArray){
                if(o != null){
                    try{
                        Object jsonObj = JSON.toJSON(o);
                        params += jsonObj.toString() + " ";
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return params.trim();
    }



    /**
    * @Description: 获取请求的ip地址
    * @Params: HttpServletRequest request
    * @Return: String ip
    */
    public static String getIP(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client_IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip;
    }






}
