package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.WorkInstruction;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.WorkInstructionMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.WorkInstructionService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 作业指导书服务实现层
 * @date 2024-8-29 15:40:00
 */
@Service
@DS("db2")
public class WorkInstructionServiceImp extends ServiceImpl<WorkInstructionMapper, WorkInstruction> implements WorkInstructionService {

    @Autowired
    private WorkInstructionMapper workInstructionMapper;

    //根据plm里面的代号查找作业指导书
    @Override
    public List<WorkInstruction> getListByName(String name) {
        QueryWrapper<WorkInstruction> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("代号",name);

        return workInstructionMapper.selectList(queryWrapper);
    }

    //根据标题获取作业指导书列表
    @Override
    public List<WorkInstruction> getListByTitle(String[] titles) {
        QueryWrapper<WorkInstruction> queryWrapper = new QueryWrapper<>();
        for(String title : titles){
            System.out.println(title);
            queryWrapper.like("名称",title);
        }
        System.out.println(queryWrapper.getSqlSegment());
        return workInstructionMapper.selectList(queryWrapper);
    }




    //根据标题获取标签作业指导书列表
    @Override
    public List<WorkInstruction> getLabelListByTitles(String[] titles) {
        QueryWrapper<WorkInstruction> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("名称","标签");
        for(String title : titles){
            queryWrapper.like("名称",title);
        }
        return workInstructionMapper.selectList(queryWrapper);
    }

    //获取标准的内贸标签作业指导书
    public List<WorkInstruction> getDomesticLabel(){
        return getListByName("B-Z-ME-E89");
    }



    //获取标准的外贸标签作业指导书
    public List<WorkInstruction> getForeigntradeLabel() {
        return getListByName("B-Z-ME-E90");
    }
}
