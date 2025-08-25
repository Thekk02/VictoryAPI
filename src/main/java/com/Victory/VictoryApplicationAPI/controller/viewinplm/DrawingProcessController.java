package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.DrawingProcess;
import com.Victory.VictoryApplicationAPI.service.viewinplm.DrawingProcessService;
import com.Victory.VictoryApplicationAPI.service.vo.ArticleToSpecificationService;
import com.Victory.VictoryApplicationAPI.service.vo.OrderToCodeService;
import com.Victory.VictoryApplicationAPI.utils.FileUtil;
import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kk
 * @description 图纸工艺控制层
 * @date 2024-8-28 16:28:45
 */
@Slf4j
@Api(tags = "图纸工艺")
@RestController
@RequestMapping("/DrawingProcess")
public class DrawingProcessController {

    @Autowired
    private DrawingProcessService drawingProcessService;


    @Autowired
    private OrderToCodeService orderToCodeService;

    @Autowired
    private ArticleToSpecificationService articleToSpecificationService;



    @ApiOperation("输入名称获取图纸工艺列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "输入名称获取图纸工艺列表")
    @ResponseBody
    public Result<List<DrawingProcess>> GetListByname( String name){
        return Result.ok(drawingProcessService.getListByName(name));
    }

    @ApiOperation("通过卡号获取图纸工艺列表")
    @GetMapping("/getlistbycardnumber")
    @MyLog(title = "plm看图模块",content = "通过卡号获取图纸工艺列表")
    @ResponseBody
    public Result<List<DrawingProcess>> GetListBycardNumber(String cardnumber){
        return Result.ok(drawingProcessService.getListByName(orderToCodeService.getSpecification(cardnumber).substring(0,15)));
    }

    @ApiOperation("通过图号获取图纸工艺列表")
    @GetMapping("/getlistbyfigurenumber")
    @MyLog(title = "plm看图模块",content = "通过图号获取图纸工艺列表")
    @ResponseBody
    public Result<List<DrawingProcess>> GetListfigurenumber(String figurenumber){

        List<String> specficationsTemp = articleToSpecificationService.getSpecification(figurenumber);
        List<String> specfications = new ArrayList<>(specficationsTemp.size());
        for(String str : specficationsTemp){
            if(str.length() >= 15){
                specfications.add(str.substring(0,15));
            }else{
                specfications.add(str);
            }
        }

        for(String str : specfications){
            System.out.println(str);
        }

        return Result.ok(drawingProcessService.getlistBynameList(specfications));
    }

    @ApiOperation("根据共享文件夹远程地址获取图纸工艺文件")
    @GetMapping("/getbyname")
    @MyLog(title = "plm看图模块",content = "根据共享文件夹远程地址获取图纸工艺文件")
    public void getDrawingProcessByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
