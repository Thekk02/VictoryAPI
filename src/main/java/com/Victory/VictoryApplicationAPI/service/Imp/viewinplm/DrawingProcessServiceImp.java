package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.DrawingProcess;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.DrawingProcessMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.DrawingProcessService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kk
 * @description 图纸工艺服务实现层
 * @date 2024-8-29 15:30:36
 */
@Service
@DS("db2")
public class DrawingProcessServiceImp extends ServiceImpl<DrawingProcessMapper, DrawingProcess> implements DrawingProcessService {

    @Autowired
    private DrawingProcessMapper drawingProcessMapper;

    @Override
    public List<DrawingProcess> getListByName(String name) {
        QueryWrapper<DrawingProcess> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("图纸工艺名称",name);
        log.warn("图纸工艺查询");
        return drawingProcessMapper.selectList(queryWrapper);
    }

    @Override
    public List<DrawingProcess> getlistBynameList(List<String> names) {
        List<DrawingProcess> drawingProcesses = new ArrayList<>();
        for(String name : names){
            System.out.println(name);
            QueryWrapper<DrawingProcess> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("图纸工艺名称",name);

            drawingProcesses.addAll(drawingProcessMapper.selectList(queryWrapper));
        }
        return drawingProcesses;
    }
}
