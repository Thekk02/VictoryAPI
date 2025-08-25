package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 编程用图实体类
 * @date 2024-8-28 10:36:27
 */
@Data
@TableName("\"ProgramDiagram\"")
@ApiModel("编程用途视图")
public class ProgramDiagram implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "标题")
    private String title;

    @TableField(value = "文件类型")
    private String type;

    @TableField(value = "是否下发生产")
    private String product;

    private String location;
}
