package com.Victory.VictoryApplicationAPI.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author kk
 * @description PLM查图通过图号在U9里面查询对应规格名
 * @date 2025-06-24 13:40:20
 */
@Data
@TableName("v_wp_inv201")
public class ArticleToSpecification {
    @TableField("品名")
    private  String Article;

    @TableField("规格")
    private  String Specification;

    @TableField("客户代码")
    private String CustomerCode;
}
