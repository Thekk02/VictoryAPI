package com.Victory.VictoryApplicationAPI.entity.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author kk
 * @description 用户实体类
 * @date 2025-07-03 14:40:40
 */
@Data
@TableName("User")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @TableField("id")
    private Integer id;

    @TableField("name")
    private String name;

    @TableField("pwd")
    private String pwd;

    @TableField("telephone_number")
    private String telephoneNumber;

    @TableField("role_id")
    private Integer roleId;

    @TableField("status")
    private Integer status;

    @TableField("creator")
    private String creator;

    @TableField("ctime")
    private Timestamp ctime;

    @TableField("remark")
    private String remark;


}
