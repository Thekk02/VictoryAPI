package com.Victory.VictoryApplicationAPI.service.Imp;

import com.Victory.VictoryApplicationAPI.entity.application.Application;
import com.Victory.VictoryApplicationAPI.mapper.ApplicationMapper;
import com.Victory.VictoryApplicationAPI.service.ApplicationService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 应用服务实现层
 * @date 2024-9-2 10:07:02
 */
@Service
@DS("db1")
public class ApplicationServiceImp extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;


    //获取应用版本信息
    @Override
    public List<Application> getApplicationInfo(String name, String version) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name",name);
        queryWrapper.eq("version",version);
        return applicationMapper.selectList(queryWrapper);
    }

    //获取最新版应用
    @Override
    public List<Application>getLatestApplication(String name) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("stat","1");
        queryWrapper.like("name",name);
        return applicationMapper.selectList(queryWrapper);
    }
}












