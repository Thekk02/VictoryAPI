package com.Victory.VictoryApplicationAPI.service.Imp.scancode;

import com.Victory.VictoryApplicationAPI.entity.ScanCode.ScanCode;
import com.Victory.VictoryApplicationAPI.mapper.ScanCode.ScanCodeMapper;
import com.Victory.VictoryApplicationAPI.service.scancode.ScanCodeService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kk
 * @description 扫码服务实现层
 * @date 2024-10-14 13:45:54
 */
@Service
@DS("db3")
public class ScanCodeServiceImp extends ServiceImpl<ScanCodeMapper, ScanCode> implements ScanCodeService {
    @Autowired
    private ScanCodeMapper scanCodeMapper;


    public boolean InsertRecording(ScanCode scanCode){
        if(this.exist(scanCode)){
            return false;
        }else{
            scanCodeMapper.insert(scanCode);
            return true;
        }
    }

    @Override
    public boolean exist(ScanCode scanCode) {
        QueryWrapper<ScanCode> wrapper = new QueryWrapper<>();
        wrapper.eq("scancode",scanCode.getScanCode());
        return scanCodeMapper.selectOne(wrapper) != null;
    }
}










