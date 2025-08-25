package com.Victory.VictoryApplicationAPI.service.Imp.system;

import com.Victory.VictoryApplicationAPI.entity.system.User;
import com.Victory.VictoryApplicationAPI.mapper.system.UserMapper;
import com.Victory.VictoryApplicationAPI.service.system.UserService;
import com.Victory.VictoryApplicationAPI.utils.JwtUtil;
import com.Victory.VictoryApplicationAPI.utils.RedisUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;

/**
 * @author kk
 * @description 用户服务实现层
 * @date 2025-07-03 14:50:57
 */
@Service
@DS("db1")
public class UserServiceImp extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByLoginDto(String name, String pwd) {
        return userMapper.selectOne(
                Wrappers.<User>lambdaQuery()
                        .eq(User::getName,name)
                        .eq(User::getPwd,pwd)
            );
    }

    @Override
    public String UserLogin(String name, String pwd) {
        User user = this.getUserByLoginDto(name,pwd);
        if(user == null){
            return "用户名或密码错误";
        }
        String token = JwtUtil.getToken(user.getName());
        if(redisUtil.set(user.getName(),token,900)){
            return token;
        }else{
            return "缓存错误";
        }
    }


}
