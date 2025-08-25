package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.WorkInstruction;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 作业指导书service层
 * @date 2024-8-29 15:26:11
 */
public interface WorkInstructionService extends IService<WorkInstruction> {
    //根据代号获取作业指导书列表
    List<WorkInstruction> getListByName(String name);

    //通过标题获取作业指导书列表
    List<WorkInstruction> getListByTitle(String[] titles);


    //通过标题获取标签作业指导书列表
    List<WorkInstruction> getLabelListByTitles(String[] titles);

    //获取通用的内贸标签指导书
    List<WorkInstruction> getDomesticLabel();

    //获取通用的外贸标签指导书
    List<WorkInstruction> getForeigntradeLabel();
}
