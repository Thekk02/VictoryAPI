package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.InspectionInstruction;
import com.Victory.VictoryApplicationAPI.service.viewinplm.InspectionInstructionService;
import com.Victory.VictoryApplicationAPI.utils.FileUtil;
import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kk
 * @description 检验指导书控制层
 * @date 2024-8-28 16:33:47
 */
@Api(tags = "检验指导书")
@RestController
@RequestMapping("/InspectionInstruction")
public class InspectionInstructionController {

    @Autowired
    private InspectionInstructionService inspectionInstructionService;


    @ApiOperation("根据名称(代号)获取检验指导书列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据名称获取检验指导书列表")
    @ResponseBody
    public Result<List<InspectionInstruction>> getListByname(String name){
        List<InspectionInstruction> ans = inspectionInstructionService.getListByName(name);
        ans.addAll(inspectionInstructionService.getListBycode(name));
        return Result.ok(ans);
    }

    @ApiOperation("根据共享文件夹远程地址获取检验指导书文件")
    @GetMapping("/getbyname")
    @MyLog(title = "plm看图模块",content = "根据共享文件夹远程地址获取检验指导书文件")
    public void getInspectionInstructionByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
