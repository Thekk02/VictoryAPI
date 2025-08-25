package com.Victory.VictoryApplicationAPI.controller.SystemUtils;

import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * @author kk
 * @description 伊梦飞pdf添加水印控制层
 * @date 2024-9-2 10:13:31
 */
@Api(tags = "车间扫码")
@RestController
@RequestMapping("/PDFAddWaterMask")
public class PDFAddWaterMaskController {


    @ApiOperation("pdf添加水印接口，暂未实现")
    @GetMapping("/addwatermask")
    public Result<List<File>> addwatermask(File xlsx,File pdf){
        return null;
    }
}
