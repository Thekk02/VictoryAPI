package com.Victory.VictoryApplicationAPI.service.vo;

import com.Victory.VictoryApplicationAPI.vo.ArticleToSpecification;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description PLM查图通过图号在U9里面查询对应规格名Service层
 * @date 2025-06-24 13:44:48
 */
public interface ArticleToSpecificationService extends IService<ArticleToSpecification> {
    //根据品名查询规格
    List<String> getSpecification(String Article);

    //根据规格查询客户代码
    String getCustomerCodeBySpecification(String Specification);
}
