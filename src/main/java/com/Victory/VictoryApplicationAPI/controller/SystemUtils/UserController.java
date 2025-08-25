package com.Victory.VictoryApplicationAPI.controller.SystemUtils;

import com.Victory.VictoryApplicationAPI.dto.LoginDto;
import com.Victory.VictoryApplicationAPI.service.system.UserService;
import com.Victory.VictoryApplicationAPI.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kk
 * @description 用户控制层
 * @date 2025-07-04 11:03:01
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDto loginDto){
        return Result.ok(userService.UserLogin(loginDto.getUname(),loginDto.getPwd()));
    }

    @GetMapping("/test")
    @ResponseBody
    public Result<String> test(String test){
        log.warn("测试成功");
        return Result.ok("Hello");
    }
}
