package com.Victory.VictoryApplicationAPI.service.Imp.vo;

import com.Victory.VictoryApplicationAPI.mapper.vomapper.OrderToCodeMapper;
import com.Victory.VictoryApplicationAPI.service.vo.OrderToCodeService;
import com.Victory.VictoryApplicationAPI.vo.OrderToCode;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kk
 * @description plm看图通过卡号和图号获取规格实体服务实现层
 * @date 2025-06-20 09:12:07
 */
@Service
@DS("db3")
public class OrderToCodeServiceImp extends ServiceImpl<OrderToCodeMapper,OrderToCode> implements OrderToCodeService {


    @Autowired
    private OrderToCodeMapper orderToCodeMapper;




    //根据卡号获取规格
    @Override
    public String getSpecification(String cardNumber) {
        QueryWrapper queryWrapper = new QueryWrapper();
        log.warn(cardNumber);
        queryWrapper.eq("卡号",cardNumber);
        log.warn(queryWrapper.getSqlSegment());
        log.warn(queryWrapper.getSqlSelect());
        //log.warn(orderToCodeMapper.selectOne(queryWrapper).getSpecification());
        return ((OrderToCode)orderToCodeMapper.selectList(queryWrapper).get(0)).getSpecification();
    }
    @Override
    public List<String> getSpecificationList(String FigureNumber){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("图号",FigureNumber);
        List<OrderToCode> list = orderToCodeMapper.selectList(queryWrapper);
        List<String> specificationList = new ArrayList<>();
        for(OrderToCode orderToCode : list){
            specificationList.add(orderToCode.getSpecification().substring(0,15));
        }
        return specificationList;
    }
}
