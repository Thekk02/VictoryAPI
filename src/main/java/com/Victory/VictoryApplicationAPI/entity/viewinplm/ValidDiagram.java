package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description plm本批有效图视图
 * @date 2025-09-17 08:22:36
 */
@Data
@TableName("\"ValidDiagram\"")
@ApiModel("型材图视图")
public class ValidDiagram implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "名字")
    private String name;

    @TableField(value = "文件类型")
    private String type;


    private String location;
}
