package com.Victory.VictoryApplicationAPI.entity.application;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("application")
@ApiModel("应用程序实体类")
public class Application {

  private Integer id;
  private String name;
  private Timestamp ctime;
  private String author;
  private String version;
  private String stat;
  private String location;
}
