package com.Victory.VictoryApplicationAPI.service.vo;

import com.Victory.VictoryApplicationAPI.vo.OrderToCode;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author kk
 * @description plm看图通过卡号和图号获取规格实体服务层
 * @date 2025-06-20 09:10:39
 */
public interface OrderToCodeService extends IService<OrderToCode> {
    //通过卡号获得规格
    String getSpecification(String cardNumber);

    //通过图号获取对应规格列表
    List<String> getSpecificationList(String FigureNumber);

    //根据卡号，获取订单号-销售订单行号
    String getSOAndLineNumber(String cardNumber);

}
