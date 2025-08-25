package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.CustomerOriginalPicture;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.CustomerOriginalPictureMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.CustomerOriginalPictureService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author kk
 * @description 客户原图服务实现层
 * @date 2024-8-28 11:04:09
 */
@Service
@DS("db2")
public class CustomerOriginalPictureServiceImp extends ServiceImpl<CustomerOriginalPictureMapper,CustomerOriginalPicture> implements CustomerOriginalPictureService {

    @Autowired
    private CustomerOriginalPictureMapper customerOriginalPictureMapper;

    @Override
    public List<CustomerOriginalPicture> getListByname(String name) {
        QueryWrapper<CustomerOriginalPicture> queryWrapper = new QueryWrapper<>();
        log.warn(name);
        queryWrapper.like("名字",name);
        log.warn(queryWrapper.getSqlSegment());
        List<CustomerOriginalPicture> list = customerOriginalPictureMapper.selectList(queryWrapper);
        log.warn("客户原图查询");
        //log.warn(list.toString());
        log.warn(list.size() + "");
        return list;

    }
}
