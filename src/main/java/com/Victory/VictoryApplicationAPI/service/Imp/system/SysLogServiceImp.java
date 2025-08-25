package com.Victory.VictoryApplicationAPI.service.Imp.system;

import com.Victory.VictoryApplicationAPI.entity.system.SysLog;
import com.Victory.VictoryApplicationAPI.mapper.system.SysLogMapper;
import com.Victory.VictoryApplicationAPI.service.system.SysLogService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kk
 * @description 系统日志服务实现类
 * @date 2025-07-01 15:22:36
 */
@Service
@DS("db1")
public class SysLogServiceImp extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void InsertLog(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
