package com.Victory.VictoryApplicationAPI.entity.Wuxi;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 无锡扫码工序验证对照表
 * @date 2025-10-20 09:35:24
 */

@Data
@TableName("\"fk_wuxigxyz\"")
@ApiModel("无锡扫码验证工序表")
public class SMGX implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField(value = "生产任务单号")
    private String OrderNumber;


    @TableField(value = "工序行号")
    private String SequenceNumber;

    @TableField(value = "工序名称")
    private String ProcessName;
}
