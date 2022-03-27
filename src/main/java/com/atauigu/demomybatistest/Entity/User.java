package com.atauigu.demomybatistest.Entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Long id;
    private String Name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //乐观锁
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

    //逻辑删除
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted;

}
