package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.InspectionInstruction;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.InspectionInstructionMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.InspectionInstructionService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 检验指导书服务实现类
 * @date 2024-8-29 15:32:36
 */
@Service
@DS("db2")
public class InspectionInstructionServiceImp extends ServiceImpl<InspectionInstructionMapper, InspectionInstruction> implements InspectionInstructionService {

    @Autowired
    private InspectionInstructionMapper inspectionInstructionMapper;

    @Override
    public List<InspectionInstruction> getListByName(String name) {
        QueryWrapper<InspectionInstruction> queryWrapper  = new QueryWrapper<>();
        queryWrapper.like("名称",name);
        //log.warn("检验指导书查询");
        return inspectionInstructionMapper.selectList(queryWrapper);
    }

    @Override
    public List<InspectionInstruction> getListBycode(String code) {
        QueryWrapper<InspectionInstruction> queryWrapper  = new QueryWrapper<>();
        queryWrapper.like("代号",code);
        //log.warn("检验指导书查询");
        return inspectionInstructionMapper.selectList(queryWrapper);
    }
}
