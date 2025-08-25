package com.Victory.VictoryApplicationAPI.scheduletask;

import com.Victory.VictoryApplicationAPI.utils.RSAUtil;
import com.Victory.VictoryApplicationAPI.utils.RedisUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author kk
 * @description 定期生成公私密钥工具类
 * @date 2025-07-04 09:38:24
 */
@Component
public class KeyTask {

    private static RedisUtil redisUtil = new RedisUtil();

    //表示每六个小时更新一次公私钥
    @Scheduled(fixedRate = 6 * 60 *  60 * 1000)
    public void SetKey() throws Exception{
        RSAUtil rsaUtil = new RSAUtil();
        redisUtil.set("publickey",rsaUtil.getPublicKey());
        redisUtil.set("privatekey",rsaUtil.getPrivateKey());
    }

    //生成令牌认证公钥
    @Scheduled(cron = "0 0 0 * * ?")
    public  void SetAuthKey(){
        redisUtil.set("authkey", UUID.randomUUID().toString());
    }

}
