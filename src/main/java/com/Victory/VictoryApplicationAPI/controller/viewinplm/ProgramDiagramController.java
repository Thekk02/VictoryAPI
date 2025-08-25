package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.ProgramDiagram;
import com.Victory.VictoryApplicationAPI.service.viewinplm.ProgramDiagramService;
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
 * @description 编程用图controller层
 * @date 2024-8-30 08:17:35
 */
@Api(tags = "编程用图")
@RestController
@RequestMapping("/ProgramDiagram")
public class ProgramDiagramController {

    @Autowired
    private ProgramDiagramService programDiagramService;



    @ApiOperation("根据名称获取编程用图列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据名称获取变成用图列表")
    @ResponseBody
    public Result<List<ProgramDiagram>> getByListName(String name){
        return Result.ok(programDiagramService.getListByName(name));
    }

    @ApiOperation("根据共享文件夹远程地址获取编程用图文件")
    @GetMapping("/getbyname")
    @MyLog(title = "plm看图模块",content = "根据共享文件夹远程地址获取编程用图文件")
    public void getProgramDiagramByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
