package com.Victory.VictoryApplicationAPI.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author kk
 * @description plm看图通过卡号和图号获取规格实体
 * @date 2025-06-20 09:04:32
 */
@Data
@TableName("Stocktaking")
public class OrderToCode {
    private static final long serialVersionUID = 1L;

    @TableField("卡号")
    private String CardNumber;

    @TableField("图号")
    private String FigureNUmber;

    @TableField("规格")
    private String Specification;

    @TableField("销售单号")
    private String SaleOrder;

    @TableField("销售订单行号")
    private String SOLineNumber;


}
