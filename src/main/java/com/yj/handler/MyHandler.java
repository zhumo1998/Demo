package com.yj.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
@Slf4j
@Component//扫描识别此类
public class MyHandler implements MetaObjectHandler {
    //执行插入时的更新策略
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("更新插入时间");
        //修改创建时间
        this.setFieldValByName("createTime",new Date(),metaObject);
//        修改修改时间
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    //执行修改时的更新策略
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新修改时间");
//        修改修改时间
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
}
