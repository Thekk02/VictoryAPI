package com.Victory.VictoryApplicationAPI.mapper;

import com.Victory.VictoryApplicationAPI.entity.application.Application;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kk
 * @description 应用mapper层
 * @date 2024-9-2 10:05:17
 */
@Mapper
public interface ApplicationMapper extends BaseMapper<Application> {
}
