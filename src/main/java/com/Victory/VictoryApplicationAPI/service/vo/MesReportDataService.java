package com.Victory.VictoryApplicationAPI.service.vo;

import com.Victory.VictoryApplicationAPI.vo.MesReportData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description mes系统供客户查询仅是包装工序的数据service层
 * @date 2024-9-10 10:06:18
 */
public interface MesReportDataService extends IService<MesReportData> {
    List<MesReportData> getReport(String name, String starttime, String endtime);
}
