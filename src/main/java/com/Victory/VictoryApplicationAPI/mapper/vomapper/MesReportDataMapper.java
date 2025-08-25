package com.Victory.VictoryApplicationAPI.mapper.vomapper;

import com.Victory.VictoryApplicationAPI.vo.MesReportData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kk
 * @description mes系统用户查询仅是包装工序的数据mapper层
 * @date 2024-9-10 10:04:30
 */
@Mapper
public interface MesReportDataMapper extends BaseMapper<MesReportData> {

}
