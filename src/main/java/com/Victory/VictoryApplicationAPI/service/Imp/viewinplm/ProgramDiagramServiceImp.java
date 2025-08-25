package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.ProgramDiagram;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.ProgramDiagramMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.ProgramDiagramService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 编程用图服务实现层
 * @date 2024-8-29 15:38:27
 */
@Service
@DS("db2")
public class ProgramDiagramServiceImp extends ServiceImpl<ProgramDiagramMapper, ProgramDiagram> implements ProgramDiagramService {

    @Autowired
    private ProgramDiagramMapper programDiagramMapper;

    @Override
    public List<ProgramDiagram> getListByName(String name) {
        QueryWrapper<ProgramDiagram> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("标题",name);
        log.warn("编程用图查询");
        return programDiagramMapper.selectList(queryWrapper);
    }
}
