package com.Victory.VictoryApplicationAPI.controller;

import com.Victory.VictoryApplicationAPI.service.vo.MesReportDataService;
import com.Victory.VictoryApplicationAPI.utils.Result;
import com.Victory.VictoryApplicationAPI.vo.MesReportData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author kk
 * @description 报表联合控制层
 * @date 2024-9-10 10:16:04
 */
@Api(tags = "客户mes报表")
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private MesReportDataService mesReportDataService;


    @ApiOperation("根据名称获取mes报表列表")
    @GetMapping("/mesreportforclient")
    @ResponseBody
    public Result<List<MesReportData>> getReport(String name, String starttime, String endtime) throws Exception{

        List<MesReportData> result = mesReportDataService.getReport(name,starttime,endtime);

        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if(result.size() == 0){
            return Result.fail(result);
        }else{
            List<MesReportData> temp =  mesReportDataService.getReport(name,starttime,endtime);
            System.out.println(temp.toString());
            List<MesReportData> results = new ArrayList<MesReportData>();
            HashMap<String,String> orders = new HashMap<>();
            for(MesReportData mesReportData : temp){
                //通过哈希表判断结果里是否已经含有这个订单
                //没有则将这条数据加入到哈希图中
                if(!(orders.containsKey(mesReportData.getProductordernumber())) || orders.size() == 0){
                    orders.put(mesReportData.getProductordernumber(),mesReportData.getProductorderlinenumber());
                    results.add(mesReportData);
                }else{
                    for(MesReportData data : results){
                        if(data.getProductordernumber().equals(mesReportData.getProductordernumber()) && data.getProductorderlinenumber().equals(mesReportData.getProductorderlinenumber())){
                            //data.setCompletime(( formatter.format(data.getCompletime()) > formatter.format(mesReportData.getCompletime()) ? data.getCompletime() : mesReportData.getCompletime()) );
                            //Date datadate = formatter.parse(data.getCompletime());
                            //Date mesreportdatadate = formatter.parse(mesReportData.getCompletime());
                            //data.setCompletime(formatter.format(data.getCompletime()).compareTo());
                            //比较完工时间，将比较靠后的时间赋值给数据
                            data.setCompletime(formatter.parse(data.getCompletime()).compareTo(formatter.parse(mesReportData.getCompletime())) >= 0 ? data.getCompletime() : mesReportData.getCompletime());
                            //工段数量相加获得新数量
                            String newquantity = String.valueOf(Double.parseDouble(data.getQuantity()) + Double.parseDouble(mesReportData.getQuantity()));
                            data.setQuantity(newquantity);
                        }
                    }
                }
            }

            //计算合并后的合格率并重新赋值
            DecimalFormat df = new DecimalFormat("0%");
            for(MesReportData data :results){
                data.setRate(df.format((Double.parseDouble(data.getQuantity()))/(Double.parseDouble(data.getProductworkordernumber()))));
            }


            return Result.ok(results);}

    }
}
