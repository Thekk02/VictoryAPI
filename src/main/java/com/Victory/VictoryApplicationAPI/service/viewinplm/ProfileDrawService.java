package com.Victory.VictoryApplicationAPI.service.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.ProfileDraw;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description 型材图服务层
 * @date 2024-8-29 15:24:56
 */
public interface ProfileDrawService extends IService<ProfileDraw> {
    List<ProfileDraw> getListByName(String name);
}
