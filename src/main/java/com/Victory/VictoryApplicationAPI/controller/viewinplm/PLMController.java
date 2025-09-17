package com.Victory.VictoryApplicationAPI.controller.viewinplm;

import com.Victory.VictoryApplicationAPI.annotation.MyLog;
import com.Victory.VictoryApplicationAPI.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kk
 * @description plm总体控制类
 * @date 2025-09-16 15:36:04
 */
@Api(tags = "plm工具控制类")
@RestController
@RequestMapping("/PLM")
public class PLMController {
    @ApiOperation("根据plm文件地址获取文件流程")
    @GetMapping("/getbyname")
    @MyLog(title = "plm工具",content = "根据plm图纸地址获取文件流")
    @ResponseBody
    public void getFileByName(String remoteFilePath, HttpServletResponse res) throws IOException {
        FileUtil.downloadBySharedFolder(remoteFilePath,res);
    }
}
