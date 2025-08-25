package com.Victory.VictoryApplicationAPI.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kk
 * @description excel工具类,负责读取excel数据
 * @date 2024-9-11 14:35:02
 */
public class ExcelUtil {

    /**
    * @Description: 读取excel表格数据
    * @Params: filepath:文件地址，sheetNo：sheet编号（从0开始），headRow：开始行（从0开始），tclass：数据实体类
    * @Return:
    */
    public static <T> List<T> readExcelToList(String filepath, int sheetNo, int headRow, Class<T> tclass){
        List<T> datalist = new ArrayList<>();
        EasyExcel.read(filepath, tclass, new AnalysisEventListener<T>() {
            @Override
            public void invoke(T data, AnalysisContext analysisContext) {
                datalist.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {

            }
        }).sheet(sheetNo).headRowNumber(headRow).doRead();
        return datalist;
    }

}
