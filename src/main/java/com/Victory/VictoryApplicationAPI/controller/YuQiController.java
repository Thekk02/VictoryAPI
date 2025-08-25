package com.Victory.VictoryApplicationAPI.controller;

import com.Victory.VictoryApplicationAPI.utils.Result;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author kk
 * @description 玉祁应用控制
 * @date 2025/1/20 16:12:22
 */
@Api(tags="玉祁应用接口")
@RestController
@RequestMapping("/YuQi")
public class YuQiController {

    @Value("${yuqi.picturelocation}")
    private String FileLocation;

    @GetMapping("/getmoldpicture")
    @ResponseBody
    public ResponseEntity<Resource> getMoldPicture(@RequestParam("name")String name) throws IOException {
        String picturepath = FileLocation + name + ".jpg";
        System.out.println(picturepath);
        Resource resource = new FileSystemResource(picturepath);
        if(!resource.exists()){
            System.out.println("文件未找到");
            return ResponseEntity.notFound().build();

        }
        InputStream inputstream = resource.getInputStream();

        return ResponseEntity.ok()
                .contentLength(Files.size(Paths.get(picturepath)))
                .header("Content-Disposition","attachment; filename = 5010100001741-01.jpg")
                .header("Access-Control-Expose-Headers","Content-Disposition")
                .body(new InputStreamResource(inputstream));
        }


}
