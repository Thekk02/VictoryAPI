package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.ProfileDraw;
import com.Victory.VictoryApplicationAPI.service.viewinplm.ProfileDrawService;
import com.Victory.VictoryApplicationAPI.utils.FileUtil;
import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kk
 * @description 型材图controller层
 * @date 2024-8-30 08:16:51
 */
@Api(tags = "型材图")
@RestController
@RequestMapping("/ProfileDraw")
public class ProfileDrawController {

    @Autowired
    private ProfileDrawService profileDrawService;


    @ApiOperation("根据名称获取型材图列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据名称获取型材图列表")
    @ResponseBody
    public Result<List<ProfileDraw>> getListByName(String name){
        return Result.ok(profileDrawService.getListByName(name));
    }

    @ApiOperation("根据共享文件夹远程地址获取型材图文件")
    @GetMapping("/getbyname")
    @MyLog(title = "plm看图模块",content = "根据共享文件夹远程地址获取型材图文件")
    public void getProfileDrawByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
