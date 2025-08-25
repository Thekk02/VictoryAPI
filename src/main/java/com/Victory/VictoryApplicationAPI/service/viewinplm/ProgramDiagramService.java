package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.ProgramDiagram;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 编程用图服务层
 * @date 2024-8-29 15:25:34
 */
public interface ProgramDiagramService extends IService<ProgramDiagram> {
    List<ProgramDiagram> getListByName(String name);
}
