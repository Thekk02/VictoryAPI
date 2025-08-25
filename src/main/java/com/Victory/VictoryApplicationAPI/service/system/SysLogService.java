package com.Victory.VictoryApplicationAPI.service.system;

import com.Victory.VictoryApplicationAPI.entity.system.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author kk
 * @description 系统日志服务层
 * @date 2025-07-01 15:18:19
 */
public interface SysLogService extends IService<SysLog> {
    void InsertLog(SysLog sysLog);
}
