package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.CustomerOriginalPicture;
import com.Victory.VictoryApplicationAPI.entity.viewinplm.ValidDiagram;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.ValidDiagramMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.ValidDiagramService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 本批有效图服务实现层
 * @date 2025-09-17 08:26:19
 */
@Service
@DS("db2")
public class ValidDiagramServiceImp extends ServiceImpl<ValidDiagramMapper, ValidDiagram> implements ValidDiagramService {
    @Autowired
    private ValidDiagramMapper validDiagramMapper;

    @Override
    public List<ValidDiagram> getListByname(String name) {
        QueryWrapper<ValidDiagram> queryWrapper = new QueryWrapper<>();
        //log.warn(name);
        queryWrapper.like("名字",name);
        //log.warn(queryWrapper.getSqlSegment());
        List<ValidDiagram> list = validDiagramMapper.selectList(queryWrapper);
        log.warn("本批有效图查询");
        //log.warn(list.toString());
        //log.warn(list.size() + "");
        return list;
    }
}
