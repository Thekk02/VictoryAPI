package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 作业指导书
 * @date 2024-8-28 10:51:20
 */
@Data
@TableName("\"WorkInstruction\"")
@ApiModel("作业指导书视图")
public class WorkInstruction implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "代号")
    private String code;

    @TableField(value = "名称")
    private String name;


    private String plocation;
}

