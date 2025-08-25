package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 检验指导书实体类
 * @date 2024-8-28 10:31:22
 */
@Data
@TableName("\"InspectionInstruction\"")
@ApiModel("检验指导书视图")
public class InspectionInstruction implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "代号")
    private String code;

    @TableField(value = "名称")
    private String name;

    private String plocation;
}
