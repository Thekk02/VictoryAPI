package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.CustomerOriginalPicture;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.ValidDiagram;
import com.Victory.VictoryApplicationAPI.service.viewinplm.ValidDiagramService;
import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author kk
 * @description 本批有效图控制层
 * @date 2025-09-17 08:30:24
 */
@Api(tags = "本批有效图")
@RestController
@RequestMapping("/ValidDiagram")
public class ValidDiagramController {
    @Autowired
    private ValidDiagramService validDiagramService;


    @ApiOperation("输入名称获取本批有效图列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据名称查询本批有效图")
    @ResponseBody
    public Result<List<ValidDiagram>> getbyName(String name){
        return Result.ok(validDiagramService.getListByname(name));
    }
}
