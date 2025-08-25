package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.WorkInstruction;
import com.Victory.VictoryApplicationAPI.service.viewinplm.WorkInstructionService;
import com.Victory.VictoryApplicationAPI.service.vo.ArticleToSpecificationService;
import com.Victory.VictoryApplicationAPI.service.vo.OrderToCodeService;
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
 * @description 作业指导书控制层
 * @date 2024-8-30 08:18:22
 */
@Api(tags = "作业指导书")
@RestController
@RequestMapping("/WorkInstruction")
public class WorkInstructionController {

    @Autowired
    private WorkInstructionService workInstructionService;

    @Autowired
    private OrderToCodeService orderToCodeService;

    @Autowired
    private ArticleToSpecificationService articleToSpecificationService;



    @ApiOperation("根据名称获取作业指导书列表")
    @GetMapping("/getlistbyname")
    @MyLog(title = "plm看图模块",content = "根据名称获取作业指导书列表")
    public Result<List<WorkInstruction>> getListByName(String name){

        return Result.ok(workInstructionService.getListByTitle(name.split(" ")));
    }

    @ApiOperation("扫工单号获取标签作业指导书")
    @GetMapping("/getlabellistbycardnumber")
    @MyLog(title = "plm看图模块",content = "扫码获取作业指导书列表")
    public Result<List<WorkInstruction>> getLabelListByCardNumber(String cardnumber){
        //根据工单号获取规格
        String Specification = orderToCodeService.getSpecification(cardnumber);

        //根据规格获取客户代码
        String CustomerCode = articleToSpecificationService.getCustomerCodeBySpecification(Specification);

        //根据客户代码获取对应的标签作业指导书

        List<WorkInstruction> ans = workInstructionService.getLabelListByTitles(new String[]{CustomerCode});
        if(ans.isEmpty()){
            if(CustomerCode.startsWith("VC33")){
                return Result.ok(workInstructionService.getForeigntradeLabel());
            }else{
                return Result.ok(workInstructionService.getDomesticLabel());
            }
        }else{
            return Result.ok(ans);
        }

    }

    @ApiOperation("扫工单号获取所有作业指导书")
    @GetMapping("/getlistbycardnumber")
    @MyLog(title = "plm看图模块",content = "扫码获取作业指导书列表")
    public Result<List<WorkInstruction>> getListByCardNumber(String cardnumber){
        //根据工单号获取规格
        String Specification = orderToCodeService.getSpecification(cardnumber);

        //根据规格获取客户代码
        String CustomerCode = articleToSpecificationService.getCustomerCodeBySpecification(Specification);

        //根据客户代码获取作业指导书列表
        List<WorkInstruction> ans = workInstructionService.getListByTitle(new String[]{CustomerCode});
        return Result.ok(ans);
    }

    @ApiOperation("根据共享文件夹远程地址获取作业指导书文件")
    @GetMapping("/getbyname")
    @MyLog(title = "plm看图模块",content = "根据共享文件夹远程地址获取作业指导书文件")
    public void getWorkInstructionByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
