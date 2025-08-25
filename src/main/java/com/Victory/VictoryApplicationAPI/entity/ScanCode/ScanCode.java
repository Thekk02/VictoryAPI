package com.Victory.VictoryApplicationAPI.entity.ScanCode;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

/**
 * @author kk
 * @description 扫码实体类
 * @date 2024-10-14 13:42:11
 */
@Data
@TableName("CodeScan")
@ApiModel("扫码实体类")
public class ScanCode {

    @TableField("scancode")
    public String ScanCode;
    @TableField("ScanDate")
    public Date ScanDate;
}
