package com.Victory.VictoryApplicationAPI.service.viewinplm;


import com.Victory.VictoryApplicationAPI.entity.viewinplm.DrawingProcess;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 图纸工艺服务层
 * @date 2024-8-29 15:21:42
 */
public interface DrawingProcessService extends IService<DrawingProcess> {
    List<DrawingProcess> getListByName(String name);

    List<DrawingProcess> getlistBynameList(List<String> name);
}
