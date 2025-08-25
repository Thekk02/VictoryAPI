package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.CustomerOriginalPicture;
import com.Victory.VictoryApplicationAPI.service.viewinplm.CustomerOriginalPictureService;
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
 * @description 客户原图控制层
 * @date 2024-8-28 11:09:23
 */
@Api(tags = "客户原图")
@RestController
@RequestMapping("/CustomerOriginalPicture")

public class CustomerOriginalPictureController {

    @Autowired
    private CustomerOriginalPictureService customerOriginalPictureService;


    @ApiOperation("输入名称查询客户原图列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据客户原图名称查询客户原图")
    @ResponseBody
    public Result<List<CustomerOriginalPicture>> getbyName(String name){
        return Result.ok(customerOriginalPictureService.getListByname(name));
    }

    @ApiOperation("根据共享文件夹远程地址获取客户原图文件")
    @GetMapping("/getbyname")
    //@MyLog(title = "plm看图模块",content = "根据客户原图名称获取客户原图文件")
    public void getCustomeroriginalPictureByName(String remoteFilePath,HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }

}
