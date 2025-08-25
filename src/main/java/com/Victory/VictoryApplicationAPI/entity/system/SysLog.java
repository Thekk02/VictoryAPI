package com.Victory.VictoryApplicationAPI.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author kk
 * @description 系统日志类
 * @date 2025-07-01 15:05:27
 */
@Data
@TableName("SysLog")
@ApiModel("系统日志")
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("id")
    private int id;

    @TableField("title")
    private String title;

    @TableField("content")
    private String content;

    @TableField("log_time")
    private Timestamp logTime;

    @TableField("request_ip")
    private String requestIp;

    @TableField("request_parameters")
    private String requestParamenters;

    @TableField("business_controller")
    private String businessController;


}
