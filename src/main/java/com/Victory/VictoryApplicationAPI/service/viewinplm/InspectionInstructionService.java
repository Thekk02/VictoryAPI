package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.InspectionInstruction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 检验指导书服务层
 * @date 2024-8-29 15:22:29
 */
public interface InspectionInstructionService extends IService<InspectionInstruction> {
    List<InspectionInstruction> getListByName(String name);

    List<InspectionInstruction> getListBycode(String code);
}
