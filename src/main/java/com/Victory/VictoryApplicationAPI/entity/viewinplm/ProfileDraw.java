package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 型材图实体类
 * @date 2024-8-28 10:35:00
 */
@Data
@TableName("\"ProfileDraw\"")
@ApiModel("型材图视图")
public class ProfileDraw implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "标题")
    private String name;

    @TableField(value = "文件类型")
    private String type;

    private String location;
}
