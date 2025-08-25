package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.MaterialInstruction;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.MaterialInstructionMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.MaterialInstructionService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 原材料标准服务实现类
 * @date 2024-8-29 15:35:42
 */
@Service
@DS("db2")
public class MaterialInstructionServiceImp extends ServiceImpl<MaterialInstructionMapper, MaterialInstruction> implements MaterialInstructionService {
    @Autowired
    private MaterialInstructionMapper instructionMapper;


    @Override
    public List<MaterialInstruction> getListByName(String name) {
        QueryWrapper<MaterialInstruction> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("名称",name);
        //log.warn("原材料标准查询");
        return instructionMapper.selectList(queryWrapper);
    }

    @Override
    public List<MaterialInstruction> getListByCode(String code) {
        QueryWrapper<MaterialInstruction> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("代号",code);
        //log.warn("原材料标准查询");
        return instructionMapper.selectList(queryWrapper);
    }
}
