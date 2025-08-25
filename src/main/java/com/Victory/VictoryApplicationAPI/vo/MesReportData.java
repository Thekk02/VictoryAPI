package com.Victory.VictoryApplicationAPI.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description mes系统供客户查询仅是包装工序的数据——王海东用
 * @date 2024-9-10 09:55:45
 */
@Data
@TableName("MesReportData")
public class MesReportData implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField("完工时间")
    private String completime;

    @TableField("生产单号")
    private String productordernumber;

    @TableField("生产订单行号")
    private String productorderlinenumber;

    @TableField("存货编码")
    private String inventorycode;

    @TableField("存货名称")
    private String inventoryname;

    @TableField("生产任务单数量")
    private String productworkordernumber;

    @TableField("工段数量")
    private String quantity;

    @TableField("工序行号")
    private String operationlinenumber;

    @TableField("工序代号")
    private String operationcode;

    @TableField("工序名称")
    private String operationname;

    @TableField("状态")
    private String status;

    @TableField("合格率")
    private String rate;

}
