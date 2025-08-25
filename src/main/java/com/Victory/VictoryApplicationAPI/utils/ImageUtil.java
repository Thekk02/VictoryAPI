package com.Victory.VictoryApplicationAPI.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @author kk
 * @description image工具类
 * @date 2024-9-11 16:25:50
 */
public class ImageUtil {

    /**
    * @Description:生成背景那个透明的文字水印图片，文字位于中央，且倾斜
    * @Params: 水印文字
    * @Return: 文字水印透明图片
    */
    public static BufferedImage createWaterMark(String content){
        //图片宽和高
        int width = 250;
        int height = 160;
        //获取buffereredImage对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔对象
        Graphics2D g2d = image.createGraphics();
        //背景设置透明
        image = g2d.getDeviceConfiguration().createCompatibleImage(width,height,Transparency.TRANSLUCENT);
        g2d.dispose();
        g2d = image.createGraphics();
        //设置对线段的锯齿状边缘处理
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        //设置水印旋转，倾斜度
        g2d.rotate(-0.5,(double)image.getWidth()/2,(double) image.getHeight()/2);
        //设置颜色，此处为黑色，最后一个参数为透明度
        g2d.setColor(new Color(0,0,0,20));
        //设置字体
        Font font = new Font("宋体",Font.ROMAN_BASELINE,22);
        g2d.setFont(font);
        float fontSize = font.getSize();
        //计算绘图偏移x,y,使得水印文字在图片中居中
        float x = 0.5f * fontSize;
        float y = 0.5f * height + x;
        //取绘制的字串宽度，高度中间点进行偏移，使得文字在图片坐标中居中
        g2d.drawString(content,x,y);
        //释放资源
        g2d.dispose();
        return image;





    }
}
