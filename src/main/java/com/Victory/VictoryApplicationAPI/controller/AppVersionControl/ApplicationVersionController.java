package com.Victory.VictoryApplicationAPI.controller.AppVersionControl;

import com.Victory.VictoryApplicationAPI.entity.application.Application;
import com.Victory.VictoryApplicationAPI.service.ApplicationService;
import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author kk
 * @description 应用版本控制层
 * @date 2024-9-3 08:15:14
 */

@Api(tags = "用户")
@RestController
@RequestMapping("/Application")
public class ApplicationVersionController {
    @Autowired
    private ApplicationService applicationService;

    @ApiOperation("获取应用版本信息")
    @GetMapping("/getapplicationinfo")
    @ResponseBody
    public Result<Object> getApplicationInfo(String name,String version) throws IOException {
        List<Application> apps =  applicationService.getApplicationInfo(name,version);
        if(apps.size() == 0){
            return Result.fail().setCode(500).setShowmsg(true).setMsg("未找到此应用，请联系管理员");
        }else if(!(apps.get(0).getStat().equals("1"))){
            return Result.ok().setMsg("此应用已经升级，请安装最新版！").setShowmsg(true).setCode(499);
        }
        return Result.ok();
    }

    @ApiOperation("获取最新版本应用")
    @GetMapping("/getlastestapplication")
    @ResponseBody
    public ResponseEntity<Resource> getLastestApplication(String name, HttpServletResponse response) throws IOException {
        List<Application> apps = applicationService.getLatestApplication(name);
        String path = this.getClass().getClassLoader().getResource("App/viewinplm/").getPath();
        String fullpath = path + "/plm看图 Setup 1.0.1.exe";
        System.out.println(fullpath);
        if(apps.size() != 0){
            String contentDisposition = ContentDisposition
                    .builder("attachment")
                    .filename("plm看图 Setup 1.0.1.exe")
                    .build().toString();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition)
                    .contentType(MediaType.parseMediaType("application/exe"))
                    .body(new FileSystemResource(fullpath));
        }else{
            return null;
        }

    }
}
