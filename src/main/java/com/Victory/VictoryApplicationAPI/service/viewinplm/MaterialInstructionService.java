package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.MaterialInstruction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 原材料标准服务层
 * @date 2024-8-29 15:23:50
 */
public interface MaterialInstructionService extends IService<MaterialInstruction> {
    List<MaterialInstruction> getListByName(String name);

    List<MaterialInstruction> getListByCode(String code);
}
