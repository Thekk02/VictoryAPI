package com.Victory.VictoryApplicationAPI.service.Imp.vo;

import com.Victory.VictoryApplicationAPI.mapper.vomapper.MesReportDataMapper;
import com.Victory.VictoryApplicationAPI.service.vo.MesReportDataService;
import com.Victory.VictoryApplicationAPI.vo.MesReportData;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description mes系统供客户查询工序是包装的服务实现层
 * @date 2024-9-10 10:07:31
 */
@Service
@DS("db3")
public class MesReportDataServiceImp extends ServiceImpl<MesReportDataMapper, MesReportData> implements MesReportDataService {

    @Autowired
    private MesReportDataMapper mesReportDataMapper;
    @Override
    public List<MesReportData> getReport(String name, String starttime, String endtime) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.like("存货名称",name);
        queryWrapper.gt("完工时间",starttime);
        queryWrapper.lt("完工时间",endtime);
        return  mesReportDataMapper.selectList(queryWrapper);
    }
}
