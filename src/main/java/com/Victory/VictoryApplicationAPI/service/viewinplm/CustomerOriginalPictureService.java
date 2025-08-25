package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.CustomerOriginalPicture;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 客户原图service层
 * @date 2024-8-28 11:02:51
 */
public interface CustomerOriginalPictureService extends IService<CustomerOriginalPicture> {
    List<CustomerOriginalPicture> getListByname(String name);
}
