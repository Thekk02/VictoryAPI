package com.Victory.VictoryApplicationAPI.service;

import com.Victory.VictoryApplicationAPI.entity.application.Application;
import com.alibaba.fastjson.support.odps.udf.CodecCheck;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 应用服务层
 * @date 2024-9-2 10:06:22
 */
public interface ApplicationService extends IService<Application> {
    List<Application> getApplicationInfo(String name,String version);

    List<Application> getLatestApplication(String name);
}
