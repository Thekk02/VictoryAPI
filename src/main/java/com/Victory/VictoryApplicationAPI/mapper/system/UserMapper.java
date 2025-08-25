package com.Victory.VictoryApplicationAPI.mapper.system;

import com.Victory.VictoryApplicationAPI.entity.system.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kk
 * @description 用户mapper层
 * @date 2025-07-03 14:47:36
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
