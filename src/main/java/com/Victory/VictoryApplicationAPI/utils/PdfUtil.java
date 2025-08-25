package com.Victory.VictoryApplicationAPI.utils;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * @author kk
 * @description pdf工具类
 * @date 2024-9-11 14:35:21
 */
public class PdfUtil {



    public static void addWaterMark(String inputFile,String outputFile,String watermark){
        PdfReader reader = null;
        PdfStamper stamper = null;
        try{
            reader = new PdfReader(inputFile);

        }catch(Exception e){

        }

    }
}
