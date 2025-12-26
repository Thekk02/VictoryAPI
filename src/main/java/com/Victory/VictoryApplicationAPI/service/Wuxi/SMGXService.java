package com.Victory.VictoryApplicationAPI.service.Wuxi;

import com.Victory.VictoryApplicationAPI.entity.Wuxi.SMGX;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 无锡扫码验证工序service层
 * @date 2025-10-20 09:40:58
 */
public interface SMGXService extends IService<SMGX> {
    List<SMGX> getSMGX(String orderNumber);
}
