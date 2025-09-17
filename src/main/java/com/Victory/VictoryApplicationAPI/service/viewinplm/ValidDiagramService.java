package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.ValidDiagram;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 本批有效图服务层
 * @date 2025-09-17 08:25:23
 */
public interface ValidDiagramService extends IService<ValidDiagram> {

    List<ValidDiagram> getListByname(String name);
}
