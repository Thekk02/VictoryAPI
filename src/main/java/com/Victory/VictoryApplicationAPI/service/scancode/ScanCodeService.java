package com.Victory.VictoryApplicationAPI.service.scancode;

import com.Victory.VictoryApplicationAPI.entity.ScanCode.ScanCode;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author kk
 * @description 扫码服务层
 * @date 2024-10-14 13:45:28
 */
public interface ScanCodeService extends IService<ScanCode> {
    //判断数据库里是否已经有这条记录
    boolean exist(ScanCode scanCode);
}
