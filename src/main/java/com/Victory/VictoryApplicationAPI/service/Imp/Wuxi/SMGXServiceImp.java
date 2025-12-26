package com.Victory.VictoryApplicationAPI.service.Imp.Wuxi;

import com.Victory.VictoryApplicationAPI.entity.Wuxi.SMGX;
import com.Victory.VictoryApplicationAPI.entity.application.Application;
import com.Victory.VictoryApplicationAPI.mapper.ApplicationMapper;
import com.Victory.VictoryApplicationAPI.mapper.Wuxi.SMGXMapper;
import com.Victory.VictoryApplicationAPI.service.ApplicationService;
import com.Victory.VictoryApplicationAPI.service.Wuxi.SMGXService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 扫码工序服务实现层
 * @date 2025-10-20 09:42:26
 */
@Service
@DS("db5")
public class SMGXServiceImp extends ServiceImpl<SMGXMapper, SMGX> implements SMGXService {

    @Autowired
    private SMGXMapper smgxMapper;
    @Override
    public List<SMGX> getSMGX(String orderNumber) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("生产任务单号",orderNumber);
        queryWrapper.orderByAsc("工序行号");
        List<SMGX> smgxList = smgxMapper.selectList(queryWrapper);
        return smgxList;
    }
}
