package com.Victory.VictoryApplicationAPI.controller.Wuxi;

import com.Victory.VictoryApplicationAPI.entity.Wuxi.SMGX;
import com.Victory.VictoryApplicationAPI.service.Wuxi.SMGXService;
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
 * @description 无锡扫码工序验证控制层
 * @date 2025-10-20 09:51:35
 */
@Api(tags = "无锡扫码验证工序")
@RestController
@RequestMapping("/smgx")
public class SMGXController {
    @Autowired
    private SMGXService smgxService;


    @ApiOperation("根据工单号获取扫码工序列表")
    @GetMapping("/getlistbyordernumber")
    @ResponseBody
    public Result<List<SMGX>> getListByOrderNumber(String ordernumber){
        System.out.println(ordernumber);
        return Result.ok(smgxService.getSMGX(ordernumber));
    }











}
