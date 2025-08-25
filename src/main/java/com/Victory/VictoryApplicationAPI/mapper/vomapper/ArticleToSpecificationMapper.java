package com.Victory.VictoryApplicationAPI.mapper.vomapper;

import com.Victory.VictoryApplicationAPI.vo.ArticleToSpecification;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kk
 * @description PLM查图通过图号在U9里面查询对应规格名mapper层
 * @date 2025-06-24 13:43:32
 */
@Mapper
public interface ArticleToSpecificationMapper extends BaseMapper<ArticleToSpecification> {
}
