package com.Victory.VictoryApplicationAPI.entity.viewinplm;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kk
 * @description 客户原图
 * @date 2024-8-28 10:26:10
 */
@Data
@TableName("\"CustomerOriginalPicture\"")
@ApiModel("客户原图视图")
public class CustomerOriginalPicture implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableField(value = "名字")
    private String name;

    @TableField(value = "文件类型")
    private String type;


    private String location;
}
