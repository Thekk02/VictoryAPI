package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.MaterialInstruction;
import com.Victory.VictoryApplicationAPI.service.viewinplm.MaterialInstructionService;
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
 * @description 原材料标准控制类
 * @date 2024-8-29 15:41:31
 */
@Api(tags = "原材料标准")
@RestController
@RequestMapping("/MaterialInstruction")
public class MaterialInstructionController {

    @Autowired
    private MaterialInstructionService materialInstructionService;



    @ApiOperation("根据名称(代号)获取原材料标准列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据名称获取原材料标准列表")
    @ResponseBody
    public Result<List<MaterialInstruction>> getListByname(String name){
        List<MaterialInstruction> ans = materialInstructionService.getListByName(name);
        ans.addAll(materialInstructionService.getListByCode(name));
        return Result.ok(ans);
    }

    @ApiOperation("根据共享文件夹远程地址获取原材料标准文件")
    @GetMapping("/getbyname")
    @MyLog(title = "plm看图模块",content = "根据共享文件夹远程地址获取原材料标准文件")
    public void getMaterialInstructionByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
