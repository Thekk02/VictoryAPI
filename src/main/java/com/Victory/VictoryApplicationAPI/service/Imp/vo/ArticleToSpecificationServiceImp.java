package com.Victory.VictoryApplicationAPI.service.Imp.vo;

import com.Victory.VictoryApplicationAPI.mapper.vomapper.ArticleToSpecificationMapper;
import com.Victory.VictoryApplicationAPI.service.vo.ArticleToSpecificationService;
import com.Victory.VictoryApplicationAPI.vo.ArticleToSpecification;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kk
 * @description PLM查图通过图号在U9里面查询对应规格名服务实现层
 * @date 2025-06-24 13:48:55
 */
@Service
@DS("db4")
public class ArticleToSpecificationServiceImp extends ServiceImpl<ArticleToSpecificationMapper, ArticleToSpecification>  implements ArticleToSpecificationService {
    @Autowired
    private ArticleToSpecificationMapper articleToSpecificationMapper;



    //根据品名获取规格
    @Override
    public List<String> getSpecification(String Article) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("品名",Article);
        List<ArticleToSpecification> articleToSpecifications = articleToSpecificationMapper.selectList(queryWrapper);
        List<String> specifications = new ArrayList<>();
        for(ArticleToSpecification articleToSpecification : articleToSpecifications){
            if(articleToSpecification.getSpecification().length() >= 15){
                System.out.println(articleToSpecification.getSpecification());
                specifications.add(articleToSpecification.getSpecification().substring(0,15));
            }else{
                specifications.add(articleToSpecification.getSpecification());
            }

        }
        log.warn(queryWrapper.getSqlSegment());
        return specifications;
    }

    //根据规格获取客户代码
    @Override
    public String getCustomerCodeBySpecification(String Specification) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("规格",Specification);
        ArticleToSpecification articleToSpecification = articleToSpecificationMapper.selectOne(queryWrapper);
        log.warn(queryWrapper.getSqlSegment());
        if(articleToSpecification != null){
            //log.warn(articleToSpecification.getCustomerCode());
            return articleToSpecification.getCustomerCode();
        }else{
            log.warn("weikong");
            return null;
        }

    }
}
