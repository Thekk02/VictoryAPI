package com.Victory.VictoryApplicationAPI.controller.ScanCode;

import com.Victory.VictoryApplicationAPI.entity.ScanCode.ScanCode;
import com.Victory.VictoryApplicationAPI.service.Imp.scancode.ScanCodeServiceImp;
import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kk
 * @description 扫码控制层
 * @date 2024-10-14 13:51:39
 */
@Api(tags = "车间扫码")
@RestController
@RequestMapping("/scancode")
public class ScanCodeController {

    @Autowired
    private ScanCodeServiceImp scanCodeServiceImp;



    @ApiOperation("扫码插入信息")
    @PostMapping("/insert")
    @ResponseBody
    public Result<Object> InsertRecording(@RequestBody ScanCode scanCode){
        System.out.println(scanCode.getScanCode());
        System.out.println(scanCode.getScanDate());
        if(scanCodeServiceImp.InsertRecording(scanCode)){
            return Result.ok();
        }
        else{
            return Result.fail();
        }
    }

}
