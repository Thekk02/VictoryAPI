package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 图纸工艺
 * @date 2024-8-28 10:29:04
 */
@Data
@TableName("\"DrawingProcess\"")
@ApiModel("图纸工艺视图")
public class DrawingProcess implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "图纸工艺名称")
    private String name;

    @TableField(value = "类型")
    private String type;

    private String location;
}
