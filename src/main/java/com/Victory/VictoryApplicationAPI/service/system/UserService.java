package com.Victory.VictoryApplicationAPI.service.system;

import com.Victory.VictoryApplicationAPI.entity.system.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author kk
 * @description 用户服务层
 * @date 2025-07-03 14:46:26
 */
public interface UserService extends IService<User> {
    User getUserByLoginDto(String name,String pwd);

    String UserLogin(String name,String pwd);
}
