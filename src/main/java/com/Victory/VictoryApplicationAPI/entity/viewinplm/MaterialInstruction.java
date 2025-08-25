package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 原材料标准
 * @date 2024-8-28 10:33:08
 */
@Data
@TableName("\"MaterialInstruction\"")
@ApiModel("原材料标准视图")
public class MaterialInstruction implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "代号")
    private String code;

    @TableField(value = "名称")
    private String name;

    private String plocation;
}
