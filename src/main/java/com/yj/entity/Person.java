package com.yj.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    /*
    AUTO:主键自增
    NONE:未设置主键
    ID_WORKER:默认策略生成全局主键
    ID_WORKER_STR:ID_WORKER的字符串表达法
    INPUT:手动输入主键
    UUID:生成32位UUID
    */
    @TableId(type=IdType.AUTO)
    private Long id;
    private String name;
    private String telephone;
    private Integer age;
    private Integer sex;
    private String email;
    @Version //乐观锁注解
    private Integer version;
    @TableLogic//逻辑删除
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)//插入新数据时更新时间
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)//修改数据时更新时间
    private Date updateTime;
}
