package com.Victory.VictoryApplicationAPI.service.Imp.viewinplm;

import com.Victory.VictoryApplicationAPI.entity.viewinplm.ProfileDraw;
import com.Victory.VictoryApplicationAPI.mapper.viewinplm.ProfileDrawMapper;
import com.Victory.VictoryApplicationAPI.service.viewinplm.ProfileDrawService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description 型材图服务实现类
 * @date 2024-8-29 15:36:55
 */
@Service
@DS("db2")
public class ProfileDrawServiceImp extends ServiceImpl<ProfileDrawMapper, ProfileDraw> implements ProfileDrawService {

    @Autowired
    private ProfileDrawMapper profileDrawMapper;


    @Override
    public List<ProfileDraw> getListByName(String name) {
        QueryWrapper<ProfileDraw> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("标题",name);
        log.warn("型材图查询");
        return profileDrawMapper.selectList(queryWrapper);
    }
}
